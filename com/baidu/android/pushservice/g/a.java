package com.baidu.android.pushservice.g;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class a extends ThreadPoolExecutor {

    /* renamed from: com.baidu.android.pushservice.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    protected class C0041a<V> extends FutureTask<V> implements Comparable<C0041a<V>> {

        /* renamed from: b  reason: collision with root package name */
        private Object f1305b;

        public C0041a(Runnable runnable, V v) {
            super(runnable, v);
            this.f1305b = runnable;
        }

        public C0041a(Callable<V> callable) {
            super(callable);
            this.f1305b = callable;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C0041a<V> c0041a) {
            if (this == c0041a) {
                return 0;
            }
            if (c0041a == null) {
                return -1;
            }
            if (this.f1305b == null || c0041a.f1305b == null || !(this.f1305b instanceof c) || !(c0041a.f1305b instanceof c)) {
                return 0;
            }
            return ((c) c0041a.f1305b).d() - ((c) this.f1305b).d();
        }
    }

    public a(int i, int i2, long j, TimeUnit timeUnit, b<Runnable> bVar) {
        super(i, i2, j, timeUnit, bVar);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (getQueue().size() >= 19) {
            if (getPoolSize() >= getMaximumPoolSize()) {
                getQueue().clear();
            } else {
                Runnable poll = getQueue().poll();
                getQueue().offer(runnable);
                runnable = poll;
            }
        }
        super.execute(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new C0041a(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C0041a(callable);
    }
}
