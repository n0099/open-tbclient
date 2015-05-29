package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class ae extends c<String> {
    private String sR;

    public ae(com.baidu.adp.base.a.c cVar, String str) {
        super(cVar);
        this.sR = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String Q(String str) {
        this.sS.E("CREATE TABLE IF NOT EXISTS " + this.sR + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        this.sS.E("CREATE INDEX if not exists idx_mi_ns ON " + this.sR + "(m_ns)");
        return this.sR;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void a(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int gg() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [T, java.lang.String] */
    @Override // com.baidu.adp.lib.cache.c
    protected m<String> c(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        Throwable th;
        m<String> mVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.sT + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    mVar = new m<>();
                    mVar.tf = cursor.getString(0);
                    mVar.tg = cursor.getString(1);
                    mVar.th = cursor.getLong(2);
                    mVar.ti = cursor.getLong(3);
                    mVar.tj = cursor.getLong(4);
                    mVar.ss = cursor.getString(5);
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
        contentValues.put("m_key", mVar.tf);
        contentValues.put("m_ns", mVar.tg);
        contentValues.put("m_value", mVar.ss);
        contentValues.put("saveTime", Long.valueOf(mVar.th));
        contentValues.put("lastHitTime", Long.valueOf(mVar.ti));
        contentValues.put("timeToExpire", Long.valueOf(mVar.tj));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.sT + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean R(String str) {
        try {
            this.sS.dK().delete(this.sT, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.sS.a(th, "clearData");
            return false;
        }
    }
}
