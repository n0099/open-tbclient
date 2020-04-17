package com.baidu.ar.c;

import android.text.TextUtils;
import com.baidu.ar.arplay.core.filter.OnNeedCacheFrameListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class g {
    private com.baidu.ar.arrender.c f;
    private boolean lB;
    private f lv;
    private e lw;
    private ConcurrentHashMap<String, e> lx = new ConcurrentHashMap<>();
    private List<k> ly = Collections.synchronizedList(new ArrayList());
    private ConcurrentHashMap<String, e> lz = new ConcurrentHashMap<>();
    private long lo = 0;
    private OnNeedCacheFrameListener lA = new OnNeedCacheFrameListener() { // from class: com.baidu.ar.c.g.1
        @Override // com.baidu.ar.arplay.core.filter.OnNeedCacheFrameListener
        public boolean isNeedCacheFrame(long j) {
            if (g.this.lv == null) {
                return false;
            }
            if (g.this.lo != j) {
                g.this.lB = g.this.lv.Y();
            }
            g.this.lo = j;
            return g.this.lB;
        }
    };

    public g(com.baidu.ar.arrender.c cVar) {
        this.f = cVar;
        this.f.a(this.lA);
        this.lv = new f();
        this.lw = new e() { // from class: com.baidu.ar.c.g.2
            @Override // com.baidu.ar.c.e
            public void a(b bVar) {
                g.this.j(bVar);
                if (g.this.f != null) {
                    g.this.f.h(bVar.getTimestamp());
                }
            }

            @Override // com.baidu.ar.c.e
            public void a(l lVar) {
                com.baidu.ar.f.b.c("DetectorManager", "mSyncDetectorGroup onSetup result = " + lVar.isSuccess());
            }

            @Override // com.baidu.ar.c.e
            public void b(l lVar) {
                com.baidu.ar.f.b.c("DetectorManager", "mSyncDetectorGroup onRelease result = " + lVar.isSuccess());
            }
        };
        this.lv.a(this.lw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(b bVar) {
        if (bVar == null || !(bVar instanceof c)) {
            return;
        }
        Iterator<b> it = ((c) bVar).co().iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && !TextUtils.isEmpty(next.cl()) && this.lx != null && this.lx.get(next.cl()) != null) {
                this.lx.get(next.cl()).a(next);
            }
        }
    }

    public void a(j jVar) {
        if (jVar == null || TextUtils.isEmpty(jVar.getName())) {
            return;
        }
        if (jVar.cu() && this.ly.contains(jVar)) {
            if (this.lv.isEmpty()) {
                this.f.l(true);
            }
            this.ly.remove(jVar);
            this.lv.b(jVar, this.lz.get(jVar.getName()));
            e remove = this.lz.remove(jVar.getName());
            if (remove != null) {
                this.lx.put(jVar.getName(), remove);
            }
        } else if (jVar.cu() || !this.lv.b(jVar)) {
        } else {
            this.lv.c(jVar);
            this.ly.add(jVar);
            jVar.d(this.lx.get(jVar.getName()));
            e remove2 = this.lx.remove(jVar.getName());
            if (remove2 != null) {
                this.lz.put(jVar.getName(), remove2);
            }
            if (this.lv.isEmpty()) {
                this.f.l(false);
            }
        }
    }

    public void a(k kVar) {
        if (kVar == null) {
            com.baidu.ar.f.b.b("DetectorManager", "handleRemoveDetector detector is NULLLLL!!!");
        } else if (this.ly != null && this.ly.contains(kVar)) {
            kVar.release();
            this.ly.remove(kVar);
        } else if (this.lv == null || !this.lv.b(kVar)) {
        } else {
            this.lv.a(kVar);
            if (this.lv.isEmpty()) {
                this.f.l(false);
            }
        }
    }

    public void a(k kVar, e eVar) {
        if (kVar == null) {
            return;
        }
        if ((kVar instanceof j) && ((j) kVar).cu()) {
            if (this.lv.isEmpty()) {
                this.f.l(true);
            }
            if (this.lv.b(kVar)) {
                return;
            }
            this.lv.a(kVar, eVar);
            this.lx.put(kVar.getName(), eVar);
        } else if (this.ly == null || this.ly.contains(kVar)) {
        } else {
            kVar.a(eVar);
            this.ly.add(kVar);
            this.lz.put(kVar.getName(), eVar);
        }
    }

    public void cs() {
        if (this.ly != null) {
            for (k kVar : this.ly) {
                kVar.release();
            }
            this.ly.clear();
            this.ly = null;
        }
        if (this.lv != null) {
            this.lv.release();
            if (this.f != null) {
                this.f.l(false);
            }
            this.lv = null;
        }
        if (this.lx != null) {
            this.lx.clear();
            this.lx = null;
        }
        if (this.lz != null) {
            this.lz.clear();
            this.lz = null;
        }
        this.lw = null;
    }

    public void release() {
        cs();
        this.f = null;
        this.lA = null;
    }
}
