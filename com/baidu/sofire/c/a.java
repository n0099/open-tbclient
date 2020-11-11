package com.baidu.sofire.c;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.sofire.b;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.f;
import com.baidu.sofire.i.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes15.dex */
public final class a {
    public static a d;

    /* renamed from: a  reason: collision with root package name */
    int f3600a = 5;
    String b = "create table pgn(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,la INTEGER,o INTEGER,r INTEGER,ap INTEGER,apk TEXT,cl TEXT,b TEXT,t TEXT,ac BLOB,st INTEGER,du INTEGER,th INTEGER,m5 TEXT,rs INTEGER,l TEXT,pr INTEGER DEFAULT -1,pdld INTEGER DEFAULT 0,a TEXT)";
    public SQLiteDatabase c;
    private C0357a e;
    private Context f;

    private a(Context context) {
        b.a();
        this.f = context.getApplicationContext();
        this.e = new C0357a(context.getApplicationContext());
        try {
            this.c = this.e.getWritableDatabase();
        } catch (Throwable th) {
            e.a();
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            new StringBuilder("i=").append(d);
            b.a();
            if (d == null) {
                d = new a(context);
            }
            aVar = d;
        }
        return aVar;
    }

    /* renamed from: com.baidu.sofire.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    private class C0357a extends SQLiteOpenHelper {
        public C0357a(Context context) {
            super(context, "tpgcc.db", (SQLiteDatabase.CursorFactory) null, a.this.f3600a);
            new StringBuilder().append(a.this.f3600a);
            b.a();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(a.this.b);
            } catch (Throwable th) {
                e.a();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                new StringBuilder("o=").append(i).append(", n=").append(i2);
                b.a();
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
                e.a();
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
                    j = this.c.update("pgn", contentValues, "k=" + apkInfo.key, null);
                } else {
                    contentValues.put("k", Integer.valueOf(apkInfo.key));
                    j = this.c.insert("pgn", null, contentValues);
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
            cursor = this.c.query("pgn", null, null, null, null, null, null);
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
                        apkInfo.priority = cursor.getInt(cursor.getColumnIndex(Config.PRINCIPAL_PART));
                        arrayList.add(apkInfo);
                    } catch (Throwable th) {
                        try {
                            e.a();
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable th2) {
                                    e.a();
                                }
                            }
                            return arrayList;
                        } catch (Throwable th3) {
                            Cursor cursor2 = cursor;
                            if (cursor2 != null) {
                                try {
                                    if (!cursor2.isClosed()) {
                                        cursor2.close();
                                    }
                                } catch (Throwable th4) {
                                    e.a();
                                }
                            }
                            throw th3;
                        }
                    }
                }
            }
            if (cursor != null) {
                try {
                    if (!cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Throwable th5) {
                    e.a();
                }
            }
        } catch (Throwable th6) {
            cursor = null;
        }
        return arrayList;
    }

    public final Map<Integer, String> b() {
        Cursor cursor;
        HashMap hashMap = new HashMap();
        try {
            cursor = this.c.query("pgn", null, "n=1", null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        hashMap.put(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("k"))), "'" + cursor.getString(cursor.getColumnIndex("v")) + "'");
                    } catch (Throwable th) {
                        try {
                            e.a();
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable th2) {
                                    e.a();
                                }
                            }
                            return hashMap;
                        } catch (Throwable th3) {
                            Cursor cursor2 = cursor;
                            if (cursor2 != null) {
                                try {
                                    if (!cursor2.isClosed()) {
                                        cursor2.close();
                                    }
                                } catch (Throwable th4) {
                                    e.a();
                                }
                            }
                            throw th3;
                        }
                    }
                }
            }
            if (cursor != null) {
                try {
                    if (!cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Throwable th5) {
                    e.a();
                }
            }
        } catch (Throwable th6) {
            cursor = null;
        }
        return hashMap;
    }

    public final Map<Integer, String> c() {
        Cursor cursor;
        HashMap hashMap = new HashMap();
        try {
            cursor = this.c.query("pgn", null, "n=1", null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        hashMap.put(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("k"))), cursor.getString(cursor.getColumnIndex("p")));
                    } catch (Throwable th) {
                        try {
                            e.a();
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable th2) {
                                    e.a();
                                }
                            }
                            return hashMap;
                        } catch (Throwable th3) {
                            Cursor cursor2 = cursor;
                            if (cursor2 != null) {
                                try {
                                    if (!cursor2.isClosed()) {
                                        cursor2.close();
                                    }
                                } catch (Throwable th4) {
                                    e.a();
                                }
                            }
                            throw th3;
                        }
                    }
                }
            }
            if (cursor != null) {
                try {
                    if (!cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Throwable th5) {
                    e.a();
                }
            }
        } catch (Throwable th6) {
            cursor = null;
        }
        return hashMap;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, IF, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Removed duplicated region for block: B:60:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ApkInfo a(int i) {
        Cursor cursor;
        ApkInfo apkInfo;
        ArrayList<com.baidu.sofire.core.b> a2;
        int size;
        try {
            cursor = this.c.query("pgn", null, "k=" + i, null, null, null, null);
        } catch (Throwable th) {
            cursor = null;
            apkInfo = null;
        }
        if (cursor != null) {
            try {
            } catch (Throwable th2) {
                apkInfo = null;
            }
            if (cursor.moveToFirst()) {
                ApkInfo apkInfo2 = new ApkInfo();
                try {
                    apkInfo2.key = i;
                    apkInfo2.initStatus = cursor.getInt(cursor.getColumnIndex("n"));
                    apkInfo2.packageName = cursor.getString(cursor.getColumnIndex("p"));
                    apkInfo2.pkgPath = cursor.getString(cursor.getColumnIndex("a"));
                    apkInfo2.libPath = cursor.getString(cursor.getColumnIndex("l"));
                    apkInfo2.versionName = cursor.getString(cursor.getColumnIndex("v"));
                    apkInfo2.dexPath = cursor.getString(cursor.getColumnIndex("apk"));
                    apkInfo2.apkParseSuc = cursor.getInt(cursor.getColumnIndex("ap"));
                    apkInfo2.className = cursor.getString(cursor.getColumnIndex(Config.CELL_LOCATION));
                    apkInfo2.applicationTheme = cursor.getInt(cursor.getColumnIndex("th"));
                    apkInfo2.startTime = cursor.getLong(cursor.getColumnIndex("st"));
                    apkInfo2.duration = cursor.getInt(cursor.getColumnIndex("du"));
                    apkInfo2.apkMD5 = cursor.getString(cursor.getColumnIndex("m5"));
                    apkInfo2.priority = cursor.getInt(cursor.getColumnIndex(Config.PRINCIPAL_PART));
                    byte[] blob = cursor.getBlob(cursor.getColumnIndex("ac"));
                    if (blob != null && (a2 = com.baidu.sofire.core.a.a(blob)) != null && (size = a2.size()) > 0) {
                        apkInfo2.activities = new ActivityInfo[size];
                        for (int i2 = 0; i2 < size; i2++) {
                            ActivityInfo activityInfo = new ActivityInfo();
                            activityInfo.theme = a2.get(i2).f3604a;
                            activityInfo.name = a2.get(i2).j;
                            activityInfo.configChanges = a2.get(i2).h;
                            activityInfo.flags = a2.get(i2).f;
                            activityInfo.labelRes = a2.get(i2).l;
                            activityInfo.launchMode = a2.get(i2).b;
                            activityInfo.nonLocalizedLabel = a2.get(i2).m;
                            activityInfo.packageName = a2.get(i2).k;
                            activityInfo.permission = a2.get(i2).c;
                            activityInfo.screenOrientation = a2.get(i2).g;
                            activityInfo.softInputMode = a2.get(i2).i;
                            activityInfo.targetActivity = a2.get(i2).e;
                            activityInfo.taskAffinity = a2.get(i2).d;
                            apkInfo2.activities[i2] = activityInfo;
                        }
                    }
                    apkInfo = apkInfo2;
                } catch (Throwable th3) {
                    apkInfo = apkInfo2;
                    try {
                        e.a();
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable th4) {
                                e.a();
                            }
                        }
                        return apkInfo;
                    } finally {
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable th5) {
                                e.a();
                            }
                        }
                    }
                }
                return apkInfo;
            }
        }
        apkInfo = null;
        return apkInfo;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final boolean b(int r12) {
        /*
            r11 = this;
            r10 = 1
            r8 = 0
            r9 = 0
            java.lang.String r1 = "pgn"
            android.database.sqlite.SQLiteDatabase r0 = r11.c     // Catch: java.lang.Throwable -> L43
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L43
            r3 = 0
            java.lang.String r4 = "p"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L43
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43
            java.lang.String r4 = "k="
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L43
            java.lang.StringBuilder r3 = r3.append(r12)     // Catch: java.lang.Throwable -> L43
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L43
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L43
            if (r1 == 0) goto L77
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L74
            if (r0 <= 0) goto L77
            r0 = r10
        L32:
            if (r1 == 0) goto L3d
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> L3e
            if (r2 != 0) goto L3d
            r1.close()     // Catch: java.lang.Throwable -> L3e
        L3d:
            return r0
        L3e:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L3d
        L43:
            r0 = move-exception
            r0 = r9
        L45:
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L70
            if (r0 == 0) goto L53
            boolean r1 = r0.isClosed()     // Catch: java.lang.Throwable -> L55
            if (r1 != 0) goto L53
            r0.close()     // Catch: java.lang.Throwable -> L55
        L53:
            r0 = r8
            goto L3d
        L55:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            r0 = r8
            goto L3d
        L5b:
            r0 = move-exception
        L5c:
            if (r9 == 0) goto L67
            boolean r1 = r9.isClosed()     // Catch: java.lang.Throwable -> L68
            if (r1 != 0) goto L67
            r9.close()     // Catch: java.lang.Throwable -> L68
        L67:
            throw r0
        L68:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L67
        L6d:
            r0 = move-exception
            r9 = r1
            goto L5c
        L70:
            r1 = move-exception
            r9 = r0
            r0 = r1
            goto L5c
        L74:
            r0 = move-exception
            r0 = r1
            goto L45
        L77:
            r0 = r8
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.c.a.b(int):boolean");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final int c(int r11) {
        /*
            r10 = this;
            r8 = 0
            r9 = 0
            android.database.sqlite.SQLiteDatabase r0 = r10.c     // Catch: java.lang.Throwable -> L4d
            java.lang.String r1 = "pgn"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L4d
            r3 = 0
            java.lang.String r4 = "n"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L4d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d
            java.lang.String r4 = "k="
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L4d
            java.lang.StringBuilder r3 = r3.append(r11)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L4d
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L81
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L7e
            if (r0 == 0) goto L81
            java.lang.String r0 = "n"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7e
            int r8 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L7e
            r0 = r8
        L3c:
            if (r1 == 0) goto L47
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> L48
            if (r2 != 0) goto L47
            r1.close()     // Catch: java.lang.Throwable -> L48
        L47:
            return r0
        L48:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L47
        L4d:
            r0 = move-exception
            r0 = r9
        L4f:
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L7a
            if (r0 == 0) goto L5d
            boolean r1 = r0.isClosed()     // Catch: java.lang.Throwable -> L5f
            if (r1 != 0) goto L5d
            r0.close()     // Catch: java.lang.Throwable -> L5f
        L5d:
            r0 = r8
            goto L47
        L5f:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            r0 = r8
            goto L47
        L65:
            r0 = move-exception
        L66:
            if (r9 == 0) goto L71
            boolean r1 = r9.isClosed()     // Catch: java.lang.Throwable -> L72
            if (r1 != 0) goto L71
            r9.close()     // Catch: java.lang.Throwable -> L72
        L71:
            throw r0
        L72:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L71
        L77:
            r0 = move-exception
            r9 = r1
            goto L66
        L7a:
            r1 = move-exception
            r9 = r0
            r0 = r1
            goto L66
        L7e:
            r0 = move-exception
            r0 = r1
            goto L4f
        L81:
            r0 = r8
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.c.a.c(int):int");
    }

    public final void a(String str) {
        new StringBuilder().append(str);
        b.a();
        if (!TextUtils.isEmpty(str)) {
            try {
                this.c.delete("pgn", "p=?", new String[]{str});
            } catch (Throwable th) {
                e.a();
            }
        }
    }

    public final void d() {
        try {
            ArrayList<ApkInfo> arrayList = new ArrayList();
            for (ApkInfo apkInfo : a()) {
                if (!e.c(apkInfo.pkgPath) && f.b != null && !f.b.contains(Integer.valueOf(apkInfo.key))) {
                    arrayList.add(apkInfo);
                }
            }
            f a2 = f.a();
            for (ApkInfo apkInfo2 : arrayList) {
                if (a2 != null) {
                    a2.b(apkInfo2.packageName);
                }
                new StringBuilder().append(apkInfo2.packageName).append(this.c.delete("pgn", "k=" + apkInfo2.key, null));
                b.a();
                e.d(this.f.getFilesDir().getCanonicalPath() + "/." + apkInfo2.key);
                if (this.f != null) {
                    e.d(this.f.getFileStreamPath(apkInfo2.packageName).getAbsolutePath());
                }
            }
        } catch (Throwable th) {
            e.a();
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
    public final boolean d(int r12) {
        /*
            r11 = this;
            r8 = 1
            r9 = 0
            r10 = 0
            android.database.sqlite.SQLiteDatabase r0 = r11.c     // Catch: java.lang.Throwable -> L53
            java.lang.String r1 = "pgn"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L53
            r3 = 0
            java.lang.String r4 = "u"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L53
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53
            java.lang.String r4 = "k="
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L53
            java.lang.StringBuilder r3 = r3.append(r12)     // Catch: java.lang.Throwable -> L53
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L53
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L53
            if (r1 == 0) goto L40
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L82
            if (r0 == 0) goto L40
            java.lang.String r0 = "u"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L82
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L82
            if (r0 != r8) goto L4c
            r0 = r8
        L3f:
            r9 = r0
        L40:
            if (r1 == 0) goto L4b
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> L4e
            if (r0 != 0) goto L4b
            r1.close()     // Catch: java.lang.Throwable -> L4e
        L4b:
            return r9
        L4c:
            r0 = r9
            goto L3f
        L4e:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L4b
        L53:
            r0 = move-exception
            r0 = r10
        L55:
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L7e
            if (r0 == 0) goto L4b
            boolean r1 = r0.isClosed()     // Catch: java.lang.Throwable -> L64
            if (r1 != 0) goto L4b
            r0.close()     // Catch: java.lang.Throwable -> L64
            goto L4b
        L64:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L4b
        L69:
            r0 = move-exception
        L6a:
            if (r10 == 0) goto L75
            boolean r1 = r10.isClosed()     // Catch: java.lang.Throwable -> L76
            if (r1 != 0) goto L75
            r10.close()     // Catch: java.lang.Throwable -> L76
        L75:
            throw r0
        L76:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L75
        L7b:
            r0 = move-exception
            r10 = r1
            goto L6a
        L7e:
            r1 = move-exception
            r10 = r0
            r0 = r1
            goto L6a
        L82:
            r0 = move-exception
            r0 = r1
            goto L55
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.c.a.d(int):boolean");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final boolean e(int r12) {
        /*
            r11 = this;
            r8 = 1
            r9 = 0
            r10 = 0
            android.database.sqlite.SQLiteDatabase r0 = r11.c     // Catch: java.lang.Throwable -> L53
            java.lang.String r1 = "pgn"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L53
            r3 = 0
            java.lang.String r4 = "s"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L53
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53
            java.lang.String r4 = "k="
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L53
            java.lang.StringBuilder r3 = r3.append(r12)     // Catch: java.lang.Throwable -> L53
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L53
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L53
            if (r1 == 0) goto L40
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L82
            if (r0 == 0) goto L40
            java.lang.String r0 = "s"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L82
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L82
            if (r0 != r8) goto L4c
            r0 = r8
        L3f:
            r9 = r0
        L40:
            if (r1 == 0) goto L4b
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> L4e
            if (r0 != 0) goto L4b
            r1.close()     // Catch: java.lang.Throwable -> L4e
        L4b:
            return r9
        L4c:
            r0 = r9
            goto L3f
        L4e:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L4b
        L53:
            r0 = move-exception
            r0 = r10
        L55:
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L7e
            if (r0 == 0) goto L4b
            boolean r1 = r0.isClosed()     // Catch: java.lang.Throwable -> L64
            if (r1 != 0) goto L4b
            r0.close()     // Catch: java.lang.Throwable -> L64
            goto L4b
        L64:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L4b
        L69:
            r0 = move-exception
        L6a:
            if (r10 == 0) goto L75
            boolean r1 = r10.isClosed()     // Catch: java.lang.Throwable -> L76
            if (r1 != 0) goto L75
            r10.close()     // Catch: java.lang.Throwable -> L76
        L75:
            throw r0
        L76:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L75
        L7b:
            r0 = move-exception
            r10 = r1
            goto L6a
        L7e:
            r1 = move-exception
            r10 = r0
            r0 = r1
            goto L6a
        L82:
            r0 = move-exception
            r0 = r1
            goto L55
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.c.a.e(int):boolean");
    }

    public final int a(int i, int i2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("u", Integer.valueOf(i2));
            return this.c.update("pgn", contentValues, "k=" + i, null);
        } catch (Throwable th) {
            return 0;
        }
    }

    public final void f(int i) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", (Integer) (-1));
            this.c.update("pgn", contentValues, "k=" + i, null);
        } catch (Throwable th) {
            e.a();
        }
    }

    public final void b(int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("pdld", Integer.valueOf(i2));
        try {
            this.c.update("pgn", contentValues, "k=" + i, null);
        } catch (Throwable th) {
            e.a();
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
    public final int g(int r11) {
        /*
            r10 = this;
            r8 = 0
            r9 = 0
            android.database.sqlite.SQLiteDatabase r0 = r10.c     // Catch: java.lang.Throwable -> L4d
            java.lang.String r1 = "pgn"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L4d
            r3 = 0
            java.lang.String r4 = "pdld"
            r2[r3] = r4     // Catch: java.lang.Throwable -> L4d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d
            java.lang.String r4 = "k="
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L4d
            java.lang.StringBuilder r3 = r3.append(r11)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L4d
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L81
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L7e
            if (r0 == 0) goto L81
            java.lang.String r0 = "pdld"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7e
            int r8 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L7e
            r0 = r8
        L3c:
            if (r1 == 0) goto L47
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> L48
            if (r2 != 0) goto L47
            r1.close()     // Catch: java.lang.Throwable -> L48
        L47:
            return r0
        L48:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L47
        L4d:
            r0 = move-exception
            r0 = r9
        L4f:
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L7a
            if (r0 == 0) goto L5d
            boolean r1 = r0.isClosed()     // Catch: java.lang.Throwable -> L5f
            if (r1 != 0) goto L5d
            r0.close()     // Catch: java.lang.Throwable -> L5f
        L5d:
            r0 = r8
            goto L47
        L5f:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            r0 = r8
            goto L47
        L65:
            r0 = move-exception
        L66:
            if (r9 == 0) goto L71
            boolean r1 = r9.isClosed()     // Catch: java.lang.Throwable -> L72
            if (r1 != 0) goto L71
            r9.close()     // Catch: java.lang.Throwable -> L72
        L71:
            throw r0
        L72:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L71
        L77:
            r0 = move-exception
            r9 = r1
            goto L66
        L7a:
            r1 = move-exception
            r9 = r0
            r0 = r1
            goto L66
        L7e:
            r0 = move-exception
            r0 = r1
            goto L4f
        L81:
            r0 = r8
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.c.a.g(int):int");
    }

    public final void h(int i) {
        new StringBuilder().append(i);
        b.a();
        if (i > 0) {
            try {
                new StringBuilder().append(this.c.delete("pgn", "k=" + i, null));
                b.a();
            } catch (Throwable th) {
                e.a();
            }
        }
    }

    public final void a(int i, String str) {
        new StringBuilder().append(i).append(" v = ").append(str);
        b.a();
        if (i > 0 && !TextUtils.isEmpty(str)) {
            try {
                this.c.delete("pgn", "k=" + i + " and v=?", new String[]{str});
                b.a();
            } catch (Throwable th) {
                e.a();
            }
        }
    }

    public final void c(int i, int i2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Config.PRINCIPAL_PART, Integer.valueOf(i2));
            this.c.update("pgn", contentValues, "k=" + i, null);
        } catch (Throwable th) {
            e.a();
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
    public final com.baidu.sofire.core.ApkInfo b(java.lang.String r11) {
        /*
            r10 = this;
            r9 = 0
            r8 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 == 0) goto La
            r0 = r8
        L9:
            return r0
        La:
            android.database.sqlite.SQLiteDatabase r0 = r10.c     // Catch: java.lang.Throwable -> L1a7
            java.lang.String r1 = "pgn"
            r2 = 0
            java.lang.String r3 = "p=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L1a7
            r5 = 0
            r4[r5] = r11     // Catch: java.lang.Throwable -> L1a7
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L1a7
            if (r1 == 0) goto L1df
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L1d7
            if (r0 == 0) goto L1df
            com.baidu.sofire.core.ApkInfo r2 = new com.baidu.sofire.core.ApkInfo     // Catch: java.lang.Throwable -> L1d7
            r2.<init>()     // Catch: java.lang.Throwable -> L1d7
            java.lang.String r0 = "k"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1db
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1db
            r2.key = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = "n"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1db
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1db
            r2.initStatus = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = "p"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1db
            r2.packageName = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = "a"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1db
            r2.pkgPath = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = "l"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1db
            r2.libPath = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = "v"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1db
            r2.versionName = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = "apk"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1db
            r2.dexPath = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = "ap"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1db
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1db
            r2.apkParseSuc = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = "cl"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1db
            r2.className = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = "th"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1db
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1db
            r2.applicationTheme = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = "st"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1db
            long r4 = r1.getLong(r0)     // Catch: java.lang.Throwable -> L1db
            r2.startTime = r4     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = "du"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1db
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1db
            r2.duration = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = "m5"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1db
            r2.apkMD5 = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = "pr"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1db
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1db
            r2.priority = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = "ac"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1db
            byte[] r0 = r1.getBlob(r0)     // Catch: java.lang.Throwable -> L1db
            if (r0 == 0) goto L193
            java.util.ArrayList r4 = com.baidu.sofire.core.a.a(r0)     // Catch: java.lang.Throwable -> L1db
            if (r4 == 0) goto L193
            int r5 = r4.size()     // Catch: java.lang.Throwable -> L1db
            if (r5 <= 0) goto L193
            android.content.pm.ActivityInfo[] r0 = new android.content.pm.ActivityInfo[r5]     // Catch: java.lang.Throwable -> L1db
            r2.activities = r0     // Catch: java.lang.Throwable -> L1db
            r3 = r9
        L101:
            if (r3 >= r5) goto L193
            android.content.pm.ActivityInfo r6 = new android.content.pm.ActivityInfo     // Catch: java.lang.Throwable -> L1db
            r6.<init>()     // Catch: java.lang.Throwable -> L1db
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1db
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1db
            int r0 = r0.f3604a     // Catch: java.lang.Throwable -> L1db
            r6.theme = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1db
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = r0.j     // Catch: java.lang.Throwable -> L1db
            r6.name = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1db
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1db
            int r0 = r0.h     // Catch: java.lang.Throwable -> L1db
            r6.configChanges = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1db
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1db
            int r0 = r0.f     // Catch: java.lang.Throwable -> L1db
            r6.flags = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1db
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1db
            int r0 = r0.l     // Catch: java.lang.Throwable -> L1db
            r6.labelRes = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1db
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1db
            int r0 = r0.b     // Catch: java.lang.Throwable -> L1db
            r6.launchMode = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1db
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = r0.m     // Catch: java.lang.Throwable -> L1db
            r6.nonLocalizedLabel = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1db
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = r0.k     // Catch: java.lang.Throwable -> L1db
            r6.packageName = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1db
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = r0.c     // Catch: java.lang.Throwable -> L1db
            r6.permission = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1db
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1db
            int r0 = r0.g     // Catch: java.lang.Throwable -> L1db
            r6.screenOrientation = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1db
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1db
            int r0 = r0.i     // Catch: java.lang.Throwable -> L1db
            r6.softInputMode = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1db
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = r0.e     // Catch: java.lang.Throwable -> L1db
            r6.targetActivity = r0     // Catch: java.lang.Throwable -> L1db
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1db
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1db
            java.lang.String r0 = r0.d     // Catch: java.lang.Throwable -> L1db
            r6.taskAffinity = r0     // Catch: java.lang.Throwable -> L1db
            android.content.pm.ActivityInfo[] r0 = r2.activities     // Catch: java.lang.Throwable -> L1db
            r0[r3] = r6     // Catch: java.lang.Throwable -> L1db
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
            com.baidu.sofire.i.e.a()
            goto L9
        L1a7:
            r0 = move-exception
            r0 = r8
        L1a9:
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L1d4
            if (r8 == 0) goto L9
            boolean r1 = r8.isClosed()     // Catch: java.lang.Throwable -> L1b9
            if (r1 != 0) goto L9
            r8.close()     // Catch: java.lang.Throwable -> L1b9
            goto L9
        L1b9:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L9
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
            com.baidu.sofire.i.e.a()
            goto L1cc
        L1d2:
            r0 = move-exception
            goto L1c1
        L1d4:
            r0 = move-exception
            r1 = r8
            goto L1c1
        L1d7:
            r0 = move-exception
            r0 = r8
            r8 = r1
            goto L1a9
        L1db:
            r0 = move-exception
            r8 = r1
            r0 = r2
            goto L1a9
        L1df:
            r0 = r8
            goto L194
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.c.a.b(java.lang.String):com.baidu.sofire.core.ApkInfo");
    }
}
