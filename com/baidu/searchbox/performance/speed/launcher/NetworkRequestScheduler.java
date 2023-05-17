package com.baidu.searchbox.performance.speed.launcher;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public class NetworkRequestScheduler {
    public static synchronized void execute(Runnable runnable, String str, long j, boolean z) {
        synchronized (NetworkRequestScheduler.class) {
            new Handler(Looper.getMainLooper()).postDelayed(runnable, j);
        }
    }
}
