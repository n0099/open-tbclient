package com.baidu.android.pushservice.d;

import android.annotation.TargetApi;
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
import com.baidu.android.pushservice.h.m;
import com.baidu.android.pushservice.j.p;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private static e a = null;
    private static d b = null;
    private static final Object c = new Object();
    private static int d = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.android.pushservice.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0017a {
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
    public enum b {
        appInfoId,
        appid,
        appType,
        packageName,
        appName,
        cFrom,
        versionCode,
        versionName,
        intergratedPushVersion
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum c {
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
        openByPackageName,
        packageName
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d implements DatabaseErrorHandler {
        private d() {
        }

        @TargetApi(16)
        private void a(String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            com.baidu.android.pushservice.g.a.e("PushDatabase", "deleting the database file: " + str);
            try {
                if (Build.VERSION.SDK_INT > 18) {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } else {
                    new File(str).delete();
                }
            } catch (Exception e) {
                com.baidu.android.pushservice.g.a.d("PushDatabase", "delete failed: " + e.getMessage());
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
        @Override // android.database.DatabaseErrorHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
            List<Pair<String, String>> list;
            Throwable th;
            com.baidu.android.pushservice.g.a.e("PushDatabase", "Corruption reported by sqlite on database: " + sQLiteDatabase.getPath());
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
                    for (Pair<String, String> pair : list) {
                        a((String) pair.second);
                    }
                } else {
                    a(sQLiteDatabase.getPath());
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
    public static class e extends SQLiteOpenHelper {
        public e(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        }

        public e(Context context, String str, int i, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i, databaseErrorHandler);
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS StatisticsInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS FileDownloadingInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushBehavior");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS AppInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS AlarmMsgInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS NoDisturb");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS MsgArriveApp");
            } catch (Exception e) {
                com.baidu.android.pushservice.g.a.c("PushDatabase", "dropTables Exception: " + e);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE StatisticsInfo (" + j.info_id.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + j.packageName.name() + " TEXT NOT NULL, " + j.open_type.name() + " TEXT NOT NULL, " + j.msgid.name() + " TEXT, " + j.app_open_time.name() + " TEXT NOT NULL, " + j.app_close_time.name() + " TEXT NOT NULL, " + j.use_duration.name() + " TEXT NOT NULL, " + j.extra.name() + " TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE PushBehavior (" + c.actionId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.actionName.name() + " TEXT NOT NULL, " + c.timeStamp.name() + " LONG  NOT NULL, " + c.networkStatus.name() + " TEXT, " + c.msgType.name() + " INTEGER, " + c.msgId.name() + " TEXT, " + c.msgLen.name() + " INTEGER, " + c.errorMsg.name() + " TEXT, " + c.requestId.name() + " TEXT, " + c.stableHeartInterval.name() + " INTEGER, " + c.errorCode.name() + " INTEGER, " + c.appid.name() + " TEXT, " + c.channel.name() + " TEXT, " + c.packageName.name() + " TEXT, " + c.openByPackageName.name() + " Text);");
                sQLiteDatabase.execSQL("CREATE TABLE MsgArriveApp (" + h.MsgInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + h.msgId.name() + " TEXT NOT NULL, " + h.timeStamp.name() + " LONG NOT NULL);");
                sQLiteDatabase.execSQL("CREATE TABLE AlarmMsgInfo (" + EnumC0017a.alarmMsgInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + EnumC0017a.msgId.name() + " TEXT NOT NULL, " + EnumC0017a.sendtime.name() + " LONG NOT NULL, " + EnumC0017a.showtime.name() + " LONG NOT NULL, " + EnumC0017a.expiretime.name() + " LONG NOT NULL, " + EnumC0017a.msgEnable.name() + " INTEGER, " + EnumC0017a.isAlarm.name() + " INTEGER);");
                sQLiteDatabase.execSQL("CREATE TABLE AppInfo (" + b.appInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + b.appid.name() + " TEXT, " + b.appType.name() + " INTEGER, " + b.packageName.name() + " TEXT UNIQUE, " + b.appName.name() + " TEXT, " + b.cFrom.name() + " TEXT, " + b.versionCode.name() + " TEXT, " + b.versionName.name() + " TEXT, " + b.intergratedPushVersion.name() + " TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE FileDownloadingInfo (" + f.belongTo.name() + " TEXT, " + f.downloadUrl.name() + " TEXT PRIMARY KEY, " + f.savePath.name() + " TEXT NOT NULL, " + f.title.name() + " TEXT, " + f.description.name() + " TEXT, " + f.fileName.name() + " TEXT NOT NULL, " + f.downloadBytes.name() + " INTEGER NOT NULL, " + f.totalBytes.name() + " INTEGER NOT NULL, " + f.downloadStatus.name() + " INTEGER NOT NULL," + f.timeStamp.name() + " INTEGER NOT NULL);");
                sQLiteDatabase.execSQL("CREATE TABLE NoDisturb (" + i.pkgName.name() + " TEXT NOT NULL, " + i.startHour.name() + " INTEGER, " + i.startMinute.name() + " INTEGER, " + i.endHour.name() + " INTEGER, " + i.endMinute.name() + " INTEGER);");
            } catch (Exception e) {
                com.baidu.android.pushservice.g.a.c("PushDatabase", "DbOpenHelper onCreate E: " + e);
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
    public enum f {
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
    public static class g {
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
    public enum h {
        MsgInfoId,
        msgId,
        timeStamp
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum i {
        pkgName,
        startHour,
        startMinute,
        endHour,
        endMinute
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum j {
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
        Cursor cursor = null;
        int i2 = 0;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 != null) {
                try {
                    cursor = e2.rawQuery("SELECT COUNT(*) FROM PushBehavior WHERE " + c.timeStamp.name() + " < " + j2 + " AND " + c.timeStamp.name() + " >= " + j3 + " ;", null);
                    cursor.moveToFirst();
                    i2 = cursor.getInt(0);
                    if (cursor != null) {
                        cursor.close();
                    }
                    e2.close();
                } catch (Exception e3) {
                    com.baidu.android.pushservice.g.a.c("PushDatabase", "e getBehaviorEnumCount" + e3.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                    e2.close();
                }
            }
        }
        return i2;
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
                    cursor = e2.query("AlarmMsgInfo", null, EnumC0017a.msgId.name() + " = " + str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null, null, null, null);
                    try {
                    } catch (Exception e3) {
                        e = e3;
                        com.baidu.android.pushservice.g.a.a("PushDatabase", e);
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
                    com.baidu.android.pushservice.g.a.d("PushDatabase", "no msgid info table!!");
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (e2 != null) {
                        e2.close();
                    }
                    return -2;
                }
                if (cursor.getCount() > 0) {
                    e2.execSQL("UPDATE AlarmMsgInfo SET " + EnumC0017a.msgEnable.name() + " = " + i2 + " WHERE " + EnumC0017a.msgId + " = " + str);
                    com.baidu.android.pushservice.g.a.c("PushDatabase", "setAlarmMsgEnable  msgID = " + str + "  enable = " + i2);
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

    public static int a(Context context, String str, g gVar) {
        int i2 = 0;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 != null) {
                String[] strArr = {str};
                ContentValues contentValues = new ContentValues();
                contentValues.put(f.belongTo.name(), gVar.a);
                contentValues.put(f.downloadUrl.name(), gVar.b);
                contentValues.put(f.title.name(), gVar.c);
                contentValues.put(f.description.name(), gVar.d);
                contentValues.put(f.savePath.name(), gVar.e);
                contentValues.put(f.fileName.name(), gVar.f);
                contentValues.put(f.downloadBytes.name(), Integer.valueOf(gVar.g));
                contentValues.put(f.totalBytes.name(), Integer.valueOf(gVar.h));
                contentValues.put(f.downloadStatus.name(), Integer.valueOf(gVar.i));
                contentValues.put(f.timeStamp.name(), Long.valueOf(System.currentTimeMillis()));
                try {
                    i2 = e2.update("FileDownloadingInfo", contentValues, f.downloadUrl.name() + "=?", strArr);
                } catch (Exception e3) {
                    com.baidu.android.pushservice.g.a.e("PushDatabase", "updateFileDownloadingInfo Exception: " + e3);
                    i2 = -1;
                }
                e2.close();
            }
        }
        return i2;
    }

    private static int a(SQLiteDatabase sQLiteDatabase, com.baidu.android.pushservice.h.i iVar) {
        if (sQLiteDatabase == null) {
            return 0;
        }
        String[] strArr = {iVar.b()};
        ContentValues contentValues = new ContentValues();
        contentValues.put(b.packageName.name(), iVar.b());
        if (!TextUtils.isEmpty(iVar.a())) {
            contentValues.put(b.appid.name(), iVar.a());
        }
        contentValues.put(b.appType.name(), Integer.valueOf(iVar.h()));
        contentValues.put(b.appName.name(), iVar.c());
        if (!TextUtils.isEmpty(iVar.d())) {
            contentValues.put(b.cFrom.name(), iVar.d());
        }
        contentValues.put(b.versionCode.name(), Integer.valueOf(iVar.e()));
        contentValues.put(b.versionName.name(), iVar.f());
        contentValues.put(b.intergratedPushVersion.name(), Integer.valueOf(iVar.g()));
        try {
            return sQLiteDatabase.update("AppInfo", contentValues, b.packageName.name() + " =?", strArr);
        } catch (Exception e2) {
            com.baidu.android.pushservice.g.a.e("PushDatabase", "updateAppInfo exception " + e2);
            return -1;
        }
    }

    public static long a(Context context, g gVar) {
        long j2;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                j2 = -1;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(f.belongTo.name(), gVar.a);
                contentValues.put(f.downloadUrl.name(), gVar.b);
                contentValues.put(f.title.name(), gVar.c);
                contentValues.put(f.description.name(), gVar.d);
                contentValues.put(f.savePath.name(), gVar.e);
                contentValues.put(f.fileName.name(), gVar.f);
                contentValues.put(f.downloadBytes.name(), Integer.valueOf(gVar.g));
                contentValues.put(f.totalBytes.name(), Integer.valueOf(gVar.h));
                contentValues.put(f.downloadStatus.name(), Integer.valueOf(gVar.i));
                contentValues.put(f.timeStamp.name(), Long.valueOf(System.currentTimeMillis()));
                try {
                    j2 = e2.insert("FileDownloadingInfo", null, contentValues);
                } catch (Exception e3) {
                    com.baidu.android.pushservice.g.a.e("PushDatabase", "exception " + e3);
                    j2 = 0;
                }
                e2.close();
            }
        }
        return j2;
    }

    public static long a(Context context, com.baidu.android.pushservice.h.a aVar) {
        long j2;
        Exception e2;
        long j3 = -1;
        synchronized (c) {
            SQLiteDatabase e3 = e(context);
            if (e3 != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(EnumC0017a.msgId.name(), aVar.a);
                contentValues.put(EnumC0017a.sendtime.name(), Long.valueOf(aVar.b));
                contentValues.put(EnumC0017a.showtime.name(), Long.valueOf(aVar.c));
                contentValues.put(EnumC0017a.expiretime.name(), Long.valueOf(aVar.d));
                contentValues.put(EnumC0017a.isAlarm.name(), Integer.valueOf(aVar.e));
                contentValues.put(EnumC0017a.msgEnable.name(), Integer.valueOf(aVar.f));
                try {
                    j2 = e3.insert("AlarmMsgInfo", null, contentValues);
                } catch (Exception e4) {
                    j2 = -1;
                    e2 = e4;
                }
                try {
                    com.baidu.android.pushservice.g.a.c("PushDatabase", "AlarmMsgInfoEnum:  insert into database");
                    p.b("AlarmMsgInfoEnum:  insert into database", context);
                    j3 = j2;
                } catch (Exception e5) {
                    e2 = e5;
                    com.baidu.android.pushservice.g.a.a("PushDatabase", e2);
                    j3 = j2;
                    e3.close();
                    return j3;
                }
                e3.close();
            }
        }
        return j3;
    }

    public static long a(Context context, com.baidu.android.pushservice.h.b bVar) {
        long j2;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                j2 = -1;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(c.actionName.name(), bVar.d);
                contentValues.put(c.timeStamp.name(), Long.valueOf(bVar.e));
                contentValues.put(c.networkStatus.name(), bVar.f);
                contentValues.put(c.appid.name(), bVar.h);
                contentValues.put(c.errorMsg.name(), bVar.a);
                contentValues.put(c.requestId.name(), bVar.b);
                contentValues.put(c.errorCode.name(), Integer.valueOf(bVar.g));
                contentValues.put(c.packageName.name(), bVar.j);
                if (bVar.c != null) {
                    contentValues.put(c.channel.name(), bVar.c);
                }
                try {
                    j2 = e2.insert("PushBehavior", null, contentValues);
                } catch (Exception e3) {
                    com.baidu.android.pushservice.g.a.e("PushDatabase", "insertApiBehavior E: " + e3);
                    j2 = 0;
                }
                e2.close();
            }
        }
        return j2;
    }

    public static long a(Context context, com.baidu.android.pushservice.h.f fVar) {
        long j2;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                j2 = -1;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(c.actionName.name(), fVar.d);
                contentValues.put(c.timeStamp.name(), Long.valueOf(fVar.e));
                contentValues.put(c.networkStatus.name(), fVar.f);
                contentValues.put(c.errorMsg.name(), fVar.a);
                contentValues.put(c.appid.name(), fVar.h);
                try {
                    j2 = e2.insert("PushBehavior", null, contentValues);
                } catch (Exception e3) {
                    com.baidu.android.pushservice.g.a.e("PushDatabase", "insertCrashBehavior E: " + e3);
                    j2 = 0;
                }
                e2.close();
            }
        }
        return j2;
    }

    public static long a(Context context, com.baidu.android.pushservice.h.h hVar) {
        long j2;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                j2 = -1;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(c.actionName.name(), hVar.d);
                contentValues.put(c.timeStamp.name(), Long.valueOf(hVar.e));
                contentValues.put(c.networkStatus.name(), hVar.f);
                contentValues.put(c.errorMsg.name(), hVar.i);
                contentValues.put(c.stableHeartInterval.name(), Integer.valueOf(hVar.a));
                contentValues.put(c.errorCode.name(), Integer.valueOf(hVar.g));
                contentValues.put(c.appid.name(), hVar.h);
                contentValues.put(c.msgId.name(), hVar.b);
                contentValues.put(c.openByPackageName.name(), hVar.c);
                try {
                    j2 = e2.insert("PushBehavior", null, contentValues);
                } catch (Exception e3) {
                    com.baidu.android.pushservice.g.a.e("PushDatabase", "insertPromptBehavior E: " + e3);
                    j2 = 0;
                }
                e2.close();
            }
        }
        return j2;
    }

    public static long a(Context context, com.baidu.android.pushservice.h.i iVar) {
        long j2 = 0;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                j2 = -1;
            } else if (b(e2, iVar)) {
                e2.close();
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(b.appid.name(), iVar.a());
                contentValues.put(b.appType.name(), Integer.valueOf(iVar.h()));
                contentValues.put(b.packageName.name(), iVar.b());
                contentValues.put(b.appName.name(), iVar.c());
                contentValues.put(b.cFrom.name(), iVar.d());
                contentValues.put(b.versionCode.name(), Integer.valueOf(iVar.e()));
                contentValues.put(b.versionName.name(), iVar.f());
                contentValues.put(b.intergratedPushVersion.name(), Integer.valueOf(iVar.g()));
                try {
                    j2 = e2.insert("AppInfo", null, contentValues);
                } catch (Exception e3) {
                    com.baidu.android.pushservice.g.a.e("PushDatabase", "insertAppInfo E: " + e3);
                }
                e2.close();
            }
        }
        return j2;
    }

    public static long a(Context context, com.baidu.android.pushservice.h.j jVar) {
        long j2 = -1;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(c.actionName.name(), jVar.d);
                contentValues.put(c.timeStamp.name(), Long.valueOf(jVar.e));
                contentValues.put(c.networkStatus.name(), jVar.f);
                if (jVar.h != null) {
                    contentValues.put(c.appid.name(), jVar.h);
                }
                contentValues.put(c.msgType.name(), Integer.valueOf(jVar.c));
                contentValues.put(c.msgId.name(), jVar.a);
                contentValues.put(c.msgLen.name(), Integer.valueOf(jVar.b));
                contentValues.put(c.errorCode.name(), Integer.valueOf(jVar.g));
                if (jVar.k != null) {
                    contentValues.put(c.openByPackageName.name(), jVar.k);
                }
                if (TextUtils.isEmpty(jVar.j)) {
                    com.baidu.android.pushservice.g.a.c("PushDatabase", "insert push behavior failed pkgname is null");
                    e2.close();
                } else {
                    contentValues.put(c.packageName.name(), jVar.j);
                    try {
                        j2 = e2.insert("PushBehavior", null, contentValues);
                    } catch (Exception e3) {
                        com.baidu.android.pushservice.g.a.e("PushDatabase", "exception " + e3);
                    }
                    e2.close();
                }
            }
        }
        return j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x01d0 A[Catch: all -> 0x013a, TryCatch #2 {, blocks: (B:5:0x0005, B:7:0x000b, B:24:0x012e, B:26:0x0133, B:27:0x0137, B:45:0x01d0, B:47:0x01d5, B:48:0x01d8, B:39:0x01c1, B:41:0x01c6), top: B:57:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01d5 A[Catch: all -> 0x013a, TryCatch #2 {, blocks: (B:5:0x0005, B:7:0x000b, B:24:0x012e, B:26:0x0133, B:27:0x0137, B:45:0x01d0, B:47:0x01d5, B:48:0x01d8, B:39:0x01c1, B:41:0x01c6), top: B:57:0x0005 }] */
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
            try {
                com.baidu.android.pushservice.g.a.c("PushDatabase", "package name: " + str + " setNoDisturbMode -- startHour: " + i2 + " startMinute: " + i3 + " endHour: " + i4 + " endMinute: " + i5);
                cursor = e2.query("NoDisturb", new String[]{i.pkgName.name()}, i.pkgName.name() + "= ?", new String[]{str}, null, null, null);
                try {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(i.pkgName.name(), str);
                        contentValues.put(i.startHour.name(), Integer.valueOf(i2));
                        contentValues.put(i.startMinute.name(), Integer.valueOf(i3));
                        contentValues.put(i.endHour.name(), Integer.valueOf(i4));
                        contentValues.put(i.endMinute.name(), Integer.valueOf(i5));
                        if (cursor == null || !cursor.moveToNext()) {
                            com.baidu.android.pushservice.g.a.c("PushDatabase", "add No Disturb record for " + str);
                            j3 = e2.insert("NoDisturb", null, contentValues);
                        } else if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
                            com.baidu.android.pushservice.g.a.c("PushDatabase", "delete No Disturb record for " + str);
                            j3 = e2.delete("NoDisturb", i.pkgName.name() + "= ?", new String[]{str});
                        } else {
                            com.baidu.android.pushservice.g.a.c("PushDatabase", "update No Disturb record for " + str);
                            j3 = e2.update("NoDisturb", contentValues, i.pkgName.name() + "= ?", new String[]{str});
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        com.baidu.android.pushservice.g.a.e("PushDatabase", "setNoDisturbMode Exception: " + e);
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
                    if (cursor != null) {
                        cursor.close();
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
                cursor = null;
                if (cursor != null) {
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

    /* JADX WARN: Removed duplicated region for block: B:33:0x0117 A[Catch: all -> 0x00fe, TryCatch #5 {, blocks: (B:4:0x0004, B:6:0x000a, B:9:0x000d, B:17:0x00f4, B:18:0x00f7, B:19:0x00fb, B:28:0x010b, B:29:0x010e, B:33:0x0117, B:34:0x011a, B:35:0x011d), top: B:51:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static g a(Context context, String str) {
        Cursor cursor;
        g gVar;
        g gVar2;
        g gVar3;
        Cursor cursor2 = null;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                return null;
            }
            try {
                cursor = e2.query("FileDownloadingInfo", null, "(" + f.downloadUrl.name() + "==?)", new String[]{str}, null, null, null);
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            g gVar4 = new g();
                            try {
                                gVar4.a = cursor.getString(cursor.getColumnIndex(f.belongTo.name()));
                                gVar4.b = cursor.getString(cursor.getColumnIndex(f.downloadUrl.name()));
                                gVar4.c = cursor.getString(cursor.getColumnIndex(f.title.name()));
                                gVar4.d = cursor.getString(cursor.getColumnIndex(f.description.name()));
                                gVar4.e = cursor.getString(cursor.getColumnIndex(f.savePath.name()));
                                gVar4.f = cursor.getString(cursor.getColumnIndex(f.fileName.name()));
                                gVar4.g = cursor.getInt(cursor.getColumnIndex(f.downloadBytes.name()));
                                gVar4.h = cursor.getInt(cursor.getColumnIndex(f.totalBytes.name()));
                                gVar4.i = cursor.getInt(cursor.getColumnIndex(f.downloadStatus.name()));
                                gVar4.j = cursor.getLong(cursor.getColumnIndex(f.timeStamp.name()));
                                gVar3 = gVar4;
                            } catch (Exception e3) {
                                e = e3;
                                cursor2 = cursor;
                                gVar = gVar4;
                                try {
                                    com.baidu.android.pushservice.g.a.a("PushDatabase", e);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    e2.close();
                                    gVar2 = gVar;
                                    return gVar2;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor = cursor2;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    e2.close();
                                    throw th;
                                }
                            }
                        } else {
                            gVar3 = null;
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        e2.close();
                        gVar2 = gVar3;
                    } catch (Exception e4) {
                        e = e4;
                        gVar = null;
                        cursor2 = cursor;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    e2.close();
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                gVar = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
            return gVar2;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x00dc */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d5 A[Catch: all -> 0x00cd, TRY_ENTER, TryCatch #3 {, blocks: (B:4:0x0004, B:6:0x000a, B:8:0x000c, B:23:0x00c6, B:24:0x00c9, B:20:0x00c0, B:18:0x00ba, B:19:0x00bd, B:31:0x00d5, B:32:0x00d8, B:33:0x00db), top: B:39:0x0004 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<com.baidu.android.pushservice.h.i> a(Context context) {
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
                            com.baidu.android.pushservice.h.i iVar = new com.baidu.android.pushservice.h.i();
                            iVar.a(cursor.getString(cursor.getColumnIndex(b.appid.name())));
                            iVar.c(cursor.getInt(cursor.getColumnIndex(b.appType.name())));
                            iVar.b(cursor.getString(cursor.getColumnIndex(b.packageName.name())));
                            iVar.c(cursor.getString(cursor.getColumnIndex(b.appName.name())));
                            iVar.d(cursor.getString(cursor.getColumnIndex(b.cFrom.name())));
                            iVar.a(cursor.getInt(cursor.getColumnIndex(b.versionCode.name())));
                            iVar.e(cursor.getString(cursor.getColumnIndex(b.versionName.name())));
                            iVar.b(cursor.getInt(cursor.getColumnIndex(b.intergratedPushVersion.name())));
                            arrayList.add(iVar);
                        } catch (Exception e4) {
                            e2 = e4;
                            com.baidu.android.pushservice.g.a.a("PushDatabase", e2);
                            if (cursor != null) {
                                cursor.close();
                            }
                            e3.close();
                            return arrayList;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    e3.close();
                } catch (Throwable th2) {
                    th = th2;
                    if (r2 != 0) {
                        r2.close();
                    }
                    e3.close();
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
                e3.close();
                throw th;
            }
            return arrayList;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x01b4 A[Catch: all -> 0x01ac, TRY_ENTER, TryCatch #3 {, blocks: (B:4:0x0004, B:6:0x000a, B:8:0x000c, B:23:0x01a5, B:24:0x01a8, B:20:0x019f, B:18:0x0199, B:19:0x019c, B:31:0x01b4, B:32:0x01b7, B:33:0x01ba), top: B:41:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<com.baidu.android.pushservice.h.e> a(Context context, long j2, long j3, int i2) {
        Cursor cursor;
        Throwable th;
        Exception e2;
        synchronized (c) {
            SQLiteDatabase e3 = e(context);
            if (e3 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                cursor = e3.rawQuery("SELECT * FROM PushBehavior WHERE " + c.timeStamp.name() + " < " + j2 + " AND " + c.timeStamp.name() + " >= " + j3 + " LIMIT " + i2 + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null);
                while (cursor.moveToNext()) {
                    try {
                        try {
                            com.baidu.android.pushservice.h.e eVar = new com.baidu.android.pushservice.h.e();
                            eVar.a(cursor.getInt(cursor.getColumnIndex(c.actionId.name())));
                            eVar.a(cursor.getString(cursor.getColumnIndex(c.actionName.name())));
                            eVar.f(cursor.getString(cursor.getColumnIndex(c.appid.name())));
                            eVar.g(cursor.getString(cursor.getColumnIndex(c.channel.name())));
                            eVar.e(cursor.getInt(cursor.getColumnIndex(c.errorCode.name())));
                            eVar.d(cursor.getString(cursor.getColumnIndex(c.errorMsg.name())));
                            eVar.c(cursor.getString(cursor.getColumnIndex(c.msgId.name())));
                            eVar.c(cursor.getInt(cursor.getColumnIndex(c.msgLen.name())));
                            eVar.b(cursor.getInt(cursor.getColumnIndex(c.msgType.name())));
                            eVar.b(cursor.getString(cursor.getColumnIndex(c.networkStatus.name())));
                            eVar.i(cursor.getString(cursor.getColumnIndex(c.openByPackageName.name())));
                            eVar.e(cursor.getString(cursor.getColumnIndex(c.requestId.name())));
                            eVar.d(cursor.getInt(cursor.getColumnIndex(c.stableHeartInterval.name())));
                            eVar.a(cursor.getLong(cursor.getColumnIndex(c.timeStamp.name())));
                            eVar.h(cursor.getString(cursor.getColumnIndex(c.packageName.name())));
                            arrayList.add(eVar);
                        } catch (Exception e4) {
                            e2 = e4;
                            com.baidu.android.pushservice.g.a.c("PushDatabase", "e getBehaviorEnumClassList " + e2.getMessage());
                            if (cursor != null) {
                                cursor.close();
                            }
                            e3.close();
                            return arrayList;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        e3.close();
                        throw th;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                e3.close();
            } catch (Exception e5) {
                cursor = null;
                e2 = e5;
            } catch (Throwable th3) {
                cursor = null;
                th = th3;
                if (cursor != null) {
                }
                e3.close();
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
                com.baidu.android.pushservice.g.a.e("PushDatabase", "close db: " + e2);
            }
        }
    }

    private static void a(final String str, Context context) {
        File[] listFiles;
        File parentFile = context.getDatabasePath("pushstat_5.8.0.db").getParentFile();
        if (parentFile == null || !parentFile.isDirectory() || (listFiles = parentFile.listFiles(new FileFilter() { // from class: com.baidu.android.pushservice.d.a.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file == null) {
                    return false;
                }
                String name = file.getName();
                return name.contains("pushstat") && !name.contains(str);
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
    private static boolean a(SQLiteDatabase sQLiteDatabase, com.baidu.android.pushservice.h.h hVar) {
        boolean z;
        Cursor cursor = null;
        if (sQLiteDatabase == null) {
            return true;
        }
        try {
            try {
                cursor = sQLiteDatabase.rawQuery("SELECT * FROM PushBehavior WHERE " + c.actionName.name() + " = '" + hVar.d + "' AND " + c.errorCode.name() + " = " + hVar.g + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null);
                if (cursor.moveToNext()) {
                    hVar.a = cursor.getInt(cursor.getColumnIndex(c.stableHeartInterval.name()));
                    b(sQLiteDatabase, hVar);
                    z = true;
                } else {
                    z = false;
                }
            } catch (Exception e2) {
                com.baidu.android.pushservice.g.a.b("PushDatabase", "needToInsertUpdatePromptBehavior Exception: " + e2);
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
                    i2 = e2.delete("FileDownloadingInfo", f.downloadUrl.name() + "=?", new String[]{str});
                } catch (Exception e3) {
                    com.baidu.android.pushservice.g.a.e("PushDatabase", "exception " + e3);
                    i2 = -1;
                }
                e2.close();
            }
        }
        return i2;
    }

    private static int b(SQLiteDatabase sQLiteDatabase, com.baidu.android.pushservice.h.h hVar) {
        if (sQLiteDatabase == null) {
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(c.actionName.name(), hVar.d);
        contentValues.put(c.timeStamp.name(), Long.valueOf(hVar.e));
        contentValues.put(c.networkStatus.name(), hVar.f);
        contentValues.put(c.stableHeartInterval.name(), Integer.valueOf(hVar.a + 1));
        contentValues.put(c.errorCode.name(), Integer.valueOf(hVar.g));
        contentValues.put(c.appid.name(), hVar.h);
        try {
            sQLiteDatabase.update("PushBehavior", contentValues, c.actionName.name() + " = '" + hVar.d + "' AND " + c.errorCode.name() + " = " + hVar.g + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null);
            return -1;
        } catch (Exception e2) {
            com.baidu.android.pushservice.g.a.b("PushDatabase", "updatePromptBehavior Exception: " + e2);
            return -1;
        }
    }

    public static long b(Context context, com.baidu.android.pushservice.h.h hVar) {
        long j2 = 0;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                j2 = -1;
            } else if (!a(e2, hVar)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(c.actionName.name(), hVar.d);
                contentValues.put(c.timeStamp.name(), Long.valueOf(hVar.e));
                contentValues.put(c.networkStatus.name(), hVar.f);
                contentValues.put(c.stableHeartInterval.name(), (Integer) 1);
                contentValues.put(c.errorCode.name(), Integer.valueOf(hVar.g));
                contentValues.put(c.appid.name(), hVar.h);
                try {
                    j2 = e2.insert("PushBehavior", null, contentValues);
                } catch (Exception e3) {
                    com.baidu.android.pushservice.g.a.e("PushDatabase", "insertAgentOrHttpBehavior E: " + e3);
                }
                e2.close();
            } else if (e2 != null) {
                e2.close();
            }
        }
        return j2;
    }

    public static List<g> b(Context context) {
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
                    cursor = e2.query("FileDownloadingInfo", null, null, null, null, null, f.timeStamp.name() + " DESC");
                    while (cursor.moveToNext()) {
                        try {
                            g gVar = new g();
                            gVar.a = cursor.getString(cursor.getColumnIndex(f.belongTo.name()));
                            gVar.b = cursor.getString(cursor.getColumnIndex(f.downloadUrl.name()));
                            gVar.c = cursor.getString(cursor.getColumnIndex(f.title.name()));
                            gVar.d = cursor.getString(cursor.getColumnIndex(f.description.name()));
                            gVar.e = cursor.getString(cursor.getColumnIndex(f.savePath.name()));
                            gVar.f = cursor.getString(cursor.getColumnIndex(f.fileName.name()));
                            gVar.g = cursor.getInt(cursor.getColumnIndex(f.downloadBytes.name()));
                            gVar.h = cursor.getInt(cursor.getColumnIndex(f.totalBytes.name()));
                            gVar.i = cursor.getInt(cursor.getColumnIndex(f.downloadStatus.name()));
                            gVar.j = cursor.getLong(cursor.getColumnIndex(f.timeStamp.name()));
                            arrayList.add(gVar);
                        } catch (Exception e3) {
                            e = e3;
                            com.baidu.android.pushservice.g.a.a("PushDatabase", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            e2.close();
                            return arrayList;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    e2.close();
                } catch (Exception e4) {
                    e = e4;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        cursor2.close();
                    }
                    e2.close();
                    throw th;
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00da A[Catch: all -> 0x00a1, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x000d, B:19:0x0096, B:21:0x009b, B:22:0x009e, B:37:0x00da, B:39:0x00df, B:40:0x00e2, B:31:0x00c9, B:33:0x00ce), top: B:48:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00df A[Catch: all -> 0x00a1, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x000b, B:8:0x000d, B:19:0x0096, B:21:0x009b, B:22:0x009e, B:37:0x00da, B:39:0x00df, B:40:0x00e2, B:31:0x00c9, B:33:0x00ce), top: B:48:0x0005 }] */
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
                    Cursor rawQuery = e2.rawQuery("SELECT " + c.actionName.name() + " FROM PushBehavior WHERE " + c.timeStamp.name() + " < " + j2 + " AND " + c.timeStamp.name() + " >= " + j3 + " ;", null);
                    while (rawQuery.moveToNext()) {
                        try {
                            String string = rawQuery.getString(0);
                            if (!TextUtils.isEmpty(string) && !string.startsWith(m.s)) {
                                z2 = true;
                            }
                        } catch (Exception e3) {
                            cursor = rawQuery;
                            z = z2;
                            exc = e3;
                            try {
                                com.baidu.android.pushservice.g.a.c("PushDatabase", "e isNeedUpload " + exc.getMessage());
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (z) {
                                    e2.close();
                                    z2 = z;
                                } else {
                                    z2 = z;
                                }
                                return z2;
                            } catch (Throwable th2) {
                                th = th2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (z) {
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
                            }
                            throw th;
                        }
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    if (z2) {
                        e2.close();
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
            }
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean b(SQLiteDatabase sQLiteDatabase, com.baidu.android.pushservice.h.i iVar) {
        Cursor cursor;
        if (sQLiteDatabase == null) {
            return false;
        }
        try {
            cursor = sQLiteDatabase.query("AppInfo", null, b.packageName.name() + " =?", new String[]{iVar.b()}, null, null, null);
            try {
                try {
                } catch (Exception e2) {
                    e = e2;
                    com.baidu.android.pushservice.g.a.c("PushDatabase", "needToInsertUpdate Exception: " + e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        if (!cursor.moveToNext()) {
            if (cursor != null) {
                cursor.close();
            }
            return false;
        }
        if (!TextUtils.equals(iVar.d(), cursor.getString(cursor.getColumnIndex(b.cFrom.name()))) || !TextUtils.equals(iVar.e() + "", cursor.getInt(cursor.getColumnIndex(b.versionCode.name())) + "") || !TextUtils.equals(iVar.g() + "", cursor.getString(cursor.getColumnIndex(b.intergratedPushVersion.name())))) {
            a(sQLiteDatabase, iVar);
        }
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ef A[Catch: all -> 0x00e8, TRY_ENTER, TryCatch #4 {, blocks: (B:4:0x0004, B:6:0x000a, B:9:0x000d, B:14:0x0050, B:15:0x0053, B:16:0x0056, B:22:0x00ce, B:23:0x00d1, B:24:0x00d4, B:37:0x00ef, B:38:0x00f2, B:39:0x00f5, B:29:0x00e1, B:30:0x00e4), top: B:48:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.android.pushservice.h.a c(Context context, String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                return null;
            }
            com.baidu.android.pushservice.h.a aVar = new com.baidu.android.pushservice.h.a();
            try {
                cursor = e2.query("AlarmMsgInfo", null, EnumC0017a.msgId.name() + " = " + str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null, null, null, null);
                try {
                } catch (Exception e3) {
                    e = e3;
                    cursor2 = cursor;
                    try {
                        com.baidu.android.pushservice.g.a.a("PushDatabase", e);
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        e2.close();
                        return aVar;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursor2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        e2.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    e2.close();
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
            if (cursor == null) {
                com.baidu.android.pushservice.g.a.d("PushDatabase", "no msgid info table!!");
                if (cursor != null) {
                    cursor.close();
                }
                e2.close();
                return null;
            }
            if (cursor.getCount() > 0) {
                com.baidu.android.pushservice.g.a.c("PushDatabase", "getAlarmMsgInfo  msgID = " + str);
                cursor.moveToFirst();
                aVar.b = cursor.getLong(cursor.getColumnIndex(EnumC0017a.sendtime.name()));
                aVar.c = cursor.getLong(cursor.getColumnIndex(EnumC0017a.showtime.name()));
                aVar.d = cursor.getLong(cursor.getColumnIndex(EnumC0017a.expiretime.name()));
                aVar.e = cursor.getInt(cursor.getColumnIndex(EnumC0017a.isAlarm.name()));
                aVar.f = cursor.getInt(cursor.getColumnIndex(EnumC0017a.msgEnable.name()));
            }
            if (cursor != null) {
                cursor.close();
            }
            e2.close();
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
                    com.baidu.android.pushservice.h.a aVar = new com.baidu.android.pushservice.h.a();
                    aVar.a = cursor.getString(cursor.getColumnIndex(EnumC0017a.msgId.name()));
                    aVar.b = cursor.getLong(cursor.getColumnIndex(EnumC0017a.sendtime.name()));
                    aVar.c = cursor.getLong(cursor.getColumnIndex(EnumC0017a.showtime.name()));
                    aVar.d = cursor.getLong(cursor.getColumnIndex(EnumC0017a.expiretime.name()));
                    aVar.e = cursor.getInt(cursor.getColumnIndex(EnumC0017a.isAlarm.name()));
                    aVar.f = cursor.getInt(cursor.getColumnIndex(EnumC0017a.msgEnable.name()));
                    if (aVar.f == 0 || aVar.d < System.currentTimeMillis()) {
                        d(context, aVar.a);
                        com.baidu.android.pushservice.g.a.c("PushDatabase", "deleteInvalidAlarmMsg   msgID = " + aVar.a);
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                if (e2 != null) {
                    e2.close();
                }
            } catch (Exception e3) {
                com.baidu.android.pushservice.g.a.a("PushDatabase", e3);
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
                    e2.delete("AppInfo", null, null);
                } catch (Exception e3) {
                    com.baidu.android.pushservice.g.a.e("PushDatabase", "clearBehaviorInfo Exception: " + e3);
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
                    cursor = e2.query("AlarmMsgInfo", null, EnumC0017a.msgId.name() + " = " + str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null, null, null, null);
                    try {
                    } catch (Exception e3) {
                        e = e3;
                        com.baidu.android.pushservice.g.a.a("PushDatabase", e);
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
                    com.baidu.android.pushservice.g.a.d("PushDatabase", "no msgid info table!!");
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (e2 != null) {
                        e2.close();
                    }
                    return;
                }
                e2.delete("AlarmMsgInfo", EnumC0017a.msgId.name() + "= ?", new String[]{str});
                com.baidu.android.pushservice.g.a.c("PushDatabase", "deleteAlarmMsg  msgID = " + str);
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
        e f2 = f(context);
        if (f2 == null) {
            return null;
        }
        try {
            return f2.getWritableDatabase();
        } catch (Exception e2) {
            com.baidu.android.pushservice.g.a.b("PushDatabase", "getDb Exception: " + e2);
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
                    contentValues.clear();
                    contentValues.put(h.msgId.name(), str);
                    contentValues.put(h.timeStamp.name(), Long.valueOf(System.currentTimeMillis()));
                    String str2 = h.msgId.name() + " =? ";
                    cursor = e2.query("MsgArriveApp", null, str2, new String[]{str}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.getCount() > 0) {
                                com.baidu.android.pushservice.g.a.d("PushDatabase", "msgid is duplicated ");
                                String str3 = "UPDATE MsgArriveApp SET " + h.timeStamp.name() + " = " + System.currentTimeMillis() + " WHERE " + h.msgId + " = " + str;
                                e2.update("MsgArriveApp", contentValues, str2, new String[]{str});
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                e2.close();
                                return false;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            com.baidu.android.pushservice.g.a.e("PushDatabase", "exception " + e.getMessage());
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            e2.close();
                            return true;
                        }
                    }
                    Cursor rawQuery = e2.rawQuery("SELECT COUNT(*) FROM MsgArriveApp;", null);
                    rawQuery.moveToFirst();
                    int i2 = rawQuery.getInt(0);
                    com.baidu.android.pushservice.g.a.b("PushDatabase", "msgID count = " + i2);
                    if (i2 > d) {
                        e2.delete("MsgArriveApp", null, null);
                        com.baidu.android.pushservice.g.a.b("PushDatabase", "delete msgid info table!!");
                    }
                    e2.insert("MsgArriveApp", null, contentValues);
                    com.baidu.android.pushservice.g.a.b("PushDatabase", "insert normal msgid");
                    if (rawQuery != null && !rawQuery.isClosed()) {
                        rawQuery.close();
                    }
                    e2.close();
                    return true;
                } catch (Exception e4) {
                    e = e4;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0 && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    e2.close();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private static e f(Context context) {
        synchronized (c) {
            if (a == null) {
                String path = context.getDatabasePath("pushstat_5.8.0.db").getPath();
                a("pushstat_5.8.0.db", context);
                if (Build.VERSION.SDK_INT >= 11) {
                    b = new d();
                    a = new e(context, path, 2, b);
                } else {
                    a = new e(context, path, 2);
                }
            }
        }
        return a;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x012c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x012e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:57:? */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:? */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: android.database.sqlite.SQLiteDatabase */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0117 A[Catch: all -> 0x011e, TRY_ENTER, TryCatch #4 {, blocks: (B:4:0x0004, B:6:0x000a, B:20:0x00c4, B:21:0x00c7, B:22:0x00ca, B:27:0x00df, B:28:0x00e2, B:29:0x00e5, B:32:0x00eb, B:33:0x00ee, B:34:0x00f1, B:48:0x0125, B:49:0x0128, B:50:0x012b, B:40:0x0117, B:41:0x011a), top: B:59:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0125 A[Catch: all -> 0x011e, TRY_ENTER, TryCatch #4 {, blocks: (B:4:0x0004, B:6:0x000a, B:20:0x00c4, B:21:0x00c7, B:22:0x00ca, B:27:0x00df, B:28:0x00e2, B:29:0x00e5, B:32:0x00eb, B:33:0x00ee, B:34:0x00f1, B:48:0x0125, B:49:0x0128, B:50:0x012b, B:40:0x0117, B:41:0x011a), top: B:59:0x0004 }] */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int[]] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x011a -> B:34:0x00f1). Please submit an issue!!! */
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
                cursor = e2.query("NoDisturb", null, i.pkgName.name() + "= ?", new String[]{str}, null, null, null);
            } catch (Exception e3) {
                e = e3;
                cursor = null;
                com.baidu.android.pushservice.g.a.e("PushDatabase", "error " + e.getMessage());
                if (cursor != null) {
                }
                e2.close();
                e2 = 0;
                return e2;
            } catch (Throwable th) {
                th = th;
                cursor = null;
                if (cursor != null) {
                }
                e2.close();
                throw th;
            }
            if (cursor != null) {
                try {
                    try {
                    } catch (Exception e4) {
                        e = e4;
                        com.baidu.android.pushservice.g.a.e("PushDatabase", "error " + e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        e2.close();
                        e2 = 0;
                        return e2;
                    }
                    if (cursor.moveToNext()) {
                        int i2 = cursor.getInt(cursor.getColumnIndex(i.startHour.name()));
                        int i3 = cursor.getInt(cursor.getColumnIndex(i.startMinute.name()));
                        int i4 = cursor.getInt(cursor.getColumnIndex(i.endHour.name()));
                        int i5 = cursor.getInt(cursor.getColumnIndex(i.endMinute.name()));
                        com.baidu.android.pushservice.g.a.c("PushDatabase", str + " disturb data is found! startHour: " + i2 + " startMinute: " + i3 + " endHour: " + i4 + " endMinute: " + i5);
                        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
                            int[] iArr = new int[0];
                            if (cursor != null) {
                                cursor.close();
                            }
                            e2.close();
                            e2 = iArr;
                        } else {
                            int[] iArr2 = {i2, i3, i4, i5};
                            if (cursor != null) {
                                cursor.close();
                            }
                            e2.close();
                            e2 = iArr2;
                        }
                        return e2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    e2.close();
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            e2.close();
            e2 = 0;
            return e2;
        }
    }
}
