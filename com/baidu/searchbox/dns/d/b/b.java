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
/* loaded from: classes11.dex */
public abstract class b {
    private int Z = 15;
    private int aa = 1;
    private final Queue<a> ab = G();
    private final Queue<a> ac = H();
    private ExecutorService ad;

    protected abstract Queue<a> G();

    protected abstract Queue<a> H();

    protected String I() {
        return "Searchbox Dispatcher #";
    }

    public synchronized ExecutorService J() {
        if (this.ad == null) {
            this.ad = new ThreadPoolExecutor(0, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60L, TimeUnit.SECONDS, new SynchronousQueue(), c(I(), false));
        }
        return this.ad;
    }

    public synchronized void a(a aVar) {
        if (this.ac.size() < this.Z && c(aVar) < this.aa) {
            this.ac.add(aVar);
            J().execute(aVar);
        } else {
            this.ab.add(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(a aVar) {
        this.ac.remove(aVar);
        K();
    }

    private synchronized void K() {
        if (this.ac.size() < this.Z && !this.ab.isEmpty()) {
            Iterator<a> it = this.ab.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (c(next) < this.aa) {
                    it.remove();
                    this.ac.add(next);
                    J().execute(next);
                }
                if (this.ac.size() >= this.Z) {
                    break;
                }
            }
        }
    }

    private int c(a aVar) {
        int i = 0;
        Iterator<a> it = this.ac.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().n().equals(aVar.n()) ? i2 + 1 : i2;
            } else {
                return i2;
            }
        }
    }

    private ThreadFactory c(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.baidu.searchbox.dns.d.b.b.1
            private final AtomicInteger ae = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str + this.ae.getAndIncrement());
                thread.setDaemon(z);
                return thread;
            }
        };
    }
}
