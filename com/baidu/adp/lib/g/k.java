package com.baidu.adp.lib.g;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class k {
    private static k lE = new k();
    private final ThreadPoolExecutor lD = new ScheduledThreadPoolExecutor(1);

    public static k el() {
        return lE;
    }

    public void a(Runnable runnable) {
        try {
            this.lD.submit(runnable);
        } catch (Throwable th) {
        }
    }

    public void b(Runnable runnable) {
        if (this.lD.getTaskCount() >= 1) {
            new Thread(runnable).start();
            return;
        }
        try {
            this.lD.submit(runnable);
        } catch (Throwable th) {
        }
    }
}
