package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class k {
    private static k wI = new k();
    private final ThreadPoolExecutor wH = new ScheduledThreadPoolExecutor(1);

    public static k fT() {
        return wI;
    }

    public void e(Runnable runnable) {
        try {
            this.wH.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void f(Runnable runnable) {
        if (this.wH.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.wH.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
