package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h akq = new h();
    private final ThreadPoolExecutor akp = new ScheduledThreadPoolExecutor(1);

    public static h ns() {
        return akq;
    }

    public void d(Runnable runnable) {
        try {
            this.akp.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void e(Runnable runnable) {
        if (this.akp.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.akp.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
