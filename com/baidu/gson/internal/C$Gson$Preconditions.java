package com.baidu.gson.internal;
/* renamed from: com.baidu.gson.internal.$Gson$Preconditions  reason: invalid class name */
/* loaded from: classes.dex */
public final class C$Gson$Preconditions {
    public static <T> T checkNotNull(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}
