package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class k {
    private static k wJ = new k();
    private final ThreadPoolExecutor wI = new ScheduledThreadPoolExecutor(1);

    public static k fT() {
        return wJ;
    }

    public void e(Runnable runnable) {
        try {
            this.wI.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void f(Runnable runnable) {
        if (this.wI.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.wI.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
