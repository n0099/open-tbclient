package com.baidu.browser.core.async;

import java.util.HashMap;
/* loaded from: classes11.dex */
public final class b {
    private static HashMap<String, a> IJ = new HashMap<>();

    public static synchronized a bH(String str) {
        a n;
        synchronized (b.class) {
            n = n(str, 0);
        }
        return n;
    }

    static synchronized a n(String str, int i) {
        a aVar;
        synchronized (b.class) {
            if (!IJ.containsKey(str) || (aVar = IJ.get(str)) == null) {
                aVar = new a(str, i);
                try {
                    aVar.start();
                } catch (Exception e) {
                }
                IJ.put(str, aVar);
            }
        }
        return aVar;
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (aVar != null) {
                aVar.my();
                IJ.values().remove(aVar);
            }
        }
    }
}
