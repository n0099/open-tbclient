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

    /* renamed from: c  reason: collision with root package name */
    public static final int f9069c = Runtime.getRuntime().availableProcessors();

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadFactory f9070d = new ThreadFactory() { // from class: com.baidu.pass.biometrics.base.utils.thread.ThreadPoolService.1

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f9075a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pass_face_thread # " + this.f9075a.getAndIncrement());
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static final int f9071e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static final int f9072f = 1;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f9073a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f9074b;

    /* loaded from: classes2.dex */
    public static class SingletonContainer {
        public static ThreadPoolService mSingleInstance = new ThreadPoolService();
    }

    public static ThreadPoolService getInstance() {
        return SingletonContainer.mSingleInstance;
    }

    public void run(TPRunnable tPRunnable) {
        this.f9073a.submit(tPRunnable);
    }

    public void runInUiThread(TPRunnable tPRunnable) {
        this.f9074b.sendMessage(this.f9074b.obtainMessage(0, tPRunnable));
    }

    public ThreadPoolService() {
        this.f9074b = new Handler(Looper.getMainLooper()) { // from class: com.baidu.pass.biometrics.base.utils.thread.ThreadPoolService.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 0) {
                    ((TPRunnable) message.obj).run();
                } else if (i2 != 1) {
                } else {
                    ThreadPoolService.this.f9073a.submit(((TPRunnable) message.obj).runable);
                }
            }
        };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Math.max(2, Math.min(f9069c - 1, 4)), Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f9070d);
        this.f9073a = threadPoolExecutor;
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
    }
}
