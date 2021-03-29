package com.baidu.apollon.utils.reflect;
/* loaded from: classes.dex */
public class b {
    public static void a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
