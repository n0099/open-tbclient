package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class a extends c<byte[]> {
    private String sP;

    public a(com.baidu.adp.base.a.b bVar, String str) {
        super(bVar);
        this.sP = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String N(String str) {
        this.sQ.E("CREATE TABLE IF NOT EXISTS " + this.sP + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
        this.sQ.E("CREATE INDEX if not exists idx_mi_ns ON " + this.sP + "(m_ns)");
        return this.sP;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void a(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int fX() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [byte[], T] */
    @Override // com.baidu.adp.lib.cache.c
    protected h<byte[]> c(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        Throwable th;
        h<byte[]> hVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.sR + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    hVar = new h<>();
                    hVar.td = cursor.getString(0);
                    hVar.te = cursor.getString(1);
                    hVar.tf = cursor.getLong(2);
                    hVar.tg = cursor.getLong(3);
                    hVar.th = cursor.getLong(4);
                    hVar.sq = cursor.getBlob(5);
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
    protected ContentValues a(h<byte[]> hVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", hVar.td);
        contentValues.put("m_ns", hVar.te);
        contentValues.put("m_value", hVar.sq);
        contentValues.put("saveTime", Long.valueOf(hVar.tf));
        contentValues.put("lastHitTime", Long.valueOf(hVar.tg));
        contentValues.put("timeToExpire", Long.valueOf(hVar.th));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.sR + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean O(String str) {
        try {
            this.sQ.dL().delete(this.sR, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.sQ.d(th, "failed to clear from " + str);
            return false;
        }
    }
}
