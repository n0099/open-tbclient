package com.baidu.ar.bus;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class c {
    public static final List<c> kC = new ArrayList();
    public Object kD;
    public g kE;
    public c kF;

    public c(Object obj, g gVar) {
        this.kD = obj;
        this.kE = gVar;
    }

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
