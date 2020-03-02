package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d bxu;
    private List<com.baidu.swan.pms.model.e> cBK = new ArrayList();
    private List<com.baidu.swan.pms.model.e> cBL = new ArrayList();
    private List<com.baidu.swan.pms.model.e> cBM = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> cBJ = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.bxu = dVar;
        d.atV().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.cBJ.add(bVar);
        }
    }

    public void startDownload() {
        if (!auh()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.atp().getProcessName() + " startDownload: total=" + this.cBJ.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.cBJ) {
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
            Iterator<com.baidu.swan.pms.c.a.b> it = this.cBJ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int atY = fVar.atY();
                    this.cBJ.remove(next);
                    switch (atY) {
                        case 2:
                            this.cBM.add(next.atQ().cBC.cBB);
                            break;
                        case 3:
                            this.cBL.add(next.atQ().cBC.cBB);
                            break;
                        case 10:
                            this.cBK.add(next.atQ().cBC.cBB);
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
        if (this.cBJ.isEmpty()) {
            this.bxu.Ph();
            d.atV().d(this);
            return true;
        }
        return false;
    }
}
