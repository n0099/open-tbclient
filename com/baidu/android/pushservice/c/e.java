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
    public static final Object f2934a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static String f2935b = "PushTrackDatabase";

    /* renamed from: c  reason: collision with root package name */
    public static C0032e f2936c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static e f2937d;

    /* renamed from: e  reason: collision with root package name */
    public Context f2938e;

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
    public static class C0032e extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        public static final String f2970a = "CREATE TABLE crash (" + c.crashId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.exception.name() + " TEXT, " + c.timestamp.name() + " LONG, " + c.ext.name() + " TEXT, " + c.aliasId.name() + " LONG NOT NULL );";

        /* renamed from: b  reason: collision with root package name */
        public static final String f2971b = "CREATE TABLE db (" + d.dbId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.tableName.name() + " TEXT, " + d.className.name() + " TEXT, " + d.method.name() + " TEXT, " + d.action.name() + " TEXT, " + d.startTime.name() + " LONG, " + d.endTime.name() + " LONG, " + d.duration.name() + " LONG, " + d.ext.name() + " TEXT, " + d.aliasId.name() + " LONG NOT NULL );";

        /* renamed from: c  reason: collision with root package name */
        public static final String f2972c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f2973d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f2974e;

        /* renamed from: f  reason: collision with root package name */
        public Context f2975f;

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
            f2972c = sb.toString();
            f2973d = "CREATE TABLE request (" + f.id.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.method.name() + " TEXT, " + f.requestId.name() + " TEXT, " + f.timestamp.name() + " LONG, " + f.responseTime.name() + " LONG, " + f.errorCode.name() + " LONG, " + f.ext.name() + " TEXT, " + f.aliasId.name() + " LONG NOT NULL);";
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
            f2974e = sb2.toString();
        }

        public C0032e(Context context, String str, int i2) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
            this.f2975f = context;
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
                sQLiteDatabase.execSQL(f2970a);
                sQLiteDatabase.execSQL(f2971b);
                sQLiteDatabase.execSQL(f2972c);
                sQLiteDatabase.execSQL(f2973d);
                sQLiteDatabase.execSQL(f2974e);
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
        this.f2938e = context;
        f2936c = new C0032e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        if (f2937d == null) {
            synchronized (f2934a) {
                if (f2937d == null) {
                    f2937d = new e(context.getApplicationContext());
                }
            }
        }
        return f2937d;
    }

    public static SQLiteDatabase b(Context context) {
        if (f2936c == null) {
            f2936c = new C0032e(context, "push_track.db", 1);
        }
        try {
            return f2936c.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }

    public List<com.baidu.android.pushservice.c.a.c> a() {
        Cursor cursor;
        synchronized (f2934a) {
            SQLiteDatabase b2 = b(this.f2938e);
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
                        cVar.f2807a = rawQuery.getString(rawQuery.getColumnIndex(c.exception.name()));
                        cVar.f2808b = rawQuery.getLong(rawQuery.getColumnIndex(c.timestamp.name()));
                        cVar.f2809c = rawQuery.getString(rawQuery.getColumnIndex(c.ext.name()));
                        cVar.f2810d = rawQuery.getLong(rawQuery.getColumnIndex(c.aliasId.name()));
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
        synchronized (f2934a) {
            SQLiteDatabase b2 = b(this.f2938e);
            if (b2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(a.type.name(), aVar.f2778a);
                contentValues.put(a.value.name(), aVar.f2779b);
                contentValues.put(a.timestamp.name(), Long.valueOf(aVar.f2780c));
                contentValues.put(a.ext.name(), aVar.f2781d);
                contentValues.put(a.aliasId.name(), Long.valueOf(aVar.f2782e));
                b2.insert(IMTrackDatabase.AckEnum.TABLE_NAME, null, contentValues);
            } catch (Exception unused) {
            }
            b2.close();
        }
    }

    public void a(com.baidu.android.pushservice.c.a.b bVar) {
        synchronized (f2934a) {
            SQLiteDatabase b2 = b(this.f2938e);
            if (b2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(b.startTime.name(), Long.valueOf(bVar.f2791a));
                contentValues.put(b.stopTime.name(), Long.valueOf(bVar.f2792b));
                contentValues.put(b.reason.name(), bVar.f2793c);
                contentValues.put(b.retryTime.name(), Long.valueOf(bVar.f2794d));
                contentValues.put(b.retryCount.name(), Long.valueOf(bVar.f2795e));
                contentValues.put(b.ext.name(), bVar.f2796f);
                contentValues.put(b.aliasId.name(), Long.valueOf(bVar.f2797g));
                b2.insert("connection", null, contentValues);
            } catch (Exception unused) {
            }
            b2.close();
        }
    }

    public void a(com.baidu.android.pushservice.c.a.c cVar) {
        synchronized (f2934a) {
            SQLiteDatabase b2 = b(this.f2938e);
            if (b2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(c.exception.name(), cVar.f2807a);
                contentValues.put(c.timestamp.name(), Long.valueOf(cVar.f2808b));
                contentValues.put(c.ext.name(), cVar.f2809c);
                contentValues.put(c.aliasId.name(), Long.valueOf(cVar.f2810d));
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
        synchronized (f2934a) {
            SQLiteDatabase b2 = b(this.f2938e);
            if (b2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(d.tableName.name(), dVar.f2820a);
                contentValues.put(d.className.name(), dVar.f2821b);
                contentValues.put(d.method.name(), dVar.f2822c);
                contentValues.put(d.action.name(), dVar.f2823d);
                contentValues.put(d.startTime.name(), Long.valueOf(dVar.f2824e));
                contentValues.put(d.endTime.name(), Long.valueOf(dVar.f2825f));
                contentValues.put(d.duration.name(), Long.valueOf(dVar.f2826g));
                contentValues.put(d.ext.name(), dVar.f2827h);
                contentValues.put(d.aliasId.name(), Long.valueOf(dVar.f2828i));
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
        synchronized (f2934a) {
            SQLiteDatabase b2 = b(this.f2938e);
            if (b2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(f.method.name(), eVar.f2829a);
                contentValues.put(f.requestId.name(), eVar.f2830b);
                contentValues.put(f.timestamp.name(), Long.valueOf(eVar.f2831c));
                contentValues.put(f.responseTime.name(), Long.valueOf(eVar.f2832d));
                contentValues.put(f.errorCode.name(), Long.valueOf(eVar.f2833e));
                contentValues.put(f.ext.name(), eVar.f2834f);
                contentValues.put(f.aliasId.name(), Long.valueOf(eVar.f2835g));
                b2.insert("request", null, contentValues);
            } catch (Exception unused) {
            }
            b2.close();
        }
    }

    public List<com.baidu.android.pushservice.c.a.d> b() {
        synchronized (f2934a) {
            SQLiteDatabase b2 = b(this.f2938e);
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
                    dVar.f2820a = cursor.getString(cursor.getColumnIndex(d.tableName.name()));
                    dVar.f2821b = cursor.getString(cursor.getColumnIndex(d.className.name()));
                    dVar.f2822c = cursor.getString(cursor.getColumnIndex(d.method.name()));
                    dVar.f2823d = cursor.getString(cursor.getColumnIndex(d.action.name()));
                    dVar.f2824e = cursor.getLong(cursor.getColumnIndex(d.startTime.name()));
                    dVar.f2825f = cursor.getLong(cursor.getColumnIndex(d.endTime.name()));
                    dVar.f2826g = cursor.getLong(cursor.getColumnIndex(d.duration.name()));
                    dVar.f2827h = cursor.getString(cursor.getColumnIndex(d.ext.name()));
                    dVar.f2828i = cursor.getLong(cursor.getColumnIndex(d.aliasId.name()));
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
        synchronized (f2934a) {
            SQLiteDatabase b2 = b(this.f2938e);
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
                    bVar.f2791a = cursor.getLong(cursor.getColumnIndex(b.startTime.name()));
                    bVar.f2792b = cursor.getLong(cursor.getColumnIndex(b.stopTime.name()));
                    bVar.f2793c = cursor.getString(cursor.getColumnIndex(b.reason.name()));
                    bVar.f2794d = cursor.getLong(cursor.getColumnIndex(b.retryTime.name()));
                    bVar.f2795e = cursor.getLong(cursor.getColumnIndex(b.retryCount.name()));
                    bVar.f2796f = cursor.getString(cursor.getColumnIndex(b.ext.name()));
                    bVar.f2797g = cursor.getLong(cursor.getColumnIndex(b.aliasId.name()));
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
        synchronized (f2934a) {
            SQLiteDatabase b2 = b(this.f2938e);
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
                    eVar.f2829a = cursor.getString(cursor.getColumnIndex(f.method.name()));
                    eVar.f2830b = cursor.getString(cursor.getColumnIndex(f.requestId.name()));
                    eVar.f2831c = cursor.getLong(cursor.getColumnIndex(f.timestamp.name()));
                    eVar.f2832d = cursor.getLong(cursor.getColumnIndex(f.responseTime.name()));
                    eVar.f2833e = cursor.getLong(cursor.getColumnIndex(f.errorCode.name()));
                    eVar.f2834f = cursor.getString(cursor.getColumnIndex(f.ext.name()));
                    eVar.f2835g = cursor.getLong(cursor.getColumnIndex(f.aliasId.name()));
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
        synchronized (f2934a) {
            SQLiteDatabase b2 = b(this.f2938e);
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
                    aVar.f2778a = cursor.getString(cursor.getColumnIndex(a.type.name()));
                    aVar.f2779b = cursor.getString(cursor.getColumnIndex(a.value.name()));
                    aVar.f2780c = cursor.getLong(cursor.getColumnIndex(a.timestamp.name()));
                    aVar.f2781d = cursor.getString(cursor.getColumnIndex(a.ext.name()));
                    aVar.f2782e = cursor.getLong(cursor.getColumnIndex(a.aliasId.name()));
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
        synchronized (f2934a) {
            SQLiteDatabase b2 = b(this.f2938e);
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
