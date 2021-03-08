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
/* loaded from: classes6.dex */
public class ThreadPoolService {

    /* renamed from: a  reason: collision with root package name */
    private static final int f2769a = Runtime.getRuntime().availableProcessors();
    private static final ThreadFactory b = new ThreadFactory() { // from class: com.baidu.pass.biometrics.base.utils.thread.ThreadPoolService.1

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f2770a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pass_face_thread # " + this.f2770a.getAndIncrement());
        }
    };
    private static final int c = 0;
    private static final int d = 1;
    private ThreadPoolExecutor e;
    private Handler f;

    /* loaded from: classes6.dex */
    private static class SingletonContainer {
        public static ThreadPoolService mSingleInstance = new ThreadPoolService();

        private SingletonContainer() {
        }
    }

    public static ThreadPoolService getInstance() {
        return SingletonContainer.mSingleInstance;
    }

    public void run(TPRunnable tPRunnable) {
        this.e.submit(tPRunnable);
    }

    public void runInUiThread(TPRunnable tPRunnable) {
        this.f.sendMessage(this.f.obtainMessage(0, tPRunnable));
    }

    private ThreadPoolService() {
        this.f = new Handler(Looper.getMainLooper()) { // from class: com.baidu.pass.biometrics.base.utils.thread.ThreadPoolService.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    ((TPRunnable) message.obj).run();
                } else if (i == 1) {
                    ThreadPoolService.this.e.submit(((TPRunnable) message.obj).runable);
                }
            }
        };
        this.e = new ThreadPoolExecutor(Math.max(2, Math.min(f2769a - 1, 4)), Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), b);
        if (Build.VERSION.SDK_INT >= 9) {
            this.e.allowCoreThreadTimeOut(true);
        }
    }
}
