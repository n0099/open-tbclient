package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h DW = new h();
    private final ThreadPoolExecutor DV = new ScheduledThreadPoolExecutor(1);

    public static h jI() {
        return DW;
    }

    public void c(Runnable runnable) {
        try {
            this.DV.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void d(Runnable runnable) {
        if (this.DV.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.DV.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
