package com.baidu.adp.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* loaded from: classes.dex */
public final class i extends SQLiteOpenHelper {
    private static SQLiteDatabase a;
    private static Object b = new Object();

    public i(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    public final boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
            return true;
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.a(getClass(), str, th);
            return false;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i <= 0) {
            a(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS cache_meta_info(nameSpace VARCHAR(128) PRIMARY KEY, tableName varchar(64), maxSize int(11) default 0, cacheType varchar(32) not null, cacheVersion int(11) default 0, lastActiveTime bigint(21) default 0)");
    }

    public final SQLiteDatabase a() {
        if (a == null || !a.isOpen()) {
            synchronized (b) {
                if (a == null) {
                    a = getWritableDatabase();
                }
            }
        }
        return a;
    }

    public final void b() {
        close();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public final void close() {
        synchronized (b) {
            SQLiteDatabase sQLiteDatabase = a;
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b("adp_util_close", "error on close android.database.SQLiteDatabase.", e.getMessage());
                }
            }
            a = null;
        }
    }
}
