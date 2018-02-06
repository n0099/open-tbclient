package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h aks = new h();
    private final ThreadPoolExecutor akr = new ScheduledThreadPoolExecutor(1);

    public static h nt() {
        return aks;
    }

    public void d(Runnable runnable) {
        try {
            this.akr.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void e(Runnable runnable) {
        if (this.akr.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.akr.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
