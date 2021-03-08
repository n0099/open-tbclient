package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d dgn;
    private List<com.baidu.swan.pms.model.e> ewm = new ArrayList();
    private List<com.baidu.swan.pms.model.e> ewn = new ArrayList();
    private List<com.baidu.swan.pms.model.e> ewo = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> ewl = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.dgn = dVar;
        d.bcY().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.ewl.add(bVar);
        }
    }

    public void bdj() {
        if (!bdk()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.bcr().getProcessName() + " startDownload: total=" + this.ewl.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.ewl) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.bcr().getProcessName() + " startDownload: for handler=" + bVar);
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
        if (!fVar.bdi()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.ewl.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int taskState = fVar.getTaskState();
                    this.ewl.remove(next);
                    switch (taskState) {
                        case 2:
                            this.ewo.add(next.bcS().ewe.ewd);
                            break;
                        case 3:
                            this.ewn.add(next.bcS().ewe.ewd);
                            break;
                        case 10:
                            this.ewm.add(next.bcS().ewe.ewd);
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
            bdk();
        }
    }

    private boolean bdk() {
        if (this.ewl.isEmpty()) {
            this.dgn.aqF();
            d.bcY().d(this);
            return true;
        }
        return false;
    }
}
