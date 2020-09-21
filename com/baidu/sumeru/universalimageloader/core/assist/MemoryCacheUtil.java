package com.baidu.sumeru.universalimageloader.core.assist;

import android.graphics.Bitmap;
import com.baidu.sumeru.universalimageloader.cache.memory.MemoryCacheAware;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes9.dex */
public final class MemoryCacheUtil {
    private static final String URI_AND_SIZE_SEPARATOR = "_";
    private static final String WIDTH_AND_HEIGHT_SEPARATOR = "x";

    private MemoryCacheUtil() {
    }

    public static String generateKey(String str, ImageSize imageSize) {
        return str + "_" + imageSize.getWidth() + "x" + imageSize.getHeight();
    }

    public static Comparator<String> createFuzzyKeyComparator() {
        return new Comparator<String>() { // from class: com.baidu.sumeru.universalimageloader.core.assist.MemoryCacheUtil.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return str.substring(0, str.lastIndexOf("_")).compareTo(str2.substring(0, str2.lastIndexOf("_")));
            }
        };
    }

    public static List<Bitmap> findCachedBitmapsForImageUri(String str, MemoryCacheAware<String, Bitmap> memoryCacheAware) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : memoryCacheAware.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(memoryCacheAware.get(str2));
            }
        }
        return arrayList;
    }

    public static List<String> findCacheKeysForImageUri(String str, MemoryCacheAware<String, Bitmap> memoryCacheAware) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : memoryCacheAware.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static void removeFromCache(String str, MemoryCacheAware<String, Bitmap> memoryCacheAware) {
        ArrayList<String> arrayList = new ArrayList();
        for (String str2 : memoryCacheAware.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        for (String str3 : arrayList) {
            memoryCacheAware.remove(str3);
        }
    }
}
