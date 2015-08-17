package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class a extends c<byte[]> {
    private String sO;

    public a(com.baidu.adp.base.a.b bVar, String str) {
        super(bVar);
        this.sO = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String P(String str) {
        this.sP.E("CREATE TABLE IF NOT EXISTS " + this.sO + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
        this.sP.E("CREATE INDEX if not exists idx_mi_ns ON " + this.sO + "(m_ns)");
        return this.sO;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void a(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int ga() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [T, byte[]] */
    @Override // com.baidu.adp.lib.cache.c
    protected h<byte[]> c(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        Throwable th;
        h<byte[]> hVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.sQ + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    hVar = new h<>();
                    hVar.tc = cursor.getString(0);
                    hVar.td = cursor.getString(1);
                    hVar.te = cursor.getLong(2);
                    hVar.tf = cursor.getLong(3);
                    hVar.tg = cursor.getLong(4);
                    hVar.so = cursor.getBlob(5);
                    com.baidu.adp.lib.g.a.b(cursor);
                } else {
                    com.baidu.adp.lib.g.a.b(cursor);
                }
                return hVar;
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.g.a.b(cursor);
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
        contentValues.put("m_key", hVar.tc);
        contentValues.put("m_ns", hVar.td);
        contentValues.put("m_value", hVar.so);
        contentValues.put("saveTime", Long.valueOf(hVar.te));
        contentValues.put("lastHitTime", Long.valueOf(hVar.tf));
        contentValues.put("timeToExpire", Long.valueOf(hVar.tg));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.sQ + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean Q(String str) {
        try {
            this.sP.dL().delete(this.sQ, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.sP.a(th, "failed to clear from " + str);
            return false;
        }
    }
}
