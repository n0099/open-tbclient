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
    public AtomicInteger f9400a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Queue<n<?>>> f9401b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<n<?>> f9402c;

    /* renamed from: d  reason: collision with root package name */
    public final PriorityBlockingQueue<n<?>> f9403d;

    /* renamed from: e  reason: collision with root package name */
    public final PriorityBlockingQueue<n<?>> f9404e;

    /* renamed from: f  reason: collision with root package name */
    public final b f9405f;

    /* renamed from: g  reason: collision with root package name */
    public final i f9406g;

    /* renamed from: h  reason: collision with root package name */
    public final r f9407h;
    public j[] i;
    public c j;
    public List<a> k;

    /* loaded from: classes2.dex */
    public interface a<T> {
        void a(n<T> nVar);
    }

    public p(b bVar, i iVar, int i, r rVar) {
        this.f9400a = new AtomicInteger();
        this.f9401b = new HashMap();
        this.f9402c = new HashSet();
        this.f9403d = new PriorityBlockingQueue<>();
        this.f9404e = new PriorityBlockingQueue<>();
        this.k = new ArrayList();
        this.f9405f = bVar;
        this.f9406g = iVar;
        this.i = new j[i];
        this.f9407h = rVar;
    }

    public void a() {
        b();
        c cVar = new c(this.f9403d, this.f9404e, this.f9405f, this.f9407h);
        this.j = cVar;
        cVar.start();
        for (int i = 0; i < this.i.length; i++) {
            j jVar = new j(this.f9404e, this.f9406g, this.f9405f, this.f9407h);
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
        return this.f9400a.incrementAndGet();
    }

    public <T> void b(n<T> nVar) {
        synchronized (this.f9402c) {
            this.f9402c.remove(nVar);
        }
        synchronized (this.k) {
            for (a aVar : this.k) {
                aVar.a(nVar);
            }
        }
        if (nVar.r()) {
            synchronized (this.f9401b) {
                String e2 = nVar.e();
                Queue<n<?>> remove = this.f9401b.remove(e2);
                if (remove != null) {
                    if (w.f9415b) {
                        w.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), e2);
                    }
                    this.f9403d.addAll(remove);
                }
            }
        }
    }

    public <T> n<T> a(n<T> nVar) {
        nVar.a(this);
        synchronized (this.f9402c) {
            this.f9402c.add(nVar);
        }
        nVar.a(c());
        nVar.a("add-to-queue");
        if (!nVar.r()) {
            this.f9404e.add(nVar);
            return nVar;
        }
        synchronized (this.f9401b) {
            String e2 = nVar.e();
            if (this.f9401b.containsKey(e2)) {
                Queue<n<?>> queue = this.f9401b.get(e2);
                if (queue == null) {
                    queue = new LinkedList<>();
                }
                queue.add(nVar);
                this.f9401b.put(e2, queue);
                if (w.f9415b) {
                    w.a("Request for cacheKey=%s is in flight, putting on hold.", e2);
                }
            } else {
                this.f9401b.put(e2, null);
                this.f9403d.add(nVar);
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
