package com.baidu.live.adp.lib.cache;
/* loaded from: classes3.dex */
public interface BdKVCache<T> {
    public static final long MILLS_10Years = 315532800000L;
    public static final long MILLS_1Hour = 3600000;
    public static final long MILLS_1YEAR = 31536000000L;
    public static final long MILLS_24Hours = 86400000;
    public static final long MILLS_30Days = 2592000000L;

    /* loaded from: classes3.dex */
    public interface BdCacheGetCallback<T> {
        void onItemGet(String str, T t);
    }

    /* loaded from: classes3.dex */
    public interface BdCacheGetDetailCallback<T> {
        void onItemGet(String str, CacheElement<T> cacheElement);
    }

    /* loaded from: classes3.dex */
    public static class CacheElement<T> {
        public String key;
        public long lastSaveTime;
        public long timeToExpire;
        public T value;
    }

    /* loaded from: classes3.dex */
    public interface MXSupportedCache<T> extends BdKVCache<T> {
        void clearAndClose();

        void flushAndClose();

        BdCacheStorage<T> getCacheStorage();

        String getNameSpace();

        void onCacheCreated();
    }

    void asyncGet(String str, BdCacheGetCallback<T> bdCacheGetCallback);

    void asyncGetForDetail(String str, BdCacheGetDetailCallback<T> bdCacheGetDetailCallback);

    void asyncRemove(String str);

    void asyncSet(String str, T t, long j);

    void asyncSetForever(String str, T t);

    T get(String str);

    CacheElement<T> getForDetail(String str);

    void remove(String str);

    void set(String str, T t, long j);

    void setForever(String str, T t);
}
