package com.baidu.cyberplayer.sdk;

import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class CyberTaskExcutor {
    private static CyberTaskExcutor a;
    private final int b = 0;
    private final int c = 5;
    private final int d = 180;
    private ExecutorService e = new ThreadPoolExecutor(0, 5, 180, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("cyberplayer-thread", 5));

    /* loaded from: classes.dex */
    public static class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);
        private final String b;
        private int c;

        a(String str, int i) {
            this.c = 5;
            this.b = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
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

    private CyberTaskExcutor() {
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
}
