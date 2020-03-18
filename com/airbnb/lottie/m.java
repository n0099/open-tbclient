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
    public static Executor fq = Executors.newCachedThreadPool();
    @Nullable
    private Thread fs;
    private final Set<i<T>> ft;
    private final Set<i<Throwable>> fu;
    private final FutureTask<l<T>> fv;
    @Nullable
    private volatile l<T> fw;
    private final Handler handler;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public m(Callable<l<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    m(Callable<l<T>> callable, boolean z) {
        this.ft = new LinkedHashSet(1);
        this.fu = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.fw = null;
        this.fv = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new l<>(th));
                return;
            }
        }
        fq.execute(this.fv);
        bA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable l<T> lVar) {
        if (this.fw != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.fw = lVar;
        bz();
    }

    public synchronized m<T> a(i<T> iVar) {
        if (this.fw != null && this.fw.getValue() != null) {
            iVar.onResult(this.fw.getValue());
        }
        this.ft.add(iVar);
        bA();
        return this;
    }

    public synchronized m<T> b(i<T> iVar) {
        this.ft.remove(iVar);
        bB();
        return this;
    }

    public synchronized m<T> c(i<Throwable> iVar) {
        if (this.fw != null && this.fw.by() != null) {
            iVar.onResult(this.fw.by());
        }
        this.fu.add(iVar);
        bA();
        return this;
    }

    public synchronized m<T> d(i<Throwable> iVar) {
        this.fu.remove(iVar);
        bB();
        return this;
    }

    private void bz() {
        this.handler.post(new Runnable() { // from class: com.airbnb.lottie.m.1
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.fw != null && !m.this.fv.isCancelled()) {
                    l lVar = m.this.fw;
                    if (lVar.getValue() != null) {
                        m.this.m(lVar.getValue());
                    } else {
                        m.this.g(lVar.by());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(T t) {
        for (i iVar : new ArrayList(this.ft)) {
            iVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Throwable th) {
        ArrayList<i> arrayList = new ArrayList(this.fu);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (i iVar : arrayList) {
            iVar.onResult(th);
        }
    }

    private synchronized void bA() {
        if (!bC() && this.fw == null) {
            this.fs = new Thread("LottieTaskObserver") { // from class: com.airbnb.lottie.m.2
                private boolean fA = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.fA) {
                        if (m.this.fv.isDone()) {
                            try {
                                m.this.a((l) m.this.fv.get());
                            } catch (InterruptedException | ExecutionException e) {
                                m.this.a(new l(e));
                            }
                            this.fA = true;
                            m.this.bB();
                        }
                    }
                }
            };
            this.fs.start();
            d.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bB() {
        if (bC() && (this.ft.isEmpty() || this.fw != null)) {
            this.fs.interrupt();
            this.fs = null;
            d.debug("Stopping TaskObserver thread");
        }
    }

    private boolean bC() {
        return this.fs != null && this.fs.isAlive();
    }
}
