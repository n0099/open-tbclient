package com.baidu.swan.apps.t.a;
/* loaded from: classes14.dex */
public class f {
    private static volatile e cvs;

    public static synchronized e aqi() {
        e eVar;
        synchronized (f.class) {
            if (cvs == null) {
                cvs = new e();
            }
            eVar = cvs;
        }
        return eVar;
    }
}
