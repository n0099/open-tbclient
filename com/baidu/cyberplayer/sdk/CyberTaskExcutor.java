package com.baidu.cyberplayer.sdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public final class CyberTaskExcutor {
    public static CyberTaskExcutor a;
    public final int b = 2;
    public final int c = 7;
    public final int d = 120;
    public ExecutorService e = new ThreadPoolExecutor(2, 7, 120, TimeUnit.SECONDS, new LinkedBlockingQueue(20), new a("cyber-thread", 5));
    public ExecutorService f = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("cyber-thread-Single", 5));

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

    public CyberTaskExcutor() {
        ExecutorService executorService = this.e;
        if (executorService == null || !(executorService instanceof ThreadPoolExecutor)) {
            return;
        }
        ((ThreadPoolExecutor) executorService).allowCoreThreadTimeOut(true);
    }

    @Keep
    public static synchronized CyberTaskExcutor getInstance() {
        CyberTaskExcutor cyberTaskExcutor;
        synchronized (CyberTaskExcutor.class) {
            if (a == null) {
                a = new CyberTaskExcutor();
            }
            cyberTaskExcutor = a;
        }
        return cyberTaskExcutor;
    }

    @Keep
    public void execute(Runnable runnable) {
        this.e.execute(runnable);
    }

    @Keep
    public void executeSingleThread(Runnable runnable) {
        this.f.execute(runnable);
    }
}
