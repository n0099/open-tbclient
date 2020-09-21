package com.baidu.sumeru.universalimageloader.cache.memory;

import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes9.dex */
public abstract class BaseMemoryCache<K, V> implements MemoryCacheAware<K, V> {
    private final Map<K, Reference<V>> softMap = Collections.synchronizedMap(new HashMap());

    protected abstract Reference<V> createReference(V v);

    @Override // com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public V get(K k) {
        Reference<V> reference = this.softMap.get(k);
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    @Override // com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public boolean put(K k, V v) {
        this.softMap.put(k, createReference(v));
        return true;
    }

    @Override // com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public void remove(K k) {
        this.softMap.remove(k);
    }

    @Override // com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public Collection<K> keys() {
        HashSet hashSet;
        synchronized (this.softMap) {
            hashSet = new HashSet(this.softMap.keySet());
        }
        return hashSet;
    }

    @Override // com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        this.softMap.clear();
    }
}
