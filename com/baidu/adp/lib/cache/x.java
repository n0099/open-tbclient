package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class x extends c<String> {
    public x(com.baidu.adp.base.a.b bVar) {
        super(bVar);
    }

    @Override // com.baidu.adp.lib.cache.c
    public String N(String str) {
        int hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        String str2 = "cache_kv_t" + hashCode;
        this.sQ.E("CREATE TABLE IF NOT EXISTS " + str2 + "(m_key VARCHAR(64) PRIMARY KEY, saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        return str2;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void a(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int fX() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v15, types: [T, java.lang.String] */
    @Override // com.baidu.adp.lib.cache.c
    protected h<String> c(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        Throwable th;
        h<String> hVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.sR + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    hVar = new h<>();
                    hVar.td = cursor.getString(0);
                    hVar.tf = cursor.getLong(1);
                    hVar.tg = cursor.getLong(2);
                    hVar.th = cursor.getLong(3);
                    hVar.sq = cursor.getString(4);
                    com.baidu.adp.lib.h.a.b(cursor);
                } else {
                    com.baidu.adp.lib.h.a.b(cursor);
                }
                return hVar;
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.h.a.b(cursor);
                throw th;
            }
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
        }
    }

    @Override // com.baidu.adp.lib.cache.c
    protected ContentValues a(h<String> hVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", hVar.td);
        contentValues.put("m_value", hVar.sq);
        contentValues.put("saveTime", Long.valueOf(hVar.tf));
        contentValues.put("lastHitTime", Long.valueOf(hVar.tg));
        contentValues.put("timeToExpire", Long.valueOf(hVar.th));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.sR, new String[0]);
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean O(String str) {
        this.sQ.E("DROP TABLE IF EXISTS " + this.sR);
        return true;
    }
}
