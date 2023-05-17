package com.baidu.nadcore.utils;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class LruCache<K, V> extends LinkedHashMap<K, V> {
    public static final int DEFAULT_CACHE_SIZE = 32;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;
    public final int mMaxCacheSize;

    public LruCache() {
        super((int) (Math.ceil(42.66666793823242d) + 1.0d), 0.75f, true);
        this.mMaxCacheSize = 32;
    }

    public LruCache(int i) {
        super((int) (Math.ceil(i / 0.75f) + 1.0d), 0.75f, true);
        this.mMaxCacheSize = i;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        if (size() > this.mMaxCacheSize) {
            return true;
        }
        return false;
    }
}
