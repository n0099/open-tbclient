package com.baidu.ar.f;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public class p {
    private static Handler wu = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable, long j) {
        wu.postDelayed(runnable, j);
    }

    public static boolean fi() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void runOnUiThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (fi()) {
            runnable.run();
        } else {
            wu.post(runnable);
        }
    }
}
