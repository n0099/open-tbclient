package com.baidu.live.adp.lib.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.live.adp.base.db.DatabaseManager;
import com.baidu.live.adp.lib.cache.BdCacheEvictPolicy;
import com.baidu.live.adp.lib.safe.BdCloseHelper;
import com.baidu.live.adp.lib.safe.ThreadService;
import java.util.LinkedList;
/* loaded from: classes11.dex */
public abstract class BdCacheBaseDBManager<T> {
    protected BdCacheEvictPolicy.EvictOnCountSupport countCachePolicy;
    protected final DatabaseManager dbService;
    protected int dirtyCount;
    protected BdCacheEvictPolicy.EvictOnInsertSupport insertCachePolicy;
    protected String tableName;
    protected LinkedList<String> idsToDelete = new LinkedList<>();
    private Object lockForIdsToDelete = new Object();

    protected abstract boolean clearData(String str);

    protected abstract Cursor countForNameSpace(SQLiteDatabase sQLiteDatabase, String str);

    public abstract int getCacheVersion();

    protected abstract BdCacheItem<T> getFromDB(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract void onNameSpaceUpgraded(String str, String str2, int i, int i2);

    public abstract String onNewNameSpaceCreated(String str);

    protected abstract ContentValues prepareForAddOrUpdate(BdCacheItem<T> bdCacheItem);

    public abstract Cursor queryAllForNameSpace(SQLiteDatabase sQLiteDatabase, String str);

    public BdCacheBaseDBManager(DatabaseManager databaseManager) {
        this.dbService = databaseManager;
    }

    public void startup(BdCacheEvictPolicy bdCacheEvictPolicy, String str) {
        this.tableName = str;
        if (bdCacheEvictPolicy instanceof BdCacheEvictPolicy.EvictOnInsertSupport) {
            this.insertCachePolicy = (BdCacheEvictPolicy.EvictOnInsertSupport) bdCacheEvictPolicy;
        }
        if (bdCacheEvictPolicy instanceof BdCacheEvictPolicy.EvictOnCountSupport) {
            this.countCachePolicy = (BdCacheEvictPolicy.EvictOnCountSupport) bdCacheEvictPolicy;
        }
    }

    public BdCacheItem<T> get(String str) {
        try {
            return getFromDB(this.dbService.getOpenedDatabase(), str);
        } catch (Throwable th) {
            this.dbService.notifySQLException(th, "get");
            return null;
        }
    }

    public void addOrUpdateTextCacheItem(BdCacheItem<T> bdCacheItem) {
        String onItemJoined;
        try {
            synchronized (this.lockForIdsToDelete) {
                this.idsToDelete.remove(bdCacheItem.uniqueKey);
            }
            ContentValues prepareForAddOrUpdate = prepareForAddOrUpdate(bdCacheItem);
            SQLiteDatabase openedDatabase = this.dbService.getOpenedDatabase();
            if (openedDatabase.update(this.tableName, prepareForAddOrUpdate, "m_key = ?", new String[]{bdCacheItem.uniqueKey}) == 0) {
                openedDatabase.insert(this.tableName, null, prepareForAddOrUpdate);
                if (this.countCachePolicy != null) {
                    notifyDirtyCountAdded();
                }
            }
            if (this.insertCachePolicy != null && (onItemJoined = this.insertCachePolicy.onItemJoined(bdCacheItem)) != null) {
                deleteCacheItem(onItemJoined);
            }
        } catch (Throwable th) {
            this.dbService.notifySQLException(th, "addOrUpdateTextCacheItem");
        }
    }

    protected void notifyDirtyCountAdded() {
        if (this.countCachePolicy != null) {
            this.dirtyCount++;
            if (this.dirtyCount >= ((int) Math.min(this.countCachePolicy.getMaxSize() * 0.2d, 5.0d))) {
                this.dirtyCount = 0;
                ThreadService.sharedInstance().submitTask(new Runnable() { // from class: com.baidu.live.adp.lib.cache.BdCacheBaseDBManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BdCacheBaseDBManager.this.performCleanup();
                    }
                });
            }
        }
    }

    public int deleteCacheItem(String str) {
        try {
            return this.dbService.getOpenedDatabase().delete(this.tableName, "m_key = ?", new String[]{str});
        } catch (Throwable th) {
            this.dbService.notifySQLException(th, "deleteCacheItem");
            return 0;
        }
    }

    public void clearAllForNameSpace(String str) {
        this.dirtyCount = 0;
        synchronized (this.lockForIdsToDelete) {
            this.idsToDelete.clear();
        }
        if (clearData(str)) {
            BdCacheService.sharedInstance().getNameSpaceManager().delete(str);
        }
    }

    public int count(String str) {
        int i = 0;
        Cursor cursor = null;
        try {
            cursor = countForNameSpace(this.dbService.getOpenedDatabase(), str);
            if (cursor.moveToNext()) {
                i = cursor.getInt(0);
            }
        } catch (Throwable th) {
            try {
                this.dbService.notifySQLException(th, "count");
            } finally {
                BdCloseHelper.close(cursor);
            }
        }
        return i;
    }

    public synchronized void addItemIdToDeleteList(String str, boolean z) {
        synchronized (this.lockForIdsToDelete) {
            if (!this.idsToDelete.contains(str)) {
                this.idsToDelete.addLast(str);
                if (z) {
                    notifyDirtyCountAdded();
                }
            }
        }
    }

    public void performEvict(String str) {
        if (this.countCachePolicy != null) {
            Cursor cursor = null;
            try {
                this.countCachePolicy.startEvict();
                cursor = queryAllForNameSpace(this.dbService.getOpenedDatabase(), str);
                while (cursor.moveToNext()) {
                    BdCacheItem<?> bdCacheItem = new BdCacheItem<>();
                    bdCacheItem.uniqueKey = cursor.getString(cursor.getColumnIndex("m_key"));
                    bdCacheItem.saveTime = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    bdCacheItem.lastHitTime = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    bdCacheItem.timeToExpire = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String evictedKey = this.countCachePolicy.getEvictedKey(bdCacheItem);
                    if (evictedKey != null) {
                        addItemIdToDeleteList(evictedKey, false);
                    }
                }
                performCleanup();
            } catch (Throwable th) {
                try {
                    this.dbService.notifySQLException(th, "performEvict");
                } finally {
                    BdCloseHelper.close(cursor);
                    this.countCachePolicy.finishEvict();
                }
            }
        }
    }

    public void performPump(String str) {
        if (this.insertCachePolicy != null) {
            Cursor cursor = null;
            try {
                this.insertCachePolicy.startInit();
                cursor = queryAllForNameSpace(this.dbService.getOpenedDatabase(), str);
                while (cursor.moveToNext()) {
                    BdCacheItem<?> bdCacheItem = new BdCacheItem<>();
                    bdCacheItem.uniqueKey = cursor.getString(cursor.getColumnIndex("m_key"));
                    bdCacheItem.saveTime = cursor.getLong(cursor.getColumnIndex("saveTime"));
                    bdCacheItem.lastHitTime = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                    bdCacheItem.timeToExpire = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                    String prepareForOldData = this.insertCachePolicy.prepareForOldData(bdCacheItem);
                    if (prepareForOldData != null) {
                        addItemIdToDeleteList(prepareForOldData, false);
                    }
                }
                performCleanup();
            } catch (Throwable th) {
                try {
                    this.dbService.notifySQLException(th, "performPump");
                } finally {
                    BdCloseHelper.close(cursor);
                    this.insertCachePolicy.finishInit();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void performCleanup() {
        String removeFirst;
        if (!this.idsToDelete.isEmpty()) {
            SQLiteDatabase openedDatabase = this.dbService.getOpenedDatabase();
            openedDatabase.beginTransaction();
            while (true) {
                try {
                    synchronized (this.lockForIdsToDelete) {
                        if (!this.idsToDelete.isEmpty()) {
                            removeFirst = this.idsToDelete.removeFirst();
                        } else {
                            openedDatabase.setTransactionSuccessful();
                            this.dirtyCount = 0;
                            return;
                        }
                    }
                    openedDatabase.delete(this.tableName, "m_key = ?", new String[]{String.valueOf(removeFirst)});
                } catch (Throwable th) {
                    try {
                        this.dbService.notifySQLException(th, "performCleanup");
                        return;
                    } finally {
                        openedDatabase.endTransaction();
                    }
                }
            }
        }
    }

    public DatabaseManager getDatabaseManager() {
        return this.dbService;
    }
}
