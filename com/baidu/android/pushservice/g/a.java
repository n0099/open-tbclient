package com.baidu.android.pushservice.g;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class a extends ThreadPoolExecutor {

    /* renamed from: com.baidu.android.pushservice.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    protected class C0048a<V> extends FutureTask<V> implements Comparable<C0048a<V>> {
        private Object b;

        public C0048a(Runnable runnable, V v) {
            super(runnable, v);
            this.b = runnable;
        }

        public C0048a(Callable<V> callable) {
            super(callable);
            this.b = callable;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C0048a<V> c0048a) {
            if (this == c0048a) {
                return 0;
            }
            if (c0048a == null) {
                return -1;
            }
            if (this.b == null || c0048a.b == null || !(this.b instanceof c) || !(c0048a.b instanceof c)) {
                return 0;
            }
            return ((c) c0048a.b).d() - ((c) this.b).d();
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
        return new C0048a(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C0048a(callable);
    }
}
