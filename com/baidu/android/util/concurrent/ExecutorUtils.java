package com.baidu.android.util.concurrent;

import androidx.annotation.NonNull;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
@Deprecated
/* loaded from: classes.dex */
public class ExecutorUtils {
    @Deprecated
    public static String getStandardThreadName(String str) {
        if (str == null) {
            str = null;
        } else if (!str.startsWith("RxDeprecate_")) {
            str = "RxDeprecate_" + str;
        }
        if (str == null) {
            str = "RxDeprecate";
        }
        return str.length() > 256 ? str.substring(0, 255) : str;
    }

    @Deprecated
    public static void postOnComputation(@NonNull Runnable runnable, @NonNull String str) {
        ExecutorUtilsExt.postOnElastic(runnable, str, 2);
    }

    @Deprecated
    public static void postOnIO(@NonNull Runnable runnable, @NonNull String str) {
        ExecutorUtilsExt.postOnElastic(runnable, str, 2);
    }
}
