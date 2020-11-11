package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d cXh;
    private List<com.baidu.swan.pms.model.e> eiq = new ArrayList();
    private List<com.baidu.swan.pms.model.e> eir = new ArrayList();
    private List<com.baidu.swan.pms.model.e> eis = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> eip = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.cXh = dVar;
        d.bbI().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.eip.add(bVar);
        }
    }

    public void bbU() {
        if (!bbV()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.bbb().getProcessName() + " startDownload: total=" + this.eip.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.eip) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.bbb().getProcessName() + " startDownload: for handler=" + bVar);
                }
                bVar.hR(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (!fVar.bbT()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.eip.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int bbL = fVar.bbL();
                    this.eip.remove(next);
                    switch (bbL) {
                        case 2:
                            this.eis.add(next.bbC().eih.eig);
                            break;
                        case 3:
                            this.eir.add(next.bbC().eih.eig);
                            break;
                        case 10:
                            this.eiq.add(next.bbC().eih.eig);
                            break;
                        default:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + bbL);
                                break;
                            }
                            break;
                    }
                }
            }
            bbV();
        }
    }

    private boolean bbV() {
        if (this.eip.isEmpty()) {
            this.cXh.aqh();
            d.bbI().d(this);
            return true;
        }
        return false;
    }
}
