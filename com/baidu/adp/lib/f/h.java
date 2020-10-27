package com.baidu.adp.lib.f;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h Np = new h();
    private final ThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);

    public static h mZ() {
        return Np;
    }

    public void submitTaskToSingleThread(Runnable runnable) {
        try {
            this.executor.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void submitTask(Runnable runnable) {
        if (this.executor.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.executor.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
