package com.baidu.swan.pms.c.a.a;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.a.d.f;
import com.baidu.swan.pms.c.a.d.h;
import com.baidu.swan.pms.c.a.d.i;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.c.c.c;
import com.baidu.swan.pms.model.b;
import com.baidu.swan.pms.model.d;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    public static synchronized void a(com.baidu.swan.pms.node.d.a aVar, g gVar) {
        synchronized (a.class) {
            f<d> a = h.a(aVar.dnl, gVar);
            f<d> a2 = h.a(aVar.dnk, gVar);
            f<b> a3 = h.a(aVar.dmz, gVar);
            i iVar = new i(gVar);
            if (a != null) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.aGy().i(a));
            }
            if (a2 != null) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.aGy().i(a2));
            }
            if (a3 != null) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.aGy().i(a3));
            }
            iVar.aGK();
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.c.b bVar, g gVar) {
        synchronized (a.class) {
            f<d> a = h.a(bVar.dmx, gVar);
            f<com.baidu.swan.pms.model.f> a2 = h.a(bVar.dmt, gVar);
            f<b> a3 = h.a(bVar.dmz, gVar);
            List<f<com.baidu.swan.pms.model.g>> b = h.b(bVar.dmw, gVar);
            i iVar = new i(gVar);
            iVar.a(com.baidu.swan.pms.c.a.d.d.aGy().i(a));
            iVar.a(com.baidu.swan.pms.c.a.d.d.aGy().i(a2));
            iVar.a(com.baidu.swan.pms.c.a.d.d.aGy().i(a3));
            for (f<com.baidu.swan.pms.model.g> fVar : b) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.aGy().i(fVar));
            }
            iVar.aGK();
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.c.a aVar, g gVar) {
        synchronized (a.class) {
            List<f<a.C0456a>> a = h.a(aVar.dms, gVar);
            i iVar = new i(gVar);
            for (f<a.C0456a> fVar : a) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.aGy().i(fVar));
            }
            iVar.aGK();
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.c.d dVar, g gVar) {
        synchronized (a.class) {
            List<f<com.baidu.swan.pms.model.g>> b = h.b(dVar.dmw, gVar);
            i iVar = new i(gVar);
            for (f<com.baidu.swan.pms.model.g> fVar : b) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.aGy().i(fVar));
            }
            iVar.aGK();
        }
    }

    public static synchronized void a(c cVar, g gVar) {
        synchronized (a.class) {
            f<com.baidu.swan.pms.model.h> a = h.a(cVar.dmA, gVar);
            i iVar = new i(gVar);
            iVar.a(com.baidu.swan.pms.c.a.d.d.aGy().i(a));
            iVar.aGK();
        }
    }
}
