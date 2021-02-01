package com.baidu.live.adp.lib.cache;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.live.adp.base.db.DatabaseManager;
import com.baidu.live.adp.lib.safe.BdCloseHelper;
/* loaded from: classes11.dex */
public class BdNameSpaceDBManager {
    private final DatabaseManager dbService;

    public BdNameSpaceDBManager(Context context, DatabaseManager databaseManager) {
        this.dbService = databaseManager;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    public BdCacheNSItem get(String str) {
        Cursor cursor;
        try {
            cursor = this.dbService.getOpenedDatabase().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                this.dbService.notifySQLException(th, "get");
                BdCloseHelper.close(cursor);
                return null;
            } finally {
                BdCloseHelper.close(cursor);
            }
        }
        if (cursor.moveToNext()) {
            BdCacheNSItem bdCacheNSItem = new BdCacheNSItem();
            bdCacheNSItem.nameSpace = cursor.getString(0);
            bdCacheNSItem.tableName = cursor.getString(1);
            bdCacheNSItem.maxSize = cursor.getInt(2);
            bdCacheNSItem.cacheType = cursor.getString(3);
            bdCacheNSItem.cacheVersion = cursor.getInt(4);
            bdCacheNSItem.lastActiveTime = cursor.getLong(5);
            return bdCacheNSItem;
        }
        return null;
    }

    public void addOrUpdate(BdCacheNSItem bdCacheNSItem) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("nameSpace", bdCacheNSItem.nameSpace);
            contentValues.put("tableName", bdCacheNSItem.tableName);
            contentValues.put("maxSize", Integer.valueOf(bdCacheNSItem.maxSize));
            contentValues.put("cacheVersion", Integer.valueOf(bdCacheNSItem.cacheVersion));
            contentValues.put("cacheType", bdCacheNSItem.cacheType);
            contentValues.put("lastActiveTime", Long.valueOf(bdCacheNSItem.lastActiveTime));
            SQLiteDatabase openedDatabase = this.dbService.getOpenedDatabase();
            if (openedDatabase != null && openedDatabase.update(BdCacheSQLiteHelper.TABLE_CACHE_META_INFO, contentValues, "nameSpace = ?", new String[]{bdCacheNSItem.nameSpace}) == 0) {
                openedDatabase.insert(BdCacheSQLiteHelper.TABLE_CACHE_META_INFO, null, contentValues);
            }
        } catch (Throwable th) {
            this.dbService.notifySQLException(th, "addOrUpdate");
        }
    }

    public int delete(String str) {
        try {
            if (get(str) == null) {
                return 0;
            }
            return this.dbService.getOpenedDatabase().delete(BdCacheSQLiteHelper.TABLE_CACHE_META_INFO, "nameSpace = ?", new String[]{str});
        } catch (Throwable th) {
            this.dbService.notifySQLException(th, "delete");
            return 0;
        }
    }
}
