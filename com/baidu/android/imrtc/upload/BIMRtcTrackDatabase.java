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
/* loaded from: classes2.dex */
public class BIMRtcTrackDatabase {
    public static final String DB_NAME = "bimrtc_track.db";
    public static final int DB_VERSION = 1;
    public static final int MAX_QUERY_COUNT = 1000;
    public static String TAG = "BIMRtcTrackDatabase";
    public static DbOpenHelper dbOpenHelper;
    @SuppressLint({"StaticFieldLeak"})
    public static BIMRtcTrackDatabase instance;
    public static final Object myLock = new Object();
    public Context context;

    /* loaded from: classes2.dex */
    public static class DbOpenHelper extends SQLiteOpenHelper {
        public static final String SQL_TABLE_CREATE_REQUEST = "CREATE TABLE request (" + RequestEnum.id.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + RequestEnum.method.name() + " TEXT, " + RequestEnum.requestId.name() + " TEXT, " + RequestEnum.timestamp.name() + " LONG, " + RequestEnum.responseTime.name() + " LONG, " + RequestEnum.errorCode.name() + " LONG, " + RequestEnum.ext.name() + " TEXT, " + RequestEnum.aliasId.name() + " LONG NOT NULL);";
        public Context context;

        public DbOpenHelper(Context context, String str, int i, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i, databaseErrorHandler);
        }

        private void dropTables(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS request");
            } catch (Exception e2) {
                String str = BIMRtcTrackDatabase.TAG;
                LogUtils.d(str, "dropTables Exception: " + e2);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(SQL_TABLE_CREATE_REQUEST);
            } catch (Exception e2) {
                String str = BIMRtcTrackDatabase.TAG;
                LogUtils.d(str, "DbOpenHelper onCreate E: " + e2);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            dropTables(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }

        public DbOpenHelper(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
            this.context = context;
        }
    }

    /* loaded from: classes2.dex */
    public enum RequestEnum {
        id,
        method,
        requestId,
        timestamp,
        responseTime,
        errorCode,
        ext,
        aliasId;
        
        public static final String TABLE_NAME = "request";
    }

    public BIMRtcTrackDatabase(Context context) {
        this.context = context;
        dbOpenHelper = new DbOpenHelper(context, DB_NAME, 1);
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

    public static SQLiteDatabase getDb(Context context) {
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

    public void clearRequestTable() {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db == null) {
                return;
            }
            try {
                db.delete("request", null, null);
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "BIMRtcTrack clearRequestTable Exception: " + e2);
            }
            db.close();
        }
    }

    public void deleteRequest(Request request) {
        SQLiteDatabase db = getDb(this.context);
        if (db == null) {
            return;
        }
        try {
            try {
                db.delete("request", RequestEnum.responseTime + " = ?", new String[]{String.valueOf(request.responseTime)});
            } catch (Exception e2) {
                LogUtils.e(TAG, "deleteRequest :", e2);
            }
        } finally {
            db.close();
        }
    }

    public void deleteRequests(List<Request> list) {
        synchronized (myLock) {
            for (Request request : list) {
                deleteRequest(request);
            }
        }
    }

    public long getRequestCount() {
        synchronized (myLock) {
            long j = 0;
            SQLiteDatabase db = getDb(this.context);
            if (db == null) {
                return 0L;
            }
            Cursor cursor = null;
            try {
                cursor = db.rawQuery("select count(*) from request", null);
                if (cursor != null && cursor.moveToNext()) {
                    j = cursor.getInt(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                LogUtils.e(TAG, "BIMRtcTrack insert Db exception : " + e2);
                if (cursor != null) {
                    cursor.close();
                }
            }
            db.close();
            return j;
        }
    }

    public List<Request> getRequests() {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            Cursor cursor = null;
            if (db == null) {
                return null;
            }
            List<Request> arrayList = new ArrayList<>();
            try {
                cursor = db.rawQuery("select * from request limit 1000", null);
                arrayList = getCursorRequests(cursor);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "BIMRtcTrack getRequests error " + e2.getMessage());
                if (cursor != null) {
                    cursor.close();
                }
            }
            db.close();
            return arrayList;
        }
    }

    public List<Request> getRequestsByAliasId(long j) {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            Cursor cursor = null;
            if (db == null) {
                return null;
            }
            List<Request> arrayList = new ArrayList<>();
            try {
                cursor = db.rawQuery("select * from request limit 1000 where " + RequestEnum.aliasId + " = " + j, null);
                arrayList = getCursorRequests(cursor);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "BIMRtcTrack getRequests error " + e2.getMessage());
                if (cursor != null) {
                    cursor.close();
                }
            }
            db.close();
            return arrayList;
        }
    }

    public void insertRequest(Request request) {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db == null) {
                return;
            }
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
                String str = TAG;
                LogUtils.d(str, "method :" + request.method + ", requestId :" + request.requestId + ", errorCode :" + request.errorCode + ", ext :" + request.ext);
            } catch (Exception e2) {
                String str2 = TAG;
                LogUtils.e(str2, "BIMRtcTrack insert Request exception : " + e2);
            }
            db.close();
        }
    }
}
