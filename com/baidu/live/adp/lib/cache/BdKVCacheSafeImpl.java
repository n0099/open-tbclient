package com.baidu.live.adp.lib.cache;

import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes7.dex */
public class BdKVCacheSafeImpl<T> extends BdKVCacheImpl<T> {
    public BdKVCacheSafeImpl(String str, BdCacheStorage<T> bdCacheStorage) {
        super(str, bdCacheStorage);
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCacheImpl, com.baidu.live.adp.lib.cache.BdKVCache
    public T get(String str) {
        try {
            return (T) super.get(str);
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e(th);
            }
            return null;
        }
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCacheImpl, com.baidu.live.adp.lib.cache.BdKVCache
    public BdKVCache.CacheElement<T> getForDetail(String str) {
        try {
            return super.getForDetail(str);
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e(th);
            }
            return null;
        }
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCacheImpl, com.baidu.live.adp.lib.cache.BdKVCache
    public void set(String str, T t, long j) {
        try {
            super.set(str, t, j);
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e(th);
            }
        }
    }

    @Override // com.baidu.live.adp.lib.cache.BdKVCacheImpl, com.baidu.live.adp.lib.cache.BdKVCache
    public void remove(String str) {
        try {
            super.remove(str);
        } catch (Throwable th) {
            if (BdLog.isDebugMode()) {
                BdLog.e(th);
            }
        }
    }
}
