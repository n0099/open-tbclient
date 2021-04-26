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
    public com.baidu.pano.platform.a.n<?> f9228a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f9229b = false;

    /* renamed from: c  reason: collision with root package name */
    public T f9230c;

    /* renamed from: d  reason: collision with root package name */
    public v f9231d;

    public static <E> l<E> a() {
        return new l<>();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        if (this.f9228a == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.f9228a.g();
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
        com.baidu.pano.platform.a.n<?> nVar = this.f9228a;
        if (nVar == null) {
            return false;
        }
        return nVar.h();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.f9229b && this.f9231d == null) {
            z = isCancelled();
        }
        return z;
    }

    private synchronized T a(Long l) throws InterruptedException, ExecutionException, TimeoutException {
        if (this.f9231d == null) {
            if (this.f9229b) {
                return this.f9230c;
            }
            if (l == null) {
                wait(0L);
            } else if (l.longValue() > 0) {
                wait(l.longValue());
            }
            if (this.f9231d == null) {
                if (this.f9229b) {
                    return this.f9230c;
                }
                throw new TimeoutException();
            }
            throw new ExecutionException(this.f9231d);
        }
        throw new ExecutionException(this.f9231d);
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    @Override // com.baidu.pano.platform.a.q.b
    public synchronized void a(T t) {
        this.f9229b = true;
        this.f9230c = t;
        notifyAll();
    }

    @Override // com.baidu.pano.platform.a.q.a
    public synchronized void a(v vVar) {
        this.f9231d = vVar;
        notifyAll();
    }
}
