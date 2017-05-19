package com.baidu.android.pushservice.h;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Pair;
import com.baidu.android.pushservice.PushInfoProvider;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class q {
    private static b a = null;
    private static a b = null;
    private static Object c = new Object();
    private static int d = 100;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements DatabaseErrorHandler {
        private a() {
        }

        private void a(String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            com.baidu.android.pushservice.e.a.e("PushInfoDataBase", "deleting the database file: " + str);
            try {
                if (Build.VERSION.SDK_INT > 18) {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } else {
                    new File(str).delete();
                }
            } catch (Exception e) {
                com.baidu.android.pushservice.e.a.d("PushInfoDataBase", "delete failed: " + e.getMessage());
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
            com.baidu.android.pushservice.e.a.e("PushInfoDataBase", "Corruption reported by sqlite on database: " + sQLiteDatabase.getPath());
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
    public static class b extends SQLiteOpenHelper {
        public b(Context context, String str, int i, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i, databaseErrorHandler);
        }

        public b(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushShareInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushVerifInfo");
            } catch (Exception e) {
                com.baidu.android.pushservice.e.a.c("PushInfoDataBase", "dropTables Exception: " + e);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE PushShareInfo (" + c.PushInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.PushPriority.name() + " LONG  NOT NULL DEFAULT ((0)), " + c.PushVersion.name() + " INTEGER DEFAULT ((0)), " + c.PushChannelID.name() + " TEXT, " + c.PushCurPkgName.name() + " TEXT, " + c.PushWebAppBindInfo.name() + " TEXT, " + c.PushLightAppBindInfo.name() + " TEXT, " + c.PushSDKClientBindInfo.name() + " TEXT, " + c.PushClientsBindInfo.name() + " TEXT, " + c.PushSelfBindInfo.name() + " TEXT );");
                com.baidu.android.pushservice.e.a.c("PushInfoDataBase", "CREATE TABLE PushShareInfo (" + c.PushInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.PushPriority.name() + " INTEGER DEFAULT ((0)), " + c.PushVersion.name() + " INTEGER DEFAULT ((0)), " + c.PushChannelID.name() + " TEXT, " + c.PushCurPkgName.name() + " TEXT, " + c.PushWebAppBindInfo.name() + " TEXT, " + c.PushLightAppBindInfo.name() + " TEXT, " + c.PushSDKClientBindInfo.name() + " TEXT, " + c.PushClientsBindInfo.name() + " TEXT, " + c.PushSelfBindInfo.name() + " TEXT );");
                String str = "CREATE TABLE PushVerifInfo (" + d.verifId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.msgId.name() + " TEXT  NOT NULL, " + d.md5Infos.name() + " TEXT  NOT NULL, " + d.appId.name() + " TEXT, " + d.time.name() + " TEXT );";
                sQLiteDatabase.execSQL(str);
                com.baidu.android.pushservice.e.a.c("PushInfoDataBase", str);
            } catch (Exception e) {
                com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
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
    public enum c {
        PushInfoId,
        PushPriority,
        PushVersion,
        PushChannelID,
        PushCurPkgName,
        PushWebAppBindInfo,
        PushLightAppBindInfo,
        PushSDKClientBindInfo,
        PushClientsBindInfo,
        PushSelfBindInfo
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum d {
        verifId,
        msgId,
        md5Infos,
        appId,
        time
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ef A[Catch: all -> 0x00f6, TryCatch #4 {, blocks: (B:4:0x0006, B:5:0x0008, B:6:0x0009, B:8:0x000f, B:12:0x0013, B:20:0x00e4, B:22:0x00ea, B:24:0x00ef, B:25:0x00f3, B:38:0x0118, B:40:0x011e, B:42:0x0123, B:46:0x012c, B:48:0x0132, B:50:0x0137, B:51:0x013a), top: B:59:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0137 A[Catch: all -> 0x00f6, TryCatch #4 {, blocks: (B:4:0x0006, B:5:0x0008, B:6:0x0009, B:8:0x000f, B:12:0x0013, B:20:0x00e4, B:22:0x00ea, B:24:0x00ef, B:25:0x00f3, B:38:0x0118, B:40:0x011e, B:42:0x0123, B:46:0x012c, B:48:0x0132, B:50:0x0137, B:51:0x013a), top: B:59:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized long a(Context context, p pVar) {
        Cursor cursor;
        long j;
        long j2 = -1;
        synchronized (q.class) {
            synchronized (c) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    j = -1;
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(c.PushPriority.name(), Long.valueOf(pVar.a));
                    contentValues.put(c.PushVersion.name(), Long.valueOf(pVar.b));
                    contentValues.put(c.PushChannelID.name(), pVar.c);
                    contentValues.put(c.PushCurPkgName.name(), pVar.d);
                    contentValues.put(c.PushLightAppBindInfo.name(), pVar.f);
                    contentValues.put(c.PushWebAppBindInfo.name(), pVar.e);
                    contentValues.put(c.PushSDKClientBindInfo.name(), pVar.g);
                    contentValues.put(c.PushClientsBindInfo.name(), pVar.h);
                    contentValues.put(c.PushSelfBindInfo.name(), pVar.i);
                    try {
                        cursor = a2.query(PushInfoProvider.TABLENAME_PUSHSHARE, null, null, null, null, null, null);
                    } catch (Exception e) {
                        e = e;
                        cursor = null;
                    } catch (Throwable th) {
                        th = th;
                        cursor = null;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (a2 != null) {
                        }
                        throw th;
                    }
                    if (cursor != null) {
                        try {
                            try {
                            } catch (Exception e2) {
                                e = e2;
                                com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (a2 != null) {
                                    a2.close();
                                    j = j2;
                                    return j;
                                }
                                j = j2;
                                return j;
                            }
                            if (cursor.getCount() != 0) {
                                j2 = a2.update(PushInfoProvider.TABLENAME_PUSHSHARE, contentValues, c.PushInfoId.name() + "=1", null);
                                com.baidu.android.pushservice.e.a.c("PushInfoDataBase", "pushadvertiseinfo:  update into database");
                                u.b("pushadvertiseinfo:  update into database", context);
                                u.b("updatePushInfo pushinfo:  insert into database,  clientinfo = " + pVar.a().toString(), context);
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (a2 != null) {
                                    a2.close();
                                    j = j2;
                                }
                                j = j2;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                            throw th;
                        }
                    }
                    j2 = a2.insert(PushInfoProvider.TABLENAME_PUSHSHARE, null, contentValues);
                    com.baidu.android.pushservice.e.a.c("PushInfoDataBase", "pushadvertiseinfo:  insert into database");
                    u.b("pushadvertiseinfo:  insert into database", context);
                    u.b("updatePushInfo pushinfo:  insert into database,  clientinfo = " + pVar.a().toString(), context);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (a2 != null) {
                    }
                    j = j2;
                }
            }
        }
        return j;
    }

    public static SQLiteDatabase a(Context context) {
        b i = i(context);
        if (i == null) {
            return null;
        }
        try {
            return i.getWritableDatabase();
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
            com.baidu.android.pushservice.f.p.a(context, e);
            return null;
        }
    }

    public static Object a() {
        return c;
    }

    public static String a(Context context, String str, String str2) {
        Cursor cursor;
        String str3;
        ContentResolver contentResolver;
        try {
            if (u.l(context, str) < 52 || (contentResolver = context.getContentResolver()) == null) {
                str3 = null;
                cursor = null;
            } else {
                cursor = contentResolver.query(Uri.parse("content://" + str + PushInfoProvider.PUSH_PROVIDER_AUTHORITIES_SUFFIX + "/" + PushInfoProvider.DATABASE_PUSHINFO_VERIF), new String[]{d.md5Infos.name()}, d.msgId.name() + "=?", new String[]{str2}, null);
                try {
                    com.baidu.android.pushservice.e.a.c("PushInfoDataBase", "getMd5ByMsgId cursor  is " + cursor);
                    str3 = (cursor == null || !cursor.moveToFirst()) ? null : cursor.getString(0);
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.baidu.android.pushservice.e.a.a("PushInfoDataBase", th);
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e) {
                                com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
                                return null;
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        Cursor cursor2 = cursor;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception e2) {
                                com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e2);
                            }
                        }
                        throw th2;
                    }
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                    return str3;
                } catch (Exception e3) {
                    com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e3);
                    return str3;
                }
            }
            return str3;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0062 A[Catch: all -> 0x0067, TryCatch #3 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:8:0x000d, B:17:0x0057, B:19:0x005d, B:21:0x0062, B:22:0x0065, B:35:0x0099, B:37:0x009f, B:39:0x00a4, B:43:0x00ac, B:45:0x00b2, B:47:0x00b7, B:48:0x00ba), top: B:53:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void a(Context context, long j) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (q.class) {
            synchronized (c) {
                SQLiteDatabase a2 = a(context);
                try {
                    if (a2 != null) {
                        try {
                            cursor = a2.query(PushInfoProvider.TABLENAME_PUSHSHARE, null, null, null, null, null, null);
                        } catch (Exception e) {
                            e = e;
                            cursor = null;
                        } catch (Throwable th) {
                            th = th;
                            if (0 != 0 && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                            throw th;
                        }
                        if (cursor != null) {
                            try {
                            } catch (Exception e2) {
                                e = e2;
                                com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (a2 != null) {
                                    a2.close();
                                }
                            }
                            if (cursor.getCount() != 0) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(c.PushPriority.name(), Long.valueOf(j));
                                a2.update(PushInfoProvider.TABLENAME_PUSHSHARE, contentValues, c.PushInfoId.name() + "=1", null);
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (a2 != null) {
                                    a2.close();
                                }
                            }
                        }
                        p pVar = new p();
                        pVar.a = j;
                        pVar.b = 0L;
                        pVar.c = null;
                        pVar.d = null;
                        pVar.f = null;
                        pVar.e = null;
                        pVar.g = null;
                        pVar.h = null;
                        pVar.i = null;
                        a(context, pVar);
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (a2 != null) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005e A[Catch: all -> 0x0063, TryCatch #4 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:8:0x000d, B:17:0x0053, B:19:0x0059, B:21:0x005e, B:22:0x0061, B:35:0x0096, B:37:0x009c, B:39:0x00a1, B:43:0x00a9, B:45:0x00af, B:47:0x00b4, B:48:0x00b7), top: B:55:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b4 A[Catch: all -> 0x0063, TryCatch #4 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:8:0x000d, B:17:0x0053, B:19:0x0059, B:21:0x005e, B:22:0x0061, B:35:0x0096, B:37:0x009c, B:39:0x00a1, B:43:0x00a9, B:45:0x00af, B:47:0x00b4, B:48:0x00b7), top: B:55:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void a(Context context, String str) {
        Cursor cursor;
        synchronized (q.class) {
            synchronized (c) {
                SQLiteDatabase a2 = a(context);
                if (a2 != null) {
                    try {
                        cursor = a2.query(PushInfoProvider.TABLENAME_PUSHSHARE, null, null, null, null, null, null);
                    } catch (Exception e) {
                        e = e;
                        cursor = null;
                    } catch (Throwable th) {
                        th = th;
                        cursor = null;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (a2 != null) {
                        }
                        throw th;
                    }
                    if (cursor != null) {
                        try {
                            try {
                            } catch (Exception e2) {
                                e = e2;
                                com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (a2 != null) {
                                    a2.close();
                                }
                            }
                            if (cursor.getCount() != 0) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(c.PushChannelID.name(), str);
                                a2.update(PushInfoProvider.TABLENAME_PUSHSHARE, contentValues, c.PushInfoId.name() + "=1", null);
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (a2 != null) {
                                    a2.close();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                            throw th;
                        }
                    }
                    p pVar = new p();
                    pVar.a = 0L;
                    pVar.b = 0L;
                    pVar.c = str;
                    pVar.d = null;
                    pVar.f = null;
                    pVar.e = null;
                    pVar.g = null;
                    pVar.h = null;
                    pVar.i = null;
                    a(context, pVar);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (a2 != null) {
                    }
                }
            }
        }
    }

    public static synchronized boolean a(Context context, s sVar) {
        boolean z;
        synchronized (q.class) {
            synchronized (c) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    z = false;
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(d.msgId.name(), sVar.a);
                    contentValues.put(d.md5Infos.name(), sVar.b);
                    contentValues.put(d.appId.name(), sVar.d);
                    contentValues.put(d.time.name(), System.currentTimeMillis() + "");
                    long j = -1;
                    Cursor cursor = null;
                    try {
                        j = a2.insert("PushVerifInfo", null, contentValues);
                        com.baidu.android.pushservice.e.a.c("PushInfoDataBase", "PushVerifInfo:  insert into database");
                        cursor = a2.rawQuery("SELECT COUNT(*) FROM PushVerifInfo;", null);
                        cursor.moveToFirst();
                        int i = cursor.getInt(0);
                        com.baidu.android.pushservice.e.a.b("PushInfoDataBase", "PushVerifInfo table records count = " + i);
                        if (i > d) {
                            a2.delete("PushVerifInfo", " msgId IS NOT ?", new String[]{sVar.a});
                            com.baidu.android.pushservice.e.a.b("PushInfoDataBase", "clear PushVerifInfoEnum table!!");
                        }
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (a2 != null) {
                            a2.close();
                        }
                    } catch (Exception e) {
                        com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (a2 != null) {
                            a2.close();
                        }
                    }
                    z = j != -1;
                }
            }
        }
        return z;
    }

    public static int b(Context context) {
        Cursor cursor;
        int i;
        Cursor cursor2 = null;
        synchronized (c) {
            SQLiteDatabase a2 = a(context);
            try {
                if (a2 == null) {
                    return 0;
                }
                try {
                    cursor = a2.query(PushInfoProvider.TABLENAME_PUSHSHARE, null, null, null, null, null, null);
                    try {
                        r8 = cursor.moveToFirst() ? cursor.getInt(cursor.getColumnIndex(c.PushPriority.name())) : 0;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                    } catch (Exception e) {
                        e = e;
                        com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (a2 != null) {
                            a2.close();
                            i = 0;
                            return i;
                        }
                        i = r8;
                        return i;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0 && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    if (a2 != null) {
                        a2.close();
                    }
                    throw th;
                }
                if (a2 != null) {
                    a2.close();
                    i = r8;
                    return i;
                }
                i = r8;
                return i;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static String b(Context context, String str, String str2) {
        Cursor cursor;
        String str3;
        ContentResolver contentResolver;
        try {
            if (u.l(context, str) < 52 || (contentResolver = context.getContentResolver()) == null) {
                str3 = null;
                cursor = null;
            } else {
                cursor = contentResolver.query(Uri.parse("content://" + str + PushInfoProvider.PUSH_PROVIDER_AUTHORITIES_SUFFIX + "/" + PushInfoProvider.DATABASE_PUSHINFO_VERIF), new String[]{d.md5Infos.name()}, d.md5Infos.name() + "=?", new String[]{str2}, null);
                try {
                    com.baidu.android.pushservice.e.a.c("PushInfoDataBase", "getMd5ByMd5 cursor  is " + cursor);
                    str3 = (cursor == null || !cursor.moveToFirst()) ? null : cursor.getString(0);
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.baidu.android.pushservice.e.a.a("PushInfoDataBase", th);
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e) {
                                com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
                                return null;
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        Cursor cursor2 = cursor;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception e2) {
                                com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e2);
                            }
                        }
                        throw th2;
                    }
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                    return str3;
                } catch (Exception e3) {
                    com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e3);
                    return str3;
                }
            }
            return str3;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0062 A[Catch: all -> 0x0067, TryCatch #3 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:8:0x000d, B:17:0x0057, B:19:0x005d, B:21:0x0062, B:22:0x0065, B:35:0x0099, B:37:0x009f, B:39:0x00a4, B:43:0x00ac, B:45:0x00b2, B:47:0x00b7, B:48:0x00ba), top: B:53:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void b(Context context, long j) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (q.class) {
            synchronized (c) {
                SQLiteDatabase a2 = a(context);
                try {
                    if (a2 != null) {
                        try {
                            cursor = a2.query(PushInfoProvider.TABLENAME_PUSHSHARE, null, null, null, null, null, null);
                        } catch (Exception e) {
                            e = e;
                            cursor = null;
                        } catch (Throwable th) {
                            th = th;
                            if (0 != 0 && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                            throw th;
                        }
                        if (cursor != null) {
                            try {
                            } catch (Exception e2) {
                                e = e2;
                                com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (a2 != null) {
                                    a2.close();
                                }
                            }
                            if (cursor.getCount() != 0) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(c.PushVersion.name(), Long.valueOf(j));
                                a2.update(PushInfoProvider.TABLENAME_PUSHSHARE, contentValues, c.PushInfoId.name() + "=1", null);
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (a2 != null) {
                                    a2.close();
                                }
                            }
                        }
                        p pVar = new p();
                        pVar.a = 0L;
                        pVar.b = j;
                        pVar.c = null;
                        pVar.d = null;
                        pVar.f = null;
                        pVar.e = null;
                        pVar.g = null;
                        pVar.h = null;
                        pVar.i = null;
                        a(context, pVar);
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (a2 != null) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005e A[Catch: all -> 0x0063, TryCatch #4 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:8:0x000d, B:17:0x0053, B:19:0x0059, B:21:0x005e, B:22:0x0061, B:35:0x0096, B:37:0x009c, B:39:0x00a1, B:43:0x00a9, B:45:0x00af, B:47:0x00b4, B:48:0x00b7), top: B:55:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b4 A[Catch: all -> 0x0063, TryCatch #4 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:8:0x000d, B:17:0x0053, B:19:0x0059, B:21:0x005e, B:22:0x0061, B:35:0x0096, B:37:0x009c, B:39:0x00a1, B:43:0x00a9, B:45:0x00af, B:47:0x00b4, B:48:0x00b7), top: B:55:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void b(Context context, String str) {
        Cursor cursor;
        synchronized (q.class) {
            synchronized (c) {
                SQLiteDatabase a2 = a(context);
                if (a2 != null) {
                    try {
                        cursor = a2.query(PushInfoProvider.TABLENAME_PUSHSHARE, null, null, null, null, null, null);
                    } catch (Exception e) {
                        e = e;
                        cursor = null;
                    } catch (Throwable th) {
                        th = th;
                        cursor = null;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (a2 != null) {
                        }
                        throw th;
                    }
                    if (cursor != null) {
                        try {
                            try {
                            } catch (Exception e2) {
                                e = e2;
                                com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (a2 != null) {
                                    a2.close();
                                }
                            }
                            if (cursor.getCount() != 0) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(c.PushCurPkgName.name(), str);
                                a2.update(PushInfoProvider.TABLENAME_PUSHSHARE, contentValues, c.PushInfoId.name() + "=1", null);
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (a2 != null) {
                                    a2.close();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                            throw th;
                        }
                    }
                    p pVar = new p();
                    pVar.a = 0L;
                    pVar.b = 0L;
                    pVar.c = null;
                    pVar.d = str;
                    pVar.f = null;
                    pVar.e = null;
                    pVar.g = null;
                    pVar.h = null;
                    pVar.i = null;
                    a(context, pVar);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (a2 != null) {
                    }
                }
            }
        }
    }

    public static int c(Context context) {
        Cursor cursor;
        int i;
        Cursor cursor2 = null;
        synchronized (c) {
            SQLiteDatabase a2 = a(context);
            try {
                if (a2 == null) {
                    return 0;
                }
                try {
                    cursor = a2.query(PushInfoProvider.TABLENAME_PUSHSHARE, null, null, null, null, null, null);
                    try {
                        r8 = cursor.moveToFirst() ? cursor.getInt(cursor.getColumnIndex(c.PushVersion.name())) : 0;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                    } catch (Exception e) {
                        e = e;
                        com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (a2 != null) {
                            a2.close();
                            i = 0;
                            return i;
                        }
                        i = r8;
                        return i;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0 && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    if (a2 != null) {
                        a2.close();
                    }
                    throw th;
                }
                if (a2 != null) {
                    a2.close();
                    i = r8;
                    return i;
                }
                i = r8;
                return i;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0060 A[Catch: all -> 0x0065, TryCatch #4 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:18:0x0055, B:20:0x005b, B:22:0x0060, B:23:0x0063, B:36:0x0098, B:38:0x009e, B:40:0x00a3, B:44:0x00ab, B:46:0x00b1, B:48:0x00b6, B:49:0x00b9, B:9:0x000f), top: B:56:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b6 A[Catch: all -> 0x0065, TryCatch #4 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:18:0x0055, B:20:0x005b, B:22:0x0060, B:23:0x0063, B:36:0x0098, B:38:0x009e, B:40:0x00a3, B:44:0x00ab, B:46:0x00b1, B:48:0x00b6, B:49:0x00b9, B:9:0x000f), top: B:56:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void c(Context context, String str) {
        Cursor cursor;
        synchronized (q.class) {
            synchronized (c) {
                SQLiteDatabase a2 = a(context);
                if (a2 != null && str != null) {
                    try {
                        cursor = a2.query(PushInfoProvider.TABLENAME_PUSHSHARE, null, null, null, null, null, null);
                    } catch (Exception e) {
                        e = e;
                        cursor = null;
                    } catch (Throwable th) {
                        th = th;
                        cursor = null;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (a2 != null) {
                        }
                        throw th;
                    }
                    if (cursor != null) {
                        try {
                            try {
                            } catch (Exception e2) {
                                e = e2;
                                com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (a2 != null) {
                                    a2.close();
                                }
                            }
                            if (cursor.getCount() != 0) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(c.PushWebAppBindInfo.name(), str);
                                a2.update(PushInfoProvider.TABLENAME_PUSHSHARE, contentValues, c.PushInfoId.name() + "=1", null);
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (a2 != null) {
                                    a2.close();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                            throw th;
                        }
                    }
                    p pVar = new p();
                    pVar.a = 0L;
                    pVar.b = 0L;
                    pVar.c = null;
                    pVar.d = null;
                    pVar.f = null;
                    pVar.e = str;
                    pVar.g = null;
                    pVar.h = null;
                    pVar.i = null;
                    a(context, pVar);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (a2 != null) {
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x006b A[Catch: all -> 0x0040, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000a, B:14:0x002f, B:16:0x0035, B:18:0x003a, B:19:0x003e, B:36:0x0060, B:38:0x0066, B:40:0x006b, B:41:0x006e, B:28:0x004c, B:30:0x0052, B:32:0x0057), top: B:48:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(Context context) {
        Cursor cursor;
        String str;
        synchronized (c) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query(PushInfoProvider.TABLENAME_PUSHSHARE, null, null, null, null, null, null);
                try {
                    try {
                        String string = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(c.PushChannelID.name())) : null;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (a2 != null) {
                            a2.close();
                            str = string;
                        } else {
                            str = string;
                        }
                    } catch (Exception e) {
                        e = e;
                        com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (a2 != null) {
                            a2.close();
                            str = null;
                        } else {
                            str = null;
                        }
                        return str;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    if (a2 != null) {
                        a2.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                if (a2 != null) {
                }
                throw th;
            }
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0060 A[Catch: all -> 0x0065, TryCatch #4 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:18:0x0055, B:20:0x005b, B:22:0x0060, B:23:0x0063, B:36:0x0098, B:38:0x009e, B:40:0x00a3, B:44:0x00ab, B:46:0x00b1, B:48:0x00b6, B:49:0x00b9, B:9:0x000f), top: B:56:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b6 A[Catch: all -> 0x0065, TryCatch #4 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:18:0x0055, B:20:0x005b, B:22:0x0060, B:23:0x0063, B:36:0x0098, B:38:0x009e, B:40:0x00a3, B:44:0x00ab, B:46:0x00b1, B:48:0x00b6, B:49:0x00b9, B:9:0x000f), top: B:56:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void d(Context context, String str) {
        Cursor cursor;
        synchronized (q.class) {
            synchronized (c) {
                SQLiteDatabase a2 = a(context);
                if (a2 != null && str != null) {
                    try {
                        cursor = a2.query(PushInfoProvider.TABLENAME_PUSHSHARE, null, null, null, null, null, null);
                    } catch (Exception e) {
                        e = e;
                        cursor = null;
                    } catch (Throwable th) {
                        th = th;
                        cursor = null;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (a2 != null) {
                        }
                        throw th;
                    }
                    if (cursor != null) {
                        try {
                            try {
                            } catch (Exception e2) {
                                e = e2;
                                com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (a2 != null) {
                                    a2.close();
                                }
                            }
                            if (cursor.getCount() != 0) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(c.PushSDKClientBindInfo.name(), str);
                                a2.update(PushInfoProvider.TABLENAME_PUSHSHARE, contentValues, c.PushInfoId.name() + "=1", null);
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (a2 != null) {
                                    a2.close();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                            throw th;
                        }
                    }
                    p pVar = new p();
                    pVar.a = 0L;
                    pVar.b = 0L;
                    pVar.c = null;
                    pVar.d = null;
                    pVar.f = null;
                    pVar.e = null;
                    pVar.g = str;
                    pVar.h = null;
                    pVar.i = null;
                    a(context, pVar);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (a2 != null) {
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x006b A[Catch: all -> 0x0040, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000a, B:14:0x002f, B:16:0x0035, B:18:0x003a, B:19:0x003e, B:36:0x0060, B:38:0x0066, B:40:0x006b, B:41:0x006e, B:28:0x004c, B:30:0x0052, B:32:0x0057), top: B:48:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(Context context) {
        Cursor cursor;
        String str;
        synchronized (c) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query(PushInfoProvider.TABLENAME_PUSHSHARE, null, null, null, null, null, null);
                try {
                    try {
                        String string = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(c.PushWebAppBindInfo.name())) : null;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (a2 != null) {
                            a2.close();
                            str = string;
                        } else {
                            str = string;
                        }
                    } catch (Exception e) {
                        e = e;
                        com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (a2 != null) {
                            a2.close();
                            str = null;
                        } else {
                            str = null;
                        }
                        return str;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    if (a2 != null) {
                        a2.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                if (a2 != null) {
                }
                throw th;
            }
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0060 A[Catch: all -> 0x0065, TryCatch #4 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:18:0x0055, B:20:0x005b, B:22:0x0060, B:23:0x0063, B:36:0x0098, B:38:0x009e, B:40:0x00a3, B:44:0x00ab, B:46:0x00b1, B:48:0x00b6, B:49:0x00b9, B:9:0x000f), top: B:56:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b6 A[Catch: all -> 0x0065, TryCatch #4 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:18:0x0055, B:20:0x005b, B:22:0x0060, B:23:0x0063, B:36:0x0098, B:38:0x009e, B:40:0x00a3, B:44:0x00ab, B:46:0x00b1, B:48:0x00b6, B:49:0x00b9, B:9:0x000f), top: B:56:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void e(Context context, String str) {
        Cursor cursor;
        synchronized (q.class) {
            synchronized (c) {
                SQLiteDatabase a2 = a(context);
                if (a2 != null && str != null) {
                    try {
                        cursor = a2.query(PushInfoProvider.TABLENAME_PUSHSHARE, null, null, null, null, null, null);
                    } catch (Exception e) {
                        e = e;
                        cursor = null;
                    } catch (Throwable th) {
                        th = th;
                        cursor = null;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (a2 != null) {
                        }
                        throw th;
                    }
                    if (cursor != null) {
                        try {
                            try {
                            } catch (Exception e2) {
                                e = e2;
                                com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (a2 != null) {
                                    a2.close();
                                }
                            }
                            if (cursor.getCount() != 0) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(c.PushClientsBindInfo.name(), str);
                                a2.update(PushInfoProvider.TABLENAME_PUSHSHARE, contentValues, c.PushInfoId.name() + "=1", null);
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (a2 != null) {
                                    a2.close();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                            throw th;
                        }
                    }
                    p pVar = new p();
                    pVar.a = 0L;
                    pVar.b = 0L;
                    pVar.c = null;
                    pVar.d = null;
                    pVar.f = null;
                    pVar.e = null;
                    pVar.g = null;
                    pVar.h = str;
                    pVar.i = null;
                    a(context, pVar);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (a2 != null) {
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x006b A[Catch: all -> 0x0040, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000a, B:14:0x002f, B:16:0x0035, B:18:0x003a, B:19:0x003e, B:36:0x0060, B:38:0x0066, B:40:0x006b, B:41:0x006e, B:28:0x004c, B:30:0x0052, B:32:0x0057), top: B:48:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String f(Context context) {
        Cursor cursor;
        String str;
        synchronized (c) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query(PushInfoProvider.TABLENAME_PUSHSHARE, null, null, null, null, null, null);
                try {
                    try {
                        String string = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(c.PushSDKClientBindInfo.name())) : null;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (a2 != null) {
                            a2.close();
                            str = string;
                        } else {
                            str = string;
                        }
                    } catch (Exception e) {
                        e = e;
                        com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (a2 != null) {
                            a2.close();
                            str = null;
                        } else {
                            str = null;
                        }
                        return str;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    if (a2 != null) {
                        a2.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                if (a2 != null) {
                }
                throw th;
            }
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0060 A[Catch: all -> 0x0065, TryCatch #4 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:18:0x0055, B:20:0x005b, B:22:0x0060, B:23:0x0063, B:36:0x0098, B:38:0x009e, B:40:0x00a3, B:44:0x00ab, B:46:0x00b1, B:48:0x00b6, B:49:0x00b9, B:9:0x000f), top: B:56:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b6 A[Catch: all -> 0x0065, TryCatch #4 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:18:0x0055, B:20:0x005b, B:22:0x0060, B:23:0x0063, B:36:0x0098, B:38:0x009e, B:40:0x00a3, B:44:0x00ab, B:46:0x00b1, B:48:0x00b6, B:49:0x00b9, B:9:0x000f), top: B:56:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void f(Context context, String str) {
        Cursor cursor;
        synchronized (q.class) {
            synchronized (c) {
                SQLiteDatabase a2 = a(context);
                if (a2 != null && str != null) {
                    try {
                        cursor = a2.query(PushInfoProvider.TABLENAME_PUSHSHARE, null, null, null, null, null, null);
                    } catch (Exception e) {
                        e = e;
                        cursor = null;
                    } catch (Throwable th) {
                        th = th;
                        cursor = null;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (a2 != null) {
                        }
                        throw th;
                    }
                    if (cursor != null) {
                        try {
                            try {
                            } catch (Exception e2) {
                                e = e2;
                                com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (a2 != null) {
                                    a2.close();
                                }
                            }
                            if (cursor.getCount() != 0) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(c.PushSelfBindInfo.name(), str);
                                a2.update(PushInfoProvider.TABLENAME_PUSHSHARE, contentValues, c.PushInfoId.name() + "=1", null);
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                if (a2 != null) {
                                    a2.close();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                            throw th;
                        }
                    }
                    p pVar = new p();
                    pVar.a = 0L;
                    pVar.b = 0L;
                    pVar.c = null;
                    pVar.d = null;
                    pVar.f = null;
                    pVar.e = null;
                    pVar.g = null;
                    pVar.h = null;
                    pVar.i = str;
                    a(context, pVar);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (a2 != null) {
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0085 A[Catch: all -> 0x0040, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000a, B:14:0x002f, B:16:0x0035, B:18:0x003a, B:19:0x003e, B:36:0x007a, B:38:0x0080, B:40:0x0085, B:41:0x0088, B:28:0x0066, B:30:0x006c, B:32:0x0071), top: B:48:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String g(Context context) {
        Cursor cursor;
        String str;
        synchronized (c) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query(PushInfoProvider.TABLENAME_PUSHSHARE, null, null, null, null, null, null);
                try {
                    try {
                        String string = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(c.PushClientsBindInfo.name())) : null;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (a2 != null) {
                            a2.close();
                            str = string;
                        } else {
                            str = string;
                        }
                    } catch (Exception e) {
                        e = e;
                        com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
                        u.b("PushInfoDataBase*BBind*" + com.baidu.android.pushservice.e.a.a(e), context);
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (a2 != null) {
                            a2.close();
                            str = null;
                        } else {
                            str = null;
                        }
                        return str;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    if (a2 != null) {
                        a2.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                if (a2 != null) {
                }
                throw th;
            }
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x006b A[Catch: all -> 0x0040, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000a, B:14:0x002f, B:16:0x0035, B:18:0x003a, B:19:0x003e, B:36:0x0060, B:38:0x0066, B:40:0x006b, B:41:0x006e, B:28:0x004c, B:30:0x0052, B:32:0x0057), top: B:48:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String h(Context context) {
        Cursor cursor;
        String str;
        synchronized (c) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query(PushInfoProvider.TABLENAME_PUSHSHARE, null, null, null, null, null, null);
                try {
                    try {
                        String string = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(c.PushSelfBindInfo.name())) : null;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (a2 != null) {
                            a2.close();
                            str = string;
                        } else {
                            str = string;
                        }
                    } catch (Exception e) {
                        e = e;
                        com.baidu.android.pushservice.e.a.a("PushInfoDataBase", e);
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (a2 != null) {
                            a2.close();
                            str = null;
                        } else {
                            str = null;
                        }
                        return str;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    if (a2 != null) {
                        a2.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                if (a2 != null) {
                }
                throw th;
            }
            return str;
        }
    }

    private static b i(Context context) {
        synchronized (c) {
            if (a == null) {
                File file = new File(Environment.getDataDirectory().getAbsolutePath() + "/data" + File.separator + context.getPackageName() + "/database");
                com.baidu.android.pushservice.e.a.c("PushInfoDataBase", "File Path is  " + Environment.getDataDirectory().getAbsolutePath() + "/data" + File.separator + context.getPackageName() + "/database");
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str = file.getAbsolutePath() + File.separator + "pushinfo.db";
                com.baidu.android.pushservice.e.a.c("PushInfoDataBase", "dbname is :" + str);
                if (Build.VERSION.SDK_INT >= 11) {
                    b = new a();
                    a = new b(context, str, 2, b);
                } else {
                    a = new b(context, str, (SQLiteDatabase.CursorFactory) null, 2);
                }
            }
        }
        return a;
    }
}
