package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class w extends c<String> {
    private String sM;

    public w(com.baidu.adp.base.a.b bVar, String str) {
        super(bVar);
        this.sM = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String P(String str) {
        this.sN.E("CREATE TABLE IF NOT EXISTS " + this.sM + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        this.sN.E("CREATE INDEX if not exists idx_mi_ns ON " + this.sM + "(m_ns)");
        return this.sM;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void a(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int fX() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [T, java.lang.String] */
    @Override // com.baidu.adp.lib.cache.c
    protected h<String> c(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        Throwable th;
        h<String> hVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.sO + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    hVar = new h<>();
                    hVar.sZ = cursor.getString(0);
                    hVar.tb = cursor.getString(1);
                    hVar.tc = cursor.getLong(2);
                    hVar.td = cursor.getLong(3);
                    hVar.te = cursor.getLong(4);
                    hVar.sl = cursor.getString(5);
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
    protected ContentValues a(h<String> hVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", hVar.sZ);
        contentValues.put("m_ns", hVar.tb);
        contentValues.put("m_value", hVar.sl);
        contentValues.put("saveTime", Long.valueOf(hVar.tc));
        contentValues.put("lastHitTime", Long.valueOf(hVar.td));
        contentValues.put("timeToExpire", Long.valueOf(hVar.te));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.sO + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean Q(String str) {
        try {
            this.sN.dL().delete(this.sO, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.sN.a(th, "clearData");
            return false;
        }
    }
}
