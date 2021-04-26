package com.baidu.sofire.a;

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
import com.baidu.sofire.g.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static a f11111d;

    /* renamed from: a  reason: collision with root package name */
    public int f11112a = 5;

    /* renamed from: b  reason: collision with root package name */
    public String f11113b = "create table pgn(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,la INTEGER,o INTEGER,r INTEGER,ap INTEGER,apk TEXT,cl TEXT,b TEXT,t TEXT,ac BLOB,st INTEGER,du INTEGER,th INTEGER,m5 TEXT,rs INTEGER,l TEXT,pr INTEGER DEFAULT -1,pdld INTEGER DEFAULT 0,a TEXT)";

    /* renamed from: c  reason: collision with root package name */
    public SQLiteDatabase f11114c;

    /* renamed from: e  reason: collision with root package name */
    public C0152a f11115e;

    /* renamed from: f  reason: collision with root package name */
    public Context f11116f;

    /* renamed from: com.baidu.sofire.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0152a extends SQLiteOpenHelper {
        public C0152a(Context context) {
            super(context, "tpgcc.db", (SQLiteDatabase.CursorFactory) null, a.this.f11112a);
            new StringBuilder().append(a.this.f11112a);
            b.a();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(a.this.f11113b);
            } catch (Throwable unused) {
                d.a();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            try {
                StringBuilder sb = new StringBuilder("o=");
                sb.append(i2);
                sb.append(", n=");
                sb.append(i3);
                b.a();
                if (i2 < 3 && i3 >= 3) {
                    sQLiteDatabase.beginTransaction();
                    try {
                        sQLiteDatabase.execSQL("ALTER TABLE pgn ADD COLUMN pr INTEGER  DEFAULT -1");
                        sQLiteDatabase.setTransactionSuccessful();
                    } catch (Throwable unused) {
                        d.a();
                    }
                    sQLiteDatabase.endTransaction();
                }
                if (i2 < 5 && i3 >= 5) {
                    sQLiteDatabase.beginTransaction();
                    try {
                        sQLiteDatabase.execSQL("ALTER TABLE pgn ADD COLUMN pdld INTEGER  DEFAULT -1");
                        sQLiteDatabase.setTransactionSuccessful();
                    } catch (Throwable unused2) {
                        d.a();
                    }
                    sQLiteDatabase.endTransaction();
                }
                if (i2 >= 4 || i3 < 4) {
                    return;
                }
                sQLiteDatabase.execSQL("drop table if exists tbch");
            } catch (Throwable unused3) {
                d.a();
            }
        }
    }

    public a(Context context) {
        b.a();
        this.f11116f = context.getApplicationContext();
        C0152a c0152a = new C0152a(context.getApplicationContext());
        this.f11115e = c0152a;
        try {
            this.f11114c = c0152a.getWritableDatabase();
        } catch (Throwable unused) {
            d.a();
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            new StringBuilder("i=").append(f11111d);
            b.a();
            if (f11111d == null) {
                f11111d = new a(context);
            }
            aVar = f11111d;
        }
        return aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0050, code lost:
        if (r2.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005d, code lost:
        if (r2.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
        r2.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<Integer, String> b() {
        Cursor cursor;
        HashMap hashMap = new HashMap();
        try {
            try {
                cursor = this.f11114c.query("pgn", null, "n=1", null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            int i2 = cursor.getInt(cursor.getColumnIndex(Config.APP_KEY));
                            String string = cursor.getString(cursor.getColumnIndex("v"));
                            Integer valueOf = Integer.valueOf(i2);
                            hashMap.put(valueOf, "'" + string + "'");
                        } catch (Throwable unused) {
                            try {
                                d.a();
                                if (cursor != null) {
                                }
                                return hashMap;
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        d.a();
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable unused3) {
                d.a();
            }
        } catch (Throwable unused4) {
            cursor = null;
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
        if (r1.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
        if (r1.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<Integer, String> c() {
        Cursor cursor;
        HashMap hashMap = new HashMap();
        try {
            try {
                cursor = this.f11114c.query("pgn", null, "n=1", null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            int i2 = cursor.getInt(cursor.getColumnIndex(Config.APP_KEY));
                            hashMap.put(Integer.valueOf(i2), cursor.getString(cursor.getColumnIndex("p")));
                        } catch (Throwable unused) {
                            try {
                                d.a();
                                if (cursor != null) {
                                }
                                return hashMap;
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        d.a();
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable unused3) {
                d.a();
            }
        } catch (Throwable unused4) {
            cursor = null;
        }
        return hashMap;
    }

    public final void d() {
        try {
            ArrayList<ApkInfo> arrayList = new ArrayList();
            for (ApkInfo apkInfo : a()) {
                if (!d.c(apkInfo.pkgPath) && f.f11190b != null && !f.f11190b.contains(Integer.valueOf(apkInfo.key))) {
                    arrayList.add(apkInfo);
                }
            }
            f a2 = f.a();
            for (ApkInfo apkInfo2 : arrayList) {
                if (a2 != null) {
                    a2.b(apkInfo2.packageName);
                }
                SQLiteDatabase sQLiteDatabase = this.f11114c;
                int delete = sQLiteDatabase.delete("pgn", "k=" + apkInfo2.key, null);
                StringBuilder sb = new StringBuilder();
                sb.append(apkInfo2.packageName);
                sb.append(delete);
                b.a();
                d.d(this.f11116f.getFilesDir().getCanonicalPath() + "/." + apkInfo2.key);
                if (this.f11116f != null) {
                    d.d(this.f11116f.getFileStreamPath(apkInfo2.packageName).getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
            d.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003b, code lost:
        if (r11.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
        if (r11.isClosed() == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean e(int i2) {
        Cursor cursor;
        boolean z = false;
        try {
            try {
                cursor = this.f11114c.query("pgn", new String[]{"s"}, "k=" + i2, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            if (cursor.getInt(cursor.getColumnIndex("s")) == 1) {
                                z = true;
                            }
                        }
                    } catch (Throwable unused) {
                        try {
                            d.a();
                            if (cursor != null) {
                            }
                            return z;
                        } catch (Throwable th) {
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable unused2) {
                                    d.a();
                                }
                            }
                            throw th;
                        }
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable unused3) {
                d.a();
            }
        } catch (Throwable unused4) {
            cursor = null;
        }
        return z;
    }

    public final void f(int i2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", (Integer) (-1));
            SQLiteDatabase sQLiteDatabase = this.f11114c;
            sQLiteDatabase.update("pgn", contentValues, "k=" + i2, null);
        } catch (Throwable unused) {
            d.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (r11.isClosed() == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r11.isClosed() == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int g(int i2) {
        Cursor cursor;
        int i3 = 0;
        try {
            try {
                cursor = this.f11114c.query("pgn", new String[]{"pdld"}, "k=" + i2, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            i3 = cursor.getInt(cursor.getColumnIndex("pdld"));
                        }
                    } catch (Throwable unused) {
                        try {
                            d.a();
                            if (cursor != null) {
                            }
                            return i3;
                        } catch (Throwable th) {
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable unused2) {
                                    d.a();
                                }
                            }
                            throw th;
                        }
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable unused3) {
                cursor = null;
            }
        } catch (Throwable unused4) {
            d.a();
        }
        return i3;
    }

    public final void h(int i2) {
        new StringBuilder().append(i2);
        b.a();
        if (i2 <= 0) {
            return;
        }
        try {
            SQLiteDatabase sQLiteDatabase = this.f11114c;
            new StringBuilder().append(sQLiteDatabase.delete("pgn", "k=" + i2, null));
            b.a();
        } catch (Throwable unused) {
            d.a();
        }
    }

    public final long a(ApkInfo apkInfo) {
        long j = 0;
        if (apkInfo == null) {
            return 0L;
        }
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
        ActivityInfo[] activityInfoArr = apkInfo.activities;
        if (activityInfoArr != null) {
            contentValues.put("ac", new com.baidu.sofire.core.a(activityInfoArr).a());
        }
        try {
            if (b(apkInfo.key)) {
                j = this.f11114c.update("pgn", contentValues, "k=" + apkInfo.key, null);
            } else {
                contentValues.put(Config.APP_KEY, Integer.valueOf(apkInfo.key));
                j = this.f11114c.insert("pgn", null, contentValues);
            }
        } catch (Throwable unused) {
        }
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
        if (r10.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        if (r10.isClosed() == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(int i2) {
        Cursor cursor;
        boolean z = false;
        try {
            try {
                cursor = this.f11114c.query("pgn", new String[]{"p"}, "k=" + i2, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0) {
                            z = true;
                        }
                    } catch (Throwable unused) {
                        try {
                            d.a();
                            if (cursor != null) {
                            }
                            return z;
                        } catch (Throwable th) {
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable unused2) {
                                    d.a();
                                }
                            }
                            throw th;
                        }
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable unused3) {
                d.a();
            }
        } catch (Throwable unused4) {
            cursor = null;
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (r11.isClosed() == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r11.isClosed() == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int c(int i2) {
        Cursor cursor;
        int i3 = 0;
        try {
            try {
                cursor = this.f11114c.query("pgn", new String[]{"n"}, "k=" + i2, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            i3 = cursor.getInt(cursor.getColumnIndex("n"));
                        }
                    } catch (Throwable unused) {
                        try {
                            d.a();
                            if (cursor != null) {
                            }
                            return i3;
                        } catch (Throwable th) {
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable unused2) {
                                    d.a();
                                }
                            }
                            throw th;
                        }
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable unused3) {
                cursor = null;
            }
        } catch (Throwable unused4) {
            d.a();
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
        if (r11.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
        if (r11.isClosed() == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean d(int i2) {
        Cursor cursor;
        boolean z = false;
        try {
            try {
                cursor = this.f11114c.query("pgn", new String[]{"u"}, "k=" + i2, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            if (cursor.getInt(cursor.getColumnIndex("u")) == 1) {
                                z = true;
                            }
                        }
                    } catch (Throwable unused) {
                        try {
                            d.a();
                            if (cursor != null) {
                            }
                            return z;
                        } catch (Throwable th) {
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable unused2) {
                                    d.a();
                                }
                            }
                            throw th;
                        }
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable unused3) {
                d.a();
            }
        } catch (Throwable unused4) {
            cursor = null;
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x008c, code lost:
        if (r1.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0099, code lost:
        if (r1.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x009b, code lost:
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<ApkInfo> a() {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                cursor = this.f11114c.query("pgn", null, null, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            ApkInfo apkInfo = new ApkInfo();
                            apkInfo.key = cursor.getInt(cursor.getColumnIndex(Config.APP_KEY));
                            apkInfo.packageName = cursor.getString(cursor.getColumnIndex("p"));
                            apkInfo.pkgPath = cursor.getString(cursor.getColumnIndex("a"));
                            apkInfo.libPath = cursor.getString(cursor.getColumnIndex("l"));
                            apkInfo.versionName = cursor.getString(cursor.getColumnIndex("v"));
                            apkInfo.startTime = cursor.getLong(cursor.getColumnIndex("st"));
                            apkInfo.duration = cursor.getInt(cursor.getColumnIndex("du"));
                            apkInfo.priority = cursor.getInt(cursor.getColumnIndex(Config.PRINCIPAL_PART));
                            arrayList.add(apkInfo);
                        } catch (Throwable unused) {
                            try {
                                d.a();
                                if (cursor != null) {
                                }
                                return arrayList;
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        d.a();
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable unused3) {
                d.a();
            }
        } catch (Throwable unused4) {
            cursor = null;
        }
        return arrayList;
    }

    public final void b(int i2, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("pdld", Integer.valueOf(i3));
        try {
            SQLiteDatabase sQLiteDatabase = this.f11114c;
            sQLiteDatabase.update("pgn", contentValues, "k=" + i2, null);
        } catch (Throwable unused) {
            d.a();
        }
    }

    public final void c(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Config.PRINCIPAL_PART, Integer.valueOf(i3));
            SQLiteDatabase sQLiteDatabase = this.f11114c;
            sQLiteDatabase.update("pgn", contentValues, "k=" + i2, null);
        } catch (Throwable unused) {
            d.a();
        }
    }

    public final ApkInfo b(String str) {
        ApkInfo apkInfo;
        ArrayList<com.baidu.sofire.core.b> a2;
        int size;
        Cursor cursor = null;
        r1 = null;
        ApkInfo apkInfo2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Cursor query = this.f11114c.query("pgn", null, "p=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        apkInfo = new ApkInfo();
                        try {
                            apkInfo.key = query.getInt(query.getColumnIndex(Config.APP_KEY));
                            apkInfo.initStatus = query.getInt(query.getColumnIndex("n"));
                            apkInfo.packageName = query.getString(query.getColumnIndex("p"));
                            apkInfo.pkgPath = query.getString(query.getColumnIndex("a"));
                            apkInfo.libPath = query.getString(query.getColumnIndex("l"));
                            apkInfo.versionName = query.getString(query.getColumnIndex("v"));
                            apkInfo.dexPath = query.getString(query.getColumnIndex("apk"));
                            apkInfo.apkParseSuc = query.getInt(query.getColumnIndex("ap"));
                            apkInfo.className = query.getString(query.getColumnIndex(Config.CELL_LOCATION));
                            apkInfo.applicationTheme = query.getInt(query.getColumnIndex("th"));
                            apkInfo.startTime = query.getLong(query.getColumnIndex("st"));
                            apkInfo.duration = query.getInt(query.getColumnIndex("du"));
                            apkInfo.apkMD5 = query.getString(query.getColumnIndex("m5"));
                            apkInfo.priority = query.getInt(query.getColumnIndex(Config.PRINCIPAL_PART));
                            byte[] blob = query.getBlob(query.getColumnIndex("ac"));
                            if (blob != null && (a2 = com.baidu.sofire.core.a.a(blob)) != null && (size = a2.size()) > 0) {
                                apkInfo.activities = new ActivityInfo[size];
                                for (int i2 = 0; i2 < size; i2++) {
                                    ActivityInfo activityInfo = new ActivityInfo();
                                    activityInfo.theme = a2.get(i2).f11139a;
                                    activityInfo.name = a2.get(i2).j;
                                    activityInfo.configChanges = a2.get(i2).f11146h;
                                    activityInfo.flags = a2.get(i2).f11144f;
                                    activityInfo.labelRes = a2.get(i2).l;
                                    activityInfo.launchMode = a2.get(i2).f11140b;
                                    activityInfo.nonLocalizedLabel = a2.get(i2).m;
                                    activityInfo.packageName = a2.get(i2).k;
                                    activityInfo.permission = a2.get(i2).f11141c;
                                    activityInfo.screenOrientation = a2.get(i2).f11145g;
                                    activityInfo.softInputMode = a2.get(i2).f11147i;
                                    activityInfo.targetActivity = a2.get(i2).f11143e;
                                    activityInfo.taskAffinity = a2.get(i2).f11142d;
                                    apkInfo.activities[i2] = activityInfo;
                                }
                            }
                            apkInfo2 = apkInfo;
                        } catch (Throwable unused) {
                            cursor = query;
                            try {
                                d.a();
                                return apkInfo;
                            } finally {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        d.a();
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused3) {
                    apkInfo = null;
                }
            }
            if (query != null) {
                try {
                    if (query.isClosed()) {
                        return apkInfo2;
                    }
                    query.close();
                    return apkInfo2;
                } catch (Throwable unused4) {
                    d.a();
                    return apkInfo2;
                }
            }
            return apkInfo2;
        } catch (Throwable unused5) {
            apkInfo = null;
        }
    }

    public final ApkInfo a(int i2) {
        ApkInfo apkInfo;
        ArrayList<com.baidu.sofire.core.b> a2;
        int size;
        Cursor cursor = null;
        r0 = null;
        ApkInfo apkInfo2 = null;
        try {
            Cursor query = this.f11114c.query("pgn", null, "k=" + i2, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        apkInfo = new ApkInfo();
                        try {
                            apkInfo.key = i2;
                            apkInfo.initStatus = query.getInt(query.getColumnIndex("n"));
                            apkInfo.packageName = query.getString(query.getColumnIndex("p"));
                            apkInfo.pkgPath = query.getString(query.getColumnIndex("a"));
                            apkInfo.libPath = query.getString(query.getColumnIndex("l"));
                            apkInfo.versionName = query.getString(query.getColumnIndex("v"));
                            apkInfo.dexPath = query.getString(query.getColumnIndex("apk"));
                            apkInfo.apkParseSuc = query.getInt(query.getColumnIndex("ap"));
                            apkInfo.className = query.getString(query.getColumnIndex(Config.CELL_LOCATION));
                            apkInfo.applicationTheme = query.getInt(query.getColumnIndex("th"));
                            apkInfo.startTime = query.getLong(query.getColumnIndex("st"));
                            apkInfo.duration = query.getInt(query.getColumnIndex("du"));
                            apkInfo.apkMD5 = query.getString(query.getColumnIndex("m5"));
                            apkInfo.priority = query.getInt(query.getColumnIndex(Config.PRINCIPAL_PART));
                            byte[] blob = query.getBlob(query.getColumnIndex("ac"));
                            if (blob != null && (a2 = com.baidu.sofire.core.a.a(blob)) != null && (size = a2.size()) > 0) {
                                apkInfo.activities = new ActivityInfo[size];
                                for (int i3 = 0; i3 < size; i3++) {
                                    ActivityInfo activityInfo = new ActivityInfo();
                                    activityInfo.theme = a2.get(i3).f11139a;
                                    activityInfo.name = a2.get(i3).j;
                                    activityInfo.configChanges = a2.get(i3).f11146h;
                                    activityInfo.flags = a2.get(i3).f11144f;
                                    activityInfo.labelRes = a2.get(i3).l;
                                    activityInfo.launchMode = a2.get(i3).f11140b;
                                    activityInfo.nonLocalizedLabel = a2.get(i3).m;
                                    activityInfo.packageName = a2.get(i3).k;
                                    activityInfo.permission = a2.get(i3).f11141c;
                                    activityInfo.screenOrientation = a2.get(i3).f11145g;
                                    activityInfo.softInputMode = a2.get(i3).f11147i;
                                    activityInfo.targetActivity = a2.get(i3).f11143e;
                                    activityInfo.taskAffinity = a2.get(i3).f11142d;
                                    apkInfo.activities[i3] = activityInfo;
                                }
                            }
                            apkInfo2 = apkInfo;
                        } catch (Throwable unused) {
                            cursor = query;
                            try {
                                d.a();
                                return apkInfo;
                            } finally {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        d.a();
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused3) {
                    apkInfo = null;
                }
            }
            if (query != null) {
                try {
                    if (query.isClosed()) {
                        return apkInfo2;
                    }
                    query.close();
                    return apkInfo2;
                } catch (Throwable unused4) {
                    d.a();
                    return apkInfo2;
                }
            }
            return apkInfo2;
        } catch (Throwable unused5) {
            apkInfo = null;
        }
    }

    public final void a(String str) {
        new StringBuilder().append(str);
        b.a();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f11114c.delete("pgn", "p=?", new String[]{str});
        } catch (Throwable unused) {
            d.a();
        }
    }

    public final int a(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("u", Integer.valueOf(i3));
            SQLiteDatabase sQLiteDatabase = this.f11114c;
            return sQLiteDatabase.update("pgn", contentValues, "k=" + i2, null);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public final void a(int i2, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append(" v = ");
        sb.append(str);
        b.a();
        if (i2 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            SQLiteDatabase sQLiteDatabase = this.f11114c;
            sQLiteDatabase.delete("pgn", "k=" + i2 + " and v=?", new String[]{str});
            b.a();
        } catch (Throwable unused) {
            d.a();
        }
    }
}
