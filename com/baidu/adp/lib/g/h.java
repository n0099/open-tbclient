package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h AP = new h();
    private final ThreadPoolExecutor AO = new ScheduledThreadPoolExecutor(1);

    public static h io() {
        return AP;
    }

    public void c(Runnable runnable) {
        try {
            this.AO.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void d(Runnable runnable) {
        if (this.AO.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.AO.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
