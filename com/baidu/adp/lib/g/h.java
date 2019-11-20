package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h pJ = new h();
    private final ThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);

    public static h ga() {
        return pJ;
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
