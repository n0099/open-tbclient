package com.baidu.browser.core.async;

import java.util.HashMap;
/* loaded from: classes4.dex */
public final class b {
    private static HashMap<String, a> afL = new HashMap<>();

    public static synchronized a dc(String str) {
        a s;
        synchronized (b.class) {
            s = s(str, 0);
        }
        return s;
    }

    static synchronized a s(String str, int i) {
        a aVar;
        synchronized (b.class) {
            if (!afL.containsKey(str) || (aVar = afL.get(str)) == null) {
                aVar = new a(str, i);
                try {
                    aVar.start();
                } catch (Exception e) {
                }
                afL.put(str, aVar);
            }
        }
        return aVar;
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (aVar != null) {
                aVar.sI();
                afL.values().remove(aVar);
            }
        }
    }
}
