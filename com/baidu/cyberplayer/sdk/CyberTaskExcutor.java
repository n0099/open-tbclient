package com.baidu.cyberplayer.sdk;

import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes17.dex */
public final class CyberTaskExcutor {

    /* renamed from: a  reason: collision with root package name */
    private static CyberTaskExcutor f1347a;
    private final int b = 0;
    private final int c = 5;
    private final int d = 180;
    private ExecutorService e = new ThreadPoolExecutor(0, 5, 180, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("cyber-thread", 5));
    private ExecutorService f = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("cyber-thread-Single", 5));

    /* loaded from: classes17.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f1348a = new AtomicInteger(1);
        private final String b;
        private int c;

        a(String str, int i) {
            this.c = 5;
            this.b = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            this.c = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.b + this.f1348a.getAndIncrement());
            if (thread.isDaemon()) {
                thread.setDaemon(true);
            }
            thread.setPriority(this.c);
            return thread;
        }
    }

    private CyberTaskExcutor() {
    }

    @Keep
    public static synchronized CyberTaskExcutor getInstance() {
        CyberTaskExcutor cyberTaskExcutor;
        synchronized (CyberTaskExcutor.class) {
            if (f1347a == null) {
                f1347a = new CyberTaskExcutor();
            }
            cyberTaskExcutor = f1347a;
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
