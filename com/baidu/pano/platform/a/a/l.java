package com.baidu.pano.platform.a.a;

import com.baidu.pano.platform.a.q;
import com.baidu.pano.platform.a.v;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes2.dex */
public class l<T> implements q.a, q.b<T>, Future<T> {

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.pano.platform.a.n<?> f8900a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8901b = false;

    /* renamed from: c  reason: collision with root package name */
    public T f8902c;

    /* renamed from: d  reason: collision with root package name */
    public v f8903d;

    public static <E> l<E> a() {
        return new l<>();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        if (this.f8900a == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.f8900a.g();
        return true;
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        try {
            return a((Long) null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        com.baidu.pano.platform.a.n<?> nVar = this.f8900a;
        if (nVar == null) {
            return false;
        }
        return nVar.h();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.f8901b && this.f8903d == null) {
            z = isCancelled();
        }
        return z;
    }

    private synchronized T a(Long l) throws InterruptedException, ExecutionException, TimeoutException {
        if (this.f8903d == null) {
            if (this.f8901b) {
                return this.f8902c;
            }
            if (l == null) {
                wait(0L);
            } else if (l.longValue() > 0) {
                wait(l.longValue());
            }
            if (this.f8903d == null) {
                if (this.f8901b) {
                    return this.f8902c;
                }
                throw new TimeoutException();
            }
            throw new ExecutionException(this.f8903d);
        }
        throw new ExecutionException(this.f8903d);
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    @Override // com.baidu.pano.platform.a.q.b
    public synchronized void a(T t) {
        this.f8901b = true;
        this.f8902c = t;
        notifyAll();
    }

    @Override // com.baidu.pano.platform.a.q.a
    public synchronized void a(v vVar) {
        this.f8903d = vVar;
        notifyAll();
    }
}
