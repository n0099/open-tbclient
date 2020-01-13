package com.baidu.swan.pms.c.a.a;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.a.d.f;
import com.baidu.swan.pms.c.a.d.h;
import com.baidu.swan.pms.c.a.d.i;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.c.c.b;
import com.baidu.swan.pms.c.c.c;
import com.baidu.swan.pms.c.c.e;
import com.baidu.swan.pms.model.d;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    public static synchronized void a(b bVar, g gVar) {
        synchronized (a.class) {
            f<d> b = h.b(bVar.cxV, gVar);
            f<com.baidu.swan.pms.model.f> a = h.a(bVar.cxR, gVar);
            f<com.baidu.swan.pms.model.b> b2 = h.b(bVar.cxX, gVar);
            List<f<com.baidu.swan.pms.model.g>> b3 = h.b(bVar.cxU, gVar);
            i iVar = new i(gVar);
            iVar.a(com.baidu.swan.pms.c.a.d.d.arF().i(b));
            iVar.a(com.baidu.swan.pms.c.a.d.d.arF().i(a));
            iVar.a(com.baidu.swan.pms.c.a.d.d.arF().i(b2));
            for (f<com.baidu.swan.pms.model.g> fVar : b3) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.arF().i(fVar));
            }
            iVar.startDownload();
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.c.a aVar, g gVar) {
        synchronized (a.class) {
            List<f<a.C0354a>> a = h.a(aVar.cxQ, gVar);
            i iVar = new i(gVar);
            for (f<a.C0354a> fVar : a) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.arF().i(fVar));
            }
            iVar.startDownload();
        }
    }

    public static synchronized void a(e eVar, g gVar) {
        synchronized (a.class) {
            f<d> b = h.b(eVar.cxV, gVar);
            f<com.baidu.swan.pms.model.b> b2 = h.b(eVar.cxX, gVar);
            i iVar = new i(gVar);
            iVar.a(com.baidu.swan.pms.c.a.d.d.arF().i(b));
            iVar.a(com.baidu.swan.pms.c.a.d.d.arF().i(b2));
            iVar.startDownload();
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.c.d dVar, g gVar) {
        synchronized (a.class) {
            List<f<com.baidu.swan.pms.model.g>> b = h.b(dVar.cxU, gVar);
            i iVar = new i(gVar);
            for (f<com.baidu.swan.pms.model.g> fVar : b) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.arF().i(fVar));
            }
            iVar.startDownload();
        }
    }

    public static synchronized void a(c cVar, g gVar) {
        synchronized (a.class) {
            f<com.baidu.swan.pms.model.h> a = h.a(cVar.cxY, gVar);
            i iVar = new i(gVar);
            iVar.a(com.baidu.swan.pms.c.a.d.d.arF().i(a));
            iVar.startDownload();
        }
    }

    public static synchronized void a(d dVar, g gVar) {
        synchronized (a.class) {
            f<d> b = h.b(dVar, gVar);
            i iVar = new i(gVar);
            iVar.a(com.baidu.swan.pms.c.a.d.d.arF().i(b));
            iVar.startDownload();
        }
    }

    public static synchronized void a(com.baidu.swan.pms.model.b bVar, g gVar) {
        synchronized (a.class) {
            f<com.baidu.swan.pms.model.b> b = h.b(bVar, gVar);
            i iVar = new i(gVar);
            iVar.a(com.baidu.swan.pms.c.a.d.d.arF().i(b));
            iVar.startDownload();
        }
    }
}
