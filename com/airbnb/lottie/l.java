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
/* loaded from: classes3.dex */
public class l<T> {
    public static Executor De = Executors.newCachedThreadPool();
    @Nullable
    private Thread Df;
    private final Set<h<T>> Dg;
    private final Set<h<Throwable>> Dh;
    private final FutureTask<k<T>> Di;
    @Nullable
    private volatile k<T> Dj;
    private final Handler handler;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public l(Callable<k<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    l(Callable<k<T>> callable, boolean z) {
        this.Dg = new LinkedHashSet(1);
        this.Dh = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.Dj = null;
        this.Di = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new k<>(th));
                return;
            }
        }
        De.execute(this.Di);
        ip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable k<T> kVar) {
        if (this.Dj != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.Dj = kVar;
        in();
    }

    public synchronized l<T> a(h<T> hVar) {
        if (this.Dj != null && this.Dj.getValue() != null) {
            hVar.onResult(this.Dj.getValue());
        }
        this.Dg.add(hVar);
        ip();
        return this;
    }

    public synchronized l<T> b(h<T> hVar) {
        this.Dg.remove(hVar);
        iq();
        return this;
    }

    public synchronized l<T> c(h<Throwable> hVar) {
        if (this.Dj != null && this.Dj.im() != null) {
            hVar.onResult(this.Dj.im());
        }
        this.Dh.add(hVar);
        ip();
        return this;
    }

    public synchronized l<T> d(h<Throwable> hVar) {
        this.Dh.remove(hVar);
        iq();
        return this;
    }

    private void in() {
        this.handler.post(new Runnable() { // from class: com.airbnb.lottie.l.1
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.Dj != null && !l.this.Di.isCancelled()) {
                    k kVar = l.this.Dj;
                    if (kVar.getValue() != null) {
                        l.this.l(kVar.getValue());
                    } else {
                        l.this.f(kVar.im());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(T t) {
        for (h hVar : new ArrayList(this.Dg)) {
            hVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Throwable th) {
        ArrayList<h> arrayList = new ArrayList(this.Dh);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (h hVar : arrayList) {
            hVar.onResult(th);
        }
    }

    private synchronized void ip() {
        if (!ir() && this.Dj == null) {
            this.Df = new Thread("LottieTaskObserver") { // from class: com.airbnb.lottie.l.2
                private boolean Dl = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.Dl) {
                        if (l.this.Di.isDone()) {
                            try {
                                l.this.a((k) l.this.Di.get());
                            } catch (InterruptedException | ExecutionException e) {
                                l.this.a(new k(e));
                            }
                            this.Dl = true;
                            l.this.iq();
                        }
                    }
                }
            };
            this.Df.start();
            c.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void iq() {
        if (ir() && (this.Dg.isEmpty() || this.Dj != null)) {
            this.Df.interrupt();
            this.Df = null;
            c.debug("Stopping TaskObserver thread");
        }
    }

    private boolean ir() {
        return this.Df != null && this.Df.isAlive();
    }
}
