package com.baidu.searchbox.network.support.okhttp.converters;

import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class ConverterUtils {
    public static RuntimeException methodError(String str, String str2, Object... objArr) {
        return methodError(str, null, str2, objArr);
    }

    public static RuntimeException methodError(String str, @Nullable Throwable th, String str2, Object... objArr) {
        String format = String.format(str2, objArr);
        return new IllegalArgumentException(format + "\n    for method " + str + "." + th);
    }

    public static <T> T requireNonNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
