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
    public AtomicInteger f9287a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Queue<n<?>>> f9288b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<n<?>> f9289c;

    /* renamed from: d  reason: collision with root package name */
    public final PriorityBlockingQueue<n<?>> f9290d;

    /* renamed from: e  reason: collision with root package name */
    public final PriorityBlockingQueue<n<?>> f9291e;

    /* renamed from: f  reason: collision with root package name */
    public final b f9292f;

    /* renamed from: g  reason: collision with root package name */
    public final i f9293g;

    /* renamed from: h  reason: collision with root package name */
    public final r f9294h;

    /* renamed from: i  reason: collision with root package name */
    public j[] f9295i;
    public c j;
    public List<a> k;

    /* loaded from: classes2.dex */
    public interface a<T> {
        void a(n<T> nVar);
    }

    public p(b bVar, i iVar, int i2, r rVar) {
        this.f9287a = new AtomicInteger();
        this.f9288b = new HashMap();
        this.f9289c = new HashSet();
        this.f9290d = new PriorityBlockingQueue<>();
        this.f9291e = new PriorityBlockingQueue<>();
        this.k = new ArrayList();
        this.f9292f = bVar;
        this.f9293g = iVar;
        this.f9295i = new j[i2];
        this.f9294h = rVar;
    }

    public void a() {
        b();
        c cVar = new c(this.f9290d, this.f9291e, this.f9292f, this.f9294h);
        this.j = cVar;
        cVar.start();
        for (int i2 = 0; i2 < this.f9295i.length; i2++) {
            j jVar = new j(this.f9291e, this.f9293g, this.f9292f, this.f9294h);
            this.f9295i[i2] = jVar;
            jVar.start();
        }
    }

    public void b() {
        c cVar = this.j;
        if (cVar != null) {
            cVar.a();
        }
        int i2 = 0;
        while (true) {
            j[] jVarArr = this.f9295i;
            if (i2 >= jVarArr.length) {
                return;
            }
            if (jVarArr[i2] != null) {
                jVarArr[i2].a();
            }
            i2++;
        }
    }

    public int c() {
        return this.f9287a.incrementAndGet();
    }

    public <T> void b(n<T> nVar) {
        synchronized (this.f9289c) {
            this.f9289c.remove(nVar);
        }
        synchronized (this.k) {
            for (a aVar : this.k) {
                aVar.a(nVar);
            }
        }
        if (nVar.r()) {
            synchronized (this.f9288b) {
                String e2 = nVar.e();
                Queue<n<?>> remove = this.f9288b.remove(e2);
                if (remove != null) {
                    if (w.f9303b) {
                        w.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), e2);
                    }
                    this.f9290d.addAll(remove);
                }
            }
        }
    }

    public <T> n<T> a(n<T> nVar) {
        nVar.a(this);
        synchronized (this.f9289c) {
            this.f9289c.add(nVar);
        }
        nVar.a(c());
        nVar.a("add-to-queue");
        if (!nVar.r()) {
            this.f9291e.add(nVar);
            return nVar;
        }
        synchronized (this.f9288b) {
            String e2 = nVar.e();
            if (this.f9288b.containsKey(e2)) {
                Queue<n<?>> queue = this.f9288b.get(e2);
                if (queue == null) {
                    queue = new LinkedList<>();
                }
                queue.add(nVar);
                this.f9288b.put(e2, queue);
                if (w.f9303b) {
                    w.a("Request for cacheKey=%s is in flight, putting on hold.", e2);
                }
            } else {
                this.f9288b.put(e2, null);
                this.f9290d.add(nVar);
            }
        }
        return nVar;
    }

    public p(b bVar, i iVar, int i2) {
        this(bVar, iVar, i2, new f(new Handler(Looper.getMainLooper())));
    }

    public p(b bVar, i iVar) {
        this(bVar, iVar, 4);
    }
}
