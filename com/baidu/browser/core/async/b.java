package com.baidu.browser.core.async;

import java.util.HashMap;
/* loaded from: classes14.dex */
public final class b {
    private static HashMap<String, a> agX = new HashMap<>();

    public static synchronized a dg(String str) {
        a s;
        synchronized (b.class) {
            s = s(str, 0);
        }
        return s;
    }

    static synchronized a s(String str, int i) {
        a aVar;
        synchronized (b.class) {
            if (!agX.containsKey(str) || (aVar = agX.get(str)) == null) {
                aVar = new a(str, i);
                try {
                    aVar.start();
                } catch (Exception e) {
                }
                agX.put(str, aVar);
            }
        }
        return aVar;
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (aVar != null) {
                aVar.sF();
                agX.values().remove(aVar);
            }
        }
    }
}
