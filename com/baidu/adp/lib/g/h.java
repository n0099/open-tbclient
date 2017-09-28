package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h wf = new h();
    private final ThreadPoolExecutor we = new ScheduledThreadPoolExecutor(1);

    public static h fQ() {
        return wf;
    }

    public void c(Runnable runnable) {
        try {
            this.we.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void d(Runnable runnable) {
        if (this.we.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.we.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
