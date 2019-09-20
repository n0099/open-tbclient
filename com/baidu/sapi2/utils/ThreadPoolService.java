package com.baidu.sapi2.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ThreadPoolService {
    private static final ThreadFactory a = new ThreadFactory() { // from class: com.baidu.sapi2.utils.ThreadPoolService.1
        private final AtomicInteger a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pass_pool_thread # " + this.a.getAndIncrement());
        }
    };
    private static final int b = 0;
    private static final int c = 1;
    private Handler d;
    public ThreadPoolExecutor poolService;

    /* loaded from: classes.dex */
    private static class SingletonContainer {
        static ThreadPoolService a = new ThreadPoolService();

        private SingletonContainer() {
        }
    }

    public static ThreadPoolService getInstance() {
        return SingletonContainer.a;
    }

    private ThreadPoolService() {
        this.d = new Handler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.utils.ThreadPoolService.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        ((TPRunnable) message.obj).run();
                        return;
                    case 1:
                        ThreadPoolService.this.poolService.submit(((TPRunnable) message.obj).runable);
                        return;
                    default:
                        return;
                }
            }
        };
        this.poolService = new ThreadPoolExecutor(6, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), a);
        if (Build.VERSION.SDK_INT >= 9) {
            this.poolService.allowCoreThreadTimeOut(true);
        }
    }

    public void run(TPRunnable tPRunnable) {
        this.poolService.submit(tPRunnable);
    }

    public void runInUiThread(TPRunnable tPRunnable) {
        this.d.sendMessage(this.d.obtainMessage(0, tPRunnable));
    }
}
