package com.baidu.searchbox.dns.d.b;

import android.support.v7.widget.ActivityChooserView;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public abstract class b {
    private int I = 15;
    private int J = 1;
    private final Queue<a> K = u();
    private final Queue<a> L = v();
    private ExecutorService M;

    protected abstract Queue<a> u();

    protected abstract Queue<a> v();

    protected String w() {
        return "Searchbox Dispatcher #";
    }

    public synchronized ExecutorService x() {
        if (this.M == null) {
            this.M = new ThreadPoolExecutor(0, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60L, TimeUnit.SECONDS, new SynchronousQueue(), d(w(), false));
        }
        return this.M;
    }

    public synchronized void a(a aVar) {
        if (this.L.size() < this.I && c(aVar) < this.J) {
            this.L.add(aVar);
            x().execute(aVar);
        } else {
            this.K.add(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(a aVar) {
        this.L.remove(aVar);
        y();
    }

    private synchronized void y() {
        if (this.L.size() < this.I && !this.K.isEmpty()) {
            Iterator<a> it = this.K.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (c(next) < this.J) {
                    it.remove();
                    this.L.add(next);
                    x().execute(next);
                }
                if (this.L.size() >= this.I) {
                    break;
                }
            }
        }
    }

    private int c(a aVar) {
        int i = 0;
        Iterator<a> it = this.L.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().l().equals(aVar.l()) ? i2 + 1 : i2;
            } else {
                return i2;
            }
        }
    }

    private ThreadFactory d(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.baidu.searchbox.dns.d.b.b.1
            private final AtomicInteger N = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str + this.N.getAndIncrement());
                thread.setDaemon(z);
                return thread;
            }
        };
    }
}
