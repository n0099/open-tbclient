package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h akm = new h();
    private final ThreadPoolExecutor akl = new ScheduledThreadPoolExecutor(1);

    public static h nt() {
        return akm;
    }

    public void d(Runnable runnable) {
        try {
            this.akl.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void e(Runnable runnable) {
        if (this.akl.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.akl.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
