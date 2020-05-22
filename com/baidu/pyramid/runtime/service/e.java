package com.baidu.pyramid.runtime.service;

import com.baidu.ubc.UBC;
import com.baidu.ubc.ac;
import java.util.HashMap;
/* loaded from: classes13.dex */
public class e {
    private static final HashMap<d, b<?>> bCr = new HashMap<>();

    static {
        Pl();
    }

    private static void Pl() {
        a("account", com.baidu.sapi2.outsdk.c.k, com.baidu.tieba.write.b.b.b.class);
        a("ubc", UBC.TAG, ac.class);
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
        synchronized (bCr) {
            bCr.put(dVar, bVar);
        }
    }

    public static <T> T a(d dVar) {
        b<?> bVar = bCr.get(dVar);
        if (bVar != null) {
            return (T) bVar.Pj();
        }
        return null;
    }
}
