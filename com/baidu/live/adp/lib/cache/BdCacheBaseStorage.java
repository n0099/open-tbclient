package com.baidu.live.adp.lib.cache;

import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes10.dex */
public abstract class BdCacheBaseStorage<T> implements BdCacheStorage<T> {
    protected final BdCacheEvictPolicy cachePolicy;
    protected final boolean prefixNameSpaceToKey;

    public abstract BdCacheItem<T> getByUniqueKey(String str);

    public abstract void insertOrUpdate(BdCacheItem<T> bdCacheItem);

    public abstract void removeByUniqueKey(String str);

    protected abstract void removeExpiredItem(String str);

    public BdCacheBaseStorage(BdCacheEvictPolicy bdCacheEvictPolicy, boolean z) {
        this.cachePolicy = bdCacheEvictPolicy;
        this.prefixNameSpaceToKey = z;
    }

    protected String buildUniqueKey(String str, String str2) {
        if (this.prefixNameSpaceToKey) {
            return str + "@" + str2;
        }
        return str2;
    }

    protected BdCacheItem<T> internalGetWithCachePolicy(String str, String str2) {
        String buildUniqueKey = buildUniqueKey(str, str2);
        BdCacheItem<T> byUniqueKey = getByUniqueKey(buildUniqueKey);
        if (byUniqueKey == null) {
            return null;
        }
        if (byUniqueKey.timeToExpire < System.currentTimeMillis()) {
            removeExpiredItem(buildUniqueKey);
            return null;
        }
        if (this.cachePolicy.shouldUpdateLastHitTime()) {
            byUniqueKey.lastHitTime = System.currentTimeMillis();
            insertOrUpdate(byUniqueKey);
        }
        return byUniqueKey;
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheStorage
    public T get(String str, String str2) {
        BdCacheItem<T> internalGetWithCachePolicy = internalGetWithCachePolicy(str, str2);
        if (internalGetWithCachePolicy == null) {
            return null;
        }
        return internalGetWithCachePolicy.value;
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheStorage
    public BdKVCache.CacheElement<T> getForDetail(String str, String str2) {
        BdCacheItem<T> internalGetWithCachePolicy = internalGetWithCachePolicy(str, str2);
        if (internalGetWithCachePolicy == null) {
            return null;
        }
        BdKVCache.CacheElement<T> cacheElement = new BdKVCache.CacheElement<>();
        cacheElement.key = str2;
        cacheElement.value = internalGetWithCachePolicy.value;
        cacheElement.timeToExpire = internalGetWithCachePolicy.timeToExpire;
        cacheElement.lastSaveTime = internalGetWithCachePolicy.saveTime;
        return cacheElement;
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheStorage
    public void set(String str, String str2, T t, long j) {
        BdCacheItem<T> bdCacheItem = new BdCacheItem<>();
        bdCacheItem.uniqueKey = buildUniqueKey(str, str2);
        bdCacheItem.nameSpace = str;
        bdCacheItem.timeToExpire = j;
        bdCacheItem.value = t;
        bdCacheItem.lastHitTime = System.currentTimeMillis();
        bdCacheItem.saveTime = System.currentTimeMillis();
        insertOrUpdate(bdCacheItem);
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheStorage
    public void remove(String str, String str2) {
        removeByUniqueKey(buildUniqueKey(str, str2));
    }

    @Override // com.baidu.live.adp.lib.cache.BdCacheStorage
    public BdCacheEvictPolicy getCachePolicy() {
        return this.cachePolicy;
    }
}
