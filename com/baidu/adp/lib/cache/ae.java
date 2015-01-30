package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class ae extends c<String> {
    private String hl;

    public ae(com.baidu.adp.base.a.c cVar, String str) {
        super(cVar);
        this.hl = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String G(String str) {
        this.hm.t("CREATE TABLE IF NOT EXISTS " + this.hl + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        this.hm.t("CREATE INDEX if not exists idx_mi_ns ON " + this.hl + "(m_ns)");
        return this.hl;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void a(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int cD() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [T, java.lang.String] */
    @Override // com.baidu.adp.lib.cache.c
    protected m<String> c(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        Throwable th;
        m<String> mVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.hn + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    mVar = new m<>();
                    mVar.hy = cursor.getString(0);
                    mVar.hz = cursor.getString(1);
                    mVar.hA = cursor.getLong(2);
                    mVar.hB = cursor.getLong(3);
                    mVar.hC = cursor.getLong(4);
                    mVar.gL = cursor.getString(5);
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
        contentValues.put("m_key", mVar.hy);
        contentValues.put("m_ns", mVar.hz);
        contentValues.put("m_value", mVar.gL);
        contentValues.put("saveTime", Long.valueOf(mVar.hA));
        contentValues.put("lastHitTime", Long.valueOf(mVar.hB));
        contentValues.put("timeToExpire", Long.valueOf(mVar.hC));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.hn + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean I(String str) {
        try {
            this.hm.ak().delete(this.hn, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.hm.a(th, "clearData");
            return false;
        }
    }
}
