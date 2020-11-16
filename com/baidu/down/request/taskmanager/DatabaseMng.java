package com.baidu.down.request.taskmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.down.request.db.DownloadDatabaseHelper;
/* loaded from: classes15.dex */
public class DatabaseMng {
    public static final String DB_NAME = "bddownloads.db";
    public static final int DB_VERSION = 1;
    public static final String DEFAULT_SORT_ORDER = "_id DESC";
    private Context mContext;
    private DownloadDatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    private DownloadDataConstants mDownLoad;

    public DatabaseMng(Context context) {
        this.mContext = context;
        this.mDBHelper = new DownloadDatabaseHelper(context);
        try {
            this.mDb = this.mDBHelper.getWritableDatabase();
        } catch (SQLiteException e) {
        }
        this.mDownLoad = new DownloadDataConstants(this.mContext);
    }

    public DownloadDataConstants getDownLoad() {
        return this.mDownLoad;
    }

    public SQLiteDatabase getSQLiteDatabase() {
        return this.mDb;
    }

    public long insertToDatabase(String str, String str2, String str3, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadDataConstants.Columns.COLUMN_URI, str);
        contentValues.put("name", str2);
        contentValues.put("path", str3);
        contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(i));
        return this.mDownLoad.insert(this.mDb, contentValues);
    }

    public long insert(ContentValues contentValues) {
        return this.mDownLoad.insert(this.mDb, contentValues);
    }

    public int delete(String str, String[] strArr) {
        return this.mDownLoad.delete(this.mDb, str, strArr);
    }

    public int update(ContentValues contentValues, String str, String[] strArr) {
        return this.mDownLoad.update(this.mDb, contentValues, str, strArr);
    }

    public Cursor query(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        return this.mDownLoad.query(this.mDb, strArr, str, strArr2, str2, str3, str4);
    }

    public int insertOrUpdate(ContentValues contentValues) {
        return this.mDownLoad.insertOrUpdate(this.mDb, contentValues);
    }
}
