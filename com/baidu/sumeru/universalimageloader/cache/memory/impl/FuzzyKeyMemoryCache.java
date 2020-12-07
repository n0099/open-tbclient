package com.baidu.sumeru.universalimageloader.cache.memory.impl;

import com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class FuzzyKeyMemoryCache<K, V> implements MemoryCacheAware<K, V> {
    private final MemoryCacheAware<K, V> cache;
    private final Comparator<K> keyComparator;

    public FuzzyKeyMemoryCache(MemoryCacheAware<K, V> memoryCacheAware, Comparator<K> comparator) {
        this.cache = memoryCacheAware;
        this.keyComparator = comparator;
    }

    @Override // com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public boolean put(K k, V v) {
        K k2;
        synchronized (this.cache) {
            Iterator<K> it = this.cache.keys().iterator();
            while (true) {
                if (!it.hasNext()) {
                    k2 = null;
                    break;
                }
                k2 = it.next();
                if (this.keyComparator.compare(k, k2) == 0) {
                    break;
                }
            }
            if (k2 != null) {
                this.cache.remove(k2);
            }
        }
        return this.cache.put(k, v);
    }

    @Override // com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public V get(K k) {
        return this.cache.get(k);
    }

    @Override // com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public void remove(K k) {
        this.cache.remove(k);
    }

    @Override // com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        this.cache.clear();
    }

    @Override // com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public Collection<K> keys() {
        return this.cache.keys();
    }
}
