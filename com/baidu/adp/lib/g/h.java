package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h uP = new h();
    private final ThreadPoolExecutor uO = new ScheduledThreadPoolExecutor(1);

    public static h fx() {
        return uP;
    }

    public void c(Runnable runnable) {
        try {
            this.uO.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void d(Runnable runnable) {
        if (this.uO.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.uO.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
