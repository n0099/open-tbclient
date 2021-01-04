package com.baidu.sumeru.universalimageloader.cache.disc.impl;

import com.baidu.sumeru.universalimageloader.cache.disc.LimitedDiscCache;
import com.baidu.sumeru.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.baidu.sumeru.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;
/* loaded from: classes3.dex */
public class FileCountLimitedDiscCache extends LimitedDiscCache {
    public FileCountLimitedDiscCache(File file, int i) {
        this(file, DefaultConfigurationFactory.createFileNameGenerator(), i);
    }

    public FileCountLimitedDiscCache(File file, FileNameGenerator fileNameGenerator, int i) {
        super(file, fileNameGenerator, i);
    }

    @Override // com.baidu.sumeru.universalimageloader.cache.disc.LimitedDiscCache
    protected int getSize(File file) {
        return 1;
    }
}
