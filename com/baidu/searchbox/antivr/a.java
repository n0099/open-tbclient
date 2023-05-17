package com.baidu.searchbox.antivr;

import android.util.Log;
/* loaded from: classes3.dex */
public class a {
    public static final String a = "VRChecker";
    public static volatile boolean b;

    public static void a(String str) {
        if (b) {
            Log.d(a, str);
        }
    }

    public static void a(String str, Throwable th) {
        if (b) {
            Log.e(a, str, th);
        }
    }

    public static void a(boolean z) {
        b = z;
    }
}
