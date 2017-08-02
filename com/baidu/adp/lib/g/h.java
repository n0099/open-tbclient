package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h wK = new h();
    private final ThreadPoolExecutor wJ = new ScheduledThreadPoolExecutor(1);

    public static h fQ() {
        return wK;
    }

    public void e(Runnable runnable) {
        try {
            this.wJ.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void f(Runnable runnable) {
        if (this.wJ.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.wJ.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
