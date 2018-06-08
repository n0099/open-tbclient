package com.baidu.ar.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public class UiThreadUtil {
    private static Handler a = new Handler(Looper.getMainLooper());

    public static boolean isOnUiThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void postDelayed(Runnable runnable, long j) {
        a.postDelayed(runnable, j);
    }

    public static void removeCallbacks(Runnable runnable) {
        a.removeCallbacks(runnable);
    }

    public static void removeCallbacksAndMessages() {
        a.removeCallbacksAndMessages(null);
    }

    public static void runOnUiThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (isOnUiThread()) {
            runnable.run();
        } else {
            a.post(runnable);
        }
    }
}
