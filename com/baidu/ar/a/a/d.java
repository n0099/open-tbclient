package com.baidu.ar.a.a;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class d {
    private static d a;
    private ThreadPoolExecutor b = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new ArrayBlockingQueue(1), new a());
    private Queue<byte[]> c = new ArrayBlockingQueue(3);

    /* loaded from: classes3.dex */
    public static class a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (threadPoolExecutor.isShutdown()) {
                return;
            }
            Runnable poll = threadPoolExecutor.getQueue().poll();
            if (poll != null && (poll instanceof c)) {
                ((c) poll).a();
            }
            threadPoolExecutor.execute(runnable);
        }
    }

    private d(int i, int i2, int i3) {
        for (int i4 = 0; i4 < 3; i4++) {
            this.c.add(new byte[i3]);
        }
    }

    public static d a() {
        return a;
    }

    public static void a(int i, int i2, int i3) {
        a = new d(i, i2, i3);
    }

    public static void d() {
        a = null;
    }

    public void a(byte[] bArr) {
        this.c.add(bArr);
    }

    public boolean a(Runnable runnable) {
        if (this.b == null || this.b.isShutdown()) {
            return false;
        }
        try {
            this.b.execute(runnable);
            return true;
        } catch (Exception e) {
            com.baidu.ar.util.b.d("AlgoThreadPool execute runnable error");
            return false;
        }
    }

    public byte[] b() {
        return this.c.poll();
    }

    public void c() {
        if (this.b == null) {
            return;
        }
        try {
            this.c.clear();
            this.c = null;
            this.b.shutdownNow();
            this.b = null;
        } catch (Exception e) {
            com.baidu.ar.util.b.d("AlgoThreadPool destroy error");
        }
    }
}
