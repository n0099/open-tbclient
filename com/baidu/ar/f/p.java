package com.baidu.ar.f;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes11.dex */
public class p {
    private static Handler wU = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable, long j) {
        wU.postDelayed(runnable, j);
    }

    public static boolean fy() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void runOnUiThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (fy()) {
            runnable.run();
        } else {
            wU.post(runnable);
        }
    }
}
