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
import android.os.Environment;
import android.util.Pair;
import com.baidu.android.pushservice.h.h;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private static C0032c a = null;
    private static b b = null;
    private static final Object c = new Object();
    private static int d = 100;

    /* loaded from: classes2.dex */
    public enum a {
        actionId,
        actionName,
        timeStamp,
        appid,
        pkgName,
        versionCode,
        versionName,
        status
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
    /* renamed from: com.baidu.android.pushservice.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0032c extends SQLiteOpenHelper {
        private static final String a = "CREATE TABLE PushShareInfo (" + e.PushInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + e.PushPriority.name() + " LONG NOT NULL DEFAULT ((0)), " + e.PushVersion.name() + " INTEGER DEFAULT ((0)), " + e.PushChannelID.name() + " TEXT, " + e.PushCurPkgName.name() + " TEXT, " + e.PushWebAppBindInfo.name() + " TEXT, " + e.PushLightAppBindInfo.name() + " TEXT, " + e.PushSDKClientBindInfo.name() + " TEXT, " + e.PushClientsBindInfo.name() + " TEXT, " + e.PushSelfBindInfo.name() + " TEXT);";
        private static final String b = "CREATE TABLE PushVerifInfo (" + f.verifId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.msgId.name() + " TEXT NOT NULL, " + f.md5Infos.name() + " TEXT NOT NULL, " + f.appId.name() + " TEXT, " + f.time.name() + " TEXT);";
        private static final String c = "CREATE TABLE PushMsgInfos (" + d.MsgInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.appId.name() + "  TEXT, " + d.msgType.name() + "  INTEGER NOT NULL, " + d.msgId.name() + " LONG NOT NULL, " + d.secureInfo.name() + " TEXT, " + d.msgBody.name() + "  TEXT, " + d.expireTime.name() + "  LONG, " + d.ackRet.name() + "  INTEGER, " + d.arriveTime.name() + " LONG NOT NULL);";
        private static final String d = "CREATE TABLE PushAppStatus (" + a.actionId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + a.actionName.name() + " TEXT NOT NULL, " + a.timeStamp.name() + " LONG NOT NULL, " + a.pkgName.name() + " TEXT, " + a.versionCode.name() + " INTEGER, " + a.versionName.name() + " TEXT, " + a.status.name() + " INTEGER);";

        public C0032c(Context context, String str, int i, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i, databaseErrorHandler);
        }

        public C0032c(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushShareInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushVerifyInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushMsgInfo");
            } catch (Exception e) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(a);
                sQLiteDatabase.execSQL(b);
                sQLiteDatabase.execSQL(c);
                sQLiteDatabase.execSQL(d);
            } catch (Exception e) {
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
            } else if (i == 3) {
                sQLiteDatabase.execSQL(d);
            }
        }
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public enum e {
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

    /* loaded from: classes2.dex */
    public enum f {
        verifId,
        msgId,
        md5Infos,
        appId,
        time
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ed A[Catch: all -> 0x00f4, TryCatch #4 {, blocks: (B:4:0x0006, B:5:0x0008, B:6:0x0009, B:8:0x000f, B:12:0x0013, B:20:0x00e2, B:22:0x00e8, B:24:0x00ed, B:25:0x00f1, B:37:0x010c, B:39:0x0112, B:41:0x0117, B:44:0x011f, B:46:0x0125, B:48:0x012a, B:49:0x012d), top: B:59:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized long a(Context context, com.baidu.android.pushservice.d.b bVar) {
        Cursor cursor;
        long j;
        long j2 = -1;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (c) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    j = -1;
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(e.PushPriority.name(), Long.valueOf(bVar.a));
                    contentValues.put(e.PushVersion.name(), Long.valueOf(bVar.b));
                    contentValues.put(e.PushChannelID.name(), bVar.c);
                    contentValues.put(e.PushCurPkgName.name(), bVar.d);
                    contentValues.put(e.PushLightAppBindInfo.name(), bVar.f);
                    contentValues.put(e.PushWebAppBindInfo.name(), bVar.e);
                    contentValues.put(e.PushSDKClientBindInfo.name(), bVar.g);
                    contentValues.put(e.PushClientsBindInfo.name(), bVar.h);
                    contentValues.put(e.PushSelfBindInfo.name(), bVar.i);
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
                            if (a2 != null) {
                                a2.close();
                                j = j2;
                                return j;
                            }
                            j = j2;
                            return j;
                        } catch (Throwable th2) {
                            cursor2 = cursor;
                            th = th2;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                            throw th;
                        }
                        if (cursor.getCount() != 0) {
                            j2 = a2.update("PushShareInfo", contentValues, e.PushInfoId.name() + "=1", null);
                            p.b("pushadvertiseinfo:  update into database", context);
                            p.b("updatePushInfo pushinfo:  insert into database,  clientinfo = " + bVar.a().toString(), context);
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            if (a2 != null) {
                                a2.close();
                                j = j2;
                            }
                            j = j2;
                        }
                    }
                    j2 = a2.insert("PushShareInfo", null, contentValues);
                    p.b("pushadvertiseinfo:  insert into database", context);
                    p.b("updatePushInfo pushinfo:  insert into database,  clientinfo = " + bVar.a().toString(), context);
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
        C0032c i = i(context);
        if (i == null) {
            return null;
        }
        try {
            return i.getWritableDatabase();
        } catch (Throwable th) {
            q.a(context, th);
            return null;
        }
    }

    public static Object a() {
        return c;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String a(android.content.Context r8, java.lang.String r9, java.lang.String r10) {
        /*
            r6 = 0
            int r0 = com.baidu.android.pushservice.j.p.m(r8, r9)     // Catch: java.lang.Throwable -> L83
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
            com.baidu.android.pushservice.d.c$f r4 = com.baidu.android.pushservice.d.c.f.md5Infos     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L83
            r2[r3] = r4     // Catch: java.lang.Throwable -> L83
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
            r3.<init>()     // Catch: java.lang.Throwable -> L83
            com.baidu.android.pushservice.d.c$f r4 = com.baidu.android.pushservice.d.c.f.msgId     // Catch: java.lang.Throwable -> L83
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.c.a(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0065 A[Catch: all -> 0x006a, TryCatch #5 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:8:0x000d, B:17:0x005a, B:19:0x0060, B:21:0x0065, B:22:0x0068, B:34:0x0097, B:36:0x009d, B:38:0x00a2, B:41:0x00a9, B:43:0x00af, B:45:0x00b4, B:46:0x00b7), top: B:51:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void a(Context context, long j) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (c) {
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
                            if (a2 != null) {
                                a2.close();
                            }
                        } catch (Throwable th2) {
                            cursor2 = cursor;
                            th = th2;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                            throw th;
                        }
                        if (cursor.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(e.PushPriority.name(), Long.valueOf(j));
                            a2.update("PushShareInfo", contentValues, e.PushInfoId.name() + "=1", null);
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                        }
                    }
                    com.baidu.android.pushservice.d.b bVar = new com.baidu.android.pushservice.d.b();
                    bVar.a = j;
                    bVar.b = 0L;
                    bVar.c = null;
                    bVar.d = null;
                    bVar.f = null;
                    bVar.e = null;
                    bVar.g = null;
                    bVar.h = null;
                    bVar.i = null;
                    a(context, bVar);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (a2 != null) {
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0061 A[Catch: all -> 0x0066, TryCatch #4 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:8:0x000d, B:17:0x0056, B:19:0x005c, B:21:0x0061, B:22:0x0064, B:34:0x0094, B:36:0x009a, B:38:0x009f, B:41:0x00a6, B:43:0x00ac, B:45:0x00b1, B:46:0x00b4), top: B:51:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void a(Context context, String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (c) {
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
                            if (a2 != null) {
                                a2.close();
                            }
                        } catch (Throwable th2) {
                            cursor2 = cursor;
                            th = th2;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                            throw th;
                        }
                        if (cursor.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(e.PushChannelID.name(), str);
                            a2.update("PushShareInfo", contentValues, e.PushInfoId.name() + "=1", null);
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                        }
                    }
                    com.baidu.android.pushservice.d.b bVar = new com.baidu.android.pushservice.d.b();
                    bVar.a = 0L;
                    bVar.b = 0L;
                    bVar.c = str;
                    bVar.d = null;
                    bVar.f = null;
                    bVar.e = null;
                    bVar.g = null;
                    bVar.h = null;
                    bVar.i = null;
                    a(context, bVar);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (a2 != null) {
                    }
                }
            }
        }
    }

    public static void a(Context context, String str, int i, long j, byte[] bArr, byte[] bArr2, long j2, int i2) {
        synchronized (c) {
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
                    contentValues.put(d.msgBody.name(), BaiduAppSSOJni.getEncrypted(context, str, bArr));
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

    public static synchronized void a(Context context, List<h> list) {
        synchronized (c.class) {
            synchronized (c) {
                SQLiteDatabase a2 = a(context);
                if (a2 != null) {
                    try {
                        a2.beginTransaction();
                        a2.delete("PushAppStatus", null, null);
                        for (h hVar : list) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(a.actionName.name(), hVar.d);
                            contentValues.put(a.pkgName.name(), hVar.j);
                            contentValues.put(a.timeStamp.name(), Long.valueOf(hVar.e));
                            contentValues.put(a.versionCode.name(), Integer.valueOf(hVar.b));
                            contentValues.put(a.versionName.name(), hVar.a);
                            contentValues.put(a.status.name(), Integer.valueOf(hVar.c));
                            a2.insert("PushAppStatus", null, contentValues);
                        }
                        a2.setTransactionSuccessful();
                        a2.endTransaction();
                        a2.close();
                    } catch (Exception e2) {
                        a2.endTransaction();
                        a2.close();
                    } catch (Throwable th) {
                        a2.endTransaction();
                        a2.close();
                        throw th;
                    }
                }
            }
        }
    }

    public static synchronized boolean a(Context context, com.baidu.android.pushservice.d.e eVar) {
        Cursor cursor;
        Throwable th;
        boolean z;
        Cursor rawQuery;
        synchronized (c.class) {
            synchronized (c) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    z = false;
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(f.msgId.name(), eVar.a);
                    contentValues.put(f.md5Infos.name(), eVar.b);
                    contentValues.put(f.appId.name(), eVar.d);
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
                        try {
                            rawQuery.moveToFirst();
                            if (rawQuery.getInt(0) > d) {
                                a2.delete("PushVerifInfo", " msgId IS NOT ?", new String[]{eVar.a});
                            }
                            if (rawQuery != null && !rawQuery.isClosed()) {
                                rawQuery.close();
                            }
                            a2.close();
                        } catch (Throwable th3) {
                            cursor = rawQuery;
                            th = th3;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            a2.close();
                            throw th;
                        }
                    } catch (Exception e2) {
                        if (0 != 0 && !cursor2.isClosed()) {
                            cursor2.close();
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
        Cursor cursor;
        int i;
        Cursor cursor2 = null;
        synchronized (c) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return 0;
            }
            try {
                cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                try {
                    r8 = cursor.moveToFirst() ? cursor.getInt(cursor.getColumnIndex(e.PushPriority.name())) : 0;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Exception e2) {
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
                } catch (Throwable th) {
                    cursor2 = cursor;
                    th = th;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    if (a2 != null) {
                        a2.close();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            if (a2 != null) {
                a2.close();
                i = r8;
                return i;
            }
            i = r8;
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
            int r0 = com.baidu.android.pushservice.j.p.m(r8, r9)     // Catch: java.lang.Throwable -> L83
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
            com.baidu.android.pushservice.d.c$f r4 = com.baidu.android.pushservice.d.c.f.md5Infos     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L83
            r2[r3] = r4     // Catch: java.lang.Throwable -> L83
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
            r3.<init>()     // Catch: java.lang.Throwable -> L83
            com.baidu.android.pushservice.d.c$f r4 = com.baidu.android.pushservice.d.c.f.md5Infos     // Catch: java.lang.Throwable -> L83
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.d.c.b(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0065 A[Catch: all -> 0x006a, TryCatch #5 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:8:0x000d, B:17:0x005a, B:19:0x0060, B:21:0x0065, B:22:0x0068, B:34:0x0097, B:36:0x009d, B:38:0x00a2, B:41:0x00a9, B:43:0x00af, B:45:0x00b4, B:46:0x00b7), top: B:51:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void b(Context context, long j) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (c) {
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
                            if (a2 != null) {
                                a2.close();
                            }
                        } catch (Throwable th2) {
                            cursor2 = cursor;
                            th = th2;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                            throw th;
                        }
                        if (cursor.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(e.PushVersion.name(), Long.valueOf(j));
                            a2.update("PushShareInfo", contentValues, e.PushInfoId.name() + "=1", null);
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                        }
                    }
                    com.baidu.android.pushservice.d.b bVar = new com.baidu.android.pushservice.d.b();
                    bVar.a = 0L;
                    bVar.b = j;
                    bVar.c = null;
                    bVar.d = null;
                    bVar.f = null;
                    bVar.e = null;
                    bVar.g = null;
                    bVar.h = null;
                    bVar.i = null;
                    a(context, bVar);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (a2 != null) {
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0061 A[Catch: all -> 0x0066, TryCatch #4 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:8:0x000d, B:17:0x0056, B:19:0x005c, B:21:0x0061, B:22:0x0064, B:34:0x0094, B:36:0x009a, B:38:0x009f, B:41:0x00a6, B:43:0x00ac, B:45:0x00b1, B:46:0x00b4), top: B:51:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void b(Context context, String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (c) {
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
                            if (a2 != null) {
                                a2.close();
                            }
                        } catch (Throwable th2) {
                            cursor2 = cursor;
                            th = th2;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                            throw th;
                        }
                        if (cursor.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(e.PushCurPkgName.name(), str);
                            a2.update("PushShareInfo", contentValues, e.PushInfoId.name() + "=1", null);
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                        }
                    }
                    com.baidu.android.pushservice.d.b bVar = new com.baidu.android.pushservice.d.b();
                    bVar.a = 0L;
                    bVar.b = 0L;
                    bVar.c = null;
                    bVar.d = str;
                    bVar.f = null;
                    bVar.e = null;
                    bVar.g = null;
                    bVar.h = null;
                    bVar.i = null;
                    a(context, bVar);
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
            if (a2 == null) {
                return 0;
            }
            try {
                cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                try {
                    r8 = cursor.moveToFirst() ? cursor.getInt(cursor.getColumnIndex(e.PushVersion.name())) : 0;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Exception e2) {
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
                } catch (Throwable th) {
                    cursor2 = cursor;
                    th = th;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    if (a2 != null) {
                        a2.close();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            if (a2 != null) {
                a2.close();
                i = r8;
                return i;
            }
            i = r8;
            return i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0063 A[Catch: all -> 0x0068, TryCatch #4 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:18:0x0058, B:20:0x005e, B:22:0x0063, B:23:0x0066, B:35:0x0096, B:37:0x009c, B:39:0x00a1, B:42:0x00a8, B:44:0x00ae, B:46:0x00b3, B:47:0x00b6, B:9:0x000f), top: B:52:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void c(Context context, String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (c) {
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
                            if (a2 != null) {
                                a2.close();
                            }
                        } catch (Throwable th2) {
                            cursor2 = cursor;
                            th = th2;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                            throw th;
                        }
                        if (cursor.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(e.PushSDKClientBindInfo.name(), str);
                            a2.update("PushShareInfo", contentValues, e.PushInfoId.name() + "=1", null);
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                        }
                    }
                    com.baidu.android.pushservice.d.b bVar = new com.baidu.android.pushservice.d.b();
                    bVar.a = 0L;
                    bVar.b = 0L;
                    bVar.c = null;
                    bVar.d = null;
                    bVar.f = null;
                    bVar.e = null;
                    bVar.g = str;
                    bVar.h = null;
                    bVar.i = null;
                    a(context, bVar);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (a2 != null) {
                    }
                }
            }
        }
    }

    public static boolean c(Context context, long j) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return false;
            }
            try {
                cursor = a2.query("PushMsgInfos", null, d.msgId.name() + " =? ", new String[]{String.valueOf(j)}, null, null, null);
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
        Cursor cursor2 = null;
        synchronized (c) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                try {
                    String string = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(e.PushChannelID.name())) : null;
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

    /* JADX WARN: Removed duplicated region for block: B:22:0x0063 A[Catch: all -> 0x0068, TryCatch #4 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:18:0x0058, B:20:0x005e, B:22:0x0063, B:23:0x0066, B:35:0x0096, B:37:0x009c, B:39:0x00a1, B:42:0x00a8, B:44:0x00ae, B:46:0x00b3, B:47:0x00b6, B:9:0x000f), top: B:52:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void d(Context context, String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (c) {
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
                            if (a2 != null) {
                                a2.close();
                            }
                        } catch (Throwable th2) {
                            cursor2 = cursor;
                            th = th2;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                            throw th;
                        }
                        if (cursor.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(e.PushClientsBindInfo.name(), str);
                            a2.update("PushShareInfo", contentValues, e.PushInfoId.name() + "=1", null);
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                        }
                    }
                    com.baidu.android.pushservice.d.b bVar = new com.baidu.android.pushservice.d.b();
                    bVar.a = 0L;
                    bVar.b = 0L;
                    bVar.c = null;
                    bVar.d = null;
                    bVar.f = null;
                    bVar.e = null;
                    bVar.g = null;
                    bVar.h = str;
                    bVar.i = null;
                    a(context, bVar);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (a2 != null) {
                    }
                }
            }
        }
    }

    public static String e(Context context) {
        Cursor cursor;
        String str;
        Cursor cursor2 = null;
        synchronized (c) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                try {
                    String string = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(e.PushSDKClientBindInfo.name())) : null;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    if (a2 != null) {
                        a2.close();
                        str = string;
                    } else {
                        str = string;
                    }
                } catch (Exception e2) {
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
                } catch (Throwable th) {
                    cursor2 = cursor;
                    th = th;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    if (a2 != null) {
                        a2.close();
                    }
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

    /* JADX WARN: Removed duplicated region for block: B:22:0x0063 A[Catch: all -> 0x0068, TryCatch #4 {, blocks: (B:4:0x0004, B:5:0x0006, B:6:0x0007, B:18:0x0058, B:20:0x005e, B:22:0x0063, B:23:0x0066, B:35:0x0096, B:37:0x009c, B:39:0x00a1, B:42:0x00a8, B:44:0x00ae, B:46:0x00b3, B:47:0x00b6, B:9:0x000f), top: B:52:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void e(Context context, String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        synchronized (c.class) {
            synchronized (c) {
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
                            if (a2 != null) {
                                a2.close();
                            }
                        } catch (Throwable th2) {
                            cursor2 = cursor;
                            th = th2;
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                            throw th;
                        }
                        if (cursor.getCount() != 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(e.PushSelfBindInfo.name(), str);
                            a2.update("PushShareInfo", contentValues, e.PushInfoId.name() + "=1", null);
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            if (a2 != null) {
                                a2.close();
                            }
                        }
                    }
                    com.baidu.android.pushservice.d.b bVar = new com.baidu.android.pushservice.d.b();
                    bVar.a = 0L;
                    bVar.b = 0L;
                    bVar.c = null;
                    bVar.d = null;
                    bVar.f = null;
                    bVar.e = null;
                    bVar.g = null;
                    bVar.h = null;
                    bVar.i = str;
                    a(context, bVar);
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (a2 != null) {
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    public static String f(Context context) {
        Cursor cursor;
        String str;
        synchronized (c) {
            SQLiteDatabase a2 = a(context);
            try {
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                    try {
                        r8 = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(e.PushClientsBindInfo.name())) : null;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (a2 != null) {
                            a2.close();
                            str = r8;
                        } else {
                            str = r8;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        p.b("PushInfoDataBase*BBind*" + com.baidu.android.pushservice.g.a.a(e), context);
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
                } catch (Exception e3) {
                    e = e3;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0 && !r8.isClosed()) {
                        r8.close();
                    }
                    if (a2 != null) {
                        a2.close();
                    }
                    throw th;
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static String g(Context context) {
        Cursor cursor;
        String str;
        Cursor cursor2 = null;
        synchronized (c) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query("PushShareInfo", null, null, null, null, null, null);
                try {
                    String string = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(e.PushSelfBindInfo.name())) : null;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    if (a2 != null) {
                        a2.close();
                        str = string;
                    } else {
                        str = string;
                    }
                } catch (Exception e2) {
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
                } catch (Throwable th) {
                    cursor2 = cursor;
                    th = th;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    if (a2 != null) {
                        a2.close();
                    }
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

    public static synchronized List<com.baidu.android.pushservice.h.e> h(Context context) {
        ArrayList arrayList;
        Cursor cursor = null;
        synchronized (c.class) {
            synchronized (c) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    try {
                        String name = a.timeStamp.name();
                        cursor = a2.query("PushAppStatus", null, null, null, null, null, name + " DESC");
                        if (cursor != null && cursor.getCount() > 0) {
                            int columnIndex = cursor.getColumnIndex(a.actionName.name());
                            int columnIndex2 = cursor.getColumnIndex(a.pkgName.name());
                            int columnIndex3 = cursor.getColumnIndex(name);
                            int columnIndex4 = cursor.getColumnIndex(a.versionCode.name());
                            int columnIndex5 = cursor.getColumnIndex(a.versionName.name());
                            int columnIndex6 = cursor.getColumnIndex(a.status.name());
                            while (cursor.moveToNext()) {
                                com.baidu.android.pushservice.h.e eVar = new com.baidu.android.pushservice.h.e();
                                eVar.a(cursor.getString(columnIndex));
                                eVar.h(cursor.getString(columnIndex2));
                                eVar.a(cursor.getLong(columnIndex3));
                                eVar.f(cursor.getInt(columnIndex4));
                                eVar.j(cursor.getString(columnIndex5));
                                eVar.g(cursor.getInt(columnIndex6));
                                arrayList2.add(eVar);
                            }
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
                    arrayList = arrayList2;
                }
            }
        }
        return arrayList;
    }

    private static C0032c i(Context context) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        SQLiteDatabase sQLiteDatabase2 = null;
        synchronized (c) {
            if (a == null) {
                File file = new File(Environment.getDataDirectory().getAbsolutePath() + "/data" + File.separator + context.getPackageName() + "/database");
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str = file.getAbsolutePath() + File.separator + "pushinfo.db";
                if (Build.VERSION.SDK_INT >= 11) {
                    b = new b();
                    a = new C0032c(context, str, 4, b);
                } else {
                    a = new C0032c(context, str, (SQLiteDatabase.CursorFactory) null, 4);
                }
                try {
                    try {
                        SQLiteDatabase writableDatabase = a.getWritableDatabase();
                        try {
                            writableDatabase.delete("PushMsgInfos", d.arriveTime.name() + " < " + (System.currentTimeMillis() - 259200000), null);
                            if (writableDatabase != null) {
                                writableDatabase.close();
                            }
                        } catch (Throwable th2) {
                            sQLiteDatabase = writableDatabase;
                            th = th2;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        if (0 != 0) {
                            sQLiteDatabase2.close();
                        }
                    }
                } catch (Throwable th3) {
                    sQLiteDatabase = null;
                    th = th3;
                }
            }
        }
        return a;
    }
}
