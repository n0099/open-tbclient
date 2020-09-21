package com.baidu.sumeru.universalimageloader.cache.disc.impl;

import com.baidu.sumeru.universalimageloader.cache.disc.BaseDiscCache;
import com.baidu.sumeru.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.baidu.sumeru.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;
/* loaded from: classes9.dex */
public class UnlimitedDiscCache extends BaseDiscCache {
    public UnlimitedDiscCache(File file) {
        this(file, DefaultConfigurationFactory.createFileNameGenerator());
    }

    public UnlimitedDiscCache(File file, FileNameGenerator fileNameGenerator) {
        super(file, fileNameGenerator);
    }

    @Override // com.baidu.sumeru.universalimageloader.cache.disc.DiscCacheAware
    public void put(String str, File file) {
    }
}
