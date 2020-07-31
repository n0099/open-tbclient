package com.baidu.browser.core.async;

import java.util.HashMap;
/* loaded from: classes10.dex */
public final class b {
    private static HashMap<String, a> acL = new HashMap<>();

    public static synchronized a cW(String str) {
        a r;
        synchronized (b.class) {
            r = r(str, 0);
        }
        return r;
    }

    static synchronized a r(String str, int i) {
        a aVar;
        synchronized (b.class) {
            if (!acL.containsKey(str) || (aVar = acL.get(str)) == null) {
                aVar = new a(str, i);
                try {
                    aVar.start();
                } catch (Exception e) {
                }
                acL.put(str, aVar);
            }
        }
        return aVar;
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (aVar != null) {
                aVar.rA();
                acL.values().remove(aVar);
            }
        }
    }
}
