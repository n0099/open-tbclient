package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class a extends c<byte[]> {
    private String rj;

    public a(com.baidu.adp.base.a.b bVar, String str) {
        super(bVar);
        this.rj = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String O(String str) {
        this.rk.C("CREATE TABLE IF NOT EXISTS " + this.rj + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
        this.rk.C("CREATE INDEX if not exists idx_mi_ns ON " + this.rj + "(m_ns)");
        return this.rj;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void b(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int eb() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [byte[], T] */
    @Override // com.baidu.adp.lib.cache.c
    protected g<byte[]> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor;
        Throwable th;
        g<byte[]> gVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.rl + " where m_key = ?", new String[]{str});
        } catch (Throwable th2) {
            cursor = null;
            th = th2;
        }
        try {
            if (cursor.moveToNext()) {
                gVar = new g<>();
                gVar.rx = cursor.getString(0);
                gVar.ry = cursor.getString(1);
                gVar.rz = cursor.getLong(2);
                gVar.rA = cursor.getLong(3);
                gVar.rB = cursor.getLong(4);
                gVar.value = cursor.getBlob(5);
                com.baidu.adp.lib.g.a.e(cursor);
            } else {
                com.baidu.adp.lib.g.a.e(cursor);
            }
            return gVar;
        } catch (Throwable th3) {
            th = th3;
            com.baidu.adp.lib.g.a.e(cursor);
            throw th;
        }
    }

    @Override // com.baidu.adp.lib.cache.c
    protected ContentValues a(g<byte[]> gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", gVar.rx);
        contentValues.put("m_ns", gVar.ry);
        contentValues.put("m_value", gVar.value);
        contentValues.put("saveTime", Long.valueOf(gVar.rz));
        contentValues.put("lastHitTime", Long.valueOf(gVar.rA));
        contentValues.put("timeToExpire", Long.valueOf(gVar.rB));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.rl + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean P(String str) {
        try {
            this.rk.bQ().delete(this.rl, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.rk.a(th, "failed to clear from " + str);
            return false;
        }
    }
}
