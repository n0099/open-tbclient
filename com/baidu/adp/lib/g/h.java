package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h yl = new h();
    private final ThreadPoolExecutor yk = new ScheduledThreadPoolExecutor(1);

    public static h gb() {
        return yl;
    }

    public void e(Runnable runnable) {
        try {
            this.yk.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void f(Runnable runnable) {
        if (this.yk.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.yk.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
