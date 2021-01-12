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
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f3888a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Queue<n<?>>> f3889b;
    private final Set<n<?>> c;
    private final PriorityBlockingQueue<n<?>> d;
    private final PriorityBlockingQueue<n<?>> e;
    private final b f;
    private final i g;
    private final r h;
    private j[] i;
    private c j;
    private List<a> k;

    /* loaded from: classes6.dex */
    public interface a<T> {
        void a(n<T> nVar);
    }

    public p(b bVar, i iVar, int i, r rVar) {
        this.f3888a = new AtomicInteger();
        this.f3889b = new HashMap();
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
        return this.f3888a.incrementAndGet();
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
            synchronized (this.f3889b) {
                String e = nVar.e();
                if (this.f3889b.containsKey(e)) {
                    Queue<n<?>> queue = this.f3889b.get(e);
                    if (queue == null) {
                        queue = new LinkedList<>();
                    }
                    queue.add(nVar);
                    this.f3889b.put(e, queue);
                    if (w.f3895b) {
                        w.a("Request for cacheKey=%s is in flight, putting on hold.", e);
                    }
                } else {
                    this.f3889b.put(e, null);
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
            synchronized (this.f3889b) {
                String e = nVar.e();
                Queue<n<?>> remove = this.f3889b.remove(e);
                if (remove != null) {
                    if (w.f3895b) {
                        w.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), e);
                    }
                    this.d.addAll(remove);
                }
            }
        }
    }
}
