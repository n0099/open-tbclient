package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class k {
    private static k vU = new k();
    private final ThreadPoolExecutor vT = new ScheduledThreadPoolExecutor(1);

    public static k hi() {
        return vU;
    }

    public void b(Runnable runnable) {
        try {
            this.vT.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void c(Runnable runnable) {
        if (this.vT.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.vT.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
