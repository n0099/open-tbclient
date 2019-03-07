package com.baidu.swan.pms.b.a.c;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class i implements b {
    private com.baidu.swan.pms.a.b bmE;
    private List<com.baidu.swan.pms.model.f> bmF = new ArrayList();
    private List<com.baidu.swan.pms.model.f> bmG = new ArrayList();
    private List<com.baidu.swan.pms.model.f> bmH = new ArrayList();
    private List<com.baidu.swan.pms.b.a.b> bmD = new ArrayList();

    public i(com.baidu.swan.pms.a.b bVar) {
        this.bmE = bVar;
        d.RT().c(this);
    }

    public void a(com.baidu.swan.pms.b.a.b bVar) {
        if (bVar != null) {
            this.bmD.add(bVar);
        }
    }

    public void startDownload() {
        if (!Sd()) {
            for (com.baidu.swan.pms.b.a.b bVar : this.bmD) {
                bVar.cP(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.b.a.c.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.b.a.c.b
    public <T> void e(f<T> fVar) {
        Iterator<com.baidu.swan.pms.b.a.b> it = this.bmD.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.swan.pms.b.a.b next = it.next();
            if (next.a(fVar)) {
                int RW = fVar.RW();
                this.bmD.remove(next);
                switch (RW) {
                    case 2:
                        this.bmH.add(next.RR().bmx.bmw);
                        break;
                    case 3:
                        this.bmG.add(next.RR().bmx.bmw);
                        break;
                    case 10:
                        this.bmF.add(next.RR().bmx.bmw);
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
        if (this.bmD.isEmpty()) {
            this.bmE.DA();
            d.RT().d(this);
            return true;
        }
        return false;
    }
}
