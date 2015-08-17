package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class k {
    private static k vV = new k();
    private final ThreadPoolExecutor vU = new ScheduledThreadPoolExecutor(1);

    public static k hj() {
        return vV;
    }

    public void b(Runnable runnable) {
        try {
            this.vU.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void c(Runnable runnable) {
        if (this.vU.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.vU.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
