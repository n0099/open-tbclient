package com.baidu.android.systemmonitor.a.a;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* loaded from: classes.dex */
public class f extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private Context f375a;

    public f(Context context) {
        super(context, "moplus_server_config.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.f375a = context;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE server_config_table (_id INTEGER PRIMARY KEY,name TEXT,type INTEGER,value TEXT);");
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLException e) {
                throw e;
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
