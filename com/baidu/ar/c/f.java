package com.baidu.ar.c;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class f implements k {
    private e lb;
    private d lr;
    private List<k> O = new CopyOnWriteArrayList();
    private List<k> lq = new CopyOnWriteArrayList();

    private void a(k kVar, final e eVar, final boolean z) {
        com.baidu.ar.f.b.c("DetectorGroup", "setupDetctor detector.getName() = " + kVar.getName());
        e eVar2 = new e() { // from class: com.baidu.ar.c.f.2
            @Override // com.baidu.ar.c.e
            public void a(b bVar) {
                if (bVar == null) {
                    com.baidu.ar.f.b.b("DetectorGroup", "onDetected detectResult is NULLLLLL!!!");
                    return;
                }
                if (f.this.lq != null && f.this.lq.size() > 0) {
                    k kVar2 = null;
                    for (k kVar3 : f.this.lq) {
                        if (!f.this.a(bVar, kVar3) || !f.this.i(bVar)) {
                            kVar3 = kVar2;
                        }
                        kVar2 = kVar3;
                    }
                    if (kVar2 != null && f.this.O != null) {
                        f.this.O.add(kVar2);
                        f.this.lq.remove(kVar2);
                        if (f.this.lr != null) {
                            f.this.lr.c(new l(bVar.cl(), true));
                        }
                        com.baidu.ar.f.b.c("DetectorGroup", "onDetected detector2Add = " + kVar2.getName());
                    }
                }
                if (f.this.lr != null) {
                    f.this.lr.d(bVar);
                }
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
                com.baidu.ar.f.b.c("DetectorGroup", "setupDetctor result = " + lVar.cl() + " * " + lVar.isSuccess());
                if (f.this.lq != null && f.this.lq.size() > 0 && !lVar.isSuccess()) {
                    k kVar2 = null;
                    for (k kVar3 : f.this.lq) {
                        if (lVar.cl() == null || !lVar.cl().equals(kVar3.getName())) {
                            kVar3 = kVar2;
                        }
                        kVar2 = kVar3;
                    }
                    if (kVar2 != null) {
                        f.this.lq.remove(kVar2);
                        com.baidu.ar.f.b.c("DetectorGroup", "onSetup detector2Remove = " + kVar2.getName());
                    }
                }
                if (f.this.lr != null) {
                    f.this.lr.c(lVar);
                }
                if (eVar == null || !z) {
                    return;
                }
                eVar.a(lVar);
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
                if (f.this.lr != null) {
                    f.this.lr.d(lVar);
                }
                if (eVar != null) {
                    eVar.b(lVar);
                }
            }
        };
        if (!z) {
            kVar.a(eVar2);
        } else if (kVar instanceof j) {
            ((j) kVar).d(eVar2);
            eVar2.a(new l(kVar.getName(), true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b bVar, k kVar) {
        return bVar.cl() != null && bVar.cl().equals(kVar.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(b bVar) {
        return this.lr != null && this.lr.e(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Y() {
        boolean z;
        if (this.O != null && this.O.size() > 0) {
            for (k kVar : this.O) {
                if (kVar == null || !(kVar instanceof j) || !((j) kVar).Y()) {
                    z = false;
                    break;
                }
                while (r2.hasNext()) {
                }
            }
        }
        z = true;
        j.x(z);
        return z;
    }

    @Override // com.baidu.ar.c.k
    public void a(e eVar) {
        this.lb = eVar;
        this.lr = new d();
        this.lr.a(this.O, new e() { // from class: com.baidu.ar.c.f.1
            @Override // com.baidu.ar.c.e
            public void a(b bVar) {
                if (f.this.lb != null) {
                    f.this.lb.a(bVar);
                }
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
                if (f.this.lb != null) {
                    f.this.lb.a(lVar);
                }
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
                if (f.this.lb != null) {
                    f.this.lb.b(lVar);
                }
            }
        });
    }

    public void a(k kVar) {
        if (this.lq != null) {
            this.lq.remove(kVar);
            com.baidu.ar.f.b.c("DetectorGroup", "removeDetector detector = " + kVar.getName());
            kVar.release();
        }
        if (this.O != null) {
            this.O.remove(kVar);
            kVar.release();
        }
    }

    public void a(k kVar, e eVar) {
        if (kVar != null) {
            this.lq.add(kVar);
            com.baidu.ar.f.b.c("DetectorGroup", "addDetector detector = " + kVar.getName());
            a(kVar, eVar, false);
        }
    }

    public void b(k kVar, e eVar) {
        if (kVar != null) {
            this.lq.add(kVar);
            a(kVar, eVar, true);
        }
    }

    public boolean b(k kVar) {
        if (kVar == null) {
            return false;
        }
        return (this.O != null && this.O.contains(kVar)) || (this.lq != null && this.lq.contains(kVar));
    }

    public void c(k kVar) {
        if (kVar != null) {
            if (this.lq != null) {
                this.lq.remove(kVar);
            }
            if (this.O != null) {
                this.O.remove(kVar);
            }
            if (this.lr != null) {
                this.lr.d(new l(kVar.getName(), true));
            }
        }
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return "DetectorGroup";
    }

    public boolean isEmpty() {
        return (this.O == null || this.O.size() <= 0) && (this.lq == null || this.lq.size() <= 0);
    }

    @Override // com.baidu.ar.c.k
    public synchronized void release() {
        if (this.O != null) {
            for (k kVar : this.O) {
                kVar.release();
            }
            this.O.clear();
            this.O = null;
        }
        if (this.lr != null) {
            this.lr.release();
        }
    }
}
