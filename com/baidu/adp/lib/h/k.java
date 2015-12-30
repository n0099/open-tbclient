package com.baidu.adp.lib.h;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class k {
    private static k wc = new k();
    private final ThreadPoolExecutor wb = new ScheduledThreadPoolExecutor(1);

    public static k hk() {
        return wc;
    }

    public void b(Runnable runnable) {
        try {
            this.wb.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void c(Runnable runnable) {
        if (this.wb.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.wb.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
