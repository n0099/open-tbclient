package com.baidu.sapi2.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.ActivityChooserView;
import com.baidu.sapi2.NoProguard;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes25.dex */
public class ThreadPoolService implements NoProguard {
    private static final ThreadFactory b = new a();
    private static final int c = 0;
    private static final int d = 1;
    private Handler a;
    public ThreadPoolExecutor poolService;

    /* loaded from: classes25.dex */
    static class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pass_pool_thread # " + this.a.getAndIncrement());
        }
    }

    /* loaded from: classes25.dex */
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

    /* loaded from: classes25.dex */
    private static class c {
        static ThreadPoolService a = new ThreadPoolService(null);

        private c() {
        }
    }

    /* synthetic */ ThreadPoolService(a aVar) {
        this();
    }

    public static ThreadPoolService getInstance() {
        return c.a;
    }

    public void run(TPRunnable tPRunnable) {
        this.poolService.submit(tPRunnable);
    }

    public void runInUiThread(TPRunnable tPRunnable) {
        this.a.sendMessage(this.a.obtainMessage(0, tPRunnable));
    }

    private ThreadPoolService() {
        this.a = new b(Looper.getMainLooper());
        this.poolService = new ThreadPoolExecutor(6, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), b);
        if (Build.VERSION.SDK_INT >= 9) {
            this.poolService.allowCoreThreadTimeOut(true);
        }
    }
}
