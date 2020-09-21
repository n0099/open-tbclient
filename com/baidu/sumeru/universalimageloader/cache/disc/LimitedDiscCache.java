package com.baidu.sumeru.universalimageloader.cache.disc;

import com.baidu.sumeru.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.baidu.sumeru.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public abstract class LimitedDiscCache extends BaseDiscCache {
    private static final int INVALID_SIZE = -1;
    private final AtomicInteger cacheSize;
    private final Map<File, Long> lastUsageDates;
    private final int sizeLimit;

    protected abstract int getSize(File file);

    public LimitedDiscCache(File file, int i) {
        this(file, DefaultConfigurationFactory.createFileNameGenerator(), i);
    }

    public LimitedDiscCache(File file, FileNameGenerator fileNameGenerator, int i) {
        super(file, fileNameGenerator);
        this.lastUsageDates = Collections.synchronizedMap(new HashMap());
        this.sizeLimit = i;
        this.cacheSize = new AtomicInteger();
        calculateCacheSizeAndFillUsageMap();
    }

    private void calculateCacheSizeAndFillUsageMap() {
        new Thread(new Runnable() { // from class: com.baidu.sumeru.universalimageloader.cache.disc.LimitedDiscCache.1
            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles = LimitedDiscCache.this.cacheDir.listFiles();
                if (listFiles != null) {
                    int i = 0;
                    for (File file : listFiles) {
                        i += LimitedDiscCache.this.getSize(file);
                        LimitedDiscCache.this.lastUsageDates.put(file, Long.valueOf(file.lastModified()));
                    }
                    LimitedDiscCache.this.cacheSize.set(i);
                }
            }
        }).start();
    }

    @Override // com.baidu.sumeru.universalimageloader.cache.disc.DiscCacheAware
    public void put(String str, File file) {
        int removeNext;
        int size = getSize(file);
        int i = this.cacheSize.get();
        while (i + size > this.sizeLimit && (removeNext = removeNext()) != -1) {
            i = this.cacheSize.addAndGet(-removeNext);
        }
        this.cacheSize.addAndGet(size);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        file.setLastModified(valueOf.longValue());
        this.lastUsageDates.put(file, valueOf);
    }

    @Override // com.baidu.sumeru.universalimageloader.cache.disc.BaseDiscCache, com.baidu.sumeru.universalimageloader.cache.disc.DiscCacheAware
    public File get(String str) {
        File file = super.get(str);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        file.setLastModified(valueOf.longValue());
        this.lastUsageDates.put(file, valueOf);
        return file;
    }

    @Override // com.baidu.sumeru.universalimageloader.cache.disc.BaseDiscCache, com.baidu.sumeru.universalimageloader.cache.disc.DiscCacheAware
    public void clear() {
        this.lastUsageDates.clear();
        this.cacheSize.set(0);
        super.clear();
    }

    private int removeNext() {
        File file;
        Long l;
        File file2 = null;
        if (this.lastUsageDates.isEmpty()) {
            return -1;
        }
        Set<Map.Entry<File, Long>> entrySet = this.lastUsageDates.entrySet();
        synchronized (this.lastUsageDates) {
            Long l2 = null;
            for (Map.Entry<File, Long> entry : entrySet) {
                if (file2 == null) {
                    file = entry.getKey();
                    l = entry.getValue();
                } else {
                    Long value = entry.getValue();
                    if (value.longValue() < l2.longValue()) {
                        File key = entry.getKey();
                        l = value;
                        file = key;
                    } else {
                        file = file2;
                        l = l2;
                    }
                }
                file2 = file;
                l2 = l;
            }
        }
        if (file2 == null) {
            return 0;
        }
        if (file2.exists()) {
            int size = getSize(file2);
            if (file2.delete()) {
                this.lastUsageDates.remove(file2);
                return size;
            }
            return size;
        }
        this.lastUsageDates.remove(file2);
        return 0;
    }
}
