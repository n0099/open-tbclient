package com.baidu.nadcore.thread.task;

import android.os.SystemClock;
/* loaded from: classes3.dex */
public class ElasticTask implements Runnable {
    public Runnable a;
    public a b;
    public String c;
    public int d;
    public long e;
    public long f;
    public long g;
    public Status h = Status.WAITING;

    /* loaded from: classes3.dex */
    public enum Status {
        WAITING,
        RUNNING,
        COMPLETE
    }

    /* loaded from: classes3.dex */
    public interface a {
        void afterExecuteTask();

        void beforeExecuteTask();
    }

    public ElasticTask(Runnable runnable, String str, long j, int i) {
        this.a = runnable;
        this.c = str;
        this.d = i;
    }

    public String a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public synchronized long c() {
        long j;
        if (this.h == Status.WAITING) {
            return 0L;
        }
        if (this.h == Status.RUNNING) {
            j = SystemClock.elapsedRealtime();
        } else {
            j = this.g;
        }
        return Math.max(0L, j - this.f);
    }

    public synchronized long d() {
        long j;
        if (this.e == 0) {
            return 0L;
        }
        if (this.h == Status.WAITING) {
            j = SystemClock.elapsedRealtime();
        } else {
            j = this.f;
        }
        return Math.max(0L, j - this.e);
    }

    public synchronized void e() {
        this.h = Status.COMPLETE;
        this.g = SystemClock.elapsedRealtime();
    }

    public synchronized void f() {
        this.h = Status.WAITING;
        this.e = SystemClock.elapsedRealtime();
    }

    public synchronized void g() {
        this.h = Status.RUNNING;
        this.f = SystemClock.elapsedRealtime();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.b != null) {
                this.b.beforeExecuteTask();
            }
        } catch (Exception unused) {
        }
        this.a.run();
        try {
            if (this.b != null) {
                this.b.afterExecuteTask();
            }
        } catch (Exception unused2) {
        }
    }

    public void h(a aVar) {
        this.b = aVar;
    }
}
