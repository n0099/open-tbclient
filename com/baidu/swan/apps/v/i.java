package com.baidu.swan.apps.v;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes25.dex */
public class i {
    private static List<WeakReference<h>> deY = new ArrayList();

    public static void a(h hVar) {
        boolean z;
        if (hVar != null) {
            int size = deY.size() - 1;
            boolean z2 = false;
            while (size >= 0) {
                h hVar2 = deY.get(size).get();
                if (hVar2 == null) {
                    deY.remove(size);
                    z = z2;
                } else {
                    z = hVar2 == hVar;
                }
                size--;
                z2 = z;
            }
            if (!z2) {
                deY.add(new WeakReference<>(hVar));
            }
        }
    }

    public static void b(h hVar) {
        if (hVar != null) {
            for (int size = deY.size() - 1; size >= 0; size--) {
                h hVar2 = deY.get(size).get();
                if (hVar2 == null || hVar == hVar2) {
                    deY.remove(size);
                }
            }
        }
    }

    public static void a(com.baidu.swan.apps.adaptation.b.e eVar) {
        for (int size = deY.size() - 1; size >= 0; size--) {
            h hVar = deY.get(size).get();
            if (hVar == null) {
                deY.remove(size);
            } else {
                hVar.a(eVar);
            }
        }
    }

    public static void b(com.baidu.swan.apps.adaptation.b.e eVar) {
        for (int size = deY.size() - 1; size >= 0; size--) {
            h hVar = deY.get(size).get();
            if (hVar == null) {
                deY.remove(size);
            } else {
                hVar.b(eVar);
            }
        }
    }

    public static void c(com.baidu.swan.apps.adaptation.b.e eVar) {
        for (int size = deY.size() - 1; size >= 0; size--) {
            h hVar = deY.get(size).get();
            if (hVar == null) {
                deY.remove(size);
            } else {
                hVar.c(eVar);
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.e eVar) {
        for (int size = deY.size() - 1; size >= 0; size--) {
            h hVar = deY.get(size).get();
            if (hVar == null) {
                deY.remove(size);
            } else {
                hVar.d(eVar);
            }
        }
    }
}
