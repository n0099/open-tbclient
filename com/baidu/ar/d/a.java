package com.baidu.ar.d;

import com.baidu.ar.databasic.AlgoHandleAdapter;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public abstract class a implements k {
    private CopyOnWriteArrayList<e> mu = new CopyOnWriteArrayList<>();
    protected e mv;
    private e mw;
    private l mx;

    @Override // com.baidu.ar.d.k
    public void a(e eVar) {
        this.mw = eVar;
        this.mv = new e() { // from class: com.baidu.ar.d.a.1
            @Override // com.baidu.ar.d.e
            public void a(b bVar) {
                if (a.this.mu != null && a.this.mu.size() > 0) {
                    Iterator it = a.this.mu.iterator();
                    while (it.hasNext()) {
                        e eVar2 = (e) it.next();
                        if (bVar.de() > 0) {
                            AlgoHandleAdapter.increaseHandleReference(bVar.de());
                        }
                        eVar2.a(bVar);
                    }
                }
                if (a.this.mw != null) {
                    a.this.mw.a(bVar);
                }
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
                a.this.mx = lVar;
                if (a.this.mw != null) {
                    a.this.mw.a(lVar);
                }
                if (a.this.mu == null || a.this.mu.size() <= 0) {
                    return;
                }
                Iterator it = a.this.mu.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).a(lVar);
                }
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
                if (a.this.mw != null) {
                    a.this.mw.b(lVar);
                }
                if (a.this.mu == null || a.this.mu.size() <= 0) {
                    return;
                }
                Iterator it = a.this.mu.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).b(lVar);
                }
            }
        };
    }

    public void b(e eVar) {
        if (this.mu != null) {
            this.mu.add(eVar);
            if (this.mx != null) {
                eVar.a(this.mx);
            }
        }
    }

    public void c(e eVar) {
        if (this.mu != null) {
            this.mu.remove(eVar);
        }
    }

    public void d(e eVar) {
        this.mw = eVar;
    }

    public boolean db() {
        return this.mu != null && this.mu.size() > 0;
    }

    @Override // com.baidu.ar.d.k
    public void release() {
        if (this.mu != null) {
            this.mu.clear();
            this.mu = null;
        }
    }
}
