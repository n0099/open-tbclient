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
/* loaded from: classes14.dex */
public final class a {
    public static a d;

    /* renamed from: a  reason: collision with root package name */
    int f5200a = 5;

    /* renamed from: b  reason: collision with root package name */
    String f5201b = "create table pgn(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,la INTEGER,o INTEGER,r INTEGER,ap INTEGER,apk TEXT,cl TEXT,b TEXT,t TEXT,ac BLOB,st INTEGER,du INTEGER,th INTEGER,m5 TEXT,rs INTEGER,l TEXT,pr INTEGER DEFAULT -1,pdld INTEGER DEFAULT 0,a TEXT)";
    public SQLiteDatabase c;
    private C0343a e;
    private Context f;

    private a(Context context) {
        b.a();
        this.f = context.getApplicationContext();
        this.e = new C0343a(context.getApplicationContext());
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
    /* loaded from: classes14.dex */
    private class C0343a extends SQLiteOpenHelper {
        public C0343a(Context context) {
            super(context, "tpgcc.db", (SQLiteDatabase.CursorFactory) null, a.this.f5200a);
            new StringBuilder().append(a.this.f5200a);
            b.a();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(a.this.f5201b);
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
                            activityInfo.theme = a2.get(i2).f5206a;
                            activityInfo.name = a2.get(i2).j;
                            activityInfo.configChanges = a2.get(i2).h;
                            activityInfo.flags = a2.get(i2).f;
                            activityInfo.labelRes = a2.get(i2).l;
                            activityInfo.launchMode = a2.get(i2).f5207b;
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
            if (r1 == 0) goto L79
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L76
            if (r0 <= 0) goto L79
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
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L72
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
            r2 = r0
        L5d:
            if (r9 == 0) goto L68
            boolean r0 = r9.isClosed()     // Catch: java.lang.Throwable -> L69
            if (r0 != 0) goto L68
            r9.close()     // Catch: java.lang.Throwable -> L69
        L68:
            throw r2
        L69:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L68
        L6e:
            r0 = move-exception
            r2 = r0
            r9 = r1
            goto L5d
        L72:
            r1 = move-exception
            r2 = r1
            r9 = r0
            goto L5d
        L76:
            r0 = move-exception
            r0 = r1
            goto L45
        L79:
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
            if (r1 == 0) goto L83
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L80
            if (r0 == 0) goto L83
            java.lang.String r0 = "n"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L80
            int r8 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L80
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
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L7c
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
            r2 = r0
        L67:
            if (r9 == 0) goto L72
            boolean r0 = r9.isClosed()     // Catch: java.lang.Throwable -> L73
            if (r0 != 0) goto L72
            r9.close()     // Catch: java.lang.Throwable -> L73
        L72:
            throw r2
        L73:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L72
        L78:
            r0 = move-exception
            r2 = r0
            r9 = r1
            goto L67
        L7c:
            r1 = move-exception
            r2 = r1
            r9 = r0
            goto L67
        L80:
            r0 = move-exception
            r0 = r1
            goto L4f
        L83:
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
                if (!e.c(apkInfo.pkgPath) && f.f5228b != null && !f.f5228b.contains(Integer.valueOf(apkInfo.key))) {
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
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L84
            if (r0 == 0) goto L40
            java.lang.String r0 = "u"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L84
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L84
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
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L80
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
            r2 = r0
        L6b:
            if (r10 == 0) goto L76
            boolean r0 = r10.isClosed()     // Catch: java.lang.Throwable -> L77
            if (r0 != 0) goto L76
            r10.close()     // Catch: java.lang.Throwable -> L77
        L76:
            throw r2
        L77:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L76
        L7c:
            r0 = move-exception
            r2 = r0
            r10 = r1
            goto L6b
        L80:
            r1 = move-exception
            r2 = r1
            r10 = r0
            goto L6b
        L84:
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
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L84
            if (r0 == 0) goto L40
            java.lang.String r0 = "s"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L84
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L84
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
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L80
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
            r2 = r0
        L6b:
            if (r10 == 0) goto L76
            boolean r0 = r10.isClosed()     // Catch: java.lang.Throwable -> L77
            if (r0 != 0) goto L76
            r10.close()     // Catch: java.lang.Throwable -> L77
        L76:
            throw r2
        L77:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L76
        L7c:
            r0 = move-exception
            r2 = r0
            r10 = r1
            goto L6b
        L80:
            r1 = move-exception
            r2 = r1
            r10 = r0
            goto L6b
        L84:
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
            if (r1 == 0) goto L83
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L80
            if (r0 == 0) goto L83
            java.lang.String r0 = "pdld"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L80
            int r8 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L80
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
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L7c
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
            r2 = r0
        L67:
            if (r9 == 0) goto L72
            boolean r0 = r9.isClosed()     // Catch: java.lang.Throwable -> L73
            if (r0 != 0) goto L72
            r9.close()     // Catch: java.lang.Throwable -> L73
        L72:
            throw r2
        L73:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L72
        L78:
            r0 = move-exception
            r2 = r0
            r9 = r1
            goto L67
        L7c:
            r1 = move-exception
            r2 = r1
            r9 = r0
            goto L67
        L80:
            r0 = move-exception
            r0 = r1
            goto L4f
        L83:
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

    /* JADX WARN: Removed duplicated region for block: B:61:0x0196 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ApkInfo b(String str) {
        Cursor cursor;
        ApkInfo apkInfo;
        ApkInfo apkInfo2;
        ArrayList<com.baidu.sofire.core.b> a2;
        int size;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            cursor = this.c.query("pgn", null, "p=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        ApkInfo apkInfo3 = new ApkInfo();
                        try {
                            apkInfo3.key = cursor.getInt(cursor.getColumnIndex("k"));
                            apkInfo3.initStatus = cursor.getInt(cursor.getColumnIndex("n"));
                            apkInfo3.packageName = cursor.getString(cursor.getColumnIndex("p"));
                            apkInfo3.pkgPath = cursor.getString(cursor.getColumnIndex("a"));
                            apkInfo3.libPath = cursor.getString(cursor.getColumnIndex("l"));
                            apkInfo3.versionName = cursor.getString(cursor.getColumnIndex("v"));
                            apkInfo3.dexPath = cursor.getString(cursor.getColumnIndex("apk"));
                            apkInfo3.apkParseSuc = cursor.getInt(cursor.getColumnIndex("ap"));
                            apkInfo3.className = cursor.getString(cursor.getColumnIndex(Config.CELL_LOCATION));
                            apkInfo3.applicationTheme = cursor.getInt(cursor.getColumnIndex("th"));
                            apkInfo3.startTime = cursor.getLong(cursor.getColumnIndex("st"));
                            apkInfo3.duration = cursor.getInt(cursor.getColumnIndex("du"));
                            apkInfo3.apkMD5 = cursor.getString(cursor.getColumnIndex("m5"));
                            apkInfo3.priority = cursor.getInt(cursor.getColumnIndex(Config.PRINCIPAL_PART));
                            byte[] blob = cursor.getBlob(cursor.getColumnIndex("ac"));
                            if (blob != null && (a2 = com.baidu.sofire.core.a.a(blob)) != null && (size = a2.size()) > 0) {
                                apkInfo3.activities = new ActivityInfo[size];
                                for (int i = 0; i < size; i++) {
                                    ActivityInfo activityInfo = new ActivityInfo();
                                    activityInfo.theme = a2.get(i).f5206a;
                                    activityInfo.name = a2.get(i).j;
                                    activityInfo.configChanges = a2.get(i).h;
                                    activityInfo.flags = a2.get(i).f;
                                    activityInfo.labelRes = a2.get(i).l;
                                    activityInfo.launchMode = a2.get(i).f5207b;
                                    activityInfo.nonLocalizedLabel = a2.get(i).m;
                                    activityInfo.packageName = a2.get(i).k;
                                    activityInfo.permission = a2.get(i).c;
                                    activityInfo.screenOrientation = a2.get(i).g;
                                    activityInfo.softInputMode = a2.get(i).i;
                                    activityInfo.targetActivity = a2.get(i).e;
                                    activityInfo.taskAffinity = a2.get(i).d;
                                    apkInfo3.activities[i] = activityInfo;
                                }
                            }
                            apkInfo2 = apkInfo3;
                            if (cursor == null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                        return apkInfo2;
                                    }
                                    return apkInfo2;
                                } catch (Throwable th) {
                                    e.a();
                                    return apkInfo2;
                                }
                            }
                            return apkInfo2;
                        } catch (Throwable th2) {
                            apkInfo = apkInfo3;
                            try {
                                e.a();
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                            return apkInfo;
                                        }
                                        return apkInfo;
                                    } catch (Throwable th3) {
                                        e.a();
                                        return apkInfo;
                                    }
                                }
                                return apkInfo;
                            } catch (Throwable th4) {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable th5) {
                                        e.a();
                                    }
                                }
                                throw th4;
                            }
                        }
                    }
                } catch (Throwable th6) {
                    apkInfo = null;
                }
            }
            apkInfo2 = null;
            if (cursor == null) {
            }
        } catch (Throwable th7) {
            cursor = null;
            apkInfo = null;
        }
    }
}
