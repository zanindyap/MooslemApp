package com.example.mooslem

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mooslem.api.RetrofitHelper
import com.example.mooslem.api.TodoApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SecondActivity : AppCompatActivity() {


    lateinit var listTodo : ListView

    val apiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Inp1dmZ4b2hwanRkZGJ6anZsb2huIiwicm9sZSI6ImFub24iLCJpYXQiOjE2Njk5OTM5NDYsImV4cCI6MTk4NTU2OTk0Nn0.709e0TYLggcNhaUMp4S6zH9Fzv7EKvUm0bD3lwiIBkE"
    val token = "Bearer $apiKey"

    val Items = ArrayList<Model>()
    val todoApi = RetrofitHelper.getInstance().create(TodoApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        listTodo = findViewById(R.id.list_todo)



        CoroutineScope(Dispatchers.Main).launch {
            val response = todoApi.get(token=token, apiKey=apiKey)

            response.body()?.forEach {
                Items.add(
                    Model(
                        Id=it.id,
                        Title=it.title,
                        Description=it.description

                    )
                )
            }

            setList(Items)
        }

        listTodo.setOnItemClickListener { adapterView, view, position, id ->
            val item = adapterView.getItemAtPosition(position) as Model
            val title = item.Title


        }
    }

    fun setList(Items: ArrayList<Model>) {
        val adapter = TodoAdapter(this, R.layout.todo_item, Items)
        listTodo.adapter = adapter

        listTodo.setOnItemClickListener { adapterView, view, position, id ->
            //      val intent = Intent(this, DetailActivity::class.java)
            //    startActivity(intent)

            if (position == 0) {
                val intent = Intent(this, DetailActivity::class.java)
                startActivity(intent)
            }

            if (position == 1) {
                val intent = Intent(this, DetailDua::class.java)
                startActivity(intent)

            }

            if (position == 2) {
                val intent = Intent(this, DetailTiga::class.java)
                startActivity(intent)

            }
            if (position == 3) {
                val intent = Intent(this,DetailEmpat::class.java)
                startActivity(intent)

            }
            if (position == 4) {
                val intent = Intent(this,DetailLima::class.java)
                startActivity(intent)

            }
            if (position == 5) {
                val intent = Intent(this,DetailEnam::class.java)
                startActivity(intent)

            }
            if (position == 6) {
                val intent = Intent(this,DetailTujuh::class.java)
                startActivity(intent)

            }
            if (position == 7) {
                val intent = Intent(this,DetailDelapan::class.java)
                startActivity(intent)

            }
            if (position == 8) {
                val intent = Intent(this,DetailSembilan::class.java)
                startActivity(intent)

            }
            if (position == 9) {
                val intent = Intent(this,DetailSepuluh::class.java)
                startActivity(intent)

            }
        }
    }

}