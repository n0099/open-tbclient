package com.baidu.pyramid.runtime.service;

import com.baidu.ubc.UBC;
import com.baidu.ubc.ae;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class e {
    private static final HashMap<d, b<?>> ctb = new HashMap<>();

    static {
        aev();
    }

    private static void aev() {
        a("ubc", UBC.TAG, ae.class);
    }

    private static <T> void a(String str, String str2, Class<? extends b<T>> cls) {
        try {
            a(new d(str, str2), cls.newInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        }
    }

    public static <T> void a(d dVar, b<T> bVar) {
        synchronized (ctb) {
            ctb.put(dVar, bVar);
        }
    }

    public static <T> T a(d dVar) {
        b<?> bVar = ctb.get(dVar);
        if (bVar != null) {
            return (T) bVar.aet();
        }
        return null;
    }
}
