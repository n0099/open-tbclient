package com.baidu.ar.d;

import android.os.Looper;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class f implements k {
    private e mg;
    private d mw;
    private List<k> N = new CopyOnWriteArrayList();
    private List<k> mv = new CopyOnWriteArrayList();

    public f(Looper looper) {
        this.mw = new d(looper);
    }

    private void a(k kVar, final e eVar, final boolean z) {
        com.baidu.ar.g.b.c("DetectorGroup", "setupDetctor detector.getName() = " + kVar.getName());
        e eVar2 = new e() { // from class: com.baidu.ar.d.f.2
            @Override // com.baidu.ar.d.e
            public void a(b bVar) {
                if (bVar == null) {
                    com.baidu.ar.g.b.b("DetectorGroup", "onDetected detectResult is NULLLLLL!!!");
                    return;
                }
                if (f.this.mv != null && f.this.mv.size() > 0) {
                    k kVar2 = null;
                    for (k kVar3 : f.this.mv) {
                        if (!f.this.a(bVar, kVar3) || !f.this.i(bVar)) {
                            kVar3 = kVar2;
                        }
                        kVar2 = kVar3;
                    }
                    if (kVar2 != null && f.this.N != null) {
                        f.this.N.add(kVar2);
                        f.this.mv.remove(kVar2);
                        com.baidu.ar.g.b.c("DetectorGroup", "onDetected detector2Add = " + kVar2.getName());
                    }
                }
                if (f.this.mw != null) {
                    f.this.mw.d(bVar);
                }
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
                com.baidu.ar.g.b.c("DetectorGroup", "setupDetctor result = " + lVar.dd() + " * " + lVar.isSuccess());
                if (f.this.mv != null && f.this.mv.size() > 0 && !lVar.isSuccess()) {
                    k kVar2 = null;
                    for (k kVar3 : f.this.mv) {
                        if (lVar.dd() == null || !lVar.dd().equals(kVar3.getName())) {
                            kVar3 = kVar2;
                        }
                        kVar2 = kVar3;
                    }
                    if (kVar2 != null) {
                        f.this.mv.remove(kVar2);
                        com.baidu.ar.g.b.c("DetectorGroup", "onSetup detector2Remove = " + kVar2.getName());
                    }
                }
                if (f.this.mw != null) {
                    f.this.mw.c(lVar);
                }
                if (eVar == null || !z) {
                    return;
                }
                eVar.a(lVar);
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
                if (f.this.mw != null) {
                    f.this.mw.d(lVar);
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
        return bVar.dd() != null && bVar.dd().equals(kVar.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(b bVar) {
        return this.mw != null && this.mw.e(bVar);
    }

    @Override // com.baidu.ar.d.k
    public void a(e eVar) {
        this.mg = eVar;
        this.mw.a(this.N, new e() { // from class: com.baidu.ar.d.f.1
            @Override // com.baidu.ar.d.e
            public void a(b bVar) {
                if (f.this.mg != null) {
                    f.this.mg.a(bVar);
                }
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
                if (f.this.mg != null) {
                    f.this.mg.a(lVar);
                }
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
                if (f.this.mg != null) {
                    f.this.mg.b(lVar);
                }
            }
        });
    }

    public void a(k kVar) {
        if (this.mv != null && this.mv.contains(kVar)) {
            this.mv.remove(kVar);
            com.baidu.ar.g.b.c("DetectorGroup", "removeDetector detector = " + kVar.getName());
            kVar.release();
        } else if (this.N == null || !this.N.contains(kVar)) {
        } else {
            this.N.remove(kVar);
            kVar.release();
        }
    }

    public void a(k kVar, e eVar) {
        if (kVar != null) {
            this.mv.add(kVar);
            com.baidu.ar.g.b.c("DetectorGroup", "addDetector detector = " + kVar.getName());
            a(kVar, eVar, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean an() {
        boolean z;
        if (this.N != null && this.N.size() > 0) {
            for (k kVar : this.N) {
                if (kVar == null || !(kVar instanceof j) || !((j) kVar).an()) {
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

    public void b(k kVar, e eVar) {
        if (kVar != null) {
            this.mv.add(kVar);
            a(kVar, eVar, true);
        }
    }

    public boolean c(k kVar) {
        if (kVar == null) {
            return false;
        }
        return (this.N != null && this.N.contains(kVar)) || (this.mv != null && this.mv.contains(kVar));
    }

    public void d(k kVar) {
        if (kVar != null) {
            if (this.mv != null) {
                this.mv.remove(kVar);
            }
            if (this.N != null) {
                this.N.remove(kVar);
            }
            if (this.mw != null) {
                this.mw.d(new l(kVar.getName(), true));
            }
        }
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        return "DetectorGroup";
    }

    public boolean isEmpty() {
        return (this.N == null || this.N.size() <= 0) && (this.mv == null || this.mv.size() <= 0);
    }

    @Override // com.baidu.ar.d.k
    public synchronized void release() {
        if (this.N != null) {
            for (k kVar : this.N) {
                kVar.release();
            }
            this.N.clear();
            this.N = null;
        }
        if (this.mw != null) {
            this.mw.release();
        }
    }
}
