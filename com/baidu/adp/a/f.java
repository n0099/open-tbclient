package com.baidu.adp.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* loaded from: classes.dex */
public class f extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static SQLiteDatabase f352a;
    private static Object b = new Object();

    public f(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    public boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
            return true;
        } catch (Throwable th) {
            com.baidu.adp.lib.f.d.a(getClass(), str, th);
            return false;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 1) {
            a(sQLiteDatabase);
        }
    }

    protected void a(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS cache_meta_info(nameSpace VARCHAR(128) PRIMARY KEY, tableName varchar(64), maxSize int(11) default 0, cacheType varchar(32) not null, cacheVersion int(11) default 0, lastActiveTime bigint(21) default 0)");
    }

    public SQLiteDatabase a() {
        if (f352a == null || !f352a.isOpen()) {
            synchronized (b) {
                if (f352a == null) {
                    f352a = getWritableDatabase();
                }
            }
        }
        return f352a;
    }

    public void a(Throwable th) {
        close();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
        synchronized (b) {
            com.baidu.adp.lib.d.a.a(f352a);
            f352a = null;
        }
    }
}
