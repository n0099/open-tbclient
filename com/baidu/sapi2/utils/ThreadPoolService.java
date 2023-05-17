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
/* loaded from: classes3.dex */
public class ThreadPoolService implements NoProguard {
    public static final int CORE_POOL_SIZE;
    public static final int CPU_COUNT;
    public static final int MSG_RUN_IN_CHILD_THREAD = 1;
    public static final int MSG_RUN_IN_UI_THREAD = 0;
    public static final ThreadFactory THREAD_FACTORY;
    public Handler mHandler;
    public ThreadPoolExecutor poolService;

    /* loaded from: classes3.dex */
    public static class SingletonContainer {
        public static ThreadPoolService mSingleInstance = new ThreadPoolService();
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        int i = 2;
        if (availableProcessors > 4) {
            i = availableProcessors / 2;
        }
        CORE_POOL_SIZE = i;
        THREAD_FACTORY = new ThreadFactory() { // from class: com.baidu.sapi2.utils.ThreadPoolService.1
            public final AtomicInteger count = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "pass_pool_thread # " + this.count.getAndIncrement());
            }
        };
    }

    public ThreadPoolService() {
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.utils.ThreadPoolService.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i != 0) {
                    if (i == 1) {
                        ThreadPoolService.this.poolService.submit(((TPRunnable) message.obj).runable);
                        return;
                    }
                    return;
                }
                ((TPRunnable) message.obj).run();
            }
        };
        int i = CORE_POOL_SIZE;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 60L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), THREAD_FACTORY);
        this.poolService = threadPoolExecutor;
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
    }

    public static ThreadPoolService getInstance() {
        return SingletonContainer.mSingleInstance;
    }

    public void run(TPRunnable tPRunnable) {
        this.poolService.submit(tPRunnable);
    }

    public void runInUiThread(TPRunnable tPRunnable) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, tPRunnable));
    }
}
