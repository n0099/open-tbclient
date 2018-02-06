package com.baidu.ar.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public class n {
    private static Handler a;

    public static void a(Runnable runnable) {
        synchronized (n.class) {
            if (a == null) {
                a = new Handler(Looper.getMainLooper());
            }
        }
        a.post(runnable);
    }
}
