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
    public static final int f9148c = Runtime.getRuntime().availableProcessors();

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadFactory f9149d = new ThreadFactory() { // from class: com.baidu.pass.biometrics.base.utils.thread.ThreadPoolService.1

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f9154a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pass_face_thread # " + this.f9154a.getAndIncrement());
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static final int f9150e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static final int f9151f = 1;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f9152a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f9153b;

    /* loaded from: classes2.dex */
    public static class SingletonContainer {
        public static ThreadPoolService mSingleInstance = new ThreadPoolService();
    }

    public static ThreadPoolService getInstance() {
        return SingletonContainer.mSingleInstance;
    }

    public void run(TPRunnable tPRunnable) {
        this.f9152a.submit(tPRunnable);
    }

    public void runInUiThread(TPRunnable tPRunnable) {
        this.f9153b.sendMessage(this.f9153b.obtainMessage(0, tPRunnable));
    }

    public ThreadPoolService() {
        this.f9153b = new Handler(Looper.getMainLooper()) { // from class: com.baidu.pass.biometrics.base.utils.thread.ThreadPoolService.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    ((TPRunnable) message.obj).run();
                } else if (i != 1) {
                } else {
                    ThreadPoolService.this.f9152a.submit(((TPRunnable) message.obj).runable);
                }
            }
        };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Math.max(2, Math.min(f9148c - 1, 4)), Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f9149d);
        this.f9152a = threadPoolExecutor;
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
    }
}
