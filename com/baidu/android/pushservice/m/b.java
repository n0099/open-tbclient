package com.baidu.android.pushservice.m;

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
public class b {
    public static f a = null;
    public static final Object b = new Object();
    public static int c = 200;

    /* loaded from: classes.dex */
    public static class a implements FileFilter {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (file == null) {
                return false;
            }
            String name = file.getName();
            return name.contains("pushstat") && !name.contains(this.a);
        }
    }

    /* renamed from: com.baidu.android.pushservice.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0030b {
        alarmMsgInfoId,
        msgId,
        sendtime,
        showtime,
        expiretime,
        msgEnable,
        isAlarm
    }

    /* loaded from: classes.dex */
    public enum c {
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
        openByPackageName,
        packageName
    }

    /* loaded from: classes.dex */
    public static class e implements DatabaseErrorHandler {
        public e() {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }

        @TargetApi(16)
        public final void a(String str) {
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
    public static class f extends SQLiteOpenHelper {
        public static final String a = "CREATE TABLE StatisticsInfo (" + j.info_id.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + j.packageName.name() + " TEXT NOT NULL, " + j.open_type.name() + " TEXT NOT NULL, " + j.msgid.name() + " TEXT, " + j.app_open_time.name() + " TEXT NOT NULL, " + j.app_close_time.name() + " TEXT NOT NULL, " + j.use_duration.name() + " TEXT NOT NULL, " + j.extra.name() + " TEXT);";
        public static final String b = "CREATE TABLE PushBehavior (" + d.actionId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.actionName.name() + " TEXT NOT NULL, " + d.timeStamp.name() + " LONG NOT NULL, " + d.networkStatus.name() + " TEXT, " + d.msgType.name() + " INTEGER, " + d.msgId.name() + " TEXT, " + d.msgLen.name() + " INTEGER, " + d.errorMsg.name() + " TEXT, " + d.requestId.name() + " TEXT, " + d.stableHeartInterval.name() + " INTEGER, " + d.errorCode.name() + " INTEGER, " + d.appid.name() + " TEXT, " + d.channel.name() + " TEXT, " + d.packageName.name() + " TEXT, " + d.openByPackageName.name() + " TEXT);";
        public static final String c;
        public static final String d;
        public static final String e;
        public static final String f;
        public static final String g;

        static {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE MsgArriveApp (");
            sb.append(h.MsgInfoId.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(h.msgId.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(h.timeStamp.name());
            sb.append(" LONG NOT NULL);");
            c = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE AlarmMsgInfo (");
            sb2.append(EnumC0030b.alarmMsgInfoId.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(EnumC0030b.msgId.name());
            sb2.append(" TEXT NOT NULL, ");
            sb2.append(EnumC0030b.sendtime.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC0030b.showtime.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC0030b.expiretime.name());
            sb2.append(" LONG NOT NULL, ");
            sb2.append(EnumC0030b.msgEnable.name());
            sb2.append(" INTEGER, ");
            sb2.append(EnumC0030b.isAlarm.name());
            sb2.append(" INTEGER);");
            d = sb2.toString();
            e = "CREATE TABLE AppInfo (" + c.appInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.appid.name() + " TEXT, " + c.appType.name() + " INTEGER, " + c.packageName.name() + " TEXT UNIQUE, " + c.appName.name() + " TEXT, " + c.cFrom.name() + " TEXT, " + c.versionCode.name() + " TEXT, " + c.versionName.name() + " TEXT, " + c.intergratedPushVersion.name() + " TEXT);";
            f = "CREATE TABLE FileDownloadingInfo (" + g.belongTo.name() + " TEXT, " + g.downloadUrl.name() + " TEXT PRIMARY KEY, " + g.savePath.name() + " TEXT NOT NULL, " + g.title.name() + " TEXT, " + g.description.name() + " TEXT, " + g.fileName.name() + " TEXT NOT NULL, " + g.downloadBytes.name() + " INTEGER NOT NULL, " + g.totalBytes.name() + " INTEGER NOT NULL, " + g.downloadStatus.name() + " INTEGER NOT NULL," + g.timeStamp.name() + " INTEGER NOT NULL);";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("CREATE TABLE NoDisturb (");
            sb3.append(i.pkgName.name());
            sb3.append(" TEXT NOT NULL, ");
            sb3.append(i.startHour.name());
            sb3.append(" INTEGER, ");
            sb3.append(i.startMinute.name());
            sb3.append(" INTEGER, ");
            sb3.append(i.endHour.name());
            sb3.append(" INTEGER, ");
            sb3.append(i.endMinute.name());
            sb3.append(" INTEGER);");
            g = sb3.toString();
        }

        public f(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        }

        public f(Context context, String str, int i, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i, databaseErrorHandler);
        }

        public final void a(SQLiteDatabase sQLiteDatabase) {
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
                sQLiteDatabase.execSQL(a);
                sQLiteDatabase.execSQL(b);
                sQLiteDatabase.execSQL(c);
                sQLiteDatabase.execSQL(d);
                sQLiteDatabase.execSQL(e);
                sQLiteDatabase.execSQL(f);
                sQLiteDatabase.execSQL(g);
            } catch (Exception unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            a(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public enum h {
        MsgInfoId,
        msgId,
        timeStamp
    }

    /* loaded from: classes.dex */
    public enum i {
        pkgName,
        startHour,
        startMinute,
        endHour,
        endMinute
    }

    /* loaded from: classes.dex */
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

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00e7, code lost:
        if (r2 != null) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a(Context context, String str, int i2, int i3, int i4, int i5) {
        long insert;
        int update;
        synchronized (b) {
            SQLiteDatabase a2 = a(context);
            long j2 = -1;
            if (a2 == null) {
                return -1L;
            }
            Cursor cursor = null;
            try {
                Cursor cursor2 = a2.query("NoDisturb", new String[]{i.pkgName.name()}, i.pkgName.name() + "= ?", new String[]{str}, null, null, null);
                try {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(i.pkgName.name(), str);
                        contentValues.put(i.startHour.name(), Integer.valueOf(i2));
                        contentValues.put(i.startMinute.name(), Integer.valueOf(i3));
                        contentValues.put(i.endHour.name(), Integer.valueOf(i4));
                        contentValues.put(i.endMinute.name(), Integer.valueOf(i5));
                        if (cursor2 == null || !cursor2.moveToNext()) {
                            insert = a2.insert("NoDisturb", null, contentValues);
                        } else {
                            if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
                                update = a2.delete("NoDisturb", i.pkgName.name() + "= ?", new String[]{str});
                            } else {
                                update = a2.update("NoDisturb", contentValues, i.pkgName.name() + "= ?", new String[]{str});
                            }
                            insert = update;
                        }
                        j2 = insert;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception unused) {
                                if (cursor2 != null) {
                                }
                                a2.close();
                                return j2;
                            }
                        }
                    } catch (Exception unused2) {
                        cursor = cursor2;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        a2.close();
                        return j2;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursor2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    a2.close();
                    throw th;
                }
            } catch (Exception unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static SQLiteDatabase a(Context context) {
        f b2 = b(context);
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
        synchronized (b) {
            try {
                if (a != null) {
                    a.close();
                    a = null;
                }
            } catch (Exception unused) {
                a = null;
            }
        }
    }

    public static void a(String str, Context context) {
        File[] listFiles;
        File parentFile = context.getDatabasePath("pushstat_8.3.18.db").getParentFile();
        if (parentFile == null || !parentFile.isDirectory() || (listFiles = parentFile.listFiles(new a(str))) == null) {
            return;
        }
        for (File file : listFiles) {
            if (!file.isDirectory()) {
                file.delete();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a4, code lost:
        if (r13 != null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int[] a(Context context, String str) {
        Cursor cursor;
        synchronized (b) {
            SQLiteDatabase a2 = a(context);
            Cursor cursor2 = null;
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query("NoDisturb", null, i.pkgName.name() + "= ?", new String[]{str}, null, null, null);
                if (cursor != null) {
                    try {
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
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static f b(Context context) {
        synchronized (b) {
            if (a == null) {
                String path = context.getDatabasePath("pushstat_8.3.18.db").getPath();
                a("pushstat_8.3.18.db", context);
                a = Build.VERSION.SDK_INT >= 11 ? new f(context, path, 2, new e(null)) : new f(context, path, 2);
            }
        }
        return a;
    }

    public static boolean b(Context context, String str) {
        Cursor cursor;
        synchronized (b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return true;
            }
            Cursor cursor2 = null;
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.clear();
                contentValues.put(h.msgId.name(), str);
                contentValues.put(h.timeStamp.name(), Long.valueOf(System.currentTimeMillis()));
                String str2 = h.msgId.name() + " =? ";
                Cursor query = a2.query("MsgArriveApp", new String[]{h.msgId.name()}, str2, new String[]{str}, null, null, null);
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
                    if (cursor.getInt(0) > c) {
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
}
