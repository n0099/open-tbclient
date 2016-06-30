package com.baidu.adp.lib.h;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class k {
    private static k my = new k();
    private final ThreadPoolExecutor mx = new ScheduledThreadPoolExecutor(1);

    public static k dN() {
        return my;
    }

    public void b(Runnable runnable) {
        try {
            this.mx.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void c(Runnable runnable) {
        if (this.mx.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.mx.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
