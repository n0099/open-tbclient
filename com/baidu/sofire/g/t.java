package com.baidu.sofire.g;

import android.content.Context;
import android.os.Build;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class t {

    /* renamed from: b  reason: collision with root package name */
    public static volatile t f10363b;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f10364a;

    public t(Context context) {
        this.f10364a = null;
        int i2 = context != null ? new com.baidu.sofire.e(context).f10288a.getInt("s_t_p_c_s", 7) : 7;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f10364a = threadPoolExecutor;
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
    }

    public final void a(Runnable runnable) {
        try {
            this.f10364a.execute(runnable);
        } catch (Throwable unused) {
            d.a();
        }
    }

    public static t a(Context context) {
        if (f10363b == null) {
            try {
                synchronized (t.class) {
                    if (f10363b == null) {
                        f10363b = new t(context);
                    }
                }
            } catch (Throwable unused) {
                d.a();
            }
        }
        return f10363b;
    }
}
