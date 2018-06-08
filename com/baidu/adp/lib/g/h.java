package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h AU = new h();
    private final ThreadPoolExecutor AT = new ScheduledThreadPoolExecutor(1);

    public static h in() {
        return AU;
    }

    public void c(Runnable runnable) {
        try {
            this.AT.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void d(Runnable runnable) {
        if (this.AT.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.AT.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
