package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class a extends c<byte[]> {
    private String g;

    public a(com.baidu.adp.a.h hVar, String str) {
        super(hVar);
        this.g = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String a(String str) {
        this.a.a(this.a.a(), "CREATE TABLE IF NOT EXISTS " + this.g + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
        this.a.a(this.a.a(), "CREATE INDEX if not exists idx_mi_ns ON " + this.g + "(m_ns)");
        return this.g;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void a(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int a() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [T, byte[]] */
    @Override // com.baidu.adp.lib.cache.c
    protected m<byte[]> a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        Throwable th;
        m<byte[]> mVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.b + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    mVar = new m<>();
                    mVar.a = cursor.getString(0);
                    mVar.c = cursor.getString(1);
                    mVar.d = cursor.getLong(2);
                    mVar.e = cursor.getLong(3);
                    mVar.f = cursor.getLong(4);
                    mVar.b = cursor.getBlob(5);
                    com.baidu.adp.lib.f.a.a(cursor);
                } else {
                    com.baidu.adp.lib.f.a.a(cursor);
                }
                return mVar;
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.f.a.a(cursor);
                throw th;
            }
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
        }
    }

    @Override // com.baidu.adp.lib.cache.c
    protected ContentValues a(m<byte[]> mVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", mVar.a);
        contentValues.put("m_ns", mVar.c);
        contentValues.put("m_value", mVar.b);
        contentValues.put("saveTime", Long.valueOf(mVar.d));
        contentValues.put("lastHitTime", Long.valueOf(mVar.e));
        contentValues.put("timeToExpire", Long.valueOf(mVar.f));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor b(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.b + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean b(String str) {
        try {
            this.a.a().delete(this.b, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.a.a(th);
            com.baidu.adp.lib.util.f.a(getClass(), "failed to clear from " + str, th);
            return false;
        }
    }
}
