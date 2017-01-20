package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class k {
    private static k pw = new k();
    private final ThreadPoolExecutor pv = new ScheduledThreadPoolExecutor(1);

    public static k eF() {
        return pw;
    }

    public void e(Runnable runnable) {
        try {
            this.pv.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void f(Runnable runnable) {
        if (this.pv.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.pv.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
