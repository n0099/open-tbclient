package com.baidu.platform.comapi.walknavi.d.a.g;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes8.dex */
public class j {
    private static Handler a;

    public static void a(Runnable runnable) {
        synchronized (j.class) {
            if (a == null) {
                a = new Handler(Looper.getMainLooper());
            }
        }
        a.post(runnable);
    }
}
