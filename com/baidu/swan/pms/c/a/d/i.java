package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d cgn;
    private List<com.baidu.swan.pms.model.e> dmm = new ArrayList();
    private List<com.baidu.swan.pms.model.e> dmn = new ArrayList();
    private List<com.baidu.swan.pms.model.e> dmo = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> dml = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.cgn = dVar;
        d.aGy().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.dml.add(bVar);
        }
    }

    public void aGK() {
        if (!aGL()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aFP().getProcessName() + " startDownload: total=" + this.dml.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.dml) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.aFP().getProcessName() + " startDownload: for handler=" + bVar);
                }
                bVar.gg(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (!fVar.aGJ()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.dml.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int aGB = fVar.aGB();
                    this.dml.remove(next);
                    switch (aGB) {
                        case 2:
                            this.dmo.add(next.aGs().dme.dmd);
                            break;
                        case 3:
                            this.dmn.add(next.aGs().dme.dmd);
                            break;
                        case 10:
                            this.dmm.add(next.aGs().dme.dmd);
                            break;
                        default:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + aGB);
                                break;
                            }
                            break;
                    }
                }
            }
            aGL();
        }
    }

    private boolean aGL() {
        if (this.dml.isEmpty()) {
            this.cgn.ZK();
            d.aGy().d(this);
            return true;
        }
        return false;
    }
}
