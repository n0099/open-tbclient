package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d btj;
    private List<com.baidu.swan.pms.model.e> cxL = new ArrayList();
    private List<com.baidu.swan.pms.model.e> cxM = new ArrayList();
    private List<com.baidu.swan.pms.model.e> cxN = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> cxK = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.btj = dVar;
        d.arF().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.cxK.add(bVar);
        }
    }

    public void startDownload() {
        if (!arR()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aqZ().getProcessName() + " startDownload: total=" + this.cxK.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.cxK) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aqZ().getProcessName() + " startDownload: for handler=" + bVar);
                }
                bVar.eQ(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (!fVar.arQ()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.cxK.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int arI = fVar.arI();
                    this.cxK.remove(next);
                    switch (arI) {
                        case 2:
                            this.cxN.add(next.arA().cxD.cxC);
                            break;
                        case 3:
                            this.cxM.add(next.arA().cxD.cxC);
                            break;
                        case 10:
                            this.cxL.add(next.arA().cxD.cxC);
                            break;
                        default:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + arI);
                                break;
                            }
                            break;
                    }
                }
            }
            arR();
        }
    }

    private boolean arR() {
        if (this.cxK.isEmpty()) {
            this.btj.MR();
            d.arF().d(this);
            return true;
        }
        return false;
    }
}
