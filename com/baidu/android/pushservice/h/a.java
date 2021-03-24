package com.baidu.android.pushservice.h;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class a extends ThreadPoolExecutor {

    /* renamed from: com.baidu.android.pushservice.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0035a<V> extends FutureTask<V> implements Comparable<C0035a<V>> {

        /* renamed from: b  reason: collision with root package name */
        public Object f3073b;

        public C0035a(Runnable runnable, V v) {
            super(runnable, v);
            this.f3073b = runnable;
        }

        public C0035a(Callable<V> callable) {
            super(callable);
            this.f3073b = callable;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C0035a<V> c0035a) {
            Object obj;
            if (this == c0035a) {
                return 0;
            }
            if (c0035a == null) {
                return -1;
            }
            Object obj2 = this.f3073b;
            if (obj2 == null || (obj = c0035a.f3073b) == null || !(obj2 instanceof c) || !(obj instanceof c)) {
                return 0;
            }
            return ((c) obj).d() - ((c) this.f3073b).d();
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
        return new C0035a(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C0035a(callable);
    }
}
