package com.baidu.pano.platform.a;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes20.dex */
public class p {
    private AtomicInteger a;
    private final Map<String, Queue<n<?>>> b;
    private final Set<n<?>> c;
    private final PriorityBlockingQueue<n<?>> d;
    private final PriorityBlockingQueue<n<?>> e;
    private final b f;
    private final i g;
    private final r h;
    private j[] i;
    private c j;
    private List<a> k;

    /* loaded from: classes20.dex */
    public interface a<T> {
        void a(n<T> nVar);
    }

    public p(b bVar, i iVar, int i, r rVar) {
        this.a = new AtomicInteger();
        this.b = new HashMap();
        this.c = new HashSet();
        this.d = new PriorityBlockingQueue<>();
        this.e = new PriorityBlockingQueue<>();
        this.k = new ArrayList();
        this.f = bVar;
        this.g = iVar;
        this.i = new j[i];
        this.h = rVar;
    }

    public p(b bVar, i iVar, int i) {
        this(bVar, iVar, i, new f(new Handler(Looper.getMainLooper())));
    }

    public p(b bVar, i iVar) {
        this(bVar, iVar, 4);
    }

    public void a() {
        b();
        this.j = new c(this.d, this.e, this.f, this.h);
        this.j.start();
        for (int i = 0; i < this.i.length; i++) {
            j jVar = new j(this.e, this.g, this.f, this.h);
            this.i[i] = jVar;
            jVar.start();
        }
    }

    public void b() {
        if (this.j != null) {
            this.j.a();
        }
        for (int i = 0; i < this.i.length; i++) {
            if (this.i[i] != null) {
                this.i[i].a();
            }
        }
    }

    public int c() {
        return this.a.incrementAndGet();
    }

    public <T> n<T> a(n<T> nVar) {
        nVar.a(this);
        synchronized (this.c) {
            this.c.add(nVar);
        }
        nVar.a(c());
        nVar.a("add-to-queue");
        if (!nVar.r()) {
            this.e.add(nVar);
        } else {
            synchronized (this.b) {
                String e = nVar.e();
                if (this.b.containsKey(e)) {
                    Queue<n<?>> queue = this.b.get(e);
                    if (queue == null) {
                        queue = new LinkedList<>();
                    }
                    queue.add(nVar);
                    this.b.put(e, queue);
                    if (w.b) {
                        w.a("Request for cacheKey=%s is in flight, putting on hold.", e);
                    }
                } else {
                    this.b.put(e, null);
                    this.d.add(nVar);
                }
            }
        }
        return nVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> void b(n<T> nVar) {
        synchronized (this.c) {
            this.c.remove(nVar);
        }
        synchronized (this.k) {
            for (a aVar : this.k) {
                aVar.a(nVar);
            }
        }
        if (nVar.r()) {
            synchronized (this.b) {
                String e = nVar.e();
                Queue<n<?>> remove = this.b.remove(e);
                if (remove != null) {
                    if (w.b) {
                        w.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), e);
                    }
                    this.d.addAll(remove);
                }
            }
        }
    }
}
