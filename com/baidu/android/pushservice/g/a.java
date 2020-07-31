package com.baidu.android.pushservice.g;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class a extends ThreadPoolExecutor {

    /* renamed from: com.baidu.android.pushservice.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    protected class C0049a<V> extends FutureTask<V> implements Comparable<C0049a<V>> {
        private Object b;

        public C0049a(Runnable runnable, V v) {
            super(runnable, v);
            this.b = runnable;
        }

        public C0049a(Callable<V> callable) {
            super(callable);
            this.b = callable;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C0049a<V> c0049a) {
            if (this == c0049a) {
                return 0;
            }
            if (c0049a == null) {
                return -1;
            }
            if (this.b == null || c0049a.b == null || !(this.b instanceof c) || !(c0049a.b instanceof c)) {
                return 0;
            }
            return ((c) c0049a.b).d() - ((c) this.b).d();
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
        return new C0049a(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C0049a(callable);
    }
}
