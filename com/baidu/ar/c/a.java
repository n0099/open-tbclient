package com.baidu.ar.c;

import com.baidu.ar.databasic.AlgoHandleAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes11.dex */
public abstract class a implements k {
    private l lA;
    private List<e> lx = Collections.synchronizedList(new ArrayList());
    protected e ly;
    private e lz;

    @Override // com.baidu.ar.c.k
    public void a(e eVar) {
        this.lz = eVar;
        this.ly = new e() { // from class: com.baidu.ar.c.a.1
            @Override // com.baidu.ar.c.e
            public void a(b bVar) {
                if (a.this.lx != null && a.this.lx.size() > 0) {
                    for (e eVar2 : a.this.lx) {
                        if (bVar.cF() > 0) {
                            AlgoHandleAdapter.increaseHandleReference(bVar.cF());
                        }
                        eVar2.a(bVar);
                    }
                }
                if (a.this.lz != null) {
                    a.this.lz.a(bVar);
                }
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
                a.this.lA = lVar;
                if (a.this.lz != null) {
                    a.this.lz.a(lVar);
                }
                if (a.this.lx == null || a.this.lx.size() <= 0) {
                    return;
                }
                for (e eVar2 : a.this.lx) {
                    eVar2.a(lVar);
                }
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
                if (a.this.lz != null) {
                    a.this.lz.b(lVar);
                }
                if (a.this.lx == null || a.this.lx.size() <= 0) {
                    return;
                }
                for (e eVar2 : a.this.lx) {
                    eVar2.b(lVar);
                }
            }
        };
    }

    public void b(e eVar) {
        if (this.lx != null) {
            this.lx.add(eVar);
            if (this.lA != null) {
                eVar.a(this.lA);
            }
        }
    }

    public void c(e eVar) {
        if (this.lx != null) {
            this.lx.remove(eVar);
        }
    }

    public boolean cC() {
        return this.lx != null && this.lx.size() > 0;
    }

    public void d(e eVar) {
        this.lz = eVar;
    }

    @Override // com.baidu.ar.c.k
    public void release() {
        if (this.lx != null) {
            this.lx.clear();
            this.lx = null;
        }
    }
}
