package com.baidu.cyberplayer.sdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public final class CyberTaskExcutor {
    public final int a;
    public final int b;
    public final int c;
    public ExecutorService d;
    public ExecutorService e;
    public ExecutorService f;

    /* loaded from: classes3.dex */
    public static class a implements ThreadFactory {
        public final AtomicInteger a = new AtomicInteger(1);
        public final String b;
        public int c;

        public a(String str, int i) {
            this.c = 5;
            this.b = str + "-";
            this.c = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.b + this.a.getAndIncrement());
            if (thread.isDaemon()) {
                thread.setDaemon(true);
            }
            thread.setPriority(this.c);
            return thread;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static final CyberTaskExcutor a = new CyberTaskExcutor();
    }

    public CyberTaskExcutor() {
        this.a = 2;
        this.b = 7;
        this.c = 120;
        this.d = new ThreadPoolExecutor(2, 7, 120L, TimeUnit.SECONDS, new LinkedBlockingQueue(20), new a("cyber-thread", 5));
        this.e = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("cyber-thread-Single", 5));
        this.f = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("cyber-thread-Single-high", 5));
        ExecutorService executorService = this.d;
        if (executorService != null && (executorService instanceof ThreadPoolExecutor)) {
            ((ThreadPoolExecutor) executorService).allowCoreThreadTimeOut(true);
        }
    }

    @Keep
    public void execute(Runnable runnable) {
        this.d.execute(runnable);
    }

    @Keep
    public void executeSingleHighThread(Runnable runnable) {
        this.f.execute(runnable);
    }

    @Keep
    public void executeSingleThread(Runnable runnable) {
        this.e.execute(runnable);
    }

    @Keep
    public static CyberTaskExcutor getInstance() {
        return b.a;
    }
}
