package com.baidu.browser.core.async;

import java.util.HashMap;
/* loaded from: classes10.dex */
public final class b {
    private static HashMap<String, a> In = new HashMap<>();

    public static synchronized a bF(String str) {
        a n;
        synchronized (b.class) {
            n = n(str, 0);
        }
        return n;
    }

    static synchronized a n(String str, int i) {
        a aVar;
        synchronized (b.class) {
            if (!In.containsKey(str) || (aVar = In.get(str)) == null) {
                aVar = new a(str, i);
                try {
                    aVar.start();
                } catch (Exception e) {
                }
                In.put(str, aVar);
            }
        }
        return aVar;
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (aVar != null) {
                aVar.mj();
                In.values().remove(aVar);
            }
        }
    }
}
