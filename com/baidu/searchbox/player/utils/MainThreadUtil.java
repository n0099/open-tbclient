package com.baidu.searchbox.player.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class MainThreadUtil {
    public static volatile Handler sMainHandler;

    public static Handler getMainHandler() {
        if (sMainHandler == null) {
            synchronized (MainThreadUtil.class) {
                if (sMainHandler == null) {
                    sMainHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return sMainHandler;
    }

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
}
