package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class w extends c<String> {
    private String sY;

    public w(com.baidu.adp.base.a.b bVar, String str) {
        super(bVar);
        this.sY = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String M(String str) {
        this.sZ.D("CREATE TABLE IF NOT EXISTS " + this.sY + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        this.sZ.D("CREATE INDEX if not exists idx_mi_ns ON " + this.sY + "(m_ns)");
        return this.sY;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void a(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int gg() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [T, java.lang.String] */
    @Override // com.baidu.adp.lib.cache.c
    protected h<String> c(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        Throwable th;
        h<String> hVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.tb + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    hVar = new h<>();
                    hVar.tm = cursor.getString(0);
                    hVar.tp = cursor.getString(1);
                    hVar.tq = cursor.getLong(2);
                    hVar.tr = cursor.getLong(3);
                    hVar.ts = cursor.getLong(4);
                    hVar.sz = cursor.getString(5);
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
        contentValues.put("m_key", hVar.tm);
        contentValues.put("m_ns", hVar.tp);
        contentValues.put("m_value", hVar.sz);
        contentValues.put("saveTime", Long.valueOf(hVar.tq));
        contentValues.put("lastHitTime", Long.valueOf(hVar.tr));
        contentValues.put("timeToExpire", Long.valueOf(hVar.ts));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.tb + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean N(String str) {
        try {
            this.sZ.dO().delete(this.tb, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.sZ.d(th, "clearData");
            return false;
        }
    }
}
