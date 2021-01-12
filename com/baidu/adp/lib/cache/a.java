package com.baidu.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class a extends c<byte[]> {
    private String sharedTableName;

    public a(com.baidu.adp.base.a.b bVar, String str) {
        super(bVar);
        this.sharedTableName = str;
    }

    @Override // com.baidu.adp.lib.cache.c
    public String onNewNameSpaceCreated(String str) {
        this.KV.execSQLNoException("CREATE TABLE IF NOT EXISTS " + this.sharedTableName + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
        this.KV.execSQLNoException("CREATE INDEX if not exists idx_mi_ns ON " + this.sharedTableName + "(m_ns)");
        return this.sharedTableName;
    }

    @Override // com.baidu.adp.lib.cache.c
    public void onNameSpaceUpgraded(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.adp.lib.cache.c
    public int getCacheVersion() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r1v17, types: [byte[], T] */
    @Override // com.baidu.adp.lib.cache.c
    protected g<byte[]> a(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor;
        g<byte[]> gVar = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.tableName + " where m_key = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
            if (cursor.moveToNext()) {
                gVar = new g<>();
                gVar.uniqueKey = cursor.getString(0);
                gVar.nameSpace = cursor.getString(1);
                gVar.saveTime = cursor.getLong(2);
                gVar.lastHitTime = cursor.getLong(3);
                gVar.timeToExpire = cursor.getLong(4);
                gVar.value = cursor.getBlob(5);
                com.baidu.adp.lib.f.a.close(cursor);
            } else {
                com.baidu.adp.lib.f.a.close(cursor);
            }
            return gVar;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.adp.lib.f.a.close(cursor);
            throw th;
        }
    }

    @Override // com.baidu.adp.lib.cache.c
    protected ContentValues a(g<byte[]> gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", gVar.uniqueKey);
        contentValues.put("m_ns", gVar.nameSpace);
        contentValues.put("m_value", gVar.value);
        contentValues.put("saveTime", Long.valueOf(gVar.saveTime));
        contentValues.put("lastHitTime", Long.valueOf(gVar.lastHitTime));
        contentValues.put("timeToExpire", Long.valueOf(gVar.timeToExpire));
        return contentValues;
    }

    @Override // com.baidu.adp.lib.cache.c
    public Cursor queryAllForNameSpace(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.tableName + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.adp.lib.cache.c
    protected boolean clearData(String str) {
        try {
            this.KV.getOpenedDatabase().delete(this.tableName, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.KV.notifySQLException(th, "failed to clear from " + str);
            return false;
        }
    }
}
