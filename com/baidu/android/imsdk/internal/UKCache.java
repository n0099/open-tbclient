package com.baidu.android.imsdk.internal;

import android.util.LruCache;
/* loaded from: classes.dex */
public class UKCache {
    public LruCache<Long, Long> mCache;

    public UKCache(int i) {
        this.mCache = null;
        this.mCache = new LruCache<>(i);
    }

    public Long get(long j) {
        if (j < 0) {
            return null;
        }
        return this.mCache.get(Long.valueOf(j));
    }

    public boolean put(Long l, Long l2) {
        if (l == null) {
            return false;
        }
        this.mCache.put(l, l2);
        return true;
    }

    public Long remove(Long l) {
        return this.mCache.remove(l);
    }

    public void removeAll() {
        this.mCache.evictAll();
    }
}
