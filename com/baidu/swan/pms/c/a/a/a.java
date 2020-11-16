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
/* loaded from: classes6.dex */
public class a {
    public static synchronized void a(com.baidu.swan.pms.node.d.a aVar, g gVar) {
        synchronized (a.class) {
            f<d> a2 = h.a(aVar.ehK, gVar);
            f<d> a3 = h.a(aVar.ehJ, gVar);
            f<b> a4 = h.a(aVar.egX, gVar);
            i iVar = new i(gVar);
            if (a2 != null) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.bbb().i(a2));
            }
            if (a3 != null) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.bbb().i(a3));
            }
            if (a4 != null) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.bbb().i(a4));
            }
            if (aVar.ehL != null) {
                for (com.baidu.swan.pms.model.i iVar2 : aVar.ehL) {
                    f<com.baidu.swan.pms.model.i> a5 = h.a(iVar2, gVar);
                    if (a5 != null) {
                        iVar.a(com.baidu.swan.pms.c.a.d.d.bbb().i(a5));
                    }
                }
            }
            iVar.bbn();
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.c.b bVar, g gVar) {
        synchronized (a.class) {
            f<d> a2 = h.a(bVar.egV, gVar);
            f<com.baidu.swan.pms.model.f> a3 = h.a(bVar.egR, gVar);
            f<b> a4 = h.a(bVar.egX, gVar);
            List<f<com.baidu.swan.pms.model.g>> b = h.b(bVar.egS, gVar);
            i iVar = new i(gVar);
            iVar.a(com.baidu.swan.pms.c.a.d.d.bbb().i(a2));
            iVar.a(com.baidu.swan.pms.c.a.d.d.bbb().i(a3));
            iVar.a(com.baidu.swan.pms.c.a.d.d.bbb().i(a4));
            for (f<com.baidu.swan.pms.model.g> fVar : b) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.bbb().i(fVar));
            }
            iVar.bbn();
        }
    }

    @NonNull
    public static i a(com.baidu.swan.pms.c.c.a aVar, g gVar) {
        List<f<a.C0556a>> a2 = h.a(aVar.egQ, gVar);
        i iVar = new i(gVar);
        for (f<a.C0556a> fVar : a2) {
            iVar.a(com.baidu.swan.pms.c.a.d.d.bbb().i(fVar));
        }
        return iVar;
    }

    public static synchronized void a(com.baidu.swan.pms.c.c.d dVar, g gVar) {
        synchronized (a.class) {
            List<f<com.baidu.swan.pms.model.g>> b = h.b(dVar.egS, gVar);
            i iVar = new i(gVar);
            for (f<com.baidu.swan.pms.model.g> fVar : b) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.bbb().i(fVar));
            }
            iVar.bbn();
        }
    }

    public static synchronized void a(c cVar, g gVar) {
        synchronized (a.class) {
            f<com.baidu.swan.pms.model.h> a2 = h.a(cVar.egY, gVar);
            i iVar = new i(gVar);
            iVar.a(com.baidu.swan.pms.c.a.d.d.bbb().i(a2));
            iVar.bbn();
        }
    }
}
