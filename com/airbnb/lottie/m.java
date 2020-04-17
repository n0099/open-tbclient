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
    public static Executor AW = Executors.newCachedThreadPool();
    @Nullable
    private Thread AX;
    private final Set<i<T>> AY;
    private final Set<i<Throwable>> AZ;
    private final FutureTask<l<T>> Ba;
    @Nullable
    private volatile l<T> Bb;
    private final Handler handler;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public m(Callable<l<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    m(Callable<l<T>> callable, boolean z) {
        this.AY = new LinkedHashSet(1);
        this.AZ = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.Bb = null;
        this.Ba = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new l<>(th));
                return;
            }
        }
        AW.execute(this.Ba);
        gX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable l<T> lVar) {
        if (this.Bb != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.Bb = lVar;
        gW();
    }

    public synchronized m<T> a(i<T> iVar) {
        if (this.Bb != null && this.Bb.getValue() != null) {
            iVar.onResult(this.Bb.getValue());
        }
        this.AY.add(iVar);
        gX();
        return this;
    }

    public synchronized m<T> b(i<T> iVar) {
        this.AY.remove(iVar);
        gY();
        return this;
    }

    public synchronized m<T> c(i<Throwable> iVar) {
        if (this.Bb != null && this.Bb.gV() != null) {
            iVar.onResult(this.Bb.gV());
        }
        this.AZ.add(iVar);
        gX();
        return this;
    }

    public synchronized m<T> d(i<Throwable> iVar) {
        this.AZ.remove(iVar);
        gY();
        return this;
    }

    private void gW() {
        this.handler.post(new Runnable() { // from class: com.airbnb.lottie.m.1
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.Bb != null && !m.this.Ba.isCancelled()) {
                    l lVar = m.this.Bb;
                    if (lVar.getValue() != null) {
                        m.this.m(lVar.getValue());
                    } else {
                        m.this.g(lVar.gV());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(T t) {
        for (i iVar : new ArrayList(this.AY)) {
            iVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Throwable th) {
        ArrayList<i> arrayList = new ArrayList(this.AZ);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (i iVar : arrayList) {
            iVar.onResult(th);
        }
    }

    private synchronized void gX() {
        if (!gZ() && this.Bb == null) {
            this.AX = new Thread("LottieTaskObserver") { // from class: com.airbnb.lottie.m.2
                private boolean Bd = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.Bd) {
                        if (m.this.Ba.isDone()) {
                            try {
                                m.this.a((l) m.this.Ba.get());
                            } catch (InterruptedException | ExecutionException e) {
                                m.this.a(new l(e));
                            }
                            this.Bd = true;
                            m.this.gY();
                        }
                    }
                }
            };
            this.AX.start();
            d.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void gY() {
        if (gZ() && (this.AY.isEmpty() || this.Bb != null)) {
            this.AX.interrupt();
            this.AX = null;
            d.debug("Stopping TaskObserver thread");
        }
    }

    private boolean gZ() {
        return this.AX != null && this.AX.isAlive();
    }
}
