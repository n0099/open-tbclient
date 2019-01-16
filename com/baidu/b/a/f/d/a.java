package com.baidu.b.a.f.d;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements com.baidu.b.a.f.d.a.a {
    private List<j> ZZ;
    private com.baidu.b.a.b.c.b aaa;
    private List<com.baidu.b.a.c.a.a> aab = new ArrayList();
    private List<com.baidu.b.a.c.a.a> aac = new ArrayList();
    private List<com.baidu.b.a.c.a.a> aad = new ArrayList();

    public a(List<j> list, com.baidu.b.a.b.c.b bVar) {
        this.ZZ = list;
        this.aaa = bVar;
        g.rV().a(this);
    }

    public void startDownload() {
        if (!rM()) {
            for (j jVar : this.ZZ) {
                jVar.aI(false);
            }
        }
    }

    @Override // com.baidu.b.a.f.d.a.a
    public void a(f fVar) {
    }

    @Override // com.baidu.b.a.f.d.a.a
    public void b(f fVar) {
        Iterator<j> it = this.ZZ.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            j next = it.next();
            if (next.g(fVar)) {
                com.baidu.b.a.c.a.a rP = fVar.rP();
                if (rP == null) {
                    Log.w("BulkDownload", "unexpected state: DynamicFile is NULL.");
                } else {
                    this.ZZ.remove(next);
                    switch (rP.type) {
                        case 3:
                            this.aac.add(next.rX().rP());
                            rN();
                            break;
                        case 10:
                            this.aab.add(next.rX().rP());
                            break;
                        default:
                            Log.w("BulkDownload", "unexpected state: default.");
                            break;
                    }
                }
            }
        }
        rM();
    }

    private boolean rM() {
        if (this.ZZ.isEmpty()) {
            this.aaa.onBulkDownloaded(this.aab, this.aac, this.aad);
            g.rV().b(this);
            com.baidu.b.a.h.g.sn().a(2216, String.format("onBulkDownloaded success:%d,error:%d,cancel:%d", Integer.valueOf(this.aab.size()), Integer.valueOf(this.aac.size()), Integer.valueOf(this.aad.size())), this.aaa.getChannelId(), this.aaa.getPackageName(), 0L, "", "", 0, 0);
            return true;
        }
        return false;
    }

    public void rN() {
        for (j jVar : this.ZZ) {
            g.rV().f(jVar.rX());
            this.aad.add(jVar.rX().rP());
        }
        this.ZZ.clear();
    }
}
