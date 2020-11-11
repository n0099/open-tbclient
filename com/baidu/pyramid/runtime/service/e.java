package com.baidu.pyramid.runtime.service;

import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.ubc.UBC;
import com.baidu.ubc.ac;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class e {
    private static final HashMap<d, b<?>> ckb = new HashMap<>();

    static {
        adA();
    }

    private static void adA() {
        a("account", OneKeyLoginSdkCall.k, com.baidu.tieba.write.b.b.b.class);
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
        synchronized (ckb) {
            ckb.put(dVar, bVar);
        }
    }

    public static <T> T a(d dVar) {
        b<?> bVar = ckb.get(dVar);
        if (bVar != null) {
            return (T) bVar.ady();
        }
        return null;
    }
}
