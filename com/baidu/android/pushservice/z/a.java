package com.baidu.android.pushservice.z;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class a extends ThreadPoolExecutor {

    /* renamed from: com.baidu.android.pushservice.z.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0046a<V> extends FutureTask<V> implements Comparable<C0046a<V>> {
        public Object a;

        public C0046a(a aVar, Runnable runnable, V v) {
            super(runnable, v);
            this.a = runnable;
        }

        public C0046a(a aVar, Callable<V> callable) {
            super(callable);
            this.a = callable;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C0046a<V> c0046a) {
            Object obj;
            if (this == c0046a) {
                return 0;
            }
            if (c0046a == null) {
                return -1;
            }
            Object obj2 = this.a;
            if (obj2 == null || (obj = c0046a.a) == null || !(obj2 instanceof c) || !(obj instanceof c)) {
                return 0;
            }
            return ((c) obj).b() - ((c) this.a).b();
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
                getQueue().offer(runnable);
                runnable = getQueue().poll();
            }
        }
        super.execute(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new C0046a(this, runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C0046a(this, callable);
    }
}
