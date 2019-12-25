package com.baidu.pyramid.runtime.service;

import java.util.HashMap;
/* loaded from: classes11.dex */
public class e {
    private static final HashMap<d, b<?>> aQI = new HashMap<>();

    static {
        Co();
    }

    private static void Co() {
    }

    public static <T> void a(d dVar, b<T> bVar) {
        synchronized (aQI) {
            aQI.put(dVar, bVar);
        }
    }

    public static <T> T a(d dVar) {
        b<?> bVar = aQI.get(dVar);
        if (bVar != null) {
            return (T) bVar.getService();
        }
        return null;
    }
}
