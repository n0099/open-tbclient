package com.baidu.swan.facade.a;
/* loaded from: classes14.dex */
public class f {
    private static volatile e dht;

    public static synchronized e aHh() {
        e eVar;
        synchronized (f.class) {
            if (dht == null) {
                dht = new e();
            }
            eVar = dht;
        }
        return eVar;
    }
}
