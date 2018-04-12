package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h uQ = new h();
    private final ThreadPoolExecutor uP = new ScheduledThreadPoolExecutor(1);

    public static h fx() {
        return uQ;
    }

    public void c(Runnable runnable) {
        try {
            this.uP.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void d(Runnable runnable) {
        if (this.uP.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.uP.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
