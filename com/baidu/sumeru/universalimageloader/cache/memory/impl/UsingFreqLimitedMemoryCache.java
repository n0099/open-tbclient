package com.baidu.sumeru.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.baidu.sumeru.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes11.dex */
public class UsingFreqLimitedMemoryCache extends LimitedMemoryCache<String, Bitmap> {
    private final Map<Bitmap, Integer> usingCounts;

    public UsingFreqLimitedMemoryCache(int i) {
        super(i);
        this.usingCounts = Collections.synchronizedMap(new HashMap());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sumeru.universalimageloader.cache.memory.LimitedMemoryCache, com.baidu.sumeru.universalimageloader.cache.memory.BaseMemoryCache, com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public boolean put(String str, Bitmap bitmap) {
        if (super.put((UsingFreqLimitedMemoryCache) str, (String) bitmap)) {
            this.usingCounts.put(bitmap, 0);
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sumeru.universalimageloader.cache.memory.BaseMemoryCache, com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public Bitmap get(String str) {
        Integer num;
        Bitmap bitmap = (Bitmap) super.get((UsingFreqLimitedMemoryCache) str);
        if (bitmap != null && (num = this.usingCounts.get(bitmap)) != null) {
            this.usingCounts.put(bitmap, Integer.valueOf(num.intValue() + 1));
        }
        return bitmap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sumeru.universalimageloader.cache.memory.LimitedMemoryCache, com.baidu.sumeru.universalimageloader.cache.memory.BaseMemoryCache, com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public void remove(String str) {
        Bitmap bitmap = (Bitmap) super.get((UsingFreqLimitedMemoryCache) str);
        if (bitmap != null) {
            this.usingCounts.remove(bitmap);
        }
        super.remove((UsingFreqLimitedMemoryCache) str);
    }

    @Override // com.baidu.sumeru.universalimageloader.cache.memory.LimitedMemoryCache, com.baidu.sumeru.universalimageloader.cache.memory.BaseMemoryCache, com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware
    public void clear() {
        this.usingCounts.clear();
        super.clear();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sumeru.universalimageloader.cache.memory.LimitedMemoryCache
    public int getSize(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.sumeru.universalimageloader.cache.memory.LimitedMemoryCache
    public Bitmap removeNext() {
        Bitmap bitmap;
        Integer num;
        Bitmap bitmap2 = null;
        Set<Map.Entry<Bitmap, Integer>> entrySet = this.usingCounts.entrySet();
        synchronized (this.usingCounts) {
            Integer num2 = null;
            for (Map.Entry<Bitmap, Integer> entry : entrySet) {
                if (bitmap2 == null) {
                    bitmap = entry.getKey();
                    num = entry.getValue();
                } else {
                    Integer value = entry.getValue();
                    if (value.intValue() < num2.intValue()) {
                        Bitmap key = entry.getKey();
                        num = value;
                        bitmap = key;
                    } else {
                        bitmap = bitmap2;
                        num = num2;
                    }
                }
                bitmap2 = bitmap;
                num2 = num;
            }
        }
        this.usingCounts.remove(bitmap2);
        return bitmap2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sumeru.universalimageloader.cache.memory.BaseMemoryCache
    public Reference<Bitmap> createReference(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }
}
