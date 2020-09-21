package com.baidu.sumeru.universalimageloader.cache.memory;

import com.baidu.sumeru.universalimageloader.utils.L;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public abstract class LimitedMemoryCache<K, V> extends BaseMemoryCache<K, V> {
    private static final int MAX_NORMAL_CACHE_SIZE = 16777216;
    private static final int MAX_NORMAL_CACHE_SIZE_IN_MB = 16;
    private final int sizeLimit;
    private final List<V> hardCache = Collections.synchronizedList(new LinkedList());
    private final AtomicInteger cacheSize = new AtomicInteger();

    protected abstract int getSize(V v);

    protected abstract V removeNext();

    public LimitedMemoryCache(int i) {
        this.sizeLimit = i;
        if (i > 16777216) {
            L.w("You set too large memory cache size (more than %1$d Mb)", 16);
        }
    }

    @Override // com.baidu.sumeru.universalimageloader.cache.memory.BaseMemoryCache, com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public boolean put(K k, V v) {
        boolean z = false;
        int size = getSize(v);
        int sizeLimit = getSizeLimit();
        int i = this.cacheSize.get();
        if (size < sizeLimit) {
            int i2 = i;
            while (i2 + size > sizeLimit) {
                V removeNext = removeNext();
                if (this.hardCache.remove(removeNext)) {
                    i2 = this.cacheSize.addAndGet(-getSize(removeNext));
                }
            }
            this.hardCache.add(v);
            this.cacheSize.addAndGet(size);
            z = true;
        }
        super.put(k, v);
        return z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.sumeru.universalimageloader.cache.memory.LimitedMemoryCache<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.sumeru.universalimageloader.cache.memory.BaseMemoryCache, com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public void remove(K k) {
        Object obj = super.get(k);
        if (obj != null && this.hardCache.remove(obj)) {
            this.cacheSize.addAndGet(-getSize(obj));
        }
        super.remove(k);
    }

    @Override // com.baidu.sumeru.universalimageloader.cache.memory.BaseMemoryCache, com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        this.hardCache.clear();
        this.cacheSize.set(0);
        super.clear();
    }

    protected int getSizeLimit() {
        return this.sizeLimit;
    }
}
