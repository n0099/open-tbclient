package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d clb;
    private List<com.baidu.swan.pms.model.e> dqX = new ArrayList();
    private List<com.baidu.swan.pms.model.e> dqY = new ArrayList();
    private List<com.baidu.swan.pms.model.e> dqZ = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> dqW = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.clb = dVar;
        d.aHE().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.dqW.add(bVar);
        }
    }

    public void aHQ() {
        if (!aHR()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aGV().getProcessName() + " startDownload: total=" + this.dqW.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.dqW) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aGV().getProcessName() + " startDownload: for handler=" + bVar);
                }
                bVar.gl(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (!fVar.aHP()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.dqW.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int aHH = fVar.aHH();
                    this.dqW.remove(next);
                    switch (aHH) {
                        case 2:
                            this.dqZ.add(next.aHy().dqP.dqO);
                            break;
                        case 3:
                            this.dqY.add(next.aHy().dqP.dqO);
                            break;
                        case 10:
                            this.dqX.add(next.aHy().dqP.dqO);
                            break;
                        default:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + aHH);
                                break;
                            }
                            break;
                    }
                }
            }
            aHR();
        }
    }

    private boolean aHR() {
        if (this.dqW.isEmpty()) {
            this.clb.aaQ();
            d.aHE().d(this);
            return true;
        }
        return false;
    }
}
