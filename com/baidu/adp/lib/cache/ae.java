package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class ae extends c<String> {
    private String hj;

    public ae(com.baidu.adp.base.a.c cVar, String str) {
        super(cVar);
        this.hj = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String G(String str) {
        this.hk.t("CREATE TABLE IF NOT EXISTS " + this.hj + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        this.hk.t("CREATE INDEX if not exists idx_mi_ns ON " + this.hj + "(m_ns)");
        return this.hj;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void a(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int cF() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [T, java.lang.String] */
    @Override // com.baidu.adp.lib.cache.c
    protected m<String> c(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        Throwable th;
        m<String> mVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.hl + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    mVar = new m<>();
                    mVar.hw = cursor.getString(0);
                    mVar.hx = cursor.getString(1);
                    mVar.hy = cursor.getLong(2);
                    mVar.hz = cursor.getLong(3);
                    mVar.hA = cursor.getLong(4);
                    mVar.gJ = cursor.getString(5);
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
        contentValues.put("m_key", mVar.hw);
        contentValues.put("m_ns", mVar.hx);
        contentValues.put("m_value", mVar.gJ);
        contentValues.put("saveTime", Long.valueOf(mVar.hy));
        contentValues.put("lastHitTime", Long.valueOf(mVar.hz));
        contentValues.put("timeToExpire", Long.valueOf(mVar.hA));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.hl + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean I(String str) {
        try {
            this.hk.ak().delete(this.hl, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.hk.a(th, "clearData");
            return false;
        }
    }
}
