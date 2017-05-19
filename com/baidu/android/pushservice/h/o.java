package com.baidu.android.pushservice.h;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class o {
    private static f a = null;
    private static e b = null;
    private static Object c = new Object();
    private static int d = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum a {
        actionId,
        actionName,
        timeStamp,
        networkStatus,
        msgType,
        msgId,
        msgLen,
        advertiseStyle,
        errorCode,
        appid,
        actionType
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum b {
        alarmMsgInfoId,
        msgId,
        sendtime,
        showtime,
        expiretime,
        msgEnable,
        isAlarm
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum c {
        appInfoId,
        appid,
        appType,
        rsaUserId,
        userId,
        packageName,
        appName,
        cFrom,
        versionCode,
        versionName,
        intergratedPushVersion
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum d {
        actionId,
        actionName,
        timeStamp,
        networkStatus,
        msgType,
        msgId,
        msgLen,
        errorMsg,
        requestId,
        stableHeartInterval,
        errorCode,
        appid,
        channel,
        openByPackageName
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class e implements DatabaseErrorHandler {
        private e() {
        }

        private void a(String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            com.baidu.android.pushservice.e.a.e("PushDatabase", "deleting the database file: " + str);
            try {
                if (Build.VERSION.SDK_INT > 18) {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } else {
                    new File(str).delete();
                }
            } catch (Exception e) {
                com.baidu.android.pushservice.e.a.d("PushDatabase", "delete failed: " + e.getMessage());
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
        @Override // android.database.DatabaseErrorHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
            List<Pair<String, String>> list;
            Throwable th;
            com.baidu.android.pushservice.e.a.e("PushDatabase", "Corruption reported by sqlite on database: " + sQLiteDatabase.getPath());
            if (!sQLiteDatabase.isOpen()) {
                a(sQLiteDatabase.getPath());
                return;
            }
            List<Pair<String, String>> list2 = null;
            try {
                list2 = sQLiteDatabase.getAttachedDbs();
            } catch (SQLiteException e) {
            } catch (Throwable th2) {
                list = null;
                th = th2;
                if (list == null) {
                    for (Pair<String, String> pair : list) {
                        a((String) pair.second);
                    }
                } else {
                    a(sQLiteDatabase.getPath());
                }
                throw th;
            }
            try {
                sQLiteDatabase.close();
            } catch (SQLiteException e2) {
            } catch (Throwable th3) {
                list = list2;
                th = th3;
                if (list == null) {
                }
                throw th;
            }
            if (list2 == null) {
                a(sQLiteDatabase.getPath());
                return;
            }
            for (Pair<String, String> pair2 : list2) {
                a((String) pair2.second);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class f extends SQLiteOpenHelper {
        public f(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        }

        public f(Context context, String str, int i, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i, databaseErrorHandler);
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS MsgResultInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS StatisticsInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS FileDownloadingInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushBehavior");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS AppInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS AlarmMsgInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS LappMsgInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS NoDisturb");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ADPushBehavior");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS MsgInfo");
            } catch (Exception e) {
                com.baidu.android.pushservice.e.a.c("PushDatabase", "dropTables Exception: " + e);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS MsgResultInfo");
                sQLiteDatabase.execSQL("CREATE TABLE StatisticsInfo (" + k.info_id.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + k.packageName.name() + " TEXT NOT NULL, " + k.open_type.name() + " TEXT NOT NULL, " + k.msgid.name() + " TEXT, " + k.app_open_time.name() + " TEXT NOT NULL, " + k.app_close_time.name() + " TEXT NOT NULL, " + k.use_duration.name() + " TEXT NOT NULL, " + k.extra.name() + " TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE PushBehavior (" + d.actionId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.actionName.name() + " TEXT NOT NULL, " + d.timeStamp.name() + " LONG  NOT NULL, " + d.networkStatus.name() + " TEXT, " + d.msgType.name() + " INTEGER, " + d.msgId.name() + " TEXT, " + d.msgLen.name() + " INTEGER, " + d.errorMsg.name() + " TEXT, " + d.requestId.name() + " TEXT, " + d.stableHeartInterval.name() + " INTEGER, " + d.errorCode.name() + " INTEGER, " + d.appid.name() + " TEXT, " + d.channel.name() + " TEXT, " + d.openByPackageName.name() + " Text);");
                sQLiteDatabase.execSQL("CREATE TABLE ADPushBehavior (" + a.actionId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + a.actionName.name() + " TEXT NOT NULL, " + a.timeStamp.name() + " LONG  NOT NULL, " + a.networkStatus.name() + " TEXT, " + a.msgType.name() + " INTEGER, " + a.msgId.name() + " TEXT, " + a.msgLen.name() + " INTEGER, " + a.advertiseStyle.name() + " TEXT, " + a.errorCode.name() + " INTEGER, " + a.appid.name() + " TEXT, " + a.actionType.name() + " TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE MsgInfo (" + i.MsgInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + i.msgId.name() + " TEXT NOT NULL, " + i.timeStamp.name() + " LONG NOT NULL);");
                sQLiteDatabase.execSQL("CREATE TABLE AlarmMsgInfo (" + b.alarmMsgInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + b.msgId.name() + " TEXT NOT NULL, " + b.sendtime.name() + " LONG NOT NULL, " + b.showtime.name() + " LONG NOT NULL, " + b.expiretime.name() + " LONG NOT NULL, " + b.msgEnable.name() + " INTEGER, " + b.isAlarm.name() + " INTEGER);");
                sQLiteDatabase.execSQL("CREATE TABLE AppInfo (" + c.appInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.appid.name() + " TEXT UNIQUE, " + c.appType.name() + " INTEGER, " + c.rsaUserId.name() + " TEXT, " + c.userId.name() + " TEXT, " + c.packageName.name() + " TEXT, " + c.appName.name() + " TEXT, " + c.cFrom.name() + " TEXT, " + c.versionCode.name() + " TEXT, " + c.versionName.name() + " TEXT, " + c.intergratedPushVersion.name() + " TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE FileDownloadingInfo (" + g.belongTo.name() + " TEXT, " + g.downloadUrl.name() + " TEXT PRIMARY KEY, " + g.savePath.name() + " TEXT NOT NULL, " + g.title.name() + " TEXT, " + g.description.name() + " TEXT, " + g.fileName.name() + " TEXT NOT NULL, " + g.downloadBytes.name() + " INTEGER NOT NULL, " + g.totalBytes.name() + " INTEGER NOT NULL, " + g.downloadStatus.name() + " INTEGER NOT NULL," + g.timeStamp.name() + " INTEGER NOT NULL);");
                sQLiteDatabase.execSQL("CREATE TABLE NoDisturb (" + j.pkgName.name() + " TEXT NOT NULL, " + j.startHour.name() + " INTEGER, " + j.startMinute.name() + " INTEGER, " + j.endHour.name() + " INTEGER, " + j.endMinute.name() + " INTEGER);");
            } catch (Exception e) {
                com.baidu.android.pushservice.e.a.c("PushDatabase", "DbOpenHelper onCreate E: " + e);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            a(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum g {
        belongTo,
        downloadUrl,
        title,
        description,
        savePath,
        fileName,
        downloadBytes,
        totalBytes,
        downloadStatus,
        timeStamp
    }

    /* loaded from: classes2.dex */
    public static class h {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public int g;
        public int h;
        public int i;
        public long j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum i {
        MsgInfoId,
        msgId,
        timeStamp
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum j {
        pkgName,
        startHour,
        startMinute,
        endHour,
        endMinute
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum k {
        info_id,
        packageName,
        open_type,
        msgid,
        app_open_time,
        app_close_time,
        use_duration,
        extra
    }

    public static int a(Context context, long j2, long j3) {
        int i2;
        Cursor cursor = null;
        int i3 = 0;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 != null) {
                String str = "SELECT COUNT(*) FROM ADPushBehavior WHERE " + a.timeStamp.name() + " < " + j2 + " AND " + a.timeStamp.name() + " >= " + j3 + " ;";
                try {
                    cursor = e2.rawQuery("SELECT COUNT(*) FROM PushBehavior WHERE " + d.timeStamp.name() + " < " + j2 + " AND " + d.timeStamp.name() + " >= " + j3 + " ;", null);
                    cursor.moveToFirst();
                    int i4 = cursor.getInt(0);
                    if (cursor != null) {
                        cursor.close();
                        i2 = i4;
                    } else {
                        i2 = i4;
                    }
                } catch (Exception e3) {
                    com.baidu.android.pushservice.e.a.c("PushDatabase", "e getBehaviorEnumCount" + e3.getMessage());
                    if (cursor != null) {
                        cursor.close();
                        i2 = 0;
                    } else {
                        i2 = 0;
                    }
                }
                try {
                    cursor = e2.rawQuery(str, null);
                    cursor.moveToFirst();
                    i3 = cursor.getInt(0);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (e2 != null) {
                        e2.close();
                    }
                } catch (Exception e4) {
                    com.baidu.android.pushservice.e.a.c("PushDatabase", "e getBehaviorEnumCount 2" + e4.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (e2 != null) {
                        e2.close();
                    }
                }
                i3 += i2;
            }
        }
        return i3;
    }

    public static int a(Context context, String str, int i2) {
        Cursor cursor;
        int i3;
        Cursor cursor2 = null;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            try {
                if (e2 == null) {
                    return -1;
                }
                try {
                    cursor = e2.query("AlarmMsgInfo", null, b.msgId.name() + " = " + str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null, null, null, null);
                    try {
                    } catch (Exception e3) {
                        e = e3;
                        com.baidu.android.pushservice.e.a.a("PushDatabase", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (e2 != null) {
                            e2.close();
                            i3 = -3;
                        } else {
                            i3 = -3;
                        }
                        return i3;
                    }
                } catch (Exception e4) {
                    e = e4;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        cursor2.close();
                    }
                    if (e2 != null) {
                        e2.close();
                    }
                    throw th;
                }
                if (cursor == null) {
                    com.baidu.android.pushservice.e.a.d("PushDatabase", "no msgid info table!!");
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (e2 != null) {
                        e2.close();
                    }
                    return -2;
                }
                if (cursor.getCount() > 0) {
                    e2.execSQL("UPDATE AlarmMsgInfo SET " + b.msgEnable.name() + " = " + i2 + " WHERE " + b.msgId + " = " + str);
                    com.baidu.android.pushservice.e.a.c("PushDatabase", "setAlarmMsgEnable  msgID = " + str + "  enable = " + i2);
                }
                if (cursor != null) {
                    cursor.close();
                }
                if (e2 != null) {
                    e2.close();
                    i3 = 0;
                } else {
                    i3 = 0;
                }
                return i3;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static int a(Context context, String str, h hVar) {
        int i2 = 0;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 != null) {
                String[] strArr = {str};
                ContentValues contentValues = new ContentValues();
                contentValues.put(g.belongTo.name(), hVar.a);
                contentValues.put(g.downloadUrl.name(), hVar.b);
                contentValues.put(g.title.name(), hVar.c);
                contentValues.put(g.description.name(), hVar.d);
                contentValues.put(g.savePath.name(), hVar.e);
                contentValues.put(g.fileName.name(), hVar.f);
                contentValues.put(g.downloadBytes.name(), Integer.valueOf(hVar.g));
                contentValues.put(g.totalBytes.name(), Integer.valueOf(hVar.h));
                contentValues.put(g.downloadStatus.name(), Integer.valueOf(hVar.i));
                contentValues.put(g.timeStamp.name(), Long.valueOf(System.currentTimeMillis()));
                try {
                    i2 = e2.update("FileDownloadingInfo", contentValues, g.downloadUrl.name() + "=?", strArr);
                } catch (Exception e3) {
                    com.baidu.android.pushservice.e.a.e("PushDatabase", "updateFileDownloadingInfo Exception: " + e3);
                    i2 = -1;
                }
                e2.close();
            }
        }
        return i2;
    }

    private static int a(SQLiteDatabase sQLiteDatabase, int i2, com.baidu.android.pushservice.f.i iVar) {
        if (sQLiteDatabase == null) {
            return 0;
        }
        String[] strArr = {"" + i2};
        ContentValues contentValues = new ContentValues();
        contentValues.put(c.appInfoId.name(), Integer.valueOf(i2));
        contentValues.put(c.appid.name(), iVar.a());
        contentValues.put(c.appType.name(), Integer.valueOf(iVar.j()));
        contentValues.put(c.rsaUserId.name(), iVar.b());
        contentValues.put(c.userId.name(), iVar.c());
        contentValues.put(c.packageName.name(), iVar.d());
        contentValues.put(c.appName.name(), iVar.e());
        if (!TextUtils.isEmpty(iVar.f())) {
            contentValues.put(c.cFrom.name(), iVar.f());
        }
        contentValues.put(c.versionCode.name(), Integer.valueOf(iVar.g()));
        contentValues.put(c.versionName.name(), iVar.h());
        contentValues.put(c.intergratedPushVersion.name(), Integer.valueOf(iVar.i()));
        try {
            return sQLiteDatabase.update("AppInfo", contentValues, c.appInfoId.name() + "=?", strArr);
        } catch (Exception e2) {
            com.baidu.android.pushservice.e.a.e("PushDatabase", "updateAppInfo exception " + e2);
            return -1;
        }
    }

    public static long a(Context context, com.baidu.android.pushservice.f.a aVar) {
        long j2;
        Exception e2;
        long j3 = -1;
        synchronized (c) {
            SQLiteDatabase e3 = e(context);
            if (e3 != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(b.msgId.name(), aVar.a);
                contentValues.put(b.sendtime.name(), Long.valueOf(aVar.b));
                contentValues.put(b.showtime.name(), Long.valueOf(aVar.c));
                contentValues.put(b.expiretime.name(), Long.valueOf(aVar.d));
                contentValues.put(b.isAlarm.name(), Integer.valueOf(aVar.e));
                contentValues.put(b.msgEnable.name(), Integer.valueOf(aVar.f));
                try {
                    j2 = e3.insert("AlarmMsgInfo", null, contentValues);
                    try {
                        com.baidu.android.pushservice.e.a.c("PushDatabase", "AlarmMsgInfoEnum:  insert into database");
                        u.b("AlarmMsgInfoEnum:  insert into database", context);
                        j3 = j2;
                    } catch (Exception e4) {
                        e2 = e4;
                        com.baidu.android.pushservice.e.a.a("PushDatabase", e2);
                        j3 = j2;
                        e3.close();
                        return j3;
                    }
                } catch (Exception e5) {
                    j2 = -1;
                    e2 = e5;
                }
                e3.close();
            }
        }
        return j3;
    }

    public static long a(Context context, com.baidu.android.pushservice.f.b bVar) {
        long j2;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                j2 = -1;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(d.actionName.name(), bVar.d);
                contentValues.put(d.timeStamp.name(), Long.valueOf(bVar.e));
                contentValues.put(d.networkStatus.name(), bVar.f);
                contentValues.put(d.appid.name(), bVar.h);
                contentValues.put(d.errorMsg.name(), bVar.a);
                contentValues.put(d.requestId.name(), bVar.b);
                contentValues.put(d.errorCode.name(), Integer.valueOf(bVar.g));
                if (bVar.c != null) {
                    contentValues.put(d.channel.name(), bVar.c);
                }
                try {
                    j2 = e2.insert("PushBehavior", null, contentValues);
                } catch (Exception e3) {
                    com.baidu.android.pushservice.e.a.e("PushDatabase", "insertApiBehavior E: " + e3);
                    j2 = 0;
                }
                e2.close();
            }
        }
        return j2;
    }

    public static long a(Context context, com.baidu.android.pushservice.f.f fVar) {
        long j2;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                j2 = -1;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(d.actionName.name(), fVar.d);
                contentValues.put(d.timeStamp.name(), Long.valueOf(fVar.e));
                contentValues.put(d.networkStatus.name(), fVar.f);
                contentValues.put(d.errorMsg.name(), fVar.a);
                contentValues.put(d.appid.name(), fVar.h);
                try {
                    j2 = e2.insert("PushBehavior", null, contentValues);
                } catch (Exception e3) {
                    com.baidu.android.pushservice.e.a.e("PushDatabase", "insertCrashBehavior E: " + e3);
                    j2 = 0;
                }
                e2.close();
            }
        }
        return j2;
    }

    public static long a(Context context, com.baidu.android.pushservice.f.h hVar) {
        long j2;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                j2 = -1;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(d.actionName.name(), hVar.d);
                contentValues.put(d.timeStamp.name(), Long.valueOf(hVar.e));
                contentValues.put(d.networkStatus.name(), hVar.f);
                contentValues.put(d.errorMsg.name(), hVar.j);
                contentValues.put(d.stableHeartInterval.name(), Integer.valueOf(hVar.a));
                contentValues.put(d.errorCode.name(), Integer.valueOf(hVar.g));
                contentValues.put(d.appid.name(), hVar.h);
                try {
                    j2 = e2.insert("PushBehavior", null, contentValues);
                } catch (Exception e3) {
                    com.baidu.android.pushservice.e.a.e("PushDatabase", "insertPromptBehavior E: " + e3);
                    j2 = 0;
                }
                e2.close();
            }
        }
        return j2;
    }

    public static long a(Context context, com.baidu.android.pushservice.f.i iVar) {
        long j2 = 0;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                j2 = -1;
            } else if (a(e2, iVar) != null) {
                e2.close();
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(c.appid.name(), iVar.a());
                contentValues.put(c.appType.name(), Integer.valueOf(iVar.j()));
                contentValues.put(c.rsaUserId.name(), iVar.b());
                contentValues.put(c.userId.name(), iVar.c());
                contentValues.put(c.packageName.name(), iVar.d());
                contentValues.put(c.appName.name(), iVar.e());
                contentValues.put(c.cFrom.name(), iVar.f());
                contentValues.put(c.versionCode.name(), Integer.valueOf(iVar.g()));
                contentValues.put(c.versionName.name(), iVar.h());
                contentValues.put(c.intergratedPushVersion.name(), Integer.valueOf(iVar.i()));
                try {
                } catch (Exception e3) {
                    com.baidu.android.pushservice.e.a.e("PushDatabase", "insertAppInfo E: " + e3);
                }
                if (Long.valueOf(iVar.a()).longValue() < 0) {
                    e2.close();
                } else {
                    j2 = e2.insert("AppInfo", null, contentValues);
                    e2.close();
                }
            }
        }
        return j2;
    }

    public static long a(Context context, com.baidu.android.pushservice.f.j jVar) {
        long j2 = -1;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(d.actionName.name(), jVar.d);
                contentValues.put(d.timeStamp.name(), Long.valueOf(jVar.e));
                contentValues.put(d.networkStatus.name(), jVar.f);
                if (jVar.h != null) {
                    contentValues.put(d.appid.name(), jVar.h);
                }
                contentValues.put(d.msgType.name(), Integer.valueOf(jVar.c));
                contentValues.put(d.msgId.name(), jVar.a);
                contentValues.put(d.msgLen.name(), Integer.valueOf(jVar.b));
                contentValues.put(d.errorCode.name(), Integer.valueOf(jVar.g));
                if (jVar.k != null) {
                    contentValues.put(d.openByPackageName.name(), jVar.k);
                }
                try {
                    j2 = e2.insert("PushBehavior", null, contentValues);
                } catch (Exception e3) {
                    com.baidu.android.pushservice.e.a.e("PushDatabase", "exception " + e3);
                }
                e2.close();
            }
        }
        return j2;
    }

    public static long a(Context context, h hVar) {
        long j2;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                j2 = -1;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(g.belongTo.name(), hVar.a);
                contentValues.put(g.downloadUrl.name(), hVar.b);
                contentValues.put(g.title.name(), hVar.c);
                contentValues.put(g.description.name(), hVar.d);
                contentValues.put(g.savePath.name(), hVar.e);
                contentValues.put(g.fileName.name(), hVar.f);
                contentValues.put(g.downloadBytes.name(), Integer.valueOf(hVar.g));
                contentValues.put(g.totalBytes.name(), Integer.valueOf(hVar.h));
                contentValues.put(g.downloadStatus.name(), Integer.valueOf(hVar.i));
                contentValues.put(g.timeStamp.name(), Long.valueOf(System.currentTimeMillis()));
                try {
                    j2 = e2.insert("FileDownloadingInfo", null, contentValues);
                } catch (Exception e3) {
                    com.baidu.android.pushservice.e.a.e("PushDatabase", "exception " + e3);
                    j2 = 0;
                }
                e2.close();
            }
        }
        return j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x01b9 A[Catch: all -> 0x012c, TryCatch #4 {, blocks: (B:5:0x0005, B:7:0x000b, B:24:0x0120, B:26:0x0125, B:27:0x0129, B:45:0x01b9, B:47:0x01be, B:48:0x01c1, B:39:0x01aa, B:41:0x01af), top: B:57:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01be A[Catch: all -> 0x012c, TryCatch #4 {, blocks: (B:5:0x0005, B:7:0x000b, B:24:0x0120, B:26:0x0125, B:27:0x0129, B:45:0x01b9, B:47:0x01be, B:48:0x01c1, B:39:0x01aa, B:41:0x01af), top: B:57:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a(Context context, String str, int i2, int i3, int i4, int i5) {
        Cursor cursor;
        long j2;
        synchronized (c) {
            long j3 = -1;
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                return -1L;
            }
            Cursor cursor2 = null;
            try {
                try {
                    com.baidu.android.pushservice.e.a.c("PushDatabase", "package name: " + str + " setNoDisturbMode -- startHour: " + i2 + " startMinute: " + i3 + " endHour: " + i4 + " endMinute: " + i5);
                    cursor = e2.query("NoDisturb", new String[]{j.pkgName.name()}, j.pkgName.name() + "= ?", new String[]{str}, null, null, null);
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(j.pkgName.name(), str);
                        contentValues.put(j.startHour.name(), Integer.valueOf(i2));
                        contentValues.put(j.startMinute.name(), Integer.valueOf(i3));
                        contentValues.put(j.endHour.name(), Integer.valueOf(i4));
                        contentValues.put(j.endMinute.name(), Integer.valueOf(i5));
                        if (cursor == null || !cursor.moveToNext()) {
                            com.baidu.android.pushservice.e.a.c("PushDatabase", "add No Disturb record for " + str);
                            j3 = e2.insert("NoDisturb", null, contentValues);
                        } else if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
                            com.baidu.android.pushservice.e.a.c("PushDatabase", "delete No Disturb record for " + str);
                            j3 = e2.delete("NoDisturb", j.pkgName.name() + "= ?", new String[]{str});
                        } else {
                            com.baidu.android.pushservice.e.a.c("PushDatabase", "update No Disturb record for " + str);
                            j3 = e2.update("NoDisturb", contentValues, j.pkgName.name() + "= ?", new String[]{str});
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        com.baidu.android.pushservice.e.a.e("PushDatabase", "setNoDisturbMode Exception: " + e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (e2 != null) {
                            e2.close();
                            j2 = j3;
                            return j2;
                        }
                        j2 = j3;
                        return j2;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        cursor2.close();
                    }
                    if (e2 != null) {
                        e2.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                }
                if (e2 != null) {
                }
                throw th;
            }
            if (e2 != null) {
                e2.close();
                j2 = j3;
                return j2;
            }
            j2 = j3;
            return j2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.baidu.android.pushservice.f.i a(SQLiteDatabase sQLiteDatabase, com.baidu.android.pushservice.f.i iVar) {
        Cursor cursor;
        Throwable th;
        if (sQLiteDatabase == null) {
            return null;
        }
        com.baidu.android.pushservice.f.i iVar2 = new com.baidu.android.pushservice.f.i(iVar.a());
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT * FROM AppInfo WHERE " + c.appid.name() + " = " + iVar.a() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null);
            boolean z = false;
            try {
                try {
                    if (cursor.moveToNext()) {
                        z = true;
                        int i2 = cursor.getInt(cursor.getColumnIndex(c.appInfoId.name()));
                        if (!TextUtils.equals(iVar.c(), cursor.getString(cursor.getColumnIndex(c.userId.name()))) || !TextUtils.equals(iVar.f(), cursor.getString(cursor.getColumnIndex(c.cFrom.name()))) || !TextUtils.equals(iVar.g() + "", cursor.getInt(cursor.getColumnIndex(c.versionCode.name())) + "") || !TextUtils.equals(iVar.i() + "", cursor.getString(cursor.getColumnIndex(c.intergratedPushVersion.name())))) {
                            a(sQLiteDatabase, i2, iVar);
                        }
                    }
                    if (z) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        return iVar2;
                    } else if (cursor != null) {
                        cursor.close();
                        return null;
                    } else {
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    com.baidu.android.pushservice.e.a.c("PushDatabase", "needToInsertUpdate Exception: " + e);
                    if (cursor != null) {
                        cursor.close();
                        return null;
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            if (cursor != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0116 A[Catch: all -> 0x00fc, TryCatch #5 {, blocks: (B:4:0x0004, B:6:0x000a, B:9:0x000d, B:17:0x00f0, B:19:0x00f5, B:20:0x00f9, B:29:0x0108, B:31:0x010d, B:35:0x0116, B:37:0x011b, B:38:0x011e), top: B:56:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011b A[Catch: all -> 0x00fc, TryCatch #5 {, blocks: (B:4:0x0004, B:6:0x000a, B:9:0x000d, B:17:0x00f0, B:19:0x00f5, B:20:0x00f9, B:29:0x0108, B:31:0x010d, B:35:0x0116, B:37:0x011b, B:38:0x011e), top: B:56:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static h a(Context context, String str) {
        Cursor cursor;
        h hVar;
        h hVar2;
        h hVar3;
        Cursor cursor2 = null;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                return null;
            }
            try {
                cursor = e2.query("FileDownloadingInfo", null, "(" + g.downloadUrl.name() + "==?)", new String[]{str}, null, null, null);
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            h hVar4 = new h();
                            try {
                                hVar4.a = cursor.getString(cursor.getColumnIndex(g.belongTo.name()));
                                hVar4.b = cursor.getString(cursor.getColumnIndex(g.downloadUrl.name()));
                                hVar4.c = cursor.getString(cursor.getColumnIndex(g.title.name()));
                                hVar4.d = cursor.getString(cursor.getColumnIndex(g.description.name()));
                                hVar4.e = cursor.getString(cursor.getColumnIndex(g.savePath.name()));
                                hVar4.f = cursor.getString(cursor.getColumnIndex(g.fileName.name()));
                                hVar4.g = cursor.getInt(cursor.getColumnIndex(g.downloadBytes.name()));
                                hVar4.h = cursor.getInt(cursor.getColumnIndex(g.totalBytes.name()));
                                hVar4.i = cursor.getInt(cursor.getColumnIndex(g.downloadStatus.name()));
                                hVar4.j = cursor.getLong(cursor.getColumnIndex(g.timeStamp.name()));
                                hVar3 = hVar4;
                            } catch (Exception e3) {
                                e = e3;
                                cursor2 = cursor;
                                hVar = hVar4;
                                try {
                                    com.baidu.android.pushservice.e.a.a("PushDatabase", e);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (e2 != null) {
                                        e2.close();
                                        hVar2 = hVar;
                                    } else {
                                        hVar2 = hVar;
                                    }
                                    return hVar2;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor = cursor2;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (e2 != null) {
                                        e2.close();
                                    }
                                    throw th;
                                }
                            }
                        } else {
                            hVar3 = null;
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (e2 != null) {
                            e2.close();
                            hVar2 = hVar3;
                        } else {
                            hVar2 = hVar3;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        hVar = null;
                        cursor2 = cursor;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    if (e2 != null) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                hVar = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
            return hVar2;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x0102 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f9 A[Catch: all -> 0x00f1, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000a, B:8:0x000c, B:24:0x00e8, B:21:0x00e2, B:26:0x00ed, B:18:0x00da, B:20:0x00df, B:33:0x00f9, B:35:0x00fe, B:36:0x0101), top: B:41:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fe A[Catch: all -> 0x00f1, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000a, B:8:0x000c, B:24:0x00e8, B:21:0x00e2, B:26:0x00ed, B:18:0x00da, B:20:0x00df, B:33:0x00f9, B:35:0x00fe, B:36:0x0101), top: B:41:0x0004 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<com.baidu.android.pushservice.f.i> a(Context context) {
        Throwable th;
        Cursor cursor;
        Exception e2;
        synchronized (c) {
            SQLiteDatabase e3 = e(context);
            if (e3 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ?? r2 = "SELECT * FROM AppInfo;";
            try {
                try {
                    cursor = e3.rawQuery("SELECT * FROM AppInfo;", null);
                    while (cursor.moveToNext()) {
                        try {
                            com.baidu.android.pushservice.f.i iVar = new com.baidu.android.pushservice.f.i();
                            iVar.a(cursor.getString(cursor.getColumnIndex(c.appid.name())));
                            iVar.c(cursor.getInt(cursor.getColumnIndex(c.appType.name())));
                            iVar.b(cursor.getString(cursor.getColumnIndex(c.rsaUserId.name())));
                            iVar.c(cursor.getString(cursor.getColumnIndex(c.userId.name())));
                            iVar.d(cursor.getString(cursor.getColumnIndex(c.packageName.name())));
                            iVar.e(cursor.getString(cursor.getColumnIndex(c.appName.name())));
                            iVar.f(cursor.getString(cursor.getColumnIndex(c.cFrom.name())));
                            iVar.a(cursor.getInt(cursor.getColumnIndex(c.versionCode.name())));
                            iVar.g(cursor.getString(cursor.getColumnIndex(c.versionName.name())));
                            iVar.b(cursor.getInt(cursor.getColumnIndex(c.intergratedPushVersion.name())));
                            arrayList.add(iVar);
                        } catch (Exception e4) {
                            e2 = e4;
                            com.baidu.android.pushservice.e.a.a("PushDatabase", e2);
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (e3 != null) {
                                e3.close();
                            }
                            return arrayList;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (e3 != null) {
                        e3.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (r2 != 0) {
                        r2.close();
                    }
                    if (e3 != null) {
                        e3.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                cursor = null;
                e2 = e5;
            } catch (Throwable th3) {
                r2 = 0;
                th = th3;
                if (r2 != 0) {
                }
                if (e3 != null) {
                }
                throw th;
            }
            return arrayList;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x01b2 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01a9 A[Catch: all -> 0x01a1, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000a, B:8:0x000c, B:24:0x0198, B:21:0x0192, B:26:0x019d, B:18:0x018a, B:20:0x018f, B:33:0x01a9, B:35:0x01ae, B:36:0x01b1), top: B:41:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01ae A[Catch: all -> 0x01a1, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000a, B:8:0x000c, B:24:0x0198, B:21:0x0192, B:26:0x019d, B:18:0x018a, B:20:0x018f, B:33:0x01a9, B:35:0x01ae, B:36:0x01b1), top: B:41:0x0004 }] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v18, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.database.sqlite.SQLiteDatabase] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<com.baidu.android.pushservice.f.e> a(Context context, long j2, long j3, int i2, int i3) {
        Throwable th;
        Cursor cursor;
        Exception e2;
        synchronized (c) {
            ?? e3 = e(context);
            if (e3 == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ?? r2 = "SELECT * FROM PushBehavior WHERE " + d.timeStamp.name() + " < " + j2 + " AND " + d.timeStamp.name() + " >= " + j3 + " LIMIT " + i3 + " OFFSET " + i2 + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR;
            try {
                try {
                    cursor = e3.rawQuery(r2, null);
                    while (cursor.moveToNext()) {
                        try {
                            com.baidu.android.pushservice.f.e eVar = new com.baidu.android.pushservice.f.e();
                            eVar.a(cursor.getInt(cursor.getColumnIndex(d.actionId.name())));
                            eVar.a(cursor.getString(cursor.getColumnIndex(d.actionName.name())));
                            eVar.f(cursor.getString(cursor.getColumnIndex(d.appid.name())));
                            eVar.g(cursor.getString(cursor.getColumnIndex(d.channel.name())));
                            eVar.e(cursor.getInt(cursor.getColumnIndex(d.errorCode.name())));
                            eVar.d(cursor.getString(cursor.getColumnIndex(d.errorMsg.name())));
                            eVar.c(cursor.getString(cursor.getColumnIndex(d.msgId.name())));
                            eVar.c(cursor.getInt(cursor.getColumnIndex(d.msgLen.name())));
                            eVar.b(cursor.getInt(cursor.getColumnIndex(d.msgType.name())));
                            eVar.b(cursor.getString(cursor.getColumnIndex(d.networkStatus.name())));
                            eVar.h(cursor.getString(cursor.getColumnIndex(d.openByPackageName.name())));
                            eVar.e(cursor.getString(cursor.getColumnIndex(d.requestId.name())));
                            eVar.d(cursor.getInt(cursor.getColumnIndex(d.stableHeartInterval.name())));
                            eVar.a(cursor.getLong(cursor.getColumnIndex(d.timeStamp.name())));
                            arrayList.add(eVar);
                        } catch (Exception e4) {
                            e2 = e4;
                            com.baidu.android.pushservice.e.a.c("PushDatabase", "e getBehaviorEnumClassList " + e2.getMessage());
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (e3 != 0) {
                                e3.close();
                            }
                            return arrayList;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (e3 != 0) {
                        e3.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (r2 != 0) {
                        r2.close();
                    }
                    if (e3 != 0) {
                        e3.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                cursor = null;
                e2 = e5;
            } catch (Throwable th3) {
                r2 = 0;
                th = th3;
                if (r2 != 0) {
                }
                if (e3 != 0) {
                }
                throw th;
            }
            return arrayList;
        }
    }

    public static void a() {
        synchronized (c) {
            try {
                if (a != null) {
                    a.close();
                    a = null;
                }
            } catch (Exception e2) {
                a = null;
                com.baidu.android.pushservice.e.a.e("PushDatabase", "close db: " + e2);
            }
        }
    }

    private static void a(final String str, Context context) {
        File[] listFiles;
        File parentFile = context.getDatabasePath("pushstat_5.6.0.db").getParentFile();
        if (parentFile == null || !parentFile.isDirectory() || (listFiles = parentFile.listFiles(new FileFilter() { // from class: com.baidu.android.pushservice.h.o.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                String name;
                return (file == null || (name = file.getName()) == null || !name.contains("pushstat") || name.contains(str)) ? false : true;
            }
        })) == null) {
            return;
        }
        for (File file : listFiles) {
            if (!file.isDirectory()) {
                file.delete();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    private static boolean a(SQLiteDatabase sQLiteDatabase, com.baidu.android.pushservice.f.h hVar) {
        boolean z;
        Cursor cursor = null;
        if (sQLiteDatabase == null) {
            return true;
        }
        try {
            try {
                cursor = sQLiteDatabase.rawQuery("SELECT * FROM PushBehavior WHERE " + d.actionName.name() + " = '" + hVar.d + "' AND " + d.errorCode.name() + " = " + hVar.g + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null);
                if (cursor.moveToNext()) {
                    hVar.a = cursor.getInt(cursor.getColumnIndex(d.stableHeartInterval.name()));
                    b(sQLiteDatabase, hVar);
                    z = true;
                } else {
                    z = false;
                }
            } catch (Exception e2) {
                com.baidu.android.pushservice.e.a.b("PushDatabase", "needToInsertUpdatePromptBehavior Exception: " + e2);
                if (cursor != null) {
                    cursor.close();
                }
            }
            if (z) {
            }
            if (cursor != null) {
                cursor.close();
            }
            return false;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static int b(Context context, String str) {
        int i2 = 0;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 != null) {
                try {
                    i2 = e2.delete("FileDownloadingInfo", g.downloadUrl.name() + "=?", new String[]{str});
                } catch (Exception e3) {
                    com.baidu.android.pushservice.e.a.e("PushDatabase", "exception " + e3);
                    i2 = -1;
                }
                e2.close();
            }
        }
        return i2;
    }

    private static int b(SQLiteDatabase sQLiteDatabase, com.baidu.android.pushservice.f.h hVar) {
        if (sQLiteDatabase == null) {
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(d.actionName.name(), hVar.d);
        contentValues.put(d.timeStamp.name(), Long.valueOf(hVar.e));
        contentValues.put(d.networkStatus.name(), hVar.f);
        contentValues.put(d.stableHeartInterval.name(), Integer.valueOf(hVar.a + 1));
        contentValues.put(d.errorCode.name(), Integer.valueOf(hVar.g));
        contentValues.put(d.appid.name(), hVar.h);
        try {
            sQLiteDatabase.update("PushBehavior", contentValues, d.actionName.name() + " = '" + hVar.d + "' AND " + d.errorCode.name() + " = " + hVar.g + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null);
            return -1;
        } catch (Exception e2) {
            com.baidu.android.pushservice.e.a.b("PushDatabase", "updatePromptBehavior Exception: " + e2);
            return -1;
        }
    }

    public static long b(Context context, com.baidu.android.pushservice.f.h hVar) {
        long j2 = 0;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                j2 = -1;
            } else if (!a(e2, hVar)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(d.actionName.name(), hVar.d);
                contentValues.put(d.timeStamp.name(), Long.valueOf(hVar.e));
                contentValues.put(d.networkStatus.name(), hVar.f);
                contentValues.put(d.stableHeartInterval.name(), (Integer) 1);
                contentValues.put(d.errorCode.name(), Integer.valueOf(hVar.g));
                contentValues.put(d.appid.name(), hVar.h);
                try {
                    j2 = e2.insert("PushBehavior", null, contentValues);
                } catch (Exception e3) {
                    com.baidu.android.pushservice.e.a.e("PushDatabase", "insertAgentOrHttpBehavior E: " + e3);
                }
                e2.close();
            }
        }
        return j2;
    }

    public static List<h> b(Context context) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c) {
            ArrayList arrayList = new ArrayList();
            SQLiteDatabase e2 = e(context);
            try {
                if (e2 == null) {
                    return arrayList;
                }
                try {
                    cursor = e2.query("FileDownloadingInfo", null, null, null, null, null, g.timeStamp.name() + " DESC");
                    while (cursor.moveToNext()) {
                        try {
                            h hVar = new h();
                            hVar.a = cursor.getString(cursor.getColumnIndex(g.belongTo.name()));
                            hVar.b = cursor.getString(cursor.getColumnIndex(g.downloadUrl.name()));
                            hVar.c = cursor.getString(cursor.getColumnIndex(g.title.name()));
                            hVar.d = cursor.getString(cursor.getColumnIndex(g.description.name()));
                            hVar.e = cursor.getString(cursor.getColumnIndex(g.savePath.name()));
                            hVar.f = cursor.getString(cursor.getColumnIndex(g.fileName.name()));
                            hVar.g = cursor.getInt(cursor.getColumnIndex(g.downloadBytes.name()));
                            hVar.h = cursor.getInt(cursor.getColumnIndex(g.totalBytes.name()));
                            hVar.i = cursor.getInt(cursor.getColumnIndex(g.downloadStatus.name()));
                            hVar.j = cursor.getLong(cursor.getColumnIndex(g.timeStamp.name()));
                            arrayList.add(hVar);
                        } catch (Exception e3) {
                            e = e3;
                            com.baidu.android.pushservice.e.a.a("PushDatabase", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (e2 != null) {
                                e2.close();
                            }
                            return arrayList;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (e2 != null) {
                        e2.close();
                    }
                } catch (Exception e4) {
                    e = e4;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        cursor2.close();
                    }
                    if (e2 != null) {
                        e2.close();
                    }
                    throw th;
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009c A[Catch: all -> 0x009f, DONT_GENERATE, TryCatch #7 {, blocks: (B:4:0x0006, B:6:0x000c, B:8:0x000e, B:19:0x008f, B:22:0x0096, B:24:0x009c, B:45:0x00e2, B:51:0x0137, B:53:0x013c, B:54:0x013f, B:59:0x0161, B:61:0x0166, B:40:0x00d7, B:43:0x00de, B:44:0x00e1, B:33:0x00c5, B:36:0x00cc, B:47:0x0126, B:57:0x0143), top: B:80:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d7 A[Catch: all -> 0x009f, TryCatch #7 {, blocks: (B:4:0x0006, B:6:0x000c, B:8:0x000e, B:19:0x008f, B:22:0x0096, B:24:0x009c, B:45:0x00e2, B:51:0x0137, B:53:0x013c, B:54:0x013f, B:59:0x0161, B:61:0x0166, B:40:0x00d7, B:43:0x00de, B:44:0x00e1, B:33:0x00c5, B:36:0x00cc, B:47:0x0126, B:57:0x0143), top: B:80:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e2 A[Catch: all -> 0x009f, TRY_LEAVE, TryCatch #7 {, blocks: (B:4:0x0006, B:6:0x000c, B:8:0x000e, B:19:0x008f, B:22:0x0096, B:24:0x009c, B:45:0x00e2, B:51:0x0137, B:53:0x013c, B:54:0x013f, B:59:0x0161, B:61:0x0166, B:40:0x00d7, B:43:0x00de, B:44:0x00e1, B:33:0x00c5, B:36:0x00cc, B:47:0x0126, B:57:0x0143), top: B:80:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context, long j2, long j3) {
        Cursor cursor;
        boolean z;
        Throwable th;
        Exception exc;
        boolean z2 = false;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 != null) {
                try {
                    Cursor rawQuery = e2.rawQuery("SELECT " + d.actionName.name() + " FROM PushBehavior WHERE " + d.timeStamp.name() + " < " + j2 + " AND " + d.timeStamp.name() + " >= " + j3 + " ;", null);
                    while (rawQuery.moveToNext()) {
                        try {
                            String string = rawQuery.getString(0);
                            if (!TextUtils.isEmpty(string) && !string.startsWith(com.baidu.android.pushservice.f.m.s)) {
                                z2 = true;
                            }
                        } catch (Exception e3) {
                            cursor = rawQuery;
                            z = z2;
                            exc = e3;
                            try {
                                com.baidu.android.pushservice.e.a.c("PushDatabase", "e isNeedUpload " + exc.getMessage());
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (!z || e2 == null) {
                                    z2 = z;
                                } else {
                                    e2.close();
                                    z2 = z;
                                }
                                if (z2) {
                                }
                                return z2;
                            } catch (Throwable th2) {
                                th = th2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (z && e2 != null) {
                                    e2.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            cursor = rawQuery;
                            z = z2;
                            th = th3;
                            if (cursor != null) {
                            }
                            if (z) {
                                e2.close();
                            }
                            throw th;
                        }
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    if (!z2 || e2 == null) {
                        cursor = rawQuery;
                    } else {
                        e2.close();
                        cursor = rawQuery;
                    }
                } catch (Exception e4) {
                    cursor = null;
                    z = false;
                    exc = e4;
                } catch (Throwable th4) {
                    cursor = null;
                    z = false;
                    th = th4;
                }
                if (z2) {
                    try {
                        cursor = e2.rawQuery("SELECT COUNT(*) FROM ADPushBehavior WHERE " + a.timeStamp.name() + " < " + j2 + " AND " + a.timeStamp.name() + " >= " + j3 + " ;", null);
                        cursor.moveToFirst();
                        if (cursor.getInt(0) > 0) {
                            z2 = true;
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (e2 != null) {
                            e2.close();
                        }
                    } catch (Exception e5) {
                        com.baidu.android.pushservice.e.a.c("PushDatabase", "e isNeedUpload" + e5.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (e2 != null) {
                            e2.close();
                        }
                    }
                }
            }
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ed A[Catch: all -> 0x00e6, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0004, B:6:0x000a, B:9:0x000d, B:14:0x004b, B:16:0x0050, B:17:0x0053, B:23:0x00c9, B:25:0x00ce, B:26:0x00d1, B:40:0x00ed, B:42:0x00f2, B:43:0x00f5, B:31:0x00dd, B:33:0x00e2), top: B:50:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f2 A[Catch: all -> 0x00e6, TryCatch #2 {, blocks: (B:4:0x0004, B:6:0x000a, B:9:0x000d, B:14:0x004b, B:16:0x0050, B:17:0x0053, B:23:0x00c9, B:25:0x00ce, B:26:0x00d1, B:40:0x00ed, B:42:0x00f2, B:43:0x00f5, B:31:0x00dd, B:33:0x00e2), top: B:50:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.android.pushservice.f.a c(Context context, String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                return null;
            }
            com.baidu.android.pushservice.f.a aVar = new com.baidu.android.pushservice.f.a();
            try {
                cursor = e2.query("AlarmMsgInfo", null, b.msgId.name() + " = " + str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null, null, null, null);
                try {
                } catch (Exception e3) {
                    e = e3;
                    cursor2 = cursor;
                    try {
                        com.baidu.android.pushservice.e.a.a("PushDatabase", e);
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (e2 != null) {
                            e2.close();
                        }
                        return aVar;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursor2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (e2 != null) {
                            e2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    if (e2 != null) {
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
            if (cursor == null) {
                com.baidu.android.pushservice.e.a.d("PushDatabase", "no msgid info table!!");
                if (cursor != null) {
                    cursor.close();
                }
                if (e2 != null) {
                    e2.close();
                }
                return null;
            }
            if (cursor.getCount() > 0) {
                com.baidu.android.pushservice.e.a.c("PushDatabase", "getAlarmMsgInfo  msgID = " + str);
                cursor.moveToFirst();
                aVar.b = cursor.getLong(cursor.getColumnIndex(b.sendtime.name()));
                aVar.c = cursor.getLong(cursor.getColumnIndex(b.showtime.name()));
                aVar.d = cursor.getLong(cursor.getColumnIndex(b.expiretime.name()));
                aVar.e = cursor.getInt(cursor.getColumnIndex(b.isAlarm.name()));
                aVar.f = cursor.getInt(cursor.getColumnIndex(b.msgEnable.name()));
            }
            if (cursor != null) {
                cursor.close();
            }
            if (e2 != null) {
                e2.close();
            }
            return aVar;
        }
    }

    public static void c(Context context) {
        Cursor cursor = null;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                return;
            }
            try {
                cursor = e2.rawQuery("SELECT * FROM AlarmMsgInfo;", null);
                while (cursor.moveToNext()) {
                    com.baidu.android.pushservice.f.a aVar = new com.baidu.android.pushservice.f.a();
                    aVar.a = cursor.getString(cursor.getColumnIndex(b.msgId.name()));
                    aVar.b = cursor.getLong(cursor.getColumnIndex(b.sendtime.name()));
                    aVar.c = cursor.getLong(cursor.getColumnIndex(b.showtime.name()));
                    aVar.d = cursor.getLong(cursor.getColumnIndex(b.expiretime.name()));
                    aVar.e = cursor.getInt(cursor.getColumnIndex(b.isAlarm.name()));
                    aVar.f = cursor.getInt(cursor.getColumnIndex(b.msgEnable.name()));
                    if (aVar.f == 0 || aVar.d < System.currentTimeMillis()) {
                        d(context, aVar.a);
                        com.baidu.android.pushservice.e.a.c("PushDatabase", "deleteInvalidAlarmMsg   msgID = " + aVar.a);
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                if (e2 != null) {
                    e2.close();
                }
            } catch (Exception e3) {
                com.baidu.android.pushservice.e.a.a("PushDatabase", e3);
                if (cursor != null) {
                    cursor.close();
                }
                if (e2 != null) {
                    e2.close();
                }
            }
        }
    }

    public static long d(Context context) {
        long j2;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                j2 = 0;
            } else {
                try {
                    e2.delete("PushBehavior", null, null);
                    e2.delete("ADPushBehavior", null, null);
                    e2.delete("AppInfo", null, null);
                } catch (Exception e3) {
                    com.baidu.android.pushservice.e.a.e("PushDatabase", "clearBehaviorInfo Exception: " + e3);
                }
                e2.close();
                j2 = -1;
            }
        }
        return j2;
    }

    public static void d(Context context, String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            try {
                if (e2 == null) {
                    return;
                }
                try {
                    cursor = e2.query("AlarmMsgInfo", null, b.msgId.name() + " = " + str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null, null, null, null);
                    try {
                    } catch (Exception e3) {
                        e = e3;
                        com.baidu.android.pushservice.e.a.a("PushDatabase", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (e2 != null) {
                            e2.close();
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        cursor2.close();
                    }
                    if (e2 != null) {
                        e2.close();
                    }
                    throw th;
                }
                if (cursor == null) {
                    com.baidu.android.pushservice.e.a.d("PushDatabase", "no msgid info table!!");
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (e2 != null) {
                        e2.close();
                    }
                    return;
                }
                e2.delete("AlarmMsgInfo", b.msgId.name() + "= ?", new String[]{str});
                com.baidu.android.pushservice.e.a.c("PushDatabase", "deleteAlarmMsg  msgID = " + str);
                if (cursor != null) {
                    cursor.close();
                }
                if (e2 != null) {
                    e2.close();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private static SQLiteDatabase e(Context context) {
        f f2 = f(context);
        if (f2 == null) {
            return null;
        }
        try {
            return f2.getWritableDatabase();
        } catch (Exception e2) {
            com.baidu.android.pushservice.e.a.b("PushDatabase", "getDb Exception: " + e2);
            com.baidu.android.pushservice.f.p.a(context.getApplicationContext(), e2);
            return null;
        }
    }

    public static boolean e(Context context, String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            try {
                if (e2 == null) {
                    return true;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    cursor = e2.query("MsgInfo", null, i.msgId.name() + " = " + str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null, null, null, null);
                    try {
                        if (cursor == null) {
                            com.baidu.android.pushservice.e.a.d("PushDatabase", "no msgid info table!!");
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            if (e2 != null) {
                                e2.close();
                            }
                            return true;
                        } else if (cursor.getCount() > 0) {
                            com.baidu.android.pushservice.e.a.d("PushDatabase", "msgid is duplicate");
                            e2.execSQL("UPDATE MsgInfo SET " + i.timeStamp.name() + " = " + System.currentTimeMillis() + " WHERE " + i.msgId + " = " + str);
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            if (e2 != null) {
                                e2.close();
                            }
                            return false;
                        } else {
                            contentValues.clear();
                            contentValues.put(i.msgId.name(), str);
                            contentValues.put(i.timeStamp.name(), Long.valueOf(System.currentTimeMillis()));
                            e2.insert("MsgInfo", null, contentValues);
                            com.baidu.android.pushservice.e.a.b("PushDatabase", "insert normal msgid");
                            Cursor rawQuery = e2.rawQuery("SELECT COUNT(*) FROM MsgInfo;", null);
                            rawQuery.moveToFirst();
                            int i2 = rawQuery.getInt(0);
                            com.baidu.android.pushservice.e.a.b("PushDatabase", "msgID count = " + i2);
                            if (i2 > d) {
                                e2.delete("MsgInfo", null, null);
                                com.baidu.android.pushservice.e.a.b("PushDatabase", "delete msgid info table!!");
                            }
                            if (rawQuery != null && !rawQuery.isClosed()) {
                                rawQuery.close();
                            }
                            if (e2 != null) {
                                e2.close();
                            }
                            return true;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        com.baidu.android.pushservice.e.a.e("PushDatabase", "exception " + e.getMessage());
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (e2 != null) {
                            e2.close();
                        }
                        return true;
                    }
                } catch (Exception e4) {
                    e = e4;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0 && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    if (e2 != null) {
                        e2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private static f f(Context context) {
        synchronized (c) {
            if (a == null) {
                String path = context.getDatabasePath("pushstat_5.6.0.db").getPath();
                a("pushstat_5.6.0.db", context);
                if (Build.VERSION.SDK_INT >= 11) {
                    b = new e();
                    a = new f(context, path, 2, b);
                } else {
                    a = new f(context, path, 2);
                }
            }
        }
        return a;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x012d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x012f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:62:? */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:63:? */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: android.database.sqlite.SQLiteDatabase */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0114 A[Catch: all -> 0x011d, TRY_ENTER, TryCatch #4 {, blocks: (B:4:0x0004, B:6:0x000a, B:20:0x00bd, B:22:0x00c2, B:23:0x00c5, B:28:0x00da, B:30:0x00df, B:31:0x00e2, B:34:0x00e8, B:36:0x00ed, B:37:0x00f0, B:52:0x0124, B:54:0x0129, B:55:0x012c, B:43:0x0114, B:45:0x0119), top: B:64:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0119 A[Catch: all -> 0x011d, TryCatch #4 {, blocks: (B:4:0x0004, B:6:0x000a, B:20:0x00bd, B:22:0x00c2, B:23:0x00c5, B:28:0x00da, B:30:0x00df, B:31:0x00e2, B:34:0x00e8, B:36:0x00ed, B:37:0x00f0, B:52:0x0124, B:54:0x0129, B:55:0x012c, B:43:0x0114, B:45:0x0119), top: B:64:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0124 A[Catch: all -> 0x011d, TRY_ENTER, TryCatch #4 {, blocks: (B:4:0x0004, B:6:0x000a, B:20:0x00bd, B:22:0x00c2, B:23:0x00c5, B:28:0x00da, B:30:0x00df, B:31:0x00e2, B:34:0x00e8, B:36:0x00ed, B:37:0x00f0, B:52:0x0124, B:54:0x0129, B:55:0x012c, B:43:0x0114, B:45:0x0119), top: B:64:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0129 A[Catch: all -> 0x011d, TryCatch #4 {, blocks: (B:4:0x0004, B:6:0x000a, B:20:0x00bd, B:22:0x00c2, B:23:0x00c5, B:28:0x00da, B:30:0x00df, B:31:0x00e2, B:34:0x00e8, B:36:0x00ed, B:37:0x00f0, B:52:0x0124, B:54:0x0129, B:55:0x012c, B:43:0x0114, B:45:0x0119), top: B:64:0x0004 }] */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int[]] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0117 -> B:37:0x00f0). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0119 -> B:37:0x00f0). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int[] f(Context context, String str) {
        Cursor cursor;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == 0) {
                return null;
            }
            try {
                cursor = e2.query("NoDisturb", null, j.pkgName.name() + "= ?", new String[]{str}, null, null, null);
            } catch (Exception e3) {
                e = e3;
                cursor = null;
                com.baidu.android.pushservice.e.a.e("PushDatabase", "error " + e.getMessage());
                if (cursor != null) {
                }
                if (e2 != 0) {
                }
                e2 = 0;
                return e2;
            } catch (Throwable th) {
                th = th;
                cursor = null;
                if (cursor != null) {
                }
                if (e2 != 0) {
                }
                throw th;
            }
            if (cursor != null) {
                try {
                    try {
                    } catch (Exception e4) {
                        e = e4;
                        com.baidu.android.pushservice.e.a.e("PushDatabase", "error " + e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (e2 != 0) {
                            e2.close();
                        }
                        e2 = 0;
                        return e2;
                    }
                    if (cursor.moveToNext()) {
                        int i2 = cursor.getInt(cursor.getColumnIndex(j.startHour.name()));
                        int i3 = cursor.getInt(cursor.getColumnIndex(j.startMinute.name()));
                        int i4 = cursor.getInt(cursor.getColumnIndex(j.endHour.name()));
                        int i5 = cursor.getInt(cursor.getColumnIndex(j.endMinute.name()));
                        com.baidu.android.pushservice.e.a.c("PushDatabase", str + " disturb data is found! startHour: " + i2 + " startMinute: " + i3 + " endHour: " + i4 + " endMinute: " + i5);
                        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
                            int[] iArr = new int[0];
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (e2 != 0) {
                                e2.close();
                            }
                            e2 = iArr;
                        } else {
                            int[] iArr2 = {i2, i3, i4, i5};
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (e2 != 0) {
                                e2.close();
                            }
                            e2 = iArr2;
                        }
                        return e2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (e2 != 0) {
                        e2.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            if (e2 != 0) {
                e2.close();
            }
            e2 = 0;
            return e2;
        }
    }
}
