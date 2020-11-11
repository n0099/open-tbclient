package com.baidu.pano.platform.a.a;

import com.baidu.pano.platform.a.q;
import com.baidu.pano.platform.a.v;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes7.dex */
public class l<T> implements q.a, q.b<T>, Future<T> {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.pano.platform.a.n<?> f2646a;
    private boolean b = false;
    private T c;
    private v d;

    public static <E> l<E> a() {
        return new l<>();
    }

    private l() {
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (this.f2646a != null && !isDone()) {
                this.f2646a.g();
                z2 = true;
            }
        }
        return z2;
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        try {
            return a((Long) null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    private synchronized T a(Long l) throws InterruptedException, ExecutionException, TimeoutException {
        T t;
        if (this.d != null) {
            throw new ExecutionException(this.d);
        }
        if (this.b) {
            t = this.c;
        } else {
            if (l == null) {
                wait(0L);
            } else if (l.longValue() > 0) {
                wait(l.longValue());
            }
            if (this.d != null) {
                throw new ExecutionException(this.d);
            }
            if (!this.b) {
                throw new TimeoutException();
            }
            t = this.c;
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        if (this.f2646a == null) {
            return false;
        }
        return this.f2646a.h();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.b && this.d == null) {
            z = isCancelled();
        }
        return z;
    }

    @Override // com.baidu.pano.platform.a.q.b
    public synchronized void a(T t) {
        this.b = true;
        this.c = t;
        notifyAll();
    }

    @Override // com.baidu.pano.platform.a.q.a
    public synchronized void a(v vVar) {
        this.d = vVar;
        notifyAll();
    }
}
