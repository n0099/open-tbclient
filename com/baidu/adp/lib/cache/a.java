package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class a extends c<byte[]> {
    private String lK;

    public a(com.baidu.adp.base.a.b bVar, String str) {
        super(bVar);
        this.lK = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String G(String str) {
        this.lL.x("CREATE TABLE IF NOT EXISTS " + this.lK + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
        this.lL.x("CREATE INDEX if not exists idx_mi_ns ON " + this.lK + "(m_ns)");
        return this.lK;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void b(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int dn() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [T, byte[]] */
    @Override // com.baidu.adp.lib.cache.c
    protected h<byte[]> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor;
        Throwable th;
        h<byte[]> hVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.lM + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    hVar = new h<>();
                    hVar.lX = cursor.getString(0);
                    hVar.lY = cursor.getString(1);
                    hVar.lZ = cursor.getLong(2);
                    hVar.ma = cursor.getLong(3);
                    hVar.mb = cursor.getLong(4);
                    hVar.lj = cursor.getBlob(5);
                    com.baidu.adp.lib.g.a.a(cursor);
                } else {
                    com.baidu.adp.lib.g.a.a(cursor);
                }
                return hVar;
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
    protected ContentValues a(h<byte[]> hVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", hVar.lX);
        contentValues.put("m_ns", hVar.lY);
        contentValues.put("m_value", hVar.lj);
        contentValues.put("saveTime", Long.valueOf(hVar.lZ));
        contentValues.put("lastHitTime", Long.valueOf(hVar.ma));
        contentValues.put("timeToExpire", Long.valueOf(hVar.mb));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.lM + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean H(String str) {
        try {
            this.lL.aZ().delete(this.lM, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.lL.a(th, "failed to clear from " + str);
            return false;
        }
    }
}
