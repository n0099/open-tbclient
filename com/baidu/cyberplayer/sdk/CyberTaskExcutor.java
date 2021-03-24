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
    public static CyberTaskExcutor f4808a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4809b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final int f4810c = 5;

    /* renamed from: d  reason: collision with root package name */
    public final int f4811d = 180;

    /* renamed from: e  reason: collision with root package name */
    public ExecutorService f4812e = new ThreadPoolExecutor(0, 5, 180, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("cyber-thread", 5));

    /* renamed from: f  reason: collision with root package name */
    public ExecutorService f4813f = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("cyber-thread-Single", 5));

    /* loaded from: classes2.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f4814a = new AtomicInteger(1);

        /* renamed from: b  reason: collision with root package name */
        public final String f4815b;

        /* renamed from: c  reason: collision with root package name */
        public int f4816c;

        public a(String str, int i) {
            this.f4816c = 5;
            this.f4815b = str + "-";
            this.f4816c = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f4815b + this.f4814a.getAndIncrement());
            if (thread.isDaemon()) {
                thread.setDaemon(true);
            }
            thread.setPriority(this.f4816c);
            return thread;
        }
    }

    @Keep
    public static synchronized CyberTaskExcutor getInstance() {
        CyberTaskExcutor cyberTaskExcutor;
        synchronized (CyberTaskExcutor.class) {
            if (f4808a == null) {
                f4808a = new CyberTaskExcutor();
            }
            cyberTaskExcutor = f4808a;
        }
        return cyberTaskExcutor;
    }

    @Keep
    public void execute(Runnable runnable) {
        this.f4812e.execute(runnable);
    }

    @Keep
    public void executeSingleThread(Runnable runnable) {
        this.f4813f.execute(runnable);
    }
}
