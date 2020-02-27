package com.baidu.pyramid.runtime.service;

import java.util.HashMap;
/* loaded from: classes13.dex */
public class e {
    private static final HashMap<d, b<?>> aVZ = new HashMap<>();

    static {
        Fg();
    }

    private static void Fg() {
    }

    public static <T> void a(d dVar, b<T> bVar) {
        synchronized (aVZ) {
            aVZ.put(dVar, bVar);
        }
    }

    public static <T> T a(d dVar) {
        b<?> bVar = aVZ.get(dVar);
        if (bVar != null) {
            return (T) bVar.getService();
        }
        return null;
    }
}
