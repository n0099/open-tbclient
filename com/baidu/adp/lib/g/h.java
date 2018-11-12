package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h DX = new h();
    private final ThreadPoolExecutor DW = new ScheduledThreadPoolExecutor(1);

    public static h jH() {
        return DX;
    }

    public void c(Runnable runnable) {
        try {
            this.DW.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void d(Runnable runnable) {
        if (this.DW.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.DW.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
