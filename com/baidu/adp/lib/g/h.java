package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h wd = new h();
    private final ThreadPoolExecutor wc = new ScheduledThreadPoolExecutor(1);

    public static h fR() {
        return wd;
    }

    public void c(Runnable runnable) {
        try {
            this.wc.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void d(Runnable runnable) {
        if (this.wc.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.wc.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
