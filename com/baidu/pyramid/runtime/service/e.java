package com.baidu.pyramid.runtime.service;

import java.util.HashMap;
/* loaded from: classes13.dex */
public class e {
    private static final HashMap<d, b<?>> aWo = new HashMap<>();

    static {
        Fn();
    }

    private static void Fn() {
    }

    public static <T> void a(d dVar, b<T> bVar) {
        synchronized (aWo) {
            aWo.put(dVar, bVar);
        }
    }

    public static <T> T a(d dVar) {
        b<?> bVar = aWo.get(dVar);
        if (bVar != null) {
            return (T) bVar.getService();
        }
        return null;
    }
}
