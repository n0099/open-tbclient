package com.baidu.browser.core.async;

import java.util.HashMap;
/* loaded from: classes11.dex */
public final class b {
    private static HashMap<String, a> abQ = new HashMap<>();

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
            if (!abQ.containsKey(str) || (aVar = abQ.get(str)) == null) {
                aVar = new a(str, i);
                try {
                    aVar.start();
                } catch (Exception e) {
                }
                abQ.put(str, aVar);
            }
        }
        return aVar;
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (aVar != null) {
                aVar.ra();
                abQ.values().remove(aVar);
            }
        }
    }
}
