package com.baidu.fsg.base.utils;

import java.util.Collection;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class Assert {
    public static void isTrue(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void isTrue(boolean z) {
        isTrue(z, "[Assertion failed] - this expression must be true");
    }

    public static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notNull(Object obj) {
        notNull(obj, "[Assertion failed] - this argument is required; it must not be null");
    }

    public static void hasLength(String str, String str2) {
        if (!StringUtils.hasLength(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void hasLength(String str) {
        hasLength(str, "[Assertion failed] - this String argument must have length; it must not be null or empty");
    }

    public static void notEmpty(Collection<?> collection, String str) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notEmpty(Collection<?> collection) {
        notEmpty(collection, "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
    }

    public static void notEmpty(Map<?, ?> map, String str) {
        if (CollectionUtils.isEmpty(map)) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notEmpty(Map<?, ?> map) {
        notEmpty(map, "[Assertion failed] - this map must not be empty; it must contain at least one entry");
    }

    public static void state(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    public static void state(boolean z) {
        state(z, "[Assertion failed] - this state invariant must be true");
    }
}
