package com.baidu.adp.lib.h;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class k {
    private static k nf = new k();
    private final ThreadPoolExecutor ne = new ScheduledThreadPoolExecutor(1);

    public static k dM() {
        return nf;
    }

    public void e(Runnable runnable) {
        try {
            this.ne.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void f(Runnable runnable) {
        if (this.ne.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.ne.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
