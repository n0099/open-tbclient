package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d deM;
    private List<com.baidu.swan.pms.model.e> euL = new ArrayList();
    private List<com.baidu.swan.pms.model.e> euM = new ArrayList();
    private List<com.baidu.swan.pms.model.e> euN = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> euK = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.deM = dVar;
        d.bcW().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.euK.add(bVar);
        }
    }

    public void bdh() {
        if (!bdi()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.bcp().getProcessName() + " startDownload: total=" + this.euK.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.euK) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.bcp().getProcessName() + " startDownload: for handler=" + bVar);
                }
                bVar.iB(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (!fVar.bdg()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.euK.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int taskState = fVar.getTaskState();
                    this.euK.remove(next);
                    switch (taskState) {
                        case 2:
                            this.euN.add(next.bcQ().euD.euC);
                            break;
                        case 3:
                            this.euM.add(next.bcQ().euD.euC);
                            break;
                        case 10:
                            this.euL.add(next.bcQ().euD.euC);
                            break;
                        default:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + taskState);
                                break;
                            }
                            break;
                    }
                }
            }
            bdi();
        }
    }

    private boolean bdi() {
        if (this.euK.isEmpty()) {
            this.deM.aqC();
            d.bcW().d(this);
            return true;
        }
        return false;
    }
}
