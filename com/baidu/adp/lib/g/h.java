package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h wg = new h();
    private final ThreadPoolExecutor wf = new ScheduledThreadPoolExecutor(1);

    public static h fQ() {
        return wg;
    }

    public void c(Runnable runnable) {
        try {
            this.wf.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void d(Runnable runnable) {
        if (this.wf.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.wf.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
