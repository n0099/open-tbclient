package com.baidu.ar.d;

import com.baidu.ar.databasic.AlgoHandleAdapter;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes12.dex */
public abstract class a implements k {
    private CopyOnWriteArrayList<e> mf = new CopyOnWriteArrayList<>();
    protected e mg;
    private e mh;
    private l mi;

    @Override // com.baidu.ar.d.k
    public void a(e eVar) {
        this.mh = eVar;
        this.mg = new e() { // from class: com.baidu.ar.d.a.1
            @Override // com.baidu.ar.d.e
            public void a(b bVar) {
                if (a.this.mf != null && a.this.mf.size() > 0) {
                    Iterator it = a.this.mf.iterator();
                    while (it.hasNext()) {
                        e eVar2 = (e) it.next();
                        if (bVar.df() > 0) {
                            AlgoHandleAdapter.increaseHandleReference(bVar.df());
                        }
                        eVar2.a(bVar);
                    }
                }
                if (a.this.mh != null) {
                    a.this.mh.a(bVar);
                }
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
                a.this.mi = lVar;
                if (a.this.mh != null) {
                    a.this.mh.a(lVar);
                }
                if (a.this.mf == null || a.this.mf.size() <= 0) {
                    return;
                }
                Iterator it = a.this.mf.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).a(lVar);
                }
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
                if (a.this.mh != null) {
                    a.this.mh.b(lVar);
                }
                if (a.this.mf == null || a.this.mf.size() <= 0) {
                    return;
                }
                Iterator it = a.this.mf.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).b(lVar);
                }
            }
        };
    }

    public void b(e eVar) {
        if (this.mf != null) {
            this.mf.add(eVar);
            if (this.mi != null) {
                eVar.a(this.mi);
            }
        }
    }

    public void c(e eVar) {
        if (this.mf != null) {
            this.mf.remove(eVar);
        }
    }

    public void d(e eVar) {
        this.mh = eVar;
    }

    public boolean dc() {
        return this.mf != null && this.mf.size() > 0;
    }

    @Override // com.baidu.ar.d.k
    public void release() {
        if (this.mf != null) {
            this.mf.clear();
            this.mf = null;
        }
    }
}
