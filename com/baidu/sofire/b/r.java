package com.baidu.sofire.b;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class r {
    private static final int b = Runtime.getRuntime().availableProcessors();
    private static volatile r c;
    private ThreadPoolExecutor a;

    private r() {
        this.a = null;
        int i = b >= 1 ? b : 1;
        com.baidu.sofire.b.a("Thread Pool core " + b);
        this.a = new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                this.a.execute(runnable);
            } catch (Throwable th) {
                e.a(th);
            }
        }
    }

    public static r a() {
        if (c == null) {
            try {
                synchronized (r.class) {
                    if (c == null) {
                        c = new r();
                    }
                }
            } catch (Throwable th) {
                e.a(th);
            }
        }
        return c;
    }
}
