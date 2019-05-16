package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h BF = new h();
    private final ThreadPoolExecutor BE = new ScheduledThreadPoolExecutor(1);

    public static h iC() {
        return BF;
    }

    public void c(Runnable runnable) {
        try {
            this.BE.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void d(Runnable runnable) {
        if (this.BE.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.BE.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
