package com.baidu.fsg.base.utils;

import java.util.Collection;
import java.util.Map;
/* loaded from: classes11.dex */
public abstract class CollectionUtils {
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }
}
