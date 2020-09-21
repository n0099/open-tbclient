package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes24.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d cwN;
    private List<com.baidu.swan.pms.model.e> dIb = new ArrayList();
    private List<com.baidu.swan.pms.model.e> dIc = new ArrayList();
    private List<com.baidu.swan.pms.model.e> dId = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> dIa = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.cwN = dVar;
        d.aUG().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.dIa.add(bVar);
        }
    }

    public void aUS() {
        if (!aUT()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aTZ().getProcessName() + " startDownload: total=" + this.dIa.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.dIa) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aTZ().getProcessName() + " startDownload: for handler=" + bVar);
                }
                bVar.gZ(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (!fVar.aUR()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.dIa.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int aUJ = fVar.aUJ();
                    this.dIa.remove(next);
                    switch (aUJ) {
                        case 2:
                            this.dId.add(next.aUA().dHS.dHR);
                            break;
                        case 3:
                            this.dIc.add(next.aUA().dHS.dHR);
                            break;
                        case 10:
                            this.dIb.add(next.aUA().dHS.dHR);
                            break;
                        default:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + aUJ);
                                break;
                            }
                            break;
                    }
                }
            }
            aUT();
        }
    }

    private boolean aUT() {
        if (this.dIa.isEmpty()) {
            this.cwN.ajb();
            d.aUG().d(this);
            return true;
        }
        return false;
    }
}
