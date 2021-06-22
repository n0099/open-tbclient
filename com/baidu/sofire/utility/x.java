package com.baidu.sofire.utility;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.baidu.searchbox.track.ui.TrackUI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public static final int f10454a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile x f10455d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f10456e;

    /* renamed from: h  reason: collision with root package name */
    public static long f10457h;

    /* renamed from: b  reason: collision with root package name */
    public ThreadPoolExecutor f10458b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f10459c;

    /* renamed from: f  reason: collision with root package name */
    public BlockingQueue<Runnable> f10460f = new LinkedBlockingQueue(100);

    /* renamed from: g  reason: collision with root package name */
    public BlockingQueue<Runnable> f10461g = new LinkedBlockingQueue(10);

    /* renamed from: i  reason: collision with root package name */
    public Context f10462i;

    /* loaded from: classes2.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f10463a = new AtomicInteger(1);

        /* renamed from: b  reason: collision with root package name */
        public final String f10464b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10465c;

        public a(String str, int i2) {
            this.f10464b = str;
            this.f10465c = i2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f10464b + this.f10463a.getAndIncrement());
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.f10465c);
            return thread;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f10454a = availableProcessors;
        f10456e = (availableProcessors * 2) + 1;
        f10457h = 0L;
    }

    public x(Context context) {
        int i2;
        int max = (context == null || (i2 = com.baidu.sofire.h.a.a(context).f10321a.getInt("s_t_p_c_s", -1)) <= 0) ? Math.max(4, f10454a) : i2;
        this.f10458b = new ThreadPoolExecutor(max, Math.max(max, (f10454a * 2) + 1), 10L, TimeUnit.SECONDS, this.f10460f, new a("sofire_pool_thread_", 5), new ThreadPoolExecutor.AbortPolicy());
        this.f10459c = new ThreadPoolExecutor(2, f10456e, 10L, TimeUnit.SECONDS, this.f10461g, new a("sofire_pool_core_thread_", 6), new ThreadPoolExecutor.DiscardOldestPolicy());
        if (Build.VERSION.SDK_INT >= 9) {
            this.f10458b.allowCoreThreadTimeOut(true);
            this.f10459c.allowCoreThreadTimeOut(true);
        }
    }

    public final int a(Runnable runnable) {
        try {
            if (this.f10458b != null) {
                this.f10458b.execute(runnable);
                return 1;
            }
            return -2;
        } catch (RejectedExecutionException e2) {
            try {
                if (this.f10462i != null && System.currentTimeMillis() - f10457h >= 86400000) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", Integer.valueOf(f10454a));
                    hashMap.put("1", Integer.valueOf(this.f10458b.getCorePoolSize()));
                    hashMap.put("2", Integer.valueOf(this.f10458b.getMaximumPoolSize()));
                    hashMap.put("3", Base64.encodeToString(com.baidu.sofire.b.a(e2).getBytes(), 0).replace("\n", "").replace(TrackUI.SEPERATOR, "").replace("\r", ""));
                    c.a(this.f10462i.getApplicationContext(), "1003147", (Map<String, Object>) hashMap, true);
                    f10457h = System.currentTimeMillis();
                }
            } catch (Throwable unused) {
                c.a();
            }
            c.a();
            return -1;
        } catch (Throwable unused2) {
            c.a();
            return -3;
        }
    }

    public final int b(Runnable runnable) {
        if (runnable != null) {
            try {
                if (this.f10459c != null) {
                    this.f10459c.execute(runnable);
                    return 1;
                }
                return -2;
            } catch (Throwable unused) {
                c.a();
                return -3;
            }
        }
        return -2;
    }

    public static x a(Context context) {
        if (f10455d == null) {
            try {
                synchronized (x.class) {
                    if (f10455d == null) {
                        f10455d = new x(context);
                    }
                }
            } catch (Throwable unused) {
                c.a();
            }
        }
        if (f10455d != null && f10455d.f10462i == null && context != null) {
            f10455d.f10462i = context;
        }
        return f10455d;
    }
}
