package com.baidu.searchbox.dns.d.b;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes12.dex */
public abstract class b {
    private int Z = 15;
    private int aa = 1;
    private final Queue<a> ab = E();
    private final Queue<a> ac = F();
    private ExecutorService ad;

    protected abstract Queue<a> E();

    protected abstract Queue<a> F();

    protected String G() {
        return "Searchbox Dispatcher #";
    }

    public synchronized ExecutorService H() {
        if (this.ad == null) {
            this.ad = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), c(G(), false));
        }
        return this.ad;
    }

    public synchronized void a(a aVar) {
        if (this.ac.size() < this.Z && c(aVar) < this.aa) {
            this.ac.add(aVar);
            H().execute(aVar);
        } else {
            this.ab.add(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(a aVar) {
        this.ac.remove(aVar);
        I();
    }

    private synchronized void I() {
        if (this.ac.size() < this.Z && !this.ab.isEmpty()) {
            Iterator<a> it = this.ab.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (c(next) < this.aa) {
                    it.remove();
                    this.ac.add(next);
                    H().execute(next);
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
