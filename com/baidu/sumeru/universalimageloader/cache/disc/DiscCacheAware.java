package com.baidu.sumeru.universalimageloader.cache.disc;

import java.io.File;
/* loaded from: classes11.dex */
public interface DiscCacheAware {
    void clear();

    File get(String str);

    void put(String str, File file);
}
