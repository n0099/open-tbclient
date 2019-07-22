package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h BK = new h();
    private final ThreadPoolExecutor BJ = new ScheduledThreadPoolExecutor(1);

    public static h iL() {
        return BK;
    }

    public void c(Runnable runnable) {
        try {
            this.BJ.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void d(Runnable runnable) {
        if (this.BJ.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.BJ.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
