package com.baidu.sofire.b;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class t {
    private static final int b = Runtime.getRuntime().availableProcessors();
    private static volatile t c;
    public ThreadPoolExecutor a;

    private t() {
        this.a = null;
        int i = b <= 0 ? 1 : b;
        new StringBuilder("Thread Pool core ").append(b);
        this.a = new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static t a() {
        if (c == null) {
            try {
                synchronized (t.class) {
                    if (c == null) {
                        c = new t();
                    }
                }
            } catch (Throwable th) {
                e.a(th);
            }
        }
        return c;
    }
}
