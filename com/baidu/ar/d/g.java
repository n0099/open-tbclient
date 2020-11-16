package com.baidu.ar.d;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.filter.OnNeedCacheFrameListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes12.dex */
public class g {
    private com.baidu.ar.arrender.c g;
    private f mA;
    private e mB;
    private boolean mG;
    private ConcurrentHashMap<String, e> mC = new ConcurrentHashMap<>();
    private List<k> mD = Collections.synchronizedList(new ArrayList());
    private ConcurrentHashMap<String, e> mE = new ConcurrentHashMap<>();
    private long mt = 0;
    private OnNeedCacheFrameListener mF = new OnNeedCacheFrameListener() { // from class: com.baidu.ar.d.g.1
        @Override // com.baidu.ar.arplay.core.filter.OnNeedCacheFrameListener
        public boolean isNeedCacheFrame(long j) {
            if (g.this.mA == null) {
                return false;
            }
            if (g.this.mt != j) {
                g.this.mG = g.this.mA.an();
            }
            g.this.mt = j;
            return g.this.mG;
        }
    };

    public g(com.baidu.ar.arrender.c cVar, Looper looper) {
        this.g = cVar;
        this.g.a(this.mF);
        this.mA = new f(looper);
        this.mB = new e() { // from class: com.baidu.ar.d.g.2
            @Override // com.baidu.ar.d.e
            public void a(b bVar) {
                g.this.j(bVar);
                if (g.this.g != null) {
                    g.this.g.h(bVar.getTimestamp());
                }
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
                com.baidu.ar.g.b.c("DetectorManager", "mSyncDetectorGroup onSetup result = " + lVar.isSuccess());
                g.this.g(lVar);
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
                com.baidu.ar.g.b.c("DetectorManager", "mSyncDetectorGroup onRelease result = " + lVar.isSuccess());
                g.this.h(lVar);
            }
        };
        this.mA.a(this.mB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(l lVar) {
        if (lVar != null) {
            if (lVar.dd() != "DetectorGroup" && this.mC != null && this.mC.get(lVar.dd()) != null) {
                this.mC.get(lVar.dd()).a(lVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h(l lVar) {
        if (lVar != null) {
            if (lVar.dd() != "DetectorGroup" && this.mC != null && this.mC.get(lVar.dd()) != null) {
                this.mC.get(lVar.dd()).b(lVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(b bVar) {
        if (bVar != null) {
            if (bVar instanceof c) {
                Iterator<b> it = ((c) bVar).dg().iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.dd()) && this.mC != null && this.mC.get(next.dd()) != null) {
                        this.mC.get(next.dd()).a(next);
                    }
                }
            }
        }
    }

    public synchronized void a(j jVar) {
        if (jVar != null) {
            if (!TextUtils.isEmpty(jVar.getName())) {
                if (jVar.dk() && this.mD.contains(jVar)) {
                    if (this.mA.isEmpty()) {
                        this.g.l(true);
                    }
                    this.mD.remove(jVar);
                    this.mA.b(jVar, this.mE.get(jVar.getName()));
                    e remove = this.mE.remove(jVar.getName());
                    if (remove != null) {
                        this.mC.put(jVar.getName(), remove);
                    }
                } else if (!jVar.dk() && this.mA.c(jVar)) {
                    this.mA.d(jVar);
                    this.mD.add(jVar);
                    jVar.d(this.mC.get(jVar.getName()));
                    e remove2 = this.mC.remove(jVar.getName());
                    if (remove2 != null) {
                        this.mE.put(jVar.getName(), remove2);
                    }
                    if (this.mA.isEmpty()) {
                        this.g.l(false);
                    }
                }
            }
        }
    }

    public synchronized void a(k kVar) {
        if (kVar == null) {
            com.baidu.ar.g.b.b("DetectorManager", "handleRemoveDetector detector is NULLLLL!!!");
        } else if (this.mD != null && this.mD.contains(kVar)) {
            kVar.release();
            this.mD.remove(kVar);
        } else if (this.mA != null && this.mA.c(kVar)) {
            this.mA.a(kVar);
            if (this.mA.isEmpty()) {
                this.g.l(false);
            }
        }
    }

    public synchronized void a(k kVar, e eVar) {
        if (kVar != null) {
            if ((kVar instanceof j) && ((j) kVar).dk()) {
                if (this.mA.isEmpty()) {
                    this.g.l(true);
                }
                if (!this.mA.c(kVar)) {
                    this.mA.a(kVar, eVar);
                    this.mC.put(kVar.getName(), eVar);
                }
            } else if (this.mD != null && !this.mD.contains(kVar)) {
                kVar.a(eVar);
                this.mD.add(kVar);
                this.mE.put(kVar.getName(), eVar);
            }
        }
    }

    public synchronized void di() {
        if (this.mD != null) {
            for (k kVar : this.mD) {
                kVar.release();
            }
            this.mD.clear();
            this.mD = null;
        }
        if (this.mA != null) {
            this.mA.release();
            if (this.g != null) {
                this.g.l(false);
            }
            this.mA = null;
        }
        if (this.mC != null) {
            this.mC.clear();
            this.mC = null;
        }
        if (this.mE != null) {
            this.mE.clear();
            this.mE = null;
        }
        this.mB = null;
    }

    public void release() {
        di();
        this.g = null;
        this.mF = null;
    }
}
