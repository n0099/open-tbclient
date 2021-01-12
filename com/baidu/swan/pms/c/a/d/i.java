package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d dcz;
    private List<com.baidu.swan.pms.model.e> esE = new ArrayList();
    private List<com.baidu.swan.pms.model.e> esF = new ArrayList();
    private List<com.baidu.swan.pms.model.e> esG = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> esD = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.dcz = dVar;
        d.bcJ().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.esD.add(bVar);
        }
    }

    public void bcU() {
        if (!bcV()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.bcc().getProcessName() + " startDownload: total=" + this.esD.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.esD) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.bcc().getProcessName() + " startDownload: for handler=" + bVar);
                }
                bVar.iz(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.c.a.d.b
    public <T> void e(f<T> fVar) {
        if (!fVar.bcT()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.esD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int taskState = fVar.getTaskState();
                    this.esD.remove(next);
                    switch (taskState) {
                        case 2:
                            this.esG.add(next.bcD().esw.esv);
                            break;
                        case 3:
                            this.esF.add(next.bcD().esw.esv);
                            break;
                        case 10:
                            this.esE.add(next.bcD().esw.esv);
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
            bcV();
        }
    }

    private boolean bcV() {
        if (this.esD.isEmpty()) {
            this.dcz.aqe();
            d.bcJ().d(this);
            return true;
        }
        return false;
    }
}
