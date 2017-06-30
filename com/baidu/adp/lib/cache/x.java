package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class x extends c<String> {
    private String tg;

    public x(com.baidu.adp.base.a.b bVar, String str) {
        super(bVar);
        this.tg = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String H(String str) {
        this.th.y("CREATE TABLE IF NOT EXISTS " + this.tg + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        this.th.y("CREATE INDEX if not exists idx_mi_ns ON " + this.tg + "(m_ns)");
        return this.tg;
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
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.ti + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    hVar = new h<>();
                    hVar.f0tv = cursor.getString(0);
                    hVar.tw = cursor.getString(1);
                    hVar.tx = cursor.getLong(2);
                    hVar.ty = cursor.getLong(3);
                    hVar.tz = cursor.getLong(4);
                    hVar.sG = cursor.getString(5);
                    com.baidu.adp.lib.g.a.e(cursor);
                } else {
                    com.baidu.adp.lib.g.a.e(cursor);
                }
                return hVar;
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
    protected ContentValues a(h<String> hVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", hVar.f0tv);
        contentValues.put("m_ns", hVar.tw);
        contentValues.put("m_value", hVar.sG);
        contentValues.put("saveTime", Long.valueOf(hVar.tx));
        contentValues.put("lastHitTime", Long.valueOf(hVar.ty));
        contentValues.put("timeToExpire", Long.valueOf(hVar.tz));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.ti + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean I(String str) {
        try {
            this.th.ch().delete(this.ti, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.th.a(th, "clearData");
            return false;
        }
    }
}
