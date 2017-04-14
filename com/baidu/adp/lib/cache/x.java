package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class x extends c<String> {
    private String tb;

    public x(com.baidu.adp.base.a.b bVar, String str) {
        super(bVar);
        this.tb = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String C(String str) {
        this.tc.r("CREATE TABLE IF NOT EXISTS " + this.tb + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        this.tc.r("CREATE INDEX if not exists idx_mi_ns ON " + this.tb + "(m_ns)");
        return this.tb;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void b(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int ev() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [T, java.lang.String] */
    @Override // com.baidu.adp.lib.cache.c
    protected h<String> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor;
        Throwable th;
        h<String> hVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.td + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    hVar = new h<>();
                    hVar.tq = cursor.getString(0);
                    hVar.tr = cursor.getString(1);
                    hVar.ts = cursor.getLong(2);
                    hVar.tt = cursor.getLong(3);
                    hVar.tu = cursor.getLong(4);
                    hVar.sB = cursor.getString(5);
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
    protected ContentValues a(h<String> hVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", hVar.tq);
        contentValues.put("m_ns", hVar.tr);
        contentValues.put("m_value", hVar.sB);
        contentValues.put("saveTime", Long.valueOf(hVar.ts));
        contentValues.put("lastHitTime", Long.valueOf(hVar.tt));
        contentValues.put("timeToExpire", Long.valueOf(hVar.tu));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.td + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean D(String str) {
        try {
            this.tc.ch().delete(this.td, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.tc.a(th, "clearData");
            return false;
        }
    }
}
