package com.baidu.sofire.i;

import android.os.Build;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes12.dex */
public class w {
    private static final int b = Runtime.getRuntime().availableProcessors();
    private static volatile w c;
    private ThreadPoolExecutor a;

    private w() {
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
            e.a();
        }
    }

    public static w a() {
        if (c == null) {
            try {
                synchronized (w.class) {
                    if (c == null) {
                        c = new w();
                    }
                }
            } catch (Throwable th) {
                e.a();
            }
        }
        return c;
    }
}
