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
    public static final Object f2923a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static String f2924b = "PushTrackDatabase";

    /* renamed from: c  reason: collision with root package name */
    public static C0033e f2925c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static e f2926d;

    /* renamed from: e  reason: collision with root package name */
    public Context f2927e;

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
    public static class C0033e extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        public static final String f2957a = "CREATE TABLE crash (" + c.crashId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.exception.name() + " TEXT, " + c.timestamp.name() + " LONG, " + c.ext.name() + " TEXT, " + c.aliasId.name() + " LONG NOT NULL );";

        /* renamed from: b  reason: collision with root package name */
        public static final String f2958b = "CREATE TABLE db (" + d.dbId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.tableName.name() + " TEXT, " + d.className.name() + " TEXT, " + d.method.name() + " TEXT, " + d.action.name() + " TEXT, " + d.startTime.name() + " LONG, " + d.endTime.name() + " LONG, " + d.duration.name() + " LONG, " + d.ext.name() + " TEXT, " + d.aliasId.name() + " LONG NOT NULL );";

        /* renamed from: c  reason: collision with root package name */
        public static final String f2959c;

        /* renamed from: d  reason: collision with root package name */
        public static final String f2960d;

        /* renamed from: e  reason: collision with root package name */
        public static final String f2961e;

        /* renamed from: f  reason: collision with root package name */
        public Context f2962f;

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
            f2959c = sb.toString();
            f2960d = "CREATE TABLE request (" + f.id.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.method.name() + " TEXT, " + f.requestId.name() + " TEXT, " + f.timestamp.name() + " LONG, " + f.responseTime.name() + " LONG, " + f.errorCode.name() + " LONG, " + f.ext.name() + " TEXT, " + f.aliasId.name() + " LONG NOT NULL);";
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
            f2961e = sb2.toString();
        }

        public C0033e(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
            this.f2962f = context;
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
                sQLiteDatabase.execSQL(f2957a);
                sQLiteDatabase.execSQL(f2958b);
                sQLiteDatabase.execSQL(f2959c);
                sQLiteDatabase.execSQL(f2960d);
                sQLiteDatabase.execSQL(f2961e);
            } catch (Exception unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
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
        this.f2927e = context;
        f2925c = new C0033e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        if (f2926d == null) {
            synchronized (f2923a) {
                if (f2926d == null) {
                    f2926d = new e(context.getApplicationContext());
                }
            }
        }
        return f2926d;
    }

    public static SQLiteDatabase b(Context context) {
        if (f2925c == null) {
            f2925c = new C0033e(context, "push_track.db", 1);
        }
        try {
            return f2925c.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }

    public List<com.baidu.android.pushservice.c.a.c> a() {
        Cursor cursor;
        synchronized (f2923a) {
            SQLiteDatabase b2 = b(this.f2927e);
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
                        cVar.f2804a = rawQuery.getString(rawQuery.getColumnIndex(c.exception.name()));
                        cVar.f2805b = rawQuery.getLong(rawQuery.getColumnIndex(c.timestamp.name()));
                        cVar.f2806c = rawQuery.getString(rawQuery.getColumnIndex(c.ext.name()));
                        cVar.f2807d = rawQuery.getLong(rawQuery.getColumnIndex(c.aliasId.name()));
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
        synchronized (f2923a) {
            SQLiteDatabase b2 = b(this.f2927e);
            if (b2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(a.type.name(), aVar.f2776a);
                contentValues.put(a.value.name(), aVar.f2777b);
                contentValues.put(a.timestamp.name(), Long.valueOf(aVar.f2778c));
                contentValues.put(a.ext.name(), aVar.f2779d);
                contentValues.put(a.aliasId.name(), Long.valueOf(aVar.f2780e));
                b2.insert(IMTrackDatabase.AckEnum.TABLE_NAME, null, contentValues);
            } catch (Exception unused) {
            }
            b2.close();
        }
    }

    public void a(com.baidu.android.pushservice.c.a.b bVar) {
        synchronized (f2923a) {
            SQLiteDatabase b2 = b(this.f2927e);
            if (b2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(b.startTime.name(), Long.valueOf(bVar.f2789a));
                contentValues.put(b.stopTime.name(), Long.valueOf(bVar.f2790b));
                contentValues.put(b.reason.name(), bVar.f2791c);
                contentValues.put(b.retryTime.name(), Long.valueOf(bVar.f2792d));
                contentValues.put(b.retryCount.name(), Long.valueOf(bVar.f2793e));
                contentValues.put(b.ext.name(), bVar.f2794f);
                contentValues.put(b.aliasId.name(), Long.valueOf(bVar.f2795g));
                b2.insert("connection", null, contentValues);
            } catch (Exception unused) {
            }
            b2.close();
        }
    }

    public void a(com.baidu.android.pushservice.c.a.c cVar) {
        synchronized (f2923a) {
            SQLiteDatabase b2 = b(this.f2927e);
            if (b2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(c.exception.name(), cVar.f2804a);
                contentValues.put(c.timestamp.name(), Long.valueOf(cVar.f2805b));
                contentValues.put(c.ext.name(), cVar.f2806c);
                contentValues.put(c.aliasId.name(), Long.valueOf(cVar.f2807d));
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
        synchronized (f2923a) {
            SQLiteDatabase b2 = b(this.f2927e);
            if (b2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(d.tableName.name(), dVar.f2816a);
                contentValues.put(d.className.name(), dVar.f2817b);
                contentValues.put(d.method.name(), dVar.f2818c);
                contentValues.put(d.action.name(), dVar.f2819d);
                contentValues.put(d.startTime.name(), Long.valueOf(dVar.f2820e));
                contentValues.put(d.endTime.name(), Long.valueOf(dVar.f2821f));
                contentValues.put(d.duration.name(), Long.valueOf(dVar.f2822g));
                contentValues.put(d.ext.name(), dVar.f2823h);
                contentValues.put(d.aliasId.name(), Long.valueOf(dVar.i));
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
        synchronized (f2923a) {
            SQLiteDatabase b2 = b(this.f2927e);
            if (b2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(f.method.name(), eVar.f2824a);
                contentValues.put(f.requestId.name(), eVar.f2825b);
                contentValues.put(f.timestamp.name(), Long.valueOf(eVar.f2826c));
                contentValues.put(f.responseTime.name(), Long.valueOf(eVar.f2827d));
                contentValues.put(f.errorCode.name(), Long.valueOf(eVar.f2828e));
                contentValues.put(f.ext.name(), eVar.f2829f);
                contentValues.put(f.aliasId.name(), Long.valueOf(eVar.f2830g));
                b2.insert("request", null, contentValues);
            } catch (Exception unused) {
            }
            b2.close();
        }
    }

    public List<com.baidu.android.pushservice.c.a.d> b() {
        synchronized (f2923a) {
            SQLiteDatabase b2 = b(this.f2927e);
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
                    dVar.f2816a = cursor.getString(cursor.getColumnIndex(d.tableName.name()));
                    dVar.f2817b = cursor.getString(cursor.getColumnIndex(d.className.name()));
                    dVar.f2818c = cursor.getString(cursor.getColumnIndex(d.method.name()));
                    dVar.f2819d = cursor.getString(cursor.getColumnIndex(d.action.name()));
                    dVar.f2820e = cursor.getLong(cursor.getColumnIndex(d.startTime.name()));
                    dVar.f2821f = cursor.getLong(cursor.getColumnIndex(d.endTime.name()));
                    dVar.f2822g = cursor.getLong(cursor.getColumnIndex(d.duration.name()));
                    dVar.f2823h = cursor.getString(cursor.getColumnIndex(d.ext.name()));
                    dVar.i = cursor.getLong(cursor.getColumnIndex(d.aliasId.name()));
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
        synchronized (f2923a) {
            SQLiteDatabase b2 = b(this.f2927e);
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
                    bVar.f2789a = cursor.getLong(cursor.getColumnIndex(b.startTime.name()));
                    bVar.f2790b = cursor.getLong(cursor.getColumnIndex(b.stopTime.name()));
                    bVar.f2791c = cursor.getString(cursor.getColumnIndex(b.reason.name()));
                    bVar.f2792d = cursor.getLong(cursor.getColumnIndex(b.retryTime.name()));
                    bVar.f2793e = cursor.getLong(cursor.getColumnIndex(b.retryCount.name()));
                    bVar.f2794f = cursor.getString(cursor.getColumnIndex(b.ext.name()));
                    bVar.f2795g = cursor.getLong(cursor.getColumnIndex(b.aliasId.name()));
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
        synchronized (f2923a) {
            SQLiteDatabase b2 = b(this.f2927e);
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
                    eVar.f2824a = cursor.getString(cursor.getColumnIndex(f.method.name()));
                    eVar.f2825b = cursor.getString(cursor.getColumnIndex(f.requestId.name()));
                    eVar.f2826c = cursor.getLong(cursor.getColumnIndex(f.timestamp.name()));
                    eVar.f2827d = cursor.getLong(cursor.getColumnIndex(f.responseTime.name()));
                    eVar.f2828e = cursor.getLong(cursor.getColumnIndex(f.errorCode.name()));
                    eVar.f2829f = cursor.getString(cursor.getColumnIndex(f.ext.name()));
                    eVar.f2830g = cursor.getLong(cursor.getColumnIndex(f.aliasId.name()));
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
        synchronized (f2923a) {
            SQLiteDatabase b2 = b(this.f2927e);
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
                    aVar.f2776a = cursor.getString(cursor.getColumnIndex(a.type.name()));
                    aVar.f2777b = cursor.getString(cursor.getColumnIndex(a.value.name()));
                    aVar.f2778c = cursor.getLong(cursor.getColumnIndex(a.timestamp.name()));
                    aVar.f2779d = cursor.getString(cursor.getColumnIndex(a.ext.name()));
                    aVar.f2780e = cursor.getLong(cursor.getColumnIndex(a.aliasId.name()));
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
        synchronized (f2923a) {
            SQLiteDatabase b2 = b(this.f2927e);
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
