package com.baidu.android.imsdk.upload.action;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.http.Headers;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.upload.action.track.Ack;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Crash;
import com.baidu.android.imsdk.upload.action.track.Db;
import com.baidu.android.imsdk.upload.action.track.Msg;
import com.baidu.android.imsdk.upload.action.track.Request;
import com.baidu.android.imsdk.upload.action.track.Ui;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class IMTrackDatabase {
    public static final String DB_NAME = "im_track.db";
    private static final int DB_VERSION = 1;
    private static final int MAX_QUERY_COUNT = 1000;
    @SuppressLint({"StaticFieldLeak"})
    private static IMTrackDatabase instance;
    private Context context;
    private static String TAG = "IMTrackDatabase";
    private static DbOpenHelper dbOpenHelper = null;
    public static final Object myLock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum AckEnum {
        ackId,
        type,
        value,
        timestamp,
        ext,
        aliasId;
        
        static final String TABLE_NAME = "ack";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum ConnectionEnum {
        connectionId,
        startTime,
        stopTime,
        reason,
        retryTime,
        retryCount,
        ext,
        aliasId;
        
        static final String TABLE_NAME = "connection";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum CrashEnum {
        crashId,
        exception,
        timestamp,
        ext,
        aliasId;
        
        static final String TABLE_NAME = "crash";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
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
        
        static final String TABLE_NAME = "db";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum MsgEnum {
        msgId,
        msgCount,
        roomId,
        duration,
        startMsgId,
        endMsgId,
        ext,
        aliasId;
        
        static final String TABLE_NAME = "msg";
    }

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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum UiEnum {
        uiId,
        category,
        page,
        startTime,
        endTime,
        duration,
        ext,
        aliasId;
        
        static final String TABLE_NAME = "ui";
    }

    private IMTrackDatabase(Context context) {
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

    public void insertUi(Ui ui) {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db != null) {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(UiEnum.category.name(), ui.category);
                    contentValues.put(UiEnum.page.name(), ui.page);
                    contentValues.put(UiEnum.startTime.name(), Long.valueOf(ui.startTime));
                    contentValues.put(UiEnum.endTime.name(), Long.valueOf(ui.endTime));
                    contentValues.put(UiEnum.duration.name(), Long.valueOf(ui.duration));
                    contentValues.put(UiEnum.ext.name(), ui.ext);
                    contentValues.put(UiEnum.aliasId.name(), Long.valueOf(ui.aliasId));
                    db.insert("ui", null, contentValues);
                    db.close();
                } catch (Exception e) {
                    LogUtils.e(TAG, "IMTrack insert ui exception : " + e);
                    db.close();
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [122=4] */
    public List<Ui> getUis() {
        Throwable th;
        ArrayList arrayList;
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db == null) {
                return null;
            }
            try {
                arrayList = new ArrayList();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                cursor = db.rawQuery("select * from ui limit 1000", null);
                while (cursor != null) {
                    try {
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        Ui ui = new Ui();
                        ui.category = cursor.getString(cursor.getColumnIndex(UiEnum.category.name()));
                        ui.page = cursor.getString(cursor.getColumnIndex(UiEnum.page.name()));
                        ui.startTime = cursor.getLong(cursor.getColumnIndex(UiEnum.startTime.name()));
                        ui.endTime = cursor.getLong(cursor.getColumnIndex(UiEnum.endTime.name()));
                        ui.duration = cursor.getLong(cursor.getColumnIndex(UiEnum.duration.name()));
                        ui.ext = cursor.getString(cursor.getColumnIndex(UiEnum.ext.name()));
                        ui.aliasId = cursor.getLong(cursor.getColumnIndex(UiEnum.aliasId.name()));
                        arrayList.add(ui);
                    } catch (Exception e) {
                        e = e;
                        LogUtils.e(TAG, "IMTrack getUis error " + e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        db.close();
                        return arrayList;
                    }
                }
                checkDadabaseMaxCount(db, "ui");
                if (cursor != null) {
                    cursor.close();
                }
                db.close();
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                    cursor2.close();
                }
                db.close();
                throw th;
            }
            return arrayList;
        }
    }

    public void insertCrash(Crash crash) {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db != null) {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(CrashEnum.exception.name(), crash.exception);
                    contentValues.put(CrashEnum.timestamp.name(), Long.valueOf(crash.timestamp));
                    contentValues.put(CrashEnum.ext.name(), crash.ext);
                    contentValues.put(CrashEnum.aliasId.name(), Long.valueOf(crash.aliasId));
                    db.insert("crash", null, contentValues);
                    db.close();
                } catch (Exception e) {
                    LogUtils.e(TAG, "IMTrack insert Crash exception : " + e);
                    db.close();
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [180=4] */
    public List<Crash> getCrashes() {
        Throwable th;
        ArrayList arrayList;
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db == null) {
                return null;
            }
            try {
                arrayList = new ArrayList();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                cursor = db.rawQuery("select * from crash limit 1000", null);
                while (cursor != null) {
                    try {
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        Crash crash = new Crash();
                        crash.exception = cursor.getString(cursor.getColumnIndex(CrashEnum.exception.name()));
                        crash.timestamp = cursor.getLong(cursor.getColumnIndex(CrashEnum.timestamp.name()));
                        crash.ext = cursor.getString(cursor.getColumnIndex(CrashEnum.ext.name()));
                        crash.aliasId = cursor.getLong(cursor.getColumnIndex(CrashEnum.aliasId.name()));
                        arrayList.add(crash);
                    } catch (Exception e) {
                        e = e;
                        LogUtils.e(TAG, "IMTrack getCrashes error " + e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        db.close();
                        return arrayList;
                    }
                }
                checkDadabaseMaxCount(db, "crash");
                if (cursor != null) {
                    cursor.close();
                }
                db.close();
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                    cursor2.close();
                }
                db.close();
                throw th;
            }
            return arrayList;
        }
    }

    public long getCrashCount() {
        long j;
        Cursor cursor = null;
        synchronized (myLock) {
            j = 0;
            SQLiteDatabase db = getDb(this.context);
            if (db != null) {
                try {
                    cursor = db.rawQuery("select count(*) from crash", null);
                    if (cursor != null && cursor.moveToNext()) {
                        j = cursor.getInt(0);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    db.close();
                } catch (Exception e) {
                    LogUtils.e(TAG, "IMTrack insert Db exception : " + e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    db.close();
                }
            }
        }
        return j;
    }

    public void insertDb(Db db) {
        synchronized (myLock) {
            SQLiteDatabase db2 = getDb(this.context);
            if (db2 != null) {
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
                    db2.insert(BdStatsConstant.OpSubType.DB, null, contentValues);
                    db2.close();
                } catch (Exception e) {
                    LogUtils.e(TAG, "IMTrack insert Db exception : " + e);
                    db2.close();
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [274=4] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fe A[Catch: all -> 0x00f7, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0004, B:6:0x000c, B:8:0x000e, B:25:0x00f0, B:26:0x00f3, B:21:0x00e4, B:19:0x00de, B:20:0x00e1, B:33:0x00fe, B:34:0x0101, B:35:0x0104), top: B:43:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<Db> getDbs() {
        Cursor cursor;
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                cursor = db.rawQuery("select * from db limit 1000", null);
                while (cursor != null) {
                    try {
                        try {
                            if (!cursor.moveToNext()) {
                                break;
                            }
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
                        } catch (Exception e) {
                            e = e;
                            LogUtils.e(TAG, "IMTrack getDbs error " + e.getMessage());
                            if (cursor != null) {
                                cursor.close();
                            }
                            db.close();
                            return arrayList;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        db.close();
                        throw th;
                    }
                }
                checkDadabaseMaxCount(db, BdStatsConstant.OpSubType.DB);
                if (cursor != null) {
                    cursor.close();
                }
                db.close();
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                db.close();
                throw th;
            }
            return arrayList;
        }
    }

    public void insertConnection(Connection connection) {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db != null) {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(ConnectionEnum.startTime.name(), Long.valueOf(connection.startTime));
                    contentValues.put(ConnectionEnum.stopTime.name(), Long.valueOf(connection.stopTime));
                    contentValues.put(ConnectionEnum.reason.name(), connection.reason);
                    contentValues.put(ConnectionEnum.retryTime.name(), Long.valueOf(connection.retryTime));
                    contentValues.put(ConnectionEnum.retryCount.name(), Long.valueOf(connection.retryCount));
                    contentValues.put(ConnectionEnum.ext.name(), connection.ext);
                    contentValues.put(ConnectionEnum.aliasId.name(), Long.valueOf(connection.aliasId));
                    db.insert(Headers.CONN_DIRECTIVE, null, contentValues);
                    db.close();
                } catch (Exception e) {
                    LogUtils.e(TAG, "IMTrack insert Connection exception : " + e);
                    db.close();
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [336=4] */
    public List<Connection> getConnections() {
        Throwable th;
        ArrayList arrayList;
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db == null) {
                return null;
            }
            try {
                arrayList = new ArrayList();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                cursor = db.rawQuery("select * from connection limit 1000", null);
                while (cursor != null) {
                    try {
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        Connection connection = new Connection();
                        connection.startTime = cursor.getLong(cursor.getColumnIndex(ConnectionEnum.startTime.name()));
                        connection.stopTime = cursor.getLong(cursor.getColumnIndex(ConnectionEnum.stopTime.name()));
                        connection.reason = cursor.getString(cursor.getColumnIndex(ConnectionEnum.reason.name()));
                        connection.retryTime = cursor.getLong(cursor.getColumnIndex(ConnectionEnum.retryTime.name()));
                        connection.retryCount = cursor.getLong(cursor.getColumnIndex(ConnectionEnum.retryCount.name()));
                        connection.ext = cursor.getString(cursor.getColumnIndex(ConnectionEnum.ext.name()));
                        connection.aliasId = cursor.getLong(cursor.getColumnIndex(ConnectionEnum.aliasId.name()));
                        arrayList.add(connection);
                    } catch (Exception e) {
                        e = e;
                        LogUtils.e(TAG, "IMTrack getConnections error " + e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        db.close();
                        return arrayList;
                    }
                }
                checkDadabaseMaxCount(db, Headers.CONN_DIRECTIVE);
                if (cursor != null) {
                    cursor.close();
                }
                db.close();
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                    cursor2.close();
                }
                db.close();
                throw th;
            }
            return arrayList;
        }
    }

    public long getConnectionCount() {
        long j;
        Cursor cursor = null;
        synchronized (myLock) {
            j = 0;
            SQLiteDatabase db = getDb(this.context);
            if (db != null) {
                try {
                    cursor = db.rawQuery("select count(*) from connection", null);
                    if (cursor != null && cursor.moveToNext()) {
                        j = cursor.getInt(0);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    db.close();
                } catch (Exception e) {
                    LogUtils.e(TAG, "IMTrack insert Db exception : " + e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    db.close();
                }
            }
        }
        return j;
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
                    db.close();
                } catch (Exception e) {
                    LogUtils.e(TAG, "IMTrack insert Request exception : " + e);
                    db.close();
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [424=4] */
    public List<Request> getRequests() {
        Throwable th;
        ArrayList arrayList;
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db == null) {
                return null;
            }
            try {
                arrayList = new ArrayList();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                cursor = db.rawQuery("select * from request limit 1000", null);
                while (cursor != null) {
                    try {
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        Request request = new Request();
                        request.method = cursor.getString(cursor.getColumnIndex(RequestEnum.method.name()));
                        request.requestId = cursor.getString(cursor.getColumnIndex(RequestEnum.requestId.name()));
                        request.timestamp = cursor.getLong(cursor.getColumnIndex(RequestEnum.timestamp.name()));
                        request.responseTime = cursor.getLong(cursor.getColumnIndex(RequestEnum.responseTime.name()));
                        request.errorCode = cursor.getLong(cursor.getColumnIndex(RequestEnum.errorCode.name()));
                        request.ext = cursor.getString(cursor.getColumnIndex(RequestEnum.ext.name()));
                        request.aliasId = cursor.getLong(cursor.getColumnIndex(RequestEnum.aliasId.name()));
                        arrayList.add(request);
                    } catch (Exception e) {
                        e = e;
                        LogUtils.e(TAG, "IMTrack getRequests error " + e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        db.close();
                        return arrayList;
                    }
                }
                checkDadabaseMaxCount(db, "request");
                if (cursor != null) {
                    cursor.close();
                }
                db.close();
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                    cursor2.close();
                }
                db.close();
                throw th;
            }
            return arrayList;
        }
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
                    LogUtils.e(TAG, "IMTrack insert Db exception : " + e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    db.close();
                }
            }
        }
        return j;
    }

    public void insertAck(Ack ack) {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db != null) {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(AckEnum.type.name(), ack.type);
                    contentValues.put(AckEnum.value.name(), ack.value);
                    contentValues.put(AckEnum.timestamp.name(), Long.valueOf(ack.timestamp));
                    contentValues.put(AckEnum.ext.name(), ack.ext);
                    contentValues.put(AckEnum.aliasId.name(), Long.valueOf(ack.aliasId));
                    db.insert("ack", null, contentValues);
                    db.close();
                } catch (Exception e) {
                    LogUtils.e(TAG, "IMTrack insert Ack exception : " + e);
                    db.close();
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [509=4] */
    public List<Ack> getAcks() {
        Throwable th;
        ArrayList arrayList;
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db == null) {
                return null;
            }
            try {
                arrayList = new ArrayList();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                cursor = db.rawQuery("select * from ack limit 1000", null);
                while (cursor != null) {
                    try {
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        Ack ack = new Ack();
                        ack.type = cursor.getString(cursor.getColumnIndex(AckEnum.type.name()));
                        ack.value = cursor.getString(cursor.getColumnIndex(AckEnum.value.name()));
                        ack.timestamp = cursor.getLong(cursor.getColumnIndex(AckEnum.timestamp.name()));
                        ack.ext = cursor.getString(cursor.getColumnIndex(AckEnum.ext.name()));
                        ack.aliasId = cursor.getLong(cursor.getColumnIndex(AckEnum.aliasId.name()));
                        arrayList.add(ack);
                    } catch (Exception e) {
                        e = e;
                        LogUtils.e(TAG, "IMTrack getAcks error " + e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        db.close();
                        return arrayList;
                    }
                }
                checkDadabaseMaxCount(db, "ack");
                if (cursor != null) {
                    cursor.close();
                }
                db.close();
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                    cursor2.close();
                }
                db.close();
                throw th;
            }
            return arrayList;
        }
    }

    public void insertMsg(Msg msg) {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db != null) {
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
                    db.close();
                } catch (Exception e) {
                    LogUtils.e(TAG, "IMTrack insert Ack exception : " + e);
                    db.close();
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [571=4] */
    public List<Msg> getMsgs() {
        Throwable th;
        ArrayList arrayList;
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db == null) {
                return null;
            }
            try {
                arrayList = new ArrayList();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                cursor = db.rawQuery("select * from msg limit 1000", null);
                while (cursor != null) {
                    try {
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        Msg msg = new Msg();
                        msg.msgCount = cursor.getLong(cursor.getColumnIndex(MsgEnum.msgCount.name()));
                        msg.roomId = cursor.getString(cursor.getColumnIndex(MsgEnum.roomId.name()));
                        msg.duration = cursor.getLong(cursor.getColumnIndex(MsgEnum.duration.name()));
                        msg.startMsgId = cursor.getLong(cursor.getColumnIndex(MsgEnum.startMsgId.name()));
                        msg.endMsgId = cursor.getLong(cursor.getColumnIndex(MsgEnum.endMsgId.name()));
                        msg.ext = cursor.getString(cursor.getColumnIndex(MsgEnum.ext.name()));
                        msg.aliasId = cursor.getLong(cursor.getColumnIndex(MsgEnum.aliasId.name()));
                        arrayList.add(msg);
                    } catch (Exception e) {
                        e = e;
                        LogUtils.e(TAG, "IMTrack getMsgs error " + e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        db.close();
                        return arrayList;
                    }
                }
                checkDadabaseMaxCount(db, "msg");
                if (cursor != null) {
                    cursor.close();
                }
                db.close();
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                    cursor2.close();
                }
                db.close();
                throw th;
            }
            return arrayList;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE] complete} */
    @Nullable
    private void checkDadabaseMaxCount(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.rawQuery("select count(*) from " + str, null);
                if (cursor != null && cursor.moveToFirst() && cursor.getInt(0) > 1000) {
                    sQLiteDatabase.delete(str, null, null);
                }
                if (cursor != null) {
                    cursor.close();
                }
                sQLiteDatabase.close();
            } catch (Exception e) {
                e.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                sQLiteDatabase.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            sQLiteDatabase.close();
            throw th;
        }
    }

    public void clearAllTables() {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db != null) {
                try {
                    db.delete("ui", null, null);
                    db.delete("crash", null, null);
                    db.delete(BdStatsConstant.OpSubType.DB, null, null);
                    db.delete(Headers.CONN_DIRECTIVE, null, null);
                    db.delete("request", null, null);
                    db.delete("ack", null, null);
                    db.delete("msg", null, null);
                    db.close();
                } catch (Exception e) {
                    LogUtils.e(TAG, "IMTrack clearAllTables Exception: " + e);
                    db.close();
                }
            }
        }
    }

    public void clearCrashTable() {
        synchronized (myLock) {
            SQLiteDatabase db = getDb(this.context);
            if (db != null) {
                try {
                    db.delete("crash", null, null);
                    db.close();
                } catch (Exception e) {
                    LogUtils.e(TAG, "IMTrack clearCrashTable Exception: " + e);
                    db.close();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class DbOpenHelper extends SQLiteOpenHelper {
        private Context context;
        private static final String SQL_TABLE_CREATE_UI = "CREATE TABLE ui (" + UiEnum.uiId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + UiEnum.category.name() + " TEXT, " + UiEnum.page.name() + " TEXT, " + UiEnum.startTime.name() + " LONG, " + UiEnum.endTime.name() + " LONG, " + UiEnum.duration.name() + " LONG, " + UiEnum.ext.name() + " TEXT, " + UiEnum.aliasId.name() + " LONG NOT NULL );";
        private static final String SQL_TABLE_CREATE_CRASH = "CREATE TABLE crash (" + CrashEnum.crashId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CrashEnum.exception.name() + " TEXT, " + CrashEnum.timestamp.name() + " LONG, " + CrashEnum.ext.name() + " TEXT, " + CrashEnum.aliasId.name() + " LONG NOT NULL );";
        private static final String SQL_TABLE_CREATE_DB = "CREATE TABLE db (" + DbEnum.dbId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DbEnum.tableName.name() + " TEXT, " + DbEnum.className.name() + " TEXT, " + DbEnum.method.name() + " TEXT, " + DbEnum.action.name() + " TEXT, " + DbEnum.startTime.name() + " LONG, " + DbEnum.endTime.name() + " LONG, " + DbEnum.duration.name() + " LONG, " + DbEnum.ext.name() + " TEXT, " + DbEnum.aliasId.name() + " LONG NOT NULL );";
        private static final String SQL_TABLE_CREATE_CONNECTION = "CREATE TABLE connection (" + ConnectionEnum.connectionId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ConnectionEnum.startTime.name() + " LONG, " + ConnectionEnum.stopTime.name() + " LONG, " + ConnectionEnum.reason.name() + " TEXT, " + ConnectionEnum.retryTime.name() + " LONG, " + ConnectionEnum.retryCount.name() + " LONG, " + ConnectionEnum.ext.name() + " TEXT, " + ConnectionEnum.aliasId.name() + " LONG NOT NULL );";
        private static final String SQL_TABLE_CREATE_REQUEST = "CREATE TABLE request (" + RequestEnum.id.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + RequestEnum.method.name() + " TEXT, " + RequestEnum.requestId.name() + " TEXT, " + RequestEnum.timestamp.name() + " LONG, " + RequestEnum.responseTime.name() + " LONG, " + RequestEnum.errorCode.name() + " LONG, " + RequestEnum.ext.name() + " TEXT, " + RequestEnum.aliasId.name() + " LONG NOT NULL);";
        private static final String SQL_TABLE_CREATE_ACK = "CREATE TABLE ack (" + AckEnum.ackId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + AckEnum.type.name() + " TEXT, " + AckEnum.value.name() + " TEXT, " + AckEnum.timestamp.name() + " LONG, " + AckEnum.ext.name() + " TEXT, " + AckEnum.aliasId.name() + " LONG NOT NULL);";
        private static final String SQL_TABLE_CREATE_MESSAGE = "CREATE TABLE msg (" + MsgEnum.msgId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + MsgEnum.msgCount.name() + " LONG, " + MsgEnum.roomId.name() + " TEXT, " + MsgEnum.duration.name() + " LONG, " + MsgEnum.startMsgId.name() + " LONG, " + MsgEnum.endMsgId.name() + " LONG, " + MsgEnum.ext.name() + " TEXT, " + MsgEnum.aliasId.name() + " LONG NOT NULL);";

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
                sQLiteDatabase.execSQL(SQL_TABLE_CREATE_UI);
                sQLiteDatabase.execSQL(SQL_TABLE_CREATE_CRASH);
                sQLiteDatabase.execSQL(SQL_TABLE_CREATE_DB);
                sQLiteDatabase.execSQL(SQL_TABLE_CREATE_CONNECTION);
                sQLiteDatabase.execSQL(SQL_TABLE_CREATE_REQUEST);
                sQLiteDatabase.execSQL(SQL_TABLE_CREATE_ACK);
                sQLiteDatabase.execSQL(SQL_TABLE_CREATE_MESSAGE);
            } catch (Exception e) {
                LogUtils.d(IMTrackDatabase.TAG, "DbOpenHelper onCreate E: " + e);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            dropTables(sQLiteDatabase);
            onCreate(sQLiteDatabase);
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
            } catch (Exception e) {
                LogUtils.d(IMTrackDatabase.TAG, "dropTables Exception: " + e);
            }
        }
    }
}
