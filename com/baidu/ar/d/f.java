package com.baidu.ar.d;

import android.os.Looper;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public class f implements k {
    private List<k> O = new CopyOnWriteArrayList();
    private List<k> mK = new CopyOnWriteArrayList();
    private d mL;
    private e mv;

    public f(Looper looper) {
        this.mL = new d(looper);
    }

    private void a(k kVar, final e eVar, final boolean z) {
        com.baidu.ar.h.b.c("DetectorGroup", "setupDetctor detector.getName() = " + kVar.getName());
        e eVar2 = new e() { // from class: com.baidu.ar.d.f.2
            @Override // com.baidu.ar.d.e
            public void a(b bVar) {
                if (bVar == null) {
                    com.baidu.ar.h.b.b("DetectorGroup", "onDetected detectResult is NULLLLLL!!!");
                    return;
                }
                if (f.this.mK != null && f.this.mK.size() > 0) {
                    k kVar2 = null;
                    for (k kVar3 : f.this.mK) {
                        if (!f.this.a(bVar, kVar3) || !f.this.i(bVar)) {
                            kVar3 = kVar2;
                        }
                        kVar2 = kVar3;
                    }
                    if (kVar2 != null && f.this.O != null) {
                        f.this.O.add(kVar2);
                        f.this.mK.remove(kVar2);
                        com.baidu.ar.h.b.c("DetectorGroup", "onDetected detector2Add = " + kVar2.getName());
                    }
                }
                if (f.this.mL != null) {
                    f.this.mL.d(bVar);
                }
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
                com.baidu.ar.h.b.c("DetectorGroup", "setupDetctor result = " + lVar.dc() + " * " + lVar.isSuccess());
                if (f.this.mK != null && f.this.mK.size() > 0 && !lVar.isSuccess()) {
                    k kVar2 = null;
                    for (k kVar3 : f.this.mK) {
                        if (lVar.dc() == null || !lVar.dc().equals(kVar3.getName())) {
                            kVar3 = kVar2;
                        }
                        kVar2 = kVar3;
                    }
                    if (kVar2 != null) {
                        f.this.mK.remove(kVar2);
                        com.baidu.ar.h.b.c("DetectorGroup", "onSetup detector2Remove = " + kVar2.getName());
                    }
                }
                if (f.this.mL != null) {
                    f.this.mL.c(lVar);
                }
                if (eVar == null || !z) {
                    return;
                }
                eVar.a(lVar);
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
                if (f.this.mL != null) {
                    f.this.mL.d(lVar);
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
        return bVar.dc() != null && bVar.dc().equals(kVar.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(b bVar) {
        return this.mL != null && this.mL.e(bVar);
    }

    @Override // com.baidu.ar.d.k
    public void a(e eVar) {
        this.mv = eVar;
        this.mL.a(this.O, new e() { // from class: com.baidu.ar.d.f.1
            @Override // com.baidu.ar.d.e
            public void a(b bVar) {
                if (f.this.mv != null) {
                    f.this.mv.a(bVar);
                }
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
                if (f.this.mv != null) {
                    f.this.mv.a(lVar);
                }
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
                if (f.this.mv != null) {
                    f.this.mv.b(lVar);
                }
            }
        });
    }

    public void a(k kVar) {
        if (this.mK != null && this.mK.contains(kVar)) {
            this.mK.remove(kVar);
            com.baidu.ar.h.b.c("DetectorGroup", "removeDetector detector = " + kVar.getName());
            kVar.release();
        } else if (this.O == null || !this.O.contains(kVar)) {
        } else {
            this.O.remove(kVar);
            kVar.release();
        }
    }

    public void a(k kVar, e eVar) {
        if (kVar != null) {
            this.mK.add(kVar);
            com.baidu.ar.h.b.c("DetectorGroup", "addDetector detector = " + kVar.getName());
            a(kVar, eVar, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean ap() {
        boolean z;
        if (this.O != null && this.O.size() > 0) {
            for (k kVar : this.O) {
                if (kVar == null || !(kVar instanceof j) || !((j) kVar).ap()) {
                    z = false;
                    break;
                }
                while (r2.hasNext()) {
                }
            }
        }
        z = true;
        j.v(z);
        return z;
    }

    public void b(k kVar, e eVar) {
        if (kVar != null) {
            this.mK.add(kVar);
            a(kVar, eVar, true);
        }
    }

    public boolean c(k kVar) {
        if (kVar == null) {
            return false;
        }
        return (this.O != null && this.O.contains(kVar)) || (this.mK != null && this.mK.contains(kVar));
    }

    public void d(k kVar) {
        if (kVar != null) {
            if (this.mK != null) {
                this.mK.remove(kVar);
            }
            if (this.O != null) {
                this.O.remove(kVar);
            }
            if (this.mL != null) {
                this.mL.d(new l(kVar.getName(), true));
            }
        }
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        return "DetectorGroup";
    }

    public boolean isEmpty() {
        return (this.O == null || this.O.size() <= 0) && (this.mK == null || this.mK.size() <= 0);
    }

    @Override // com.baidu.ar.d.k
    public synchronized void release() {
        if (this.O != null) {
            for (k kVar : this.O) {
                kVar.release();
            }
            this.O.clear();
            this.O = null;
        }
        if (this.mL != null) {
            this.mL.release();
        }
    }
}
