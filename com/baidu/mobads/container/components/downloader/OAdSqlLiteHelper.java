package com.baidu.mobads.container.components.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* loaded from: classes2.dex */
public class OAdSqlLiteHelper extends SQLiteOpenHelper {
    public static final String DB_NAME_NEW = "__bd_sdk_remote_download_x.db";
    public static final String SQL_CREATE_TABLE_DOWNLOAD_INFO = "create table download_info(_id integer PRIMARY KEY AUTOINCREMENT, thread_id integer, start_pos integer, end_pos integer, compelete_size integer, url char, local_file char, process_name char)";
    public static final String TABLE_NAME = "download_info";

    public OAdSqlLiteHelper(Context context) {
        super(context, DB_NAME_NEW, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(SQL_CREATE_TABLE_DOWNLOAD_INFO);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
