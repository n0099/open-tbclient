package com.baidu.android.util.concurrent;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes8.dex */
public class UiThreadUtil {
    private static volatile Handler sMainHandler;

    public static boolean isOnUiThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            getMainHandler().post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void runOnUiThread(Runnable runnable, long j) {
        if (j > 0) {
            getMainHandler().postDelayed(runnable, j);
        } else {
            runOnUiThread(runnable);
        }
    }

    public static void runOnUiThreadAtFrontOfQueue(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            getMainHandler().postAtFrontOfQueue(runnable);
        } else {
            runnable.run();
        }
    }

    public static Handler getMainHandler() {
        if (sMainHandler == null) {
            synchronized (UiThreadUtil.class) {
                if (sMainHandler == null) {
                    sMainHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return sMainHandler;
    }
}
