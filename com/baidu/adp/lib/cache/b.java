package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public final class b extends c<byte[]> {
    public b(com.baidu.adp.a.h hVar) {
        super(hVar);
    }

    @Override // com.baidu.adp.lib.cache.c
    public final String a(String str) {
        String str2 = "cache_kv_b" + Math.abs(str.hashCode());
        this.a.a(this.a.a(), "CREATE TABLE IF NOT EXISTS " + str2 + "(m_key VARCHAR(64) PRIMARY KEY, saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
        return str2;
    }

    /* JADX WARN: Type inference failed for: r2v15, types: [T, byte[]] */
    @Override // com.baidu.adp.lib.cache.c
    protected final m<byte[]> a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        Throwable th;
        m<byte[]> mVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.b + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    mVar = new m<>();
                    mVar.a = cursor.getString(0);
                    mVar.d = cursor.getLong(1);
                    mVar.e = cursor.getLong(2);
                    mVar.f = cursor.getLong(3);
                    mVar.b = cursor.getBlob(4);
                    com.baidu.adp.lib.f.a.a(cursor);
                } else {
                    com.baidu.adp.lib.f.a.a(cursor);
                }
                return mVar;
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.f.a.a(cursor);
                throw th;
            }
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
        }
    }

    @Override // com.baidu.adp.lib.cache.c
    protected final ContentValues a(m<byte[]> mVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", mVar.a);
        contentValues.put("m_value", mVar.b);
        contentValues.put("saveTime", Long.valueOf(mVar.d));
        contentValues.put("lastHitTime", Long.valueOf(mVar.e));
        contentValues.put("timeToExpire", Long.valueOf(mVar.f));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public final Cursor b(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.b, new String[0]);
    }

    @Override // com.baidu.adp.lib.cache.c
    protected final boolean b(String str) {
        this.a.a(this.a.a(), "DROP TABLE IF EXISTS " + this.b);
        return true;
    }
}
