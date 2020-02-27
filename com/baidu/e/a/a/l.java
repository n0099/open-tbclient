package com.baidu.e.a.a;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes13.dex */
public class l {
    private static Handler sMainHandler;

    public static void runOnUiThread(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            getMainHandler().post(runnable);
        } else {
            runnable.run();
        }
    }

    private static Handler getMainHandler() {
        if (sMainHandler == null) {
            synchronized (l.class) {
                if (sMainHandler == null) {
                    sMainHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return sMainHandler;
    }
}
