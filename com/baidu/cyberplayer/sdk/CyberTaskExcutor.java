package com.baidu.cyberplayer.sdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class CyberTaskExcutor {

    /* renamed from: a  reason: collision with root package name */
    public static CyberTaskExcutor f4809a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4810b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final int f4811c = 5;

    /* renamed from: d  reason: collision with root package name */
    public final int f4812d = 180;

    /* renamed from: e  reason: collision with root package name */
    public ExecutorService f4813e = new ThreadPoolExecutor(0, 5, 180, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("cyber-thread", 5));

    /* renamed from: f  reason: collision with root package name */
    public ExecutorService f4814f = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("cyber-thread-Single", 5));

    /* loaded from: classes.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f4815a = new AtomicInteger(1);

        /* renamed from: b  reason: collision with root package name */
        public final String f4816b;

        /* renamed from: c  reason: collision with root package name */
        public int f4817c;

        public a(String str, int i) {
            this.f4817c = 5;
            this.f4816b = str + "-";
            this.f4817c = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f4816b + this.f4815a.getAndIncrement());
            if (thread.isDaemon()) {
                thread.setDaemon(true);
            }
            thread.setPriority(this.f4817c);
            return thread;
        }
    }

    @Keep
    public static synchronized CyberTaskExcutor getInstance() {
        CyberTaskExcutor cyberTaskExcutor;
        synchronized (CyberTaskExcutor.class) {
            if (f4809a == null) {
                f4809a = new CyberTaskExcutor();
            }
            cyberTaskExcutor = f4809a;
        }
        return cyberTaskExcutor;
    }

    @Keep
    public void execute(Runnable runnable) {
        this.f4813e.execute(runnable);
    }

    @Keep
    public void executeSingleThread(Runnable runnable) {
        this.f4814f.execute(runnable);
    }
}
