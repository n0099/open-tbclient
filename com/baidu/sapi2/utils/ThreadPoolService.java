package com.baidu.sapi2.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.sapi2.NoProguard;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class ThreadPoolService implements NoProguard {

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadFactory f11018b = new a();

    /* renamed from: c  reason: collision with root package name */
    public static final int f11019c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final int f11020d = 1;

    /* renamed from: a  reason: collision with root package name */
    public Handler f11021a;
    public ThreadPoolExecutor poolService;

    /* loaded from: classes2.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f11022a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pass_pool_thread # " + this.f11022a.getAndIncrement());
        }
    }

    /* loaded from: classes2.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                ((TPRunnable) message.obj).run();
            } else if (i != 1) {
            } else {
                ThreadPoolService.this.poolService.submit(((TPRunnable) message.obj).runable);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static ThreadPoolService f11024a = new ThreadPoolService(null);
    }

    public /* synthetic */ ThreadPoolService(a aVar) {
        this();
    }

    public static ThreadPoolService getInstance() {
        return c.f11024a;
    }

    public void run(TPRunnable tPRunnable) {
        this.poolService.submit(tPRunnable);
    }

    public void runInUiThread(TPRunnable tPRunnable) {
        this.f11021a.sendMessage(this.f11021a.obtainMessage(0, tPRunnable));
    }

    public ThreadPoolService() {
        this.f11021a = new b(Looper.getMainLooper());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f11018b);
        this.poolService = threadPoolExecutor;
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
    }
}
