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
    public static CyberTaskExcutor f4716a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4717b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final int f4718c = 5;

    /* renamed from: d  reason: collision with root package name */
    public final int f4719d = 180;

    /* renamed from: e  reason: collision with root package name */
    public ExecutorService f4720e = new ThreadPoolExecutor(0, 5, 180, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("cyber-thread", 5));

    /* renamed from: f  reason: collision with root package name */
    public ExecutorService f4721f = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("cyber-thread-Single", 5));

    /* loaded from: classes2.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f4722a = new AtomicInteger(1);

        /* renamed from: b  reason: collision with root package name */
        public final String f4723b;

        /* renamed from: c  reason: collision with root package name */
        public int f4724c;

        public a(String str, int i2) {
            this.f4724c = 5;
            this.f4723b = str + "-";
            this.f4724c = i2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f4723b + this.f4722a.getAndIncrement());
            if (thread.isDaemon()) {
                thread.setDaemon(true);
            }
            thread.setPriority(this.f4724c);
            return thread;
        }
    }

    @Keep
    public static synchronized CyberTaskExcutor getInstance() {
        CyberTaskExcutor cyberTaskExcutor;
        synchronized (CyberTaskExcutor.class) {
            if (f4716a == null) {
                f4716a = new CyberTaskExcutor();
            }
            cyberTaskExcutor = f4716a;
        }
        return cyberTaskExcutor;
    }

    @Keep
    public void execute(Runnable runnable) {
        this.f4720e.execute(runnable);
    }

    @Keep
    public void executeSingleThread(Runnable runnable) {
        this.f4721f.execute(runnable);
    }
}
