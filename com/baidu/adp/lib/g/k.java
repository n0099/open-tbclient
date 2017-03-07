package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class k {
    private static k xb = new k();
    private final ThreadPoolExecutor xa = new ScheduledThreadPoolExecutor(1);

    public static k fN() {
        return xb;
    }

    public void e(Runnable runnable) {
        try {
            this.xa.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void f(Runnable runnable) {
        if (this.xa.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.xa.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
