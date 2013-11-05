package com.baidu.cloudsdk.common.util;

import android.text.TextUtils;
import java.util.Collection;
/* loaded from: classes.dex */
public final class Validator {
    public static void containsNoNulls(Collection collection, String str) {
        notNull(collection, str);
        for (Object obj : collection) {
            if (obj == null) {
                throw new NullPointerException(String.format("Container '%s' cannot contain null values", str));
            }
        }
    }

    public static void notEmptyAndContainsNoNulls(Collection collection, String str) {
        notNullOrEmpty(collection, str);
        for (Object obj : collection) {
            if (obj == null) {
                throw new NullPointerException(String.format("Container '%s' cannot contain null values", str));
            }
        }
    }

    public static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(String.format("Argument '%s' cannot be null", str));
        }
    }

    public static void notNullOrEmpty(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.format("Argument '%s' cannot be null or empty", str2));
        }
    }

    public static void notNullOrEmpty(Collection collection, String str) {
        if (Utils.isEmpty(collection)) {
            throw new IllegalArgumentException(String.format("Argument '%s' cannot be null or empty", str));
        }
    }

    public static void notNullOrEmpty(Object[] objArr, String str) {
        notNull(objArr, str);
        if (objArr.length == 0) {
            throw new IllegalArgumentException(String.format("Argument '%s' cannot be null or empty", str));
        }
    }

    public static void oneOf(Object obj, String str, Object... objArr) {
        for (Object obj2 : objArr) {
            if (obj2 != null) {
                if (obj2.equals(obj)) {
                    return;
                }
            } else if (obj == null) {
                return;
            }
        }
        throw new IllegalArgumentException(String.format("Argument '%s' was not one of the allowed values", str));
    }
}
