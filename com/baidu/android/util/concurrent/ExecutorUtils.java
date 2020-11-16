package com.baidu.android.util.concurrent;

import android.support.annotation.NonNull;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
@Deprecated
/* loaded from: classes16.dex */
public class ExecutorUtils {
    private ExecutorUtils() {
    }

    @Deprecated
    public static void postOnIO(@NonNull Runnable runnable, @NonNull String str) {
        ExecutorUtilsExt.postOnElastic(runnable, str, 2);
    }

    @Deprecated
    public static void postOnComputation(@NonNull Runnable runnable, @NonNull String str) {
        ExecutorUtilsExt.postOnElastic(runnable, str, 2);
    }

    @Deprecated
    public static String getStandardThreadName(String str) {
        String str2 = null;
        if (str != null) {
            str2 = !str.startsWith("RxDeprecate_") ? "RxDeprecate_" + str : str;
        }
        if (str2 == null) {
            str2 = "RxDeprecate";
        }
        if (str2.length() > 256) {
            return str2.substring(0, 255);
        }
        return str2;
    }
}
