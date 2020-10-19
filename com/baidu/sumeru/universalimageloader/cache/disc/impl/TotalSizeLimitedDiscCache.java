package com.baidu.sumeru.universalimageloader.cache.disc.impl;

import com.baidu.sumeru.universalimageloader.cache.disc.LimitedDiscCache;
import com.baidu.sumeru.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.baidu.sumeru.universalimageloader.core.DefaultConfigurationFactory;
import com.baidu.sumeru.universalimageloader.utils.L;
import java.io.File;
/* loaded from: classes12.dex */
public class TotalSizeLimitedDiscCache extends LimitedDiscCache {
    private static final int MIN_NORMAL_CACHE_SIZE = 2097152;
    private static final int MIN_NORMAL_CACHE_SIZE_IN_MB = 2;

    public TotalSizeLimitedDiscCache(File file, int i) {
        this(file, DefaultConfigurationFactory.createFileNameGenerator(), i);
    }

    public TotalSizeLimitedDiscCache(File file, FileNameGenerator fileNameGenerator, int i) {
        super(file, fileNameGenerator, i);
        if (i < 2097152) {
            L.w("You set too small disc cache size (less than %1$d Mb)", 2);
        }
    }

    @Override // com.baidu.sumeru.universalimageloader.cache.disc.LimitedDiscCache
    protected int getSize(File file) {
        return (int) file.length();
    }
}
