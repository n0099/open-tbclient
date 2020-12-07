package com.baidu.pyramid.runtime.service;

import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.ubc.UBC;
import com.baidu.ubc.ae;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class e {
    private static final HashMap<d, b<?>> coY = new HashMap<>();

    static {
        agb();
    }

    private static void agb() {
        a("account", OneKeyLoginSdkCall.k, com.baidu.tieba.write.b.b.b.class);
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
        synchronized (coY) {
            coY.put(dVar, bVar);
        }
    }

    public static <T> T a(d dVar) {
        b<?> bVar = coY.get(dVar);
        if (bVar != null) {
            return (T) bVar.afZ();
        }
        return null;
    }
}
