package com.baidu.ar.plugin.reflect;
/* loaded from: classes2.dex */
public class Validate {
    public static void isTrue(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
