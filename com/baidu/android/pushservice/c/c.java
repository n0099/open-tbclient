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
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import java.io.File;
import java.util.List;
/* loaded from: classes10.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile C0045c f1040a;
    private static final Object b = new Object();

    /* loaded from: classes10.dex */
    public enum a {
        actionId,
        actionName,
        timeStamp,
        pkgName,
        versionCode,
        versionName,
        status
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b implements DatabaseErrorHandler {
        private b() {
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
    /* renamed from: com.baidu.android.pushservice.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0045c extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        private static final String f1042a = "CREATE TABLE PushShareInfo (" + e.PushInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + e.PushPriority.name() + " LONG NOT NULL DEFAULT ((0)), " + e.PushVersion.name() + " INTEGER DEFAULT ((0)), " + e.PushChannelID.name() + " TEXT, " + e.PushNewChannelID.name() + " TEXT, " + e.PushChannelToken.name() + " TEXT, " + e.PushCurPkgName.name() + " TEXT, " + e.PushWebAppBindInfo.name() + " TEXT, " + e.PushLightAppBindInfo.name() + " TEXT, " + e.PushSDKClientBindInfo.name() + " TEXT, " + e.PushClientsBindInfo.name() + " TEXT, " + e.PushSelfBindInfo.name() + " TEXT);";
        private static final String b = "CREATE TABLE PushVerifInfo (" + f.verifId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.msgId.name() + " TEXT NOT NULL, " + f.md5Infos.name() + " TEXT NOT NULL, " + f.appId.name() + " TEXT, " + f.time.name() + " TEXT);";
        private static final String c = "CREATE TABLE PushMsgInfos (" + d.MsgInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.appId.name() + "  TEXT, " + d.msgType.name() + "  INTEGER NOT NULL, " + d.msgId.name() + " LONG NOT NULL, " + d.secureInfo.name() + " TEXT, " + d.msgBody.name() + "  TEXT, " + d.expireTime.name() + "  LONG, " + d.ackRet.name() + "  INTEGER, " + d.arriveTime.name() + " LONG NOT NULL);";
        private static final String d = "CREATE TABLE PushAppStatus (" + a.actionId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + a.actionName.name() + " TEXT NOT NULL, " + a.timeStamp.name() + " LONG NOT NULL, " + a.pkgName.name() + " TEXT, " + a.versionCode.name() + " INTEGER, " + a.versionName.name() + " TEXT, " + a.status.name() + " INTEGER);";
        private static final String e = "ALTER TABLE PushShareInfo ADD COLUMN " + e.PushNewChannelID.name() + " TEXT";
        private static final String f = "ALTER TABLE PushShareInfo ADD COLUMN " + e.PushChannelToken.name() + " TEXT";

        public C0045c(Context context, String str, int i, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i, databaseErrorHandler);
        }

        public C0045c(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushShareInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushVerifyInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushMsgInfo");
            } catch (Exception e2) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(f1042a);
                sQLiteDatabase.execSQL(b);
                sQLiteDatabase.execSQL(c);
                sQLiteDatabase.execSQL(d);
            } catch (Exception e2) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i <= 1) {
                a(sQLiteDatabase);
                onCreate(sQLiteDatabase);
            } else if (i == 2) {
                sQLiteDatabase.execSQL(c);
                sQLiteDatabase.execSQL(d);
                sQLiteDatabase.execSQL(e);
                sQLiteDatabase.execSQL(f);
            } else if (i == 3) {
                sQLiteDatabase.execSQL(d);
                sQLiteDatabase.execSQL(e);
                sQLiteDatabase.execSQL(f);
            } else if (i == 4) {
                sQLiteDatabase.execSQL(e);
                sQLiteDatabase.execSQL(f);
            } else if (i == 5) {
                sQLiteDatabase.execSQL(f);
            }
        }
    }

    /* loaded from: classes10.dex */
    public enum d {
        MsgInfoId,
        appId,
        msgType,
        msgId,
        arriveTime,
        secureInfo,
        msgBody,
        expireTime,
        ackRet
    }

    /* loaded from: classes10.dex */
    public enum e {
        PushInfoId,
        PushPriority,
        PushVersion,
        PushChannelID,
        PushNewChannelID,
        PushChannelToken,
        PushCurPkgName,
        PushWebAppBindInfo,
        PushLightAppBindInfo,
        PushSDKClientBindInfo,
        PushClientsBindInfo,
        PushSelfBindInfo
    }

    /* loaded from: classes10.dex */
    public enum f {
        verifId,
        msgId,
        md5Infos,
        appId,
        time
    }

    public static synchronized long a(Context context, com.baidu.android.pushservice.c.b bVar) {
        Cursor cursor;
        long j;
        long j2 = -1;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    j = -1;
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(e.PushPriority.name(), Long.valueOf(bVar.f1039a));
                    contentValues.put(e.PushVersion.name(), Long.valueOf(bVar.b));
                    contentValues.put(e.PushChannelID.name(), bVar.c);
                    contentValues.put(e.PushNewChannelID.name(), bVar.d);
                    contentValues.put(e.PushCurPkgName.name(), bVar.e);
                    contentValues.put(e.PushLightAppBindInfo.name(), bVar.g);
                    contentValues.put(e.PushWebAppBindInfo.name(), bVar.f);
                    contentValues.put(e.PushSDKClientBindInfo.name(), bVar.h);
                    contentValues.put(e.PushClientsBindInfo.name(), bVar.i);
                    contentValues.put(e.PushSelfBindInfo.name(), bVar.j);
                    try {
                        cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                    } catch (Exception e2) {
                        cursor = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                    if (cursor != null) {
                        try {
                        } catch (Exception e3) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            j = j2;
                            return j;
                        } catch (Throwable th2) {
                            cursor2 = cursor;
                            th = th2;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            a2.close();
                            throw th;
                        }
                        if (cursor.getCount() != 0) {
                            j2 = a2.update("PushShareInfo", contentValues, e.PushInfoId.name() + "=1", null);
                            m.a("pushadvertiseinfo:  update into database", context);
                            m.a("updatePushInfo pushinfo:  insert into database,  clientinfo = " + bVar.a().toString(), context);
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            j = j2;
                        }
                    }
                    j2 = a2.insert("PushShareInfo", null, contentValues);
                    m.a("pushadvertiseinfo:  insert into database", context);
                    m.a("updatePushInfo pushinfo:  insert into database,  clientinfo = " + bVar.a().toString(), context);
                    if (cursor != null) {
                        cursor.close();
                    }
                    a2.close();
                    j = j2;
                }
            }
        }
        return j;
    }

    public static SQLiteDatabase a(Context context) {
        C0045c f2 = f(context);
        if (f2 == null) {
            return null;
        }
        try {
            return f2.getWritableDatabase();
        } catch (Throwable th) {
            return null;
        }
    }

    public static Object a() {
        return b;
    }

    public static String a(Context context, boolean z) {
        Cursor cursor;
        String str;
        Cursor cursor2 = null;
        String str2 = null;
        synchronized (b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query("PushShareInfo", new String[]{e.PushChannelID.name(), e.PushNewChannelID.name()}, null, null, null, null, null);
                try {
                    if (cursor.moveToFirst()) {
                        str2 = cursor.getString(cursor.getColumnIndex(z ? e.PushNewChannelID.name() : e.PushChannelID.name()));
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    str = str2;
                } catch (Exception e2) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    str = null;
                    return str;
                } catch (Throwable th) {
                    cursor2 = cursor;
                    th = th;
                    if (cursor2 != null && !cursor2.isClosed()) {
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
            return str;
        }
    }

    public static synchronized void a(Context context, long j) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (b) {
                SQLiteDatabase a2 = a(context);
                if (a2 != null) {
                    try {
                        cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                    } catch (Exception e2) {
                        cursor = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                    if (cursor != null) {
                        try {
                        } catch (Exception e3) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        } catch (Throwable th2) {
                            cursor2 = cursor;
                            th = th2;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            a2.close();
                            throw th;
                        }
                        if (cursor.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(e.PushPriority.name(), Long.valueOf(j));
                            a2.update("PushShareInfo", contentValues, e.PushInfoId.name() + "=1", null);
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f1039a = j;
                    bVar.b = 0L;
                    bVar.c = null;
                    bVar.d = null;
                    bVar.e = null;
                    bVar.g = null;
                    bVar.f = null;
                    bVar.h = null;
                    bVar.i = null;
                    bVar.j = null;
                    a(context, bVar);
                    if (cursor != null) {
                        cursor.close();
                    }
                    a2.close();
                }
            }
        }
    }

    public static synchronized void a(Context context, String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (b) {
                SQLiteDatabase a2 = a(context);
                if (a2 != null) {
                    try {
                        cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                    } catch (Exception e2) {
                        cursor = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                    if (cursor != null) {
                        try {
                        } catch (Exception e3) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        } catch (Throwable th2) {
                            cursor2 = cursor;
                            th = th2;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            a2.close();
                            throw th;
                        }
                        if (cursor.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(e.PushChannelToken.name(), str);
                            a2.update("PushShareInfo", contentValues, e.PushInfoId.name() + "=1", null);
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f1039a = 0L;
                    bVar.b = 0L;
                    bVar.c = null;
                    bVar.d = null;
                    bVar.e = null;
                    bVar.g = null;
                    bVar.f = null;
                    bVar.h = null;
                    bVar.i = null;
                    bVar.j = null;
                    a(context, bVar);
                    if (cursor != null) {
                        cursor.close();
                    }
                    a2.close();
                }
            }
        }
    }

    public static void a(Context context, String str, int i, long j, byte[] bArr, byte[] bArr2, long j2, int i2) {
        synchronized (b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(d.appId.name(), str);
                contentValues.put(d.msgId.name(), Long.valueOf(j));
                contentValues.put(d.msgType.name(), Integer.valueOf(i));
                if (bArr != null && bArr.length > 0) {
                    contentValues.put(d.msgBody.name(), BaiduAppSSOJni.a(context, str, bArr));
                    contentValues.put(d.secureInfo.name(), bArr2);
                    contentValues.put(d.expireTime.name(), Long.valueOf(j2));
                }
                contentValues.put(d.arriveTime.name(), Long.valueOf(System.currentTimeMillis()));
                contentValues.put(d.ackRet.name(), Integer.valueOf(i2));
                a2.insert("PushMsgInfos", null, contentValues);
                a2.close();
            } catch (Exception e2) {
                a2.close();
            }
        }
    }

    public static synchronized void a(Context context, String str, String str2) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (b) {
                SQLiteDatabase a2 = a(context);
                if (a2 != null) {
                    try {
                        cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                    } catch (Exception e2) {
                        cursor = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                    if (cursor != null) {
                        try {
                        } catch (Exception e3) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        } catch (Throwable th2) {
                            cursor2 = cursor;
                            th = th2;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            a2.close();
                            throw th;
                        }
                        if (cursor.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(e.PushChannelID.name(), str);
                            if (!TextUtils.isEmpty(str2)) {
                                contentValues.put(e.PushNewChannelID.name(), str2);
                            }
                            a2.update("PushShareInfo", contentValues, e.PushInfoId.name() + "=1", null);
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f1039a = 0L;
                    bVar.b = 0L;
                    bVar.c = str;
                    bVar.d = str2;
                    bVar.e = null;
                    bVar.g = null;
                    bVar.f = null;
                    bVar.h = null;
                    bVar.i = null;
                    bVar.j = null;
                    a(context, bVar);
                    if (cursor != null) {
                        cursor.close();
                    }
                    a2.close();
                }
            }
        }
    }

    public static synchronized boolean a(Context context, com.baidu.android.pushservice.c.f fVar) {
        Cursor cursor;
        Throwable th;
        boolean z;
        Cursor rawQuery;
        synchronized (c.class) {
            synchronized (b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    z = false;
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.msgId.name(), fVar.f1053a);
                    contentValues.put(f.md5Infos.name(), fVar.b);
                    contentValues.put(f.appId.name(), fVar.c);
                    contentValues.put(f.time.name(), System.currentTimeMillis() + "");
                    long j = -1;
                    Cursor cursor2 = null;
                    try {
                        try {
                            j = a2.insert("PushVerifInfo", null, contentValues);
                            rawQuery = a2.rawQuery("SELECT COUNT(*) FROM PushVerifInfo;", null);
                        } catch (Throwable th2) {
                            cursor = null;
                            th = th2;
                        }
                    } catch (Exception e2) {
                        if (0 != 0 && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        a2.close();
                    }
                    try {
                        if (rawQuery.moveToFirst() && rawQuery.getInt(0) > 200) {
                            a2.delete("PushVerifInfo", " msgId IS NOT ?", new String[]{fVar.f1053a});
                        }
                        if (rawQuery != null && !rawQuery.isClosed()) {
                            rawQuery.close();
                        }
                        a2.close();
                        z = j != -1;
                    } catch (Throwable th3) {
                        cursor = rawQuery;
                        th = th3;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        throw th;
                    }
                }
            }
        }
        return z;
    }

    public static int b(Context context) {
        Cursor cursor;
        int i;
        Cursor cursor2 = null;
        synchronized (b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return 0;
            }
            try {
                cursor = a2.query("PushShareInfo", new String[]{e.PushVersion.name()}, null, null, null, null, null);
                try {
                    int i2 = cursor.moveToFirst() ? cursor.getInt(cursor.getColumnIndex(e.PushVersion.name())) : 0;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    i = i2;
                } catch (Exception e2) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    i = 0;
                    return i;
                } catch (Throwable th) {
                    cursor2 = cursor;
                    th = th;
                    if (cursor2 != null && !cursor2.isClosed()) {
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
            return i;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String b(android.content.Context r8, java.lang.String r9, java.lang.String r10) {
        /*
            r6 = 0
            int r0 = com.baidu.android.pushservice.i.m.g(r8, r9)     // Catch: java.lang.Throwable -> L83
            r1 = 52
            if (r0 < r1) goto La4
            android.content.ContentResolver r0 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L83
            if (r0 == 0) goto La4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
            r1.<init>()     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = "content://"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L83
            java.lang.StringBuilder r1 = r1.append(r9)     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = ".bdpush"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = "/"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = "verif"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L83
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L83
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L83
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L83
            r3 = 0
            com.baidu.android.pushservice.c.c$f r4 = com.baidu.android.pushservice.c.c.f.md5Infos     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L83
            r2[r3] = r4     // Catch: java.lang.Throwable -> L83
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
            r3.<init>()     // Catch: java.lang.Throwable -> L83
            com.baidu.android.pushservice.c.c$f r4 = com.baidu.android.pushservice.c.c.f.msgId     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L83
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = "=?"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L83
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L83
            r5 = 0
            r4[r5] = r10     // Catch: java.lang.Throwable -> L83
            r5 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L83
            if (r0 == 0) goto La0
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L9e
            if (r1 == 0) goto La0
            r1 = 0
            java.lang.String r6 = r0.getString(r1)     // Catch: java.lang.Throwable -> L9e
            r7 = r6
            r6 = r0
            r0 = r7
        L7d:
            if (r6 == 0) goto L82
            r6.close()     // Catch: java.lang.Exception -> L96
        L82:
            return r0
        L83:
            r0 = move-exception
            r0 = r6
        L85:
            if (r0 == 0) goto L8a
            r0.close()     // Catch: java.lang.Exception -> L8c
        L8a:
            r0 = r6
            goto L82
        L8c:
            r0 = move-exception
            r0 = r6
            goto L82
        L8f:
            r0 = move-exception
        L90:
            if (r6 == 0) goto L95
            r6.close()     // Catch: java.lang.Exception -> L98
        L95:
            throw r0
        L96:
            r1 = move-exception
            goto L82
        L98:
            r1 = move-exception
            goto L95
        L9a:
            r1 = move-exception
            r6 = r0
            r0 = r1
            goto L90
        L9e:
            r1 = move-exception
            goto L85
        La0:
            r7 = r6
            r6 = r0
            r0 = r7
            goto L7d
        La4:
            r0 = r6
            goto L7d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.c.c.b(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public static synchronized void b(Context context, long j) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (b) {
                SQLiteDatabase a2 = a(context);
                if (a2 != null) {
                    try {
                        cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                    } catch (Exception e2) {
                        cursor = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                    if (cursor != null) {
                        try {
                        } catch (Exception e3) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        } catch (Throwable th2) {
                            cursor2 = cursor;
                            th = th2;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            a2.close();
                            throw th;
                        }
                        if (cursor.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(e.PushVersion.name(), Long.valueOf(j));
                            a2.update("PushShareInfo", contentValues, e.PushInfoId.name() + "=1", null);
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f1039a = 0L;
                    bVar.b = j;
                    bVar.c = null;
                    bVar.d = null;
                    bVar.e = null;
                    bVar.g = null;
                    bVar.f = null;
                    bVar.h = null;
                    bVar.i = null;
                    bVar.j = null;
                    a(context, bVar);
                    if (cursor != null) {
                        cursor.close();
                    }
                    a2.close();
                }
            }
        }
    }

    public static synchronized void b(Context context, String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (b) {
                SQLiteDatabase a2 = a(context);
                if (a2 != null && str != null) {
                    try {
                        cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                    } catch (Exception e2) {
                        cursor = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                    if (cursor != null) {
                        try {
                        } catch (Exception e3) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        } catch (Throwable th2) {
                            cursor2 = cursor;
                            th = th2;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            a2.close();
                            throw th;
                        }
                        if (cursor.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(e.PushClientsBindInfo.name(), str);
                            a2.update("PushShareInfo", contentValues, e.PushInfoId.name() + "=1", null);
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f1039a = 0L;
                    bVar.b = 0L;
                    bVar.c = null;
                    bVar.d = null;
                    bVar.e = null;
                    bVar.g = null;
                    bVar.f = null;
                    bVar.h = null;
                    bVar.i = str;
                    bVar.j = null;
                    a(context, bVar);
                    if (cursor != null) {
                        cursor.close();
                    }
                    a2.close();
                }
            }
        }
    }

    public static String c(Context context) {
        Cursor cursor;
        String str;
        Cursor cursor2 = null;
        synchronized (b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query("PushShareInfo", new String[]{e.PushChannelToken.name()}, null, null, null, null, null);
            } catch (Exception e2) {
                cursor = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                String string = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(e.PushChannelToken.name())) : null;
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                a2.close();
                str = string;
            } catch (Exception e3) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                a2.close();
                str = null;
                return str;
            } catch (Throwable th2) {
                cursor2 = cursor;
                th = th2;
                if (cursor2 != null && !cursor2.isClosed()) {
                    cursor2.close();
                }
                a2.close();
                throw th;
            }
            return str;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String c(android.content.Context r8, java.lang.String r9, java.lang.String r10) {
        /*
            r6 = 0
            int r0 = com.baidu.android.pushservice.i.m.g(r8, r9)     // Catch: java.lang.Throwable -> L83
            r1 = 52
            if (r0 < r1) goto La4
            android.content.ContentResolver r0 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L83
            if (r0 == 0) goto La4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
            r1.<init>()     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = "content://"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L83
            java.lang.StringBuilder r1 = r1.append(r9)     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = ".bdpush"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = "/"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = "verif"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L83
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L83
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L83
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L83
            r3 = 0
            com.baidu.android.pushservice.c.c$f r4 = com.baidu.android.pushservice.c.c.f.md5Infos     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L83
            r2[r3] = r4     // Catch: java.lang.Throwable -> L83
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
            r3.<init>()     // Catch: java.lang.Throwable -> L83
            com.baidu.android.pushservice.c.c$f r4 = com.baidu.android.pushservice.c.c.f.md5Infos     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L83
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = "=?"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L83
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L83
            r5 = 0
            r4[r5] = r10     // Catch: java.lang.Throwable -> L83
            r5 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L83
            if (r0 == 0) goto La0
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L9e
            if (r1 == 0) goto La0
            r1 = 0
            java.lang.String r6 = r0.getString(r1)     // Catch: java.lang.Throwable -> L9e
            r7 = r6
            r6 = r0
            r0 = r7
        L7d:
            if (r6 == 0) goto L82
            r6.close()     // Catch: java.lang.Exception -> L96
        L82:
            return r0
        L83:
            r0 = move-exception
            r0 = r6
        L85:
            if (r0 == 0) goto L8a
            r0.close()     // Catch: java.lang.Exception -> L8c
        L8a:
            r0 = r6
            goto L82
        L8c:
            r0 = move-exception
            r0 = r6
            goto L82
        L8f:
            r0 = move-exception
        L90:
            if (r6 == 0) goto L95
            r6.close()     // Catch: java.lang.Exception -> L98
        L95:
            throw r0
        L96:
            r1 = move-exception
            goto L82
        L98:
            r1 = move-exception
            goto L95
        L9a:
            r1 = move-exception
            r6 = r0
            r0 = r1
            goto L90
        L9e:
            r1 = move-exception
            goto L85
        La0:
            r7 = r6
            r6 = r0
            r0 = r7
            goto L7d
        La4:
            r0 = r6
            goto L7d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.c.c.c(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public static synchronized void c(Context context, String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (b) {
                SQLiteDatabase a2 = a(context);
                if (a2 != null && str != null) {
                    try {
                        cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                    } catch (Exception e2) {
                        cursor = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                    if (cursor != null) {
                        try {
                        } catch (Exception e3) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        } catch (Throwable th2) {
                            cursor2 = cursor;
                            th = th2;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            a2.close();
                            throw th;
                        }
                        if (cursor.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(e.PushSelfBindInfo.name(), str);
                            a2.update("PushShareInfo", contentValues, e.PushInfoId.name() + "=1", null);
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        }
                    }
                    com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                    bVar.f1039a = 0L;
                    bVar.b = 0L;
                    bVar.c = null;
                    bVar.d = null;
                    bVar.e = null;
                    bVar.g = null;
                    bVar.f = null;
                    bVar.h = null;
                    bVar.i = null;
                    bVar.j = str;
                    a(context, bVar);
                    if (cursor != null) {
                        cursor.close();
                    }
                    a2.close();
                }
            }
        }
    }

    public static boolean c(Context context, long j) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return false;
            }
            try {
                cursor = a2.query("PushMsgInfos", new String[]{d.msgId.name()}, d.msgId.name() + " =? ", new String[]{String.valueOf(j)}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            return true;
                        }
                    } catch (Exception e2) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        return false;
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
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                a2.close();
                return false;
            } catch (Exception e3) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static String d(Context context) {
        Cursor cursor;
        String str;
        synchronized (b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query("PushShareInfo", new String[]{e.PushClientsBindInfo.name()}, null, null, null, null, null);
                try {
                    try {
                        String string = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(e.PushClientsBindInfo.name())) : null;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        str = string;
                    } catch (Exception e2) {
                        e = e2;
                        m.a("PushInfoDataBase*BBind*" + com.baidu.android.pushservice.f.a.a(e), context);
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        str = null;
                        return str;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                a2.close();
                throw th;
            }
            return str;
        }
    }

    public static String e(Context context) {
        Cursor cursor;
        String str;
        Cursor cursor2 = null;
        synchronized (b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query("PushShareInfo", new String[]{e.PushSelfBindInfo.name()}, null, null, null, null, null);
            } catch (Exception e2) {
                cursor = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                String string = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(e.PushSelfBindInfo.name())) : null;
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                a2.close();
                str = string;
            } catch (Exception e3) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                a2.close();
                str = null;
                return str;
            } catch (Throwable th2) {
                cursor2 = cursor;
                th = th2;
                if (cursor2 != null && !cursor2.isClosed()) {
                    cursor2.close();
                }
                a2.close();
                throw th;
            }
            return str;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private static com.baidu.android.pushservice.c.c.C0045c f(android.content.Context r9) {
        /*
            r0 = 0
            com.baidu.android.pushservice.c.c$c r1 = com.baidu.android.pushservice.c.c.f1040a
            if (r1 != 0) goto Lb6
            java.lang.Object r2 = com.baidu.android.pushservice.c.c.b
            monitor-enter(r2)
            com.baidu.android.pushservice.c.c$c r1 = com.baidu.android.pushservice.c.c.f1040a     // Catch: java.lang.Throwable -> Lc3
            if (r1 != 0) goto Lb5
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> Lc3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            r3.<init>()     // Catch: java.lang.Throwable -> Lc3
            java.io.File r4 = android.os.Environment.getDataDirectory()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r4 = r4.getAbsolutePath()     // Catch: java.lang.Throwable -> Lc3
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r4 = "/data"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r4 = java.io.File.separator     // Catch: java.lang.Throwable -> Lc3
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r4 = r9.getPackageName()     // Catch: java.lang.Throwable -> Lc3
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r4 = "/database"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lc3
            r1.<init>(r3)     // Catch: java.lang.Throwable -> Lc3
            boolean r3 = r1.exists()     // Catch: java.lang.Throwable -> Lc3
            if (r3 != 0) goto L4b
            r1.mkdirs()     // Catch: java.lang.Throwable -> Lc3
        L4b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            r3.<init>()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> Lc3
            java.lang.StringBuilder r1 = r3.append(r1)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r3 = java.io.File.separator     // Catch: java.lang.Throwable -> Lc3
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r3 = "pushinfo.db"
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lc3
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lc3
            r4 = 11
            if (r3 < r4) goto Lb9
            com.baidu.android.pushservice.c.c$b r3 = new com.baidu.android.pushservice.c.c$b     // Catch: java.lang.Throwable -> Lc3
            r4 = 0
            r3.<init>()     // Catch: java.lang.Throwable -> Lc3
            com.baidu.android.pushservice.c.c$c r4 = new com.baidu.android.pushservice.c.c$c     // Catch: java.lang.Throwable -> Lc3
            r5 = 6
            r4.<init>(r9, r1, r5, r3)     // Catch: java.lang.Throwable -> Lc3
            com.baidu.android.pushservice.c.c.f1040a = r4     // Catch: java.lang.Throwable -> Lc3
        L7d:
            com.baidu.android.pushservice.c.c$c r1 = com.baidu.android.pushservice.c.c.f1040a     // Catch: java.lang.Throwable -> Lc6
            android.database.sqlite.SQLiteDatabase r0 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> Lc6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc6
            r1.<init>()     // Catch: java.lang.Throwable -> Lc6
            com.baidu.android.pushservice.c.c$d r3 = com.baidu.android.pushservice.c.c.d.arriveTime     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r3 = r3.name()     // Catch: java.lang.Throwable -> Lc6
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r3 = " < "
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> Lc6
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lc6
            r6 = 259200000(0xf731400, double:1.280618154E-315)
            long r4 = r4 - r6
            java.lang.StringBuilder r1 = r1.append(r4)     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r3 = "PushMsgInfos"
            r4 = 0
            r0.delete(r3, r1, r4)     // Catch: java.lang.Throwable -> Lc6
            if (r0 == 0) goto Lb5
            r0.close()     // Catch: java.lang.Throwable -> Lc3
        Lb5:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lc3
        Lb6:
            com.baidu.android.pushservice.c.c$c r0 = com.baidu.android.pushservice.c.c.f1040a
            return r0
        Lb9:
            com.baidu.android.pushservice.c.c$c r3 = new com.baidu.android.pushservice.c.c$c     // Catch: java.lang.Throwable -> Lc3
            r4 = 0
            r5 = 6
            r3.<init>(r9, r1, r4, r5)     // Catch: java.lang.Throwable -> Lc3
            com.baidu.android.pushservice.c.c.f1040a = r3     // Catch: java.lang.Throwable -> Lc3
            goto L7d
        Lc3:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lc3
            throw r0
        Lc6:
            r1 = move-exception
            if (r0 == 0) goto Lb5
            r0.close()     // Catch: java.lang.Throwable -> Lc3
            goto Lb5
        Lcd:
            r1 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
        Ld1:
            if (r1 == 0) goto Ld6
            r1.close()     // Catch: java.lang.Throwable -> Lc3
        Ld6:
            throw r0     // Catch: java.lang.Throwable -> Lc3
        Ld7:
            r1 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
            goto Ld1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.c.c.f(android.content.Context):com.baidu.android.pushservice.c.c$c");
    }
}
