package com.baidu.live.adp.lib.cache;

import com.baidu.live.adp.lib.cache.BdCacheEvictPolicy;
import com.baidu.live.adp.lib.safe.ThreadService;
/* loaded from: classes11.dex */
public class BdCacheSQLiteStorage<T> extends BdCacheBaseStorage<T> {
    protected final BdCacheBaseDBManager<T> dbManager;

    public BdCacheSQLiteStorage(BdCacheBaseDBManager<T> bdCacheBaseDBManager, BdCacheEvictPolicy bdCacheEvictPolicy, boolean z) {
        super(bdCacheEvictPolicy, z);
        this.dbManager = bdCacheBaseDBManager;
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheBaseStorage
    public BdCacheItem<T> getByUniqueKey(String str) {
        return this.dbManager.get(str);
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheBaseStorage
    public void insertOrUpdate(BdCacheItem<T> bdCacheItem) {
        this.dbManager.addOrUpdateTextCacheItem(bdCacheItem);
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheBaseStorage
    public void removeByUniqueKey(String str) {
        this.dbManager.deleteCacheItem(str);
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheBaseStorage
    protected void removeExpiredItem(String str) {
        this.dbManager.addItemIdToDeleteList(str, true);
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheStorage
    public void clearAndClose(String str) {
        this.dbManager.clearAllForNameSpace(str);
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheStorage
    public void flushAndClose(String str) {
        this.dbManager.performCleanup();
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheStorage
    public void startup(final String str) {
        if (this.cachePolicy instanceof BdCacheEvictPolicy.EvictOnInsertSupport) {
            ThreadService.sharedInstance().submitTask(new Runnable() { // from class: com.baidu.live.adp.lib.cache.BdCacheSQLiteStorage.1
                @Override // java.lang.Runnable
                public void run() {
                    BdCacheSQLiteStorage.this.dbManager.performPump(str);
                }
            });
        }
        if (this.cachePolicy instanceof BdCacheEvictPolicy.EvictOnCountSupport) {
            ThreadService.sharedInstance().submitTask(new Runnable() { // from class: com.baidu.live.adp.lib.cache.BdCacheSQLiteStorage.2
                @Override // java.lang.Runnable
                public void run() {
                    BdCacheSQLiteStorage.this.dbManager.performEvict(str);
                }
            });
        }
    }

    public BdCacheBaseDBManager<T> getDbManager() {
        return this.dbManager;
    }
}
