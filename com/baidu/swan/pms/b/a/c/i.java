package com.baidu.swan.pms.b.a.c;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class i implements b {
    private com.baidu.swan.pms.a.b aRY;
    private List<com.baidu.swan.pms.model.e> bMI = new ArrayList();
    private List<com.baidu.swan.pms.model.e> bMJ = new ArrayList();
    private List<com.baidu.swan.pms.model.e> bMK = new ArrayList();
    private List<com.baidu.swan.pms.b.a.b> bMH = new ArrayList();

    public i(com.baidu.swan.pms.a.b bVar) {
        this.aRY = bVar;
        d.abr().c(this);
    }

    public void a(com.baidu.swan.pms.b.a.b bVar) {
        if (bVar != null) {
            this.bMH.add(bVar);
        }
    }

    public void startDownload() {
        if (!abB()) {
            for (com.baidu.swan.pms.b.a.b bVar : this.bMH) {
                bVar.dC(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.b.a.c.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.b.a.c.b
    public <T> void e(f<T> fVar) {
        Iterator<com.baidu.swan.pms.b.a.b> it = this.bMH.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.swan.pms.b.a.b next = it.next();
            if (next.a(fVar)) {
                int abu = fVar.abu();
                this.bMH.remove(next);
                switch (abu) {
                    case 2:
                        this.bMK.add(next.abp().bMC.bMB);
                        break;
                    case 3:
                        this.bMJ.add(next.abp().bMC.bMB);
                        break;
                    case 10:
                        this.bMI.add(next.abp().bMC.bMB);
                        break;
                    default:
                        if (com.baidu.swan.pms.e.DEBUG) {
                            Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + abu);
                            break;
                        }
                        break;
                }
            }
        }
        abB();
    }

    private boolean abB() {
        if (this.bMH.isEmpty()) {
            this.aRY.aaU();
            d.abr().d(this);
            return true;
        }
        return false;
    }
}
