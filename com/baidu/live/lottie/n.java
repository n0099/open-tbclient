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
    public static Executor Dc = Executors.newCachedThreadPool();
    @Nullable
    private Thread Dd;
    private final Set<j<T>> De;
    private final Set<j<Throwable>> Df;
    private final FutureTask<m<T>> Dg;
    @Nullable
    private volatile m<T> boK;
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
        this.boK = null;
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
        ip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable m<T> mVar) {
        if (this.boK != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.boK = mVar;
        in();
    }

    public synchronized n<T> a(j<T> jVar) {
        if (this.boK != null && this.boK.getValue() != null) {
            jVar.onResult(this.boK.getValue());
        }
        this.De.add(jVar);
        ip();
        return this;
    }

    public synchronized n<T> b(j<T> jVar) {
        this.De.remove(jVar);
        iq();
        return this;
    }

    public synchronized n<T> c(j<Throwable> jVar) {
        if (this.boK != null && this.boK.im() != null) {
            jVar.onResult(this.boK.im());
        }
        this.Df.add(jVar);
        ip();
        return this;
    }

    public synchronized n<T> d(j<Throwable> jVar) {
        this.Df.remove(jVar);
        iq();
        return this;
    }

    private void in() {
        this.handler.post(new Runnable() { // from class: com.baidu.live.lottie.n.1
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.boK != null && !n.this.Dg.isCancelled()) {
                    m mVar = n.this.boK;
                    if (mVar.getValue() != null) {
                        n.this.l(mVar.getValue());
                    } else {
                        n.this.f(mVar.im());
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
    public void f(Throwable th) {
        ArrayList<j> arrayList = new ArrayList(this.Df);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (j jVar : arrayList) {
            jVar.onResult(th);
        }
    }

    private synchronized void ip() {
        if (!ir() && this.boK == null) {
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
                            n.this.iq();
                        }
                    }
                }
            };
            this.Dd.start();
            d.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void iq() {
        if (ir() && (this.De.isEmpty() || this.boK != null)) {
            this.Dd.interrupt();
            this.Dd = null;
            d.debug("Stopping TaskObserver thread");
        }
    }

    private boolean ir() {
        return this.Dd != null && this.Dd.isAlive();
    }
}
