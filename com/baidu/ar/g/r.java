package com.baidu.ar.g;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes11.dex */
public class r {
    private static Handler xt = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable, long j) {
        xt.postDelayed(runnable, j);
    }

    public static boolean gN() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void runOnUiThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (gN()) {
            runnable.run();
        } else {
            xt.post(runnable);
        }
    }
}
