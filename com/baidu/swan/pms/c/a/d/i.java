package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes14.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d cuI;
    private List<com.baidu.swan.pms.model.e> dFT = new ArrayList();
    private List<com.baidu.swan.pms.model.e> dFU = new ArrayList();
    private List<com.baidu.swan.pms.model.e> dFV = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> dFS = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.cuI = dVar;
        d.aTU().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.dFS.add(bVar);
        }
    }

    public void aUg() {
        if (!aUh()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aTn().getProcessName() + " startDownload: total=" + this.dFS.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.dFS) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aTn().getProcessName() + " startDownload: for handler=" + bVar);
                }
                bVar.ha(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (!fVar.aUf()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.dFS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int aTX = fVar.aTX();
                    this.dFS.remove(next);
                    switch (aTX) {
                        case 2:
                            this.dFV.add(next.aTO().dFK.dFJ);
                            break;
                        case 3:
                            this.dFU.add(next.aTO().dFK.dFJ);
                            break;
                        case 10:
                            this.dFT.add(next.aTO().dFK.dFJ);
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
        if (this.dFS.isEmpty()) {
            this.cuI.air();
            d.aTU().d(this);
            return true;
        }
        return false;
    }
}
