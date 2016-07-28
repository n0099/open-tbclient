package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class a extends c<byte[]> {
    private String jy;

    public a(com.baidu.adp.base.a.b bVar, String str) {
        super(bVar);
        this.jy = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String F(String str) {
        this.jz.u("CREATE TABLE IF NOT EXISTS " + this.jy + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
        this.jz.u("CREATE INDEX if not exists idx_mi_ns ON " + this.jy + "(m_ns)");
        return this.jy;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void b(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int cu() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [T, byte[]] */
    @Override // com.baidu.adp.lib.cache.c
    protected h<byte[]> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor;
        Throwable th;
        h<byte[]> hVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.jA + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    hVar = new h<>();
                    hVar.jL = cursor.getString(0);
                    hVar.jM = cursor.getString(1);
                    hVar.jN = cursor.getLong(2);
                    hVar.jO = cursor.getLong(3);
                    hVar.jP = cursor.getLong(4);
                    hVar.iZ = cursor.getBlob(5);
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
        contentValues.put("m_key", hVar.jL);
        contentValues.put("m_ns", hVar.jM);
        contentValues.put("m_value", hVar.iZ);
        contentValues.put("saveTime", Long.valueOf(hVar.jN));
        contentValues.put("lastHitTime", Long.valueOf(hVar.jO));
        contentValues.put("timeToExpire", Long.valueOf(hVar.jP));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.jA + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean G(String str) {
        try {
            this.jz.ae().delete(this.jA, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.jz.d(th, "failed to clear from " + str);
            return false;
        }
    }
}
