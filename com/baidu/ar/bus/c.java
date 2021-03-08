package com.baidu.ar.bus;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
final class c {
    private static final List<c> kC = new ArrayList();
    Object kD;
    g kE;
    c kF;

    private c(Object obj, g gVar) {
        this.kD = obj;
        this.kE = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(c cVar) {
        cVar.kD = null;
        cVar.kE = null;
        cVar.kF = null;
        synchronized (kC) {
            if (kC.size() < 20) {
                kC.add(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c d(g gVar, Object obj) {
        synchronized (kC) {
            int size = kC.size();
            if (size > 0) {
                c remove = kC.remove(size - 1);
                remove.kD = obj;
                remove.kE = gVar;
                remove.kF = null;
                return remove;
            }
            return new c(obj, gVar);
        }
    }
}
