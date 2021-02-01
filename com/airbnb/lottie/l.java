package com.airbnb.lottie;

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
/* loaded from: classes4.dex */
public class l<T> {
    public static Executor Dc = Executors.newCachedThreadPool();
    @Nullable
    private Thread Dd;
    private final Set<h<T>> De;
    private final Set<h<Throwable>> Df;
    private final FutureTask<k<T>> Dg;
    @Nullable
    private volatile k<T> Dh;
    private final Handler handler;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public l(Callable<k<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    l(Callable<k<T>> callable, boolean z) {
        this.De = new LinkedHashSet(1);
        this.Df = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.Dh = null;
        this.Dg = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new k<>(th));
                return;
            }
        }
        Dc.execute(this.Dg);
        in();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable k<T> kVar) {
        if (this.Dh != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.Dh = kVar;
        im();
    }

    public synchronized l<T> a(h<T> hVar) {
        if (this.Dh != null && this.Dh.getValue() != null) {
            hVar.onResult(this.Dh.getValue());
        }
        this.De.add(hVar);
        in();
        return this;
    }

    public synchronized l<T> b(h<T> hVar) {
        this.De.remove(hVar);
        ip();
        return this;
    }

    public synchronized l<T> c(h<Throwable> hVar) {
        if (this.Dh != null && this.Dh.il() != null) {
            hVar.onResult(this.Dh.il());
        }
        this.Df.add(hVar);
        in();
        return this;
    }

    public synchronized l<T> d(h<Throwable> hVar) {
        this.Df.remove(hVar);
        ip();
        return this;
    }

    private void im() {
        this.handler.post(new Runnable() { // from class: com.airbnb.lottie.l.1
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.Dh != null && !l.this.Dg.isCancelled()) {
                    k kVar = l.this.Dh;
                    if (kVar.getValue() != null) {
                        l.this.l(kVar.getValue());
                    } else {
                        l.this.g(kVar.il());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(T t) {
        for (h hVar : new ArrayList(this.De)) {
            hVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Throwable th) {
        ArrayList<h> arrayList = new ArrayList(this.Df);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (h hVar : arrayList) {
            hVar.onResult(th);
        }
    }

    private synchronized void in() {
        if (!iq() && this.Dh == null) {
            this.Dd = new Thread("LottieTaskObserver") { // from class: com.airbnb.lottie.l.2
                private boolean Dj = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.Dj) {
                        if (l.this.Dg.isDone()) {
                            try {
                                l.this.a((k) l.this.Dg.get());
                            } catch (InterruptedException | ExecutionException e) {
                                l.this.a(new k(e));
                            }
                            this.Dj = true;
                            l.this.ip();
                        }
                    }
                }
            };
            this.Dd.start();
            c.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ip() {
        if (iq() && (this.De.isEmpty() || this.Dh != null)) {
            this.Dd.interrupt();
            this.Dd = null;
            c.debug("Stopping TaskObserver thread");
        }
    }

    private boolean iq() {
        return this.Dd != null && this.Dd.isAlive();
    }
}
