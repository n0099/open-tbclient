package com.baidu.live.adp.lib.cache;

import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes2.dex */
public class BdKVEmptyCacheImpl<T> implements BdKVCache<T> {
    @Override // com.baidu.live.adp.lib.cache.BdKVCache
    public T get(String str) {
        return null;
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache
    public BdKVCache.CacheElement<T> getForDetail(String str) {
        return null;
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache
    public void set(String str, T t, long j) {
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache
    public void setForever(String str, T t) {
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache
    public void remove(String str) {
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache
    public void asyncGet(String str, BdKVCache.BdCacheGetCallback<T> bdCacheGetCallback) {
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache
    public void asyncGetForDetail(String str, BdKVCache.BdCacheGetDetailCallback<T> bdCacheGetDetailCallback) {
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache
    public void asyncSet(String str, T t, long j) {
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache
    public void asyncSetForever(String str, T t) {
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCache
    public void asyncRemove(String str) {
    }

    protected void releaseCacheData() {
    }
}
