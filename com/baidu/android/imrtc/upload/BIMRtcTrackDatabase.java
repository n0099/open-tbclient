package com.baidu.android.imrtc.upload;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imsdk.upload.action.track.Request;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
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
    /* loaded from: classes3.dex */
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
                    LogUtils.d(TAG, "method :" + request.method + ", requestId :" + request.requestId + ", errorCode :" + request.errorCode + ", ext :" + request.ext);
                    db.close();
                } catch (Exception e) {
                    LogUtils.e(TAG, "BIMRtcTrack insert Request exception : " + e);
                    db.close();
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [104=4] */
    public List<Request> getRequests() {
        Throwable th;
        Cursor cursor;
        ArrayList arrayList;
        List<Request> list = null;
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db != null) {
                try {
                    arrayList = new ArrayList();
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    cursor = db.rawQuery("select * from request limit 1000", null);
                    try {
                        list = getCursorRequests(cursor);
                        if (cursor != null) {
                            cursor.close();
                        }
                        db.close();
                    } catch (Exception e) {
                        e = e;
                        LogUtils.e(TAG, "BIMRtcTrack getRequests error " + e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        db.close();
                        list = arrayList;
                        return list;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th3) {
                    th = th3;
                    cursor = null;
                    if (cursor != null) {
                        cursor.close();
                    }
                    db.close();
                    throw th;
                }
            }
        }
        return list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [132=4] */
    public List<Request> getRequestsByAliasId(long j) {
        Throwable th;
        Cursor cursor;
        ArrayList arrayList;
        List<Request> list = null;
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db != null) {
                try {
                    arrayList = new ArrayList();
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    cursor = db.rawQuery("select * from request limit 1000 where " + RequestEnum.aliasId + " = " + j, null);
                    try {
                        list = getCursorRequests(cursor);
                        if (cursor != null) {
                            cursor.close();
                        }
                        db.close();
                    } catch (Exception e) {
                        e = e;
                        LogUtils.e(TAG, "BIMRtcTrack getRequests error " + e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        db.close();
                        list = arrayList;
                        return list;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th3) {
                    th = th3;
                    cursor = null;
                    if (cursor != null) {
                        cursor.close();
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
    /* loaded from: classes3.dex */
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
