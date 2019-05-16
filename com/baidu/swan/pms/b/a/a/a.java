package com.baidu.swan.pms.b.a.a;

import com.baidu.swan.pms.a.f;
import com.baidu.swan.pms.b.a.c.h;
import com.baidu.swan.pms.b.a.c.i;
import com.baidu.swan.pms.b.c.c;
import com.baidu.swan.pms.model.b;
import com.baidu.swan.pms.model.d;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static synchronized void a(com.baidu.swan.pms.b.c.a aVar, f fVar) {
        synchronized (a.class) {
            com.baidu.swan.pms.b.a.c.f<d> a = h.a(aVar.bsP, fVar);
            com.baidu.swan.pms.b.a.c.f<com.baidu.swan.pms.model.f> a2 = h.a(aVar.bse, fVar);
            com.baidu.swan.pms.b.a.c.f<b> a3 = h.a(aVar.bsR, fVar);
            List<com.baidu.swan.pms.b.a.c.f<com.baidu.swan.pms.model.h>> a4 = h.a(aVar.bsO, fVar);
            i iVar = new i(fVar);
            iVar.a(com.baidu.swan.pms.b.a.c.d.VF().f(a));
            iVar.a(com.baidu.swan.pms.b.a.c.d.VF().f(a2));
            iVar.a(com.baidu.swan.pms.b.a.c.d.VF().f(a3));
            for (com.baidu.swan.pms.b.a.c.f<com.baidu.swan.pms.model.h> fVar2 : a4) {
                iVar.a(com.baidu.swan.pms.b.a.c.d.VF().f(fVar2));
            }
            iVar.startDownload();
        }
    }

    public static synchronized void a(com.baidu.swan.pms.b.c.d dVar, f fVar) {
        synchronized (a.class) {
            com.baidu.swan.pms.b.a.c.f<d> a = h.a(dVar.bsP, fVar);
            com.baidu.swan.pms.b.a.c.f<b> a2 = h.a(dVar.bsR, fVar);
            i iVar = new i(fVar);
            iVar.a(com.baidu.swan.pms.b.a.c.d.VF().f(a));
            iVar.a(com.baidu.swan.pms.b.a.c.d.VF().f(a2));
            iVar.startDownload();
        }
    }

    public static synchronized void a(c cVar, f fVar) {
        synchronized (a.class) {
            List<com.baidu.swan.pms.b.a.c.f<com.baidu.swan.pms.model.h>> a = h.a(cVar.bsO, fVar);
            i iVar = new i(fVar);
            for (com.baidu.swan.pms.b.a.c.f<com.baidu.swan.pms.model.h> fVar2 : a) {
                iVar.a(com.baidu.swan.pms.b.a.c.d.VF().f(fVar2));
            }
            iVar.startDownload();
        }
    }

    public static synchronized void a(com.baidu.swan.pms.b.c.b bVar, f fVar) {
        synchronized (a.class) {
            com.baidu.swan.pms.b.a.c.f<com.baidu.swan.pms.model.i> a = h.a(bVar.bsS, fVar);
            i iVar = new i(fVar);
            iVar.a(com.baidu.swan.pms.b.a.c.d.VF().f(a));
            iVar.startDownload();
        }
    }
}
