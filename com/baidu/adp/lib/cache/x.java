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
    public String M(String str) {
        int hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        String str2 = "cache_kv_t" + hashCode;
        this.tj.D("CREATE TABLE IF NOT EXISTS " + str2 + "(m_key VARCHAR(64) PRIMARY KEY, saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        return str2;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void a(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int gg() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v15, types: [T, java.lang.String] */
    @Override // com.baidu.adp.lib.cache.c
    protected h<String> c(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        Throwable th;
        h<String> hVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.tk + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    hVar = new h<>();
                    hVar.tx = cursor.getString(0);
                    hVar.tz = cursor.getLong(1);
                    hVar.tA = cursor.getLong(2);
                    hVar.tB = cursor.getLong(3);
                    hVar.sI = cursor.getString(4);
                    com.baidu.adp.lib.h.a.a(cursor);
                } else {
                    com.baidu.adp.lib.h.a.a(cursor);
                }
                return hVar;
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.h.a.a(cursor);
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
        contentValues.put("m_key", hVar.tx);
        contentValues.put("m_value", hVar.sI);
        contentValues.put("saveTime", Long.valueOf(hVar.tz));
        contentValues.put("lastHitTime", Long.valueOf(hVar.tA));
        contentValues.put("timeToExpire", Long.valueOf(hVar.tB));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.tk, new String[0]);
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean N(String str) {
        this.tj.D("DROP TABLE IF EXISTS " + this.tk);
        return true;
    }
}
