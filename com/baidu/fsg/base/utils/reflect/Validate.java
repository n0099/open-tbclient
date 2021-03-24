package com.baidu.fsg.base.utils.reflect;
/* loaded from: classes2.dex */
public class Validate {
    public static void a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
