package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class l {
    private static l wW = new l();
    private final ThreadPoolExecutor wV = new ScheduledThreadPoolExecutor(1);

    public static l hJ() {
        return wW;
    }

    public void b(Runnable runnable) {
        try {
            this.wV.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void c(Runnable runnable) {
        if (this.wV.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.wV.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
