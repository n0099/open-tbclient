package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes14.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d cuM;
    private List<com.baidu.swan.pms.model.e> dFX = new ArrayList();
    private List<com.baidu.swan.pms.model.e> dFY = new ArrayList();
    private List<com.baidu.swan.pms.model.e> dFZ = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> dFW = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.cuM = dVar;
        d.aTU().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.dFW.add(bVar);
        }
    }

    public void aUg() {
        if (!aUh()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aTn().getProcessName() + " startDownload: total=" + this.dFW.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.dFW) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aTn().getProcessName() + " startDownload: for handler=" + bVar);
                }
                bVar.hb(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (!fVar.aUf()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.dFW.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int aTX = fVar.aTX();
                    this.dFW.remove(next);
                    switch (aTX) {
                        case 2:
                            this.dFZ.add(next.aTO().dFO.dFN);
                            break;
                        case 3:
                            this.dFY.add(next.aTO().dFO.dFN);
                            break;
                        case 10:
                            this.dFX.add(next.aTO().dFO.dFN);
                            break;
                        default:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + aTX);
                                break;
                            }
                            break;
                    }
                }
            }
            aUh();
        }
    }

    private boolean aUh() {
        if (this.dFW.isEmpty()) {
            this.cuM.air();
            d.aTU().d(this);
            return true;
        }
        return false;
    }
}
