package com.baidu.live.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.live.adp.base.db.DatabaseManager;
import com.baidu.live.adp.lib.safe.BdCloseHelper;
/* loaded from: classes2.dex */
public class BdTextCacheAllInOneTableDBManager extends BdCacheBaseDBManager<String> {
    private String sharedTableName;

    public BdTextCacheAllInOneTableDBManager(DatabaseManager databaseManager, String str) {
        super(databaseManager);
        this.sharedTableName = str;
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheBaseDBManager
    public String onNewNameSpaceCreated(String str) {
        this.dbService.execSQLNoException("CREATE TABLE IF NOT EXISTS " + this.sharedTableName + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
        this.dbService.execSQLNoException("CREATE INDEX if not exists idx_mi_ns ON " + this.sharedTableName + "(m_ns)");
        return this.sharedTableName;
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheBaseDBManager
    public void onNameSpaceUpgraded(String str, String str2, int i, int i2) {
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheBaseDBManager
    public int getCacheVersion() {
        return 1;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [T, java.lang.String] */
    @Override // com.baidu.live.adp.lib.cache.BdCacheBaseDBManager
    protected BdCacheItem<String> getFromDB(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        Cursor cursor;
        Throwable th;
        BdCacheItem<String> bdCacheItem = null;
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.tableName + " where m_key = ?", new String[]{str});
        } catch (Throwable th2) {
            cursor = null;
            th = th2;
        }
        try {
            if (cursor.moveToNext()) {
                bdCacheItem = new BdCacheItem<>();
                bdCacheItem.uniqueKey = cursor.getString(0);
                bdCacheItem.nameSpace = cursor.getString(1);
                bdCacheItem.saveTime = cursor.getLong(2);
                bdCacheItem.lastHitTime = cursor.getLong(3);
                bdCacheItem.timeToExpire = cursor.getLong(4);
                bdCacheItem.value = cursor.getString(5);
                BdCloseHelper.close(cursor);
            } else {
                BdCloseHelper.close(cursor);
            }
            return bdCacheItem;
        } catch (Throwable th3) {
            th = th3;
            BdCloseHelper.close(cursor);
            throw th;
        }
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheBaseDBManager
    protected ContentValues prepareForAddOrUpdate(BdCacheItem<String> bdCacheItem) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("m_key", bdCacheItem.uniqueKey);
        contentValues.put("m_ns", bdCacheItem.nameSpace);
        contentValues.put("m_value", bdCacheItem.value);
        contentValues.put("saveTime", Long.valueOf(bdCacheItem.saveTime));
        contentValues.put("lastHitTime", Long.valueOf(bdCacheItem.lastHitTime));
        contentValues.put("timeToExpire", Long.valueOf(bdCacheItem.timeToExpire));
        return contentValues;
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheBaseDBManager
    public Cursor queryAllForNameSpace(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select * from " + this.tableName + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheBaseDBManager
    protected Cursor countForNameSpace(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.rawQuery("select count(*) from " + this.tableName + " where m_ns = ?", new String[]{str});
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheBaseDBManager
    protected boolean clearData(String str) {
        try {
            this.dbService.getOpenedDatabase().delete(this.tableName, "m_ns = ?", new String[]{str});
            return true;
        } catch (Throwable th) {
            this.dbService.notifySQLException(th, "clearData");
            return false;
        }
    }
}
