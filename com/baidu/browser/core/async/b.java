package com.baidu.browser.core.async;

import java.util.HashMap;
/* loaded from: classes11.dex */
public final class b {
    private static HashMap<String, a> abT = new HashMap<>();

    public static synchronized a cV(String str) {
        a r;
        synchronized (b.class) {
            r = r(str, 0);
        }
        return r;
    }

    static synchronized a r(String str, int i) {
        a aVar;
        synchronized (b.class) {
            if (!abT.containsKey(str) || (aVar = abT.get(str)) == null) {
                aVar = new a(str, i);
                try {
                    aVar.start();
                } catch (Exception e) {
                }
                abT.put(str, aVar);
            }
        }
        return aVar;
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (aVar != null) {
                aVar.ra();
                abT.values().remove(aVar);
            }
        }
    }
}
