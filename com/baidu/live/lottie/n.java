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
/* loaded from: classes10.dex */
public class n<T> {
    public static Executor Dc = Executors.newCachedThreadPool();
    @Nullable
    private Thread Dd;
    private final Set<j<T>> De;
    private final Set<j<Throwable>> Df;
    private final FutureTask<m<T>> Dg;
    @Nullable
    private volatile m<T> bsl;
    private final Handler handler;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public n(Callable<m<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    n(Callable<m<T>> callable, boolean z) {
        this.De = new LinkedHashSet(1);
        this.Df = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.bsl = null;
        this.Dg = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new m<>(th));
                return;
            }
        }
        Dc.execute(this.Dg);
        in();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable m<T> mVar) {
        if (this.bsl != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.bsl = mVar;
        im();
    }

    public synchronized n<T> a(j<T> jVar) {
        if (this.bsl != null && this.bsl.getValue() != null) {
            jVar.onResult(this.bsl.getValue());
        }
        this.De.add(jVar);
        in();
        return this;
    }

    public synchronized n<T> b(j<T> jVar) {
        this.De.remove(jVar);
        ip();
        return this;
    }

    public synchronized n<T> c(j<Throwable> jVar) {
        if (this.bsl != null && this.bsl.il() != null) {
            jVar.onResult(this.bsl.il());
        }
        this.Df.add(jVar);
        in();
        return this;
    }

    public synchronized n<T> d(j<Throwable> jVar) {
        this.Df.remove(jVar);
        ip();
        return this;
    }

    private void im() {
        this.handler.post(new Runnable() { // from class: com.baidu.live.lottie.n.1
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.bsl != null && !n.this.Dg.isCancelled()) {
                    m mVar = n.this.bsl;
                    if (mVar.getValue() != null) {
                        n.this.l(mVar.getValue());
                    } else {
                        n.this.g(mVar.il());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(T t) {
        for (j jVar : new ArrayList(this.De)) {
            jVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Throwable th) {
        ArrayList<j> arrayList = new ArrayList(this.Df);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (j jVar : arrayList) {
            jVar.onResult(th);
        }
    }

    private synchronized void in() {
        if (!iq() && this.bsl == null) {
            this.Dd = new Thread("LottieTaskObserver") { // from class: com.baidu.live.lottie.n.2
                private boolean Dj = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.Dj) {
                        if (n.this.Dg.isDone()) {
                            try {
                                n.this.a((m) n.this.Dg.get());
                            } catch (InterruptedException | ExecutionException e) {
                                n.this.a(new m(e));
                            }
                            this.Dj = true;
                            n.this.ip();
                        }
                    }
                }
            };
            this.Dd.start();
            d.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ip() {
        if (iq() && (this.De.isEmpty() || this.bsl != null)) {
            this.Dd.interrupt();
            this.Dd = null;
            d.debug("Stopping TaskObserver thread");
        }
    }

    private boolean iq() {
        return this.Dd != null && this.Dd.isAlive();
    }
}
