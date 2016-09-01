package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class b extends c<byte[]> {
    public b(com.baidu.adp.base.a.b bVar) {
        super(bVar);
    }

    @Override // com.baidu.adp.lib.cache.c
    public String G(String str) {
        int hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        String str2 = "cache_kv_b" + hashCode;
        this.lQ.x("CREATE TABLE IF NOT EXISTS " + str2 + "(m_key VARCHAR(64) PRIMARY KEY, saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
        return str2;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void b(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int dp() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v15, types: [T, byte[]] */
    @Override // com.baidu.adp.lib.cache.c
    protected h<byte[]> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor;
        Throwable th;
        h<byte[]> hVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.lR + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    hVar = new h<>();
                    hVar.mc = cursor.getString(0);
                    hVar.mf = cursor.getLong(1);
                    hVar.mg = cursor.getLong(2);
                    hVar.mh = cursor.getLong(3);
                    hVar.lo = cursor.getBlob(4);
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
    protected ContentValues a(h<byte[]> hVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", hVar.mc);
        contentValues.put("m_value", hVar.lo);
        contentValues.put("saveTime", Long.valueOf(hVar.mf));
        contentValues.put("lastHitTime", Long.valueOf(hVar.mg));
        contentValues.put("timeToExpire", Long.valueOf(hVar.mh));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.lR, new String[0]);
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean H(String str) {
        this.lQ.x("DROP TABLE IF EXISTS " + this.lR);
        return true;
    }
}
