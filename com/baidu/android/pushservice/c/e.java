package com.baidu.android.pushservice.c;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f2956a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static String f2957b = "PushTrackDatabase";

    /* renamed from: c  reason: collision with root package name */
    public static C0034e f2958c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static e f2959d;

    /* renamed from: e  reason: collision with root package name */
    public Context f2960e;

    /* loaded from: classes.dex */
    public enum a {
        ackId,
        type,
        value,
        timestamp,
        ext,
        aliasId
    }

    /* loaded from: classes.dex */
    public enum b {
        connectionId,
        startTime,
        stopTime,
        reason,
        retryTime,
        retryCount,
        ext,
        aliasId
    }

    /* loaded from: classes.dex */
    public enum c {
        crashId,
        exception,
        timestamp,
        ext,
        aliasId
    }

    /* loaded from: classes.dex */
    public enum d {
        dbId,
        tableName,
        className,
        method,
        action,
        startTime,
        endTime,
        duration,
        ext,
        aliasId
    }

    /* renamed from: com.baidu.android.pushservice.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0034e extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        public static final String f2992a = "CREATE TABLE crash (" + c.crashId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.exception.name() + " TEXT, " + c.timestamp.name() + " LONG, " + c.ext.name() + " TEXT, " + c.aliasId.name() + " LONG NOT NULL );";

        /* renamed from: b  reason: collision with root package name */
        public static final String f2993b = "CREATE TABLE db (" + d.dbId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.tableName.name() + " TEXT, " + d.className.name() + " TEXT, " + d.method.name() + " TEXT, " + d.action.name() + " TEXT, " + d.startTime.name() + " LONG, " + d.endTime.name() + " LONG, " + d.duration.name() + " LONG, " + d.ext.name() + " TEXT, " + d.aliasId.name() + " LONG NOT NULL );";

        /* renamed from: c  reason: collision with root package name */
        public static final String f2994c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f2995d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f2996e;

        /* renamed from: f  reason: collision with root package name */
        public Context f2997f;

        static {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE connection (");
            sb.append(b.connectionId.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(b.startTime.name());
            sb.append(" LONG, ");
            sb.append(b.stopTime.name());
            sb.append(" LONG, ");
            sb.append(b.reason.name());
            sb.append(" TEXT, ");
            sb.append(b.retryTime.name());
            sb.append(" LONG, ");
            sb.append(b.retryCount.name());
            sb.append(" LONG, ");
            sb.append(b.ext.name());
            sb.append(" TEXT, ");
            sb.append(b.aliasId.name());
            sb.append(" LONG NOT NULL );");
            f2994c = sb.toString();
            f2995d = "CREATE TABLE request (" + f.id.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.method.name() + " TEXT, " + f.requestId.name() + " TEXT, " + f.timestamp.name() + " LONG, " + f.responseTime.name() + " LONG, " + f.errorCode.name() + " LONG, " + f.ext.name() + " TEXT, " + f.aliasId.name() + " LONG NOT NULL);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE ack (");
            sb2.append(a.ackId.name());
            sb2.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb2.append(a.type.name());
            sb2.append(" TEXT, ");
            sb2.append(a.value.name());
            sb2.append(" TEXT, ");
            sb2.append(a.timestamp.name());
            sb2.append(" LONG, ");
            sb2.append(a.ext.name());
            sb2.append(" TEXT, ");
            sb2.append(a.aliasId.name());
            sb2.append(" LONG NOT NULL);");
            f2996e = sb2.toString();
        }

        public C0034e(Context context, String str, int i2) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
            this.f2997f = context;
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS crash");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS connection");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS request");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS db");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ack");
            } catch (Exception unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(f2992a);
                sQLiteDatabase.execSQL(f2993b);
                sQLiteDatabase.execSQL(f2994c);
                sQLiteDatabase.execSQL(f2995d);
                sQLiteDatabase.execSQL(f2996e);
            } catch (Exception unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            a(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    /* loaded from: classes.dex */
    public enum f {
        id,
        method,
        requestId,
        timestamp,
        responseTime,
        errorCode,
        ext,
        aliasId
    }

    public e(Context context) {
        this.f2960e = context;
        f2958c = new C0034e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        if (f2959d == null) {
            synchronized (f2956a) {
                if (f2959d == null) {
                    f2959d = new e(context.getApplicationContext());
                }
            }
        }
        return f2959d;
    }

    public static SQLiteDatabase b(Context context) {
        if (f2958c == null) {
            f2958c = new C0034e(context, "push_track.db", 1);
        }
        try {
            return f2958c.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }

    public List<com.baidu.android.pushservice.c.a.c> a() {
        Cursor cursor;
        synchronized (f2956a) {
            SQLiteDatabase b2 = b(this.f2960e);
            Cursor cursor2 = null;
            if (b2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                Cursor rawQuery = b2.rawQuery("select * from crash limit 1000", null);
                while (rawQuery != null) {
                    try {
                        if (!rawQuery.moveToNext()) {
                            break;
                        }
                        com.baidu.android.pushservice.c.a.c cVar = new com.baidu.android.pushservice.c.a.c();
                        cVar.f2829a = rawQuery.getString(rawQuery.getColumnIndex(c.exception.name()));
                        cVar.f2830b = rawQuery.getLong(rawQuery.getColumnIndex(c.timestamp.name()));
                        cVar.f2831c = rawQuery.getString(rawQuery.getColumnIndex(c.ext.name()));
                        cVar.f2832d = rawQuery.getLong(rawQuery.getColumnIndex(c.aliasId.name()));
                        arrayList.add(cVar);
                    } catch (Exception unused) {
                        cursor = null;
                        cursor2 = rawQuery;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        b2.close();
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        cursor = null;
                        cursor2 = rawQuery;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        b2.close();
                        throw th;
                    }
                }
                cursor = b2.rawQuery("select count(*) from crash", null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst() && cursor.getInt(0) > 1000) {
                            b2.delete("crash", null, null);
                        }
                    } catch (Exception unused2) {
                        cursor2 = rawQuery;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        b2.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = rawQuery;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        b2.close();
                        throw th;
                    }
                }
                if (rawQuery != null && !rawQuery.isClosed()) {
                    rawQuery.close();
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Exception unused3) {
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
            b2.close();
            return arrayList;
        }
    }

    public void a(com.baidu.android.pushservice.c.a.a aVar) {
        synchronized (f2956a) {
            SQLiteDatabase b2 = b(this.f2960e);
            if (b2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(a.type.name(), aVar.f2800a);
                contentValues.put(a.value.name(), aVar.f2801b);
                contentValues.put(a.timestamp.name(), Long.valueOf(aVar.f2802c));
                contentValues.put(a.ext.name(), aVar.f2803d);
                contentValues.put(a.aliasId.name(), Long.valueOf(aVar.f2804e));
                b2.insert(IMTrackDatabase.AckEnum.TABLE_NAME, null, contentValues);
            } catch (Exception unused) {
            }
            b2.close();
        }
    }

    public void a(com.baidu.android.pushservice.c.a.b bVar) {
        synchronized (f2956a) {
            SQLiteDatabase b2 = b(this.f2960e);
            if (b2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(b.startTime.name(), Long.valueOf(bVar.f2813a));
                contentValues.put(b.stopTime.name(), Long.valueOf(bVar.f2814b));
                contentValues.put(b.reason.name(), bVar.f2815c);
                contentValues.put(b.retryTime.name(), Long.valueOf(bVar.f2816d));
                contentValues.put(b.retryCount.name(), Long.valueOf(bVar.f2817e));
                contentValues.put(b.ext.name(), bVar.f2818f);
                contentValues.put(b.aliasId.name(), Long.valueOf(bVar.f2819g));
                b2.insert("connection", null, contentValues);
            } catch (Exception unused) {
            }
            b2.close();
        }
    }

    public void a(com.baidu.android.pushservice.c.a.c cVar) {
        synchronized (f2956a) {
            SQLiteDatabase b2 = b(this.f2960e);
            if (b2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(c.exception.name(), cVar.f2829a);
                contentValues.put(c.timestamp.name(), Long.valueOf(cVar.f2830b));
                contentValues.put(c.ext.name(), cVar.f2831c);
                contentValues.put(c.aliasId.name(), Long.valueOf(cVar.f2832d));
                b2.insert("crash", null, contentValues);
            } catch (Exception unused) {
            } catch (Throwable th) {
                b2.close();
                throw th;
            }
            b2.close();
        }
    }

    public void a(com.baidu.android.pushservice.c.a.d dVar) {
        synchronized (f2956a) {
            SQLiteDatabase b2 = b(this.f2960e);
            if (b2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(d.tableName.name(), dVar.f2842a);
                contentValues.put(d.className.name(), dVar.f2843b);
                contentValues.put(d.method.name(), dVar.f2844c);
                contentValues.put(d.action.name(), dVar.f2845d);
                contentValues.put(d.startTime.name(), Long.valueOf(dVar.f2846e));
                contentValues.put(d.endTime.name(), Long.valueOf(dVar.f2847f));
                contentValues.put(d.duration.name(), Long.valueOf(dVar.f2848g));
                contentValues.put(d.ext.name(), dVar.f2849h);
                contentValues.put(d.aliasId.name(), Long.valueOf(dVar.f2850i));
                b2.insert(IMTrackDatabase.DbEnum.TABLE_NAME, null, contentValues);
            } catch (Exception unused) {
            } catch (Throwable th) {
                b2.close();
                throw th;
            }
            b2.close();
        }
    }

    public void a(com.baidu.android.pushservice.c.a.e eVar) {
        synchronized (f2956a) {
            SQLiteDatabase b2 = b(this.f2960e);
            if (b2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(f.method.name(), eVar.f2851a);
                contentValues.put(f.requestId.name(), eVar.f2852b);
                contentValues.put(f.timestamp.name(), Long.valueOf(eVar.f2853c));
                contentValues.put(f.responseTime.name(), Long.valueOf(eVar.f2854d));
                contentValues.put(f.errorCode.name(), Long.valueOf(eVar.f2855e));
                contentValues.put(f.ext.name(), eVar.f2856f);
                contentValues.put(f.aliasId.name(), Long.valueOf(eVar.f2857g));
                b2.insert("request", null, contentValues);
            } catch (Exception unused) {
            }
            b2.close();
        }
    }

    public List<com.baidu.android.pushservice.c.a.d> b() {
        synchronized (f2956a) {
            SQLiteDatabase b2 = b(this.f2960e);
            Cursor cursor = null;
            if (b2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                cursor = b2.rawQuery("select * from db limit 1000", null);
                while (cursor != null) {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    com.baidu.android.pushservice.c.a.d dVar = new com.baidu.android.pushservice.c.a.d();
                    dVar.f2842a = cursor.getString(cursor.getColumnIndex(d.tableName.name()));
                    dVar.f2843b = cursor.getString(cursor.getColumnIndex(d.className.name()));
                    dVar.f2844c = cursor.getString(cursor.getColumnIndex(d.method.name()));
                    dVar.f2845d = cursor.getString(cursor.getColumnIndex(d.action.name()));
                    dVar.f2846e = cursor.getLong(cursor.getColumnIndex(d.startTime.name()));
                    dVar.f2847f = cursor.getLong(cursor.getColumnIndex(d.endTime.name()));
                    dVar.f2848g = cursor.getLong(cursor.getColumnIndex(d.duration.name()));
                    dVar.f2849h = cursor.getString(cursor.getColumnIndex(d.ext.name()));
                    dVar.f2850i = cursor.getLong(cursor.getColumnIndex(d.aliasId.name()));
                    arrayList.add(dVar);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception unused) {
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                b2.close();
                throw th;
            }
            b2.close();
            return arrayList;
        }
    }

    public List<com.baidu.android.pushservice.c.a.b> c() {
        synchronized (f2956a) {
            SQLiteDatabase b2 = b(this.f2960e);
            Cursor cursor = null;
            if (b2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                cursor = b2.rawQuery("select * from connection limit 1000", null);
                while (cursor != null) {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    com.baidu.android.pushservice.c.a.b bVar = new com.baidu.android.pushservice.c.a.b();
                    bVar.f2813a = cursor.getLong(cursor.getColumnIndex(b.startTime.name()));
                    bVar.f2814b = cursor.getLong(cursor.getColumnIndex(b.stopTime.name()));
                    bVar.f2815c = cursor.getString(cursor.getColumnIndex(b.reason.name()));
                    bVar.f2816d = cursor.getLong(cursor.getColumnIndex(b.retryTime.name()));
                    bVar.f2817e = cursor.getLong(cursor.getColumnIndex(b.retryCount.name()));
                    bVar.f2818f = cursor.getString(cursor.getColumnIndex(b.ext.name()));
                    bVar.f2819g = cursor.getLong(cursor.getColumnIndex(b.aliasId.name()));
                    arrayList.add(bVar);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception unused) {
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                b2.close();
                throw th;
            }
            b2.close();
            return arrayList;
        }
    }

    public List<com.baidu.android.pushservice.c.a.e> d() {
        synchronized (f2956a) {
            SQLiteDatabase b2 = b(this.f2960e);
            Cursor cursor = null;
            if (b2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                cursor = b2.rawQuery("select * from request limit 1000", null);
                while (cursor != null) {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    com.baidu.android.pushservice.c.a.e eVar = new com.baidu.android.pushservice.c.a.e();
                    eVar.f2851a = cursor.getString(cursor.getColumnIndex(f.method.name()));
                    eVar.f2852b = cursor.getString(cursor.getColumnIndex(f.requestId.name()));
                    eVar.f2853c = cursor.getLong(cursor.getColumnIndex(f.timestamp.name()));
                    eVar.f2854d = cursor.getLong(cursor.getColumnIndex(f.responseTime.name()));
                    eVar.f2855e = cursor.getLong(cursor.getColumnIndex(f.errorCode.name()));
                    eVar.f2856f = cursor.getString(cursor.getColumnIndex(f.ext.name()));
                    eVar.f2857g = cursor.getLong(cursor.getColumnIndex(f.aliasId.name()));
                    arrayList.add(eVar);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception unused) {
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                b2.close();
                throw th;
            }
            b2.close();
            return arrayList;
        }
    }

    public List<com.baidu.android.pushservice.c.a.a> e() {
        synchronized (f2956a) {
            SQLiteDatabase b2 = b(this.f2960e);
            Cursor cursor = null;
            if (b2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                cursor = b2.rawQuery("select * from ack limit 1000", null);
                while (cursor != null) {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    com.baidu.android.pushservice.c.a.a aVar = new com.baidu.android.pushservice.c.a.a();
                    aVar.f2800a = cursor.getString(cursor.getColumnIndex(a.type.name()));
                    aVar.f2801b = cursor.getString(cursor.getColumnIndex(a.value.name()));
                    aVar.f2802c = cursor.getLong(cursor.getColumnIndex(a.timestamp.name()));
                    aVar.f2803d = cursor.getString(cursor.getColumnIndex(a.ext.name()));
                    aVar.f2804e = cursor.getLong(cursor.getColumnIndex(a.aliasId.name()));
                    arrayList.add(aVar);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception unused) {
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                b2.close();
                throw th;
            }
            b2.close();
            return arrayList;
        }
    }

    public void f() {
        synchronized (f2956a) {
            SQLiteDatabase b2 = b(this.f2960e);
            if (b2 == null) {
                return;
            }
            try {
                b2.delete("crash", null, null);
                b2.delete(IMTrackDatabase.DbEnum.TABLE_NAME, null, null);
                b2.delete("connection", null, null);
                b2.delete("request", null, null);
                b2.delete(IMTrackDatabase.AckEnum.TABLE_NAME, null, null);
            } catch (Exception unused) {
            }
            b2.close();
        }
    }
}
