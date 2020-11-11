package com.baidu.android.imrtc.upload;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.android.imsdk.upload.action.track.Request;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class BIMRtcTrackDatabase {
    private static final String DB_NAME = "bimrtc_track.db";
    private static final int DB_VERSION = 1;
    private static final int MAX_QUERY_COUNT = 1000;
    @SuppressLint({"StaticFieldLeak"})
    private static BIMRtcTrackDatabase instance;
    private Context context;
    private static String TAG = "BIMRtcTrackDatabase";
    private static DbOpenHelper dbOpenHelper = null;
    public static final Object myLock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public enum RequestEnum {
        id,
        method,
        requestId,
        timestamp,
        responseTime,
        errorCode,
        ext,
        aliasId;
        
        static final String TABLE_NAME = "request";
    }

    private BIMRtcTrackDatabase(Context context) {
        this.context = context;
        dbOpenHelper = new DbOpenHelper(context, DB_NAME, 1);
    }

    private static SQLiteDatabase getDb(Context context) {
        if (dbOpenHelper == null) {
            dbOpenHelper = new DbOpenHelper(context, DB_NAME, 1);
        }
        try {
            return dbOpenHelper.getWritableDatabase();
        } catch (Throwable th) {
            LogUtils.e(TAG, "getDb Exception: ", th);
            return null;
        }
    }

    public static BIMRtcTrackDatabase getInstance(Context context) {
        BIMRtcTrackDatabase bIMRtcTrackDatabase;
        synchronized (myLock) {
            if (instance == null) {
                instance = new BIMRtcTrackDatabase(context.getApplicationContext());
            }
            bIMRtcTrackDatabase = instance;
        }
        return bIMRtcTrackDatabase;
    }

    public void insertRequest(Request request) {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db != null) {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(RequestEnum.method.name(), request.method);
                    contentValues.put(RequestEnum.requestId.name(), request.requestId);
                    contentValues.put(RequestEnum.timestamp.name(), Long.valueOf(request.timestamp));
                    contentValues.put(RequestEnum.responseTime.name(), Long.valueOf(request.responseTime));
                    contentValues.put(RequestEnum.errorCode.name(), Long.valueOf(request.errorCode));
                    contentValues.put(RequestEnum.ext.name(), request.ext);
                    contentValues.put(RequestEnum.aliasId.name(), Long.valueOf(request.aliasId));
                    db.insert("request", null, contentValues);
                    com.baidu.android.imrtc.utils.LogUtils.e(TAG, "method :" + request.method + ", requestId :" + request.requestId + ", errorCode :" + request.errorCode + ", ext :" + request.ext);
                    db.close();
                } catch (Exception e) {
                    LogUtils.e(TAG, "BIMRtcTrack insert Request exception : " + e);
                    db.close();
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [104=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0064 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0066 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x000e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public List<Request> getRequests() {
        ArrayList arrayList;
        Cursor cursor;
        Exception e;
        List<Request> list = null;
        synchronized (myLock) {
            ?? r1 = this.context;
            SQLiteDatabase db = getDb(r1);
            if (db != null) {
                try {
                    arrayList = new ArrayList();
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    cursor = db.rawQuery("select * from request limit 1000", null);
                    try {
                        list = getCursorRequests(cursor);
                        if (cursor != null) {
                            cursor.close();
                        }
                        db.close();
                        r1 = cursor;
                    } catch (Exception e2) {
                        e = e2;
                        LogUtils.e(TAG, "BIMRtcTrack getRequests error " + e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        db.close();
                        list = arrayList;
                        r1 = cursor;
                        return list;
                    }
                } catch (Exception e3) {
                    cursor = null;
                    e = e3;
                } catch (Throwable th2) {
                    r1 = 0;
                    th = th2;
                    if (r1 != 0) {
                        r1.close();
                    }
                    db.close();
                    throw th;
                }
            }
        }
        return list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [132=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0082 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0084 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x000e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public List<Request> getRequestsByAliasId(long j) {
        ArrayList arrayList;
        Cursor cursor;
        Exception e;
        List<Request> list = null;
        synchronized (myLock) {
            ?? r1 = this.context;
            SQLiteDatabase db = getDb(r1);
            if (db != null) {
                try {
                    arrayList = new ArrayList();
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    cursor = db.rawQuery("select * from request limit 1000 where " + RequestEnum.aliasId + " = " + j, null);
                    try {
                        list = getCursorRequests(cursor);
                        if (cursor != null) {
                            cursor.close();
                        }
                        db.close();
                        r1 = cursor;
                    } catch (Exception e2) {
                        e = e2;
                        LogUtils.e(TAG, "BIMRtcTrack getRequests error " + e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        db.close();
                        list = arrayList;
                        r1 = cursor;
                        return list;
                    }
                } catch (Exception e3) {
                    cursor = null;
                    e = e3;
                } catch (Throwable th2) {
                    r1 = 0;
                    th = th2;
                    if (r1 != 0) {
                        r1.close();
                    }
                    db.close();
                    throw th;
                }
            }
        }
        return list;
    }

    private List<Request> getCursorRequests(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor != null && cursor.moveToNext()) {
            Request request = new Request();
            request.method = cursor.getString(cursor.getColumnIndex(RequestEnum.method.name()));
            request.requestId = cursor.getString(cursor.getColumnIndex(RequestEnum.requestId.name()));
            request.timestamp = cursor.getLong(cursor.getColumnIndex(RequestEnum.timestamp.name()));
            request.responseTime = cursor.getLong(cursor.getColumnIndex(RequestEnum.responseTime.name()));
            request.errorCode = cursor.getLong(cursor.getColumnIndex(RequestEnum.errorCode.name()));
            request.ext = cursor.getString(cursor.getColumnIndex(RequestEnum.ext.name()));
            request.aliasId = cursor.getLong(cursor.getColumnIndex(RequestEnum.aliasId.name()));
            arrayList.add(request);
        }
        return arrayList;
    }

    public long getRequestCount() {
        long j;
        Cursor cursor = null;
        synchronized (myLock) {
            j = 0;
            SQLiteDatabase db = getDb(this.context);
            if (db != null) {
                try {
                    cursor = db.rawQuery("select count(*) from request", null);
                    if (cursor != null && cursor.moveToNext()) {
                        j = cursor.getInt(0);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    db.close();
                } catch (Exception e) {
                    LogUtils.e(TAG, "BIMRtcTrack insert Db exception : " + e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    db.close();
                }
            }
        }
        return j;
    }

    public void deleteRequests(List<Request> list) {
        synchronized (myLock) {
            for (Request request : list) {
                deleteRequest(request);
            }
        }
    }

    public void deleteRequest(Request request) {
        SQLiteDatabase db = getDb(this.context);
        try {
        } catch (Exception e) {
            LogUtils.e(TAG, "deleteRequest :", e);
        } finally {
            db.close();
        }
        if (db != null) {
            db.delete("request", RequestEnum.responseTime + " = ?", new String[]{String.valueOf(request.responseTime)});
        }
    }

    public void clearRequestTable() {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db != null) {
                try {
                    db.delete("request", null, null);
                    db.close();
                } catch (Exception e) {
                    LogUtils.e(TAG, "BIMRtcTrack clearRequestTable Exception: " + e);
                    db.close();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class DbOpenHelper extends SQLiteOpenHelper {
        private static final String SQL_TABLE_CREATE_REQUEST = "CREATE TABLE request (" + RequestEnum.id.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + RequestEnum.method.name() + " TEXT, " + RequestEnum.requestId.name() + " TEXT, " + RequestEnum.timestamp.name() + " LONG, " + RequestEnum.responseTime.name() + " LONG, " + RequestEnum.errorCode.name() + " LONG, " + RequestEnum.ext.name() + " TEXT, " + RequestEnum.aliasId.name() + " LONG NOT NULL);";
        private Context context;

        public DbOpenHelper(Context context, String str, int i, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i, databaseErrorHandler);
        }

        public DbOpenHelper(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
            this.context = context;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(SQL_TABLE_CREATE_REQUEST);
            } catch (Exception e) {
                LogUtils.d(BIMRtcTrackDatabase.TAG, "DbOpenHelper onCreate E: " + e);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            dropTables(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }

        private void dropTables(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS request");
            } catch (Exception e) {
                LogUtils.d(BIMRtcTrackDatabase.TAG, "dropTables Exception: " + e);
            }
        }
    }
}
