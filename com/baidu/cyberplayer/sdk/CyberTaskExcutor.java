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
    public static CyberTaskExcutor f4816a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4817b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final int f4818c = 5;

    /* renamed from: d  reason: collision with root package name */
    public final int f4819d = 180;

    /* renamed from: e  reason: collision with root package name */
    public ExecutorService f4820e = new ThreadPoolExecutor(0, 5, 180, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("cyber-thread", 5));

    /* renamed from: f  reason: collision with root package name */
    public ExecutorService f4821f = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("cyber-thread-Single", 5));

    /* loaded from: classes2.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f4822a = new AtomicInteger(1);

        /* renamed from: b  reason: collision with root package name */
        public final String f4823b;

        /* renamed from: c  reason: collision with root package name */
        public int f4824c;

        public a(String str, int i2) {
            this.f4824c = 5;
            this.f4823b = str + "-";
            this.f4824c = i2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f4823b + this.f4822a.getAndIncrement());
            if (thread.isDaemon()) {
                thread.setDaemon(true);
            }
            thread.setPriority(this.f4824c);
            return thread;
        }
    }

    @Keep
    public static synchronized CyberTaskExcutor getInstance() {
        CyberTaskExcutor cyberTaskExcutor;
        synchronized (CyberTaskExcutor.class) {
            if (f4816a == null) {
                f4816a = new CyberTaskExcutor();
            }
            cyberTaskExcutor = f4816a;
        }
        return cyberTaskExcutor;
    }

    @Keep
    public void execute(Runnable runnable) {
        this.f4820e.execute(runnable);
    }

    @Keep
    public void executeSingleThread(Runnable runnable) {
        this.f4821f.execute(runnable);
    }
}
