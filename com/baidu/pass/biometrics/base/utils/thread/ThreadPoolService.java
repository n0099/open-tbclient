package com.baidu.pass.biometrics.base.utils.thread;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class ThreadPoolService {
    private static final int MSG_RUN_IN_CHILD_THREAD = 1;
    private static final int MSG_RUN_IN_UI_THREAD = 0;
    private Handler mHandler;
    private ThreadPoolExecutor poolService;
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final ThreadFactory THREAD_FACTORY = new ThreadFactory() { // from class: com.baidu.pass.biometrics.base.utils.thread.ThreadPoolService.1
        private final AtomicInteger count = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pass_face_thread # " + this.count.getAndIncrement());
        }
    };

    /* loaded from: classes2.dex */
    private static class SingletonContainer {
        public static ThreadPoolService mSingleInstance = new ThreadPoolService();

        private SingletonContainer() {
        }
    }

    public static ThreadPoolService getInstance() {
        return SingletonContainer.mSingleInstance;
    }

    private ThreadPoolService() {
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.pass.biometrics.base.utils.thread.ThreadPoolService.2
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
        this.poolService = new ThreadPoolExecutor(Math.max(2, Math.min(CPU_COUNT - 1, 4)), Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), THREAD_FACTORY);
        if (Build.VERSION.SDK_INT >= 9) {
            this.poolService.allowCoreThreadTimeOut(true);
        }
    }

    public void run(TPRunnable tPRunnable) {
        this.poolService.submit(tPRunnable);
    }

    public void runInUiThread(TPRunnable tPRunnable) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, tPRunnable));
    }
}
