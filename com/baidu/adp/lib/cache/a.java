package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class a extends c<byte[]> {
    private String uN;

    public a(com.baidu.adp.base.a.b bVar, String str) {
        super(bVar);
        this.uN = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String P(String str) {
        this.uO.E("CREATE TABLE IF NOT EXISTS " + this.uN + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
        this.uO.E("CREATE INDEX if not exists idx_mi_ns ON " + this.uN + "(m_ns)");
        return this.uN;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void b(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int eE() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [T, byte[]] */
    @Override // com.baidu.adp.lib.cache.c
    protected g<byte[]> c(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor;
        Throwable th;
        g<byte[]> gVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.uP + " where m_key = ?", new String[]{str});
        } catch (Throwable th2) {
            cursor = null;
            th = th2;
        }
        try {
            if (cursor.moveToNext()) {
                gVar = new g<>();
                gVar.va = cursor.getString(0);
                gVar.vb = cursor.getString(1);
                gVar.vc = cursor.getLong(2);
                gVar.vd = cursor.getLong(3);
                gVar.ve = cursor.getLong(4);
                gVar.um = cursor.getBlob(5);
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
        contentValues.put("m_key", gVar.va);
        contentValues.put("m_ns", gVar.vb);
        contentValues.put("m_value", gVar.um);
        contentValues.put("saveTime", Long.valueOf(gVar.vc));
        contentValues.put("lastHitTime", Long.valueOf(gVar.vd));
        contentValues.put("timeToExpire", Long.valueOf(gVar.ve));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor d(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.uP + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean Q(String str) {
        try {
            this.uO.cs().delete(this.uP, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.uO.a(th, "failed to clear from " + str);
            return false;
        }
    }
}
