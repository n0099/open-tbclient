package com.baidu.adp.lib.h;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class k {
    private static k wa = new k();
    private final ThreadPoolExecutor vZ = new ScheduledThreadPoolExecutor(1);

    public static k hk() {
        return wa;
    }

    public void b(Runnable runnable) {
        try {
            this.vZ.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void c(Runnable runnable) {
        if (this.vZ.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.vZ.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
