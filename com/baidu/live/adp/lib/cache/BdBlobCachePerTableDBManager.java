package com.baidu.live.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.live.adp.base.db.DatabaseManager;
import com.baidu.live.adp.lib.safe.BdCloseHelper;
/* loaded from: classes3.dex */
public class BdBlobCachePerTableDBManager extends BdCacheBaseDBManager<byte[]> {
    public BdBlobCachePerTableDBManager(DatabaseManager databaseManager) {
        super(databaseManager);
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheBaseDBManager
    public String onNewNameSpaceCreated(String str) {
        int hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        String str2 = "cache_kv_b" + hashCode;
        this.dbService.execSQLNoException("CREATE TABLE IF NOT EXISTS " + str2 + "(m_key VARCHAR(64) PRIMARY KEY, saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
        return str2;
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheBaseDBManager
    public void onNameSpaceUpgraded(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheBaseDBManager
    public int getCacheVersion() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v15, types: [byte[], T] */
    @Override // com.baidu.live.adp.lib.cache.BdCacheBaseDBManager
    protected BdCacheItem<byte[]> getFromDB(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor;
        Throwable th;
        BdCacheItem<byte[]> bdCacheItem = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.tableName + " where m_key = ?", new String[]{str});
            try {
                if (cursor.moveToNext()) {
                    bdCacheItem = new BdCacheItem<>();
                    bdCacheItem.uniqueKey = cursor.getString(0);
                    bdCacheItem.saveTime = cursor.getLong(1);
                    bdCacheItem.lastHitTime = cursor.getLong(2);
                    bdCacheItem.timeToExpire = cursor.getLong(3);
                    bdCacheItem.value = cursor.getBlob(4);
                    BdCloseHelper.close(cursor);
                } else {
                    BdCloseHelper.close(cursor);
                }
                return bdCacheItem;
            } catch (Throwable th2) {
                th = th2;
                BdCloseHelper.close(cursor);
                throw th;
            }
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
        }
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheBaseDBManager
    protected ContentValues prepareForAddOrUpdate(BdCacheItem<byte[]> bdCacheItem) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", bdCacheItem.uniqueKey);
        contentValues.put("m_value", bdCacheItem.value);
        contentValues.put("saveTime", Long.valueOf(bdCacheItem.saveTime));
        contentValues.put("lastHitTime", Long.valueOf(bdCacheItem.lastHitTime));
        contentValues.put("timeToExpire", Long.valueOf(bdCacheItem.timeToExpire));
        return contentValues;
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheBaseDBManager
    public Cursor queryAllForNameSpace(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.tableName, new String[0]);
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheBaseDBManager
    protected Cursor countForNameSpace(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select count(*) from " + this.tableName, new String[0]);
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheBaseDBManager
    protected boolean clearData(String str) {
        this.dbService.execSQLNoException("DROP TABLE IF EXISTS " + this.tableName);
        return true;
    }
}
