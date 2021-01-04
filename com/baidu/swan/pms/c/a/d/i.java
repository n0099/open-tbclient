package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d dhn;
    private List<com.baidu.swan.pms.model.e> exr = new ArrayList();
    private List<com.baidu.swan.pms.model.e> exs = new ArrayList();
    private List<com.baidu.swan.pms.model.e> exu = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> exq = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.dhn = dVar;
        d.bgC().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.exq.add(bVar);
        }
    }

    public void bgN() {
        if (!bgO()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.bfV().getProcessName() + " startDownload: total=" + this.exq.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.exq) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.bfV().getProcessName() + " startDownload: for handler=" + bVar);
                }
                bVar.iD(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (!fVar.bgM()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.exq.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int taskState = fVar.getTaskState();
                    this.exq.remove(next);
                    switch (taskState) {
                        case 2:
                            this.exu.add(next.bgw().exj.exi);
                            break;
                        case 3:
                            this.exs.add(next.bgw().exj.exi);
                            break;
                        case 10:
                            this.exr.add(next.bgw().exj.exi);
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
            bgO();
        }
    }

    private boolean bgO() {
        if (this.exq.isEmpty()) {
            this.dhn.atY();
            d.bgC().d(this);
            return true;
        }
        return false;
    }
}
