package com.baidu.sofire.i;

import android.os.Build;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class u {
    private static final int b = Runtime.getRuntime().availableProcessors();
    private static volatile u c;
    private ThreadPoolExecutor a;

    private u() {
        this.a = null;
        int max = Math.max(7, (b * 2) + 3);
        this.a = new ThreadPoolExecutor(max, max, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        if (Build.VERSION.SDK_INT >= 9) {
            this.a.allowCoreThreadTimeOut(true);
        }
    }

    public final void a(Runnable runnable) {
        try {
            this.a.execute(runnable);
        } catch (Throwable th) {
            d.a();
        }
    }

    public static u a() {
        if (c == null) {
            try {
                synchronized (u.class) {
                    if (c == null) {
                        c = new u();
                    }
                }
            } catch (Throwable th) {
                d.a();
            }
        }
        return c;
    }
}
