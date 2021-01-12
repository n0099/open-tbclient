package com.baidu.cyberplayer.sdk;

import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public final class CyberTaskExcutor {

    /* renamed from: a  reason: collision with root package name */
    private static CyberTaskExcutor f1706a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1707b = 0;
    private final int c = 5;
    private final int d = 180;
    private ExecutorService e = new ThreadPoolExecutor(0, 5, 180, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("cyber-thread", 5));
    private ExecutorService f = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("cyber-thread-Single", 5));

    /* loaded from: classes5.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f1708a = new AtomicInteger(1);

        /* renamed from: b  reason: collision with root package name */
        private final String f1709b;
        private int c;

        a(String str, int i) {
            this.c = 5;
            this.f1709b = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            this.c = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f1709b + this.f1708a.getAndIncrement());
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
            if (f1706a == null) {
                f1706a = new CyberTaskExcutor();
            }
            cyberTaskExcutor = f1706a;
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
