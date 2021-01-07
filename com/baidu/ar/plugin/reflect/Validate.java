package com.baidu.ar.plugin.reflect;
/* loaded from: classes3.dex */
class Validate {
    Validate() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void isTrue(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
