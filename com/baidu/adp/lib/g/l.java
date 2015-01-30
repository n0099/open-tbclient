package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class l {
    private static l lI = new l();
    private final ThreadPoolExecutor lH = new ScheduledThreadPoolExecutor(1);

    public static l ek() {
        return lI;
    }

    public void b(Runnable runnable) {
        try {
            this.lH.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void c(Runnable runnable) {
        if (this.lH.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.lH.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
