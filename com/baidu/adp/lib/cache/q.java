package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class q extends c<String> {
    private String yc;

    public q(com.baidu.adp.base.a.b bVar, String str) {
        super(bVar);
        this.yc = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String ab(String str) {
        this.yd.O("CREATE TABLE IF NOT EXISTS " + this.yc + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        this.yd.O("CREATE INDEX if not exists idx_mi_ns ON " + this.yc + "(m_ns)");
        return this.yc;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void b(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int he() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [T, java.lang.String] */
    @Override // com.baidu.adp.lib.cache.c
    protected g<String> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor;
        Throwable th;
        g<String> gVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.ye + " where m_key = ?", new String[]{str});
        } catch (Throwable th2) {
            cursor = null;
            th = th2;
        }
        try {
            if (cursor.moveToNext()) {
                gVar = new g<>();
                gVar.yp = cursor.getString(0);
                gVar.yq = cursor.getString(1);
                gVar.yr = cursor.getLong(2);
                gVar.ys = cursor.getLong(3);
                gVar.yt = cursor.getLong(4);
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
        contentValues.put("m_key", gVar.yp);
        contentValues.put("m_ns", gVar.yq);
        contentValues.put("m_value", gVar.value);
        contentValues.put("saveTime", Long.valueOf(gVar.yr));
        contentValues.put("lastHitTime", Long.valueOf(gVar.ys));
        contentValues.put("timeToExpire", Long.valueOf(gVar.yt));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.ye + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean ac(String str) {
        try {
            this.yd.eT().delete(this.ye, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.yd.c(th, "clearData");
            return false;
        }
    }
}
