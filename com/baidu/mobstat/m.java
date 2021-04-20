package com.baidu.mobstat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
/* loaded from: classes2.dex */
public class m extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public String f8818a;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f8819b;

    public m(Context context, String str) throws SQLiteException {
        super(context, ".confd", (SQLiteDatabase.CursorFactory) null, 1);
        this.f8818a = str;
    }

    public synchronized boolean a() {
        boolean z;
        z = false;
        if (this.f8819b == null || !this.f8819b.isOpen()) {
            try {
                this.f8819b = getWritableDatabase();
            } catch (NullPointerException unused) {
                throw new NullPointerException("db path is null");
            }
        }
        if (this.f8819b != null && this.f8819b.isOpen()) {
            z = true;
        }
        return z;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public final int b() {
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f8819b;
            cursor = sQLiteDatabase.rawQuery("SELECT COUNT(*) FROM " + this.f8818a, null);
            if (cursor == null || !cursor.moveToNext()) {
                if (cursor != null) {
                    cursor.close();
                }
                return 0;
            }
            return cursor.getInt(0);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
        super.close();
        if (this.f8819b != null) {
            this.f8819b.close();
            this.f8819b = null;
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
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f8819b = sQLiteDatabase;
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

    public Cursor a(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        return this.f8819b.query(this.f8818a, strArr, str, strArr2, str2, str3, str4, str5);
    }

    public long a(String str, ContentValues contentValues) {
        return this.f8819b.insert(this.f8818a, str, contentValues);
    }

    public int a(String str, String[] strArr) {
        return this.f8819b.delete(this.f8818a, str, strArr);
    }
}
