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
/* loaded from: classes15.dex */
public class ThreadPoolService implements NoProguard {

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadFactory f5093b = new a();
    private static final int c = 0;
    private static final int d = 1;

    /* renamed from: a  reason: collision with root package name */
    private Handler f5094a;
    public ThreadPoolExecutor poolService;

    /* loaded from: classes15.dex */
    static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f5095a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pass_pool_thread # " + this.f5095a.getAndIncrement());
        }
    }

    /* loaded from: classes15.dex */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                ((TPRunnable) message.obj).run();
            } else if (i == 1) {
                ThreadPoolService.this.poolService.submit(((TPRunnable) message.obj).runable);
            }
        }
    }

    /* loaded from: classes15.dex */
    private static class c {

        /* renamed from: a  reason: collision with root package name */
        static ThreadPoolService f5097a = new ThreadPoolService(null);

        private c() {
        }
    }

    /* synthetic */ ThreadPoolService(a aVar) {
        this();
    }

    public static ThreadPoolService getInstance() {
        return c.f5097a;
    }

    public void run(TPRunnable tPRunnable) {
        this.poolService.submit(tPRunnable);
    }

    public void runInUiThread(TPRunnable tPRunnable) {
        this.f5094a.sendMessage(this.f5094a.obtainMessage(0, tPRunnable));
    }

    private ThreadPoolService() {
        this.f5094a = new b(Looper.getMainLooper());
        this.poolService = new ThreadPoolExecutor(6, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f5093b);
        if (Build.VERSION.SDK_INT >= 9) {
            this.poolService.allowCoreThreadTimeOut(true);
        }
    }
}
