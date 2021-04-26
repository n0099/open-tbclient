package com.baidu.android.imsdk.upload.action;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.upload.action.track.Ack;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Crash;
import com.baidu.android.imsdk.upload.action.track.Db;
import com.baidu.android.imsdk.upload.action.track.Msg;
import com.baidu.android.imsdk.upload.action.track.Request;
import com.baidu.android.imsdk.upload.action.track.Ui;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class IMTrackDatabase {
    public static final String DB_NAME = "im_track.db";
    public static final int DB_VERSION = 1;
    public static final int MAX_QUERY_COUNT = 1000;
    public static String TAG = "IMTrackDatabase";
    public static DbOpenHelper dbOpenHelper;
    @SuppressLint({"StaticFieldLeak"})
    public static IMTrackDatabase instance;
    public static final Object myLock = new Object();
    public Context context;

    /* loaded from: classes.dex */
    public enum AckEnum {
        ackId,
        type,
        value,
        timestamp,
        ext,
        aliasId;
        
        public static final String TABLE_NAME = "ack";
    }

    /* loaded from: classes.dex */
    public enum ConnectionEnum {
        connectionId,
        startTime,
        stopTime,
        reason,
        retryTime,
        retryCount,
        ext,
        aliasId;
        
        public static final String TABLE_NAME = "connection";
    }

    /* loaded from: classes.dex */
    public enum CrashEnum {
        crashId,
        exception,
        timestamp,
        ext,
        aliasId;
        
        public static final String TABLE_NAME = "crash";
    }

    /* loaded from: classes.dex */
    public enum DbEnum {
        dbId,
        tableName,
        className,
        method,
        action,
        startTime,
        endTime,
        duration,
        ext,
        aliasId;
        
        public static final String TABLE_NAME = "db";
    }

    /* loaded from: classes.dex */
    public static class DbOpenHelper extends SQLiteOpenHelper {
        public static final String SQL_TABLE_CREATE_ACK;
        public static final String SQL_TABLE_CREATE_CONNECTION;
        public static final String SQL_TABLE_CREATE_CRASH;
        public static final String SQL_TABLE_CREATE_DB;
        public static final String SQL_TABLE_CREATE_MESSAGE;
        public static final String SQL_TABLE_CREATE_REQUEST;
        public static final String SQL_TABLE_CREATE_UI = "CREATE TABLE ui (" + UiEnum.uiId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + UiEnum.category.name() + " TEXT, " + UiEnum.page.name() + " TEXT, " + UiEnum.startTime.name() + " LONG, " + UiEnum.endTime.name() + " LONG, " + UiEnum.duration.name() + " LONG, " + UiEnum.ext.name() + " TEXT, " + UiEnum.aliasId.name() + " LONG NOT NULL );";
        public Context context;

        static {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE crash (");
            sb.append(CrashEnum.crashId.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(CrashEnum.exception.name());
            sb.append(" TEXT, ");
            sb.append(CrashEnum.timestamp.name());
            sb.append(" LONG, ");
            sb.append(CrashEnum.ext.name());
            sb.append(" TEXT, ");
            sb.append(CrashEnum.aliasId.name());
            sb.append(" LONG NOT NULL );");
            SQL_TABLE_CREATE_CRASH = sb.toString();
            SQL_TABLE_CREATE_DB = "CREATE TABLE db (" + DbEnum.dbId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DbEnum.tableName.name() + " TEXT, " + DbEnum.className.name() + " TEXT, " + DbEnum.method.name() + " TEXT, " + DbEnum.action.name() + " TEXT, " + DbEnum.startTime.name() + " LONG, " + DbEnum.endTime.name() + " LONG, " + DbEnum.duration.name() + " LONG, " + DbEnum.ext.name() + " TEXT, " + DbEnum.aliasId.name() + " LONG NOT NULL );";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE connection (");
            sb2.append(ConnectionEnum.connectionId.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(ConnectionEnum.startTime.name());
            sb2.append(" LONG, ");
            sb2.append(ConnectionEnum.stopTime.name());
            sb2.append(" LONG, ");
            sb2.append(ConnectionEnum.reason.name());
            sb2.append(" TEXT, ");
            sb2.append(ConnectionEnum.retryTime.name());
            sb2.append(" LONG, ");
            sb2.append(ConnectionEnum.retryCount.name());
            sb2.append(" LONG, ");
            sb2.append(ConnectionEnum.ext.name());
            sb2.append(" TEXT, ");
            sb2.append(ConnectionEnum.aliasId.name());
            sb2.append(" LONG NOT NULL );");
            SQL_TABLE_CREATE_CONNECTION = sb2.toString();
            SQL_TABLE_CREATE_REQUEST = "CREATE TABLE request (" + RequestEnum.id.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + RequestEnum.method.name() + " TEXT, " + RequestEnum.requestId.name() + " TEXT, " + RequestEnum.timestamp.name() + " LONG, " + RequestEnum.responseTime.name() + " LONG, " + RequestEnum.errorCode.name() + " LONG, " + RequestEnum.ext.name() + " TEXT, " + RequestEnum.aliasId.name() + " LONG NOT NULL);";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("CREATE TABLE ack (");
            sb3.append(AckEnum.ackId.name());
            sb3.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb3.append(AckEnum.type.name());
            sb3.append(" TEXT, ");
            sb3.append(AckEnum.value.name());
            sb3.append(" TEXT, ");
            sb3.append(AckEnum.timestamp.name());
            sb3.append(" LONG, ");
            sb3.append(AckEnum.ext.name());
            sb3.append(" TEXT, ");
            sb3.append(AckEnum.aliasId.name());
            sb3.append(" LONG NOT NULL);");
            SQL_TABLE_CREATE_ACK = sb3.toString();
            SQL_TABLE_CREATE_MESSAGE = "CREATE TABLE msg (" + MsgEnum.msgId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + MsgEnum.msgCount.name() + " LONG, " + MsgEnum.roomId.name() + " TEXT, " + MsgEnum.duration.name() + " LONG, " + MsgEnum.startMsgId.name() + " LONG, " + MsgEnum.endMsgId.name() + " LONG, " + MsgEnum.ext.name() + " TEXT, " + MsgEnum.aliasId.name() + " LONG NOT NULL);";
        }

        public DbOpenHelper(Context context, String str, int i2, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i2, databaseErrorHandler);
        }

        private void dropTables(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ui");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS crash");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS connection");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS request");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS db");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ack");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS msg");
            } catch (Exception e2) {
                String str = IMTrackDatabase.TAG;
                LogUtils.d(str, "dropTables Exception: " + e2);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(SQL_TABLE_CREATE_UI);
                sQLiteDatabase.execSQL(SQL_TABLE_CREATE_CRASH);
                sQLiteDatabase.execSQL(SQL_TABLE_CREATE_DB);
                sQLiteDatabase.execSQL(SQL_TABLE_CREATE_CONNECTION);
                sQLiteDatabase.execSQL(SQL_TABLE_CREATE_REQUEST);
                sQLiteDatabase.execSQL(SQL_TABLE_CREATE_ACK);
                sQLiteDatabase.execSQL(SQL_TABLE_CREATE_MESSAGE);
            } catch (Exception e2) {
                String str = IMTrackDatabase.TAG;
                LogUtils.d(str, "DbOpenHelper onCreate E: " + e2);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            dropTables(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }

        public DbOpenHelper(Context context, String str, int i2) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
            this.context = context;
        }
    }

    /* loaded from: classes.dex */
    public enum MsgEnum {
        msgId,
        msgCount,
        roomId,
        duration,
        startMsgId,
        endMsgId,
        ext,
        aliasId;
        
        public static final String TABLE_NAME = "msg";
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public enum UiEnum {
        uiId,
        category,
        page,
        startTime,
        endTime,
        duration,
        ext,
        aliasId;
        
        public static final String TABLE_NAME = "ui";
    }

    public IMTrackDatabase(Context context) {
        this.context = context;
        dbOpenHelper = new DbOpenHelper(context, DB_NAME, 1);
    }

    @Nullable
    private void checkDadabaseMaxCount(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("select count(*) from " + str, null);
                if (rawQuery != null) {
                    try {
                        if (rawQuery.moveToFirst() && rawQuery.getInt(0) > 1000) {
                            sQLiteDatabase.delete(str, null, null);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor = rawQuery;
                        e.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        sQLiteDatabase.close();
                    } catch (Throwable th) {
                        th = th;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        sQLiteDatabase.close();
                        throw th;
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Exception e3) {
                e = e3;
            }
            sQLiteDatabase.close();
        } catch (Throwable th2) {
            th = th2;
        }
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

    public static IMTrackDatabase getInstance(Context context) {
        IMTrackDatabase iMTrackDatabase;
        synchronized (myLock) {
            if (instance == null) {
                instance = new IMTrackDatabase(context.getApplicationContext());
            }
            iMTrackDatabase = instance;
        }
        return iMTrackDatabase;
    }

    public void clearAllTables() {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db == null) {
                return;
            }
            try {
                db.delete(UiEnum.TABLE_NAME, null, null);
                db.delete("crash", null, null);
                db.delete(DbEnum.TABLE_NAME, null, null);
                db.delete("connection", null, null);
                db.delete("request", null, null);
                db.delete(AckEnum.TABLE_NAME, null, null);
                db.delete("msg", null, null);
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "IMTrack clearAllTables Exception: " + e2);
            }
            db.close();
        }
    }

    public void clearCrashTable() {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db == null) {
                return;
            }
            try {
                db.delete("crash", null, null);
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "IMTrack clearCrashTable Exception: " + e2);
            }
            db.close();
        }
    }

    public List<Ack> getAcks() {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            Cursor cursor = null;
            if (db == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                cursor = db.rawQuery("select * from ack limit 1000", null);
                while (cursor != null && cursor.moveToNext()) {
                    Ack ack = new Ack();
                    ack.type = cursor.getString(cursor.getColumnIndex(AckEnum.type.name()));
                    ack.value = cursor.getString(cursor.getColumnIndex(AckEnum.value.name()));
                    ack.timestamp = cursor.getLong(cursor.getColumnIndex(AckEnum.timestamp.name()));
                    ack.ext = cursor.getString(cursor.getColumnIndex(AckEnum.ext.name()));
                    ack.aliasId = cursor.getLong(cursor.getColumnIndex(AckEnum.aliasId.name()));
                    arrayList.add(ack);
                }
                checkDadabaseMaxCount(db, AckEnum.TABLE_NAME);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "IMTrack getAcks error " + e2.getMessage());
                if (cursor != null) {
                    cursor.close();
                }
            }
            db.close();
            return arrayList;
        }
    }

    public long getConnectionCount() {
        synchronized (myLock) {
            long j = 0;
            SQLiteDatabase db = getDb(this.context);
            if (db == null) {
                return 0L;
            }
            Cursor cursor = null;
            try {
                cursor = db.rawQuery("select count(*) from connection", null);
                if (cursor != null && cursor.moveToNext()) {
                    j = cursor.getInt(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                LogUtils.e(TAG, "IMTrack insert Db exception : " + e2);
                if (cursor != null) {
                    cursor.close();
                }
            }
            db.close();
            return j;
        }
    }

    public List<Connection> getConnections() {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            Cursor cursor = null;
            if (db == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                cursor = db.rawQuery("select * from connection limit 1000", null);
                while (cursor != null && cursor.moveToNext()) {
                    Connection connection = new Connection();
                    connection.startTime = cursor.getLong(cursor.getColumnIndex(ConnectionEnum.startTime.name()));
                    connection.stopTime = cursor.getLong(cursor.getColumnIndex(ConnectionEnum.stopTime.name()));
                    connection.reason = cursor.getString(cursor.getColumnIndex(ConnectionEnum.reason.name()));
                    connection.retryTime = cursor.getLong(cursor.getColumnIndex(ConnectionEnum.retryTime.name()));
                    connection.retryCount = cursor.getLong(cursor.getColumnIndex(ConnectionEnum.retryCount.name()));
                    connection.ext = cursor.getString(cursor.getColumnIndex(ConnectionEnum.ext.name()));
                    connection.aliasId = cursor.getLong(cursor.getColumnIndex(ConnectionEnum.aliasId.name()));
                    arrayList.add(connection);
                }
                checkDadabaseMaxCount(db, "connection");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "IMTrack getConnections error " + e2.getMessage());
                if (cursor != null) {
                    cursor.close();
                }
            }
            db.close();
            return arrayList;
        }
    }

    public long getCrashCount() {
        synchronized (myLock) {
            long j = 0;
            SQLiteDatabase db = getDb(this.context);
            if (db == null) {
                return 0L;
            }
            Cursor cursor = null;
            try {
                cursor = db.rawQuery("select count(*) from crash", null);
                if (cursor != null && cursor.moveToNext()) {
                    j = cursor.getInt(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                LogUtils.e(TAG, "IMTrack insert Db exception : " + e2);
                if (cursor != null) {
                    cursor.close();
                }
            }
            db.close();
            return j;
        }
    }

    public List<Crash> getCrashes() {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            Cursor cursor = null;
            if (db == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                cursor = db.rawQuery("select * from crash limit 1000", null);
                while (cursor != null && cursor.moveToNext()) {
                    Crash crash = new Crash();
                    crash.exception = cursor.getString(cursor.getColumnIndex(CrashEnum.exception.name()));
                    crash.timestamp = cursor.getLong(cursor.getColumnIndex(CrashEnum.timestamp.name()));
                    crash.ext = cursor.getString(cursor.getColumnIndex(CrashEnum.ext.name()));
                    crash.aliasId = cursor.getLong(cursor.getColumnIndex(CrashEnum.aliasId.name()));
                    arrayList.add(crash);
                }
                checkDadabaseMaxCount(db, "crash");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "IMTrack getCrashes error " + e2.getMessage());
                if (cursor != null) {
                    cursor.close();
                }
            }
            db.close();
            return arrayList;
        }
    }

    public List<Db> getDbs() {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            Cursor cursor = null;
            if (db == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                cursor = db.rawQuery("select * from db limit 1000", null);
                while (cursor != null && cursor.moveToNext()) {
                    Db db2 = new Db();
                    db2.table = cursor.getString(cursor.getColumnIndex(DbEnum.tableName.name()));
                    db2.className = cursor.getString(cursor.getColumnIndex(DbEnum.className.name()));
                    db2.method = cursor.getString(cursor.getColumnIndex(DbEnum.method.name()));
                    db2.action = cursor.getString(cursor.getColumnIndex(DbEnum.action.name()));
                    db2.startTime = cursor.getLong(cursor.getColumnIndex(DbEnum.startTime.name()));
                    db2.endTime = cursor.getLong(cursor.getColumnIndex(DbEnum.endTime.name()));
                    db2.duration = cursor.getLong(cursor.getColumnIndex(DbEnum.duration.name()));
                    db2.ext = cursor.getString(cursor.getColumnIndex(DbEnum.ext.name()));
                    db2.aliasId = cursor.getLong(cursor.getColumnIndex(DbEnum.aliasId.name()));
                    arrayList.add(db2);
                }
                checkDadabaseMaxCount(db, DbEnum.TABLE_NAME);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "IMTrack getDbs error " + e2.getMessage());
                if (cursor != null) {
                    cursor.close();
                }
            }
            db.close();
            return arrayList;
        }
    }

    public List<Msg> getMsgs() {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            Cursor cursor = null;
            if (db == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                cursor = db.rawQuery("select * from msg limit 1000", null);
                while (cursor != null && cursor.moveToNext()) {
                    Msg msg = new Msg();
                    msg.msgCount = cursor.getLong(cursor.getColumnIndex(MsgEnum.msgCount.name()));
                    msg.roomId = cursor.getString(cursor.getColumnIndex(MsgEnum.roomId.name()));
                    msg.duration = cursor.getLong(cursor.getColumnIndex(MsgEnum.duration.name()));
                    msg.startMsgId = cursor.getLong(cursor.getColumnIndex(MsgEnum.startMsgId.name()));
                    msg.endMsgId = cursor.getLong(cursor.getColumnIndex(MsgEnum.endMsgId.name()));
                    msg.ext = cursor.getString(cursor.getColumnIndex(MsgEnum.ext.name()));
                    msg.aliasId = cursor.getLong(cursor.getColumnIndex(MsgEnum.aliasId.name()));
                    arrayList.add(msg);
                }
                checkDadabaseMaxCount(db, "msg");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "IMTrack getMsgs error " + e2.getMessage());
                if (cursor != null) {
                    cursor.close();
                }
            }
            db.close();
            return arrayList;
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
                LogUtils.e(TAG, "IMTrack insert Db exception : " + e2);
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
            ArrayList arrayList = new ArrayList();
            try {
                cursor = db.rawQuery("select * from request limit 1000", null);
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
                checkDadabaseMaxCount(db, "request");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "IMTrack getRequests error " + e2.getMessage());
                if (cursor != null) {
                    cursor.close();
                }
            }
            db.close();
            return arrayList;
        }
    }

    public List<Ui> getUis() {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            Cursor cursor = null;
            if (db == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                cursor = db.rawQuery("select * from ui limit 1000", null);
                while (cursor != null && cursor.moveToNext()) {
                    Ui ui = new Ui();
                    ui.category = cursor.getString(cursor.getColumnIndex(UiEnum.category.name()));
                    ui.page = cursor.getString(cursor.getColumnIndex(UiEnum.page.name()));
                    ui.startTime = cursor.getLong(cursor.getColumnIndex(UiEnum.startTime.name()));
                    ui.endTime = cursor.getLong(cursor.getColumnIndex(UiEnum.endTime.name()));
                    ui.duration = cursor.getLong(cursor.getColumnIndex(UiEnum.duration.name()));
                    ui.ext = cursor.getString(cursor.getColumnIndex(UiEnum.ext.name()));
                    ui.aliasId = cursor.getLong(cursor.getColumnIndex(UiEnum.aliasId.name()));
                    arrayList.add(ui);
                }
                checkDadabaseMaxCount(db, UiEnum.TABLE_NAME);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "IMTrack getUis error " + e2.getMessage());
                if (cursor != null) {
                    cursor.close();
                }
            }
            db.close();
            return arrayList;
        }
    }

    public void insertAck(Ack ack) {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(AckEnum.type.name(), ack.type);
                contentValues.put(AckEnum.value.name(), ack.value);
                contentValues.put(AckEnum.timestamp.name(), Long.valueOf(ack.timestamp));
                contentValues.put(AckEnum.ext.name(), ack.ext);
                contentValues.put(AckEnum.aliasId.name(), Long.valueOf(ack.aliasId));
                db.insert(AckEnum.TABLE_NAME, null, contentValues);
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "IMTrack insert Ack exception : " + e2);
            }
            db.close();
        }
    }

    public void insertConnection(Connection connection) {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(ConnectionEnum.startTime.name(), Long.valueOf(connection.startTime));
                contentValues.put(ConnectionEnum.stopTime.name(), Long.valueOf(connection.stopTime));
                contentValues.put(ConnectionEnum.reason.name(), connection.reason);
                contentValues.put(ConnectionEnum.retryTime.name(), Long.valueOf(connection.retryTime));
                contentValues.put(ConnectionEnum.retryCount.name(), Long.valueOf(connection.retryCount));
                contentValues.put(ConnectionEnum.ext.name(), connection.ext);
                contentValues.put(ConnectionEnum.aliasId.name(), Long.valueOf(connection.aliasId));
                db.insert("connection", null, contentValues);
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "IMTrack insert Connection exception : " + e2);
            }
            db.close();
        }
    }

    public void insertCrash(Crash crash) {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(CrashEnum.exception.name(), crash.exception);
                contentValues.put(CrashEnum.timestamp.name(), Long.valueOf(crash.timestamp));
                contentValues.put(CrashEnum.ext.name(), crash.ext);
                contentValues.put(CrashEnum.aliasId.name(), Long.valueOf(crash.aliasId));
                db.insert("crash", null, contentValues);
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "IMTrack insert Crash exception : " + e2);
            }
            db.close();
        }
    }

    public void insertDb(Db db) {
        synchronized (myLock) {
            SQLiteDatabase db2 = getDb(this.context);
            if (db2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DbEnum.tableName.name(), db.table);
                contentValues.put(DbEnum.className.name(), db.className);
                contentValues.put(DbEnum.method.name(), db.method);
                contentValues.put(DbEnum.action.name(), db.action);
                contentValues.put(DbEnum.startTime.name(), Long.valueOf(db.startTime));
                contentValues.put(DbEnum.endTime.name(), Long.valueOf(db.endTime));
                contentValues.put(DbEnum.duration.name(), Long.valueOf(db.duration));
                contentValues.put(DbEnum.ext.name(), db.ext);
                contentValues.put(DbEnum.aliasId.name(), Long.valueOf(db.aliasId));
                db2.insert(DbEnum.TABLE_NAME, null, contentValues);
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "IMTrack insert Db exception : " + e2);
            }
            db2.close();
        }
    }

    public void insertMsg(Msg msg) {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(MsgEnum.msgCount.name(), Long.valueOf(msg.msgCount));
                contentValues.put(MsgEnum.roomId.name(), msg.roomId);
                contentValues.put(MsgEnum.duration.name(), Long.valueOf(msg.duration));
                contentValues.put(MsgEnum.startMsgId.name(), Long.valueOf(msg.startMsgId));
                contentValues.put(MsgEnum.endMsgId.name(), Long.valueOf(msg.endMsgId));
                contentValues.put(MsgEnum.ext.name(), msg.ext);
                contentValues.put(MsgEnum.aliasId.name(), Long.valueOf(msg.aliasId));
                db.insert("msg", null, contentValues);
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "IMTrack insert Ack exception : " + e2);
            }
            db.close();
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
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "IMTrack insert Request exception : " + e2);
            }
            db.close();
        }
    }

    public void insertUi(Ui ui) {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(UiEnum.category.name(), ui.category);
                contentValues.put(UiEnum.page.name(), ui.page);
                contentValues.put(UiEnum.startTime.name(), Long.valueOf(ui.startTime));
                contentValues.put(UiEnum.endTime.name(), Long.valueOf(ui.endTime));
                contentValues.put(UiEnum.duration.name(), Long.valueOf(ui.duration));
                contentValues.put(UiEnum.ext.name(), ui.ext);
                contentValues.put(UiEnum.aliasId.name(), Long.valueOf(ui.aliasId));
                db.insert(UiEnum.TABLE_NAME, null, contentValues);
            } catch (Exception e2) {
                String str = TAG;
                LogUtils.e(str, "IMTrack insert ui exception : " + e2);
            }
            db.close();
        }
    }
}
