package com.baidu.swan.pms.b.a.c;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class i implements b {
    private com.baidu.swan.pms.a.b bmJ;
    private List<com.baidu.swan.pms.model.f> bmK = new ArrayList();
    private List<com.baidu.swan.pms.model.f> bmL = new ArrayList();
    private List<com.baidu.swan.pms.model.f> bmM = new ArrayList();
    private List<com.baidu.swan.pms.b.a.b> bmI = new ArrayList();

    public i(com.baidu.swan.pms.a.b bVar) {
        this.bmJ = bVar;
        d.RR().c(this);
    }

    public void a(com.baidu.swan.pms.b.a.b bVar) {
        if (bVar != null) {
            this.bmI.add(bVar);
        }
    }

    public void startDownload() {
        if (!Sb()) {
            for (com.baidu.swan.pms.b.a.b bVar : this.bmI) {
                bVar.cP(false);
            }
        }
    }

    @Override // com.baidu.swan.pms.b.a.c.b
    public <T> void d(f<T> fVar) {
    }

    @Override // com.baidu.swan.pms.b.a.c.b
    public <T> void e(f<T> fVar) {
        Iterator<com.baidu.swan.pms.b.a.b> it = this.bmI.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.swan.pms.b.a.b next = it.next();
            if (next.a(fVar)) {
                int RU = fVar.RU();
                this.bmI.remove(next);
                switch (RU) {
                    case 2:
                        this.bmM.add(next.RP().bmC.bmB);
                        break;
                    case 3:
                        this.bmL.add(next.RP().bmC.bmB);
                        break;
                    case 10:
                        this.bmK.add(next.RP().bmC.bmB);
                        break;
                    default:
                        if (com.baidu.swan.pms.e.DEBUG) {
                            Log.e("PMSTaskGroup", "notifyTaskEnd error state:" + RU);
                            break;
                        }
                        break;
                }
            }
        }
        Sb();
    }

    private boolean Sb() {
        if (this.bmI.isEmpty()) {
            this.bmJ.Dy();
            d.RR().d(this);
            return true;
        }
        return false;
    }
}
