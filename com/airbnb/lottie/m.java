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
/* loaded from: classes5.dex */
public class m<T> {
    public static Executor fk = Executors.newCachedThreadPool();
    @Nullable
    private Thread fn;
    private final Set<i<T>> fo;
    private final Set<i<Throwable>> fq;
    private final FutureTask<l<T>> fs;
    @Nullable
    private volatile l<T> ft;
    private final Handler handler;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public m(Callable<l<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    m(Callable<l<T>> callable, boolean z) {
        this.fo = new LinkedHashSet(1);
        this.fq = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.ft = null;
        this.fs = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new l<>(th));
                return;
            }
        }
        fk.execute(this.fs);
        bz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable l<T> lVar) {
        if (this.ft != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.ft = lVar;
        by();
    }

    public synchronized m<T> a(i<T> iVar) {
        if (this.ft != null && this.ft.getValue() != null) {
            iVar.onResult(this.ft.getValue());
        }
        this.fo.add(iVar);
        bz();
        return this;
    }

    public synchronized m<T> b(i<T> iVar) {
        this.fo.remove(iVar);
        bA();
        return this;
    }

    public synchronized m<T> c(i<Throwable> iVar) {
        if (this.ft != null && this.ft.bx() != null) {
            iVar.onResult(this.ft.bx());
        }
        this.fq.add(iVar);
        bz();
        return this;
    }

    public synchronized m<T> d(i<Throwable> iVar) {
        this.fq.remove(iVar);
        bA();
        return this;
    }

    private void by() {
        this.handler.post(new Runnable() { // from class: com.airbnb.lottie.m.1
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.ft != null && !m.this.fs.isCancelled()) {
                    l lVar = m.this.ft;
                    if (lVar.getValue() != null) {
                        m.this.m(lVar.getValue());
                    } else {
                        m.this.h(lVar.bx());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(T t) {
        for (i iVar : new ArrayList(this.fo)) {
            iVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Throwable th) {
        ArrayList<i> arrayList = new ArrayList(this.fq);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (i iVar : arrayList) {
            iVar.onResult(th);
        }
    }

    private synchronized void bz() {
        if (!bB() && this.ft == null) {
            this.fn = new Thread("LottieTaskObserver") { // from class: com.airbnb.lottie.m.2
                private boolean fv = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.fv) {
                        if (m.this.fs.isDone()) {
                            try {
                                m.this.a((l) m.this.fs.get());
                            } catch (InterruptedException | ExecutionException e) {
                                m.this.a(new l(e));
                            }
                            this.fv = true;
                            m.this.bA();
                        }
                    }
                }
            };
            this.fn.start();
            d.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bA() {
        if (bB() && (this.fo.isEmpty() || this.ft != null)) {
            this.fn.interrupt();
            this.fn = null;
            d.debug("Stopping TaskObserver thread");
        }
    }

    private boolean bB() {
        return this.fn != null && this.fn.isAlive();
    }
}
