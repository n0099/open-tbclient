package com.baidu.down.request.taskmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.down.request.db.DownloadDatabaseHelper;
/* loaded from: classes.dex */
public class DatabaseMng {
    public static final String DB_NAME = "bddownloads.db";
    public static final int DB_VERSION = 1;
    public static final String DEFAULT_SORT_ORDER = "_id DESC";
    public Context mContext;
    public DownloadDatabaseHelper mDBHelper;
    public SQLiteDatabase mDb;
    public DownloadDataConstants mDownLoad;

    public DatabaseMng(Context context) {
        this.mContext = context;
        DownloadDatabaseHelper downloadDatabaseHelper = new DownloadDatabaseHelper(context);
        this.mDBHelper = downloadDatabaseHelper;
        try {
            this.mDb = downloadDatabaseHelper.getWritableDatabase();
        } catch (SQLiteException unused) {
        }
        this.mDownLoad = new DownloadDataConstants(this.mContext);
    }

    public int delete(String str, String[] strArr) {
        return this.mDownLoad.delete(this.mDb, str, strArr);
    }

    public DownloadDataConstants getDownLoad() {
        return this.mDownLoad;
    }

    public SQLiteDatabase getSQLiteDatabase() {
        return this.mDb;
    }

    public long insert(ContentValues contentValues) {
        return this.mDownLoad.insert(this.mDb, contentValues);
    }

    public int insertOrUpdate(ContentValues contentValues) {
        return this.mDownLoad.insertOrUpdate(this.mDb, contentValues);
    }

    public long insertToDatabase(String str, String str2, String str3, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("uri", str);
        contentValues.put("name", str2);
        contentValues.put("path", str3);
        contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(i));
        return this.mDownLoad.insert(this.mDb, contentValues);
    }

    public Cursor query(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        return this.mDownLoad.query(this.mDb, strArr, str, strArr2, str2, str3, str4);
    }

    public int update(ContentValues contentValues, String str, String[] strArr) {
        return this.mDownLoad.update(this.mDb, contentValues, str, strArr);
    }
}
