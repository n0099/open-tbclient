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
/* loaded from: classes5.dex */
public class l<T> {
    public static Executor Ey = Executors.newCachedThreadPool();
    private final Set<h<T>> EA;
    private final Set<h<Throwable>> EB;
    private final FutureTask<k<T>> EC;
    @Nullable
    private volatile k<T> ED;
    @Nullable
    private Thread Ez;
    private final Handler handler;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public l(Callable<k<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    l(Callable<k<T>> callable, boolean z) {
        this.EA = new LinkedHashSet(1);
        this.EB = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.ED = null;
        this.EC = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new k<>(th));
                return;
            }
        }
        Ey.execute(this.EC);
        in();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable k<T> kVar) {
        if (this.ED != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.ED = kVar;
        im();
    }

    public synchronized l<T> a(h<T> hVar) {
        if (this.ED != null && this.ED.getValue() != null) {
            hVar.onResult(this.ED.getValue());
        }
        this.EA.add(hVar);
        in();
        return this;
    }

    public synchronized l<T> b(h<T> hVar) {
        this.EA.remove(hVar);
        ip();
        return this;
    }

    public synchronized l<T> c(h<Throwable> hVar) {
        if (this.ED != null && this.ED.il() != null) {
            hVar.onResult(this.ED.il());
        }
        this.EB.add(hVar);
        in();
        return this;
    }

    public synchronized l<T> d(h<Throwable> hVar) {
        this.EB.remove(hVar);
        ip();
        return this;
    }

    private void im() {
        this.handler.post(new Runnable() { // from class: com.airbnb.lottie.l.1
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.ED != null && !l.this.EC.isCancelled()) {
                    k kVar = l.this.ED;
                    if (kVar.getValue() != null) {
                        l.this.n(kVar.getValue());
                    } else {
                        l.this.g(kVar.il());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(T t) {
        for (h hVar : new ArrayList(this.EA)) {
            hVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Throwable th) {
        ArrayList<h> arrayList = new ArrayList(this.EB);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (h hVar : arrayList) {
            hVar.onResult(th);
        }
    }

    private synchronized void in() {
        if (!iq() && this.ED == null) {
            this.Ez = new Thread("LottieTaskObserver") { // from class: com.airbnb.lottie.l.2
                private boolean EF = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.EF) {
                        if (l.this.EC.isDone()) {
                            try {
                                l.this.a((k) l.this.EC.get());
                            } catch (InterruptedException | ExecutionException e) {
                                l.this.a(new k(e));
                            }
                            this.EF = true;
                            l.this.ip();
                        }
                    }
                }
            };
            this.Ez.start();
            c.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ip() {
        if (iq() && (this.EA.isEmpty() || this.ED != null)) {
            this.Ez.interrupt();
            this.Ez = null;
            c.debug("Stopping TaskObserver thread");
        }
    }

    private boolean iq() {
        return this.Ez != null && this.Ez.isAlive();
    }
}
