package com.baidu.sofire.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.sofire.b;
import com.baidu.sofire.b.e;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static a f;
    private int a = 5;
    private String b = "create table pgn(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,la INTEGER,o INTEGER,r INTEGER,ap INTEGER,apk TEXT,cl TEXT,b TEXT,t TEXT,ac BLOB,st INTEGER,du INTEGER,th INTEGER,m5 TEXT,rs INTEGER,l TEXT,pr INTEGER DEFAULT -1,pdld INTEGER DEFAULT 0,a TEXT)";
    private C0139a c;
    private SQLiteDatabase d;
    private Context e;

    private a(Context context) {
        b.a("MyDb init");
        this.e = context.getApplicationContext();
        this.c = new C0139a(context.getApplicationContext());
        try {
            this.d = this.c.getWritableDatabase();
        } catch (Throwable th) {
            e.a(th);
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            b.a("i=" + f);
            if (f == null) {
                f = new a(context);
            }
            aVar = f;
        }
        return aVar;
    }

    public static a a() {
        return f;
    }

    /* renamed from: com.baidu.sofire.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0139a extends SQLiteOpenHelper {
        public C0139a(Context context) {
            super(context, "tpgcc.db", (SQLiteDatabase.CursorFactory) null, a.this.a);
            b.a("DatabaseHelper version=" + a.this.a);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(a.this.b);
            } catch (Throwable th) {
                e.a(th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                b.a("o=" + i + ", n=" + i2);
                if (i < 3 && i2 >= 3) {
                    sQLiteDatabase.beginTransaction();
                    sQLiteDatabase.execSQL("ALTER TABLE pgn ADD COLUMN pr INTEGER  DEFAULT -1");
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                }
                if (i < 5 && i2 >= 5) {
                    sQLiteDatabase.beginTransaction();
                    sQLiteDatabase.execSQL("ALTER TABLE pgn ADD COLUMN pdld INTEGER  DEFAULT -1");
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                }
                if (i < 4 && i2 >= 4) {
                    sQLiteDatabase.execSQL("drop table if exists tbch");
                }
            } catch (Throwable th) {
                e.a(th);
            }
        }
    }

    public long a(ApkInfo apkInfo) {
        long j = 0;
        if (apkInfo != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", Integer.valueOf(apkInfo.initStatus));
            contentValues.put("p", apkInfo.packageName);
            contentValues.put(Config.APP_VERSION_CODE, apkInfo.pkgPath);
            contentValues.put("l", apkInfo.libPath);
            contentValues.put("v", apkInfo.versionName);
            contentValues.put("apk", apkInfo.dexPath);
            contentValues.put("ap", Integer.valueOf(apkInfo.apkParseSuc));
            contentValues.put(Config.CELL_LOCATION, apkInfo.className);
            contentValues.put("st", Long.valueOf(apkInfo.startTime));
            contentValues.put("du", Integer.valueOf(apkInfo.duration));
            contentValues.put("m5", apkInfo.apkMD5);
            contentValues.put("th", Integer.valueOf(apkInfo.applicationTheme));
            contentValues.put(Config.PRINCIPAL_PART, Integer.valueOf(apkInfo.priority));
            if (apkInfo.activities != null) {
                contentValues.put("ac", new com.baidu.sofire.core.a(apkInfo.activities).a());
            }
            try {
                if (b(apkInfo.key)) {
                    j = this.d.update("pgn", contentValues, "k=" + apkInfo.key, null);
                } else {
                    contentValues.put(Config.APP_KEY, Integer.valueOf(apkInfo.key));
                    j = this.d.insert("pgn", null, contentValues);
                }
            } catch (Throwable th) {
            }
        }
        return j;
    }

    public List<ApkInfo> b() {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = this.d.query("pgn", null, null, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        ApkInfo apkInfo = new ApkInfo();
                        apkInfo.key = cursor.getInt(cursor.getColumnIndex(Config.APP_KEY));
                        apkInfo.packageName = cursor.getString(cursor.getColumnIndex("p"));
                        apkInfo.pkgPath = cursor.getString(cursor.getColumnIndex(Config.APP_VERSION_CODE));
                        apkInfo.libPath = cursor.getString(cursor.getColumnIndex("l"));
                        apkInfo.versionName = cursor.getString(cursor.getColumnIndex("v"));
                        apkInfo.startTime = cursor.getLong(cursor.getColumnIndex("st"));
                        apkInfo.duration = cursor.getInt(cursor.getColumnIndex("du"));
                        apkInfo.priority = cursor.getInt(cursor.getColumnIndex(Config.PRINCIPAL_PART));
                        arrayList.add(apkInfo);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            e.a(th);
                            return arrayList;
                        } finally {
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable th2) {
                                    e.a(th2);
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
                    e.a(th3);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
        return arrayList;
    }

    public Map<Integer, String> c() {
        Cursor cursor;
        HashMap hashMap = new HashMap();
        try {
            cursor = this.d.query("pgn", null, "n=1", null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        hashMap.put(Integer.valueOf(cursor.getInt(cursor.getColumnIndex(Config.APP_KEY))), "'" + cursor.getString(cursor.getColumnIndex("v")) + "'");
                    } catch (Throwable th) {
                        th = th;
                        try {
                            e.a(th);
                            return hashMap;
                        } finally {
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable th2) {
                                    e.a(th2);
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
                    e.a(th3);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
        return hashMap;
    }

    public Map<Integer, String> d() {
        Cursor cursor;
        HashMap hashMap = new HashMap();
        try {
            cursor = this.d.query("pgn", null, "n=1", null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        hashMap.put(Integer.valueOf(cursor.getInt(cursor.getColumnIndex(Config.APP_KEY))), cursor.getString(cursor.getColumnIndex("p")));
                    } catch (Throwable th) {
                        th = th;
                        try {
                            e.a(th);
                            return hashMap;
                        } finally {
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable th2) {
                                    e.a(th2);
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
                    e.a(th3);
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
    public com.baidu.sofire.core.ApkInfo a(int r11) {
        /*
            r10 = this;
            r8 = 0
            android.database.sqlite.SQLiteDatabase r0 = r10.d     // Catch: java.lang.Throwable -> L19e
            java.lang.String r1 = "pgn"
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L19e
            r3.<init>()     // Catch: java.lang.Throwable -> L19e
            java.lang.String r4 = "k="
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L19e
            java.lang.StringBuilder r3 = r3.append(r11)     // Catch: java.lang.Throwable -> L19e
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L19e
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L19e
            if (r1 == 0) goto L1d9
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L1ce
            if (r0 == 0) goto L1d9
            com.baidu.sofire.core.ApkInfo r2 = new com.baidu.sofire.core.ApkInfo     // Catch: java.lang.Throwable -> L1ce
            r2.<init>()     // Catch: java.lang.Throwable -> L1ce
            r2.key = r11     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = "n"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1d3
            r2.initStatus = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = "p"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1d3
            r2.packageName = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = "a"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1d3
            r2.pkgPath = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = "l"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1d3
            r2.libPath = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = "v"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1d3
            r2.versionName = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = "apk"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1d3
            r2.dexPath = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = "ap"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1d3
            r2.apkParseSuc = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = "cl"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1d3
            r2.className = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = "th"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1d3
            r2.applicationTheme = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = "st"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3
            long r4 = r1.getLong(r0)     // Catch: java.lang.Throwable -> L1d3
            r2.startTime = r4     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = "du"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1d3
            r2.duration = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = "m5"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1d3
            r2.apkMD5 = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = "pr"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1d3
            r2.priority = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = "ac"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d3
            byte[] r0 = r1.getBlob(r0)     // Catch: java.lang.Throwable -> L1d3
            if (r0 == 0) goto L18c
            java.util.ArrayList r4 = com.baidu.sofire.core.a.a(r0)     // Catch: java.lang.Throwable -> L1d3
            if (r4 == 0) goto L18c
            int r5 = r4.size()     // Catch: java.lang.Throwable -> L1d3
            if (r5 <= 0) goto L18c
            android.content.pm.ActivityInfo[] r0 = new android.content.pm.ActivityInfo[r5]     // Catch: java.lang.Throwable -> L1d3
            r2.activities = r0     // Catch: java.lang.Throwable -> L1d3
            r0 = 0
            r3 = r0
        Lfa:
            if (r3 >= r5) goto L18c
            android.content.pm.ActivityInfo r6 = new android.content.pm.ActivityInfo     // Catch: java.lang.Throwable -> L1d3
            r6.<init>()     // Catch: java.lang.Throwable -> L1d3
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1d3
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1d3
            int r0 = r0.a     // Catch: java.lang.Throwable -> L1d3
            r6.theme = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1d3
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = r0.j     // Catch: java.lang.Throwable -> L1d3
            r6.name = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1d3
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1d3
            int r0 = r0.h     // Catch: java.lang.Throwable -> L1d3
            r6.configChanges = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1d3
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1d3
            int r0 = r0.f     // Catch: java.lang.Throwable -> L1d3
            r6.flags = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1d3
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1d3
            int r0 = r0.l     // Catch: java.lang.Throwable -> L1d3
            r6.labelRes = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1d3
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1d3
            int r0 = r0.b     // Catch: java.lang.Throwable -> L1d3
            r6.launchMode = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1d3
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = r0.m     // Catch: java.lang.Throwable -> L1d3
            r6.nonLocalizedLabel = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1d3
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = r0.k     // Catch: java.lang.Throwable -> L1d3
            r6.packageName = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1d3
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = r0.c     // Catch: java.lang.Throwable -> L1d3
            r6.permission = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1d3
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1d3
            int r0 = r0.g     // Catch: java.lang.Throwable -> L1d3
            r6.screenOrientation = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1d3
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1d3
            int r0 = r0.i     // Catch: java.lang.Throwable -> L1d3
            r6.softInputMode = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1d3
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = r0.e     // Catch: java.lang.Throwable -> L1d3
            r6.targetActivity = r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1d3
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1d3
            java.lang.String r0 = r0.d     // Catch: java.lang.Throwable -> L1d3
            r6.taskAffinity = r0     // Catch: java.lang.Throwable -> L1d3
            android.content.pm.ActivityInfo[] r0 = r2.activities     // Catch: java.lang.Throwable -> L1d3
            r0[r3] = r6     // Catch: java.lang.Throwable -> L1d3
            int r0 = r3 + 1
            r3 = r0
            goto Lfa
        L18c:
            r0 = r2
        L18d:
            if (r1 == 0) goto L198
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> L199
            if (r2 != 0) goto L198
            r1.close()     // Catch: java.lang.Throwable -> L199
        L198:
            return r0
        L199:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
            goto L198
        L19e:
            r0 = move-exception
            r1 = r0
            r2 = r8
            r0 = r8
        L1a2:
            com.baidu.sofire.b.e.a(r1)     // Catch: java.lang.Throwable -> L1cb
            if (r2 == 0) goto L198
            boolean r1 = r2.isClosed()     // Catch: java.lang.Throwable -> L1b1
            if (r1 != 0) goto L198
            r2.close()     // Catch: java.lang.Throwable -> L1b1
            goto L198
        L1b1:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
            goto L198
        L1b6:
            r0 = move-exception
            r1 = r8
        L1b8:
            if (r1 == 0) goto L1c3
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> L1c4
            if (r2 != 0) goto L1c3
            r1.close()     // Catch: java.lang.Throwable -> L1c4
        L1c3:
            throw r0
        L1c4:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
            goto L1c3
        L1c9:
            r0 = move-exception
            goto L1b8
        L1cb:
            r0 = move-exception
            r1 = r2
            goto L1b8
        L1ce:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r8
            goto L1a2
        L1d3:
            r0 = move-exception
            r9 = r0
            r0 = r2
            r2 = r1
            r1 = r9
            goto L1a2
        L1d9:
            r0 = r8
            goto L18d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.a.a.a(int):com.baidu.sofire.core.ApkInfo");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(int i) {
        Cursor cursor;
        boolean z;
        try {
            cursor = this.d.query("pgn", new String[]{"p"}, "k=" + i, null, null, null, null);
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
                                e.a(th);
                                return z;
                            }
                        }
                        return z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        e.a(th);
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable th3) {
                                e.a(th3);
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
                                e.a(th5);
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

    /* JADX WARN: Removed duplicated region for block: B:39:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int c(int i) {
        Cursor cursor;
        int i2;
        try {
            cursor = this.d.query("pgn", new String[]{"n"}, "k=" + i, null, null, null, null);
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
                                e.a(th);
                                return i2;
                            }
                        }
                        return i2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        e.a(th);
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable th3) {
                                e.a(th3);
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
                                e.a(th5);
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

    public void a(String str) {
        b.a("deleteLoadedPluginByPackage p=" + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                this.d.delete("pgn", "p=?", new String[]{str});
            } catch (Throwable th) {
                e.a(th);
            }
        }
    }

    public void e() {
        try {
            ArrayList<ApkInfo> arrayList = new ArrayList();
            for (ApkInfo apkInfo : b()) {
                if (!e.c(apkInfo.pkgPath) && g.a != null && !g.a.contains(Integer.valueOf(apkInfo.key))) {
                    arrayList.add(apkInfo);
                }
            }
            g a = g.a();
            for (ApkInfo apkInfo2 : arrayList) {
                if (a != null) {
                    a.b(apkInfo2.packageName);
                }
                b.a(apkInfo2.packageName + " is deleted IfAPKNotExist count=" + this.d.delete("pgn", "k=" + apkInfo2.key, null));
                e.d(this.e.getFilesDir().getCanonicalPath() + "/." + apkInfo2.key);
                if (this.e != null) {
                    e.d(this.e.getFileStreamPath(apkInfo2.packageName).getAbsolutePath());
                }
            }
        } catch (Throwable th) {
            e.a(th);
        }
    }

    public boolean d(int i) {
        Cursor cursor;
        boolean z = false;
        try {
            Cursor cursor2 = this.d.query("pgn", new String[]{"u"}, "k=" + i, null, null, null, null);
            if (cursor2 != null) {
                try {
                    if (cursor2.moveToFirst()) {
                        cursor = cursor2.getInt(cursor2.getColumnIndex("u")) == 1;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        e.a(th);
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable th2) {
                                e.a(th2);
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
                                e.a(th3);
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

    public boolean e(int i) {
        Cursor cursor;
        boolean z = false;
        try {
            Cursor cursor2 = this.d.query("pgn", new String[]{"s"}, "k=" + i, null, null, null, null);
            if (cursor2 != null) {
                try {
                    if (cursor2.moveToFirst()) {
                        cursor = cursor2.getInt(cursor2.getColumnIndex("s")) == 1;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        e.a(th);
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable th2) {
                                e.a(th2);
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
                                e.a(th3);
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

    public void a(int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("s", Integer.valueOf(i2));
        try {
            this.d.update("pgn", contentValues, "k=" + i + " and n=1", null);
        } catch (Throwable th) {
            e.a(th);
        }
    }

    public int b(int i, int i2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("u", Integer.valueOf(i2));
            return this.d.update("pgn", contentValues, "k=" + i, null);
        } catch (Throwable th) {
            return 0;
        }
    }

    public void c(int i, int i2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", Integer.valueOf(i2));
            this.d.update("pgn", contentValues, "k=" + i, null);
        } catch (Throwable th) {
            e.a(th);
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
    public java.lang.String[] b(java.lang.String r12) {
        /*
            r11 = this;
            r10 = 0
            r8 = 0
            r9 = 1
            android.database.sqlite.SQLiteDatabase r0 = r11.d     // Catch: java.lang.Throwable -> L84
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
            com.baidu.sofire.b.e.a(r1)
            goto L7c
        L84:
            r0 = move-exception
            r1 = r0
            r2 = r8
            r0 = r8
        L88:
            com.baidu.sofire.b.e.a(r1)     // Catch: java.lang.Throwable -> Lb1
            if (r2 == 0) goto L7c
            boolean r1 = r2.isClosed()     // Catch: java.lang.Throwable -> L97
            if (r1 != 0) goto L7c
            r2.close()     // Catch: java.lang.Throwable -> L97
            goto L7c
        L97:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
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
            com.baidu.sofire.b.e.a(r1)
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

    public void a(String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("r", (Integer) 1);
        contentValues.put("b", str2);
        contentValues.put("t", str3);
        try {
            this.d.update("pgn", contentValues, "p=?", new String[]{str});
        } catch (Throwable th) {
            e.a(th);
        }
    }

    public void d(int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("pdld", Integer.valueOf(i2));
        try {
            this.d.update("pgn", contentValues, "k=" + i, null);
        } catch (Throwable th) {
            e.a(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int f(int i) {
        Cursor cursor;
        int i2;
        try {
            cursor = this.d.query("pgn", new String[]{"pdld"}, "k=" + i, null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        i2 = cursor.getInt(cursor.getColumnIndex("pdld"));
                        if (cursor == null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                    return i2;
                                }
                                return i2;
                            } catch (Throwable th) {
                                e.a(th);
                                return i2;
                            }
                        }
                        return i2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        e.a(th);
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable th3) {
                                e.a(th3);
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
                                e.a(th5);
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

    public void f() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", (Integer) 0);
        try {
            this.d.update("pgn", contentValues, "n=-1", null);
        } catch (Throwable th) {
            e.a(th);
        }
    }

    public void a(String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("s", Integer.valueOf(i));
        try {
            this.d.update("pgn", contentValues, "p=? and n=1", new String[]{str});
        } catch (Throwable th) {
            e.a(th);
        }
    }

    public void g(int i) {
        b.a("deletePluginById=" + i);
        if (i > 0) {
            try {
                b.a("deletePluginById count=" + this.d.delete("pgn", "k=" + i, null));
            } catch (Throwable th) {
                e.a(th);
            }
        }
    }

    public void e(int i, int i2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Config.PRINCIPAL_PART, Integer.valueOf(i2));
            this.d.update("pgn", contentValues, "k=" + i, null);
        } catch (Throwable th) {
            e.a(th);
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
    public com.baidu.sofire.core.ApkInfo c(java.lang.String r12) {
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
            android.database.sqlite.SQLiteDatabase r0 = r11.d     // Catch: java.lang.Throwable -> L1a7
            java.lang.String r1 = "pgn"
            r2 = 0
            java.lang.String r3 = "p=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L1a7
            r5 = 0
            r4[r5] = r12     // Catch: java.lang.Throwable -> L1a7
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L1a7
            if (r1 == 0) goto L1e3
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L1d8
            if (r0 == 0) goto L1e3
            com.baidu.sofire.core.ApkInfo r2 = new com.baidu.sofire.core.ApkInfo     // Catch: java.lang.Throwable -> L1d8
            r2.<init>()     // Catch: java.lang.Throwable -> L1d8
            java.lang.String r0 = "k"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1de
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1de
            r2.key = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = "n"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1de
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1de
            r2.initStatus = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = "p"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1de
            r2.packageName = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = "a"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1de
            r2.pkgPath = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = "l"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1de
            r2.libPath = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = "v"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1de
            r2.versionName = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = "apk"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1de
            r2.dexPath = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = "ap"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1de
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1de
            r2.apkParseSuc = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = "cl"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1de
            r2.className = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = "th"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1de
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1de
            r2.applicationTheme = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = "st"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1de
            long r4 = r1.getLong(r0)     // Catch: java.lang.Throwable -> L1de
            r2.startTime = r4     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = "du"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1de
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1de
            r2.duration = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = "m5"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1de
            r2.apkMD5 = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = "pr"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1de
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1de
            r2.priority = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = "ac"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1de
            byte[] r0 = r1.getBlob(r0)     // Catch: java.lang.Throwable -> L1de
            if (r0 == 0) goto L193
            java.util.ArrayList r4 = com.baidu.sofire.core.a.a(r0)     // Catch: java.lang.Throwable -> L1de
            if (r4 == 0) goto L193
            int r5 = r4.size()     // Catch: java.lang.Throwable -> L1de
            if (r5 <= 0) goto L193
            android.content.pm.ActivityInfo[] r0 = new android.content.pm.ActivityInfo[r5]     // Catch: java.lang.Throwable -> L1de
            r2.activities = r0     // Catch: java.lang.Throwable -> L1de
            r3 = r9
        L101:
            if (r3 >= r5) goto L193
            android.content.pm.ActivityInfo r6 = new android.content.pm.ActivityInfo     // Catch: java.lang.Throwable -> L1de
            r6.<init>()     // Catch: java.lang.Throwable -> L1de
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1de
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1de
            int r0 = r0.a     // Catch: java.lang.Throwable -> L1de
            r6.theme = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1de
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = r0.j     // Catch: java.lang.Throwable -> L1de
            r6.name = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1de
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1de
            int r0 = r0.h     // Catch: java.lang.Throwable -> L1de
            r6.configChanges = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1de
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1de
            int r0 = r0.f     // Catch: java.lang.Throwable -> L1de
            r6.flags = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1de
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1de
            int r0 = r0.l     // Catch: java.lang.Throwable -> L1de
            r6.labelRes = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1de
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1de
            int r0 = r0.b     // Catch: java.lang.Throwable -> L1de
            r6.launchMode = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1de
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = r0.m     // Catch: java.lang.Throwable -> L1de
            r6.nonLocalizedLabel = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1de
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = r0.k     // Catch: java.lang.Throwable -> L1de
            r6.packageName = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1de
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = r0.c     // Catch: java.lang.Throwable -> L1de
            r6.permission = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1de
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1de
            int r0 = r0.g     // Catch: java.lang.Throwable -> L1de
            r6.screenOrientation = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1de
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1de
            int r0 = r0.i     // Catch: java.lang.Throwable -> L1de
            r6.softInputMode = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1de
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = r0.e     // Catch: java.lang.Throwable -> L1de
            r6.targetActivity = r0     // Catch: java.lang.Throwable -> L1de
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1de
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1de
            java.lang.String r0 = r0.d     // Catch: java.lang.Throwable -> L1de
            r6.taskAffinity = r0     // Catch: java.lang.Throwable -> L1de
            android.content.pm.ActivityInfo[] r0 = r2.activities     // Catch: java.lang.Throwable -> L1de
            r0[r3] = r6     // Catch: java.lang.Throwable -> L1de
            int r0 = r3 + 1
            r3 = r0
            goto L101
        L193:
            r0 = r2
        L194:
            if (r1 == 0) goto L9
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> L1a1
            if (r2 != 0) goto L9
            r1.close()     // Catch: java.lang.Throwable -> L1a1
            goto L9
        L1a1:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
            goto L9
        L1a7:
            r0 = move-exception
            r1 = r0
            r0 = r8
        L1aa:
            com.baidu.sofire.b.e.a(r1)     // Catch: java.lang.Throwable -> L1d5
            if (r8 == 0) goto L9
            boolean r1 = r8.isClosed()     // Catch: java.lang.Throwable -> L1ba
            if (r1 != 0) goto L9
            r8.close()     // Catch: java.lang.Throwable -> L1ba
            goto L9
        L1ba:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
            goto L9
        L1c0:
            r0 = move-exception
            r1 = r8
        L1c2:
            if (r1 == 0) goto L1cd
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> L1ce
            if (r2 != 0) goto L1cd
            r1.close()     // Catch: java.lang.Throwable -> L1ce
        L1cd:
            throw r0
        L1ce:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
            goto L1cd
        L1d3:
            r0 = move-exception
            goto L1c2
        L1d5:
            r0 = move-exception
            r1 = r8
            goto L1c2
        L1d8:
            r0 = move-exception
            r10 = r0
            r0 = r8
            r8 = r1
            r1 = r10
            goto L1aa
        L1de:
            r0 = move-exception
            r8 = r1
            r1 = r0
            r0 = r2
            goto L1aa
        L1e3:
            r0 = r8
            goto L194
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.a.a.c(java.lang.String):com.baidu.sofire.core.ApkInfo");
    }
}
