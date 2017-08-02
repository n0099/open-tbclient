package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class r extends c<String> {
    public r(com.baidu.adp.base.a.b bVar) {
        super(bVar);
    }

    @Override // com.baidu.adp.lib.cache.c
    public String J(String str) {
        int hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        String str2 = "cache_kv_t" + hashCode;
        this.ti.y("CREATE TABLE IF NOT EXISTS " + str2 + "(m_key VARCHAR(64) PRIMARY KEY, saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        return str2;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void b(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int et() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v15, types: [T, java.lang.String] */
    @Override // com.baidu.adp.lib.cache.c
    protected g<String> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor;
        Throwable th;
        g<String> gVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.tj + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    gVar = new g<>();
                    gVar.tw = cursor.getString(0);
                    gVar.ty = cursor.getLong(1);
                    gVar.tz = cursor.getLong(2);
                    gVar.tA = cursor.getLong(3);
                    gVar.sG = cursor.getString(4);
                    com.baidu.adp.lib.g.a.e(cursor);
                } else {
                    com.baidu.adp.lib.g.a.e(cursor);
                }
                return gVar;
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
    protected ContentValues a(g<String> gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", gVar.tw);
        contentValues.put("m_value", gVar.sG);
        contentValues.put("saveTime", Long.valueOf(gVar.ty));
        contentValues.put("lastHitTime", Long.valueOf(gVar.tz));
        contentValues.put("timeToExpire", Long.valueOf(gVar.tA));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.tj, new String[0]);
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean K(String str) {
        this.ti.y("DROP TABLE IF EXISTS " + this.tj);
        return true;
    }
}
