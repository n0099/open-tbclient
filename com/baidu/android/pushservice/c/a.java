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
import android.util.Pair;
import java.io.File;
import java.io.FileFilter;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static e f2774a = null;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f2775b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static int f2776c = 200;

    /* renamed from: com.baidu.android.pushservice.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0030a {
        alarmMsgInfoId,
        msgId,
        sendtime,
        showtime,
        expiretime,
        msgEnable,
        isAlarm
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static class d implements DatabaseErrorHandler {
        public d() {
        }

        @TargetApi(16)
        private void a(String str) {
            if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
                try {
                    if (Build.VERSION.SDK_INT > 18) {
                        SQLiteDatabase.deleteDatabase(new File(str));
                    } else {
                        new File(str).delete();
                    }
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.database.DatabaseErrorHandler
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
            if (!sQLiteDatabase.isOpen()) {
                a(sQLiteDatabase.getPath());
                return;
            }
            List<Pair<String, String>> list = null;
            try {
                try {
                    list = sQLiteDatabase.getAttachedDbs();
                } finally {
                    if (list != null) {
                        for (Pair<String, String> next : list) {
                            a((String) next.second);
                        }
                    } else {
                        a(sQLiteDatabase.getPath());
                    }
                }
            } catch (SQLiteException unused) {
            }
            try {
                sQLiteDatabase.close();
            } catch (SQLiteException unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        public static final String f2836a = "CREATE TABLE StatisticsInfo (" + i.info_id.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + i.packageName.name() + " TEXT NOT NULL, " + i.open_type.name() + " TEXT NOT NULL, " + i.msgid.name() + " TEXT, " + i.app_open_time.name() + " TEXT NOT NULL, " + i.app_close_time.name() + " TEXT NOT NULL, " + i.use_duration.name() + " TEXT NOT NULL, " + i.extra.name() + " TEXT);";

        /* renamed from: b  reason: collision with root package name */
        public static final String f2837b = "CREATE TABLE PushBehavior (" + c.actionId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.actionName.name() + " TEXT NOT NULL, " + c.timeStamp.name() + " LONG NOT NULL, " + c.networkStatus.name() + " TEXT, " + c.msgType.name() + " INTEGER, " + c.msgId.name() + " TEXT, " + c.msgLen.name() + " INTEGER, " + c.errorMsg.name() + " TEXT, " + c.requestId.name() + " TEXT, " + c.stableHeartInterval.name() + " INTEGER, " + c.errorCode.name() + " INTEGER, " + c.appid.name() + " TEXT, " + c.channel.name() + " TEXT, " + c.packageName.name() + " TEXT, " + c.openByPackageName.name() + " TEXT);";

        /* renamed from: c  reason: collision with root package name */
        public static final String f2838c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f2839d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f2840e;

        /* renamed from: f  reason: collision with root package name */
        public static final String f2841f;

        /* renamed from: g  reason: collision with root package name */
        public static final String f2842g;

        static {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE MsgArriveApp (");
            sb.append(g.MsgInfoId.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(g.msgId.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(g.timeStamp.name());
            sb.append(" LONG NOT NULL);");
            f2838c = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE AlarmMsgInfo (");
            sb2.append(EnumC0030a.alarmMsgInfoId.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(EnumC0030a.msgId.name());
            sb2.append(" TEXT NOT NULL, ");
            sb2.append(EnumC0030a.sendtime.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC0030a.showtime.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC0030a.expiretime.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC0030a.msgEnable.name());
            sb2.append(" INTEGER, ");
            sb2.append(EnumC0030a.isAlarm.name());
            sb2.append(" INTEGER);");
            f2839d = sb2.toString();
            f2840e = "CREATE TABLE AppInfo (" + b.appInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + b.appid.name() + " TEXT, " + b.appType.name() + " INTEGER, " + b.packageName.name() + " TEXT UNIQUE, " + b.appName.name() + " TEXT, " + b.cFrom.name() + " TEXT, " + b.versionCode.name() + " TEXT, " + b.versionName.name() + " TEXT, " + b.intergratedPushVersion.name() + " TEXT);";
            f2841f = "CREATE TABLE FileDownloadingInfo (" + f.belongTo.name() + " TEXT, " + f.downloadUrl.name() + " TEXT PRIMARY KEY, " + f.savePath.name() + " TEXT NOT NULL, " + f.title.name() + " TEXT, " + f.description.name() + " TEXT, " + f.fileName.name() + " TEXT NOT NULL, " + f.downloadBytes.name() + " INTEGER NOT NULL, " + f.totalBytes.name() + " INTEGER NOT NULL, " + f.downloadStatus.name() + " INTEGER NOT NULL," + f.timeStamp.name() + " INTEGER NOT NULL);";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("CREATE TABLE NoDisturb (");
            sb3.append(h.pkgName.name());
            sb3.append(" TEXT NOT NULL, ");
            sb3.append(h.startHour.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.startMinute.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.endHour.name());
            sb3.append(" INTEGER, ");
            sb3.append(h.endMinute.name());
            sb3.append(" INTEGER);");
            f2842g = sb3.toString();
        }

        public e(Context context, String str, int i2) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
        }

        public e(Context context, String str, int i2, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i2, databaseErrorHandler);
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
            } catch (Exception unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(f2836a);
                sQLiteDatabase.execSQL(f2837b);
                sQLiteDatabase.execSQL(f2838c);
                sQLiteDatabase.execSQL(f2839d);
                sQLiteDatabase.execSQL(f2840e);
                sQLiteDatabase.execSQL(f2841f);
                sQLiteDatabase.execSQL(f2842g);
            } catch (Exception unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            a(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public enum g {
        MsgInfoId,
        msgId,
        timeStamp
    }

    /* loaded from: classes.dex */
    public enum h {
        pkgName,
        startHour,
        startMinute,
        endHour,
        endMinute
    }

    /* loaded from: classes.dex */
    public enum i {
        info_id,
        packageName,
        open_type,
        msgid,
        app_open_time,
        app_close_time,
        use_duration,
        extra
    }

    public static long a(Context context, String str, int i2, int i3, int i4, int i5) {
        int update;
        synchronized (f2775b) {
            long j = -1;
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return -1L;
            }
            Cursor cursor = null;
            try {
                Cursor query = a2.query("NoDisturb", new String[]{h.pkgName.name()}, h.pkgName.name() + "= ?", new String[]{str}, null, null, null);
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(h.pkgName.name(), str);
                    contentValues.put(h.startHour.name(), Integer.valueOf(i2));
                    contentValues.put(h.startMinute.name(), Integer.valueOf(i3));
                    contentValues.put(h.endHour.name(), Integer.valueOf(i4));
                    contentValues.put(h.endMinute.name(), Integer.valueOf(i5));
                    if (query == null || !query.moveToNext()) {
                        j = a2.insert("NoDisturb", null, contentValues);
                    } else {
                        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
                            update = a2.delete("NoDisturb", h.pkgName.name() + "= ?", new String[]{str});
                        } else {
                            update = a2.update("NoDisturb", contentValues, h.pkgName.name() + "= ?", new String[]{str});
                        }
                        j = update;
                    }
                    if (query != null) {
                        query.close();
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception unused) {
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    a2.close();
                    return j;
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    a2.close();
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
            a2.close();
            return j;
        }
    }

    public static SQLiteDatabase a(Context context) {
        e b2 = b(context);
        if (b2 == null) {
            return null;
        }
        try {
            return b2.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a() {
        synchronized (f2775b) {
            try {
                if (f2774a != null) {
                    f2774a.close();
                    f2774a = null;
                }
            } catch (Exception unused) {
                f2774a = null;
            }
        }
    }

    public static void a(final String str, Context context) {
        File[] listFiles;
        File parentFile = context.getDatabasePath("pushstat_8.0.0.db").getParentFile();
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

    public static boolean a(Context context, String str) {
        Cursor cursor;
        synchronized (f2775b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return true;
            }
            Cursor cursor2 = null;
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.clear();
                contentValues.put(g.msgId.name(), str);
                contentValues.put(g.timeStamp.name(), Long.valueOf(System.currentTimeMillis()));
                String str2 = g.msgId.name() + " =? ";
                Cursor query = a2.query("MsgArriveApp", new String[]{g.msgId.name()}, str2, new String[]{str}, null, null, null);
                if (query != null) {
                    try {
                        if (query.getCount() > 0) {
                            a2.update("MsgArriveApp", contentValues, str2, new String[]{str});
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            a2.close();
                            return false;
                        }
                    } catch (Exception unused) {
                        cursor = null;
                        cursor2 = query;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        a2.close();
                        return true;
                    } catch (Throwable th) {
                        th = th;
                        cursor = null;
                        cursor2 = query;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        a2.close();
                        throw th;
                    }
                }
                cursor = a2.rawQuery("SELECT COUNT(*) FROM MsgArriveApp;", null);
                try {
                    cursor.moveToFirst();
                    if (cursor.getInt(0) > f2776c) {
                        a2.delete("MsgArriveApp", null, null);
                    }
                    a2.insert("MsgArriveApp", null, contentValues);
                    if (query != null && !query.isClosed()) {
                        query.close();
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    return true;
                } catch (Exception unused2) {
                    cursor2 = query;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = query;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    throw th;
                }
            } catch (Exception unused3) {
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        }
    }

    public static e b(Context context) {
        synchronized (f2775b) {
            if (f2774a == null) {
                String path = context.getDatabasePath("pushstat_8.0.0.db").getPath();
                a("pushstat_8.0.0.db", context);
                if (Build.VERSION.SDK_INT >= 11) {
                    f2774a = new e(context, path, 2, new d());
                } else {
                    f2774a = new e(context, path, 2);
                }
            }
        }
        return f2774a;
    }

    public static int[] b(Context context, String str) {
        Cursor cursor;
        synchronized (f2775b) {
            SQLiteDatabase a2 = a(context);
            Cursor cursor2 = null;
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query("NoDisturb", null, h.pkgName.name() + "= ?", new String[]{str}, null, null, null);
                if (cursor != null) {
                    try {
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
                                a2.close();
                                return iArr;
                            }
                            int[] iArr2 = {i2, i3, i4, i5};
                            if (cursor != null) {
                                cursor.close();
                            }
                            a2.close();
                            return iArr2;
                        }
                    } catch (Exception unused) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        a2.close();
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        a2.close();
                        throw th;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            a2.close();
            return null;
        }
    }
}
