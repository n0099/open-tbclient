package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class b extends c<byte[]> {
    public b(com.baidu.adp.base.a.c cVar) {
        super(cVar);
    }

    @Override // com.baidu.adp.lib.cache.c
    public String r(String str) {
        String str2 = "cache_kv_b" + Math.abs(str.hashCode());
        this.fi.g("CREATE TABLE IF NOT EXISTS " + str2 + "(m_key VARCHAR(64) PRIMARY KEY, saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
        return str2;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void a(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int ce() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v15, types: [T, byte[]] */
    @Override // com.baidu.adp.lib.cache.c
    protected m<byte[]> b(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        Throwable th;
        m<byte[]> mVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.fj + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    mVar = new m<>();
                    mVar.fu = cursor.getString(0);
                    mVar.fw = cursor.getLong(1);
                    mVar.fx = cursor.getLong(2);
                    mVar.fy = cursor.getLong(3);
                    mVar.value = cursor.getBlob(4);
                    com.baidu.adp.lib.g.a.a(cursor);
                } else {
                    com.baidu.adp.lib.g.a.a(cursor);
                }
                return mVar;
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
    protected ContentValues a(m<byte[]> mVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", mVar.fu);
        contentValues.put("m_value", mVar.value);
        contentValues.put("saveTime", Long.valueOf(mVar.fw));
        contentValues.put("lastHitTime", Long.valueOf(mVar.fx));
        contentValues.put("timeToExpire", Long.valueOf(mVar.fy));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor c(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.fj, new String[0]);
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean s(String str) {
        this.fi.g("DROP TABLE IF EXISTS " + this.fj);
        return true;
    }
}
