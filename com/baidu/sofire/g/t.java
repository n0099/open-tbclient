package com.baidu.sofire.g;

import android.content.Context;
import android.os.Build;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class t {

    /* renamed from: b  reason: collision with root package name */
    public static volatile t f11463b;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f11464a;

    public t(Context context) {
        this.f11464a = null;
        int i = context != null ? new com.baidu.sofire.e(context).f11390a.getInt("s_t_p_c_s", 7) : 7;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f11464a = threadPoolExecutor;
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
    }

    public final void a(Runnable runnable) {
        try {
            this.f11464a.execute(runnable);
        } catch (Throwable unused) {
            d.a();
        }
    }

    public static t a(Context context) {
        if (f11463b == null) {
            try {
                synchronized (t.class) {
                    if (f11463b == null) {
                        f11463b = new t(context);
                    }
                }
            } catch (Throwable unused) {
                d.a();
            }
        }
        return f11463b;
    }
}
