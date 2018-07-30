package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class q extends c<String> {
    private String xo;

    public q(com.baidu.adp.base.a.b bVar, String str) {
        super(bVar);
        this.xo = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String ab(String str) {
        this.xp.O("CREATE TABLE IF NOT EXISTS " + this.xo + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        this.xp.O("CREATE INDEX if not exists idx_mi_ns ON " + this.xo + "(m_ns)");
        return this.xo;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void b(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int gR() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [T, java.lang.String] */
    @Override // com.baidu.adp.lib.cache.c
    protected g<String> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor;
        Throwable th;
        g<String> gVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.xq + " where m_key = ?", new String[]{str});
        } catch (Throwable th2) {
            cursor = null;
            th = th2;
        }
        try {
            if (cursor.moveToNext()) {
                gVar = new g<>();
                gVar.xB = cursor.getString(0);
                gVar.xC = cursor.getString(1);
                gVar.xD = cursor.getLong(2);
                gVar.xE = cursor.getLong(3);
                gVar.xF = cursor.getLong(4);
                gVar.value = cursor.getString(5);
                com.baidu.adp.lib.g.a.e(cursor);
            } else {
                com.baidu.adp.lib.g.a.e(cursor);
            }
            return gVar;
        } catch (Throwable th3) {
            th = th3;
            com.baidu.adp.lib.g.a.e(cursor);
            throw th;
        }
    }

    @Override // com.baidu.adp.lib.cache.c
    protected ContentValues a(g<String> gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", gVar.xB);
        contentValues.put("m_ns", gVar.xC);
        contentValues.put("m_value", gVar.value);
        contentValues.put("saveTime", Long.valueOf(gVar.xD));
        contentValues.put("lastHitTime", Long.valueOf(gVar.xE));
        contentValues.put("timeToExpire", Long.valueOf(gVar.xF));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.xq + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean ac(String str) {
        try {
            this.xp.eD().delete(this.xq, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.xp.a(th, "clearData");
            return false;
        }
    }
}
