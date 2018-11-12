package com.baidu.b.a.f.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements com.baidu.b.a.f.d.a.a {
    private List<j> ZQ;
    private com.baidu.b.a.b.c.b ZR;
    private List<com.baidu.b.a.c.a.a> ZS = new ArrayList();
    private List<com.baidu.b.a.c.a.a> ZT = new ArrayList();
    private List<com.baidu.b.a.c.a.a> ZU = new ArrayList();

    public a(List<j> list, com.baidu.b.a.b.c.b bVar) {
        this.ZQ = list;
        this.ZR = bVar;
        g.rS().a(this);
    }

    public void startDownload() {
        if (!rJ()) {
            for (j jVar : this.ZQ) {
                jVar.aI(false);
            }
        }
    }

    @Override // com.baidu.b.a.f.d.a.a
    public void a(f fVar) {
    }

    @Override // com.baidu.b.a.f.d.a.a
    public void b(f fVar) {
        Iterator<j> it = this.ZQ.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            j next = it.next();
            if (next.g(fVar)) {
                com.baidu.b.a.c.a.a rM = fVar.rM();
                if (rM == null) {
                    Log.w("BulkDownload", "unexpected state: DynamicFile is NULL.");
                } else {
                    this.ZQ.remove(next);
                    switch (rM.type) {
                        case 3:
                            this.ZT.add(next.rU().rM());
                            rK();
                            break;
                        case 10:
                            this.ZS.add(next.rU().rM());
                            break;
                        default:
                            Log.w("BulkDownload", "unexpected state: default.");
                            break;
                    }
                }
            }
        }
        rJ();
    }

    private boolean rJ() {
        if (this.ZQ.isEmpty()) {
            this.ZR.onBulkDownloaded(this.ZS, this.ZT, this.ZU);
            g.rS().b(this);
            com.baidu.b.a.h.g.sk().a(2216, String.format("onBulkDownloaded success:%d,error:%d,cancel:%d", Integer.valueOf(this.ZS.size()), Integer.valueOf(this.ZT.size()), Integer.valueOf(this.ZU.size())), this.ZR.getChannelId(), this.ZR.getPackageName(), 0L, "", "", 0, 0);
            return true;
        }
        return false;
    }

    public void rK() {
        for (j jVar : this.ZQ) {
            g.rS().f(jVar.rU());
            this.ZU.add(jVar.rU().rM());
        }
        this.ZQ.clear();
    }
}
