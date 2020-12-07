package com.baidu.browser.core.async;

import java.util.HashMap;
/* loaded from: classes11.dex */
public final class b {
    private static HashMap<String, a> agc = new HashMap<>();

    /* renamed from: do  reason: not valid java name */
    public static synchronized a m18do(String str) {
        a s;
        synchronized (b.class) {
            s = s(str, 0);
        }
        return s;
    }

    static synchronized a s(String str, int i) {
        a aVar;
        synchronized (b.class) {
            if (!agc.containsKey(str) || (aVar = agc.get(str)) == null) {
                aVar = new a(str, i);
                try {
                    aVar.start();
                } catch (Exception e) {
                }
                agc.put(str, aVar);
            }
        }
        return aVar;
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (aVar != null) {
                aVar.tv();
                agc.values().remove(aVar);
            }
        }
    }
}
