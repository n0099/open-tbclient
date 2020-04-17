package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d bVM;
    private List<com.baidu.swan.pms.model.e> daW = new ArrayList();
    private List<com.baidu.swan.pms.model.e> daX = new ArrayList();
    private List<com.baidu.swan.pms.model.e> daY = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> daV = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.bVM = dVar;
        d.aCi().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.daV.add(bVar);
        }
    }

    public void aCu() {
        if (!aCv()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aBC().getProcessName() + " startDownload: total=" + this.daV.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.daV) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aBC().getProcessName() + " startDownload: for handler=" + bVar);
                }
                bVar.fV(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (!fVar.aCt()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.daV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int aCl = fVar.aCl();
                    this.daV.remove(next);
                    switch (aCl) {
                        case 2:
                            this.daY.add(next.aCd().daO.daN);
                            break;
                        case 3:
                            this.daX.add(next.aCd().daO.daN);
                            break;
                        case 10:
                            this.daW.add(next.aCd().daO.daN);
                            break;
                        default:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + aCl);
                                break;
                            }
                            break;
                    }
                }
            }
            aCv();
        }
    }

    private boolean aCv() {
        if (this.daV.isEmpty()) {
            this.bVM.WZ();
            d.aCi().d(this);
            return true;
        }
        return false;
    }
}
