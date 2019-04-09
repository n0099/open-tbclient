package com.baidu.swan.pms.b.a.a;

import com.baidu.swan.pms.a.e;
import com.baidu.swan.pms.b.a.c.d;
import com.baidu.swan.pms.b.a.c.f;
import com.baidu.swan.pms.b.a.c.h;
import com.baidu.swan.pms.b.c.b;
import com.baidu.swan.pms.model.c;
import com.baidu.swan.pms.model.g;
import com.baidu.swan.pms.model.i;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static synchronized void a(b bVar, e eVar) {
        synchronized (a.class) {
            f<com.baidu.swan.pms.model.e> a = h.a(bVar.bmP, eVar);
            f<g> a2 = h.a(bVar.bmc, eVar);
            f<c> a3 = h.a(bVar.bmQ, eVar);
            List<f<i>> a4 = h.a(bVar.bmR, eVar);
            com.baidu.swan.pms.b.a.c.i iVar = new com.baidu.swan.pms.b.a.c.i(eVar);
            iVar.a(d.RR().f(a));
            iVar.a(d.RR().f(a2));
            iVar.a(d.RR().f(a3));
            for (f<i> fVar : a4) {
                iVar.a(d.RR().f(fVar));
            }
            iVar.startDownload();
        }
    }

    public static synchronized void a(com.baidu.swan.pms.b.c.a aVar, e eVar) {
        synchronized (a.class) {
            f<com.baidu.swan.pms.model.e> a = h.a(aVar.bmP, eVar);
            f<c> a2 = h.a(aVar.bmQ, eVar);
            com.baidu.swan.pms.b.a.c.i iVar = new com.baidu.swan.pms.b.a.c.i(eVar);
            iVar.a(d.RR().f(a));
            iVar.a(d.RR().f(a2));
            iVar.startDownload();
        }
    }

    public static synchronized void a(com.baidu.swan.pms.b.c.c cVar, e eVar) {
        synchronized (a.class) {
            List<f<i>> a = h.a(cVar.bmR, eVar);
            com.baidu.swan.pms.b.a.c.i iVar = new com.baidu.swan.pms.b.a.c.i(eVar);
            for (f<i> fVar : a) {
                iVar.a(d.RR().f(fVar));
            }
            iVar.startDownload();
        }
    }
}
