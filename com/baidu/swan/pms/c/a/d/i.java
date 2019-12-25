package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d bsv;
    private List<com.baidu.swan.pms.model.e> cxA = new ArrayList();
    private List<com.baidu.swan.pms.model.e> cxB = new ArrayList();
    private List<com.baidu.swan.pms.model.e> cxC = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> cxz = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.bsv = dVar;
        d.arm().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.cxz.add(bVar);
        }
    }

    public void startDownload() {
        if (!ary()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aqG().getProcessName() + " startDownload: total=" + this.cxz.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.cxz) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aqG().getProcessName() + " startDownload: for handler=" + bVar);
                }
                bVar.eL(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (!fVar.arx()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.cxz.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int arp = fVar.arp();
                    this.cxz.remove(next);
                    switch (arp) {
                        case 2:
                            this.cxC.add(next.arh().cxs.cxr);
                            break;
                        case 3:
                            this.cxB.add(next.arh().cxs.cxr);
                            break;
                        case 10:
                            this.cxA.add(next.arh().cxs.cxr);
                            break;
                        default:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + arp);
                                break;
                            }
                            break;
                    }
                }
            }
            ary();
        }
    }

    private boolean ary() {
        if (this.cxz.isEmpty()) {
            this.bsv.Mv();
            d.arm().d(this);
            return true;
        }
        return false;
    }
}
