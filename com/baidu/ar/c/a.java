package com.baidu.ar.c;

import com.baidu.ar.databasic.AlgoHandleAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a implements k {
    private List<e> la = Collections.synchronizedList(new ArrayList());
    protected e lb;
    private e lc;
    private l ld;

    @Override // com.baidu.ar.c.k
    public void a(e eVar) {
        this.lc = eVar;
        this.lb = new e() { // from class: com.baidu.ar.c.a.1
            @Override // com.baidu.ar.c.e
            public void a(b bVar) {
                if (a.this.la != null && a.this.la.size() > 0) {
                    for (e eVar2 : a.this.la) {
                        if (bVar.cn() > 0) {
                            AlgoHandleAdapter.increaseHandleReference(bVar.cn());
                        }
                        eVar2.a(bVar);
                    }
                }
                if (a.this.lc != null) {
                    a.this.lc.a(bVar);
                }
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
                a.this.ld = lVar;
                if (a.this.lc != null) {
                    a.this.lc.a(lVar);
                }
                if (a.this.la == null || a.this.la.size() <= 0) {
                    return;
                }
                for (e eVar2 : a.this.la) {
                    eVar2.a(lVar);
                }
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
                if (a.this.lc != null) {
                    a.this.lc.b(lVar);
                }
                if (a.this.la == null || a.this.la.size() <= 0) {
                    return;
                }
                for (e eVar2 : a.this.la) {
                    eVar2.b(lVar);
                }
            }
        };
    }

    public void b(e eVar) {
        if (this.la != null) {
            this.la.add(eVar);
            if (this.ld != null) {
                eVar.a(this.ld);
            }
        }
    }

    public void c(e eVar) {
        if (this.la != null) {
            this.la.remove(eVar);
        }
    }

    public boolean ck() {
        return this.la != null && this.la.size() > 0;
    }

    public void d(e eVar) {
        this.lc = eVar;
    }

    @Override // com.baidu.ar.c.k
    public void release() {
        if (this.la != null) {
            this.la.clear();
            this.la = null;
        }
    }
}
