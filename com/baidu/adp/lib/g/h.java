package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h Dk = new h();
    private final ThreadPoolExecutor Dj = new ScheduledThreadPoolExecutor(1);

    public static h ju() {
        return Dk;
    }

    public void c(Runnable runnable) {
        try {
            this.Dj.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void d(Runnable runnable) {
        if (this.Dj.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.Dj.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
