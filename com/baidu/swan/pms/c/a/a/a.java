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
/* loaded from: classes19.dex */
public class a {
    public static synchronized void a(com.baidu.swan.pms.node.d.a aVar, g gVar) {
        synchronized (a.class) {
            f<d> a = h.a(aVar.dxO, gVar);
            f<d> a2 = h.a(aVar.dxN, gVar);
            f<b> a3 = h.a(aVar.dxc, gVar);
            i iVar = new i(gVar);
            if (a != null) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.aLv().i(a));
            }
            if (a2 != null) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.aLv().i(a2));
            }
            if (a3 != null) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.aLv().i(a3));
            }
            iVar.aLH();
        }
    }

    public static synchronized void a(com.baidu.swan.pms.c.c.b bVar, g gVar) {
        synchronized (a.class) {
            f<d> a = h.a(bVar.dxa, gVar);
            f<com.baidu.swan.pms.model.f> a2 = h.a(bVar.dwW, gVar);
            f<b> a3 = h.a(bVar.dxc, gVar);
            List<f<com.baidu.swan.pms.model.g>> b = h.b(bVar.dwX, gVar);
            i iVar = new i(gVar);
            iVar.a(com.baidu.swan.pms.c.a.d.d.aLv().i(a));
            iVar.a(com.baidu.swan.pms.c.a.d.d.aLv().i(a2));
            iVar.a(com.baidu.swan.pms.c.a.d.d.aLv().i(a3));
            for (f<com.baidu.swan.pms.model.g> fVar : b) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.aLv().i(fVar));
            }
            iVar.aLH();
        }
    }

    @NonNull
    public static i a(com.baidu.swan.pms.c.c.a aVar, g gVar) {
        List<f<a.C0474a>> a = h.a(aVar.dwV, gVar);
        i iVar = new i(gVar);
        for (f<a.C0474a> fVar : a) {
            iVar.a(com.baidu.swan.pms.c.a.d.d.aLv().i(fVar));
        }
        return iVar;
    }

    public static synchronized void a(com.baidu.swan.pms.c.c.d dVar, g gVar) {
        synchronized (a.class) {
            List<f<com.baidu.swan.pms.model.g>> b = h.b(dVar.dwX, gVar);
            i iVar = new i(gVar);
            for (f<com.baidu.swan.pms.model.g> fVar : b) {
                iVar.a(com.baidu.swan.pms.c.a.d.d.aLv().i(fVar));
            }
            iVar.aLH();
        }
    }

    public static synchronized void a(c cVar, g gVar) {
        synchronized (a.class) {
            f<com.baidu.swan.pms.model.h> a = h.a(cVar.dxd, gVar);
            i iVar = new i(gVar);
            iVar.a(com.baidu.swan.pms.c.a.d.d.aLv().i(a));
            iVar.aLH();
        }
    }
}
