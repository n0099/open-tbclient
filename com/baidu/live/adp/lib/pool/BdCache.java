package com.baidu.live.adp.lib.pool;

import com.baidu.webkit.internal.ETAG;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class BdCache<K, V> {
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map = new LinkedHashMap<>(0, 0.75f, true);
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public BdCache(int i) {
        this.maxSize = i;
    }

    public final V get(K k) {
        V v = null;
        if (k != null) {
            synchronized (this) {
                V v2 = this.map.get(k);
                if (v2 != null) {
                    this.hitCount++;
                    v = v2;
                } else {
                    this.missCount++;
                }
            }
        }
        return v;
    }

    public final V put(K k, V v) {
        V put;
        if (k == null || v == null) {
            return null;
        }
        synchronized (this) {
            this.putCount++;
            this.size += safeSizeOf(k, v);
            put = this.map.put(k, v);
            if (put != null) {
                this.size -= safeSizeOf(k, put);
            }
        }
        if (put != null) {
            entryRemoved(false, k, put, v);
        }
        trimToSize(this.maxSize);
        return put;
    }

    public synchronized boolean freeMemory(int i) {
        if (this.size + i > this.maxSize * 0.8d) {
            trimToSize(this.size - i);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void trimToSize(int i) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.size < 0 || (this.map.isEmpty() && this.size != 0)) {
                    break;
                } else if (this.size <= i || this.map.isEmpty()) {
                    break;
                } else {
                    Map.Entry<K, V> next = this.map.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.map.remove(key);
                    this.size -= safeSizeOf(key, value);
                    this.evictionCount++;
                }
            }
            entryRemoved(true, key, value, null);
        }
    }

    public final V remove(K k) {
        V remove;
        if (k == null) {
            return null;
        }
        synchronized (this) {
            remove = this.map.remove(k);
            if (remove != null) {
                this.size -= safeSizeOf(k, remove);
            }
        }
        if (remove != null) {
            entryRemoved(false, k, remove, null);
        }
        return remove;
    }

    protected void entryRemoved(boolean z, K k, V v, V v2) {
    }

    private int safeSizeOf(K k, V v) {
        int sizeOf = sizeOf(k, v);
        if (sizeOf < 0) {
            throw new IllegalStateException("Negative size: " + k + ETAG.EQUAL + v);
        }
        return sizeOf;
    }

    protected int sizeOf(K k, V v) {
        return 1;
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized void clear() {
        evictAll();
        this.putCount = 0;
        this.evictionCount = 0;
        this.hitCount = 0;
        this.missCount = 0;
    }

    public final synchronized int size() {
        return this.size;
    }

    public final synchronized int getMaxSize() {
        return this.maxSize;
    }

    public final void setMaxSize(int i) {
        synchronized (this) {
            this.maxSize = i;
            trimToSize(i);
        }
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }
}
