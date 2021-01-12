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
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.live.tbadk.data.Config;
import java.io.File;
import java.util.List;
/* loaded from: classes14.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile C0040c f1234a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f1235b = new Object();

    /* loaded from: classes14.dex */
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
    /* loaded from: classes14.dex */
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

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, CHECK_CAST, IGET, CHECK_CAST, INVOKE, IF, INVOKE, INVOKE, INVOKE, INVOKE, IF] complete} */
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
            } catch (SQLiteException e) {
            }
            try {
                sQLiteDatabase.close();
            } catch (SQLiteException e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.android.pushservice.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0040c extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        private static final String f1238a = "CREATE TABLE PushShareInfo (" + e.PushInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + e.PushPriority.name() + " LONG NOT NULL DEFAULT ((0)), " + e.PushVersion.name() + " INTEGER DEFAULT ((0)), " + e.PushChannelID.name() + " TEXT, " + e.PushNewChannelID.name() + " TEXT, " + e.PushChannelToken.name() + " TEXT, " + e.PushCurPkgName.name() + " TEXT, " + e.PushWebAppBindInfo.name() + " TEXT, " + e.PushLightAppBindInfo.name() + " TEXT, " + e.PushSDKClientBindInfo.name() + " TEXT, " + e.PushClientsBindInfo.name() + " TEXT, " + e.PushSelfBindInfo.name() + " TEXT);";

        /* renamed from: b  reason: collision with root package name */
        private static final String f1239b = "CREATE TABLE PushVerifInfo (" + f.verifId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.msgId.name() + " TEXT NOT NULL, " + f.md5Infos.name() + " TEXT NOT NULL, " + f.appId.name() + " TEXT, " + f.time.name() + " TEXT);";
        private static final String c = "CREATE TABLE PushMsgInfos (" + d.MsgInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.appId.name() + "  TEXT, " + d.msgType.name() + "  INTEGER NOT NULL, " + d.msgId.name() + " LONG NOT NULL, " + d.secureInfo.name() + " TEXT, " + d.msgBody.name() + "  TEXT, " + d.expireTime.name() + "  LONG, " + d.ackRet.name() + "  INTEGER, " + d.arriveTime.name() + " LONG NOT NULL);";
        private static final String d = "CREATE TABLE PushAppStatus (" + a.actionId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + a.actionName.name() + " TEXT NOT NULL, " + a.timeStamp.name() + " LONG NOT NULL, " + a.pkgName.name() + " TEXT, " + a.versionCode.name() + " INTEGER, " + a.versionName.name() + " TEXT, " + a.status.name() + " INTEGER);";
        private static final String e = "ALTER TABLE PushShareInfo ADD COLUMN " + e.PushNewChannelID.name() + " TEXT";
        private static final String f = "ALTER TABLE PushShareInfo ADD COLUMN " + e.PushChannelToken.name() + " TEXT";

        public C0040c(Context context, String str, int i, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i, databaseErrorHandler);
        }

        public C0040c(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
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
                sQLiteDatabase.execSQL(f1238a);
                sQLiteDatabase.execSQL(f1239b);
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

    /* loaded from: classes14.dex */
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

    /* loaded from: classes14.dex */
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

    /* loaded from: classes14.dex */
    public enum f {
        verifId,
        msgId,
        md5Infos,
        appId,
        time
    }

    public static synchronized long a(Context context, com.baidu.android.pushservice.c.b bVar) {
        Throwable th;
        Cursor cursor;
        long j;
        long j2 = -1;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (f1235b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    j = -1;
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(e.PushPriority.name(), Long.valueOf(bVar.f1232a));
                    contentValues.put(e.PushVersion.name(), Long.valueOf(bVar.f1233b));
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
                    } catch (Throwable th2) {
                        th = th2;
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
                        } catch (Throwable th3) {
                            th = th3;
                            cursor2 = cursor;
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
        C0040c f2 = f(context);
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
        return f1235b;
    }

    public static String a(Context context, boolean z) {
        Throwable th;
        Cursor cursor;
        String str;
        Cursor cursor2 = null;
        String str2 = null;
        synchronized (f1235b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query("PushShareInfo", new String[]{e.PushChannelID.name(), e.PushNewChannelID.name()}, null, null, null, null, null);
            } catch (Exception e2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                if (cursor.moveToFirst()) {
                    str2 = cursor.getString(cursor.getColumnIndex(z ? e.PushNewChannelID.name() : e.PushChannelID.name()));
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                a2.close();
                str = str2;
            } catch (Exception e3) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                a2.close();
                str = null;
                return str;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null && !cursor2.isClosed()) {
                    cursor2.close();
                }
                a2.close();
                throw th;
            }
            return str;
        }
    }

    public static synchronized void a(Context context, long j) {
        Throwable th;
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (f1235b) {
                SQLiteDatabase a2 = a(context);
                if (a2 != null) {
                    try {
                        cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                    } catch (Exception e2) {
                        cursor = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (cursor != null) {
                        try {
                        } catch (Exception e3) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        } catch (Throwable th3) {
                            th = th3;
                            cursor2 = cursor;
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
                    bVar.f1232a = j;
                    bVar.f1233b = 0L;
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
        Throwable th;
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (f1235b) {
                SQLiteDatabase a2 = a(context);
                if (a2 != null) {
                    try {
                        cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                    } catch (Exception e2) {
                        cursor = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (cursor != null) {
                        try {
                        } catch (Exception e3) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        } catch (Throwable th3) {
                            th = th3;
                            cursor2 = cursor;
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
                    bVar.f1232a = 0L;
                    bVar.f1233b = 0L;
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
        synchronized (f1235b) {
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
        Throwable th;
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (f1235b) {
                SQLiteDatabase a2 = a(context);
                if (a2 != null) {
                    try {
                        cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                    } catch (Exception e2) {
                        cursor = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (cursor != null) {
                        try {
                        } catch (Exception e3) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        } catch (Throwable th3) {
                            th = th3;
                            cursor2 = cursor;
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
                    bVar.f1232a = 0L;
                    bVar.f1233b = 0L;
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
        boolean z;
        synchronized (c.class) {
            synchronized (f1235b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    z = false;
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.msgId.name(), fVar.f1260a);
                    contentValues.put(f.md5Infos.name(), fVar.f1261b);
                    contentValues.put(f.appId.name(), fVar.c);
                    contentValues.put(f.time.name(), System.currentTimeMillis() + "");
                    long j = -1;
                    Cursor cursor = null;
                    try {
                        j = a2.insert("PushVerifInfo", null, contentValues);
                        cursor = a2.rawQuery("SELECT COUNT(*) FROM PushVerifInfo;", null);
                        if (cursor.moveToFirst() && cursor.getInt(0) > 200) {
                            a2.delete("PushVerifInfo", " msgId IS NOT ?", new String[]{fVar.f1260a});
                        }
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                    } catch (Exception e2) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                    }
                    z = j != -1;
                }
            }
        }
        return z;
    }

    public static int b(Context context) {
        Throwable th;
        Cursor cursor;
        int i;
        Cursor cursor2 = null;
        synchronized (f1235b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return 0;
            }
            try {
                cursor = a2.query("PushShareInfo", new String[]{e.PushVersion.name()}, null, null, null, null, null);
            } catch (Exception e2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                int i2 = cursor.moveToFirst() ? cursor.getInt(cursor.getColumnIndex(e.PushVersion.name())) : 0;
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                a2.close();
                i = i2;
            } catch (Exception e3) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                a2.close();
                i = 0;
                return i;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null && !cursor2.isClosed()) {
                    cursor2.close();
                }
                a2.close();
                throw th;
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
    public static java.lang.String b(android.content.Context r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = 0
            int r0 = com.baidu.android.pushservice.i.m.g(r7, r8)     // Catch: java.lang.Throwable -> L81
            r1 = 52
            if (r0 < r1) goto La0
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto La0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            r1.<init>()     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = "content://"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r1 = r1.append(r8)     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = ".bdpush"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = "/"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = "verif"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L81
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L81
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L81
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L81
            r3 = 0
            com.baidu.android.pushservice.c.c$f r4 = com.baidu.android.pushservice.c.c.f.md5Infos     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L81
            r2[r3] = r4     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            r3.<init>()     // Catch: java.lang.Throwable -> L81
            com.baidu.android.pushservice.c.c$f r4 = com.baidu.android.pushservice.c.c.f.msgId     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = "=?"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L81
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L81
            r5 = 0
            r4[r5] = r9     // Catch: java.lang.Throwable -> L81
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto L9e
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L9b
            if (r0 == 0) goto L9e
            r0 = 0
            java.lang.String r6 = r1.getString(r0)     // Catch: java.lang.Throwable -> L9b
            r0 = r6
        L7b:
            if (r1 == 0) goto L80
            r1.close()     // Catch: java.lang.Exception -> L94
        L80:
            return r0
        L81:
            r0 = move-exception
            r0 = r6
        L83:
            if (r0 == 0) goto L88
            r0.close()     // Catch: java.lang.Exception -> L8a
        L88:
            r0 = r6
            goto L80
        L8a:
            r0 = move-exception
            r0 = r6
            goto L80
        L8d:
            r0 = move-exception
        L8e:
            if (r6 == 0) goto L93
            r6.close()     // Catch: java.lang.Exception -> L96
        L93:
            throw r0
        L94:
            r1 = move-exception
            goto L80
        L96:
            r1 = move-exception
            goto L93
        L98:
            r0 = move-exception
            r6 = r1
            goto L8e
        L9b:
            r0 = move-exception
            r0 = r1
            goto L83
        L9e:
            r0 = r6
            goto L7b
        La0:
            r0 = r6
            r1 = r6
            goto L7b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.c.c.b(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public static synchronized void b(Context context, long j) {
        Throwable th;
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (f1235b) {
                SQLiteDatabase a2 = a(context);
                if (a2 != null) {
                    try {
                        cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                    } catch (Exception e2) {
                        cursor = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (cursor != null) {
                        try {
                        } catch (Exception e3) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        } catch (Throwable th3) {
                            th = th3;
                            cursor2 = cursor;
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
                    bVar.f1232a = 0L;
                    bVar.f1233b = j;
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
        Throwable th;
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (f1235b) {
                SQLiteDatabase a2 = a(context);
                if (a2 != null && str != null) {
                    try {
                        cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                    } catch (Exception e2) {
                        cursor = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (cursor != null) {
                        try {
                        } catch (Exception e3) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        } catch (Throwable th3) {
                            th = th3;
                            cursor2 = cursor;
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
                    bVar.f1232a = 0L;
                    bVar.f1233b = 0L;
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
        Throwable th;
        Cursor cursor;
        String str;
        Cursor cursor2 = null;
        synchronized (f1235b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query("PushShareInfo", new String[]{e.PushChannelToken.name()}, null, null, null, null, null);
                try {
                    String string = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(e.PushChannelToken.name())) : null;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    str = string;
                } catch (Exception e2) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    str = null;
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    a2.close();
                    throw th;
                }
            } catch (Exception e3) {
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
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
    public static java.lang.String c(android.content.Context r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = 0
            int r0 = com.baidu.android.pushservice.i.m.g(r7, r8)     // Catch: java.lang.Throwable -> L81
            r1 = 52
            if (r0 < r1) goto La0
            android.content.ContentResolver r0 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto La0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            r1.<init>()     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = "content://"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r1 = r1.append(r8)     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = ".bdpush"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = "/"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = "verif"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L81
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L81
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L81
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L81
            r3 = 0
            com.baidu.android.pushservice.c.c$f r4 = com.baidu.android.pushservice.c.c.f.md5Infos     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L81
            r2[r3] = r4     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            r3.<init>()     // Catch: java.lang.Throwable -> L81
            com.baidu.android.pushservice.c.c$f r4 = com.baidu.android.pushservice.c.c.f.md5Infos     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = "=?"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L81
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L81
            r5 = 0
            r4[r5] = r9     // Catch: java.lang.Throwable -> L81
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto L9e
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L9b
            if (r0 == 0) goto L9e
            r0 = 0
            java.lang.String r6 = r1.getString(r0)     // Catch: java.lang.Throwable -> L9b
            r0 = r6
        L7b:
            if (r1 == 0) goto L80
            r1.close()     // Catch: java.lang.Exception -> L94
        L80:
            return r0
        L81:
            r0 = move-exception
            r0 = r6
        L83:
            if (r0 == 0) goto L88
            r0.close()     // Catch: java.lang.Exception -> L8a
        L88:
            r0 = r6
            goto L80
        L8a:
            r0 = move-exception
            r0 = r6
            goto L80
        L8d:
            r0 = move-exception
        L8e:
            if (r6 == 0) goto L93
            r6.close()     // Catch: java.lang.Exception -> L96
        L93:
            throw r0
        L94:
            r1 = move-exception
            goto L80
        L96:
            r1 = move-exception
            goto L93
        L98:
            r0 = move-exception
            r6 = r1
            goto L8e
        L9b:
            r0 = move-exception
            r0 = r1
            goto L83
        L9e:
            r0 = r6
            goto L7b
        La0:
            r0 = r6
            r1 = r6
            goto L7b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.c.c.c(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public static synchronized void c(Context context, String str) {
        Throwable th;
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (f1235b) {
                SQLiteDatabase a2 = a(context);
                if (a2 != null && str != null) {
                    try {
                        cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                    } catch (Exception e2) {
                        cursor = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (cursor != null) {
                        try {
                        } catch (Exception e3) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                        } catch (Throwable th3) {
                            th = th3;
                            cursor2 = cursor;
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
                    bVar.f1232a = 0L;
                    bVar.f1233b = 0L;
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
        Throwable th;
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (f1235b) {
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
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
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
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public static String d(Context context) {
        Cursor cursor;
        String str;
        synchronized (f1235b) {
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
        Throwable th;
        Cursor cursor;
        String str;
        Cursor cursor2 = null;
        synchronized (f1235b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query("PushShareInfo", new String[]{e.PushSelfBindInfo.name()}, null, null, null, null, null);
                try {
                    String string = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(e.PushSelfBindInfo.name())) : null;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    str = string;
                } catch (Exception e2) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    str = null;
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    a2.close();
                    throw th;
                }
            } catch (Exception e3) {
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
            }
            return str;
        }
    }

    private static C0040c f(Context context) {
        if (f1234a == null) {
            synchronized (f1235b) {
                if (f1234a == null) {
                    File file = new File(Environment.getDataDirectory().getAbsolutePath() + "/data" + File.separator + context.getPackageName() + "/database");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String str = file.getAbsolutePath() + File.separator + "pushinfo.db";
                    if (Build.VERSION.SDK_INT >= 11) {
                        f1234a = new C0040c(context, str, 6, new b());
                    } else {
                        f1234a = new C0040c(context, str, (SQLiteDatabase.CursorFactory) null, 6);
                    }
                    SQLiteDatabase writableDatabase = f1234a.getWritableDatabase();
                    writableDatabase.delete("PushMsgInfos", d.arriveTime.name() + " < " + (System.currentTimeMillis() - Config.THREAD_IMAGE_SAVE_MAX_TIME), null);
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                }
            }
        }
        return f1234a;
    }
}
