package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d bxG;
    private List<com.baidu.swan.pms.model.e> cBW = new ArrayList();
    private List<com.baidu.swan.pms.model.e> cBX = new ArrayList();
    private List<com.baidu.swan.pms.model.e> cBY = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> cBV = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.bxG = dVar;
        d.atY().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.cBV.add(bVar);
        }
    }

    public void startDownload() {
        if (!auk()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.ats().getProcessName() + " startDownload: total=" + this.cBV.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.cBV) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.ats().getProcessName() + " startDownload: for handler=" + bVar);
                }
                bVar.eY(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (!fVar.auj()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.cBV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int aub = fVar.aub();
                    this.cBV.remove(next);
                    switch (aub) {
                        case 2:
                            this.cBY.add(next.atT().cBO.cBN);
                            break;
                        case 3:
                            this.cBX.add(next.atT().cBO.cBN);
                            break;
                        case 10:
                            this.cBW.add(next.atT().cBO.cBN);
                            break;
                        default:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + aub);
                                break;
                            }
                            break;
                    }
                }
            }
            auk();
        }
    }

    private boolean auk() {
        if (this.cBV.isEmpty()) {
            this.bxG.Pk();
            d.atY().d(this);
            return true;
        }
        return false;
    }
}
