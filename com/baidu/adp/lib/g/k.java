package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class k {
    private static k vT = new k();
    private final ThreadPoolExecutor vS = new ScheduledThreadPoolExecutor(1);

    public static k hg() {
        return vT;
    }

    public void b(Runnable runnable) {
        try {
            this.vS.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void c(Runnable runnable) {
        if (this.vS.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.vS.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
