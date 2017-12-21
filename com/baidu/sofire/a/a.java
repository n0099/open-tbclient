package com.baidu.sofire.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.sofire.b.d;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class a {
    public static a Qi;
    private C0048a Qg;
    public SQLiteDatabase Qh;
    int a = 5;
    String b = "create table pgn(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,la INTEGER,o INTEGER,r INTEGER,ap INTEGER,apk TEXT,cl TEXT,b TEXT,t TEXT,ac BLOB,st INTEGER,du INTEGER,th INTEGER,m5 TEXT,rs INTEGER,l TEXT,pr INTEGER DEFAULT -1,pdld INTEGER DEFAULT 0,a TEXT)";
    private Context f;

    private a(Context context) {
        this.f = context.getApplicationContext();
        this.Qg = new C0048a(context.getApplicationContext());
        try {
            this.Qh = this.Qg.getWritableDatabase();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static synchronized a an(Context context) {
        a aVar;
        synchronized (a.class) {
            new StringBuilder("i=").append(Qi);
            if (Qi == null) {
                Qi = new a(context);
            }
            aVar = Qi;
        }
        return aVar;
    }

    /* renamed from: com.baidu.sofire.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0048a extends SQLiteOpenHelper {
        public C0048a(Context context) {
            super(context, "tpgcc.db", (SQLiteDatabase.CursorFactory) null, a.this.a);
            new StringBuilder().append(a.this.a);
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
                new StringBuilder("o=").append(i).append(", n=").append(i2);
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
            contentValues.put("th", Integer.valueOf(apkInfo.applicationTheme));
            contentValues.put("pr", Integer.valueOf(apkInfo.priority));
            if (apkInfo.activities != null) {
                contentValues.put("ac", new com.baidu.sofire.core.a(apkInfo.activities).a());
            }
            try {
                if (b(apkInfo.key)) {
                    j = this.Qh.update("pgn", contentValues, "k=" + apkInfo.key, null);
                } else {
                    contentValues.put("k", Integer.valueOf(apkInfo.key));
                    j = this.Qh.insert("pgn", null, contentValues);
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
            cursor = this.Qh.query("pgn", null, null, null, null, null, null);
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

    public final Map<Integer, String> b() {
        Cursor cursor;
        HashMap hashMap = new HashMap();
        try {
            cursor = this.Qh.query("pgn", null, "n=1", null, null, null, null);
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

    public final Map<Integer, String> c() {
        Cursor cursor;
        HashMap hashMap = new HashMap();
        try {
            cursor = this.Qh.query("pgn", null, "n=1", null, null, null, null);
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
    public final com.baidu.sofire.core.ApkInfo aV(int r11) {
        /*
            r10 = this;
            r8 = 0
            android.database.sqlite.SQLiteDatabase r0 = r10.Qh     // Catch: java.lang.Throwable -> L19a
            java.lang.String r1 = "pgn"
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L19a
            java.lang.String r4 = "k="
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L19a
            java.lang.StringBuilder r3 = r3.append(r11)     // Catch: java.lang.Throwable -> L19a
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L19a
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L19a
            if (r1 == 0) goto L1d5
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L1ca
            if (r0 == 0) goto L1d5
            com.baidu.sofire.core.ApkInfo r2 = new com.baidu.sofire.core.ApkInfo     // Catch: java.lang.Throwable -> L1ca
            r2.<init>()     // Catch: java.lang.Throwable -> L1ca
            r2.key = r11     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = "n"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1cf
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1cf
            r2.initStatus = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = "p"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1cf
            r2.packageName = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = "a"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1cf
            r2.pkgPath = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = "l"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1cf
            r2.libPath = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = "v"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1cf
            r2.versionName = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = "apk"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1cf
            r2.dexPath = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = "ap"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1cf
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1cf
            r2.apkParseSuc = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = "cl"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1cf
            r2.className = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = "th"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1cf
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1cf
            r2.applicationTheme = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = "st"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1cf
            long r4 = r1.getLong(r0)     // Catch: java.lang.Throwable -> L1cf
            r2.startTime = r4     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = "du"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1cf
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1cf
            r2.duration = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = "m5"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L1cf
            r2.apkMD5 = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = "pr"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1cf
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1cf
            r2.priority = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = "ac"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1cf
            byte[] r0 = r1.getBlob(r0)     // Catch: java.lang.Throwable -> L1cf
            if (r0 == 0) goto L188
            java.util.ArrayList r4 = com.baidu.sofire.core.a.a(r0)     // Catch: java.lang.Throwable -> L1cf
            if (r4 == 0) goto L188
            int r5 = r4.size()     // Catch: java.lang.Throwable -> L1cf
            if (r5 <= 0) goto L188
            android.content.pm.ActivityInfo[] r0 = new android.content.pm.ActivityInfo[r5]     // Catch: java.lang.Throwable -> L1cf
            r2.activities = r0     // Catch: java.lang.Throwable -> L1cf
            r0 = 0
            r3 = r0
        Lf6:
            if (r3 >= r5) goto L188
            android.content.pm.ActivityInfo r6 = new android.content.pm.ActivityInfo     // Catch: java.lang.Throwable -> L1cf
            r6.<init>()     // Catch: java.lang.Throwable -> L1cf
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1cf
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1cf
            int r0 = r0.a     // Catch: java.lang.Throwable -> L1cf
            r6.theme = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1cf
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = r0.j     // Catch: java.lang.Throwable -> L1cf
            r6.name = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1cf
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1cf
            int r0 = r0.h     // Catch: java.lang.Throwable -> L1cf
            r6.configChanges = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1cf
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1cf
            int r0 = r0.f     // Catch: java.lang.Throwable -> L1cf
            r6.flags = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1cf
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1cf
            int r0 = r0.l     // Catch: java.lang.Throwable -> L1cf
            r6.labelRes = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1cf
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1cf
            int r0 = r0.b     // Catch: java.lang.Throwable -> L1cf
            r6.launchMode = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1cf
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = r0.m     // Catch: java.lang.Throwable -> L1cf
            r6.nonLocalizedLabel = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1cf
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = r0.k     // Catch: java.lang.Throwable -> L1cf
            r6.packageName = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1cf
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = r0.c     // Catch: java.lang.Throwable -> L1cf
            r6.permission = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1cf
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1cf
            int r0 = r0.g     // Catch: java.lang.Throwable -> L1cf
            r6.screenOrientation = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1cf
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1cf
            int r0 = r0.i     // Catch: java.lang.Throwable -> L1cf
            r6.softInputMode = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1cf
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = r0.e     // Catch: java.lang.Throwable -> L1cf
            r6.targetActivity = r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.Object r0 = r4.get(r3)     // Catch: java.lang.Throwable -> L1cf
            com.baidu.sofire.core.b r0 = (com.baidu.sofire.core.b) r0     // Catch: java.lang.Throwable -> L1cf
            java.lang.String r0 = r0.d     // Catch: java.lang.Throwable -> L1cf
            r6.taskAffinity = r0     // Catch: java.lang.Throwable -> L1cf
            android.content.pm.ActivityInfo[] r0 = r2.activities     // Catch: java.lang.Throwable -> L1cf
            r0[r3] = r6     // Catch: java.lang.Throwable -> L1cf
            int r0 = r3 + 1
            r3 = r0
            goto Lf6
        L188:
            r0 = r2
        L189:
            if (r1 == 0) goto L194
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> L195
            if (r2 != 0) goto L194
            r1.close()     // Catch: java.lang.Throwable -> L195
        L194:
            return r0
        L195:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L194
        L19a:
            r0 = move-exception
            r1 = r0
            r2 = r8
            r0 = r8
        L19e:
            com.baidu.sofire.b.d.a(r1)     // Catch: java.lang.Throwable -> L1c7
            if (r2 == 0) goto L194
            boolean r1 = r2.isClosed()     // Catch: java.lang.Throwable -> L1ad
            if (r1 != 0) goto L194
            r2.close()     // Catch: java.lang.Throwable -> L1ad
            goto L194
        L1ad:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L194
        L1b2:
            r0 = move-exception
            r1 = r8
        L1b4:
            if (r1 == 0) goto L1bf
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> L1c0
            if (r2 != 0) goto L1bf
            r1.close()     // Catch: java.lang.Throwable -> L1c0
        L1bf:
            throw r0
        L1c0:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L1bf
        L1c5:
            r0 = move-exception
            goto L1b4
        L1c7:
            r0 = move-exception
            r1 = r2
            goto L1b4
        L1ca:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r8
            goto L19e
        L1cf:
            r0 = move-exception
            r9 = r0
            r0 = r2
            r2 = r1
            r1 = r9
            goto L19e
        L1d5:
            r0 = r8
            goto L189
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.a.a.aV(int):com.baidu.sofire.core.ApkInfo");
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
            cursor = this.Qh.query("pgn", new String[]{"p"}, "k=" + i, null, null, null, null);
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
            cursor = this.Qh.query("pgn", new String[]{"n"}, "k=" + i, null, null, null, null);
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
        new StringBuilder().append(str);
        if (!TextUtils.isEmpty(str)) {
            try {
                this.Qh.delete("pgn", "p=?", new String[]{str});
            } catch (Throwable th) {
                d.a(th);
            }
        }
    }

    public final void d() {
        try {
            ArrayList<ApkInfo> arrayList = new ArrayList();
            for (ApkInfo apkInfo : a()) {
                if (!d.a(apkInfo.pkgPath) && e.b != null && !e.b.contains(Integer.valueOf(apkInfo.key))) {
                    arrayList.add(apkInfo);
                }
            }
            e no = e.no();
            for (ApkInfo apkInfo2 : arrayList) {
                if (no != null) {
                    no.b(apkInfo2.packageName);
                }
                new StringBuilder().append(apkInfo2.packageName).append(this.Qh.delete("pgn", "k=" + apkInfo2.key, null));
                d.b(this.f.getFilesDir().getCanonicalPath() + "/." + apkInfo2.key);
                if (this.f != null) {
                    d.b(this.f.getFileStreamPath(apkInfo2.packageName).getAbsolutePath());
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final boolean aW(int i) {
        Cursor cursor;
        boolean z = false;
        try {
            Cursor cursor2 = this.Qh.query("pgn", new String[]{"u"}, "k=" + i, null, null, null, null);
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

    public final boolean aX(int i) {
        Cursor cursor;
        boolean z = false;
        try {
            Cursor cursor2 = this.Qh.query("pgn", new String[]{"s"}, "k=" + i, null, null, null, null);
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
            return this.Qh.update("pgn", contentValues, "k=" + i, null);
        } catch (Throwable th) {
            return 0;
        }
    }

    public final void f(int i) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", (Integer) (-1));
            this.Qh.update("pgn", contentValues, "k=" + i, null);
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
            android.database.sqlite.SQLiteDatabase r0 = r11.Qh     // Catch: java.lang.Throwable -> L84
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

    public final void b(int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("pdld", Integer.valueOf(i2));
        try {
            this.Qh.update("pgn", contentValues, "k=" + i, null);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int aY(int i) {
        Cursor cursor;
        int i2;
        try {
            cursor = this.Qh.query("pgn", new String[]{"pdld"}, "k=" + i, null, null, null, null);
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

    public final void h(int i) {
        new StringBuilder().append(i);
        if (i > 0) {
            try {
                new StringBuilder().append(this.Qh.delete("pgn", "k=" + i, null));
            } catch (Throwable th) {
                d.a(th);
            }
        }
    }

    public final void t(int i, int i2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("pr", Integer.valueOf(i2));
            this.Qh.update("pgn", contentValues, "k=" + i, null);
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
    public final com.baidu.sofire.core.ApkInfo bV(java.lang.String r12) {
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
            android.database.sqlite.SQLiteDatabase r0 = r11.Qh     // Catch: java.lang.Throwable -> L1a7
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
            com.baidu.sofire.b.d.a(r1)
            goto L9
        L1a7:
            r0 = move-exception
            r1 = r0
            r0 = r8
        L1aa:
            com.baidu.sofire.b.d.a(r1)     // Catch: java.lang.Throwable -> L1d5
            if (r8 == 0) goto L9
            boolean r1 = r8.isClosed()     // Catch: java.lang.Throwable -> L1ba
            if (r1 != 0) goto L9
            r8.close()     // Catch: java.lang.Throwable -> L1ba
            goto L9
        L1ba:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
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
            com.baidu.sofire.b.d.a(r1)
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.a.a.bV(java.lang.String):com.baidu.sofire.core.ApkInfo");
    }
}
