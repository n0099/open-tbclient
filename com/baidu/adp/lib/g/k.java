package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class k {
    private static k wE = new k();
    private final ThreadPoolExecutor wD = new ScheduledThreadPoolExecutor(1);

    public static k fS() {
        return wE;
    }

    public void e(Runnable runnable) {
        try {
            this.wD.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void f(Runnable runnable) {
        if (this.wD.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.wD.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
