package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h we = new h();
    private final ThreadPoolExecutor wd = new ScheduledThreadPoolExecutor(1);

    public static h fQ() {
        return we;
    }

    public void c(Runnable runnable) {
        try {
            this.wd.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void d(Runnable runnable) {
        if (this.wd.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.wd.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
