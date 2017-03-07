package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class a extends c<byte[]> {
    private String tF;

    public a(com.baidu.adp.base.a.b bVar, String str) {
        super(bVar);
        this.tF = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String F(String str) {
        this.tG.u("CREATE TABLE IF NOT EXISTS " + this.tF + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
        this.tG.u("CREATE INDEX if not exists idx_mi_ns ON " + this.tF + "(m_ns)");
        return this.tF;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void b(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int ew() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [byte[], T] */
    @Override // com.baidu.adp.lib.cache.c
    protected h<byte[]> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor;
        Throwable th;
        h<byte[]> hVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.tH + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    hVar = new h<>();
                    hVar.tS = cursor.getString(0);
                    hVar.tT = cursor.getString(1);
                    hVar.tU = cursor.getLong(2);
                    hVar.tV = cursor.getLong(3);
                    hVar.tW = cursor.getLong(4);
                    hVar.te = cursor.getBlob(5);
                    com.baidu.adp.lib.g.a.a(cursor);
                } else {
                    com.baidu.adp.lib.g.a.a(cursor);
                }
                return hVar;
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.g.a.a(cursor);
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
        contentValues.put("m_key", hVar.tS);
        contentValues.put("m_ns", hVar.tT);
        contentValues.put("m_value", hVar.te);
        contentValues.put("saveTime", Long.valueOf(hVar.tU));
        contentValues.put("lastHitTime", Long.valueOf(hVar.tV));
        contentValues.put("timeToExpire", Long.valueOf(hVar.tW));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.tH + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean G(String str) {
        try {
            this.tG.ci().delete(this.tH, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.tG.a(th, "failed to clear from " + str);
            return false;
        }
    }
}
