package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class a extends c<byte[]> {
    private String uP;

    public a(com.baidu.adp.base.a.b bVar, String str) {
        super(bVar);
        this.uP = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String Q(String str) {
        this.uQ.F("CREATE TABLE IF NOT EXISTS " + this.uP + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
        this.uQ.F("CREATE INDEX if not exists idx_mi_ns ON " + this.uP + "(m_ns)");
        return this.uP;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void b(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int eE() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [byte[], T] */
    @Override // com.baidu.adp.lib.cache.c
    protected g<byte[]> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor;
        Throwable th;
        g<byte[]> gVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.uR + " where m_key = ?", new String[]{str});
        } catch (Throwable th2) {
            cursor = null;
            th = th2;
        }
        try {
            if (cursor.moveToNext()) {
                gVar = new g<>();
                gVar.vc = cursor.getString(0);
                gVar.vd = cursor.getString(1);
                gVar.ve = cursor.getLong(2);
                gVar.vf = cursor.getLong(3);
                gVar.vg = cursor.getLong(4);
                gVar.up = cursor.getBlob(5);
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
        contentValues.put("m_key", gVar.vc);
        contentValues.put("m_ns", gVar.vd);
        contentValues.put("m_value", gVar.up);
        contentValues.put("saveTime", Long.valueOf(gVar.ve));
        contentValues.put("lastHitTime", Long.valueOf(gVar.vf));
        contentValues.put("timeToExpire", Long.valueOf(gVar.vg));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.uR + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean R(String str) {
        try {
            this.uQ.cs().delete(this.uR, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.uQ.a(th, "failed to clear from " + str);
            return false;
        }
    }
}
