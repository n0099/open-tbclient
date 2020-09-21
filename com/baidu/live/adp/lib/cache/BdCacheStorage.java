package com.baidu.live.adp.lib.cache;

import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes4.dex */
public interface BdCacheStorage<T> {
    void clearAndClose(String str);

    void flushAndClose(String str);

    T get(String str, String str2);

    BdCacheEvictPolicy getCachePolicy();

    BdKVCache.CacheElement<T> getForDetail(String str, String str2);

    void remove(String str, String str2);

    void set(String str, String str2, T t, long j);

    void startup(String str);
}
