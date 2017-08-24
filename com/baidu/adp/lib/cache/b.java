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
    public String Q(String str) {
        int hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        String str2 = "cache_kv_b" + hashCode;
        this.uQ.F("CREATE TABLE IF NOT EXISTS " + str2 + "(m_key VARCHAR(64) PRIMARY KEY, saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
        return str2;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void b(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int eE() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v15, types: [byte[], T] */
    @Override // com.baidu.adp.lib.cache.c
    protected g<byte[]> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor;
        Throwable th;
        g<byte[]> gVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.uR + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    gVar = new g<>();
                    gVar.vc = cursor.getString(0);
                    gVar.ve = cursor.getLong(1);
                    gVar.vf = cursor.getLong(2);
                    gVar.vg = cursor.getLong(3);
                    gVar.up = cursor.getBlob(4);
                    com.baidu.adp.lib.g.a.e(cursor);
                } else {
                    com.baidu.adp.lib.g.a.e(cursor);
                }
                return gVar;
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.g.a.e(cursor);
                throw th;
            }
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
        }
    }

    @Override // com.baidu.adp.lib.cache.c
    protected ContentValues a(g<byte[]> gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", gVar.vc);
        contentValues.put("m_value", gVar.up);
        contentValues.put("saveTime", Long.valueOf(gVar.ve));
        contentValues.put("lastHitTime", Long.valueOf(gVar.vf));
        contentValues.put("timeToExpire", Long.valueOf(gVar.vg));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.uR, new String[0]);
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean R(String str) {
        this.uQ.F("DROP TABLE IF EXISTS " + this.uR);
        return true;
    }
}
