package com.baidu.live.adp.lib.cache;

import com.baidu.live.adp.lib.cache.BdCacheEvictPolicy;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes7.dex */
public class BdCacheEvictPolicyFactory {
    public static BdCacheEvictPolicy newLRUCachePolicy(int i, boolean z) {
        return z ? new EvictOnInsertLRUCachePolicy(i) : new EvictOnCountLRUCachePolicy(i);
    }

    public static BdCacheEvictPolicy newNoEvictCachePolicy() {
        return new NoEvictCachePolicy();
    }

    /* loaded from: classes7.dex */
    static class NoEvictCachePolicy implements BdCacheEvictPolicy {
        NoEvictCachePolicy() {
        }

        @Override // com.baidu.live.adp.lib.cache.BdCacheEvictPolicy
        public String getName() {
            return "Noop";
        }

        @Override // com.baidu.live.adp.lib.cache.BdCacheEvictPolicy
        public int getMaxSize() {
            return 1;
        }

        @Override // com.baidu.live.adp.lib.cache.BdCacheEvictPolicy
        public boolean shouldUpdateLastHitTime() {
            return false;
        }
    }

    /* loaded from: classes7.dex */
    static class EvictOnCountLRUCachePolicy implements BdCacheEvictPolicy.EvictOnCountSupport {
        private final int maxSize;
        private LinkedList<BdCacheItem<?>> tempItems;

        public EvictOnCountLRUCachePolicy(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.live.adp.lib.cache.BdCacheEvictPolicy
        public String getName() {
            return "LRU_EVICT_ON_COUNT";
        }

        @Override // com.baidu.live.adp.lib.cache.BdCacheEvictPolicy
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.live.adp.lib.cache.BdCacheEvictPolicy.EvictOnCountSupport
        public void startEvict() {
            this.tempItems = new LinkedList<>();
        }

        @Override // com.baidu.live.adp.lib.cache.BdCacheEvictPolicy.EvictOnCountSupport
        public String getEvictedKey(BdCacheItem<?> bdCacheItem) {
            String str;
            int i;
            String str2 = null;
            if (bdCacheItem.timeToExpire < System.currentTimeMillis()) {
                return bdCacheItem.uniqueKey;
            }
            this.tempItems.add(bdCacheItem);
            if (this.tempItems.size() > getMaxSize()) {
                long j = 0;
                int i2 = 0;
                int i3 = -1;
                while (i2 < this.tempItems.size()) {
                    BdCacheItem<?> bdCacheItem2 = this.tempItems.get(i2);
                    if (i3 == -1 || bdCacheItem2.lastHitTime < j) {
                        String str3 = bdCacheItem2.uniqueKey;
                        j = bdCacheItem2.lastHitTime;
                        str = str3;
                        i = i2;
                    } else {
                        str = str2;
                        i = i3;
                    }
                    i2++;
                    i3 = i;
                    str2 = str;
                }
                this.tempItems.remove(i3);
                return str2;
            }
            return null;
        }

        @Override // com.baidu.live.adp.lib.cache.BdCacheEvictPolicy.EvictOnCountSupport
        public void finishEvict() {
            this.tempItems.clear();
            this.tempItems = null;
        }

        @Override // com.baidu.live.adp.lib.cache.BdCacheEvictPolicy
        public boolean shouldUpdateLastHitTime() {
            return true;
        }
    }

    /* loaded from: classes7.dex */
    static class EvictOnInsertLRUCachePolicy implements BdCacheEvictPolicy.EvictOnInsertSupport {
        private HashMap<String, Long> items = new HashMap<>();
        private final int maxSize;

        public EvictOnInsertLRUCachePolicy(int i) {
            this.maxSize = i;
        }

        @Override // com.baidu.live.adp.lib.cache.BdCacheEvictPolicy
        public String getName() {
            return "LRU_EVICT_ON_INSERT";
        }

        @Override // com.baidu.live.adp.lib.cache.BdCacheEvictPolicy
        public int getMaxSize() {
            return this.maxSize;
        }

        @Override // com.baidu.live.adp.lib.cache.BdCacheEvictPolicy
        public boolean shouldUpdateLastHitTime() {
            return true;
        }

        public String keyToEvictedOnNewItemJoined(String str) {
            String key;
            long j;
            String str2 = null;
            if (!this.items.containsKey(str) && this.items.size() >= this.maxSize) {
                synchronized (this) {
                    long j2 = -1;
                    for (Map.Entry<String, Long> entry : this.items.entrySet()) {
                        long longValue = entry.getValue().longValue();
                        if (j2 == -1 || j2 > longValue) {
                            key = entry.getKey();
                            j = longValue;
                        } else {
                            j = j2;
                            key = str2;
                        }
                        str2 = key;
                        j2 = j;
                    }
                    if (str2 != null) {
                        this.items.remove(str2);
                    }
                }
            }
            return str2;
        }

        @Override // com.baidu.live.adp.lib.cache.BdCacheEvictPolicy.EvictOnInsertSupport
        public String onItemJoined(BdCacheItem<?> bdCacheItem) {
            String keyToEvictedOnNewItemJoined = keyToEvictedOnNewItemJoined(bdCacheItem.uniqueKey);
            synchronized (this) {
                this.items.put(bdCacheItem.uniqueKey, Long.valueOf(bdCacheItem.lastHitTime));
            }
            return keyToEvictedOnNewItemJoined;
        }

        @Override // com.baidu.live.adp.lib.cache.BdCacheEvictPolicy.EvictOnInsertSupport
        public void startInit() {
        }

        @Override // com.baidu.live.adp.lib.cache.BdCacheEvictPolicy.EvictOnInsertSupport
        public String prepareForOldData(BdCacheItem<?> bdCacheItem) {
            return bdCacheItem.timeToExpire < System.currentTimeMillis() ? bdCacheItem.uniqueKey : onItemJoined(bdCacheItem);
        }

        @Override // com.baidu.live.adp.lib.cache.BdCacheEvictPolicy.EvictOnInsertSupport
        public void finishInit() {
        }

        @Override // com.baidu.live.adp.lib.cache.BdCacheEvictPolicy.EvictOnInsertSupport
        public void release() {
            synchronized (this) {
                this.items.clear();
            }
        }
    }
}
