package com.baidu.sumeru.universalimageloader.cache.memory;

import java.util.Collection;
/* loaded from: classes9.dex */
public interface MemoryCacheAware<K, V> {
    void clear();

    V get(K k);

    Collection<K> keys();

    boolean put(K k, V v);

    void remove(K k);
}
