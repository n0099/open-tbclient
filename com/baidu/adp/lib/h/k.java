package com.baidu.adp.lib.h;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class k {
    private static k pC = new k();
    private final ThreadPoolExecutor pB = new ScheduledThreadPoolExecutor(1);

    public static k eH() {
        return pC;
    }

    public void e(Runnable runnable) {
        try {
            this.pB.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void f(Runnable runnable) {
        if (this.pB.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.pB.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
