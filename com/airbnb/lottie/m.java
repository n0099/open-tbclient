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
    public static Executor fs = Executors.newCachedThreadPool();
    @Nullable
    private Thread ft;
    private final Set<i<T>> fu;
    private final Set<i<Throwable>> fv;
    private final FutureTask<l<T>> fw;
    @Nullable
    private volatile l<T> fz;
    private final Handler handler;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public m(Callable<l<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    m(Callable<l<T>> callable, boolean z) {
        this.fu = new LinkedHashSet(1);
        this.fv = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.fz = null;
        this.fw = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new l<>(th));
                return;
            }
        }
        fs.execute(this.fw);
        bA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable l<T> lVar) {
        if (this.fz != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.fz = lVar;
        bz();
    }

    public synchronized m<T> a(i<T> iVar) {
        if (this.fz != null && this.fz.getValue() != null) {
            iVar.onResult(this.fz.getValue());
        }
        this.fu.add(iVar);
        bA();
        return this;
    }

    public synchronized m<T> b(i<T> iVar) {
        this.fu.remove(iVar);
        bB();
        return this;
    }

    public synchronized m<T> c(i<Throwable> iVar) {
        if (this.fz != null && this.fz.by() != null) {
            iVar.onResult(this.fz.by());
        }
        this.fv.add(iVar);
        bA();
        return this;
    }

    public synchronized m<T> d(i<Throwable> iVar) {
        this.fv.remove(iVar);
        bB();
        return this;
    }

    private void bz() {
        this.handler.post(new Runnable() { // from class: com.airbnb.lottie.m.1
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.fz != null && !m.this.fw.isCancelled()) {
                    l lVar = m.this.fz;
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
        for (i iVar : new ArrayList(this.fu)) {
            iVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Throwable th) {
        ArrayList<i> arrayList = new ArrayList(this.fv);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (i iVar : arrayList) {
            iVar.onResult(th);
        }
    }

    private synchronized void bA() {
        if (!bC() && this.fz == null) {
            this.ft = new Thread("LottieTaskObserver") { // from class: com.airbnb.lottie.m.2
                private boolean fB = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.fB) {
                        if (m.this.fw.isDone()) {
                            try {
                                m.this.a((l) m.this.fw.get());
                            } catch (InterruptedException | ExecutionException e) {
                                m.this.a(new l(e));
                            }
                            this.fB = true;
                            m.this.bB();
                        }
                    }
                }
            };
            this.ft.start();
            d.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bB() {
        if (bC() && (this.fu.isEmpty() || this.fz != null)) {
            this.ft.interrupt();
            this.ft = null;
            d.debug("Stopping TaskObserver thread");
        }
    }

    private boolean bC() {
        return this.ft != null && this.ft.isAlive();
    }
}
