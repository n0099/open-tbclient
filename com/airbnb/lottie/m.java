package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.util.Log;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/* loaded from: classes6.dex */
public class m<T> {
    public static Executor Cc = Executors.newCachedThreadPool();
    @Nullable
    private Thread Cd;
    private final Set<i<T>> Ce;
    private final Set<i<Throwable>> Cf;
    private final FutureTask<l<T>> Cg;
    @Nullable
    private volatile l<T> Ch;
    private final Handler handler;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public m(Callable<l<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    m(Callable<l<T>> callable, boolean z) {
        this.Ce = new LinkedHashSet(1);
        this.Cf = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.Ch = null;
        this.Cg = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new l<>(th));
                return;
            }
        }
        Cc.execute(this.Cg);
        iP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable l<T> lVar) {
        if (this.Ch != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.Ch = lVar;
        iO();
    }

    public synchronized m<T> a(i<T> iVar) {
        if (this.Ch != null && this.Ch.getValue() != null) {
            iVar.onResult(this.Ch.getValue());
        }
        this.Ce.add(iVar);
        iP();
        return this;
    }

    public synchronized m<T> b(i<T> iVar) {
        this.Ce.remove(iVar);
        iQ();
        return this;
    }

    public synchronized m<T> c(i<Throwable> iVar) {
        if (this.Ch != null && this.Ch.iN() != null) {
            iVar.onResult(this.Ch.iN());
        }
        this.Cf.add(iVar);
        iP();
        return this;
    }

    public synchronized m<T> d(i<Throwable> iVar) {
        this.Cf.remove(iVar);
        iQ();
        return this;
    }

    private void iO() {
        this.handler.post(new Runnable() { // from class: com.airbnb.lottie.m.1
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.Ch != null && !m.this.Cg.isCancelled()) {
                    l lVar = m.this.Ch;
                    if (lVar.getValue() != null) {
                        m.this.o(lVar.getValue());
                    } else {
                        m.this.f(lVar.iN());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(T t) {
        for (i iVar : new ArrayList(this.Ce)) {
            iVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Throwable th) {
        ArrayList<i> arrayList = new ArrayList(this.Cf);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (i iVar : arrayList) {
            iVar.onResult(th);
        }
    }

    private synchronized void iP() {
        if (!iR() && this.Ch == null) {
            this.Cd = new Thread("LottieTaskObserver") { // from class: com.airbnb.lottie.m.2
                private boolean Cj = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.Cj) {
                        if (m.this.Cg.isDone()) {
                            try {
                                m.this.a((l) m.this.Cg.get());
                            } catch (InterruptedException | ExecutionException e) {
                                m.this.a(new l(e));
                            }
                            this.Cj = true;
                            m.this.iQ();
                        }
                    }
                }
            };
            this.Cd.start();
            d.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void iQ() {
        if (iR() && (this.Ce.isEmpty() || this.Ch != null)) {
            this.Cd.interrupt();
            this.Cd = null;
            d.debug("Stopping TaskObserver thread");
        }
    }

    private boolean iR() {
        return this.Cd != null && this.Cd.isAlive();
    }
}
