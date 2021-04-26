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
    public String f9133a;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f9134b;

    public m(Context context, String str) throws SQLiteException {
        super(context, ".confd", (SQLiteDatabase.CursorFactory) null, 1);
        this.f9133a = str;
    }

    public synchronized boolean a() {
        boolean z;
        z = false;
        if (this.f9134b == null || !this.f9134b.isOpen()) {
            try {
                this.f9134b = getWritableDatabase();
            } catch (NullPointerException unused) {
                throw new NullPointerException("db path is null");
            }
        }
        if (this.f9134b != null && this.f9134b.isOpen()) {
            z = true;
        }
        return z;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public final int b() {
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f9134b;
            cursor = sQLiteDatabase.rawQuery("SELECT COUNT(*) FROM " + this.f9133a, null);
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
        if (this.f9134b != null) {
            this.f9134b.close();
            this.f9134b = null;
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
        this.f9134b = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    public void a(String str) {
        getWritableDatabase().execSQL(str);
    }

    public Cursor a(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        return this.f9134b.query(this.f9133a, strArr, str, strArr2, str2, str3, str4, str5);
    }

    public long a(String str, ContentValues contentValues) {
        return this.f9134b.insert(this.f9133a, str, contentValues);
    }

    public int a(String str, String[] strArr) {
        return this.f9134b.delete(this.f9133a, str, strArr);
    }
}
