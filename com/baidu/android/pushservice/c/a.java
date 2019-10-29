package com.baidu.android.pushservice.c;

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
import com.baidu.android.pushservice.g.j;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static e a = null;
    private static final Object b = new Object();
    private static int c = 200;

    /* renamed from: com.baidu.android.pushservice.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    enum EnumC0034a {
        alarmMsgInfoId,
        msgId,
        sendtime,
        showtime,
        expiretime,
        msgEnable,
        isAlarm
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
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
    /* loaded from: classes3.dex */
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
    /* loaded from: classes3.dex */
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
    /* loaded from: classes3.dex */
    public static class e extends SQLiteOpenHelper {
        private static final String a = "CREATE TABLE StatisticsInfo (" + i.info_id.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + i.packageName.name() + " TEXT NOT NULL, " + i.open_type.name() + " TEXT NOT NULL, " + i.msgid.name() + " TEXT, " + i.app_open_time.name() + " TEXT NOT NULL, " + i.app_close_time.name() + " TEXT NOT NULL, " + i.use_duration.name() + " TEXT NOT NULL, " + i.extra.name() + " TEXT);";
        private static final String b = "CREATE TABLE PushBehavior (" + c.actionId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.actionName.name() + " TEXT NOT NULL, " + c.timeStamp.name() + " LONG NOT NULL, " + c.networkStatus.name() + " TEXT, " + c.msgType.name() + " INTEGER, " + c.msgId.name() + " TEXT, " + c.msgLen.name() + " INTEGER, " + c.errorMsg.name() + " TEXT, " + c.requestId.name() + " TEXT, " + c.stableHeartInterval.name() + " INTEGER, " + c.errorCode.name() + " INTEGER, " + c.appid.name() + " TEXT, " + c.channel.name() + " TEXT, " + c.packageName.name() + " TEXT, " + c.openByPackageName.name() + " TEXT);";
        private static final String c = "CREATE TABLE MsgArriveApp (" + g.MsgInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + g.msgId.name() + " TEXT NOT NULL, " + g.timeStamp.name() + " LONG NOT NULL);";
        private static final String d = "CREATE TABLE AlarmMsgInfo (" + EnumC0034a.alarmMsgInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + EnumC0034a.msgId.name() + " TEXT NOT NULL, " + EnumC0034a.sendtime.name() + " LONG NOT NULL, " + EnumC0034a.showtime.name() + " LONG NOT NULL, " + EnumC0034a.expiretime.name() + " LONG NOT NULL, " + EnumC0034a.msgEnable.name() + " INTEGER, " + EnumC0034a.isAlarm.name() + " INTEGER);";
        private static final String e = "CREATE TABLE AppInfo (" + b.appInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + b.appid.name() + " TEXT, " + b.appType.name() + " INTEGER, " + b.packageName.name() + " TEXT UNIQUE, " + b.appName.name() + " TEXT, " + b.cFrom.name() + " TEXT, " + b.versionCode.name() + " TEXT, " + b.versionName.name() + " TEXT, " + b.intergratedPushVersion.name() + " TEXT);";
        private static final String f = "CREATE TABLE FileDownloadingInfo (" + f.belongTo.name() + " TEXT, " + f.downloadUrl.name() + " TEXT PRIMARY KEY, " + f.savePath.name() + " TEXT NOT NULL, " + f.title.name() + " TEXT, " + f.description.name() + " TEXT, " + f.fileName.name() + " TEXT NOT NULL, " + f.downloadBytes.name() + " INTEGER NOT NULL, " + f.totalBytes.name() + " INTEGER NOT NULL, " + f.downloadStatus.name() + " INTEGER NOT NULL," + f.timeStamp.name() + " INTEGER NOT NULL);";
        private static final String g = "CREATE TABLE NoDisturb (" + h.pkgName.name() + " TEXT NOT NULL, " + h.startHour.name() + " INTEGER, " + h.startMinute.name() + " INTEGER, " + h.endHour.name() + " INTEGER, " + h.endMinute.name() + " INTEGER);";

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

    /* loaded from: classes3.dex */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum g {
        MsgInfoId,
        msgId,
        timeStamp
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum h {
        pkgName,
        startHour,
        startMinute,
        endHour,
        endMinute
    }

    /* loaded from: classes3.dex */
    enum i {
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
    public static int a(Context context, long j, long j2) {
        Cursor cursor = null;
        int i2 = 0;
        synchronized (b) {
            SQLiteDatabase c2 = c(context);
            if (c2 != null) {
                try {
                    cursor = c2.rawQuery("SELECT COUNT(*) FROM PushBehavior WHERE " + c.timeStamp.name() + " < " + j + " AND " + c.timeStamp.name() + " >= " + j2 + " ;", null);
                    cursor.moveToFirst();
                    i2 = cursor.getInt(0);
                    if (cursor != null) {
                        cursor.close();
                    }
                    c2.close();
                } catch (Exception e2) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    c2.close();
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    c2.close();
                    throw th;
                }
            }
        }
        return i2;
    }

    private static int a(SQLiteDatabase sQLiteDatabase, com.baidu.android.pushservice.g.g gVar) {
        if (sQLiteDatabase == null) {
            return 0;
        }
        String[] strArr = {gVar.b()};
        ContentValues contentValues = new ContentValues();
        contentValues.put(b.packageName.name(), gVar.b());
        if (!TextUtils.isEmpty(gVar.a())) {
            contentValues.put(b.appid.name(), gVar.a());
        }
        contentValues.put(b.appType.name(), Integer.valueOf(gVar.h()));
        contentValues.put(b.appName.name(), gVar.c());
        if (!TextUtils.isEmpty(gVar.d())) {
            contentValues.put(b.cFrom.name(), gVar.d());
        }
        contentValues.put(b.versionCode.name(), Integer.valueOf(gVar.e()));
        contentValues.put(b.versionName.name(), gVar.f());
        contentValues.put(b.intergratedPushVersion.name(), Integer.valueOf(gVar.g()));
        try {
            return sQLiteDatabase.update("AppInfo", contentValues, b.packageName.name() + " =?", strArr);
        } catch (Exception e2) {
            return -1;
        }
    }

    public static long a(Context context, com.baidu.android.pushservice.g.a aVar) {
        long j;
        synchronized (b) {
            SQLiteDatabase c2 = c(context);
            if (c2 == null) {
                j = -1;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(c.actionName.name(), aVar.d);
                contentValues.put(c.timeStamp.name(), Long.valueOf(aVar.e));
                contentValues.put(c.networkStatus.name(), aVar.f);
                contentValues.put(c.appid.name(), aVar.h);
                contentValues.put(c.errorMsg.name(), aVar.a);
                contentValues.put(c.requestId.name(), aVar.b);
                contentValues.put(c.errorCode.name(), Integer.valueOf(aVar.g));
                contentValues.put(c.packageName.name(), aVar.j);
                if (aVar.c != null) {
                    contentValues.put(c.channel.name(), aVar.c);
                }
                j = 0;
                try {
                    j = c2.insert("PushBehavior", null, contentValues);
                } catch (Exception e2) {
                }
                c2.close();
            }
        }
        return j;
    }

    public static long a(Context context, com.baidu.android.pushservice.g.e eVar) {
        long j;
        synchronized (b) {
            SQLiteDatabase c2 = c(context);
            if (c2 == null) {
                j = -1;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(c.actionName.name(), eVar.d);
                contentValues.put(c.timeStamp.name(), Long.valueOf(eVar.e));
                contentValues.put(c.networkStatus.name(), eVar.f);
                contentValues.put(c.errorMsg.name(), eVar.a);
                contentValues.put(c.appid.name(), eVar.h);
                j = 0;
                try {
                    j = c2.insert("PushBehavior", null, contentValues);
                } catch (Exception e2) {
                }
                c2.close();
            }
        }
        return j;
    }

    public static long a(Context context, com.baidu.android.pushservice.g.f fVar) {
        long j;
        synchronized (b) {
            SQLiteDatabase c2 = c(context);
            if (c2 == null) {
                j = -1;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(c.actionName.name(), fVar.d);
                contentValues.put(c.timeStamp.name(), Long.valueOf(fVar.e));
                contentValues.put(c.networkStatus.name(), fVar.f);
                contentValues.put(c.errorMsg.name(), fVar.i);
                contentValues.put(c.stableHeartInterval.name(), Integer.valueOf(fVar.a));
                contentValues.put(c.errorCode.name(), Integer.valueOf(fVar.g));
                contentValues.put(c.appid.name(), fVar.h);
                contentValues.put(c.msgId.name(), fVar.b);
                contentValues.put(c.openByPackageName.name(), fVar.c);
                j = 0;
                try {
                    j = c2.insert("PushBehavior", null, contentValues);
                } catch (Exception e2) {
                }
                c2.close();
            }
        }
        return j;
    }

    public static long a(Context context, com.baidu.android.pushservice.g.g gVar) {
        long j = 0;
        synchronized (b) {
            SQLiteDatabase c2 = c(context);
            if (c2 == null) {
                j = -1;
            } else if (b(c2, gVar)) {
                c2.close();
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(b.appid.name(), gVar.a());
                contentValues.put(b.appType.name(), Integer.valueOf(gVar.h()));
                contentValues.put(b.packageName.name(), gVar.b());
                contentValues.put(b.appName.name(), gVar.c());
                contentValues.put(b.cFrom.name(), gVar.d());
                contentValues.put(b.versionCode.name(), Integer.valueOf(gVar.e()));
                contentValues.put(b.versionName.name(), gVar.f());
                contentValues.put(b.intergratedPushVersion.name(), Integer.valueOf(gVar.g()));
                try {
                    j = c2.insert("AppInfo", null, contentValues);
                } catch (Exception e2) {
                }
                c2.close();
            }
        }
        return j;
    }

    public static long a(Context context, com.baidu.android.pushservice.g.h hVar) {
        long j = -1;
        synchronized (b) {
            SQLiteDatabase c2 = c(context);
            if (c2 != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(c.actionName.name(), hVar.d);
                contentValues.put(c.timeStamp.name(), Long.valueOf(hVar.e));
                contentValues.put(c.networkStatus.name(), hVar.f);
                if (hVar.h != null) {
                    contentValues.put(c.appid.name(), hVar.h);
                }
                contentValues.put(c.msgType.name(), Integer.valueOf(hVar.c));
                contentValues.put(c.msgId.name(), hVar.a);
                contentValues.put(c.msgLen.name(), Integer.valueOf(hVar.b));
                contentValues.put(c.errorCode.name(), Integer.valueOf(hVar.g));
                if (hVar.k != null) {
                    contentValues.put(c.openByPackageName.name(), hVar.k);
                }
                if (TextUtils.isEmpty(hVar.j)) {
                    c2.close();
                } else {
                    contentValues.put(c.packageName.name(), hVar.j);
                    try {
                        j = c2.insert("PushBehavior", null, contentValues);
                    } catch (Exception e2) {
                    }
                    c2.close();
                }
            }
        }
        return j;
    }

    public static long a(Context context, String str, int i2, int i3, int i4, int i5) {
        Cursor cursor;
        long j;
        synchronized (b) {
            long j2 = -1;
            SQLiteDatabase c2 = c(context);
            if (c2 == null) {
                return -1L;
            }
            Cursor cursor2 = null;
            try {
                cursor = c2.query("NoDisturb", new String[]{h.pkgName.name()}, h.pkgName.name() + "= ?", new String[]{str}, null, null, null);
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(h.pkgName.name(), str);
                    contentValues.put(h.startHour.name(), Integer.valueOf(i2));
                    contentValues.put(h.startMinute.name(), Integer.valueOf(i3));
                    contentValues.put(h.endHour.name(), Integer.valueOf(i4));
                    contentValues.put(h.endMinute.name(), Integer.valueOf(i5));
                    j2 = (cursor == null || !cursor.moveToNext()) ? c2.insert("NoDisturb", null, contentValues) : (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) ? c2.delete("NoDisturb", h.pkgName.name() + "= ?", new String[]{str}) : c2.update("NoDisturb", contentValues, h.pkgName.name() + "= ?", new String[]{str});
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    c2.close();
                    j = j2;
                } catch (Exception e2) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    c2.close();
                    j = j2;
                    return j;
                } catch (Throwable th) {
                    cursor2 = cursor;
                    th = th;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    c2.close();
                    throw th;
                }
            } catch (Exception e3) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            return j;
        }
    }

    public static List<com.baidu.android.pushservice.g.g> a(Context context) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        synchronized (b) {
            SQLiteDatabase c2 = c(context);
            if (c2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                try {
                    Cursor rawQuery = c2.rawQuery("SELECT * FROM AppInfo;", null);
                    while (rawQuery.moveToNext()) {
                        try {
                            com.baidu.android.pushservice.g.g gVar = new com.baidu.android.pushservice.g.g();
                            gVar.a(rawQuery.getString(rawQuery.getColumnIndex(b.appid.name())));
                            gVar.c(rawQuery.getInt(rawQuery.getColumnIndex(b.appType.name())));
                            gVar.b(rawQuery.getString(rawQuery.getColumnIndex(b.packageName.name())));
                            gVar.c(rawQuery.getString(rawQuery.getColumnIndex(b.appName.name())));
                            gVar.d(rawQuery.getString(rawQuery.getColumnIndex(b.cFrom.name())));
                            gVar.a(rawQuery.getInt(rawQuery.getColumnIndex(b.versionCode.name())));
                            gVar.e(rawQuery.getString(rawQuery.getColumnIndex(b.versionName.name())));
                            gVar.b(rawQuery.getInt(rawQuery.getColumnIndex(b.intergratedPushVersion.name())));
                            arrayList.add(gVar);
                        } catch (Throwable th2) {
                            cursor = rawQuery;
                            th = th2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            c2.close();
                            throw th;
                        }
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    c2.close();
                } catch (Throwable th3) {
                    cursor = null;
                    th = th3;
                }
            } catch (Exception e2) {
                if (0 != 0) {
                    cursor2.close();
                }
                c2.close();
            }
            return arrayList;
        }
    }

    public static List<com.baidu.android.pushservice.g.d> a(Context context, long j, long j2, int i2) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        synchronized (b) {
            SQLiteDatabase c2 = c(context);
            if (c2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                try {
                    Cursor rawQuery = c2.rawQuery("SELECT * FROM PushBehavior WHERE " + c.timeStamp.name() + " < " + j + " AND " + c.timeStamp.name() + " >= " + j2 + " LIMIT " + i2 + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null);
                    while (rawQuery.moveToNext()) {
                        try {
                            com.baidu.android.pushservice.g.d dVar = new com.baidu.android.pushservice.g.d();
                            dVar.a(rawQuery.getInt(rawQuery.getColumnIndex(c.actionId.name())));
                            dVar.a(rawQuery.getString(rawQuery.getColumnIndex(c.actionName.name())));
                            dVar.f(rawQuery.getString(rawQuery.getColumnIndex(c.appid.name())));
                            dVar.g(rawQuery.getString(rawQuery.getColumnIndex(c.channel.name())));
                            dVar.e(rawQuery.getInt(rawQuery.getColumnIndex(c.errorCode.name())));
                            dVar.d(rawQuery.getString(rawQuery.getColumnIndex(c.errorMsg.name())));
                            dVar.c(rawQuery.getString(rawQuery.getColumnIndex(c.msgId.name())));
                            dVar.c(rawQuery.getInt(rawQuery.getColumnIndex(c.msgLen.name())));
                            dVar.b(rawQuery.getInt(rawQuery.getColumnIndex(c.msgType.name())));
                            dVar.b(rawQuery.getString(rawQuery.getColumnIndex(c.networkStatus.name())));
                            dVar.i(rawQuery.getString(rawQuery.getColumnIndex(c.openByPackageName.name())));
                            dVar.e(rawQuery.getString(rawQuery.getColumnIndex(c.requestId.name())));
                            dVar.d(rawQuery.getInt(rawQuery.getColumnIndex(c.stableHeartInterval.name())));
                            dVar.a(rawQuery.getLong(rawQuery.getColumnIndex(c.timeStamp.name())));
                            dVar.h(rawQuery.getString(rawQuery.getColumnIndex(c.packageName.name())));
                            arrayList.add(dVar);
                        } catch (Throwable th2) {
                            cursor = rawQuery;
                            th = th2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            c2.close();
                            throw th;
                        }
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    c2.close();
                } catch (Throwable th3) {
                    cursor = null;
                    th = th3;
                }
            } catch (Exception e2) {
                if (0 != 0) {
                    cursor2.close();
                }
                c2.close();
            }
            return arrayList;
        }
    }

    public static void a() {
        synchronized (b) {
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
        File parentFile = context.getDatabasePath("pushstat_6.7.2.db").getParentFile();
        if (parentFile == null || !parentFile.isDirectory() || (listFiles = parentFile.listFiles(new FileFilter() { // from class: com.baidu.android.pushservice.c.a.1
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

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0101: MOVE  (r10 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:61:0x0101 */
    public static boolean a(Context context, String str) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2;
        Cursor cursor3 = null;
        synchronized (b) {
            SQLiteDatabase c2 = c(context);
            try {
                if (c2 == null) {
                    return true;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.clear();
                    contentValues.put(g.msgId.name(), str);
                    contentValues.put(g.timeStamp.name(), Long.valueOf(System.currentTimeMillis()));
                    String str2 = g.msgId.name() + " =? ";
                    cursor2 = c2.query("MsgArriveApp", new String[]{g.msgId.name()}, str2, new String[]{str}, null, null, null);
                    if (cursor2 != null) {
                        try {
                            if (cursor2.getCount() > 0) {
                                c2.update("MsgArriveApp", contentValues, str2, new String[]{str});
                                if (cursor2 != null && !cursor2.isClosed()) {
                                    cursor2.close();
                                }
                                c2.close();
                                return false;
                            }
                        } catch (Exception e2) {
                            if (com.baidu.android.pushservice.a.d(context)) {
                                if (cursor2 != null && !cursor2.isClosed()) {
                                    cursor2.close();
                                }
                                c2.close();
                                return false;
                            }
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            c2.close();
                            return true;
                        }
                    }
                    Cursor rawQuery = c2.rawQuery("SELECT COUNT(*) FROM MsgArriveApp;", null);
                    rawQuery.moveToFirst();
                    if (rawQuery.getInt(0) > c) {
                        c2.delete("MsgArriveApp", null, null);
                    }
                    c2.insert("MsgArriveApp", null, contentValues);
                    if (rawQuery != null && !rawQuery.isClosed()) {
                        rawQuery.close();
                    }
                    c2.close();
                    return true;
                } catch (Exception e3) {
                    cursor2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor3 != null && !cursor3.isClosed()) {
                        cursor3.close();
                    }
                    c2.close();
                    throw th;
                }
            } catch (Throwable th3) {
                cursor3 = cursor;
                th = th3;
            }
        }
    }

    private static boolean a(SQLiteDatabase sQLiteDatabase, com.baidu.android.pushservice.g.f fVar) {
        Cursor cursor;
        Cursor rawQuery;
        boolean z;
        Cursor cursor2 = null;
        if (sQLiteDatabase == null) {
            return true;
        }
        try {
            try {
                rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM PushBehavior WHERE " + c.actionName.name() + " = '" + fVar.d + "' AND " + c.errorCode.name() + " = " + fVar.g + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null);
            } catch (Exception e2) {
                cursor = null;
            }
            try {
                if (rawQuery.moveToNext()) {
                    fVar.a = rawQuery.getInt(rawQuery.getColumnIndex(c.stableHeartInterval.name()));
                    b(sQLiteDatabase, fVar);
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

    private static int b(SQLiteDatabase sQLiteDatabase, com.baidu.android.pushservice.g.f fVar) {
        if (sQLiteDatabase == null) {
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(c.actionName.name(), fVar.d);
        contentValues.put(c.timeStamp.name(), Long.valueOf(fVar.e));
        contentValues.put(c.networkStatus.name(), fVar.f);
        contentValues.put(c.stableHeartInterval.name(), Integer.valueOf(fVar.a + 1));
        contentValues.put(c.errorCode.name(), Integer.valueOf(fVar.g));
        contentValues.put(c.appid.name(), fVar.h);
        try {
            sQLiteDatabase.update("PushBehavior", contentValues, c.actionName.name() + " = '" + fVar.d + "' AND " + c.errorCode.name() + " = " + fVar.g + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, null);
            return -1;
        } catch (Exception e2) {
            return -1;
        }
    }

    public static long b(Context context) {
        long j;
        synchronized (b) {
            SQLiteDatabase c2 = c(context);
            if (c2 == null) {
                j = 0;
            } else {
                try {
                    c2.delete("PushBehavior", null, null);
                    c2.delete("AppInfo", null, null);
                } catch (Exception e2) {
                }
                c2.close();
                j = -1;
            }
        }
        return j;
    }

    public static long b(Context context, com.baidu.android.pushservice.g.f fVar) {
        long j = 0;
        synchronized (b) {
            SQLiteDatabase c2 = c(context);
            if (c2 == null) {
                j = -1;
            } else if (a(c2, fVar)) {
                c2.close();
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(c.actionName.name(), fVar.d);
                contentValues.put(c.timeStamp.name(), Long.valueOf(fVar.e));
                contentValues.put(c.networkStatus.name(), fVar.f);
                contentValues.put(c.stableHeartInterval.name(), (Integer) 1);
                contentValues.put(c.errorCode.name(), Integer.valueOf(fVar.g));
                contentValues.put(c.appid.name(), fVar.h);
                try {
                    j = c2.insert("PushBehavior", null, contentValues);
                } catch (Exception e2) {
                }
                c2.close();
            }
        }
        return j;
    }

    public static boolean b(Context context, long j, long j2) {
        boolean z;
        Cursor cursor;
        boolean z2 = false;
        synchronized (b) {
            SQLiteDatabase c2 = c(context);
            if (c2 != null) {
                try {
                    Cursor rawQuery = c2.rawQuery("SELECT " + c.actionName.name() + " FROM PushBehavior WHERE " + c.timeStamp.name() + " < " + j + " AND " + c.timeStamp.name() + " >= " + j2 + " ;", null);
                    while (rawQuery.moveToNext()) {
                        try {
                            String string = rawQuery.getString(0);
                            if (!TextUtils.isEmpty(string) && !string.startsWith(j.t)) {
                                z2 = true;
                            }
                        } catch (Exception e2) {
                            z = z2;
                            cursor = rawQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (z) {
                                c2.close();
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
                        c2.close();
                    }
                } catch (Exception e3) {
                    z = false;
                    cursor = null;
                }
            }
        }
        return z2;
    }

    private static boolean b(SQLiteDatabase sQLiteDatabase, com.baidu.android.pushservice.g.g gVar) {
        Cursor cursor;
        Cursor cursor2 = null;
        if (sQLiteDatabase == null) {
            return false;
        }
        try {
            cursor = sQLiteDatabase.query("AppInfo", null, b.packageName.name() + " =?", new String[]{gVar.b()}, null, null, null);
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
        if (!TextUtils.equals(gVar.d(), cursor.getString(cursor.getColumnIndex(b.cFrom.name()))) || !TextUtils.equals(gVar.e() + "", cursor.getInt(cursor.getColumnIndex(b.versionCode.name())) + "") || !TextUtils.equals(gVar.g() + "", cursor.getString(cursor.getColumnIndex(b.intergratedPushVersion.name())))) {
            a(sQLiteDatabase, gVar);
        }
        if (cursor != null) {
            cursor.close();
        }
        return true;
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
    public static int[] b(Context context, String str) {
        Cursor cursor;
        Cursor cursor2;
        SQLiteDatabase sQLiteDatabase;
        synchronized (b) {
            SQLiteDatabase c2 = c(context);
            if (c2 == 0) {
                return null;
            }
            try {
                cursor = c2.query("NoDisturb", null, h.pkgName.name() + "= ?", new String[]{str}, null, null, null);
            } catch (Exception e2) {
                cursor2 = null;
                sQLiteDatabase = c2;
                if (cursor2 != null) {
                    cursor2.close();
                }
                sQLiteDatabase.close();
                c2 = 0;
                return c2;
            } catch (Throwable th) {
                th = th;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                c2.close();
                throw th;
            }
            if (cursor != null) {
                try {
                } catch (Exception e3) {
                    cursor2 = cursor;
                    sQLiteDatabase = c2;
                    if (cursor2 != null) {
                    }
                    sQLiteDatabase.close();
                    c2 = 0;
                    return c2;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    c2.close();
                    throw th;
                }
                if (cursor.moveToNext()) {
                    int i2 = cursor.getInt(cursor.getColumnIndex(h.startHour.name()));
                    int i3 = cursor.getInt(cursor.getColumnIndex(h.startMinute.name()));
                    int i4 = cursor.getInt(cursor.getColumnIndex(h.endHour.name()));
                    int i5 = cursor.getInt(cursor.getColumnIndex(h.endMinute.name()));
                    if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
                        int[] iArr = new int[0];
                        if (cursor != null) {
                            cursor.close();
                        }
                        c2.close();
                        c2 = iArr;
                    } else {
                        int[] iArr2 = {i2, i3, i4, i5};
                        if (cursor != null) {
                            cursor.close();
                        }
                        c2.close();
                        c2 = iArr2;
                    }
                    return c2;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            c2.close();
            c2 = 0;
            return c2;
        }
    }

    private static SQLiteDatabase c(Context context) {
        e d2 = d(context);
        if (d2 == null) {
            return null;
        }
        try {
            return d2.getWritableDatabase();
        } catch (Throwable th) {
            return null;
        }
    }

    private static e d(Context context) {
        synchronized (b) {
            if (a == null) {
                String path = context.getDatabasePath("pushstat_6.7.2.db").getPath();
                a("pushstat_6.7.2.db", context);
                if (Build.VERSION.SDK_INT >= 11) {
                    a = new e(context, path, 2, new d());
                } else {
                    a = new e(context, path, 2);
                }
            }
        }
        return a;
    }
}
