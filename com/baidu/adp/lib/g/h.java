package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h akt = new h();
    private final ThreadPoolExecutor aks = new ScheduledThreadPoolExecutor(1);

    public static h nt() {
        return akt;
    }

    public void d(Runnable runnable) {
        try {
            this.aks.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void e(Runnable runnable) {
        if (this.aks.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.aks.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
