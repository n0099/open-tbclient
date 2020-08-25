package com.baidu.live.adp.lib.cache;
/* loaded from: classes7.dex */
public interface BdCacheEvictPolicy {

    /* loaded from: classes7.dex */
    public interface EvictOnCountSupport extends BdCacheEvictPolicy {
        void finishEvict();

        String getEvictedKey(BdCacheItem<?> bdCacheItem);

        void startEvict();
    }

    /* loaded from: classes7.dex */
    public interface EvictOnInsertSupport extends BdCacheEvictPolicy {
        void finishInit();

        String onItemJoined(BdCacheItem<?> bdCacheItem);

        String prepareForOldData(BdCacheItem<?> bdCacheItem);

        void release();

        void startInit();
    }

    int getMaxSize();

    String getName();

    boolean shouldUpdateLastHitTime();
}
