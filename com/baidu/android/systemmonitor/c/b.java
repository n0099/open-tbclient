package com.baidu.android.systemmonitor.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class b extends d {
    public b(Context context) {
        super(context, "devinfo.db", null, 1);
    }

    @Override // com.baidu.android.systemmonitor.c.d
    public void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE power (_id INTEGER,startstamp LONG,stopstamp LONG);");
        sQLiteDatabase.execSQL("CREATE TABLE charge (_id INTEGER,startstamp LONG,stopstamp LONG,chargetype INTEGER,startlevel INTEGER,stoplevel INTEGER,netype INTEGER,loc TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE network (_id INTEGER,startstamp LONG,stopstamp LONG,netype INTEGER,flow LONG);");
        sQLiteDatabase.execSQL("CREATE TABLE stinfo (_id INTEGER,startstamp LONG,pconum INTEGER,sconum INTEGER,msnum INTEGER,msinfo TEXT,calognum INTEGER,caloginfo TEXT,sdfall TEXT,pfall TEXT,pphnum INTEGER,sphnum INTEGER,pmpnum INTEGER,smpnum INTEGER,stvnum INTEGER);");
        sQLiteDatabase.execSQL("CREATE TABLE apkdn (_id INTEGER,startstamp LONG,dnpath TEXT,downame TEXT);");
    }

    @Override // com.baidu.android.systemmonitor.c.d
    public void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS power");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS CREATE TABLE charge (_id INTEGER,startstamp LONG,stopstamp LONG,chargetype INTEGER,startlevel INTEGER,stoplevel INTEGER,netype INTEGER,loc TEXT);");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS CREATE TABLE network (_id INTEGER,startstamp LONG,stopstamp LONG,netype INTEGER,flow LONG);");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS CREATE TABLE stinfo (_id INTEGER,startstamp LONG,pconum INTEGER,sconum INTEGER,msnum INTEGER,msinfo TEXT,calognum INTEGER,caloginfo TEXT,sdfall TEXT,pfall TEXT,pphnum INTEGER,sphnum INTEGER,pmpnum INTEGER,smpnum INTEGER,stvnum INTEGER);");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS CREATE TABLE apkdn (_id INTEGER,startstamp LONG,dnpath TEXT,downame TEXT);");
        a(sQLiteDatabase);
    }
}
