package com.baidu.sofire.g;

import android.content.Context;
import android.os.Build;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class t {

    /* renamed from: b  reason: collision with root package name */
    public static volatile t f11296b;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f11297a;

    public t(Context context) {
        this.f11297a = null;
        int i2 = context != null ? new com.baidu.sofire.e(context).f11221a.getInt("s_t_p_c_s", 7) : 7;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f11297a = threadPoolExecutor;
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
    }

    public final void a(Runnable runnable) {
        try {
            this.f11297a.execute(runnable);
        } catch (Throwable unused) {
            d.a();
        }
    }

    public static t a(Context context) {
        if (f11296b == null) {
            try {
                synchronized (t.class) {
                    if (f11296b == null) {
                        f11296b = new t(context);
                    }
                }
            } catch (Throwable unused) {
                d.a();
            }
        }
        return f11296b;
    }
}
