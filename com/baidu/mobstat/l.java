package com.baidu.mobstat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
/* loaded from: classes3.dex */
public class l extends SQLiteOpenHelper {
    public String a;
    public SQLiteDatabase b;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public l(Context context, String str) throws SQLiteException {
        super(context, y.e, (SQLiteDatabase.CursorFactory) null, 1);
        this.a = str;
    }

    public int a(String str, String[] strArr) {
        return this.b.delete(this.a, str, strArr);
    }

    public long a(String str, ContentValues contentValues) {
        return this.b.insert(this.a, str, contentValues);
    }

    public Cursor a(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        return this.b.query(this.a, strArr, str, strArr2, str2, str3, str4, str5);
    }

    public void a(String str) {
        getWritableDatabase().execSQL(str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.b = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
    }

    public synchronized boolean a() {
        boolean z;
        boolean z2;
        z = false;
        if (this.b == null || !this.b.isOpen()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            try {
                this.b = getWritableDatabase();
            } catch (NullPointerException unused) {
                throw new NullPointerException("db path is null");
            }
        }
        if (this.b != null && this.b.isOpen()) {
            z = true;
        }
        return z;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public final int b() {
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.b;
            cursor = sQLiteDatabase.rawQuery("SELECT COUNT(*) FROM " + this.a, null);
            if (cursor != null && cursor.moveToNext()) {
                return cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
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
}
