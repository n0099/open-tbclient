package com.baidu.mobstat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
/* loaded from: classes17.dex */
class m extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private String f2625a;
    private SQLiteDatabase b;

    public m(Context context, String str) throws SQLiteException {
        super(context, ".confd", (SQLiteDatabase.CursorFactory) null, 1);
        this.f2625a = str;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.b = sQLiteDatabase;
    }

    public synchronized boolean a() {
        boolean z;
        boolean z2 = true;
        synchronized (this) {
            if (this.b == null) {
                z = true;
            } else {
                z = !this.b.isOpen();
            }
            if (z) {
                try {
                    this.b = getWritableDatabase();
                } catch (NullPointerException e) {
                    throw new NullPointerException("db path is null");
                }
            }
            if (this.b == null || !this.b.isOpen()) {
                z2 = false;
            }
        }
        return z2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
        super.close();
        if (this.b != null) {
            this.b.close();
            this.b = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void a(String str) {
        getWritableDatabase().execSQL(str);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public final int b() {
        Cursor cursor = null;
        int i = 0;
        try {
            cursor = this.b.rawQuery("SELECT COUNT(*) FROM " + this.f2625a, null);
            if (cursor != null && cursor.moveToNext()) {
                i = cursor.getInt(0);
            } else if (cursor != null) {
                cursor.close();
            }
            return i;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public Cursor a(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        return this.b.query(this.f2625a, strArr, str, strArr2, str2, str3, str4, str5);
    }

    public long a(String str, ContentValues contentValues) {
        return this.b.insert(this.f2625a, str, contentValues);
    }

    public int a(String str, String[] strArr) {
        return this.b.delete(this.f2625a, str, strArr);
    }
}
