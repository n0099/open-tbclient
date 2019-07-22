package com.baidu.sofire.b;

import android.os.Build;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class r {
    private static final int b = Runtime.getRuntime().availableProcessors();
    private static volatile r c;
    private ThreadPoolExecutor a;

    private r() {
        this.a = null;
        int i = b <= 0 ? 1 : b;
        this.a = new ThreadPoolExecutor(i, i, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        if (Build.VERSION.SDK_INT >= 9) {
            this.a.allowCoreThreadTimeOut(true);
        }
    }

    public final void a(Runnable runnable) {
        try {
            this.a.execute(runnable);
        } catch (Throwable th) {
            e.a();
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
                e.a();
            }
        }
        return c;
    }
}
