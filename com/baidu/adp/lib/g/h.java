package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h AO = new h();
    private final ThreadPoolExecutor AN = new ScheduledThreadPoolExecutor(1);

    public static h io() {
        return AO;
    }

    public void c(Runnable runnable) {
        try {
            this.AN.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void d(Runnable runnable) {
        if (this.AN.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.AN.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
