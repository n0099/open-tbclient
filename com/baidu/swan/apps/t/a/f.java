package com.baidu.swan.apps.t.a;
/* loaded from: classes14.dex */
public class f {
    private static volatile e cvw;

    public static synchronized e aqi() {
        e eVar;
        synchronized (f.class) {
            if (cvw == null) {
                cvw = new e();
            }
            eVar = cvw;
        }
        return eVar;
    }
}
