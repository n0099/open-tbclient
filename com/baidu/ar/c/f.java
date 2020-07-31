package com.baidu.ar.c;

import android.os.Looper;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class f implements k {
    private List<k> N = new CopyOnWriteArrayList();
    private List<k> lN = new CopyOnWriteArrayList();
    private d lO;
    private e ly;

    public f(Looper looper) {
        this.lO = new d(looper);
    }

    private void a(k kVar, final e eVar, final boolean z) {
        com.baidu.ar.f.b.c("DetectorGroup", "setupDetctor detector.getName() = " + kVar.getName());
        e eVar2 = new e() { // from class: com.baidu.ar.c.f.2
            @Override // com.baidu.ar.c.e
            public void a(b bVar) {
                if (bVar == null) {
                    com.baidu.ar.f.b.b("DetectorGroup", "onDetected detectResult is NULLLLLL!!!");
                    return;
                }
                if (f.this.lN != null && f.this.lN.size() > 0) {
                    k kVar2 = null;
                    for (k kVar3 : f.this.lN) {
                        if (!f.this.a(bVar, kVar3) || !f.this.i(bVar)) {
                            kVar3 = kVar2;
                        }
                        kVar2 = kVar3;
                    }
                    if (kVar2 != null && f.this.N != null) {
                        f.this.N.add(kVar2);
                        f.this.lN.remove(kVar2);
                        com.baidu.ar.f.b.c("DetectorGroup", "onDetected detector2Add = " + kVar2.getName());
                    }
                }
                if (f.this.lO != null) {
                    f.this.lO.d(bVar);
                }
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
                com.baidu.ar.f.b.c("DetectorGroup", "setupDetctor result = " + lVar.cD() + " * " + lVar.isSuccess());
                if (f.this.lN != null && f.this.lN.size() > 0 && !lVar.isSuccess()) {
                    k kVar2 = null;
                    for (k kVar3 : f.this.lN) {
                        if (lVar.cD() == null || !lVar.cD().equals(kVar3.getName())) {
                            kVar3 = kVar2;
                        }
                        kVar2 = kVar3;
                    }
                    if (kVar2 != null) {
                        f.this.lN.remove(kVar2);
                        com.baidu.ar.f.b.c("DetectorGroup", "onSetup detector2Remove = " + kVar2.getName());
                    }
                }
                if (f.this.lO != null) {
                    f.this.lO.c(lVar);
                }
                if (eVar == null || !z) {
                    return;
                }
                eVar.a(lVar);
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
                if (f.this.lO != null) {
                    f.this.lO.d(lVar);
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
        return bVar.cD() != null && bVar.cD().equals(kVar.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(b bVar) {
        return this.lO != null && this.lO.e(bVar);
    }

    @Override // com.baidu.ar.c.k
    public void a(e eVar) {
        this.ly = eVar;
        this.lO.a(this.N, new e() { // from class: com.baidu.ar.c.f.1
            @Override // com.baidu.ar.c.e
            public void a(b bVar) {
                if (f.this.ly != null) {
                    f.this.ly.a(bVar);
                }
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
                if (f.this.ly != null) {
                    f.this.ly.a(lVar);
                }
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
                if (f.this.ly != null) {
                    f.this.ly.b(lVar);
                }
            }
        });
    }

    public void a(k kVar) {
        if (this.lN != null && this.lN.contains(kVar)) {
            this.lN.remove(kVar);
            com.baidu.ar.f.b.c("DetectorGroup", "removeDetector detector = " + kVar.getName());
            kVar.release();
        } else if (this.N == null || !this.N.contains(kVar)) {
        } else {
            this.N.remove(kVar);
            kVar.release();
        }
    }

    public void a(k kVar, e eVar) {
        if (kVar != null) {
            this.lN.add(kVar);
            com.baidu.ar.f.b.c("DetectorGroup", "addDetector detector = " + kVar.getName());
            a(kVar, eVar, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean am() {
        boolean z;
        if (this.N != null && this.N.size() > 0) {
            for (k kVar : this.N) {
                if (kVar == null || !(kVar instanceof j) || !((j) kVar).am()) {
                    z = false;
                    break;
                }
                while (r2.hasNext()) {
                }
            }
        }
        z = true;
        j.w(z);
        return z;
    }

    public void b(k kVar, e eVar) {
        if (kVar != null) {
            this.lN.add(kVar);
            a(kVar, eVar, true);
        }
    }

    public boolean c(k kVar) {
        if (kVar == null) {
            return false;
        }
        return (this.N != null && this.N.contains(kVar)) || (this.lN != null && this.lN.contains(kVar));
    }

    public void d(k kVar) {
        if (kVar != null) {
            if (this.lN != null) {
                this.lN.remove(kVar);
            }
            if (this.N != null) {
                this.N.remove(kVar);
            }
            if (this.lO != null) {
                this.lO.d(new l(kVar.getName(), true));
            }
        }
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return "DetectorGroup";
    }

    public boolean isEmpty() {
        return (this.N == null || this.N.size() <= 0) && (this.lN == null || this.lN.size() <= 0);
    }

    @Override // com.baidu.ar.c.k
    public synchronized void release() {
        if (this.N != null) {
            for (k kVar : this.N) {
                kVar.release();
            }
            this.N.clear();
            this.N = null;
        }
        if (this.lO != null) {
            this.lO.release();
        }
    }
}
