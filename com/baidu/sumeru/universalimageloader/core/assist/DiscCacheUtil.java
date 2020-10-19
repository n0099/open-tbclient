package com.baidu.sumeru.universalimageloader.core.assist;

import com.baidu.sumeru.universalimageloader.cache.disc.DiscCacheAware;
import java.io.File;
/* loaded from: classes12.dex */
public final class DiscCacheUtil {
    private DiscCacheUtil() {
    }

    public static File findInCache(String str, DiscCacheAware discCacheAware) {
        File file = discCacheAware.get(str);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public static boolean removeFromCache(String str, DiscCacheAware discCacheAware) {
        return discCacheAware.get(str).delete();
    }
}
