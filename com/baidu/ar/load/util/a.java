package com.baidu.ar.load.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class a {
    private static final int a = Runtime.getRuntime().availableProcessors();
    private static final int b = a * 2;
    private static final int c = (a * 4) + 1;
    private static final BlockingQueue<Runnable> d = new LinkedBlockingQueue(128);
    private static ThreadPoolExecutor e = null;
    private static ThreadPoolExecutor f = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.ar.load.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class ThreadFactoryC0037a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);
        private int b;

        public ThreadFactoryC0037a(int i) {
            this.b = 5;
            this.b = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "ARThreadPool " + this.b + "#" + this.a.getAndIncrement());
            thread.setPriority(this.b);
            return thread;
        }
    }

    public static ThreadPoolExecutor a() {
        if (e == null) {
            synchronized (a.class) {
                e = c();
            }
        }
        return e;
    }

    public static ThreadPoolExecutor b() {
        if (f == null) {
            synchronized (a.class) {
                f = new ThreadPoolExecutor(5, 5, 15L, TimeUnit.SECONDS, d, new ThreadFactoryC0037a(5), new ThreadPoolExecutor.DiscardOldestPolicy());
            }
        }
        return f;
    }

    private static ThreadPoolExecutor c() {
        e = new ThreadPoolExecutor(b, c, 15L, TimeUnit.SECONDS, d, new ThreadFactoryC0037a(5), new ThreadPoolExecutor.DiscardOldestPolicy());
        return e;
    }
}
