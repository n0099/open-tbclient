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
import com.baidu.android.pushservice.h.k;
import com.baidu.android.pushservice.h.n;
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
    public enum EnumC0031a {
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
            try {
                if (Build.VERSION.SDK_INT > 18) {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } else {
                    new File(str).delete();
                }
            } catch (Exception e) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
        @Override // android.database.DatabaseErrorHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
            List<Pair<String, String>> list;
            Throwable th;
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
        private static final String a = "CREATE TABLE StatisticsInfo (" + j.info_id.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + j.packageName.name() + " TEXT NOT NULL, " + j.open_type.name() + " TEXT NOT NULL, " + j.msgid.name() + " TEXT, " + j.app_open_time.name() + " TEXT NOT NULL, " + j.app_close_time.name() + " TEXT NOT NULL, " + j.use_duration.name() + " TEXT NOT NULL, " + j.extra.name() + " TEXT);";
        private static final String b = "CREATE TABLE PushBehavior (" + c.actionId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.actionName.name() + " TEXT NOT NULL, " + c.timeStamp.name() + " LONG NOT NULL, " + c.networkStatus.name() + " TEXT, " + c.msgType.name() + " INTEGER, " + c.msgId.name() + " TEXT, " + c.msgLen.name() + " INTEGER, " + c.errorMsg.name() + " TEXT, " + c.requestId.name() + " TEXT, " + c.stableHeartInterval.name() + " INTEGER, " + c.errorCode.name() + " INTEGER, " + c.appid.name() + " TEXT, " + c.channel.name() + " TEXT, " + c.packageName.name() + " TEXT, " + c.openByPackageName.name() + " TEXT);";
        private static final String c = "CREATE TABLE MsgArriveApp (" + h.MsgInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + h.msgId.name() + " TEXT NOT NULL, " + h.timeStamp.name() + " LONG NOT NULL);";
        private static final String d = "CREATE TABLE AlarmMsgInfo (" + EnumC0031a.alarmMsgInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + EnumC0031a.msgId.name() + " TEXT NOT NULL, " + EnumC0031a.sendtime.name() + " LONG NOT NULL, " + EnumC0031a.showtime.name() + " LONG NOT NULL, " + EnumC0031a.expiretime.name() + " LONG NOT NULL, " + EnumC0031a.msgEnable.name() + " INTEGER, " + EnumC0031a.isAlarm.name() + " INTEGER);";
        private static final String e = "CREATE TABLE AppInfo (" + b.appInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + b.appid.name() + " TEXT, " + b.appType.name() + " INTEGER, " + b.packageName.name() + " TEXT UNIQUE, " + b.appName.name() + " TEXT, " + b.cFrom.name() + " TEXT, " + b.versionCode.name() + " TEXT, " + b.versionName.name() + " TEXT, " + b.intergratedPushVersion.name() + " TEXT);";
        private static final String f = "CREATE TABLE FileDownloadingInfo (" + f.belongTo.name() + " TEXT, " + f.downloadUrl.name() + " TEXT PRIMARY KEY, " + f.savePath.name() + " TEXT NOT NULL, " + f.title.name() + " TEXT, " + f.description.name() + " TEXT, " + f.fileName.name() + " TEXT NOT NULL, " + f.downloadBytes.name() + " INTEGER NOT NULL, " + f.totalBytes.name() + " INTEGER NOT NULL, " + f.downloadStatus.name() + " INTEGER NOT NULL," + f.timeStamp.name() + " INTEGER NOT NULL);";
        private static final String g = "CREATE TABLE NoDisturb (" + i.pkgName.name() + " TEXT NOT NULL, " + i.startHour.name() + " INTEGER, " + i.startMinute.name() + " INTEGER, " + i.endHour.name() + " INTEGER, " + i.endMinute.name() + " INTEGER);";

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
            } catch (Exception e2) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(a);
                sQLiteDatabase.execSQL(b);
                sQLiteDatabase.execSQL(c);
                sQLiteDatabase.execSQL(d);
                sQLiteDatabase.execSQL(e);
                sQLiteDatabase.execSQL(f);
                sQLiteDatabase.execSQL(g);
            } catch (Exception e2) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            a(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    /* loaded from: classes2.dex */
    enum f {
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

    /* loaded from: classes2.dex */
    enum j {
        info_id,
        packageName,
        open_type,
        msgid,
        app_open_time,
        app_close_time,
        use_duration,
        extra
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE] complete} */
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
                    if (cursor != null) {
                        cursor.close();
                    }
                    e2.close();
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    e2.close();
                    throw th;
                }
            }
        }
        return i2;
    }

    public static int a(Context context, String str, int i2) {
        Cursor cursor;
        Cursor cursor2;
        int i3;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                return -1;
            }
            try {
                cursor = e2.query("AlarmMsgInfo", null, EnumC0031a.msgId.name() + " = " + str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null, null, null, null);
            } catch (Exception e3) {
                cursor2 = null;
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                if (e2 != null) {
                    e2.close();
                }
                return -2;
            }
            try {
                if (cursor.getCount() > 0) {
                    e2.execSQL("UPDATE AlarmMsgInfo SET " + EnumC0031a.msgEnable.name() + " = " + i2 + " WHERE " + EnumC0031a.msgId + " = " + str);
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
            } catch (Exception e4) {
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (e2 != null) {
                    e2.close();
                    i3 = -3;
                } else {
                    i3 = -3;
                }
                return i3;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                if (e2 != null) {
                    e2.close();
                }
                throw th;
            }
            return i3;
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
                i2 = -1;
                try {
                    i2 = e2.update("FileDownloadingInfo", contentValues, f.downloadUrl.name() + "=?", strArr);
                } catch (Exception e3) {
                }
                e2.close();
            }
        }
        return i2;
    }

    private static int a(SQLiteDatabase sQLiteDatabase, com.baidu.android.pushservice.h.j jVar) {
        if (sQLiteDatabase == null) {
            return 0;
        }
        String[] strArr = {jVar.b()};
        ContentValues contentValues = new ContentValues();
        contentValues.put(b.packageName.name(), jVar.b());
        if (!TextUtils.isEmpty(jVar.a())) {
            contentValues.put(b.appid.name(), jVar.a());
        }
        contentValues.put(b.appType.name(), Integer.valueOf(jVar.h()));
        contentValues.put(b.appName.name(), jVar.c());
        if (!TextUtils.isEmpty(jVar.d())) {
            contentValues.put(b.cFrom.name(), jVar.d());
        }
        contentValues.put(b.versionCode.name(), Integer.valueOf(jVar.e()));
        contentValues.put(b.versionName.name(), jVar.f());
        contentValues.put(b.intergratedPushVersion.name(), Integer.valueOf(jVar.g()));
        try {
            return sQLiteDatabase.update("AppInfo", contentValues, b.packageName.name() + " =?", strArr);
        } catch (Exception e2) {
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
                j2 = 0;
                try {
                    j2 = e2.insert("FileDownloadingInfo", null, contentValues);
                } catch (Exception e3) {
                }
                e2.close();
            }
        }
        return j2;
    }

    public static long a(Context context, com.baidu.android.pushservice.h.a aVar) {
        long j2 = -1;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(EnumC0031a.msgId.name(), aVar.a);
                contentValues.put(EnumC0031a.sendtime.name(), Long.valueOf(aVar.b));
                contentValues.put(EnumC0031a.showtime.name(), Long.valueOf(aVar.c));
                contentValues.put(EnumC0031a.expiretime.name(), Long.valueOf(aVar.d));
                contentValues.put(EnumC0031a.isAlarm.name(), Integer.valueOf(aVar.e));
                contentValues.put(EnumC0031a.msgEnable.name(), Integer.valueOf(aVar.f));
                try {
                    j2 = e2.insert("AlarmMsgInfo", null, contentValues);
                    p.b("AlarmMsgInfoEnum:  insert into database", context);
                } catch (Exception e3) {
                }
                e2.close();
            }
        }
        return j2;
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
                j2 = 0;
                try {
                    j2 = e2.insert("PushBehavior", null, contentValues);
                } catch (Exception e3) {
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
                j2 = 0;
                try {
                    j2 = e2.insert("PushBehavior", null, contentValues);
                } catch (Exception e3) {
                }
                e2.close();
            }
        }
        return j2;
    }

    public static long a(Context context, com.baidu.android.pushservice.h.i iVar) {
        long j2;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                j2 = -1;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(c.actionName.name(), iVar.d);
                contentValues.put(c.timeStamp.name(), Long.valueOf(iVar.e));
                contentValues.put(c.networkStatus.name(), iVar.f);
                contentValues.put(c.errorMsg.name(), iVar.i);
                contentValues.put(c.stableHeartInterval.name(), Integer.valueOf(iVar.a));
                contentValues.put(c.errorCode.name(), Integer.valueOf(iVar.g));
                contentValues.put(c.appid.name(), iVar.h);
                contentValues.put(c.msgId.name(), iVar.b);
                contentValues.put(c.openByPackageName.name(), iVar.c);
                j2 = 0;
                try {
                    j2 = e2.insert("PushBehavior", null, contentValues);
                } catch (Exception e3) {
                }
                e2.close();
            }
        }
        return j2;
    }

    public static long a(Context context, com.baidu.android.pushservice.h.j jVar) {
        long j2 = 0;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                j2 = -1;
            } else if (b(e2, jVar)) {
                e2.close();
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(b.appid.name(), jVar.a());
                contentValues.put(b.appType.name(), Integer.valueOf(jVar.h()));
                contentValues.put(b.packageName.name(), jVar.b());
                contentValues.put(b.appName.name(), jVar.c());
                contentValues.put(b.cFrom.name(), jVar.d());
                contentValues.put(b.versionCode.name(), Integer.valueOf(jVar.e()));
                contentValues.put(b.versionName.name(), jVar.f());
                contentValues.put(b.intergratedPushVersion.name(), Integer.valueOf(jVar.g()));
                try {
                    j2 = e2.insert("AppInfo", null, contentValues);
                } catch (Exception e3) {
                }
                e2.close();
            }
        }
        return j2;
    }

    public static long a(Context context, k kVar) {
        long j2 = -1;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(c.actionName.name(), kVar.d);
                contentValues.put(c.timeStamp.name(), Long.valueOf(kVar.e));
                contentValues.put(c.networkStatus.name(), kVar.f);
                if (kVar.h != null) {
                    contentValues.put(c.appid.name(), kVar.h);
                }
                contentValues.put(c.msgType.name(), Integer.valueOf(kVar.c));
                contentValues.put(c.msgId.name(), kVar.a);
                contentValues.put(c.msgLen.name(), Integer.valueOf(kVar.b));
                contentValues.put(c.errorCode.name(), Integer.valueOf(kVar.g));
                if (kVar.k != null) {
                    contentValues.put(c.openByPackageName.name(), kVar.k);
                }
                if (TextUtils.isEmpty(kVar.j)) {
                    e2.close();
                } else {
                    contentValues.put(c.packageName.name(), kVar.j);
                    try {
                        j2 = e2.insert("PushBehavior", null, contentValues);
                    } catch (Exception e3) {
                    }
                    e2.close();
                }
            }
        }
        return j2;
    }

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
                cursor = e2.query("NoDisturb", new String[]{i.pkgName.name()}, i.pkgName.name() + "= ?", new String[]{str}, null, null, null);
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(i.pkgName.name(), str);
                    contentValues.put(i.startHour.name(), Integer.valueOf(i2));
                    contentValues.put(i.startMinute.name(), Integer.valueOf(i3));
                    contentValues.put(i.endHour.name(), Integer.valueOf(i4));
                    contentValues.put(i.endMinute.name(), Integer.valueOf(i5));
                    j3 = (cursor == null || !cursor.moveToNext()) ? e2.insert("NoDisturb", null, contentValues) : (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) ? e2.delete("NoDisturb", i.pkgName.name() + "= ?", new String[]{str}) : e2.update("NoDisturb", contentValues, i.pkgName.name() + "= ?", new String[]{str});
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e3) {
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
                } catch (Throwable th) {
                    cursor2 = cursor;
                    th = th;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (e2 != null) {
                        e2.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
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

    public static g a(Context context, String str) {
        g gVar;
        g gVar2;
        g gVar3;
        Cursor cursor = null;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                return null;
            }
            try {
                Cursor query = e2.query("FileDownloadingInfo", null, "(" + f.downloadUrl.name() + "==?)", new String[]{str}, null, null, null);
                try {
                    try {
                        if (query.moveToFirst()) {
                            gVar3 = new g();
                            try {
                                gVar3.a = query.getString(query.getColumnIndex(f.belongTo.name()));
                                gVar3.b = query.getString(query.getColumnIndex(f.downloadUrl.name()));
                                gVar3.c = query.getString(query.getColumnIndex(f.title.name()));
                                gVar3.d = query.getString(query.getColumnIndex(f.description.name()));
                                gVar3.e = query.getString(query.getColumnIndex(f.savePath.name()));
                                gVar3.f = query.getString(query.getColumnIndex(f.fileName.name()));
                                gVar3.g = query.getInt(query.getColumnIndex(f.downloadBytes.name()));
                                gVar3.h = query.getInt(query.getColumnIndex(f.totalBytes.name()));
                                gVar3.i = query.getInt(query.getColumnIndex(f.downloadStatus.name()));
                                gVar3.j = query.getLong(query.getColumnIndex(f.timeStamp.name()));
                            } catch (Exception e3) {
                                cursor = query;
                                gVar = gVar3;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                e2.close();
                                gVar2 = gVar;
                                return gVar2;
                            }
                        } else {
                            gVar3 = null;
                        }
                        if (query != null) {
                            query.close();
                        }
                        e2.close();
                        gVar2 = gVar3;
                    } catch (Exception e4) {
                        gVar = null;
                        cursor = query;
                    }
                } catch (Throwable th) {
                    cursor = query;
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    e2.close();
                    throw th;
                }
            } catch (Exception e5) {
                gVar = null;
            } catch (Throwable th2) {
                th = th2;
            }
            return gVar2;
        }
    }

    public static List<com.baidu.android.pushservice.h.j> a(Context context) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                try {
                    Cursor rawQuery = e2.rawQuery("SELECT * FROM AppInfo;", null);
                    while (rawQuery.moveToNext()) {
                        try {
                            com.baidu.android.pushservice.h.j jVar = new com.baidu.android.pushservice.h.j();
                            jVar.a(rawQuery.getString(rawQuery.getColumnIndex(b.appid.name())));
                            jVar.c(rawQuery.getInt(rawQuery.getColumnIndex(b.appType.name())));
                            jVar.b(rawQuery.getString(rawQuery.getColumnIndex(b.packageName.name())));
                            jVar.c(rawQuery.getString(rawQuery.getColumnIndex(b.appName.name())));
                            jVar.d(rawQuery.getString(rawQuery.getColumnIndex(b.cFrom.name())));
                            jVar.a(rawQuery.getInt(rawQuery.getColumnIndex(b.versionCode.name())));
                            jVar.e(rawQuery.getString(rawQuery.getColumnIndex(b.versionName.name())));
                            jVar.b(rawQuery.getInt(rawQuery.getColumnIndex(b.intergratedPushVersion.name())));
                            arrayList.add(jVar);
                        } catch (Throwable th2) {
                            cursor = rawQuery;
                            th = th2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            e2.close();
                            throw th;
                        }
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    e2.close();
                } catch (Throwable th3) {
                    cursor = null;
                    th = th3;
                }
            } catch (Exception e3) {
                if (0 != 0) {
                    cursor2.close();
                }
                e2.close();
            }
            return arrayList;
        }
    }

    public static List<com.baidu.android.pushservice.h.e> a(Context context, long j2, long j3, int i2) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                try {
                    Cursor rawQuery = e2.rawQuery("SELECT * FROM PushBehavior WHERE " + c.timeStamp.name() + " < " + j2 + " AND " + c.timeStamp.name() + " >= " + j3 + " LIMIT " + i2 + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null);
                    while (rawQuery.moveToNext()) {
                        try {
                            com.baidu.android.pushservice.h.e eVar = new com.baidu.android.pushservice.h.e();
                            eVar.a(rawQuery.getInt(rawQuery.getColumnIndex(c.actionId.name())));
                            eVar.a(rawQuery.getString(rawQuery.getColumnIndex(c.actionName.name())));
                            eVar.f(rawQuery.getString(rawQuery.getColumnIndex(c.appid.name())));
                            eVar.g(rawQuery.getString(rawQuery.getColumnIndex(c.channel.name())));
                            eVar.e(rawQuery.getInt(rawQuery.getColumnIndex(c.errorCode.name())));
                            eVar.d(rawQuery.getString(rawQuery.getColumnIndex(c.errorMsg.name())));
                            eVar.c(rawQuery.getString(rawQuery.getColumnIndex(c.msgId.name())));
                            eVar.c(rawQuery.getInt(rawQuery.getColumnIndex(c.msgLen.name())));
                            eVar.b(rawQuery.getInt(rawQuery.getColumnIndex(c.msgType.name())));
                            eVar.b(rawQuery.getString(rawQuery.getColumnIndex(c.networkStatus.name())));
                            eVar.i(rawQuery.getString(rawQuery.getColumnIndex(c.openByPackageName.name())));
                            eVar.e(rawQuery.getString(rawQuery.getColumnIndex(c.requestId.name())));
                            eVar.d(rawQuery.getInt(rawQuery.getColumnIndex(c.stableHeartInterval.name())));
                            eVar.a(rawQuery.getLong(rawQuery.getColumnIndex(c.timeStamp.name())));
                            eVar.h(rawQuery.getString(rawQuery.getColumnIndex(c.packageName.name())));
                            arrayList.add(eVar);
                        } catch (Throwable th2) {
                            cursor = rawQuery;
                            th = th2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            e2.close();
                            throw th;
                        }
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    e2.close();
                } catch (Throwable th3) {
                    cursor = null;
                    th = th3;
                }
            } catch (Exception e3) {
                if (0 != 0) {
                    cursor2.close();
                }
                e2.close();
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
            }
        }
    }

    private static void a(final String str, Context context) {
        File[] listFiles;
        File parentFile = context.getDatabasePath("pushstat_6.0.0.db").getParentFile();
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

    private static boolean a(SQLiteDatabase sQLiteDatabase, com.baidu.android.pushservice.h.i iVar) {
        Cursor cursor;
        Cursor rawQuery;
        boolean z;
        Cursor cursor2 = null;
        if (sQLiteDatabase == null) {
            return true;
        }
        try {
            try {
                rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM PushBehavior WHERE " + c.actionName.name() + " = '" + iVar.d + "' AND " + c.errorCode.name() + " = " + iVar.g + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null);
            } catch (Exception e2) {
                cursor = null;
            }
            try {
                if (rawQuery.moveToNext()) {
                    iVar.a = rawQuery.getInt(rawQuery.getColumnIndex(c.stableHeartInterval.name()));
                    b(sQLiteDatabase, iVar);
                    z = true;
                } else {
                    z = false;
                }
            } catch (Exception e3) {
                cursor = rawQuery;
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
            if (!z) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return false;
            } else if (rawQuery != null) {
                rawQuery.close();
                return true;
            } else {
                return true;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor2.close();
            }
            throw th;
        }
    }

    public static int b(Context context, String str) {
        int i2 = 0;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 != null) {
                i2 = -1;
                try {
                    i2 = e2.delete("FileDownloadingInfo", f.downloadUrl.name() + "=?", new String[]{str});
                } catch (Exception e3) {
                }
                e2.close();
            }
        }
        return i2;
    }

    private static int b(SQLiteDatabase sQLiteDatabase, com.baidu.android.pushservice.h.i iVar) {
        if (sQLiteDatabase == null) {
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(c.actionName.name(), iVar.d);
        contentValues.put(c.timeStamp.name(), Long.valueOf(iVar.e));
        contentValues.put(c.networkStatus.name(), iVar.f);
        contentValues.put(c.stableHeartInterval.name(), Integer.valueOf(iVar.a + 1));
        contentValues.put(c.errorCode.name(), Integer.valueOf(iVar.g));
        contentValues.put(c.appid.name(), iVar.h);
        try {
            sQLiteDatabase.update("PushBehavior", contentValues, c.actionName.name() + " = '" + iVar.d + "' AND " + c.errorCode.name() + " = " + iVar.g + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null);
            return -1;
        } catch (Exception e2) {
            return -1;
        }
    }

    public static long b(Context context, com.baidu.android.pushservice.h.i iVar) {
        long j2 = 0;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                j2 = -1;
            } else if (!a(e2, iVar)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(c.actionName.name(), iVar.d);
                contentValues.put(c.timeStamp.name(), Long.valueOf(iVar.e));
                contentValues.put(c.networkStatus.name(), iVar.f);
                contentValues.put(c.stableHeartInterval.name(), (Integer) 1);
                contentValues.put(c.errorCode.name(), Integer.valueOf(iVar.g));
                contentValues.put(c.appid.name(), iVar.h);
                try {
                    j2 = e2.insert("PushBehavior", null, contentValues);
                } catch (Exception e3) {
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
                        if (cursor != null) {
                            cursor.close();
                        }
                        e2.close();
                        return arrayList;
                    } catch (Throwable th) {
                        cursor2 = cursor;
                        th = th;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        e2.close();
                        throw th;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                e2.close();
            } catch (Exception e4) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            return arrayList;
        }
    }

    public static boolean b(Context context, long j2, long j3) {
        boolean z;
        Cursor cursor;
        boolean z2 = false;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 != null) {
                try {
                    Cursor rawQuery = e2.rawQuery("SELECT " + c.actionName.name() + " FROM PushBehavior WHERE " + c.timeStamp.name() + " < " + j2 + " AND " + c.timeStamp.name() + " >= " + j3 + " ;", null);
                    while (rawQuery.moveToNext()) {
                        try {
                            String string = rawQuery.getString(0);
                            if (!TextUtils.isEmpty(string) && !string.startsWith(n.t)) {
                                z2 = true;
                            }
                        } catch (Exception e3) {
                            z = z2;
                            cursor = rawQuery;
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
                        }
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    if (z2) {
                        e2.close();
                    }
                } catch (Exception e4) {
                    z = false;
                    cursor = null;
                }
            }
        }
        return z2;
    }

    private static boolean b(SQLiteDatabase sQLiteDatabase, com.baidu.android.pushservice.h.j jVar) {
        Cursor cursor;
        Cursor cursor2 = null;
        if (sQLiteDatabase == null) {
            return false;
        }
        try {
            cursor = sQLiteDatabase.query("AppInfo", null, b.packageName.name() + " =?", new String[]{jVar.b()}, null, null, null);
            try {
            } catch (Exception e2) {
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th) {
                cursor2 = cursor;
                th = th;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
        if (!cursor.moveToNext()) {
            if (cursor != null) {
                cursor.close();
            }
            return false;
        }
        if (!TextUtils.equals(jVar.d(), cursor.getString(cursor.getColumnIndex(b.cFrom.name()))) || !TextUtils.equals(jVar.e() + "", cursor.getInt(cursor.getColumnIndex(b.versionCode.name())) + "") || !TextUtils.equals(jVar.g() + "", cursor.getString(cursor.getColumnIndex(b.intergratedPushVersion.name())))) {
            a(sQLiteDatabase, jVar);
        }
        if (cursor != null) {
            cursor.close();
        }
        return true;
    }

    public static com.baidu.android.pushservice.h.a c(Context context, String str) {
        Cursor query;
        Cursor cursor = null;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                return null;
            }
            com.baidu.android.pushservice.h.a aVar = new com.baidu.android.pushservice.h.a();
            try {
                query = e2.query("AlarmMsgInfo", null, EnumC0031a.msgId.name() + " = " + str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null, null, null, null);
            } catch (Exception e3) {
            } catch (Throwable th) {
                th = th;
            }
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                e2.close();
                return null;
            }
            try {
                if (query.getCount() > 0) {
                    query.moveToFirst();
                    aVar.b = query.getLong(query.getColumnIndex(EnumC0031a.sendtime.name()));
                    aVar.c = query.getLong(query.getColumnIndex(EnumC0031a.showtime.name()));
                    aVar.d = query.getLong(query.getColumnIndex(EnumC0031a.expiretime.name()));
                    aVar.e = query.getInt(query.getColumnIndex(EnumC0031a.isAlarm.name()));
                    aVar.f = query.getInt(query.getColumnIndex(EnumC0031a.msgEnable.name()));
                }
                if (query != null) {
                    query.close();
                }
                e2.close();
            } catch (Exception e4) {
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                e2.close();
                return aVar;
            } catch (Throwable th2) {
                cursor = query;
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                e2.close();
                throw th;
            }
            return aVar;
        }
    }

    public static void c(Context context) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == null) {
                return;
            }
            try {
                try {
                    Cursor rawQuery = e2.rawQuery("SELECT * FROM AlarmMsgInfo;", null);
                    while (rawQuery.moveToNext()) {
                        try {
                            com.baidu.android.pushservice.h.a aVar = new com.baidu.android.pushservice.h.a();
                            aVar.a = rawQuery.getString(rawQuery.getColumnIndex(EnumC0031a.msgId.name()));
                            aVar.b = rawQuery.getLong(rawQuery.getColumnIndex(EnumC0031a.sendtime.name()));
                            aVar.c = rawQuery.getLong(rawQuery.getColumnIndex(EnumC0031a.showtime.name()));
                            aVar.d = rawQuery.getLong(rawQuery.getColumnIndex(EnumC0031a.expiretime.name()));
                            aVar.e = rawQuery.getInt(rawQuery.getColumnIndex(EnumC0031a.isAlarm.name()));
                            aVar.f = rawQuery.getInt(rawQuery.getColumnIndex(EnumC0031a.msgEnable.name()));
                            if (aVar.f == 0 || aVar.d < System.currentTimeMillis()) {
                                d(context, aVar.a);
                            }
                        } catch (Throwable th2) {
                            cursor = rawQuery;
                            th = th2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (e2 != null) {
                                e2.close();
                            }
                            throw th;
                        }
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    if (e2 != null) {
                        e2.close();
                    }
                } catch (Exception e3) {
                    if (0 != 0) {
                        cursor2.close();
                    }
                    if (e2 != null) {
                        e2.close();
                    }
                }
            } catch (Throwable th3) {
                cursor = null;
                th = th3;
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
            if (e2 == null) {
                return;
            }
            try {
                cursor = e2.query("AlarmMsgInfo", null, EnumC0031a.msgId.name() + " = " + str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null, null, null, null);
            } catch (Exception e3) {
                cursor = null;
            } catch (Throwable th) {
                th = th;
            }
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                if (e2 != null) {
                    e2.close();
                }
                return;
            }
            try {
                e2.delete("AlarmMsgInfo", EnumC0031a.msgId.name() + "= ?", new String[]{str});
                if (cursor != null) {
                    cursor.close();
                }
                if (e2 != null) {
                    e2.close();
                }
            } catch (Exception e4) {
                if (cursor != null) {
                    cursor.close();
                }
                if (e2 != null) {
                    e2.close();
                }
            } catch (Throwable th2) {
                cursor2 = cursor;
                th = th2;
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (e2 != null) {
                    e2.close();
                }
                throw th;
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
        } catch (Throwable th) {
            return null;
        }
    }

    public static boolean e(Context context, String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
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
                            String str3 = "UPDATE MsgArriveApp SET " + h.timeStamp.name() + " = " + System.currentTimeMillis() + " WHERE " + h.msgId + " = " + str;
                            e2.update("MsgArriveApp", contentValues, str2, new String[]{str});
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            e2.close();
                            return false;
                        }
                    } catch (Exception e3) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        e2.close();
                        return true;
                    } catch (Throwable th) {
                        cursor2 = cursor;
                        th = th;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        e2.close();
                        throw th;
                    }
                }
                Cursor rawQuery = e2.rawQuery("SELECT COUNT(*) FROM MsgArriveApp;", null);
                rawQuery.moveToFirst();
                if (rawQuery.getInt(0) > d) {
                    e2.delete("MsgArriveApp", null, null);
                }
                e2.insert("MsgArriveApp", null, contentValues);
                if (rawQuery != null && !rawQuery.isClosed()) {
                    rawQuery.close();
                }
                e2.close();
                return true;
            } catch (Exception e4) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private static e f(Context context) {
        synchronized (c) {
            if (a == null) {
                String path = context.getDatabasePath("pushstat_6.0.0.db").getPath();
                a("pushstat_6.0.0.db", context);
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x00cf */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:59:? */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: android.database.sqlite.SQLiteDatabase */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ba A[Catch: all -> 0x00c1, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000a, B:20:0x0085, B:21:0x0088, B:22:0x008b, B:27:0x00a0, B:28:0x00a3, B:29:0x00a6, B:32:0x00ac, B:33:0x00af, B:34:0x00b2, B:47:0x00c8, B:48:0x00cb, B:49:0x00ce, B:39:0x00ba, B:40:0x00bd), top: B:54:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c8 A[Catch: all -> 0x00c1, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000a, B:20:0x0085, B:21:0x0088, B:22:0x008b, B:27:0x00a0, B:28:0x00a3, B:29:0x00a6, B:32:0x00ac, B:33:0x00af, B:34:0x00b2, B:47:0x00c8, B:48:0x00cb, B:49:0x00ce, B:39:0x00ba, B:40:0x00bd), top: B:54:0x0004 }] */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int[]] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00bd -> B:34:0x00b2). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int[] f(Context context, String str) {
        Cursor cursor;
        Cursor cursor2;
        SQLiteDatabase sQLiteDatabase;
        synchronized (c) {
            SQLiteDatabase e2 = e(context);
            if (e2 == 0) {
                return null;
            }
            try {
                cursor = e2.query("NoDisturb", null, i.pkgName.name() + "= ?", new String[]{str}, null, null, null);
            } catch (Exception e3) {
                cursor2 = null;
                sQLiteDatabase = e2;
                if (cursor2 != null) {
                    cursor2.close();
                }
                sQLiteDatabase.close();
                e2 = 0;
                return e2;
            } catch (Throwable th) {
                th = th;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                e2.close();
                throw th;
            }
            if (cursor != null) {
                try {
                } catch (Exception e4) {
                    cursor2 = cursor;
                    sQLiteDatabase = e2;
                    if (cursor2 != null) {
                    }
                    sQLiteDatabase.close();
                    e2 = 0;
                    return e2;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    e2.close();
                    throw th;
                }
                if (cursor.moveToNext()) {
                    int i2 = cursor.getInt(cursor.getColumnIndex(i.startHour.name()));
                    int i3 = cursor.getInt(cursor.getColumnIndex(i.startMinute.name()));
                    int i4 = cursor.getInt(cursor.getColumnIndex(i.endHour.name()));
                    int i5 = cursor.getInt(cursor.getColumnIndex(i.endMinute.name()));
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
