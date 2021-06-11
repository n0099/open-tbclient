package com.alipay.android.phone.mrpc.core;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public final class m extends FutureTask<u> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f1654a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f1655b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(l lVar, Callable callable, q qVar) {
        super(callable);
        this.f1655b = lVar;
        this.f1654a = qVar;
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        o a2 = this.f1654a.a();
        if (a2.f() == null) {
            super.done();
            return;
        }
        try {
            get();
            if (isCancelled() || a2.h()) {
                a2.g();
                if (isCancelled() && isDone()) {
                    return;
                }
                cancel(false);
            }
        } catch (InterruptedException e2) {
            new StringBuilder().append(e2);
        } catch (CancellationException unused) {
            a2.g();
        } catch (ExecutionException e3) {
            if (e3.getCause() == null || !(e3.getCause() instanceof HttpException)) {
                new StringBuilder().append(e3);
                return;
            }
            HttpException httpException = (HttpException) e3.getCause();
            httpException.getCode();
            httpException.getMsg();
        } catch (Throwable th) {
            throw new RuntimeException("An error occured while executing http request", th);
        }
    }
}
