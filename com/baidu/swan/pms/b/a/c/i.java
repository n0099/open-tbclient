package com.baidu.swan.pms.b.a.c;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class i implements b {
    private com.baidu.swan.pms.a.b bmF;
    private List<com.baidu.swan.pms.model.f> bmG = new ArrayList();
    private List<com.baidu.swan.pms.model.f> bmH = new ArrayList();
    private List<com.baidu.swan.pms.model.f> bmI = new ArrayList();
    private List<com.baidu.swan.pms.b.a.b> bmE = new ArrayList();

    public i(com.baidu.swan.pms.a.b bVar) {
        this.bmF = bVar;
        d.RT().c(this);
    }

    public void a(com.baidu.swan.pms.b.a.b bVar) {
        if (bVar != null) {
            this.bmE.add(bVar);
        }
    }

    public void startDownload() {
        if (!Sd()) {
            for (com.baidu.swan.pms.b.a.b bVar : this.bmE) {
                bVar.cP(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.b.a.c.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.b.a.c.b
    public <T> void e(f<T> fVar) {
        Iterator<com.baidu.swan.pms.b.a.b> it = this.bmE.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.swan.pms.b.a.b next = it.next();
            if (next.a(fVar)) {
                int RW = fVar.RW();
                this.bmE.remove(next);
                switch (RW) {
                    case 2:
                        this.bmI.add(next.RR().bmy.bmx);
                        break;
                    case 3:
                        this.bmH.add(next.RR().bmy.bmx);
                        break;
                    case 10:
                        this.bmG.add(next.RR().bmy.bmx);
                        break;
                    default:
                        if (com.baidu.swan.pms.e.DEBUG) {
                            Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + RW);
                            break;
                        }
                        break;
                }
            }
        }
        Sd();
    }

    private boolean Sd() {
        if (this.bmE.isEmpty()) {
            this.bmF.DA();
            d.RT().d(this);
            return true;
        }
        return false;
    }
}
