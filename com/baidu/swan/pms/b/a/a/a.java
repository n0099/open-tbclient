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
            com.baidu.swan.pms.b.a.c.f<d> a = h.a(aVar.bMO, fVar);
            com.baidu.swan.pms.b.a.c.f<com.baidu.swan.pms.model.f> a2 = h.a(aVar.bMc, fVar);
            com.baidu.swan.pms.b.a.c.f<b> a3 = h.a(aVar.bMQ, fVar);
            List<com.baidu.swan.pms.b.a.c.f<com.baidu.swan.pms.model.h>> a4 = h.a(aVar.bMN, fVar);
            i iVar = new i(fVar);
            iVar.a(com.baidu.swan.pms.b.a.c.d.abr().f(a));
            iVar.a(com.baidu.swan.pms.b.a.c.d.abr().f(a2));
            iVar.a(com.baidu.swan.pms.b.a.c.d.abr().f(a3));
            for (com.baidu.swan.pms.b.a.c.f<com.baidu.swan.pms.model.h> fVar2 : a4) {
                iVar.a(com.baidu.swan.pms.b.a.c.d.abr().f(fVar2));
            }
            iVar.startDownload();
        }
    }

    public static synchronized void a(com.baidu.swan.pms.b.c.d dVar, f fVar) {
        synchronized (a.class) {
            com.baidu.swan.pms.b.a.c.f<d> a = h.a(dVar.bMO, fVar);
            com.baidu.swan.pms.b.a.c.f<b> a2 = h.a(dVar.bMQ, fVar);
            i iVar = new i(fVar);
            iVar.a(com.baidu.swan.pms.b.a.c.d.abr().f(a));
            iVar.a(com.baidu.swan.pms.b.a.c.d.abr().f(a2));
            iVar.startDownload();
        }
    }

    public static synchronized void a(c cVar, f fVar) {
        synchronized (a.class) {
            List<com.baidu.swan.pms.b.a.c.f<com.baidu.swan.pms.model.h>> a = h.a(cVar.bMN, fVar);
            i iVar = new i(fVar);
            for (com.baidu.swan.pms.b.a.c.f<com.baidu.swan.pms.model.h> fVar2 : a) {
                iVar.a(com.baidu.swan.pms.b.a.c.d.abr().f(fVar2));
            }
            iVar.startDownload();
        }
    }

    public static synchronized void a(com.baidu.swan.pms.b.c.b bVar, f fVar) {
        synchronized (a.class) {
            com.baidu.swan.pms.b.a.c.f<com.baidu.swan.pms.model.i> a = h.a(bVar.bMR, fVar);
            i iVar = new i(fVar);
            iVar.a(com.baidu.swan.pms.b.a.c.d.abr().f(a));
            iVar.startDownload();
        }
    }
}
