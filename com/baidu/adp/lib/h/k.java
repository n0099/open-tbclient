package com.baidu.adp.lib.h;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class k {
    private static k wD = new k();
    private final ThreadPoolExecutor wC = new ScheduledThreadPoolExecutor(1);

    public static k hy() {
        return wD;
    }

    public void b(Runnable runnable) {
        try {
            this.wC.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void c(Runnable runnable) {
        if (this.wC.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.wC.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
