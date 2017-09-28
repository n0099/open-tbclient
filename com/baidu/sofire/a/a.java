package com.baidu.sofire.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.sofire.b;
import com.baidu.sofire.b.d;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class a {
    public static a PJ;
    private C0037a PH;
    public SQLiteDatabase PI;
    int a = 4;
    String b = "create table pgn(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,la INTEGER,o INTEGER,r INTEGER,ap INTEGER,apk TEXT,cl TEXT,b TEXT,t TEXT,ac BLOB,st INTEGER,du INTEGER,th INTEGER,m5 TEXT,rs INTEGER,l TEXT,pr INTEGER DEFAULT -1,a TEXT)";
    private Context f;

    private a(Context context) {
        b.a();
        this.f = context.getApplicationContext();
        this.PH = new C0037a(context.getApplicationContext());
        try {
            this.PI = this.PH.getWritableDatabase();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static synchronized a ao(Context context) {
        a aVar;
        synchronized (a.class) {
            String str = "i=" + PJ;
            b.a();
            if (PJ == null) {
                PJ = new a(context);
            }
            aVar = PJ;
        }
        return aVar;
    }

    /* renamed from: com.baidu.sofire.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0037a extends SQLiteOpenHelper {
        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0010: IGET  (r1v1 int A[REMOVE]) = (r4v0 com.baidu.sofire.a.a) com.baidu.sofire.a.a.a int)] */
        public C0037a(Context context) {
            super(context, "tpgcc.db", (SQLiteDatabase.CursorFactory) null, a.this.a);
            new StringBuilder().append(a.this.a).toString();
            b.a();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(a.this.b);
            } catch (Throwable th) {
                d.a(th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                String str = "o=" + i + ", n=" + i2;
                b.a();
                if (i < 3 && i2 >= 3) {
                    sQLiteDatabase.beginTransaction();
                    sQLiteDatabase.execSQL("ALTER TABLE pgn ADD COLUMN pr INTEGER  DEFAULT -1");
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                }
                if (i < 4 && i2 >= 4) {
                    sQLiteDatabase.execSQL("drop table if exists tbch");
                }
            } catch (Throwable th) {
                d.a(th);
            }
        }
    }

    public final long a(ApkInfo apkInfo) {
        long j = 0;
        if (apkInfo != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", Integer.valueOf(apkInfo.initStatus));
            contentValues.put("p", apkInfo.packageName);
            contentValues.put("a", apkInfo.pkgPath);
            contentValues.put("l", apkInfo.libPath);
            contentValues.put("v", apkInfo.versionName);
            contentValues.put("apk", apkInfo.dexPath);
            contentValues.put("ap", Integer.valueOf(apkInfo.apkParseSuc));
            contentValues.put("cl", apkInfo.className);
            contentValues.put("st", Long.valueOf(apkInfo.startTime));
            contentValues.put("du", Integer.valueOf(apkInfo.duration));
            contentValues.put("m5", apkInfo.apkMD5);
            contentValues.put("rs", Integer.valueOf(apkInfo.runStatus));
            contentValues.put("th", Integer.valueOf(apkInfo.applicationTheme));
            contentValues.put("pr", Integer.valueOf(apkInfo.priority));
            if (apkInfo.activities != null) {
                contentValues.put("ac", new com.baidu.sofire.core.a(apkInfo.activities).a());
            }
            try {
                if (b(apkInfo.key)) {
                    j = this.PI.update("pgn", contentValues, "k=" + apkInfo.key, null);
                } else {
                    contentValues.put("k", Integer.valueOf(apkInfo.key));
                    j = this.PI.insert("pgn", null, contentValues);
                }
            } catch (Throwable th) {
            }
        }
        return j;
    }

    public final List<ApkInfo> a() {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = this.PI.query("pgn", null, null, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        ApkInfo apkInfo = new ApkInfo();
                        apkInfo.key = cursor.getInt(cursor.getColumnIndex("k"));
                        apkInfo.packageName = cursor.getString(cursor.getColumnIndex("p"));
                        apkInfo.pkgPath = cursor.getString(cursor.getColumnIndex("a"));
                        apkInfo.libPath = cursor.getString(cursor.getColumnIndex("l"));
                        apkInfo.versionName = cursor.getString(cursor.getColumnIndex("v"));
                        apkInfo.startTime = cursor.getLong(cursor.getColumnIndex("st"));
                        apkInfo.duration = cursor.getInt(cursor.getColumnIndex("du"));
                        apkInfo.runStatus = cursor.getInt(cursor.getColumnIndex("rs"));
                        apkInfo.priority = cursor.getInt(cursor.getColumnIndex("pr"));
                        arrayList.add(apkInfo);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            d.a(th);
                            return arrayList;
                        } finally {
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable th2) {
                                    d.a(th2);
                                }
                            }
                        }
                    }
                }
            }
            if (cursor != null) {
                try {
                    if (!cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Throwable th3) {
                    d.a(th3);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
        return arrayList;
    }

    public final Map<Integer, String> nn() {
        Cursor cursor;
        HashMap hashMap = new HashMap();
        try {
            cursor = this.PI.query("pgn", null, "n=1", null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        hashMap.put(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("k"))), "'" + cursor.getString(cursor.getColumnIndex("v")) + "'");
                    } catch (Throwable th) {
                        th = th;
                        try {
                            d.a(th);
                            return hashMap;
                        } finally {
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable th2) {
                                    d.a(th2);
                                }
                            }
                        }
                    }
                }
            }
            if (cursor != null) {
                try {
                    if (!cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Throwable th3) {
                    d.a(th3);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
        return hashMap;
    }

    public final Map<Integer, String> no() {
        Cursor cursor;
        HashMap hashMap = new HashMap();
        try {
            cursor = this.PI.query("pgn", null, "n=1", null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        hashMap.put(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("k"))), cursor.getString(cursor.getColumnIndex("p")));
                    } catch (Throwable th) {
                        th = th;
                        try {
                            d.a(th);
                            return hashMap;
                        } finally {
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable th2) {
                                    d.a(th2);
                                }
                            }
                        }
                    }
                }
            }
            if (cursor != null) {
                try {
                    if (!cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Throwable th3) {
                    d.a(th3);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
        return hashMap;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final com.baidu.sofire.core.ApkInfo aX(int r11) {
        /*
            r10 = this;
            r8 = 0
            android.database.sqlite.SQLiteDatabase r0 = r10.PI     // Catch: java.lang.Throwable -> L1a7
            java.lang.String r1 = "pgn"
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1a7
            java.lang.String r4 = "k="
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L1a7
            java.lang.StringBuilder r3 = r3.append(r11)     // Catch: java.lang.Throwable -> L1a7
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L1a7
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L1a7
            if (r1 == 0) goto L1e2
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L1d7
            if (r0 == 0) goto L1e2
            com.baidu.sofire.core.ApkInfo r2 = new com.baidu.sofire.core.ApkInfo     // Catch: java.lang.Throwable -> L1d7
            r2.<init>()     // Catch: java.lang.Throwable -> L1d7
            r2.key = r11     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = "n"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1dc
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1dc
            r2.initStatus = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = "p"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1dc
            r2.packageName = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = "a"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1dc
            r2.pkgPath = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = "l"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1dc
            r2.libPath = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = "v"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1dc
            r2.versionName = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = "apk"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1dc
            r2.dexPath = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = "ap"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1dc
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1dc
            r2.apkParseSuc = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = "cl"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1dc
            r2.className = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = "th"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1dc
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1dc
            r2.applicationTheme = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = "st"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1dc
            long r4 = r1.getLong(r0)     // Catch: java.lang.Throwable -> L1dc
            r2.startTime = r4     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = "du"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1dc
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1dc
            r2.duration = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = "rs"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1dc
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1dc
            r2.runStatus = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = "m5"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1dc
            r2.apkMD5 = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = "pr"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1dc
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1dc
            r2.priority = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = "ac"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1dc
            byte[] r0 = r1.getBlob(r0)     // Catch: java.lang.Throwable -> L1dc
            if (r0 == 0) goto L195
            java.util.ArrayList r4 = com.baidu.sofire.core.a.a(r0)     // Catch: java.lang.Throwable -> L1dc
            if (r4 == 0) goto L195
            int r5 = r4.size()     // Catch: java.lang.Throwable -> L1dc
            if (r5 <= 0) goto L195
            android.content.pm.ActivityInfo[] r0 = new android.content.pm.ActivityInfo[r5]     // Catch: java.lang.Throwable -> L1dc
            r2.activities = r0     // Catch: java.lang.Throwable -> L1dc
            r0 = 0
            r3 = r0
        L103:
            if (r3 >= r5) goto L195
            android.content.pm.ActivityInfo r6 = new android.content.pm.ActivityInfo     // Catch: java.lang.Throwable -> L1dc
            r6.<init>()     // Catch: java.lang.Throwable -> L1dc
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1dc
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1dc
            int r0 = r0.a     // Catch: java.lang.Throwable -> L1dc
            r6.theme = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1dc
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = r0.j     // Catch: java.lang.Throwable -> L1dc
            r6.name = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1dc
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1dc
            int r0 = r0.h     // Catch: java.lang.Throwable -> L1dc
            r6.configChanges = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1dc
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1dc
            int r0 = r0.f     // Catch: java.lang.Throwable -> L1dc
            r6.flags = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1dc
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1dc
            int r0 = r0.l     // Catch: java.lang.Throwable -> L1dc
            r6.labelRes = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1dc
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1dc
            int r0 = r0.b     // Catch: java.lang.Throwable -> L1dc
            r6.launchMode = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1dc
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = r0.m     // Catch: java.lang.Throwable -> L1dc
            r6.nonLocalizedLabel = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1dc
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = r0.k     // Catch: java.lang.Throwable -> L1dc
            r6.packageName = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1dc
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = r0.c     // Catch: java.lang.Throwable -> L1dc
            r6.permission = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1dc
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1dc
            int r0 = r0.g     // Catch: java.lang.Throwable -> L1dc
            r6.screenOrientation = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1dc
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1dc
            int r0 = r0.i     // Catch: java.lang.Throwable -> L1dc
            r6.softInputMode = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1dc
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = r0.e     // Catch: java.lang.Throwable -> L1dc
            r6.targetActivity = r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1dc
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1dc
            java.lang.String r0 = r0.d     // Catch: java.lang.Throwable -> L1dc
            r6.taskAffinity = r0     // Catch: java.lang.Throwable -> L1dc
            android.content.pm.ActivityInfo[] r0 = r2.activities     // Catch: java.lang.Throwable -> L1dc
            r0[r3] = r6     // Catch: java.lang.Throwable -> L1dc
            int r0 = r3 + 1
            r3 = r0
            goto L103
        L195:
            r0 = r2
        L196:
            if (r1 == 0) goto L1a1
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> L1a2
            if (r2 != 0) goto L1a1
            r1.close()     // Catch: java.lang.Throwable -> L1a2
        L1a1:
            return r0
        L1a2:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L1a1
        L1a7:
            r0 = move-exception
            r1 = r0
            r2 = r8
            r0 = r8
        L1ab:
            com.baidu.sofire.b.d.a(r1)     // Catch: java.lang.Throwable -> L1d4
            if (r2 == 0) goto L1a1
            boolean r1 = r2.isClosed()     // Catch: java.lang.Throwable -> L1ba
            if (r1 != 0) goto L1a1
            r2.close()     // Catch: java.lang.Throwable -> L1ba
            goto L1a1
        L1ba:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L1a1
        L1bf:
            r0 = move-exception
            r1 = r8
        L1c1:
            if (r1 == 0) goto L1cc
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> L1cd
            if (r2 != 0) goto L1cc
            r1.close()     // Catch: java.lang.Throwable -> L1cd
        L1cc:
            throw r0
        L1cd:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L1cc
        L1d2:
            r0 = move-exception
            goto L1c1
        L1d4:
            r0 = move-exception
            r1 = r2
            goto L1c1
        L1d7:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r8
            goto L1ab
        L1dc:
            r0 = move-exception
            r9 = r0
            r0 = r2
            r2 = r1
            r1 = r9
            goto L1ab
        L1e2:
            r0 = r8
            goto L196
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.a.a.aX(int):com.baidu.sofire.core.ApkInfo");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0034 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(int i) {
        Cursor cursor;
        boolean z;
        try {
            cursor = this.PI.query("pgn", new String[]{"p"}, "k=" + i, null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        z = true;
                        if (cursor == null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                    return z;
                                }
                                return z;
                            } catch (Throwable th) {
                                d.a(th);
                                return z;
                            }
                        }
                        return z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        d.a(th);
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable th3) {
                                d.a(th3);
                                return false;
                            }
                        }
                        return false;
                    } catch (Throwable th4) {
                        Cursor cursor2 = cursor;
                        if (cursor2 != null) {
                            try {
                                if (!cursor2.isClosed()) {
                                    cursor2.close();
                                }
                            } catch (Throwable th5) {
                                d.a(th5);
                            }
                        }
                        throw th4;
                    }
                }
            }
            z = false;
            if (cursor == null) {
            }
        } catch (Throwable th6) {
            th = th6;
            cursor = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int c(int i) {
        Cursor cursor;
        int i2;
        try {
            cursor = this.PI.query("pgn", new String[]{"n"}, "k=" + i, null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        i2 = cursor.getInt(cursor.getColumnIndex("n"));
                        if (cursor == null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                    return i2;
                                }
                                return i2;
                            } catch (Throwable th) {
                                d.a(th);
                                return i2;
                            }
                        }
                        return i2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        d.a(th);
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable th3) {
                                d.a(th3);
                                return 0;
                            }
                        }
                        return 0;
                    } catch (Throwable th4) {
                        Cursor cursor2 = cursor;
                        if (cursor2 != null) {
                            try {
                                if (!cursor2.isClosed()) {
                                    cursor2.close();
                                }
                            } catch (Throwable th5) {
                                d.a(th5);
                            }
                        }
                        throw th4;
                    }
                }
            }
            i2 = 0;
            if (cursor == null) {
            }
        } catch (Throwable th6) {
            th = th6;
            cursor = null;
        }
    }

    public final void a(String str) {
        String str2 = str;
        b.a();
        if (!TextUtils.isEmpty(str)) {
            try {
                this.PI.delete("pgn", "p=?", new String[]{str});
            } catch (Throwable th) {
                d.a(th);
            }
        }
    }

    public final void d() {
        ArrayList<ApkInfo> arrayList = new ArrayList();
        for (ApkInfo apkInfo : a()) {
            if (!d.a(apkInfo.pkgPath) && e.a != null && !e.a.contains(Integer.valueOf(apkInfo.key))) {
                arrayList.add(apkInfo);
            }
        }
        try {
            e nr = e.nr();
            for (ApkInfo apkInfo2 : arrayList) {
                if (nr != null) {
                    nr.b(apkInfo2.packageName);
                }
                String str = apkInfo2.packageName + this.PI.delete("pgn", "k=" + apkInfo2.key, null);
                b.a();
                d.b(this.f.getFilesDir().getCanonicalPath() + "/." + apkInfo2.key);
                if (this.f != null) {
                    d.b(this.f.getFileStreamPath(apkInfo2.packageName).getAbsolutePath());
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final boolean aY(int i) {
        Cursor cursor;
        boolean z = false;
        try {
            Cursor cursor2 = this.PI.query("pgn", new String[]{"u"}, "k=" + i, null, null, null, null);
            if (cursor2 != null) {
                try {
                    if (cursor2.moveToFirst()) {
                        cursor = cursor2.getInt(cursor2.getColumnIndex("u")) == 1;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        d.a(th);
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable th2) {
                                d.a(th2);
                            }
                        }
                        return z;
                    } finally {
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            try {
                                if (!cursor2.isClosed()) {
                                    cursor2.close();
                                }
                            } catch (Throwable th3) {
                                d.a(th3);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
        return z;
    }

    public final boolean aZ(int i) {
        Cursor cursor;
        boolean z = false;
        try {
            Cursor cursor2 = this.PI.query("pgn", new String[]{"s"}, "k=" + i, null, null, null, null);
            if (cursor2 != null) {
                try {
                    if (cursor2.moveToFirst()) {
                        cursor = cursor2.getInt(cursor2.getColumnIndex("s")) == 1;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        d.a(th);
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable th2) {
                                d.a(th2);
                            }
                        }
                        return z;
                    } finally {
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            try {
                                if (!cursor2.isClosed()) {
                                    cursor2.close();
                                }
                            } catch (Throwable th3) {
                                d.a(th3);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
        return z;
    }

    public final int a(int i, int i2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("u", Integer.valueOf(i2));
            return this.PI.update("pgn", contentValues, "k=" + i, null);
        } catch (Throwable th) {
            return 0;
        }
    }

    public final void f(int i) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", (Integer) (-1));
            this.PI.update("pgn", contentValues, "k=" + i, null);
        } catch (Throwable th) {
            d.a(th);
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
    public final java.lang.String[] b(java.lang.String r12) {
        /*
            r11 = this;
            r10 = 0
            r8 = 0
            r9 = 1
            android.database.sqlite.SQLiteDatabase r0 = r11.PI     // Catch: java.lang.Throwable -> L84
            java.lang.String r1 = "pgn"
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L84
            r3 = 0
            java.lang.String r4 = "r"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L84
            r3 = 1
            java.lang.String r4 = "b"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L84
            r3 = 2
            java.lang.String r4 = "t"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L84
            java.lang.String r3 = "p=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L84
            r5 = 0
            r4[r5] = r12     // Catch: java.lang.Throwable -> L84
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L84
            if (r1 == 0) goto Lbe
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> Lb4
            if (r0 == 0) goto Lbe
            java.lang.String r0 = "r"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Lb4
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> Lb4
            if (r0 != r9) goto L7d
            r0 = r9
        L43:
            java.lang.String r2 = "b"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r3 = "t"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> Lb4
            if (r0 == 0) goto Lbe
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lb4
            if (r0 != 0) goto Lbe
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> Lb4
            if (r0 != 0) goto Lbe
            r0 = 2
            java.lang.String[] r8 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> Lb4
            r0 = 0
            r8[r0] = r2     // Catch: java.lang.Throwable -> Lb9
            r0 = 1
            r8[r0] = r3     // Catch: java.lang.Throwable -> Lb9
            r0 = r8
        L71:
            if (r1 == 0) goto L7c
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> L7f
            if (r2 != 0) goto L7c
            r1.close()     // Catch: java.lang.Throwable -> L7f
        L7c:
            return r0
        L7d:
            r0 = r10
            goto L43
        L7f:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L7c
        L84:
            r0 = move-exception
            r1 = r0
            r2 = r8
            r0 = r8
        L88:
            com.baidu.sofire.b.d.a(r1)     // Catch: java.lang.Throwable -> Lb1
            if (r2 == 0) goto L7c
            boolean r1 = r2.isClosed()     // Catch: java.lang.Throwable -> L97
            if (r1 != 0) goto L7c
            r2.close()     // Catch: java.lang.Throwable -> L97
            goto L7c
        L97:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L7c
        L9c:
            r0 = move-exception
            r1 = r8
        L9e:
            if (r1 == 0) goto La9
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> Laa
            if (r2 != 0) goto La9
            r1.close()     // Catch: java.lang.Throwable -> Laa
        La9:
            throw r0
        Laa:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto La9
        Laf:
            r0 = move-exception
            goto L9e
        Lb1:
            r0 = move-exception
            r1 = r2
            goto L9e
        Lb4:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r8
            goto L88
        Lb9:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r8
            goto L88
        Lbe:
            r0 = r8
            goto L71
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.a.a.b(java.lang.String):java.lang.String[]");
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0028: INVOKE  (r0v4 int A[REMOVE]) = 
      (wrap: android.database.sqlite.SQLiteDatabase : 0x0012: IGET  (r0v3 android.database.sqlite.SQLiteDatabase A[REMOVE]) = (r4v0 'this' com.baidu.sofire.a.a A[IMMUTABLE_TYPE, THIS]) com.baidu.sofire.a.a.PI android.database.sqlite.SQLiteDatabase)
      ("pgn")
      (wrap: java.lang.String : ?: STR_CONCAT  ("k="), (r5v0 int))
      (null java.lang.String[])
     type: VIRTUAL call: android.database.sqlite.SQLiteDatabase.delete(java.lang.String, java.lang.String, java.lang.String[]):int)] */
    public final void g(int i) {
        new StringBuilder().append(i).toString();
        b.a();
        if (i > 0) {
            try {
                new StringBuilder().append(this.PI.delete("pgn", "k=" + i, null)).toString();
                b.a();
            } catch (Throwable th) {
                d.a(th);
            }
        }
    }

    public final void b(int i, int i2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("pr", Integer.valueOf(i2));
            this.PI.update("pgn", contentValues, "k=" + i, null);
        } catch (Throwable th) {
            d.a(th);
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
    public final com.baidu.sofire.core.ApkInfo bQ(java.lang.String r12) {
        /*
            r11 = this;
            r9 = 0
            r8 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 == 0) goto La
            r0 = r8
        L9:
            return r0
        La:
            android.database.sqlite.SQLiteDatabase r0 = r11.PI     // Catch: java.lang.Throwable -> L1b4
            java.lang.String r1 = "pgn"
            r2 = 0
            java.lang.String r3 = "p=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L1b4
            r5 = 0
            r4[r5] = r12     // Catch: java.lang.Throwable -> L1b4
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L1b4
            if (r1 == 0) goto L1f0
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L1e5
            if (r0 == 0) goto L1f0
            com.baidu.sofire.core.ApkInfo r2 = new com.baidu.sofire.core.ApkInfo     // Catch: java.lang.Throwable -> L1e5
            r2.<init>()     // Catch: java.lang.Throwable -> L1e5
            java.lang.String r0 = "k"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1eb
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1eb
            r2.key = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = "n"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1eb
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1eb
            r2.initStatus = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = "p"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1eb
            r2.packageName = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = "a"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1eb
            r2.pkgPath = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = "l"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1eb
            r2.libPath = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = "v"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1eb
            r2.versionName = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = "apk"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1eb
            r2.dexPath = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = "ap"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1eb
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1eb
            r2.apkParseSuc = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = "cl"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1eb
            r2.className = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = "th"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1eb
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1eb
            r2.applicationTheme = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = "st"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1eb
            long r4 = r1.getLong(r0)     // Catch: java.lang.Throwable -> L1eb
            r2.startTime = r4     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = "du"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1eb
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1eb
            r2.duration = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = "rs"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1eb
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1eb
            r2.runStatus = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = "m5"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1eb
            r2.apkMD5 = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = "pr"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1eb
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1eb
            r2.priority = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = "ac"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1eb
            byte[] r0 = r1.getBlob(r0)     // Catch: java.lang.Throwable -> L1eb
            if (r0 == 0) goto L1a0
            java.util.ArrayList r4 = com.baidu.sofire.core.a.a(r0)     // Catch: java.lang.Throwable -> L1eb
            if (r4 == 0) goto L1a0
            int r5 = r4.size()     // Catch: java.lang.Throwable -> L1eb
            if (r5 <= 0) goto L1a0
            android.content.pm.ActivityInfo[] r0 = new android.content.pm.ActivityInfo[r5]     // Catch: java.lang.Throwable -> L1eb
            r2.activities = r0     // Catch: java.lang.Throwable -> L1eb
            r3 = r9
        L10e:
            if (r3 >= r5) goto L1a0
            android.content.pm.ActivityInfo r6 = new android.content.pm.ActivityInfo     // Catch: java.lang.Throwable -> L1eb
            r6.<init>()     // Catch: java.lang.Throwable -> L1eb
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1eb
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1eb
            int r0 = r0.a     // Catch: java.lang.Throwable -> L1eb
            r6.theme = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1eb
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = r0.j     // Catch: java.lang.Throwable -> L1eb
            r6.name = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1eb
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1eb
            int r0 = r0.h     // Catch: java.lang.Throwable -> L1eb
            r6.configChanges = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1eb
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1eb
            int r0 = r0.f     // Catch: java.lang.Throwable -> L1eb
            r6.flags = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1eb
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1eb
            int r0 = r0.l     // Catch: java.lang.Throwable -> L1eb
            r6.labelRes = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1eb
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1eb
            int r0 = r0.b     // Catch: java.lang.Throwable -> L1eb
            r6.launchMode = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1eb
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = r0.m     // Catch: java.lang.Throwable -> L1eb
            r6.nonLocalizedLabel = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1eb
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = r0.k     // Catch: java.lang.Throwable -> L1eb
            r6.packageName = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1eb
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = r0.c     // Catch: java.lang.Throwable -> L1eb
            r6.permission = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1eb
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1eb
            int r0 = r0.g     // Catch: java.lang.Throwable -> L1eb
            r6.screenOrientation = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1eb
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1eb
            int r0 = r0.i     // Catch: java.lang.Throwable -> L1eb
            r6.softInputMode = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1eb
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = r0.e     // Catch: java.lang.Throwable -> L1eb
            r6.targetActivity = r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1eb
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1eb
            java.lang.String r0 = r0.d     // Catch: java.lang.Throwable -> L1eb
            r6.taskAffinity = r0     // Catch: java.lang.Throwable -> L1eb
            android.content.pm.ActivityInfo[] r0 = r2.activities     // Catch: java.lang.Throwable -> L1eb
            r0[r3] = r6     // Catch: java.lang.Throwable -> L1eb
            int r0 = r3 + 1
            r3 = r0
            goto L10e
        L1a0:
            r0 = r2
        L1a1:
            if (r1 == 0) goto L9
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> L1ae
            if (r2 != 0) goto L9
            r1.close()     // Catch: java.lang.Throwable -> L1ae
            goto L9
        L1ae:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L9
        L1b4:
            r0 = move-exception
            r1 = r0
            r0 = r8
        L1b7:
            com.baidu.sofire.b.d.a(r1)     // Catch: java.lang.Throwable -> L1e2
            if (r8 == 0) goto L9
            boolean r1 = r8.isClosed()     // Catch: java.lang.Throwable -> L1c7
            if (r1 != 0) goto L9
            r8.close()     // Catch: java.lang.Throwable -> L1c7
            goto L9
        L1c7:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L9
        L1cd:
            r0 = move-exception
            r1 = r8
        L1cf:
            if (r1 == 0) goto L1da
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> L1db
            if (r2 != 0) goto L1da
            r1.close()     // Catch: java.lang.Throwable -> L1db
        L1da:
            throw r0
        L1db:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L1da
        L1e0:
            r0 = move-exception
            goto L1cf
        L1e2:
            r0 = move-exception
            r1 = r8
            goto L1cf
        L1e5:
            r0 = move-exception
            r10 = r0
            r0 = r8
            r8 = r1
            r1 = r10
            goto L1b7
        L1eb:
            r0 = move-exception
            r8 = r1
            r1 = r0
            r0 = r2
            goto L1b7
        L1f0:
            r0 = r8
            goto L1a1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.a.a.bQ(java.lang.String):com.baidu.sofire.core.ApkInfo");
    }
}
