package com.baidu.swan.pms.c.a.a;

import android.support.annotation.NonNull;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.a.d.f;
import com.baidu.swan.pms.c.a.d.h;
import com.baidu.swan.pms.c.a.d.i;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.c.c.c;
import com.baidu.swan.pms.model.b;
import com.baidu.swan.pms.model.d;
import java.util.List;
/* loaded from: classes14.dex */
public class a {
    public static synchronized void a(com.baidu.swan.pms.node.d.a aVar, g gVar) {
        synchronized (a.class) {
            f<d> a = h.a(aVar.dGU, gVar);
            f<d> a2 = h.a(aVar.dGT, gVar);
            f<b> a3 = h.a(aVar.dGh, gVar);
            i iVar = new i(gVar);
            if (a != null) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.aTU().i(a));
            }
            if (a2 != null) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.aTU().i(a2));
            }
            if (a3 != null) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.aTU().i(a3));
            }
            if (aVar.dGV != null) {
                for (com.baidu.swan.pms.model.i iVar2 : aVar.dGV) {
                    f<com.baidu.swan.pms.model.i> a4 = h.a(iVar2, gVar);
                    if (a4 != null) {
                        iVar.a(com.baidu.swan.pms.c.a.d.d.aTU().i(a4));
                    }
                }
            }
            iVar.aUg();
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.c.b bVar, g gVar) {
        synchronized (a.class) {
            f<d> a = h.a(bVar.dGf, gVar);
            f<com.baidu.swan.pms.model.f> a2 = h.a(bVar.dGb, gVar);
            f<b> a3 = h.a(bVar.dGh, gVar);
            List<f<com.baidu.swan.pms.model.g>> b = h.b(bVar.dGc, gVar);
            i iVar = new i(gVar);
            iVar.a(com.baidu.swan.pms.c.a.d.d.aTU().i(a));
            iVar.a(com.baidu.swan.pms.c.a.d.d.aTU().i(a2));
            iVar.a(com.baidu.swan.pms.c.a.d.d.aTU().i(a3));
            for (f<com.baidu.swan.pms.model.g> fVar : b) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.aTU().i(fVar));
            }
            iVar.aUg();
        }
    }

    @NonNull
    public static i a(com.baidu.swan.pms.c.c.a aVar, g gVar) {
        List<f<a.C0520a>> a = h.a(aVar.dGa, gVar);
        i iVar = new i(gVar);
        for (f<a.C0520a> fVar : a) {
            iVar.a(com.baidu.swan.pms.c.a.d.d.aTU().i(fVar));
        }
        return iVar;
    }

    public static synchronized void a(com.baidu.swan.pms.c.c.d dVar, g gVar) {
        synchronized (a.class) {
            List<f<com.baidu.swan.pms.model.g>> b = h.b(dVar.dGc, gVar);
            i iVar = new i(gVar);
            for (f<com.baidu.swan.pms.model.g> fVar : b) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.aTU().i(fVar));
            }
            iVar.aUg();
        }
    }

    public static synchronized void a(c cVar, g gVar) {
        synchronized (a.class) {
            f<com.baidu.swan.pms.model.h> a = h.a(cVar.dGi, gVar);
            i iVar = new i(gVar);
            iVar.a(com.baidu.swan.pms.c.a.d.d.aTU().i(a));
            iVar.aUg();
        }
    }
}
