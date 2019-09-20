package com.baidu.swan.pms.b.a.c;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class i implements b {
    private com.baidu.swan.pms.a.b ayI;
    private List<com.baidu.swan.pms.model.e> btX = new ArrayList();
    private List<com.baidu.swan.pms.model.e> btY = new ArrayList();
    private List<com.baidu.swan.pms.model.e> btZ = new ArrayList();
    private List<com.baidu.swan.pms.b.a.b> btW = new ArrayList();

    public i(com.baidu.swan.pms.a.b bVar) {
        this.ayI = bVar;
        d.WC().c(this);
    }

    public void a(com.baidu.swan.pms.b.a.b bVar) {
        if (bVar != null) {
            this.btW.add(bVar);
        }
    }

    public void startDownload() {
        if (!WM()) {
            for (com.baidu.swan.pms.b.a.b bVar : this.btW) {
                bVar.dl(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.b.a.c.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.b.a.c.b
    public <T> void e(f<T> fVar) {
        Iterator<com.baidu.swan.pms.b.a.b> it = this.btW.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.swan.pms.b.a.b next = it.next();
            if (next.a(fVar)) {
                int WF = fVar.WF();
                this.btW.remove(next);
                switch (WF) {
                    case 2:
                        this.btZ.add(next.WA().btR.btQ);
                        break;
                    case 3:
                        this.btY.add(next.WA().btR.btQ);
                        break;
                    case 10:
                        this.btX.add(next.WA().btR.btQ);
                        break;
                    default:
                        if (com.baidu.swan.pms.e.DEBUG) {
                            Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + WF);
                            break;
                        }
                        break;
                }
            }
        }
        WM();
    }

    private boolean WM() {
        if (this.btW.isEmpty()) {
            this.ayI.Wf();
            d.WC().d(this);
            return true;
        }
        return false;
    }
}
