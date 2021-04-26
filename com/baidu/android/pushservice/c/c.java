package com.baidu.android.pushservice.c;

import android.annotation.TargetApi;
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
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.pushservice.j.i;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.message.a.l;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f2879a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f2880b = new Object();

    /* loaded from: classes.dex */
    public enum a {
        actionId,
        actionName,
        timeStamp,
        pkgName,
        versionCode,
        versionName,
        status
    }

    /* loaded from: classes.dex */
    public enum b {
        timeStamps,
        clickData
    }

    /* renamed from: com.baidu.android.pushservice.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0032c implements DatabaseErrorHandler {
        public C0032c() {
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
    public static class d extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        public static final String f2892a = "CREATE TABLE PushShareInfo (" + g.PushInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + g.PushPriority.name() + " LONG NOT NULL DEFAULT ((0)), " + g.PushVersion.name() + " INTEGER DEFAULT ((0)), " + g.PushChannelID.name() + " TEXT, " + g.PushNewChannelID.name() + " TEXT, " + g.PushChannelToken.name() + " TEXT, " + g.PushCurPkgName.name() + " TEXT, " + g.PushWebAppBindInfo.name() + " TEXT, " + g.PushLightAppBindInfo.name() + " TEXT, " + g.PushSDKClientBindInfo.name() + " TEXT, " + g.PushClientsBindInfo.name() + " TEXT, " + g.PushSelfBindInfo.name() + " TEXT);";

        /* renamed from: b  reason: collision with root package name */
        public static final String f2893b;

        /* renamed from: c  reason: collision with root package name */
        public static final String f2894c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f2895d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f2896e;

        /* renamed from: f  reason: collision with root package name */
        public static final String f2897f;

        /* renamed from: g  reason: collision with root package name */
        public static final String f2898g;

        /* renamed from: h  reason: collision with root package name */
        public static final String f2899h;

        /* renamed from: i  reason: collision with root package name */
        public static final String f2900i;

        static {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE PushVerifInfo (");
            sb.append(h.verifId.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(h.msgId.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(h.md5Infos.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(h.appId.name());
            sb.append(" TEXT, ");
            sb.append(h.time.name());
            sb.append(" TEXT);");
            f2893b = sb.toString();
            f2894c = "CREATE TABLE PushMsgInfos (" + e.MsgInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + e.appId.name() + "  TEXT, " + e.msgType.name() + "  INTEGER NOT NULL, " + e.msgId.name() + " LONG NOT NULL, " + e.secureInfo.name() + " TEXT, " + e.msgBody.name() + "  TEXT, " + e.expireTime.name() + "  LONG, " + e.ackRet.name() + "  INTEGER, " + e.arriveTime.name() + " LONG NOT NULL, " + e.notifyId.name() + "  INTEGER);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE PushDataInfo (");
            sb2.append(f.dataKey.name());
            sb2.append(" TEXT NOT NULL, ");
            sb2.append(f.dataSensitive.name());
            sb2.append(" INTEGER NOT NULL DEFAULT ((0)), ");
            sb2.append(f.canUpload.name());
            sb2.append(" INTEGER NOT NULL DEFAULT ((0)), ");
            sb2.append(f.timeInterval.name());
            sb2.append("  LONG NOT NULL, ");
            sb2.append(f.dataValue.name());
            sb2.append(" TEXT,");
            sb2.append(f.lastUpdateStamp.name());
            sb2.append(" LONG,");
            sb2.append(f.bindCanUpload.name());
            sb2.append(" INTEGER DEFAULT ((0)));");
            f2895d = sb2.toString();
            f2896e = "CREATE TABLE ClickMsgUploadInfo (" + b.timeStamps.name() + " LONG NOT NULL," + b.clickData.name() + " TEXT NOT NULL);";
            f2897f = "CREATE TABLE PushAppStatus (" + a.actionId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + a.actionName.name() + " TEXT NOT NULL, " + a.timeStamp.name() + " LONG NOT NULL, " + a.pkgName.name() + " TEXT, " + a.versionCode.name() + " INTEGER, " + a.versionName.name() + " TEXT, " + a.status.name() + " INTEGER);";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ALTER TABLE PushShareInfo ADD COLUMN ");
            sb3.append(g.PushNewChannelID.name());
            sb3.append(" TEXT");
            f2898g = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("ALTER TABLE PushShareInfo ADD COLUMN ");
            sb4.append(g.PushChannelToken.name());
            sb4.append(" TEXT");
            f2899h = sb4.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ALTER TABLE PushMsgInfos ADD COLUMN ");
            sb5.append(e.notifyId.name());
            sb5.append(" INTEGER");
            f2900i = sb5.toString();
        }

        public d(Context context, String str, int i2, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i2, databaseErrorHandler);
        }

        public d(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
            super(context, str, cursorFactory, i2);
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushShareInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushVerifyInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushMsgInfo");
            } catch (Exception unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(f2892a);
                sQLiteDatabase.execSQL(f2893b);
                sQLiteDatabase.execSQL(f2894c);
                sQLiteDatabase.execSQL(f2897f);
                sQLiteDatabase.execSQL(f2895d);
                sQLiteDatabase.execSQL(f2896e);
            } catch (Exception unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            String str;
            String str2;
            String str3;
            if (i2 <= 1) {
                a(sQLiteDatabase);
                onCreate(sQLiteDatabase);
                return;
            }
            if (i2 == 2) {
                sQLiteDatabase.execSQL(f2894c);
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        sQLiteDatabase.execSQL(f2895d);
                        str3 = f2896e;
                        sQLiteDatabase.execSQL(str3);
                        str2 = f2899h;
                        sQLiteDatabase.execSQL(str2);
                        str = f2900i;
                        sQLiteDatabase.execSQL(str);
                    } else if (i2 == 6) {
                        sQLiteDatabase.execSQL(f2895d);
                        str2 = f2896e;
                        sQLiteDatabase.execSQL(str2);
                        str = f2900i;
                        sQLiteDatabase.execSQL(str);
                    } else if (i2 == 7) {
                        sQLiteDatabase.execSQL(f2895d);
                        str = f2896e;
                        sQLiteDatabase.execSQL(str);
                    } else {
                        return;
                    }
                }
                sQLiteDatabase.execSQL(f2895d);
                sQLiteDatabase.execSQL(f2896e);
                str3 = f2898g;
                sQLiteDatabase.execSQL(str3);
                str2 = f2899h;
                sQLiteDatabase.execSQL(str2);
                str = f2900i;
                sQLiteDatabase.execSQL(str);
            }
            sQLiteDatabase.execSQL(f2897f);
            sQLiteDatabase.execSQL(f2895d);
            sQLiteDatabase.execSQL(f2896e);
            str3 = f2898g;
            sQLiteDatabase.execSQL(str3);
            str2 = f2899h;
            sQLiteDatabase.execSQL(str2);
            str = f2900i;
            sQLiteDatabase.execSQL(str);
        }
    }

    /* loaded from: classes.dex */
    public enum e {
        MsgInfoId,
        appId,
        msgType,
        msgId,
        arriveTime,
        secureInfo,
        msgBody,
        expireTime,
        ackRet,
        notifyId
    }

    /* loaded from: classes.dex */
    public enum f {
        dataKey,
        dataSensitive,
        canUpload,
        timeInterval,
        dataValue,
        lastUpdateStamp,
        bindCanUpload
    }

    /* loaded from: classes.dex */
    public enum g {
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

    /* loaded from: classes.dex */
    public enum h {
        verifId,
        msgId,
        md5Infos,
        appId,
        time
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:37:0x0109
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static synchronized long a(android.content.Context r17, com.baidu.android.pushservice.c.b r18) {
        /*
            r0 = r17
            r1 = r18
            java.lang.Class<com.baidu.android.pushservice.c.c> r2 = com.baidu.android.pushservice.c.c.class
            monitor-enter(r2)
            java.lang.Object r3 = com.baidu.android.pushservice.c.c.f2880b     // Catch: java.lang.Throwable -> L12f
            monitor-enter(r3)     // Catch: java.lang.Throwable -> L12f
            android.database.sqlite.SQLiteDatabase r12 = a(r17)     // Catch: java.lang.Throwable -> L12c
            r13 = -1
            if (r12 != 0) goto L15
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12c
            monitor-exit(r2)
            return r13
        L15:
            android.content.ContentValues r15 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L12c
            r15.<init>()     // Catch: java.lang.Throwable -> L12c
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.PushPriority     // Catch: java.lang.Throwable -> L12c
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L12c
            long r5 = r1.f2870a     // Catch: java.lang.Throwable -> L12c
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L12c
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L12c
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.PushVersion     // Catch: java.lang.Throwable -> L12c
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L12c
            long r5 = r1.f2871b     // Catch: java.lang.Throwable -> L12c
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L12c
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L12c
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.PushChannelID     // Catch: java.lang.Throwable -> L12c
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L12c
            java.lang.String r5 = r1.f2872c     // Catch: java.lang.Throwable -> L12c
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L12c
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.PushNewChannelID     // Catch: java.lang.Throwable -> L12c
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L12c
            java.lang.String r5 = r1.f2873d     // Catch: java.lang.Throwable -> L12c
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L12c
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.PushCurPkgName     // Catch: java.lang.Throwable -> L12c
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L12c
            java.lang.String r5 = r1.f2874e     // Catch: java.lang.Throwable -> L12c
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L12c
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.PushLightAppBindInfo     // Catch: java.lang.Throwable -> L12c
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L12c
            java.lang.String r5 = r1.f2876g     // Catch: java.lang.Throwable -> L12c
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L12c
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.PushWebAppBindInfo     // Catch: java.lang.Throwable -> L12c
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L12c
            java.lang.String r5 = r1.f2875f     // Catch: java.lang.Throwable -> L12c
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L12c
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.PushSDKClientBindInfo     // Catch: java.lang.Throwable -> L12c
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L12c
            java.lang.String r5 = r1.f2877h     // Catch: java.lang.Throwable -> L12c
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L12c
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.PushClientsBindInfo     // Catch: java.lang.Throwable -> L12c
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L12c
            java.lang.String r5 = r1.f2878i     // Catch: java.lang.Throwable -> L12c
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L12c
            com.baidu.android.pushservice.c.c$g r4 = com.baidu.android.pushservice.c.c.g.PushSelfBindInfo     // Catch: java.lang.Throwable -> L12c
            java.lang.String r4 = r4.name()     // Catch: java.lang.Throwable -> L12c
            java.lang.String r5 = r1.j     // Catch: java.lang.Throwable -> L12c
            r15.put(r4, r5)     // Catch: java.lang.Throwable -> L12c
            r11 = 0
            java.lang.String r5 = "PushShareInfo"
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r16 = 0
            r4 = r12
            r13 = r11
            r11 = r16
            android.database.Cursor r11 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L104 java.lang.Exception -> L107
            if (r11 == 0) goto Lce
            int r4 = r11.getCount()     // Catch: java.lang.Throwable -> L102 java.lang.Exception -> L11b
            if (r4 == 0) goto Lce
            java.lang.String r4 = "PushShareInfo"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L102 java.lang.Exception -> L11b
            r5.<init>()     // Catch: java.lang.Throwable -> L102 java.lang.Exception -> L11b
            com.baidu.android.pushservice.c.c$g r6 = com.baidu.android.pushservice.c.c.g.PushInfoId     // Catch: java.lang.Throwable -> L102 java.lang.Exception -> L11b
            java.lang.String r6 = r6.name()     // Catch: java.lang.Throwable -> L102 java.lang.Exception -> L11b
            r5.append(r6)     // Catch: java.lang.Throwable -> L102 java.lang.Exception -> L11b
            java.lang.String r6 = "=1"
            r5.append(r6)     // Catch: java.lang.Throwable -> L102 java.lang.Exception -> L11b
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L102 java.lang.Exception -> L11b
            int r4 = r12.update(r4, r15, r5, r13)     // Catch: java.lang.Throwable -> L102 java.lang.Exception -> L11b
            long r13 = (long) r4
            java.lang.String r4 = "pushadvertiseinfo:  update into database"
        Lca:
            com.baidu.android.pushservice.j.m.a(r4, r0)     // Catch: java.lang.Throwable -> L102 java.lang.Exception -> L11d
            goto Ld7
        Lce:
            java.lang.String r4 = "PushShareInfo"
            long r13 = r12.insert(r4, r13, r15)     // Catch: java.lang.Throwable -> L102 java.lang.Exception -> L11b
            java.lang.String r4 = "pushadvertiseinfo:  insert into database"
            goto Lca
        Ld7:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L102 java.lang.Exception -> L11d
            r4.<init>()     // Catch: java.lang.Throwable -> L102 java.lang.Exception -> L11d
            java.lang.String r5 = "updatePushInfo pushinfo:  insert into database,  clientinfo = "
            r4.append(r5)     // Catch: java.lang.Throwable -> L102 java.lang.Exception -> L11d
            org.json.JSONObject r1 = r18.a()     // Catch: java.lang.Throwable -> L102 java.lang.Exception -> L11d
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L102 java.lang.Exception -> L11d
            r4.append(r1)     // Catch: java.lang.Throwable -> L102 java.lang.Exception -> L11d
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L102 java.lang.Exception -> L11d
            com.baidu.android.pushservice.j.m.a(r1, r0)     // Catch: java.lang.Throwable -> L102 java.lang.Exception -> L11d
            if (r11 == 0) goto Lfe
            boolean r0 = r11.isClosed()     // Catch: java.lang.Throwable -> L12c
            if (r0 != 0) goto Lfe
            r11.close()     // Catch: java.lang.Throwable -> L12c
        Lfe:
            r12.close()     // Catch: java.lang.Throwable -> L12c
            goto L129
        L102:
            r0 = move-exception
            goto L10b
        L104:
            r0 = move-exception
            r11 = r13
            goto L10b
        L107:
            r11 = r13
            goto L11b
        L109:
            r0 = move-exception
            r13 = r11
        L10b:
            if (r11 == 0) goto L116
            boolean r1 = r11.isClosed()     // Catch: java.lang.Throwable -> L12c
            if (r1 != 0) goto L116
            r11.close()     // Catch: java.lang.Throwable -> L12c
        L116:
            r12.close()     // Catch: java.lang.Throwable -> L12c
            throw r0     // Catch: java.lang.Throwable -> L12c
        L11a:
            r13 = r11
        L11b:
            r13 = -1
        L11d:
            if (r11 == 0) goto Lfe
            boolean r0 = r11.isClosed()     // Catch: java.lang.Throwable -> L12c
            if (r0 != 0) goto Lfe
            r11.close()     // Catch: java.lang.Throwable -> L12c
            goto Lfe
        L129:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12c
            monitor-exit(r2)
            return r13
        L12c:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12c
            throw r0     // Catch: java.lang.Throwable -> L12f
        L12f:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.c.c.a(android.content.Context, com.baidu.android.pushservice.c.b):long");
    }

    public static SQLiteDatabase a(Context context) {
        d h2 = h(context);
        if (h2 == null) {
            return null;
        }
        try {
            return h2.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object a() {
        return f2880b;
    }

    public static String a(Context context, boolean z) {
        Cursor cursor;
        synchronized (f2880b) {
            SQLiteDatabase a2 = a(context);
            Cursor cursor2 = null;
            r9 = null;
            r9 = null;
            r9 = null;
            String str = null;
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query("PushShareInfo", new String[]{g.PushChannelID.name(), g.PushNewChannelID.name()}, null, null, null, null, null);
                try {
                    if (cursor.moveToFirst()) {
                        str = cursor.getString(cursor.getColumnIndex((z ? g.PushNewChannelID : g.PushChannelID).name()));
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    return str;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    a2.close();
                    throw th;
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            a2.close();
            return str;
        }
    }

    public static synchronized void a(Context context, long j) {
        Cursor query;
        synchronized (c.class) {
            synchronized (f2880b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                Cursor cursor = null;
                try {
                    query = a2.query("PushShareInfo", null, null, null, null, null, null);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                }
                if (query != null) {
                    try {
                    } catch (Exception unused2) {
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        throw th;
                    }
                    if (query.getCount() != 0) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(g.PushPriority.name(), Long.valueOf(j));
                        a2.update("PushShareInfo", contentValues, g.PushInfoId.name() + "=1", null);
                        if (query != null && !query.isClosed()) {
                            query.close();
                        }
                        a2.close();
                    }
                }
                com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                bVar.f2870a = j;
                bVar.f2871b = 0L;
                bVar.f2872c = null;
                bVar.f2873d = null;
                bVar.f2874e = null;
                bVar.f2876g = null;
                bVar.f2875f = null;
                bVar.f2877h = null;
                bVar.f2878i = null;
                bVar.j = null;
                a(context, bVar);
                if (query != null) {
                    query.close();
                }
                a2.close();
            }
        }
    }

    public static synchronized void a(Context context, String str) {
        Cursor query;
        synchronized (c.class) {
            synchronized (f2880b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                Cursor cursor = null;
                try {
                    query = a2.query("PushShareInfo", null, null, null, null, null, null);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                }
                if (query != null) {
                    try {
                    } catch (Exception unused2) {
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        throw th;
                    }
                    if (query.getCount() != 0) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(g.PushChannelToken.name(), str);
                        a2.update("PushShareInfo", contentValues, g.PushInfoId.name() + "=1", null);
                        if (query != null && !query.isClosed()) {
                            query.close();
                        }
                        a2.close();
                    }
                }
                com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                bVar.f2870a = 0L;
                bVar.f2871b = 0L;
                bVar.f2872c = null;
                bVar.f2873d = null;
                bVar.f2874e = null;
                bVar.f2876g = null;
                bVar.f2875f = null;
                bVar.f2877h = null;
                bVar.f2878i = null;
                bVar.j = null;
                a(context, bVar);
                if (query != null) {
                    query.close();
                }
                a2.close();
            }
        }
    }

    public static void a(Context context, String str, int i2, long j) {
        synchronized (f2880b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(f.dataKey.name(), str);
                contentValues.put(f.dataSensitive.name(), Integer.valueOf(i2));
                contentValues.put(f.timeInterval.name(), Long.valueOf(j));
                contentValues.put(f.canUpload.name(), (Integer) 1);
                if (a2.update("PushDataInfo", contentValues, f.dataKey.name() + " =? ", new String[]{String.valueOf(str)}) == 0) {
                    a2.insertWithOnConflict("PushDataInfo", null, contentValues, 5);
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                a2.close();
                throw th;
            }
            a2.close();
        }
    }

    public static void a(Context context, String str, int i2, long j, byte[] bArr, byte[] bArr2, long j2, int i3, int i4) {
        synchronized (f2880b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(e.appId.name(), str);
                contentValues.put(e.msgId.name(), Long.valueOf(j));
                contentValues.put(e.msgType.name(), Integer.valueOf(i2));
                if (bArr != null && bArr.length > 0) {
                    contentValues.put(e.msgBody.name(), BaiduAppSSOJni.a(context, str, bArr));
                    contentValues.put(e.secureInfo.name(), bArr2);
                    contentValues.put(e.expireTime.name(), Long.valueOf(j2));
                }
                contentValues.put(e.arriveTime.name(), Long.valueOf(System.currentTimeMillis()));
                contentValues.put(e.ackRet.name(), Integer.valueOf(i3));
                contentValues.put(e.notifyId.name(), Integer.valueOf(i4));
                a2.insert("PushMsgInfos", null, contentValues);
            } catch (Exception unused) {
            } catch (Throwable th) {
                a2.close();
                throw th;
            }
            a2.close();
        }
    }

    public static synchronized void a(Context context, String str, String str2) {
        Cursor query;
        synchronized (c.class) {
            synchronized (f2880b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                Cursor cursor = null;
                try {
                    query = a2.query("PushShareInfo", null, null, null, null, null, null);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                }
                if (query != null) {
                    try {
                    } catch (Exception unused2) {
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        throw th;
                    }
                    if (query.getCount() != 0) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(g.PushChannelID.name(), str);
                        if (!TextUtils.isEmpty(str2)) {
                            contentValues.put(g.PushNewChannelID.name(), str2);
                        }
                        a2.update("PushShareInfo", contentValues, g.PushInfoId.name() + "=1", null);
                        if (query != null && !query.isClosed()) {
                            query.close();
                        }
                        a2.close();
                    }
                }
                com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                bVar.f2870a = 0L;
                bVar.f2871b = 0L;
                bVar.f2872c = str;
                bVar.f2873d = str2;
                bVar.f2874e = null;
                bVar.f2876g = null;
                bVar.f2875f = null;
                bVar.f2877h = null;
                bVar.f2878i = null;
                bVar.j = null;
                a(context, bVar);
                if (query != null) {
                    query.close();
                }
                a2.close();
            }
        }
    }

    public static void a(Context context, String str, String str2, Long l) {
        synchronized (f2880b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(f.dataValue.name(), str2);
                if (l != null) {
                    contentValues.put(f.lastUpdateStamp.name(), l);
                }
                a2.update("PushDataInfo", contentValues, f.dataKey.name() + " =? ", new String[]{String.valueOf(str)});
            } catch (Exception unused) {
            }
            a2.close();
        }
    }

    public static void a(Context context, ArrayList<String> arrayList) {
        synchronized (f2880b) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sb.append("'");
                sb.append(arrayList.get(i2));
                sb.append("'");
                if (i2 < arrayList.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return;
            }
            try {
                a2.execSQL("UPDATE PushDataInfo SET " + f.canUpload.name() + "=0 WHERE " + f.dataKey.name() + " NOT IN " + sb.toString());
            } catch (Exception unused) {
            } catch (Throwable th) {
                a2.close();
                throw th;
            }
            a2.close();
        }
    }

    public static void a(Context context, JSONArray jSONArray) {
        synchronized (f2880b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return;
            }
            if (jSONArray != null) {
                try {
                    if (jSONArray.length() > 0) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            ContentValues contentValues = new ContentValues();
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            long j = jSONObject.getLong("event_time");
                            contentValues.put(b.clickData.name(), jSONObject.toString());
                            contentValues.put(b.timeStamps.name(), Long.valueOf(j));
                            a2.insert("ClickMsgUploadInfo", null, contentValues);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            a2.close();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, IF, INVOKE, INVOKE] complete} */
    public static boolean a(Context context, int i2) {
        synchronized (f2880b) {
            SQLiteDatabase a2 = a(context);
            Cursor cursor = null;
            if (a2 == null) {
                return false;
            }
            try {
                cursor = a2.query("PushMsgInfos", new String[]{e.notifyId.name()}, e.notifyId.name() + "=?", new String[]{String.valueOf(i2)}, null, null, null);
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        return true;
                    }
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                a2.close();
                return false;
            } catch (Exception unused) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                a2.close();
                return false;
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                a2.close();
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean a(Context context, com.baidu.android.pushservice.c.f fVar) {
        long j;
        synchronized (c.class) {
            synchronized (f2880b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return false;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(h.msgId.name(), fVar.f2984a);
                contentValues.put(h.md5Infos.name(), fVar.f2985b);
                contentValues.put(h.appId.name(), fVar.f2986c);
                contentValues.put(h.time.name(), System.currentTimeMillis() + "");
                Cursor cursor = null;
                try {
                    j = a2.insert("PushVerifInfo", null, contentValues);
                    try {
                        cursor = a2.rawQuery("SELECT COUNT(*) FROM PushVerifInfo;", null);
                        if (cursor.moveToFirst() && cursor.getInt(0) > 200) {
                            a2.delete("PushVerifInfo", " msgId IS NOT ?", new String[]{fVar.f2984a});
                        }
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                    } catch (Exception unused) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        if (j != -1) {
                        }
                        return r2;
                    }
                } catch (Exception unused2) {
                    j = -1;
                }
                a2.close();
                boolean z = j != -1;
                return z;
            }
        }
    }

    public static int b(Context context) {
        synchronized (f2880b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return 0;
            }
            Cursor cursor = null;
            try {
                cursor = a2.query("PushShareInfo", new String[]{g.PushVersion.name()}, null, null, null, null, null);
                r9 = cursor.moveToFirst() ? cursor.getInt(cursor.getColumnIndex(g.PushVersion.name())) : 0;
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Exception unused) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            }
            a2.close();
            return r9;
        }
    }

    public static String b(Context context, String str, String str2) {
        Cursor cursor;
        String str3;
        ContentResolver contentResolver;
        Cursor cursor2 = null;
        try {
            if (m.g(context, str) < 52 || (contentResolver = context.getContentResolver()) == null) {
                str3 = null;
            } else {
                Uri parse = Uri.parse("content://" + str + ".bdpush/verif");
                String[] strArr = {h.md5Infos.name()};
                StringBuilder sb = new StringBuilder();
                sb.append(h.msgId.name());
                sb.append("=?");
                cursor = contentResolver.query(parse, strArr, sb.toString(), new String[]{str2}, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            str3 = cursor.getString(0);
                            cursor2 = cursor;
                        }
                    } catch (Throwable unused) {
                        if (cursor != null) {
                            try {
                                cursor.close();
                                return null;
                            } catch (Exception unused2) {
                                return null;
                            }
                        }
                        return null;
                    }
                }
                str3 = null;
                cursor2 = cursor;
            }
            if (cursor2 != null) {
                try {
                    cursor2.close();
                } catch (Exception unused3) {
                }
            }
            return str3;
        } catch (Throwable unused4) {
            cursor = null;
        }
    }

    public static synchronized void b(Context context, long j) {
        Cursor query;
        synchronized (c.class) {
            synchronized (f2880b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null) {
                    return;
                }
                Cursor cursor = null;
                try {
                    query = a2.query("PushShareInfo", null, null, null, null, null, null);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                }
                if (query != null) {
                    try {
                    } catch (Exception unused2) {
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        throw th;
                    }
                    if (query.getCount() != 0) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(g.PushVersion.name(), Long.valueOf(j));
                        a2.update("PushShareInfo", contentValues, g.PushInfoId.name() + "=1", null);
                        if (query != null && !query.isClosed()) {
                            query.close();
                        }
                        a2.close();
                    }
                }
                com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                bVar.f2870a = 0L;
                bVar.f2871b = j;
                bVar.f2872c = null;
                bVar.f2873d = null;
                bVar.f2874e = null;
                bVar.f2876g = null;
                bVar.f2875f = null;
                bVar.f2877h = null;
                bVar.f2878i = null;
                bVar.j = null;
                a(context, bVar);
                if (query != null) {
                    query.close();
                }
                a2.close();
            }
        }
    }

    public static synchronized void b(Context context, String str) {
        Cursor query;
        synchronized (c.class) {
            synchronized (f2880b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null || str == null) {
                    return;
                }
                Cursor cursor = null;
                try {
                    query = a2.query("PushShareInfo", null, null, null, null, null, null);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                }
                if (query != null) {
                    try {
                    } catch (Exception unused2) {
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        throw th;
                    }
                    if (query.getCount() != 0) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(g.PushClientsBindInfo.name(), str);
                        a2.update("PushShareInfo", contentValues, g.PushInfoId.name() + "=1", null);
                        if (query != null && !query.isClosed()) {
                            query.close();
                        }
                        a2.close();
                    }
                }
                com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                bVar.f2870a = 0L;
                bVar.f2871b = 0L;
                bVar.f2872c = null;
                bVar.f2873d = null;
                bVar.f2874e = null;
                bVar.f2876g = null;
                bVar.f2875f = null;
                bVar.f2877h = null;
                bVar.f2878i = str;
                bVar.j = null;
                a(context, bVar);
                if (query != null) {
                    query.close();
                }
                a2.close();
            }
        }
    }

    public static void b(Context context, JSONArray jSONArray) {
        String obj;
        synchronized (f2880b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                sb.append("'");
                try {
                    obj = jSONArray.get(i2).toString();
                } catch (JSONException unused) {
                }
                sb.append(obj);
                sb.append("'");
                if (i2 < jSONArray.length() - 1) {
                    sb.append(",");
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(f.bindCanUpload.name(), (Integer) 0);
                a2.update("PushDataInfo", contentValues, null, null);
                a2.execSQL("UPDATE PushDataInfo SET " + f.bindCanUpload.name() + "=1 WHERE " + f.dataKey.name() + " IN " + sb.toString());
            } catch (Exception unused2) {
            } catch (Throwable th) {
                a2.close();
                throw th;
            }
            a2.close();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, IF, INVOKE, INVOKE] complete} */
    public static boolean b(Context context, int i2) {
        synchronized (f2880b) {
            SQLiteDatabase a2 = a(context);
            Cursor cursor = null;
            if (a2 == null) {
                return false;
            }
            int i3 = -1;
            try {
                cursor = a2.query("PushMsgInfos", null, e.notifyId.name() + "=?", new String[]{String.valueOf(i2)}, null, null, null);
                if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                    i3 = cursor.getInt(cursor.getColumnIndex(e.msgType.name()));
                }
                if (i3 != l.MSG_TYPE_PRIVATE_MESSAGE.b() && i3 != l.MSG_TYPE_MULTI_PRIVATE.b() && i3 != l.MSG_TYPE_SINGLE_PRIVATE.b()) {
                    if (i3 != l.MSG_TYPE_APP_PRIORITY.b()) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        return false;
                    }
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                a2.close();
                return true;
            } catch (Exception unused) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                a2.close();
                return false;
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                a2.close();
                throw th;
            }
        }
    }

    public static String c(Context context) {
        Cursor cursor;
        synchronized (f2880b) {
            SQLiteDatabase a2 = a(context);
            Cursor cursor2 = null;
            r9 = null;
            r9 = null;
            String str = null;
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query("PushShareInfo", new String[]{g.PushChannelToken.name()}, null, null, null, null, null);
                try {
                    str = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(g.PushChannelToken.name())) : null;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    return str;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    a2.close();
                    throw th;
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            a2.close();
            return str;
        }
    }

    public static String c(Context context, String str, String str2) {
        Cursor cursor;
        String str3;
        ContentResolver contentResolver;
        Cursor cursor2 = null;
        try {
            if (m.g(context, str) < 52 || (contentResolver = context.getContentResolver()) == null) {
                str3 = null;
            } else {
                Uri parse = Uri.parse("content://" + str + ".bdpush/verif");
                String[] strArr = {h.md5Infos.name()};
                StringBuilder sb = new StringBuilder();
                sb.append(h.md5Infos.name());
                sb.append("=?");
                cursor = contentResolver.query(parse, strArr, sb.toString(), new String[]{str2}, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            str3 = cursor.getString(0);
                            cursor2 = cursor;
                        }
                    } catch (Throwable unused) {
                        if (cursor != null) {
                            try {
                                cursor.close();
                                return null;
                            } catch (Exception unused2) {
                                return null;
                            }
                        }
                        return null;
                    }
                }
                str3 = null;
                cursor2 = cursor;
            }
            if (cursor2 != null) {
                try {
                    cursor2.close();
                } catch (Exception unused3) {
                }
            }
            return str3;
        } catch (Throwable unused4) {
            cursor = null;
        }
    }

    public static synchronized void c(Context context, String str) {
        Cursor query;
        synchronized (c.class) {
            synchronized (f2880b) {
                SQLiteDatabase a2 = a(context);
                if (a2 == null || str == null) {
                    return;
                }
                Cursor cursor = null;
                try {
                    query = a2.query("PushShareInfo", null, null, null, null, null, null);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                }
                if (query != null) {
                    try {
                    } catch (Exception unused2) {
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        throw th;
                    }
                    if (query.getCount() != 0) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(g.PushSelfBindInfo.name(), str);
                        a2.update("PushShareInfo", contentValues, g.PushInfoId.name() + "=1", null);
                        if (query != null && !query.isClosed()) {
                            query.close();
                        }
                        a2.close();
                    }
                }
                com.baidu.android.pushservice.c.b bVar = new com.baidu.android.pushservice.c.b();
                bVar.f2870a = 0L;
                bVar.f2871b = 0L;
                bVar.f2872c = null;
                bVar.f2873d = null;
                bVar.f2874e = null;
                bVar.f2876g = null;
                bVar.f2875f = null;
                bVar.f2877h = null;
                bVar.f2878i = null;
                bVar.j = str;
                a(context, bVar);
                if (query != null) {
                    query.close();
                }
                a2.close();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, IF, INVOKE, INVOKE] complete} */
    public static boolean c(Context context, long j) {
        synchronized (f2880b) {
            SQLiteDatabase a2 = a(context);
            Cursor cursor = null;
            if (a2 == null) {
                return false;
            }
            try {
                cursor = a2.query("PushMsgInfos", new String[]{e.msgId.name()}, e.msgId.name() + " =? ", new String[]{String.valueOf(j)}, null, null, null);
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        return true;
                    }
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                a2.close();
                return false;
            } catch (Exception unused) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                a2.close();
                return false;
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                a2.close();
                throw th;
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0074: MOVE  (r10 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:32:0x0074 */
    public static String d(Context context) {
        Cursor cursor;
        Cursor cursor2;
        synchronized (f2880b) {
            SQLiteDatabase a2 = a(context);
            Cursor cursor3 = null;
            r10 = null;
            r10 = null;
            String str = null;
            try {
                if (a2 == null) {
                    return null;
                }
                try {
                    cursor2 = a2.query("PushShareInfo", new String[]{g.PushClientsBindInfo.name()}, null, null, null, null, null);
                    try {
                        str = cursor2.moveToFirst() ? cursor2.getString(cursor2.getColumnIndex(g.PushClientsBindInfo.name())) : null;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        m.a("PushInfoDataBase*BBind*" + com.baidu.android.pushservice.g.a.a(e), context);
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        a2.close();
                        return str;
                    }
                } catch (Exception e3) {
                    e = e3;
                    cursor2 = null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor3 != null && !cursor3.isClosed()) {
                        cursor3.close();
                    }
                    a2.close();
                    throw th;
                }
                a2.close();
                return str;
            } catch (Throwable th2) {
                th = th2;
                cursor3 = cursor;
            }
        }
    }

    public static String d(Context context, String str) {
        Cursor cursor;
        synchronized (f2880b) {
            SQLiteDatabase a2 = a(context);
            Cursor cursor2 = null;
            r9 = null;
            r9 = null;
            r9 = null;
            r9 = null;
            r9 = null;
            String str2 = null;
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query("PushDataInfo", null, f.dataKey.name() + " =? ", new String[]{String.valueOf(str)}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst() && cursor.getInt(cursor.getColumnIndex(f.bindCanUpload.name())) == 1) {
                            str2 = cursor.getString(cursor.getColumnIndex(f.dataValue.name()));
                        }
                    } catch (Exception unused) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        return str2;
                    } catch (Throwable th) {
                        th = th;
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
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            a2.close();
            return str2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e4, code lost:
        if (r10.isClosed() != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e6, code lost:
        r10.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d(Context context, String str, String str2) {
        synchronized (f2880b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return false;
            }
            Cursor cursor = null;
            try {
                cursor = a2.query("PushDataInfo", null, f.dataKey.name() + " =? ", new String[]{String.valueOf(str)}, null, null, null);
            } catch (Exception unused) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                a2.close();
                throw th;
            }
            if (cursor != null && cursor.moveToFirst()) {
                int i2 = cursor.getInt(cursor.getColumnIndex(f.dataSensitive.name()));
                String string = cursor.getString(cursor.getColumnIndex(f.dataValue.name()));
                if (cursor.getInt(cursor.getColumnIndex(f.canUpload.name())) != 1) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    return false;
                } else if (i2 == 1 && str2.equals(string)) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    return false;
                } else if (System.currentTimeMillis() - cursor.getLong(cursor.getColumnIndex(f.lastUpdateStamp.name())) > cursor.getLong(cursor.getColumnIndex(f.timeInterval.name())) * 1000) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    return true;
                } else {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    return false;
                }
            }
            a2.close();
            return false;
        }
    }

    public static String e(Context context) {
        Cursor cursor;
        synchronized (f2880b) {
            SQLiteDatabase a2 = a(context);
            Cursor cursor2 = null;
            r9 = null;
            r9 = null;
            String str = null;
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query("PushShareInfo", new String[]{g.PushSelfBindInfo.name()}, null, null, null, null, null);
                try {
                    str = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(g.PushSelfBindInfo.name())) : null;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    return str;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    a2.close();
                    throw th;
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            a2.close();
            return str;
        }
    }

    public static String e(Context context, String str) {
        Cursor cursor;
        synchronized (f2880b) {
            SQLiteDatabase a2 = a(context);
            Cursor cursor2 = null;
            r9 = null;
            r9 = null;
            r9 = null;
            r9 = null;
            String str2 = null;
            if (a2 == null) {
                return null;
            }
            try {
                cursor = a2.query("PushDataInfo", null, f.dataKey.name() + " =? ", new String[]{str}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            str2 = cursor.getString(cursor.getColumnIndex(f.dataValue.name()));
                        }
                    } catch (Exception unused) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        a2.close();
                        return str2;
                    } catch (Throwable th) {
                        th = th;
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
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            a2.close();
            return str2;
        }
    }

    public static JSONArray f(Context context) {
        int b2;
        long j;
        JSONArray jSONArray = new JSONArray();
        synchronized (f2880b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return jSONArray;
            }
            Cursor cursor = null;
            try {
                b2 = i.b(context, "click_data_size", 10) - 1;
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            if (b2 <= 0) {
                a2.close();
                return jSONArray;
            }
            Cursor query = a2.query(false, "ClickMsgUploadInfo", null, null, null, null, null, b.timeStamps.name() + " DESC ", String.valueOf(b2));
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        do {
                            String string = query.getString(query.getColumnIndex(b.clickData.name()));
                            j = query.getLong(query.getColumnIndex(b.timeStamps.name()));
                            jSONArray.put(new JSONObject(string));
                        } while (query.moveToNext());
                        if (a2.delete("ClickMsgUploadInfo", b.timeStamps.name() + " >= " + String.valueOf(j), null) == 0) {
                            jSONArray = new JSONArray();
                        }
                    }
                } catch (Exception unused2) {
                    cursor = query;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    return jSONArray;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    a2.close();
                    throw th;
                }
            }
            if (query != null && !query.isClosed()) {
                query.close();
            }
            a2.close();
            return jSONArray;
        }
    }

    public static void g(Context context) {
        synchronized (f2880b) {
            SQLiteDatabase a2 = a(context);
            if (a2 == null) {
                return;
            }
            try {
                a2.delete("ClickMsgUploadInfo", null, null);
            } catch (Exception unused) {
            } catch (Throwable th) {
                a2.close();
                throw th;
            }
            a2.close();
        }
    }

    public static d h(Context context) {
        if (f2879a == null) {
            synchronized (f2880b) {
                if (f2879a == null) {
                    File file = new File(Environment.getDataDirectory().getAbsolutePath() + "/data" + File.separator + context.getPackageName() + "/database");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String str = file.getAbsolutePath() + File.separator + "pushinfo.db";
                    SQLiteDatabase sQLiteDatabase = null;
                    if (Build.VERSION.SDK_INT >= 11) {
                        f2879a = new d(context, str, 8, new C0032c());
                    } else {
                        f2879a = new d(context, str, (SQLiteDatabase.CursorFactory) null, 8);
                    }
                    try {
                        SQLiteDatabase writableDatabase = f2879a.getWritableDatabase();
                        try {
                            writableDatabase.delete("PushMsgInfos", e.arriveTime.name() + " < " + (System.currentTimeMillis() - 259200000), null);
                            if (writableDatabase != null) {
                                writableDatabase.close();
                            }
                        } catch (Throwable unused) {
                            sQLiteDatabase = writableDatabase;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            return f2879a;
                        }
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
        return f2879a;
    }
}
