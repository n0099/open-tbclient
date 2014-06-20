package com.baidu.android.systemmonitor.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class b extends c {
    public b(Context context) {
        super(context, "mystatus.db", null, 1);
    }

    @Override // com.baidu.android.systemmonitor.b.c
    public void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE astatus (_id INTEGER,pn TEXT primary key,lautimes INTEGER,totaltime LONG,lauper TEXT,laucur INTEGER,timeper TEXT,timecur LONG);");
        sQLiteDatabase.execSQL("CREATE TABLE atrace (_id INTEGER,pn TEXT NOT NULL,startstamp LONG,stopstamp LONG,loc TEXT,startlevel INTEGER,stoplevel INTEGER,netype INTEGER,flow LONG);");
        sQLiteDatabase.execSQL("CREATE TABLE achange (_id INTEGER,pn TEXT NOT NULL,an TEXT,time LONG,event INTEGER,vcode INTEGER,vcodeaft INTEGER,vn TEXT,vnaft TEXT);");
    }

    @Override // com.baidu.android.systemmonitor.b.c
    public void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS astatus");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS atrace");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS CREATE TABLE achange (_id INTEGER,pn TEXT NOT NULL,an TEXT,time LONG,event INTEGER,vcode INTEGER,vcodeaft INTEGER,vn TEXT,vnaft TEXT);");
        a(sQLiteDatabase);
    }
}
