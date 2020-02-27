package com.baidu.swan.pms.c.a.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class i implements b {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private com.baidu.swan.pms.a.d bxt;
    private List<com.baidu.swan.pms.model.e> cBJ = new ArrayList();
    private List<com.baidu.swan.pms.model.e> cBK = new ArrayList();
    private List<com.baidu.swan.pms.model.e> cBL = new ArrayList();
    private List<com.baidu.swan.pms.c.a.b> cBI = new ArrayList();

    public i(com.baidu.swan.pms.a.d dVar) {
        this.bxt = dVar;
        d.atT().c(this);
    }

    public void a(com.baidu.swan.pms.c.a.b bVar) {
        if (bVar != null) {
            this.cBI.add(bVar);
        }
    }

    public void startDownload() {
        if (!auf()) {
            if (DEBUG) {
                Log.i("PMSTaskGroup", com.baidu.swan.pms.d.atn().getProcessName() + " startDownload: total=" + this.cBI.size());
            }
            for (com.baidu.swan.pms.c.a.b bVar : this.cBI) {
                if (DEBUG) {
                    Log.i("PMSTaskGroup", com.baidu.swan.pms.d.atn().getProcessName() + " startDownload: for handler=" + bVar);
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
        if (!fVar.aue()) {
            Iterator<com.baidu.swan.pms.c.a.b> it = this.cBI.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.swan.pms.c.a.b next = it.next();
                if (next.a(fVar)) {
                    int atW = fVar.atW();
                    this.cBI.remove(next);
                    switch (atW) {
                        case 2:
                            this.cBL.add(next.atO().cBB.cBA);
                            break;
                        case 3:
                            this.cBK.add(next.atO().cBB.cBA);
                            break;
                        case 10:
                            this.cBJ.add(next.atO().cBB.cBA);
                            break;
                        default:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + atW);
                                break;
                            }
                            break;
                    }
                }
            }
            auf();
        }
    }

    private boolean auf() {
        if (this.cBI.isEmpty()) {
            this.bxt.Pf();
            d.atT().d(this);
            return true;
        }
        return false;
    }
}
