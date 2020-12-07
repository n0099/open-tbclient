package com.baidu.searchbox.feed.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/* loaded from: classes8.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static boolean isIllegalArgument(boolean z, @NonNull String str, @Nullable Object... objArr) {
        if (z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        return z;
    }

    public static boolean isIllegalArgument(boolean z, @NonNull Throwable th) {
        if (z) {
            throw new IllegalArgumentException(th);
        }
        return z;
    }

    public static boolean isIllegalState(boolean z, @NonNull String str, @Nullable Object... objArr) {
        if (z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
        return z;
    }

    public static boolean isIllegalState(boolean z, @NonNull Throwable th) {
        if (z) {
            throw new IllegalStateException(th);
        }
        return z;
    }

    public static void checkArgumentFalse(boolean z, @Nullable Object obj, @NonNull String str, @Nullable Object... objArr) {
        if (z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void checkArgumentFalse(boolean z, @Nullable Object obj, @NonNull Throwable th) {
        if (z) {
            throw new IllegalArgumentException(th);
        }
    }

    public static void checkStateFalse(boolean z, @Nullable Object obj, @NonNull String str, @Nullable Object... objArr) {
        if (z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static void checkStateFalse(boolean z, @Nullable Object obj, @NonNull Throwable th) {
        if (z) {
            throw new IllegalStateException(th);
        }
    }
}
