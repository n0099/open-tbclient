package com.baidu.ar.algo.b.a;

import android.util.Log;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class c {
    private static c a;
    private static final int b = Runtime.getRuntime().availableProcessors();
    private static final int c = Math.max(2, Math.min(b - 1, 4));
    private static final int d = (b * 2) + 1;
    private final ThreadFactory e = new ThreadFactory() { // from class: com.baidu.ar.algo.b.a.c.1
        private final AtomicInteger b = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.b.getAndIncrement());
        }
    };
    private final BlockingQueue<Runnable> f = new LinkedBlockingQueue(10);
    private ThreadPoolExecutor g = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new ArrayBlockingQueue(1), new a());
    private ThreadPoolExecutor h;
    private Queue<byte[]> i;
    private Queue<byte[]> j;

    /* loaded from: classes3.dex */
    public static class a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (threadPoolExecutor.isShutdown()) {
                return;
            }
            Runnable poll = threadPoolExecutor.getQueue().poll();
            if (poll != null && (poll instanceof b)) {
                ((b) poll).a();
            }
            threadPoolExecutor.execute(runnable);
        }
    }

    private c(int i, int i2, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(c, d, 10L, TimeUnit.SECONDS, this.f, this.e, new a());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.h = threadPoolExecutor;
        this.i = new ArrayBlockingQueue(3);
        for (int i4 = 0; i4 < 3; i4++) {
            this.i.add(new byte[i3]);
        }
        this.j = new ArrayBlockingQueue(3);
        for (int i5 = 0; i5 < 3; i5++) {
            this.j.add(new byte[i3]);
        }
    }

    public static c a() {
        return a;
    }

    public static void a(int i, int i2, int i3) {
        a = new c(i, i2, i3);
    }

    private boolean a(ThreadPoolExecutor threadPoolExecutor, Runnable runnable) {
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            return false;
        }
        try {
            threadPoolExecutor.execute(runnable);
            return true;
        } catch (Exception e) {
            Log.e("bdar: AlgoThreadPool", "AlgoThreadPool execute runnable error");
            return false;
        }
    }

    public static void c() {
        a = null;
    }

    public void a(ThreadPoolExecutor threadPoolExecutor, Queue<byte[]> queue) {
        if (threadPoolExecutor == null) {
            return;
        }
        try {
            queue.clear();
            threadPoolExecutor.shutdownNow();
        } catch (Exception e) {
            Log.e("bdar: AlgoThreadPool", "AlgoThreadPool destroy error");
            e.printStackTrace();
        }
    }

    public void a(byte[] bArr, int i) {
        try {
            if (i == 1) {
                this.j.add(bArr);
            } else {
                this.i.add(bArr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean a(Runnable runnable) {
        if (runnable instanceof b) {
            return a(((b) runnable).d() == 1 ? this.h : this.g, runnable);
        }
        return a(this.g, runnable);
    }

    public byte[] a(int i) {
        try {
            return i == 1 ? this.j.poll() : this.i.poll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void b() {
        a(this.g, this.i);
        a(this.h, this.j);
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
    }
}
