package com.baidu.android.pushservice.h;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class a extends ThreadPoolExecutor {

    /* renamed from: com.baidu.android.pushservice.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    protected class C0044a<V> extends FutureTask<V> implements Comparable<C0044a<V>> {
        private Object b;

        public C0044a(Runnable runnable, V v) {
            super(runnable, v);
            this.b = runnable;
        }

        public C0044a(Callable<V> callable) {
            super(callable);
            this.b = callable;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C0044a<V> c0044a) {
            if (this == c0044a) {
                return 0;
            }
            if (c0044a == null) {
                return -1;
            }
            if (this.b == null || c0044a.b == null || !(this.b instanceof c) || !(c0044a.b instanceof c)) {
                return 0;
            }
            return ((c) c0044a.b).d() - ((c) this.b).d();
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
        return new C0044a(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C0044a(callable);
    }
}
