package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class w extends a {
    public w(com.baidu.adp.a.f fVar) {
        super(fVar);
    }

    @Override // com.baidu.adp.lib.cache.a
    public String a(String str) {
        String str2 = "cache_kv_t" + Math.abs(str.hashCode());
        this.f369a.a(this.f369a.a(), "CREATE TABLE IF NOT EXISTS " + str2 + "(m_key VARCHAR(64) PRIMARY KEY, saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        return str2;
    }

    @Override // com.baidu.adp.lib.cache.a
    public void a(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.a
    public int a() {
        return 1;
    }

    @Override // com.baidu.adp.lib.cache.a
    protected k b(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        Throwable th;
        k kVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.b + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    kVar = new k();
                    kVar.f374a = cursor.getString(0);
                    kVar.d = cursor.getLong(1);
                    kVar.e = cursor.getLong(2);
                    kVar.f = cursor.getLong(3);
                    kVar.b = cursor.getString(4);
                    com.baidu.adp.lib.e.b.a(cursor);
                } else {
                    com.baidu.adp.lib.e.b.a(cursor);
                }
                return kVar;
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.e.b.a(cursor);
                throw th;
            }
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
        }
    }

    @Override // com.baidu.adp.lib.cache.a
    protected ContentValues a(k kVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", kVar.f374a);
        contentValues.put("m_value", (String) kVar.b);
        contentValues.put("saveTime", Long.valueOf(kVar.d));
        contentValues.put("lastHitTime", Long.valueOf(kVar.e));
        contentValues.put("timeToExpire", Long.valueOf(kVar.f));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.a
    public Cursor a(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.b, new String[0]);
    }
}
