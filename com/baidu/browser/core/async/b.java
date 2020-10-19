package com.baidu.browser.core.async;

import java.util.HashMap;
/* loaded from: classes10.dex */
public final class b {
    private static HashMap<String, a> afb = new HashMap<>();

    public static synchronized a dj(String str) {
        a s;
        synchronized (b.class) {
            s = s(str, 0);
        }
        return s;
    }

    static synchronized a s(String str, int i) {
        a aVar;
        synchronized (b.class) {
            if (!afb.containsKey(str) || (aVar = afb.get(str)) == null) {
                aVar = new a(str, i);
                try {
                    aVar.start();
                } catch (Exception e) {
                }
                afb.put(str, aVar);
            }
        }
        return aVar;
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (aVar != null) {
                aVar.ts();
                afb.values().remove(aVar);
            }
        }
    }
}
