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
/* loaded from: classes3.dex */
public class ThreadPoolService {
    public static final int c = Runtime.getRuntime().availableProcessors();
    public static final ThreadFactory d = new ThreadFactory() { // from class: com.baidu.pass.biometrics.base.utils.thread.ThreadPoolService.1
        public final AtomicInteger a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pass_face_thread # " + this.a.getAndIncrement());
        }
    };
    public static final int e = 0;
    public static final int f = 1;
    public ThreadPoolExecutor a;
    public Handler b;

    /* loaded from: classes3.dex */
    public static class SingletonContainer {
        public static ThreadPoolService mSingleInstance = new ThreadPoolService();
    }

    public static ThreadPoolService getInstance() {
        return SingletonContainer.mSingleInstance;
    }

    public ThreadPoolService() {
        this.b = new Handler(Looper.getMainLooper()) { // from class: com.baidu.pass.biometrics.base.utils.thread.ThreadPoolService.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i != 0) {
                    if (i == 1) {
                        ThreadPoolService.this.a.submit(((TPRunnable) message.obj).runable);
                        return;
                    }
                    return;
                }
                ((TPRunnable) message.obj).run();
            }
        };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Math.max(2, Math.min(c - 1, 4)), Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), d);
        this.a = threadPoolExecutor;
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
    }

    public void run(TPRunnable tPRunnable) {
        this.a.submit(tPRunnable);
    }

    public void runInUiThread(TPRunnable tPRunnable) {
        this.b.sendMessage(this.b.obtainMessage(0, tPRunnable));
    }
}
