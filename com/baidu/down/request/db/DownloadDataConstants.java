package com.baidu.down.request.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
/* loaded from: classes.dex */
public final class DownloadDataConstants {
    public static final String DB_TABLE = "downloads";
    public static final String DEFAULT_DL_BINARY_EXTENSION = ".bin";
    public static final String DEFAULT_DL_HTML_EXTENSION = ".html";
    public static final String DEFAULT_DL_TEXT_EXTENSION = ".txt";
    public Context mContext;

    /* loaded from: classes.dex */
    public static final class Columns implements BaseColumns {
        public static final String COLUMN_CURRENT_BYTES = "current_bytes";
        public static final String COLUMN_ETAG = "etag";
        public static final String COLUMN_FILE_DATA = "data";
        public static final String COLUMN_FILE_NAME = "name";
        public static final String COLUMN_FILE_PATH = "path";
        public static final String COLUMN_LAST_MODIFICATION = "lastmodification";
        public static final String COLUMN_MIME_TYPE = "mimetype";
        public static final String COLUMN_PROGRESS_MAP = "progress_map";
        public static final String COLUMN_RETRY_COUNT = "retry_count";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_TASK_TYPE = "tasktype";
        public static final String COLUMN_TOTAL_BYTES = "total_bytes";
        public static final String COLUMN_URI = "uri";
    }

    public DownloadDataConstants(Context context) {
        this.mContext = context;
    }

    public int delete(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        return sQLiteDatabase.delete("downloads", str, strArr);
    }

    public long insert(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return sQLiteDatabase.insert("downloads", null, contentValues);
    }

    public int insertOrUpdate(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        long longValue = contentValues.getAsLong("_id").longValue();
        if (sQLiteDatabase.query("downloads", null, "_id=?", new String[]{longValue + ""}, null, null, null).moveToFirst()) {
            return sQLiteDatabase.update("downloads", contentValues, "_id=?", new String[]{longValue + ""});
        }
        return (int) sQLiteDatabase.insert("downloads", null, contentValues);
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        return sQLiteDatabase.query("downloads", strArr, str, strArr2, str2, str3, str4);
    }

    public int update(SQLiteDatabase sQLiteDatabase, ContentValues contentValues, String str, String[] strArr) {
        return sQLiteDatabase.update("downloads", contentValues, str, strArr);
    }
}
