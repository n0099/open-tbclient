package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d cVx;
    private List<com.baidu.swan.pms.model.e> egJ = new ArrayList();
    private List<com.baidu.swan.pms.model.e> egK = new ArrayList();
    private List<com.baidu.swan.pms.model.e> egL = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> egI = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.cVx = dVar;
        d.bbb().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.egI.add(bVar);
        }
    }

    public void bbn() {
        if (!bbo()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.bau().getProcessName() + " startDownload: total=" + this.egI.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.egI) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.bau().getProcessName() + " startDownload: for handler=" + bVar);
                }
                bVar.hU(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (!fVar.bbm()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.egI.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int bbe = fVar.bbe();
                    this.egI.remove(next);
                    switch (bbe) {
                        case 2:
                            this.egL.add(next.baV().egA.egz);
                            break;
                        case 3:
                            this.egK.add(next.baV().egA.egz);
                            break;
                        case 10:
                            this.egJ.add(next.baV().egA.egz);
                            break;
                        default:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + bbe);
                                break;
                            }
                            break;
                    }
                }
            }
            bbo();
        }
    }

    private boolean bbo() {
        if (this.egI.isEmpty()) {
            this.cVx.apz();
            d.bbb().d(this);
            return true;
        }
        return false;
    }
}
