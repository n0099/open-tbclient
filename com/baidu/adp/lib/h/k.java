package com.baidu.adp.lib.h;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class k {
    private static k pB = new k();
    private final ThreadPoolExecutor pA = new ScheduledThreadPoolExecutor(1);

    public static k eH() {
        return pB;
    }

    public void e(Runnable runnable) {
        try {
            this.pA.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void f(Runnable runnable) {
        if (this.pA.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.pA.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
