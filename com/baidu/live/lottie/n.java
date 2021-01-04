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
    public static Executor De = Executors.newCachedThreadPool();
    @Nullable
    private Thread Df;
    private final Set<j<T>> Dg;
    private final Set<j<Throwable>> Dh;
    private final FutureTask<m<T>> Di;
    @Nullable
    private volatile m<T> btx;
    private final Handler handler;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public n(Callable<m<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    n(Callable<m<T>> callable, boolean z) {
        this.Dg = new LinkedHashSet(1);
        this.Dh = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.btx = null;
        this.Di = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new m<>(th));
                return;
            }
        }
        De.execute(this.Di);
        ip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable m<T> mVar) {
        if (this.btx != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.btx = mVar;
        in();
    }

    public synchronized n<T> a(j<T> jVar) {
        if (this.btx != null && this.btx.getValue() != null) {
            jVar.onResult(this.btx.getValue());
        }
        this.Dg.add(jVar);
        ip();
        return this;
    }

    public synchronized n<T> b(j<T> jVar) {
        this.Dg.remove(jVar);
        iq();
        return this;
    }

    public synchronized n<T> c(j<Throwable> jVar) {
        if (this.btx != null && this.btx.im() != null) {
            jVar.onResult(this.btx.im());
        }
        this.Dh.add(jVar);
        ip();
        return this;
    }

    public synchronized n<T> d(j<Throwable> jVar) {
        this.Dh.remove(jVar);
        iq();
        return this;
    }

    private void in() {
        this.handler.post(new Runnable() { // from class: com.baidu.live.lottie.n.1
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.btx != null && !n.this.Di.isCancelled()) {
                    m mVar = n.this.btx;
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
        for (j jVar : new ArrayList(this.Dg)) {
            jVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Throwable th) {
        ArrayList<j> arrayList = new ArrayList(this.Dh);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (j jVar : arrayList) {
            jVar.onResult(th);
        }
    }

    private synchronized void ip() {
        if (!ir() && this.btx == null) {
            this.Df = new Thread("LottieTaskObserver") { // from class: com.baidu.live.lottie.n.2
                private boolean Dl = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.Dl) {
                        if (n.this.Di.isDone()) {
                            try {
                                n.this.a((m) n.this.Di.get());
                            } catch (InterruptedException | ExecutionException e) {
                                n.this.a(new m(e));
                            }
                            this.Dl = true;
                            n.this.iq();
                        }
                    }
                }
            };
            this.Df.start();
            d.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void iq() {
        if (ir() && (this.Dg.isEmpty() || this.btx != null)) {
            this.Df.interrupt();
            this.Df = null;
            d.debug("Stopping TaskObserver thread");
        }
    }

    private boolean ir() {
        return this.Df != null && this.Df.isAlive();
    }
}
