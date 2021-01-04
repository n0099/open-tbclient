package com.baidu.bdhttpdns;

import android.util.Log;
/* loaded from: classes6.dex */
final class l {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1637a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, Object... objArr) {
        if (f1637a) {
            Log.v("BDHttpDns", String.format(str, objArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z) {
        f1637a = z;
    }
}
