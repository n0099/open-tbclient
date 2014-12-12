package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class l {
    private static l lF = new l();
    private final ThreadPoolExecutor lE = new ScheduledThreadPoolExecutor(1);

    public static l em() {
        return lF;
    }

    public void b(Runnable runnable) {
        try {
            this.lE.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void c(Runnable runnable) {
        if (this.lE.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.lE.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
