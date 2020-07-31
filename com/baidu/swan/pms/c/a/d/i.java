package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes19.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d cnf;
    private List<com.baidu.swan.pms.model.e> dwP = new ArrayList();
    private List<com.baidu.swan.pms.model.e> dwQ = new ArrayList();
    private List<com.baidu.swan.pms.model.e> dwR = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> dwO = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.cnf = dVar;
        d.aLv().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.dwO.add(bVar);
        }
    }

    public void aLH() {
        if (!aLI()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aKM().getProcessName() + " startDownload: total=" + this.dwO.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.dwO) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aKM().getProcessName() + " startDownload: for handler=" + bVar);
                }
                bVar.gG(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (!fVar.aLG()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.dwO.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int aLy = fVar.aLy();
                    this.dwO.remove(next);
                    switch (aLy) {
                        case 2:
                            this.dwR.add(next.aLp().dwH.dwG);
                            break;
                        case 3:
                            this.dwQ.add(next.aLp().dwH.dwG);
                            break;
                        case 10:
                            this.dwP.add(next.aLp().dwH.dwG);
                            break;
                        default:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + aLy);
                                break;
                            }
                            break;
                    }
                }
            }
            aLI();
        }
    }

    private boolean aLI() {
        if (this.dwO.isEmpty()) {
            this.cnf.abS();
            d.aLv().d(this);
            return true;
        }
        return false;
    }
}
