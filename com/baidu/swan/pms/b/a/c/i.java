package com.baidu.swan.pms.b.a.c;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class i implements b {
    private com.baidu.swan.pms.a.b axD;
    private List<com.baidu.swan.pms.model.e> bsJ = new ArrayList();
    private List<com.baidu.swan.pms.model.e> bsK = new ArrayList();
    private List<com.baidu.swan.pms.model.e> bsL = new ArrayList();
    private List<com.baidu.swan.pms.b.a.b> bsI = new ArrayList();

    public i(com.baidu.swan.pms.a.b bVar) {
        this.axD = bVar;
        d.VF().c(this);
    }

    public void a(com.baidu.swan.pms.b.a.b bVar) {
        if (bVar != null) {
            this.bsI.add(bVar);
        }
    }

    public void startDownload() {
        if (!VP()) {
            for (com.baidu.swan.pms.b.a.b bVar : this.bsI) {
                bVar.dg(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.b.a.c.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.b.a.c.b
    public <T> void e(f<T> fVar) {
        Iterator<com.baidu.swan.pms.b.a.b> it = this.bsI.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.swan.pms.b.a.b next = it.next();
            if (next.a(fVar)) {
                int VI = fVar.VI();
                this.bsI.remove(next);
                switch (VI) {
                    case 2:
                        this.bsL.add(next.VD().bsD.bsC);
                        break;
                    case 3:
                        this.bsK.add(next.VD().bsD.bsC);
                        break;
                    case 10:
                        this.bsJ.add(next.VD().bsD.bsC);
                        break;
                    default:
                        if (com.baidu.swan.pms.e.DEBUG) {
                            Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + VI);
                            break;
                        }
                        break;
                }
            }
        }
        VP();
    }

    private boolean VP() {
        if (this.bsI.isEmpty()) {
            this.axD.Vi();
            d.VF().d(this);
            return true;
        }
        return false;
    }
}
