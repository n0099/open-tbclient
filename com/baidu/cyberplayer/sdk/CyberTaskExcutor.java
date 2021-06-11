package com.baidu.cyberplayer.sdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class CyberTaskExcutor {

    /* renamed from: a  reason: collision with root package name */
    public static CyberTaskExcutor f4737a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4738b = 2;

    /* renamed from: c  reason: collision with root package name */
    public final int f4739c = 7;

    /* renamed from: d  reason: collision with root package name */
    public final int f4740d = 120;

    /* renamed from: e  reason: collision with root package name */
    public ExecutorService f4741e = new ThreadPoolExecutor(2, 7, 120, TimeUnit.SECONDS, new LinkedBlockingQueue(20), new a("cyber-thread", 5));

    /* renamed from: f  reason: collision with root package name */
    public ExecutorService f4742f = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("cyber-thread-Single", 5));

    /* loaded from: classes2.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f4743a = new AtomicInteger(1);

        /* renamed from: b  reason: collision with root package name */
        public final String f4744b;

        /* renamed from: c  reason: collision with root package name */
        public int f4745c;

        public a(String str, int i2) {
            this.f4745c = 5;
            this.f4744b = str + "-";
            this.f4745c = i2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f4744b + this.f4743a.getAndIncrement());
            if (thread.isDaemon()) {
                thread.setDaemon(true);
            }
            thread.setPriority(this.f4745c);
            return thread;
        }
    }

    public CyberTaskExcutor() {
        ExecutorService executorService = this.f4741e;
        if (executorService == null || !(executorService instanceof ThreadPoolExecutor)) {
            return;
        }
        ((ThreadPoolExecutor) executorService).allowCoreThreadTimeOut(true);
    }

    @Keep
    public static synchronized CyberTaskExcutor getInstance() {
        CyberTaskExcutor cyberTaskExcutor;
        synchronized (CyberTaskExcutor.class) {
            if (f4737a == null) {
                f4737a = new CyberTaskExcutor();
            }
            cyberTaskExcutor = f4737a;
        }
        return cyberTaskExcutor;
    }

    @Keep
    public void execute(Runnable runnable) {
        this.f4741e.execute(runnable);
    }

    @Keep
    public void executeSingleThread(Runnable runnable) {
        this.f4742f.execute(runnable);
    }
}
