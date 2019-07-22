package com.baidu.swan.pms.b.a.c;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class i implements b {
    private com.baidu.swan.pms.a.b ayk;
    private List<com.baidu.swan.pms.model.e> btz = new ArrayList();
    private List<com.baidu.swan.pms.model.e> btA = new ArrayList();
    private List<com.baidu.swan.pms.model.e> btB = new ArrayList();
    private List<com.baidu.swan.pms.b.a.b> bty = new ArrayList();

    public i(com.baidu.swan.pms.a.b bVar) {
        this.ayk = bVar;
        d.Wy().c(this);
    }

    public void a(com.baidu.swan.pms.b.a.b bVar) {
        if (bVar != null) {
            this.bty.add(bVar);
        }
    }

    public void startDownload() {
        if (!WI()) {
            for (com.baidu.swan.pms.b.a.b bVar : this.bty) {
                bVar.dl(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.b.a.c.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.b.a.c.b
    public <T> void e(f<T> fVar) {
        Iterator<com.baidu.swan.pms.b.a.b> it = this.bty.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.swan.pms.b.a.b next = it.next();
            if (next.a(fVar)) {
                int WB = fVar.WB();
                this.bty.remove(next);
                switch (WB) {
                    case 2:
                        this.btB.add(next.Ww().btt.bts);
                        break;
                    case 3:
                        this.btA.add(next.Ww().btt.bts);
                        break;
                    case 10:
                        this.btz.add(next.Ww().btt.bts);
                        break;
                    default:
                        if (com.baidu.swan.pms.e.DEBUG) {
                            Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + WB);
                            break;
                        }
                        break;
                }
            }
        }
        WI();
    }

    private boolean WI() {
        if (this.bty.isEmpty()) {
            this.ayk.Wb();
            d.Wy().d(this);
            return true;
        }
        return false;
    }
}
