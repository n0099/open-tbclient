package com.baidu.swan.apps.scheme;
/* loaded from: classes7.dex */
public class d {
    private static volatile c bQN;

    public static synchronized c adL() {
        c cVar;
        synchronized (d.class) {
            if (bQN == null) {
                bQN = new c();
            }
            cVar = bQN;
        }
        return cVar;
    }
}
