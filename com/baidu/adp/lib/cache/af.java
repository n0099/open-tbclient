package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class af extends c<String> {
    public af(com.baidu.adp.base.a.c cVar) {
        super(cVar);
    }

    @Override // com.baidu.adp.lib.cache.c
    public String O(String str) {
        String str2 = "cache_kv_t" + Math.abs(str.hashCode());
        this.sH.D("CREATE TABLE IF NOT EXISTS " + str2 + "(m_key VARCHAR(64) PRIMARY KEY, saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        return str2;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void a(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int gb() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v15, types: [T, java.lang.String] */
    @Override // com.baidu.adp.lib.cache.c
    protected m<String> c(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        Throwable th;
        m<String> mVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.sI + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    mVar = new m<>();
                    mVar.sT = cursor.getString(0);
                    mVar.sV = cursor.getLong(1);
                    mVar.sW = cursor.getLong(2);
                    mVar.sX = cursor.getLong(3);
                    mVar.sf = cursor.getString(4);
                    com.baidu.adp.lib.g.a.b(cursor);
                } else {
                    com.baidu.adp.lib.g.a.b(cursor);
                }
                return mVar;
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
    protected ContentValues a(m<String> mVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", mVar.sT);
        contentValues.put("m_value", mVar.sf);
        contentValues.put("saveTime", Long.valueOf(mVar.sV));
        contentValues.put("lastHitTime", Long.valueOf(mVar.sW));
        contentValues.put("timeToExpire", Long.valueOf(mVar.sX));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.sI, new String[0]);
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean P(String str) {
        this.sH.D("DROP TABLE IF EXISTS " + this.sI);
        return true;
    }
}
