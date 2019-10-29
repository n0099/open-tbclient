package com.baidu.bdhttpdns;

import android.util.Log;
/* loaded from: classes.dex */
final class f {
    private static boolean a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, Object... objArr) {
        if (a) {
            Log.v("BDHttpDns", String.format(str, objArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z) {
        a = z;
    }
}
