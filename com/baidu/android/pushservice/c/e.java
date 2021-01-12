package com.baidu.android.pushservice.c;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.http.Headers;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes14.dex */
public class e {
    @SuppressLint({"StaticFieldLeak"})
    private static e d;
    private Context e;

    /* renamed from: b  reason: collision with root package name */
    private static String f1247b = "PushTrackDatabase";
    private static C0041e c = null;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f1246a = new Object();

    /* loaded from: classes14.dex */
    enum a {
        ackId,
        type,
        value,
        timestamp,
        ext,
        aliasId
    }

    /* loaded from: classes14.dex */
    enum b {
        connectionId,
        startTime,
        stopTime,
        reason,
        retryTime,
        retryCount,
        ext,
        aliasId
    }

    /* loaded from: classes14.dex */
    enum c {
        crashId,
        exception,
        timestamp,
        ext,
        aliasId
    }

    /* loaded from: classes14.dex */
    enum d {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.android.pushservice.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0041e extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        private static final String f1256a = "CREATE TABLE crash (" + c.crashId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + c.exception.name() + " TEXT, " + c.timestamp.name() + " LONG, " + c.ext.name() + " TEXT, " + c.aliasId.name() + " LONG NOT NULL );";

        /* renamed from: b  reason: collision with root package name */
        private static final String f1257b = "CREATE TABLE db (" + d.dbId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + d.tableName.name() + " TEXT, " + d.className.name() + " TEXT, " + d.method.name() + " TEXT, " + d.action.name() + " TEXT, " + d.startTime.name() + " LONG, " + d.endTime.name() + " LONG, " + d.duration.name() + " LONG, " + d.ext.name() + " TEXT, " + d.aliasId.name() + " LONG NOT NULL );";
        private static final String c = "CREATE TABLE connection (" + b.connectionId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + b.startTime.name() + " LONG, " + b.stopTime.name() + " LONG, " + b.reason.name() + " TEXT, " + b.retryTime.name() + " LONG, " + b.retryCount.name() + " LONG, " + b.ext.name() + " TEXT, " + b.aliasId.name() + " LONG NOT NULL );";
        private static final String d = "CREATE TABLE request (" + f.id.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.method.name() + " TEXT, " + f.requestId.name() + " TEXT, " + f.timestamp.name() + " LONG, " + f.responseTime.name() + " LONG, " + f.errorCode.name() + " LONG, " + f.ext.name() + " TEXT, " + f.aliasId.name() + " LONG NOT NULL);";
        private static final String e = "CREATE TABLE ack (" + a.ackId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + a.type.name() + " TEXT, " + a.value.name() + " TEXT, " + a.timestamp.name() + " LONG, " + a.ext.name() + " TEXT, " + a.aliasId.name() + " LONG NOT NULL);";
        private Context f;

        public C0041e(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
            this.f = context;
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS crash");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS connection");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS request");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS db");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ack");
            } catch (Exception e2) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(f1256a);
                sQLiteDatabase.execSQL(f1257b);
                sQLiteDatabase.execSQL(c);
                sQLiteDatabase.execSQL(d);
                sQLiteDatabase.execSQL(e);
            } catch (Exception e2) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            a(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    /* loaded from: classes14.dex */
    enum f {
        id,
        method,
        requestId,
        timestamp,
        responseTime,
        errorCode,
        ext,
        aliasId
    }

    private e(Context context) {
        this.e = context;
        c = new C0041e(context, "push_track.db", 1);
    }

    public static e a(Context context) {
        if (d == null) {
            synchronized (f1246a) {
                if (d == null) {
                    d = new e(context.getApplicationContext());
                }
            }
        }
        return d;
    }

    private static SQLiteDatabase b(Context context) {
        if (c == null) {
            c = new C0041e(context, "push_track.db", 1);
        }
        try {
            return c.getWritableDatabase();
        } catch (Throwable th) {
            return null;
        }
    }

    public List<com.baidu.android.pushservice.c.a.c> a() {
        Cursor cursor = null;
        synchronized (f1246a) {
            SQLiteDatabase b2 = b(this.e);
            if (b2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                Cursor rawQuery = b2.rawQuery("select * from crash limit 1000", null);
                while (rawQuery != null && rawQuery.moveToNext()) {
                    com.baidu.android.pushservice.c.a.c cVar = new com.baidu.android.pushservice.c.a.c();
                    cVar.f1214a = rawQuery.getString(rawQuery.getColumnIndex(c.exception.name()));
                    cVar.f1215b = rawQuery.getLong(rawQuery.getColumnIndex(c.timestamp.name()));
                    cVar.c = rawQuery.getString(rawQuery.getColumnIndex(c.ext.name()));
                    cVar.d = rawQuery.getLong(rawQuery.getColumnIndex(c.aliasId.name()));
                    arrayList.add(cVar);
                }
                cursor = b2.rawQuery("select count(*) from crash", null);
                if (cursor != null && cursor.moveToFirst() && cursor.getInt(0) > 1000) {
                    b2.delete("crash", null, null);
                }
                if (cursor != null) {
                    cursor.close();
                }
                b2.close();
            } catch (Exception e) {
                if (cursor != null) {
                    cursor.close();
                }
                b2.close();
            }
            return arrayList;
        }
    }

    public void a(com.baidu.android.pushservice.c.a.a aVar) {
        synchronized (f1246a) {
            SQLiteDatabase b2 = b(this.e);
            if (b2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(a.type.name(), aVar.f1206a);
                contentValues.put(a.value.name(), aVar.f1207b);
                contentValues.put(a.timestamp.name(), Long.valueOf(aVar.c));
                contentValues.put(a.ext.name(), aVar.d);
                contentValues.put(a.aliasId.name(), Long.valueOf(aVar.e));
                b2.insert("ack", null, contentValues);
                b2.close();
            } catch (Exception e) {
                b2.close();
            } catch (Throwable th) {
                b2.close();
                throw th;
            }
        }
    }

    public void a(com.baidu.android.pushservice.c.a.b bVar) {
        synchronized (f1246a) {
            SQLiteDatabase b2 = b(this.e);
            if (b2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(b.startTime.name(), Long.valueOf(bVar.f1210a));
                contentValues.put(b.stopTime.name(), Long.valueOf(bVar.f1211b));
                contentValues.put(b.reason.name(), bVar.c);
                contentValues.put(b.retryTime.name(), Long.valueOf(bVar.d));
                contentValues.put(b.retryCount.name(), Long.valueOf(bVar.e));
                contentValues.put(b.ext.name(), bVar.f);
                contentValues.put(b.aliasId.name(), Long.valueOf(bVar.g));
                b2.insert(Headers.CONN_DIRECTIVE, null, contentValues);
                b2.close();
            } catch (Exception e) {
                b2.close();
            } catch (Throwable th) {
                b2.close();
                throw th;
            }
        }
    }

    public void a(com.baidu.android.pushservice.c.a.c cVar) {
        synchronized (f1246a) {
            SQLiteDatabase b2 = b(this.e);
            if (b2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(c.exception.name(), cVar.f1214a);
                contentValues.put(c.timestamp.name(), Long.valueOf(cVar.f1215b));
                contentValues.put(c.ext.name(), cVar.c);
                contentValues.put(c.aliasId.name(), Long.valueOf(cVar.d));
                b2.insert("crash", null, contentValues);
                b2.close();
            } catch (Exception e) {
                b2.close();
            }
        }
    }

    public void a(com.baidu.android.pushservice.c.a.d dVar) {
        synchronized (f1246a) {
            SQLiteDatabase b2 = b(this.e);
            if (b2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(d.tableName.name(), dVar.f1218a);
                contentValues.put(d.className.name(), dVar.f1219b);
                contentValues.put(d.method.name(), dVar.c);
                contentValues.put(d.action.name(), dVar.d);
                contentValues.put(d.startTime.name(), Long.valueOf(dVar.e));
                contentValues.put(d.endTime.name(), Long.valueOf(dVar.f));
                contentValues.put(d.duration.name(), Long.valueOf(dVar.g));
                contentValues.put(d.ext.name(), dVar.h);
                contentValues.put(d.aliasId.name(), Long.valueOf(dVar.i));
                b2.insert(BdStatsConstant.OpSubType.DB, null, contentValues);
                b2.close();
            } catch (Exception e) {
                b2.close();
            }
        }
    }

    public void a(com.baidu.android.pushservice.c.a.e eVar) {
        synchronized (f1246a) {
            SQLiteDatabase b2 = b(this.e);
            if (b2 == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(f.method.name(), eVar.f1220a);
                contentValues.put(f.requestId.name(), eVar.f1221b);
                contentValues.put(f.timestamp.name(), Long.valueOf(eVar.c));
                contentValues.put(f.responseTime.name(), Long.valueOf(eVar.d));
                contentValues.put(f.errorCode.name(), Long.valueOf(eVar.e));
                contentValues.put(f.ext.name(), eVar.f);
                contentValues.put(f.aliasId.name(), Long.valueOf(eVar.g));
                b2.insert("request", null, contentValues);
                b2.close();
            } catch (Exception e) {
                b2.close();
            } catch (Throwable th) {
                b2.close();
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE] complete} */
    public List<com.baidu.android.pushservice.c.a.d> b() {
        Cursor cursor = null;
        synchronized (f1246a) {
            SQLiteDatabase b2 = b(this.e);
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
                    dVar.f1218a = cursor.getString(cursor.getColumnIndex(d.tableName.name()));
                    dVar.f1219b = cursor.getString(cursor.getColumnIndex(d.className.name()));
                    dVar.c = cursor.getString(cursor.getColumnIndex(d.method.name()));
                    dVar.d = cursor.getString(cursor.getColumnIndex(d.action.name()));
                    dVar.e = cursor.getLong(cursor.getColumnIndex(d.startTime.name()));
                    dVar.f = cursor.getLong(cursor.getColumnIndex(d.endTime.name()));
                    dVar.g = cursor.getLong(cursor.getColumnIndex(d.duration.name()));
                    dVar.h = cursor.getString(cursor.getColumnIndex(d.ext.name()));
                    dVar.i = cursor.getLong(cursor.getColumnIndex(d.aliasId.name()));
                    arrayList.add(dVar);
                }
                if (cursor != null) {
                    cursor.close();
                }
                b2.close();
            } catch (Exception e) {
                if (cursor != null) {
                    cursor.close();
                }
                b2.close();
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                b2.close();
                throw th;
            }
            return arrayList;
        }
    }

    public List<com.baidu.android.pushservice.c.a.b> c() {
        Cursor cursor = null;
        synchronized (f1246a) {
            SQLiteDatabase b2 = b(this.e);
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
                    bVar.f1210a = cursor.getLong(cursor.getColumnIndex(b.startTime.name()));
                    bVar.f1211b = cursor.getLong(cursor.getColumnIndex(b.stopTime.name()));
                    bVar.c = cursor.getString(cursor.getColumnIndex(b.reason.name()));
                    bVar.d = cursor.getLong(cursor.getColumnIndex(b.retryTime.name()));
                    bVar.e = cursor.getLong(cursor.getColumnIndex(b.retryCount.name()));
                    bVar.f = cursor.getString(cursor.getColumnIndex(b.ext.name()));
                    bVar.g = cursor.getLong(cursor.getColumnIndex(b.aliasId.name()));
                    arrayList.add(bVar);
                }
                if (cursor != null) {
                    cursor.close();
                }
                b2.close();
            } catch (Exception e) {
                if (cursor != null) {
                    cursor.close();
                }
                b2.close();
            }
            return arrayList;
        }
    }

    public List<com.baidu.android.pushservice.c.a.e> d() {
        Cursor cursor = null;
        synchronized (f1246a) {
            SQLiteDatabase b2 = b(this.e);
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
                    eVar.f1220a = cursor.getString(cursor.getColumnIndex(f.method.name()));
                    eVar.f1221b = cursor.getString(cursor.getColumnIndex(f.requestId.name()));
                    eVar.c = cursor.getLong(cursor.getColumnIndex(f.timestamp.name()));
                    eVar.d = cursor.getLong(cursor.getColumnIndex(f.responseTime.name()));
                    eVar.e = cursor.getLong(cursor.getColumnIndex(f.errorCode.name()));
                    eVar.f = cursor.getString(cursor.getColumnIndex(f.ext.name()));
                    eVar.g = cursor.getLong(cursor.getColumnIndex(f.aliasId.name()));
                    arrayList.add(eVar);
                }
                if (cursor != null) {
                    cursor.close();
                }
                b2.close();
            } catch (Exception e) {
                if (cursor != null) {
                    cursor.close();
                }
                b2.close();
            }
            return arrayList;
        }
    }

    public List<com.baidu.android.pushservice.c.a.a> e() {
        Cursor cursor = null;
        synchronized (f1246a) {
            SQLiteDatabase b2 = b(this.e);
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
                    aVar.f1206a = cursor.getString(cursor.getColumnIndex(a.type.name()));
                    aVar.f1207b = cursor.getString(cursor.getColumnIndex(a.value.name()));
                    aVar.c = cursor.getLong(cursor.getColumnIndex(a.timestamp.name()));
                    aVar.d = cursor.getString(cursor.getColumnIndex(a.ext.name()));
                    aVar.e = cursor.getLong(cursor.getColumnIndex(a.aliasId.name()));
                    arrayList.add(aVar);
                }
                if (cursor != null) {
                    cursor.close();
                }
                b2.close();
            } catch (Exception e) {
                if (cursor != null) {
                    cursor.close();
                }
                b2.close();
            }
            return arrayList;
        }
    }

    public void f() {
        synchronized (f1246a) {
            SQLiteDatabase b2 = b(this.e);
            if (b2 == null) {
                return;
            }
            try {
                b2.delete("crash", null, null);
                b2.delete(BdStatsConstant.OpSubType.DB, null, null);
                b2.delete(Headers.CONN_DIRECTIVE, null, null);
                b2.delete("request", null, null);
                b2.delete("ack", null, null);
                b2.close();
            } catch (Exception e) {
                b2.close();
            } catch (Throwable th) {
                b2.close();
                throw th;
            }
        }
    }
}
