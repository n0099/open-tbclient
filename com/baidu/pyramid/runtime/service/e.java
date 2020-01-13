package com.baidu.pyramid.runtime.service;

import java.util.HashMap;
/* loaded from: classes12.dex */
public class e {
    private static final HashMap<d, b<?>> aRA = new HashMap<>();

    static {
        CK();
    }

    private static void CK() {
    }

    public static <T> void a(d dVar, b<T> bVar) {
        synchronized (aRA) {
            aRA.put(dVar, bVar);
        }
    }

    public static <T> T a(d dVar) {
        b<?> bVar = aRA.get(dVar);
        if (bVar != null) {
            return (T) bVar.getService();
        }
        return null;
    }
}
