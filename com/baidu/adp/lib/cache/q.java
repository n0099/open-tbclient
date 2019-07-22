package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class q extends c<String> {
    private String yi;

    public q(com.baidu.adp.base.a.b bVar, String str) {
        super(bVar);
        this.yi = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String ac(String str) {
        this.yj.O("CREATE TABLE IF NOT EXISTS " + this.yi + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        this.yj.O("CREATE INDEX if not exists idx_mi_ns ON " + this.yi + "(m_ns)");
        return this.yi;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void b(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int hn() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [T, java.lang.String] */
    @Override // com.baidu.adp.lib.cache.c
    protected g<String> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor;
        Throwable th;
        g<String> gVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.yk + " where m_key = ?", new String[]{str});
        } catch (Throwable th2) {
            cursor = null;
            th = th2;
        }
        try {
            if (cursor.moveToNext()) {
                gVar = new g<>();
                gVar.yv = cursor.getString(0);
                gVar.yw = cursor.getString(1);
                gVar.yx = cursor.getLong(2);
                gVar.yy = cursor.getLong(3);
                gVar.yz = cursor.getLong(4);
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
        contentValues.put("m_key", gVar.yv);
        contentValues.put("m_ns", gVar.yw);
        contentValues.put("m_value", gVar.value);
        contentValues.put("saveTime", Long.valueOf(gVar.yx));
        contentValues.put("lastHitTime", Long.valueOf(gVar.yy));
        contentValues.put("timeToExpire", Long.valueOf(gVar.yz));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.yk + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean ad(String str) {
        try {
            this.yj.fa().delete(this.yk, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.yj.c(th, "clearData");
            return false;
        }
    }
}
