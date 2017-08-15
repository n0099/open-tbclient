package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h yn = new h();
    private final ThreadPoolExecutor ym = new ScheduledThreadPoolExecutor(1);

    public static h gb() {
        return yn;
    }

    public void e(Runnable runnable) {
        try {
            this.ym.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void f(Runnable runnable) {
        if (this.ym.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.ym.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
