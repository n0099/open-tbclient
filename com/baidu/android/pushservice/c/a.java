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
/* loaded from: classes5.dex */
public class a {
    private static e a = null;
    private static final Object b = new Object();
    private static int c = 200;

    /* renamed from: com.baidu.android.pushservice.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    enum EnumC0042a {
        alarmMsgInfoId,
        msgId,
        sendtime,
        showtime,
        expiretime,
        msgEnable,
        isAlarm
    }

    /* loaded from: classes5.dex */
    enum b {
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

    /* loaded from: classes5.dex */
    enum c {
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
    /* loaded from: classes5.dex */
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
    /* loaded from: classes5.dex */
    public static class e extends SQLiteOpenHelper {
        private static final String a = "CREATE TABLE StatisticsInfo (" + i.info_id.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + i.packageName.name() + " TEXT NOT NULL, " + i.open_type.name() + " TEXT NOT NULL, " + i.msgid.name() + " TEXT, " + i.app_open_time.name() + " TEXT NOT NULL, " + i.app_close_time.name() + " TEXT NOT NULL, " + i.use_duration.name() + " TEXT NOT NULL, " + i.extra.name() + " TEXT);";
        private static final String b = "CREATE TABLE PushBehavior (" + c.actionId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.actionName.name() + " TEXT NOT NULL, " + c.timeStamp.name() + " LONG NOT NULL, " + c.networkStatus.name() + " TEXT, " + c.msgType.name() + " INTEGER, " + c.msgId.name() + " TEXT, " + c.msgLen.name() + " INTEGER, " + c.errorMsg.name() + " TEXT, " + c.requestId.name() + " TEXT, " + c.stableHeartInterval.name() + " INTEGER, " + c.errorCode.name() + " INTEGER, " + c.appid.name() + " TEXT, " + c.channel.name() + " TEXT, " + c.packageName.name() + " TEXT, " + c.openByPackageName.name() + " TEXT);";
        private static final String c = "CREATE TABLE MsgArriveApp (" + g.MsgInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + g.msgId.name() + " TEXT NOT NULL, " + g.timeStamp.name() + " LONG NOT NULL);";
        private static final String d = "CREATE TABLE AlarmMsgInfo (" + EnumC0042a.alarmMsgInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + EnumC0042a.msgId.name() + " TEXT NOT NULL, " + EnumC0042a.sendtime.name() + " LONG NOT NULL, " + EnumC0042a.showtime.name() + " LONG NOT NULL, " + EnumC0042a.expiretime.name() + " LONG NOT NULL, " + EnumC0042a.msgEnable.name() + " INTEGER, " + EnumC0042a.isAlarm.name() + " INTEGER);";
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    enum g {
        MsgInfoId,
        msgId,
        timeStamp
    }

    /* loaded from: classes5.dex */
    enum h {
        pkgName,
        startHour,
        startMinute,
        endHour,
        endMinute
    }

    /* loaded from: classes5.dex */
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

    public static long a(Context context, String str, int i2, int i3, int i4, int i5) {
        Cursor cursor;
        long j;
        synchronized (b) {
            long j2 = -1;
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return -1L;
            }
            Cursor cursor2 = null;
            try {
                cursor = a2.query("NoDisturb", new String[]{h.pkgName.name()}, h.pkgName.name() + "= ?", new String[]{str}, null, null, null);
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(h.pkgName.name(), str);
                    contentValues.put(h.startHour.name(), Integer.valueOf(i2));
                    contentValues.put(h.startMinute.name(), Integer.valueOf(i3));
                    contentValues.put(h.endHour.name(), Integer.valueOf(i4));
                    contentValues.put(h.endMinute.name(), Integer.valueOf(i5));
                    j2 = (cursor == null || !cursor.moveToNext()) ? a2.insert("NoDisturb", null, contentValues) : (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) ? a2.delete("NoDisturb", h.pkgName.name() + "= ?", new String[]{str}) : a2.update("NoDisturb", contentValues, h.pkgName.name() + "= ?", new String[]{str});
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    a2.close();
                    j = j2;
                } catch (Exception e2) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    a2.close();
                    j = j2;
                    return j;
                } catch (Throwable th) {
                    cursor2 = cursor;
                    th = th;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    a2.close();
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

    private static SQLiteDatabase a(Context context) {
        e b2 = b(context);
        if (b2 == null) {
            return null;
        }
        try {
            return b2.getWritableDatabase();
        } catch (Throwable th) {
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
            } catch (Exception e2) {
                a = null;
            }
        }
    }

    private static void a(final String str, Context context) {
        File[] listFiles;
        File parentFile = context.getDatabasePath("pushstat_6.9.13.db").getParentFile();
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
        Cursor cursor2 = null;
        synchronized (b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return true;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.clear();
                contentValues.put(g.msgId.name(), str);
                contentValues.put(g.timeStamp.name(), Long.valueOf(System.currentTimeMillis()));
                String str2 = g.msgId.name() + " =? ";
                cursor = a2.query("MsgArriveApp", new String[]{g.msgId.name()}, str2, new String[]{str}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0) {
                            a2.update("MsgArriveApp", contentValues, str2, new String[]{str});
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            return false;
                        }
                    } catch (Exception e2) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        return true;
                    } catch (Throwable th) {
                        cursor2 = cursor;
                        th = th;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        a2.close();
                        throw th;
                    }
                }
                Cursor rawQuery = a2.rawQuery("SELECT COUNT(*) FROM MsgArriveApp;", null);
                rawQuery.moveToFirst();
                if (rawQuery.getInt(0) > c) {
                    a2.delete("MsgArriveApp", null, null);
                }
                a2.insert("MsgArriveApp", null, contentValues);
                if (rawQuery != null && !rawQuery.isClosed()) {
                    rawQuery.close();
                }
                a2.close();
                return true;
            } catch (Exception e3) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private static e b(Context context) {
        synchronized (b) {
            if (a == null) {
                String path = context.getDatabasePath("pushstat_6.9.13.db").getPath();
                a("pushstat_6.9.13.db", context);
                if (Build.VERSION.SDK_INT >= 11) {
                    a = new e(context, path, 2, new d());
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
    public static int[] b(Context context, String str) {
        Cursor cursor;
        Cursor cursor2;
        SQLiteDatabase sQLiteDatabase;
        synchronized (b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == 0) {
                return null;
            }
            try {
                cursor = a2.query("NoDisturb", null, h.pkgName.name() + "= ?", new String[]{str}, null, null, null);
            } catch (Exception e2) {
                cursor2 = null;
                sQLiteDatabase = a2;
                if (cursor2 != null) {
                    cursor2.close();
                }
                sQLiteDatabase.close();
                a2 = 0;
                return a2;
            } catch (Throwable th) {
                th = th;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                a2.close();
                throw th;
            }
            if (cursor != null) {
                try {
                } catch (Exception e3) {
                    cursor2 = cursor;
                    sQLiteDatabase = a2;
                    if (cursor2 != null) {
                    }
                    sQLiteDatabase.close();
                    a2 = 0;
                    return a2;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    a2.close();
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
                        a2.close();
                        a2 = iArr;
                    } else {
                        int[] iArr2 = {i2, i3, i4, i5};
                        if (cursor != null) {
                            cursor.close();
                        }
                        a2.close();
                        a2 = iArr2;
                    }
                    return a2;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            a2.close();
            a2 = 0;
            return a2;
        }
    }
}
