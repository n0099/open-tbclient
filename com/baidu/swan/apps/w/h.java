package com.baidu.swan.apps.w;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class h {
    private static List<WeakReference<g>> aTG = new ArrayList();

    public static void a(g gVar) {
        boolean z;
        if (gVar != null) {
            int size = aTG.size() - 1;
            boolean z2 = false;
            while (size >= 0) {
                g gVar2 = aTG.get(size).get();
                if (gVar2 == null) {
                    aTG.remove(size);
                    z = z2;
                } else {
                    z = gVar2 == gVar;
                }
                size--;
                z2 = z;
            }
            if (!z2) {
                aTG.add(new WeakReference<>(gVar));
            }
        }
    }

    public static void b(g gVar) {
        if (gVar != null) {
            for (int size = aTG.size() - 1; size >= 0; size--) {
                g gVar2 = aTG.get(size).get();
                if (gVar2 == null || gVar == gVar2) {
                    aTG.remove(size);
                }
            }
        }
    }

    public static void a(com.baidu.swan.apps.b.c.e eVar) {
        for (int size = aTG.size() - 1; size >= 0; size--) {
            g gVar = aTG.get(size).get();
            if (gVar == null) {
                aTG.remove(size);
            } else {
                gVar.a(eVar);
            }
        }
    }

    public static void b(com.baidu.swan.apps.b.c.e eVar) {
        for (int size = aTG.size() - 1; size >= 0; size--) {
            g gVar = aTG.get(size).get();
            if (gVar == null) {
                aTG.remove(size);
            } else {
                gVar.b(eVar);
            }
        }
    }

    public static void c(com.baidu.swan.apps.b.c.e eVar) {
        for (int size = aTG.size() - 1; size >= 0; size--) {
            g gVar = aTG.get(size).get();
            if (gVar == null) {
                aTG.remove(size);
            } else {
                gVar.c(eVar);
            }
        }
    }

    public static void d(com.baidu.swan.apps.b.c.e eVar) {
        for (int size = aTG.size() - 1; size >= 0; size--) {
            g gVar = aTG.get(size).get();
            if (gVar == null) {
                aTG.remove(size);
            } else {
                gVar.d(eVar);
            }
        }
    }
}
