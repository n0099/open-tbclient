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
/* loaded from: classes11.dex */
public class a {
    public static synchronized void a(b bVar, g gVar) {
        synchronized (a.class) {
            f<d> b = h.b(bVar.cCg, gVar);
            f<com.baidu.swan.pms.model.f> a = h.a(bVar.cCc, gVar);
            f<com.baidu.swan.pms.model.b> b2 = h.b(bVar.cCi, gVar);
            List<f<com.baidu.swan.pms.model.g>> b3 = h.b(bVar.cCf, gVar);
            i iVar = new i(gVar);
            iVar.a(com.baidu.swan.pms.c.a.d.d.atY().i(b));
            iVar.a(com.baidu.swan.pms.c.a.d.d.atY().i(a));
            iVar.a(com.baidu.swan.pms.c.a.d.d.atY().i(b2));
            for (f<com.baidu.swan.pms.model.g> fVar : b3) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.atY().i(fVar));
            }
            iVar.startDownload();
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.c.a aVar, g gVar) {
        synchronized (a.class) {
            List<f<a.C0364a>> a = h.a(aVar.cCb, gVar);
            i iVar = new i(gVar);
            for (f<a.C0364a> fVar : a) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.atY().i(fVar));
            }
            iVar.startDownload();
        }
    }

    public static synchronized void a(e eVar, g gVar) {
        synchronized (a.class) {
            f<d> b = h.b(eVar.cCg, gVar);
            f<com.baidu.swan.pms.model.b> b2 = h.b(eVar.cCi, gVar);
            i iVar = new i(gVar);
            iVar.a(com.baidu.swan.pms.c.a.d.d.atY().i(b));
            iVar.a(com.baidu.swan.pms.c.a.d.d.atY().i(b2));
            iVar.startDownload();
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.c.d dVar, g gVar) {
        synchronized (a.class) {
            List<f<com.baidu.swan.pms.model.g>> b = h.b(dVar.cCf, gVar);
            i iVar = new i(gVar);
            for (f<com.baidu.swan.pms.model.g> fVar : b) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.atY().i(fVar));
            }
            iVar.startDownload();
        }
    }

    public static synchronized void a(c cVar, g gVar) {
        synchronized (a.class) {
            f<com.baidu.swan.pms.model.h> a = h.a(cVar.cCj, gVar);
            i iVar = new i(gVar);
            iVar.a(com.baidu.swan.pms.c.a.d.d.atY().i(a));
            iVar.startDownload();
        }
    }

    public static synchronized void a(d dVar, g gVar) {
        synchronized (a.class) {
            f<d> b = h.b(dVar, gVar);
            i iVar = new i(gVar);
            iVar.a(com.baidu.swan.pms.c.a.d.d.atY().i(b));
            iVar.startDownload();
        }
    }

    public static synchronized void a(com.baidu.swan.pms.model.b bVar, g gVar) {
        synchronized (a.class) {
            f<com.baidu.swan.pms.model.b> b = h.b(bVar, gVar);
            i iVar = new i(gVar);
            iVar.a(com.baidu.swan.pms.c.a.d.d.atY().i(b));
            iVar.startDownload();
        }
    }
}
