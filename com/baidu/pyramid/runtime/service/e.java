package com.baidu.pyramid.runtime.service;

import java.util.HashMap;
/* loaded from: classes13.dex */
public class e {
    private static final HashMap<d, b<?>> aWb = new HashMap<>();

    static {
        Fi();
    }

    private static void Fi() {
    }

    public static <T> void a(d dVar, b<T> bVar) {
        synchronized (aWb) {
            aWb.put(dVar, bVar);
        }
    }

    public static <T> T a(d dVar) {
        b<?> bVar = aWb.get(dVar);
        if (bVar != null) {
            return (T) bVar.getService();
        }
        return null;
    }
}
