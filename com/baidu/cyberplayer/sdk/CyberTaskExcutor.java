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
    public static CyberTaskExcutor f4962a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4963b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final int f4964c = 5;

    /* renamed from: d  reason: collision with root package name */
    public final int f4965d = 180;

    /* renamed from: e  reason: collision with root package name */
    public ExecutorService f4966e = new ThreadPoolExecutor(0, 5, 180, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("cyber-thread", 5));

    /* renamed from: f  reason: collision with root package name */
    public ExecutorService f4967f = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("cyber-thread-Single", 5));

    /* loaded from: classes2.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f4968a = new AtomicInteger(1);

        /* renamed from: b  reason: collision with root package name */
        public final String f4969b;

        /* renamed from: c  reason: collision with root package name */
        public int f4970c;

        public a(String str, int i2) {
            this.f4970c = 5;
            this.f4969b = str + "-";
            this.f4970c = i2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f4969b + this.f4968a.getAndIncrement());
            if (thread.isDaemon()) {
                thread.setDaemon(true);
            }
            thread.setPriority(this.f4970c);
            return thread;
        }
    }

    @Keep
    public static synchronized CyberTaskExcutor getInstance() {
        CyberTaskExcutor cyberTaskExcutor;
        synchronized (CyberTaskExcutor.class) {
            if (f4962a == null) {
                f4962a = new CyberTaskExcutor();
            }
            cyberTaskExcutor = f4962a;
        }
        return cyberTaskExcutor;
    }

    @Keep
    public void execute(Runnable runnable) {
        this.f4966e.execute(runnable);
    }

    @Keep
    public void executeSingleThread(Runnable runnable) {
        this.f4967f.execute(runnable);
    }
}
