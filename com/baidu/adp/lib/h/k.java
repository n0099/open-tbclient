package com.baidu.adp.lib.h;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class k {
    private static k wm = new k();
    private final ThreadPoolExecutor wl = new ScheduledThreadPoolExecutor(1);

    public static k hs() {
        return wm;
    }

    public void b(Runnable runnable) {
        try {
            this.wl.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void c(Runnable runnable) {
        if (this.wl.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.wl.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
