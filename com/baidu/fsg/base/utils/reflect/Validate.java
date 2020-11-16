package com.baidu.fsg.base.utils.reflect;
/* loaded from: classes15.dex */
class Validate {
    Validate() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
