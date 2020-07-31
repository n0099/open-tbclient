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
/* loaded from: classes20.dex */
public class m<T> {
    public static Executor By = Executors.newCachedThreadPool();
    private final Set<i<T>> BA;
    private final Set<i<Throwable>> BB;
    private final FutureTask<l<T>> BC;
    @Nullable
    private volatile l<T> BD;
    @Nullable
    private Thread Bz;
    private final Handler handler;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public m(Callable<l<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    m(Callable<l<T>> callable, boolean z) {
        this.BA = new LinkedHashSet(1);
        this.BB = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.BD = null;
        this.BC = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
                return;
            } catch (Throwable th) {
                a(new l<>(th));
                return;
            }
        }
        By.execute(this.BC);
        hn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@Nullable l<T> lVar) {
        if (this.BD != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.BD = lVar;
        hm();
    }

    public synchronized m<T> a(i<T> iVar) {
        if (this.BD != null && this.BD.getValue() != null) {
            iVar.onResult(this.BD.getValue());
        }
        this.BA.add(iVar);
        hn();
        return this;
    }

    public synchronized m<T> b(i<T> iVar) {
        this.BA.remove(iVar);
        ho();
        return this;
    }

    public synchronized m<T> c(i<Throwable> iVar) {
        if (this.BD != null && this.BD.hl() != null) {
            iVar.onResult(this.BD.hl());
        }
        this.BB.add(iVar);
        hn();
        return this;
    }

    public synchronized m<T> d(i<Throwable> iVar) {
        this.BB.remove(iVar);
        ho();
        return this;
    }

    private void hm() {
        this.handler.post(new Runnable() { // from class: com.airbnb.lottie.m.1
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.BD != null && !m.this.BC.isCancelled()) {
                    l lVar = m.this.BD;
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
        for (i iVar : new ArrayList(this.BA)) {
            iVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Throwable th) {
        ArrayList<i> arrayList = new ArrayList(this.BB);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (i iVar : arrayList) {
            iVar.onResult(th);
        }
    }

    private synchronized void hn() {
        if (!hp() && this.BD == null) {
            this.Bz = new Thread("LottieTaskObserver") { // from class: com.airbnb.lottie.m.2
                private boolean BF = false;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted() && !this.BF) {
                        if (m.this.BC.isDone()) {
                            try {
                                m.this.a((l) m.this.BC.get());
                            } catch (InterruptedException | ExecutionException e) {
                                m.this.a(new l(e));
                            }
                            this.BF = true;
                            m.this.ho();
                        }
                    }
                }
            };
            this.Bz.start();
            d.debug("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ho() {
        if (hp() && (this.BA.isEmpty() || this.BD != null)) {
            this.Bz.interrupt();
            this.Bz = null;
            d.debug("Stopping TaskObserver thread");
        }
    }

    private boolean hp() {
        return this.Bz != null && this.Bz.isAlive();
    }
}
