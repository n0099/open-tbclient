package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h DT = new h();
    private final ThreadPoolExecutor DS = new ScheduledThreadPoolExecutor(1);

    public static h jJ() {
        return DT;
    }

    public void c(Runnable runnable) {
        try {
            this.DS.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void d(Runnable runnable) {
        if (this.DS.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.DS.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
