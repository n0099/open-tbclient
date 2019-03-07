package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class a extends c<byte[]> {
    private String At;

    public a(com.baidu.adp.base.a.b bVar, String str) {
        super(bVar);
        this.At = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String as(String str) {
        this.Au.af("CREATE TABLE IF NOT EXISTS " + this.At + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
        this.Au.af("CREATE INDEX if not exists idx_mi_ns ON " + this.At + "(m_ns)");
        return this.At;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void b(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int il() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [T, byte[]] */
    @Override // com.baidu.adp.lib.cache.c
    protected g<byte[]> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor;
        Throwable th;
        g<byte[]> gVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.Av + " where m_key = ?", new String[]{str});
        } catch (Throwable th2) {
            cursor = null;
            th = th2;
        }
        try {
            if (cursor.moveToNext()) {
                gVar = new g<>();
                gVar.AG = cursor.getString(0);
                gVar.AH = cursor.getString(1);
                gVar.AI = cursor.getLong(2);
                gVar.AJ = cursor.getLong(3);
                gVar.AK = cursor.getLong(4);
                gVar.value = cursor.getBlob(5);
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
    protected ContentValues a(g<byte[]> gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", gVar.AG);
        contentValues.put("m_ns", gVar.AH);
        contentValues.put("m_value", gVar.value);
        contentValues.put("saveTime", Long.valueOf(gVar.AI));
        contentValues.put("lastHitTime", Long.valueOf(gVar.AJ));
        contentValues.put("timeToExpire", Long.valueOf(gVar.AK));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.Av + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean at(String str) {
        try {
            this.Au.ga().delete(this.Av, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.Au.c(th, "failed to clear from " + str);
            return false;
        }
    }
}
