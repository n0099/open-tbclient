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
/* loaded from: classes2.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public AtomicInteger f8958a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Queue<n<?>>> f8959b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<n<?>> f8960c;

    /* renamed from: d  reason: collision with root package name */
    public final PriorityBlockingQueue<n<?>> f8961d;

    /* renamed from: e  reason: collision with root package name */
    public final PriorityBlockingQueue<n<?>> f8962e;

    /* renamed from: f  reason: collision with root package name */
    public final b f8963f;

    /* renamed from: g  reason: collision with root package name */
    public final i f8964g;

    /* renamed from: h  reason: collision with root package name */
    public final r f8965h;
    public j[] i;
    public c j;
    public List<a> k;

    /* loaded from: classes2.dex */
    public interface a<T> {
        void a(n<T> nVar);
    }

    public p(b bVar, i iVar, int i, r rVar) {
        this.f8958a = new AtomicInteger();
        this.f8959b = new HashMap();
        this.f8960c = new HashSet();
        this.f8961d = new PriorityBlockingQueue<>();
        this.f8962e = new PriorityBlockingQueue<>();
        this.k = new ArrayList();
        this.f8963f = bVar;
        this.f8964g = iVar;
        this.i = new j[i];
        this.f8965h = rVar;
    }

    public void a() {
        b();
        c cVar = new c(this.f8961d, this.f8962e, this.f8963f, this.f8965h);
        this.j = cVar;
        cVar.start();
        for (int i = 0; i < this.i.length; i++) {
            j jVar = new j(this.f8962e, this.f8964g, this.f8963f, this.f8965h);
            this.i[i] = jVar;
            jVar.start();
        }
    }

    public void b() {
        c cVar = this.j;
        if (cVar != null) {
            cVar.a();
        }
        int i = 0;
        while (true) {
            j[] jVarArr = this.i;
            if (i >= jVarArr.length) {
                return;
            }
            if (jVarArr[i] != null) {
                jVarArr[i].a();
            }
            i++;
        }
    }

    public int c() {
        return this.f8958a.incrementAndGet();
    }

    public <T> void b(n<T> nVar) {
        synchronized (this.f8960c) {
            this.f8960c.remove(nVar);
        }
        synchronized (this.k) {
            for (a aVar : this.k) {
                aVar.a(nVar);
            }
        }
        if (nVar.r()) {
            synchronized (this.f8959b) {
                String e2 = nVar.e();
                Queue<n<?>> remove = this.f8959b.remove(e2);
                if (remove != null) {
                    if (w.f8973b) {
                        w.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), e2);
                    }
                    this.f8961d.addAll(remove);
                }
            }
        }
    }

    public <T> n<T> a(n<T> nVar) {
        nVar.a(this);
        synchronized (this.f8960c) {
            this.f8960c.add(nVar);
        }
        nVar.a(c());
        nVar.a("add-to-queue");
        if (!nVar.r()) {
            this.f8962e.add(nVar);
            return nVar;
        }
        synchronized (this.f8959b) {
            String e2 = nVar.e();
            if (this.f8959b.containsKey(e2)) {
                Queue<n<?>> queue = this.f8959b.get(e2);
                if (queue == null) {
                    queue = new LinkedList<>();
                }
                queue.add(nVar);
                this.f8959b.put(e2, queue);
                if (w.f8973b) {
                    w.a("Request for cacheKey=%s is in flight, putting on hold.", e2);
                }
            } else {
                this.f8959b.put(e2, null);
                this.f8961d.add(nVar);
            }
        }
        return nVar;
    }

    public p(b bVar, i iVar, int i) {
        this(bVar, iVar, i, new f(new Handler(Looper.getMainLooper())));
    }

    public p(b bVar, i iVar) {
        this(bVar, iVar, 4);
    }
}
