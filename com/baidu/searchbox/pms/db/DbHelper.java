package com.baidu.searchbox.pms.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* loaded from: classes3.dex */
public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "pms.db";
    public static final int DB_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    private String getCreateDBSql() {
        return "CREATE TABLE package_info(_id INTEGER PRIMARY KEY,channel_id TEXT NOT NULL,package_name TEXT NOT NULL,name TEXT NOT NULL,version LONG," + PackageTable.UPDATE_VERSION + " LONG," + PackageTable.MIN_HOST_VERSION + " TEXT," + PackageTable.MAX_HOST_VERSION + " TEXT,download_url TEXT,type INTEGER DEFAULT 0," + PackageTable.MD5 + " TEXT,size TEXT," + PackageTable.DOWNLOAD_OPTION + " INTEGER DEFAULT 0,wifi INTEGER DEFAULT 0," + PackageTable.IS_SILENCE + " INTEGER DEFAULT 0," + PackageTable.DISABLE + " INTEGER DEFAULT 0,sign TEXT," + PackageTable.EXTRA_FROM_SERVER + " TEXT," + PackageTable.EXTRA_FROM_LOCAL + " TEXT," + PackageTable.FILE_PATH + " TEXT," + PackageTable.TOTAL_SIZE + " LONG," + PackageTable.CURRENT_SIZE + " LONG,create_time LONG,update_time LONG);";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(getCreateDBSql());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
