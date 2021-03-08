package com.baidu.live.lottie;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/* loaded from: classes9.dex */
public class n<T> {
    public static Executor Ey = Executors.newCachedThreadPool();
    private final Set<j<T>> EA;
    private final Set<j<Throwable>> EB;
    private final FutureTask<m<T>> EC;
    @Nullable
    private Thread Ez;
    @Nullable
    private volatile m<T> btM;
    private final Handler handler;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public n(Callable<m<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    n(Callable<m<T>> callable, boolean z) {
        this.EA = new LinkedHashSet(1);
        this.EB = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.btM = null;
        this.EC = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new m<>(th));
                return;
            }
        }
        Ey.execute(this.EC);
        in();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable m<T> mVar) {
        if (this.btM != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.btM = mVar;
        im();
    }

    public synchronized n<T> a(j<T> jVar) {
        if (this.btM != null && this.btM.getValue() != null) {
            jVar.onResult(this.btM.getValue());
        }
        this.EA.add(jVar);
        in();
        return this;
    }

    public synchronized n<T> b(j<T> jVar) {
        this.EA.remove(jVar);
        ip();
        return this;
    }

    public synchronized n<T> c(j<Throwable> jVar) {
        if (this.btM != null && this.btM.il() != null) {
            jVar.onResult(this.btM.il());
        }
        this.EB.add(jVar);
        in();
        return this;
    }

    public synchronized n<T> d(j<Throwable> jVar) {
        this.EB.remove(jVar);
        ip();
        return this;
    }

    private void im() {
        this.handler.post(new Runnable() { // from class: com.baidu.live.lottie.n.1
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.btM != null && !n.this.EC.isCancelled()) {
                    m mVar = n.this.btM;
                    if (mVar.getValue() != null) {
                        n.this.n(mVar.getValue());
                    } else {
                        n.this.g(mVar.il());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(T t) {
        for (j jVar : new ArrayList(this.EA)) {
            jVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Throwable th) {
        ArrayList<j> arrayList = new ArrayList(this.EB);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (j jVar : arrayList) {
            jVar.onResult(th);
        }
    }

    private synchronized void in() {
        if (!iq() && this.btM == null) {
            this.Ez = new Thread("LottieTaskObserver") { // from class: com.baidu.live.lottie.n.2
                private boolean EF = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.EF) {
                        if (n.this.EC.isDone()) {
                            try {
                                n.this.a((m) n.this.EC.get());
                            } catch (InterruptedException | ExecutionException e) {
                                n.this.a(new m(e));
                            }
                            this.EF = true;
                            n.this.ip();
                        }
                    }
                }
            };
            this.Ez.start();
            d.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ip() {
        if (iq() && (this.EA.isEmpty() || this.btM != null)) {
            this.Ez.interrupt();
            this.Ez = null;
            d.debug("Stopping TaskObserver thread");
        }
    }

    private boolean iq() {
        return this.Ez != null && this.Ez.isAlive();
    }
}
