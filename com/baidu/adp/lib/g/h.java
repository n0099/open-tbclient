package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class h {
    private static h BE = new h();
    private final ThreadPoolExecutor BD = new ScheduledThreadPoolExecutor(1);

    public static h iC() {
        return BE;
    }

    public void c(Runnable runnable) {
        try {
            this.BD.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void d(Runnable runnable) {
        if (this.BD.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.BD.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
