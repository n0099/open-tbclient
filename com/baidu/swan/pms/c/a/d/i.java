package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d cRo;
    private List<com.baidu.swan.pms.model.e> ecy = new ArrayList();
    private List<com.baidu.swan.pms.model.e> ecz = new ArrayList();
    private List<com.baidu.swan.pms.model.e> ecA = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> ecx = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.cRo = dVar;
        d.aZi().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.ecx.add(bVar);
        }
    }

    public void aZu() {
        if (!aZv()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aYB().getProcessName() + " startDownload: total=" + this.ecx.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.ecx) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aYB().getProcessName() + " startDownload: for handler=" + bVar);
                }
                bVar.hI(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (!fVar.aZt()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.ecx.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int aZl = fVar.aZl();
                    this.ecx.remove(next);
                    switch (aZl) {
                        case 2:
                            this.ecA.add(next.aZc().ecp.eco);
                            break;
                        case 3:
                            this.ecz.add(next.aZc().ecp.eco);
                            break;
                        case 10:
                            this.ecy.add(next.aZc().ecp.eco);
                            break;
                        default:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + aZl);
                                break;
                            }
                            break;
                    }
                }
            }
            aZv();
        }
    }

    private boolean aZv() {
        if (this.ecx.isEmpty()) {
            this.cRo.anG();
            d.aZi().d(this);
            return true;
        }
        return false;
    }
}
