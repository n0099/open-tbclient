package com.baidu.bdhttpdns;

import android.util.Log;
/* loaded from: classes19.dex */
final class l {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1280a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, Object... objArr) {
        if (f1280a) {
            Log.v("BDHttpDns", String.format(str, objArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z) {
        f1280a = z;
    }
}
