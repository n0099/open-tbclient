package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d cIS;
    private List<com.baidu.swan.pms.model.e> dUc = new ArrayList();
    private List<com.baidu.swan.pms.model.e> dUd = new ArrayList();
    private List<com.baidu.swan.pms.model.e> dUe = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> dUb = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.cIS = dVar;
        d.aXp().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.dUb.add(bVar);
        }
    }

    public void aXB() {
        if (!aXC()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aWI().getProcessName() + " startDownload: total=" + this.dUb.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.dUb) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aWI().getProcessName() + " startDownload: for handler=" + bVar);
                }
                bVar.hv(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (!fVar.aXA()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.dUb.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int aXs = fVar.aXs();
                    this.dUb.remove(next);
                    switch (aXs) {
                        case 2:
                            this.dUe.add(next.aXj().dTT.dTS);
                            break;
                        case 3:
                            this.dUd.add(next.aXj().dTT.dTS);
                            break;
                        case 10:
                            this.dUc.add(next.aXj().dTT.dTS);
                            break;
                        default:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + aXs);
                                break;
                            }
                            break;
                    }
                }
            }
            aXC();
        }
    }

    private boolean aXC() {
        if (this.dUb.isEmpty()) {
            this.cIS.alM();
            d.aXp().d(this);
            return true;
        }
        return false;
    }
}
