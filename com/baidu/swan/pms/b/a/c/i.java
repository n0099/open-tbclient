package com.baidu.swan.pms.b.a.c;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class i implements b {
    private com.baidu.swan.pms.a.b aRG;
    private List<com.baidu.swan.pms.model.e> bLR = new ArrayList();
    private List<com.baidu.swan.pms.model.e> bLS = new ArrayList();
    private List<com.baidu.swan.pms.model.e> bLT = new ArrayList();
    private List<com.baidu.swan.pms.b.a.b> bLQ = new ArrayList();

    public i(com.baidu.swan.pms.a.b bVar) {
        this.aRG = bVar;
        d.abp().c(this);
    }

    public void a(com.baidu.swan.pms.b.a.b bVar) {
        if (bVar != null) {
            this.bLQ.add(bVar);
        }
    }

    public void startDownload() {
        if (!abz()) {
            for (com.baidu.swan.pms.b.a.b bVar : this.bLQ) {
                bVar.dC(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.b.a.c.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.b.a.c.b
    public <T> void e(f<T> fVar) {
        Iterator<com.baidu.swan.pms.b.a.b> it = this.bLQ.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.swan.pms.b.a.b next = it.next();
            if (next.a(fVar)) {
                int abs = fVar.abs();
                this.bLQ.remove(next);
                switch (abs) {
                    case 2:
                        this.bLT.add(next.abn().bLL.bLK);
                        break;
                    case 3:
                        this.bLS.add(next.abn().bLL.bLK);
                        break;
                    case 10:
                        this.bLR.add(next.abn().bLL.bLK);
                        break;
                    default:
                        if (com.baidu.swan.pms.e.DEBUG) {
                            Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + abs);
                            break;
                        }
                        break;
                }
            }
        }
        abz();
    }

    private boolean abz() {
        if (this.bLQ.isEmpty()) {
            this.aRG.aaS();
            d.abp().d(this);
            return true;
        }
        return false;
    }
}
