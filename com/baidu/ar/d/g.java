package com.baidu.ar.d;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.renderer.OnNeedCacheFrameListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class g {
    private com.baidu.ar.arrender.c g;
    private f mP;
    private e mQ;
    private boolean mV;
    private ConcurrentHashMap<String, e> mR = new ConcurrentHashMap<>();
    private List<k> mS = Collections.synchronizedList(new ArrayList());
    private ConcurrentHashMap<String, e> mT = new ConcurrentHashMap<>();
    private long mI = 0;
    private OnNeedCacheFrameListener mU = new OnNeedCacheFrameListener() { // from class: com.baidu.ar.d.g.1
        @Override // com.baidu.ar.arplay.core.renderer.OnNeedCacheFrameListener
        public boolean isNeedCacheFrame(long j) {
            if (g.this.mP == null) {
                return false;
            }
            if (g.this.mI != j) {
                g.this.mV = g.this.mP.ap();
            }
            g.this.mI = j;
            return g.this.mV;
        }
    };

    public g(com.baidu.ar.arrender.c cVar, Looper looper) {
        this.g = cVar;
        this.g.a(this.mU);
        this.mP = new f(looper);
        this.mQ = new e() { // from class: com.baidu.ar.d.g.2
            @Override // com.baidu.ar.d.e
            public void a(b bVar) {
                g.this.j(bVar);
                if (g.this.g != null) {
                    g.this.g.f(bVar.getTimestamp());
                }
            }

            @Override // com.baidu.ar.d.e
            public void a(l lVar) {
                com.baidu.ar.h.b.c("DetectorManager", "mSyncDetectorGroup onSetup result = " + lVar.isSuccess());
                g.this.g(lVar);
            }

            @Override // com.baidu.ar.d.e
            public void b(l lVar) {
                com.baidu.ar.h.b.c("DetectorManager", "mSyncDetectorGroup onRelease result = " + lVar.isSuccess());
                g.this.h(lVar);
            }
        };
        this.mP.a(this.mQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(l lVar) {
        if (lVar != null) {
            if (lVar.dc() != "DetectorGroup" && this.mR != null && this.mR.get(lVar.dc()) != null) {
                this.mR.get(lVar.dc()).a(lVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h(l lVar) {
        if (lVar != null) {
            if (lVar.dc() != "DetectorGroup" && this.mR != null && this.mR.get(lVar.dc()) != null) {
                this.mR.get(lVar.dc()).b(lVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j(b bVar) {
        if (bVar != null) {
            if (bVar instanceof c) {
                Iterator<b> it = ((c) bVar).df().iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.dc()) && this.mR != null && this.mR.get(next.dc()) != null) {
                        this.mR.get(next.dc()).a(next);
                    }
                }
            }
        }
    }

    public synchronized void a(j jVar) {
        if (jVar != null) {
            if (!TextUtils.isEmpty(jVar.getName())) {
                if (jVar.dj() && this.mS.contains(jVar)) {
                    if (this.mP.isEmpty()) {
                        this.g.j(true);
                    }
                    this.mS.remove(jVar);
                    this.mP.b(jVar, this.mT.get(jVar.getName()));
                    e remove = this.mT.remove(jVar.getName());
                    if (remove != null) {
                        this.mR.put(jVar.getName(), remove);
                    }
                } else if (!jVar.dj() && this.mP.c(jVar)) {
                    this.mP.d(jVar);
                    this.mS.add(jVar);
                    jVar.d(this.mR.get(jVar.getName()));
                    e remove2 = this.mR.remove(jVar.getName());
                    if (remove2 != null) {
                        this.mT.put(jVar.getName(), remove2);
                    }
                    if (this.mP.isEmpty()) {
                        this.g.j(false);
                    }
                }
            }
        }
    }

    public synchronized void a(k kVar) {
        if (kVar == null) {
            com.baidu.ar.h.b.b("DetectorManager", "handleRemoveDetector detector is NULLLLL!!!");
        } else if (this.mS != null && this.mS.contains(kVar)) {
            kVar.release();
            this.mS.remove(kVar);
        } else if (this.mP != null && this.mP.c(kVar)) {
            this.mP.a(kVar);
            if (this.mP.isEmpty()) {
                this.g.j(false);
            }
        }
    }

    public synchronized void a(k kVar, e eVar) {
        if (kVar != null) {
            if ((kVar instanceof j) && ((j) kVar).dj()) {
                if (this.mP.isEmpty()) {
                    this.g.j(true);
                }
                if (!this.mP.c(kVar)) {
                    this.mP.a(kVar, eVar);
                    this.mR.put(kVar.getName(), eVar);
                }
            } else if (this.mS != null && !this.mS.contains(kVar)) {
                kVar.a(eVar);
                this.mS.add(kVar);
                this.mT.put(kVar.getName(), eVar);
            }
        }
    }

    public synchronized void dh() {
        if (this.mS != null) {
            for (k kVar : this.mS) {
                kVar.release();
            }
            this.mS.clear();
            this.mS = null;
        }
        if (this.mP != null) {
            this.mP.release();
            if (this.g != null) {
                this.g.j(false);
            }
            this.mP = null;
        }
        if (this.mR != null) {
            this.mR.clear();
            this.mR = null;
        }
        if (this.mT != null) {
            this.mT.clear();
            this.mT = null;
        }
        this.mQ = null;
    }

    public void release() {
        dh();
        this.g = null;
        this.mU = null;
    }
}
