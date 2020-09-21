package com.baidu.ar.bus;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
final class c {
    private static final List<c> kn = new ArrayList();
    Object ko;
    g kp;
    c kq;

    private c(Object obj, g gVar) {
        this.ko = obj;
        this.kp = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(c cVar) {
        cVar.ko = null;
        cVar.kp = null;
        cVar.kq = null;
        synchronized (kn) {
            if (kn.size() < 20) {
                kn.add(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c d(g gVar, Object obj) {
        synchronized (kn) {
            int size = kn.size();
            if (size > 0) {
                c remove = kn.remove(size - 1);
                remove.ko = obj;
                remove.kp = gVar;
                remove.kq = null;
                return remove;
            }
            return new c(obj, gVar);
        }
    }
}
