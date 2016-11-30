package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class x extends c<String> {
    private String lQ;

    public x(com.baidu.adp.base.a.b bVar, String str) {
        super(bVar);
        this.lQ = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String G(String str) {
        this.lR.x("CREATE TABLE IF NOT EXISTS " + this.lQ + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        this.lR.x("CREATE INDEX if not exists idx_mi_ns ON " + this.lQ + "(m_ns)");
        return this.lQ;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void b(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int dp() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [T, java.lang.String] */
    @Override // com.baidu.adp.lib.cache.c
    protected h<String> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor;
        Throwable th;
        h<String> hVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.lS + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    hVar = new h<>();
                    hVar.md = cursor.getString(0);
                    hVar.mf = cursor.getString(1);
                    hVar.mg = cursor.getLong(2);
                    hVar.mh = cursor.getLong(3);
                    hVar.mi = cursor.getLong(4);
                    hVar.lp = cursor.getString(5);
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
    protected ContentValues a(h<String> hVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", hVar.md);
        contentValues.put("m_ns", hVar.mf);
        contentValues.put("m_value", hVar.lp);
        contentValues.put("saveTime", Long.valueOf(hVar.mg));
        contentValues.put("lastHitTime", Long.valueOf(hVar.mh));
        contentValues.put("timeToExpire", Long.valueOf(hVar.mi));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.lS + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean H(String str) {
        try {
            this.lR.aZ().delete(this.lS, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.lR.a(th, "clearData");
            return false;
        }
    }
}
