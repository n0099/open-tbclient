package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d bxv;
    private List<com.baidu.swan.pms.model.e> cBL = new ArrayList();
    private List<com.baidu.swan.pms.model.e> cBM = new ArrayList();
    private List<com.baidu.swan.pms.model.e> cBN = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> cBK = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.bxv = dVar;
        d.atV().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.cBK.add(bVar);
        }
    }

    public void startDownload() {
        if (!auh()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.atp().getProcessName() + " startDownload: total=" + this.cBK.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.cBK) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.atp().getProcessName() + " startDownload: for handler=" + bVar);
                }
                bVar.eX(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (!fVar.aug()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.cBK.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int atY = fVar.atY();
                    this.cBK.remove(next);
                    switch (atY) {
                        case 2:
                            this.cBN.add(next.atQ().cBD.cBC);
                            break;
                        case 3:
                            this.cBM.add(next.atQ().cBD.cBC);
                            break;
                        case 10:
                            this.cBL.add(next.atQ().cBD.cBC);
                            break;
                        default:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + atY);
                                break;
                            }
                            break;
                    }
                }
            }
            auh();
        }
    }

    private boolean auh() {
        if (this.cBK.isEmpty()) {
            this.bxv.Ph();
            d.atV().d(this);
            return true;
        }
        return false;
    }
}
