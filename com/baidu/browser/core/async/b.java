package com.baidu.browser.core.async;

import java.util.HashMap;
/* loaded from: classes19.dex */
public final class b {
    private static HashMap<String, a> aes = new HashMap<>();

    public static synchronized a dh(String str) {
        a s;
        synchronized (b.class) {
            s = s(str, 0);
        }
        return s;
    }

    static synchronized a s(String str, int i) {
        a aVar;
        synchronized (b.class) {
            if (!aes.containsKey(str) || (aVar = aes.get(str)) == null) {
                aVar = new a(str, i);
                try {
                    aVar.start();
                } catch (Exception e) {
                }
                aes.put(str, aVar);
            }
        }
        return aVar;
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (aVar != null) {
                aVar.tm();
                aes.values().remove(aVar);
            }
        }
    }
}
