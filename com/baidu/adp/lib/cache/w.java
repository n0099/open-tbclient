package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class w extends c<String> {
    private String sN;

    public w(com.baidu.adp.base.a.b bVar, String str) {
        super(bVar);
        this.sN = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String N(String str) {
        this.sO.E("CREATE TABLE IF NOT EXISTS " + this.sN + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        this.sO.E("CREATE INDEX if not exists idx_mi_ns ON " + this.sN + "(m_ns)");
        return this.sN;
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
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.sP + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    hVar = new h<>();
                    hVar.tb = cursor.getString(0);
                    hVar.tc = cursor.getString(1);
                    hVar.td = cursor.getLong(2);
                    hVar.te = cursor.getLong(3);
                    hVar.tf = cursor.getLong(4);
                    hVar.sm = cursor.getString(5);
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
        contentValues.put("m_key", hVar.tb);
        contentValues.put("m_ns", hVar.tc);
        contentValues.put("m_value", hVar.sm);
        contentValues.put("saveTime", Long.valueOf(hVar.td));
        contentValues.put("lastHitTime", Long.valueOf(hVar.te));
        contentValues.put("timeToExpire", Long.valueOf(hVar.tf));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.sP + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean O(String str) {
        try {
            this.sO.dL().delete(this.sP, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.sO.d(th, "clearData");
            return false;
        }
    }
}
