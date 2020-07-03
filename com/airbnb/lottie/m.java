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
    public static Executor Bw = Executors.newCachedThreadPool();
    private final FutureTask<l<T>> BA;
    @Nullable
    private volatile l<T> BB;
    @Nullable
    private Thread Bx;
    private final Set<i<T>> By;
    private final Set<i<Throwable>> Bz;
    private final Handler handler;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public m(Callable<l<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    m(Callable<l<T>> callable, boolean z) {
        this.By = new LinkedHashSet(1);
        this.Bz = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.BB = null;
        this.BA = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new l<>(th));
                return;
            }
        }
        Bw.execute(this.BA);
        hn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable l<T> lVar) {
        if (this.BB != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.BB = lVar;
        hm();
    }

    public synchronized m<T> a(i<T> iVar) {
        if (this.BB != null && this.BB.getValue() != null) {
            iVar.onResult(this.BB.getValue());
        }
        this.By.add(iVar);
        hn();
        return this;
    }

    public synchronized m<T> b(i<T> iVar) {
        this.By.remove(iVar);
        ho();
        return this;
    }

    public synchronized m<T> c(i<Throwable> iVar) {
        if (this.BB != null && this.BB.hl() != null) {
            iVar.onResult(this.BB.hl());
        }
        this.Bz.add(iVar);
        hn();
        return this;
    }

    public synchronized m<T> d(i<Throwable> iVar) {
        this.Bz.remove(iVar);
        ho();
        return this;
    }

    private void hm() {
        this.handler.post(new Runnable() { // from class: com.airbnb.lottie.m.1
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.BB != null && !m.this.BA.isCancelled()) {
                    l lVar = m.this.BB;
                    if (lVar.getValue() != null) {
                        m.this.n(lVar.getValue());
                    } else {
                        m.this.g(lVar.hl());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(T t) {
        for (i iVar : new ArrayList(this.By)) {
            iVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Throwable th) {
        ArrayList<i> arrayList = new ArrayList(this.Bz);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (i iVar : arrayList) {
            iVar.onResult(th);
        }
    }

    private synchronized void hn() {
        if (!hp() && this.BB == null) {
            this.Bx = new Thread("LottieTaskObserver") { // from class: com.airbnb.lottie.m.2
                private boolean BD = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.BD) {
                        if (m.this.BA.isDone()) {
                            try {
                                m.this.a((l) m.this.BA.get());
                            } catch (InterruptedException | ExecutionException e) {
                                m.this.a(new l(e));
                            }
                            this.BD = true;
                            m.this.ho();
                        }
                    }
                }
            };
            this.Bx.start();
            d.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ho() {
        if (hp() && (this.By.isEmpty() || this.BB != null)) {
            this.Bx.interrupt();
            this.Bx = null;
            d.debug("Stopping TaskObserver thread");
        }
    }

    private boolean hp() {
        return this.Bx != null && this.Bx.isAlive();
    }
}
