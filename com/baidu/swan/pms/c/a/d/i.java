package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d dct;
    private List<com.baidu.swan.pms.model.e> enK = new ArrayList();
    private List<com.baidu.swan.pms.model.e> enL = new ArrayList();
    private List<com.baidu.swan.pms.model.e> enM = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> enJ = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.dct = dVar;
        d.beg().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.enJ.add(bVar);
        }
    }

    public void bes() {
        if (!bet()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.bdz().getProcessName() + " startDownload: total=" + this.enJ.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.enJ) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.bdz().getProcessName() + " startDownload: for handler=" + bVar);
                }
                bVar.ij(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (!fVar.ber()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.enJ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int bej = fVar.bej();
                    this.enJ.remove(next);
                    switch (bej) {
                        case 2:
                            this.enM.add(next.bea().enC.enB);
                            break;
                        case 3:
                            this.enL.add(next.bea().enC.enB);
                            break;
                        case 10:
                            this.enK.add(next.bea().enC.enB);
                            break;
                        default:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + bej);
                                break;
                            }
                            break;
                    }
                }
            }
            bet();
        }
    }

    private boolean bet() {
        if (this.enJ.isEmpty()) {
            this.dct.asH();
            d.beg().d(this);
            return true;
        }
        return false;
    }
}
