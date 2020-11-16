package com.baidu.browser.core.async;

import java.util.HashMap;
/* loaded from: classes11.dex */
public final class b {
    private static HashMap<String, a> afh = new HashMap<>();

    public static synchronized a dl(String str) {
        a s;
        synchronized (b.class) {
            s = s(str, 0);
        }
        return s;
    }

    static synchronized a s(String str, int i) {
        a aVar;
        synchronized (b.class) {
            if (!afh.containsKey(str) || (aVar = afh.get(str)) == null) {
                aVar = new a(str, i);
                try {
                    aVar.start();
                } catch (Exception e) {
                }
                afh.put(str, aVar);
            }
        }
        return aVar;
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (aVar != null) {
                aVar.ts();
                afh.values().remove(aVar);
            }
        }
    }
}
