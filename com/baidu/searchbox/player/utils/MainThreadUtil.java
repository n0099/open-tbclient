package com.baidu.searchbox.player.utils;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
/* loaded from: classes15.dex */
public class MainThreadUtil {
    private static volatile Handler sMainHandler;

    public static void runOnUiThread(@NonNull Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            getMainHandler().post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void runOnUiThread(@NonNull Runnable runnable, long j) {
        if (j > 0) {
            getMainHandler().postDelayed(runnable, j);
        } else {
            runOnUiThread(runnable);
        }
    }

    private static Handler getMainHandler() {
        if (sMainHandler == null) {
            synchronized (MainThreadUtil.class) {
                if (sMainHandler == null) {
                    sMainHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return sMainHandler;
    }
}
