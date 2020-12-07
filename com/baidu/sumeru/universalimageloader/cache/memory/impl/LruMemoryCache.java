package com.baidu.sumeru.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class LruMemoryCache implements MemoryCacheAware<String, Bitmap> {
    private final LinkedHashMap<String, Bitmap> map;
    private final int maxSize;
    private int size;

    public LruMemoryCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public final Bitmap get(String str) {
        Bitmap bitmap;
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            bitmap = this.map.get(str);
        }
        return bitmap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public final boolean put(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.size += sizeOf(str, bitmap);
            Bitmap put = this.map.put(str, bitmap);
            if (put != null) {
                this.size -= sizeOf(str, put);
            }
        }
        trimToSize(this.maxSize);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void trimToSize(int i) {
        while (true) {
            synchronized (this) {
                if (this.size < 0 || (this.map.isEmpty() && this.size != 0)) {
                    break;
                } else if (this.size <= i || this.map.isEmpty()) {
                    break;
                } else {
                    Map.Entry<String, Bitmap> next = this.map.entrySet().iterator().next();
                    if (next != null) {
                        String key = next.getKey();
                        this.map.remove(key);
                        this.size -= sizeOf(key, next.getValue());
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public final void remove(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Bitmap remove = this.map.remove(str);
            if (remove != null) {
                this.size -= sizeOf(str, remove);
            }
        }
    }

    @Override // com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public Collection<String> keys() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.map.keySet());
        }
        return hashSet;
    }

    @Override // com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        trimToSize(-1);
    }

    private int sizeOf(String str, Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.maxSize));
    }
}
