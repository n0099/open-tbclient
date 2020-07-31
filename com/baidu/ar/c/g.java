package com.baidu.ar.c;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.filter.OnNeedCacheFrameListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class g {
    private com.baidu.ar.arrender.c g;
    private f lS;
    private e lT;
    private boolean lY;
    private ConcurrentHashMap<String, e> lU = new ConcurrentHashMap<>();
    private List<k> lV = Collections.synchronizedList(new ArrayList());
    private ConcurrentHashMap<String, e> lW = new ConcurrentHashMap<>();
    private long lL = 0;
    private OnNeedCacheFrameListener lX = new OnNeedCacheFrameListener() { // from class: com.baidu.ar.c.g.1
        @Override // com.baidu.ar.arplay.core.filter.OnNeedCacheFrameListener
        public boolean isNeedCacheFrame(long j) {
            if (g.this.lS == null) {
                return false;
            }
            if (g.this.lL != j) {
                g.this.lY = g.this.lS.am();
            }
            g.this.lL = j;
            return g.this.lY;
        }
    };

    public g(com.baidu.ar.arrender.c cVar, Looper looper) {
        this.g = cVar;
        this.g.a(this.lX);
        this.lS = new f(looper);
        this.lT = new e() { // from class: com.baidu.ar.c.g.2
            @Override // com.baidu.ar.c.e
            public void a(b bVar) {
                g.this.j(bVar);
                if (g.this.g != null) {
                    g.this.g.h(bVar.getTimestamp());
                }
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
                com.baidu.ar.f.b.c("DetectorManager", "mSyncDetectorGroup onSetup result = " + lVar.isSuccess());
                g.this.g(lVar);
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
                com.baidu.ar.f.b.c("DetectorManager", "mSyncDetectorGroup onRelease result = " + lVar.isSuccess());
                g.this.h(lVar);
            }
        };
        this.lS.a(this.lT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(l lVar) {
        if (lVar == null || lVar.cD() == "DetectorGroup" || this.lU == null || this.lU.get(lVar.cD()) == null) {
            return;
        }
        this.lU.get(lVar.cD()).a(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(l lVar) {
        if (lVar == null || lVar.cD() == "DetectorGroup" || this.lU == null || this.lU.get(lVar.cD()) == null) {
            return;
        }
        this.lU.get(lVar.cD()).b(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(b bVar) {
        if (bVar == null || !(bVar instanceof c)) {
            return;
        }
        Iterator<b> it = ((c) bVar).cG().iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && !TextUtils.isEmpty(next.cD()) && this.lU != null && this.lU.get(next.cD()) != null) {
                this.lU.get(next.cD()).a(next);
            }
        }
    }

    public void a(j jVar) {
        if (jVar == null || TextUtils.isEmpty(jVar.getName())) {
            return;
        }
        if (jVar.cK() && this.lV.contains(jVar)) {
            if (this.lS.isEmpty()) {
                this.g.k(true);
            }
            this.lV.remove(jVar);
            this.lS.b(jVar, this.lW.get(jVar.getName()));
            e remove = this.lW.remove(jVar.getName());
            if (remove != null) {
                this.lU.put(jVar.getName(), remove);
            }
        } else if (jVar.cK() || !this.lS.c(jVar)) {
        } else {
            this.lS.d(jVar);
            this.lV.add(jVar);
            jVar.d(this.lU.get(jVar.getName()));
            e remove2 = this.lU.remove(jVar.getName());
            if (remove2 != null) {
                this.lW.put(jVar.getName(), remove2);
            }
            if (this.lS.isEmpty()) {
                this.g.k(false);
            }
        }
    }

    public void a(k kVar) {
        if (kVar == null) {
            com.baidu.ar.f.b.b("DetectorManager", "handleRemoveDetector detector is NULLLLL!!!");
        } else if (this.lV != null && this.lV.contains(kVar)) {
            kVar.release();
            this.lV.remove(kVar);
        } else if (this.lS == null || !this.lS.c(kVar)) {
        } else {
            this.lS.a(kVar);
            if (this.lS.isEmpty()) {
                this.g.k(false);
            }
        }
    }

    public void a(k kVar, e eVar) {
        if (kVar == null) {
            return;
        }
        if ((kVar instanceof j) && ((j) kVar).cK()) {
            if (this.lS.isEmpty()) {
                this.g.k(true);
            }
            if (this.lS.c(kVar)) {
                return;
            }
            this.lS.a(kVar, eVar);
            this.lU.put(kVar.getName(), eVar);
        } else if (this.lV == null || this.lV.contains(kVar)) {
        } else {
            kVar.a(eVar);
            this.lV.add(kVar);
            this.lW.put(kVar.getName(), eVar);
        }
    }

    public void cI() {
        if (this.lV != null) {
            for (k kVar : this.lV) {
                kVar.release();
            }
            this.lV.clear();
            this.lV = null;
        }
        if (this.lS != null) {
            this.lS.release();
            if (this.g != null) {
                this.g.k(false);
            }
            this.lS = null;
        }
        if (this.lU != null) {
            this.lU.clear();
            this.lU = null;
        }
        if (this.lW != null) {
            this.lW.clear();
            this.lW = null;
        }
        this.lT = null;
    }

    public void release() {
        cI();
        this.g = null;
        this.lX = null;
    }
}
