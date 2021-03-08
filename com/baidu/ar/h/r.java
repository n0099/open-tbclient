package com.baidu.ar.h;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public class r {
    private static Handler yi = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable, long j) {
        yi.postDelayed(runnable, j);
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
            yi.post(runnable);
        }
    }
}
