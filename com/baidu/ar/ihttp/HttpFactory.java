package com.baidu.ar.ihttp;

import com.baidu.ar.f.l;
/* loaded from: classes3.dex */
public final class HttpFactory {
    private static volatile b qC;
    private static volatile int qD = 0;
    private static Object sLock = new Object();

    private static b dG() {
        if (qC != null) {
            return qC;
        }
        if (isAvailable()) {
            synchronized (sLock) {
                if (qC == null) {
                    qC = (b) l.aO("com.baidu.ar.http.HttpRequestFactory");
                }
            }
        }
        return qC;
    }

    public static boolean isAvailable() {
        boolean z = false;
        if (qD == 1) {
            return true;
        }
        if (qD != -1) {
            try {
                Class.forName("com.baidu.ar.http.HttpRequestFactory");
                z = true;
            } catch (ClassNotFoundException e) {
            }
            synchronized (sLock) {
                qD = z ? 1 : -1;
            }
            return z;
        }
        return false;
    }

    public static IHttpRequest newRequest() {
        b dG = dG();
        if (dG != null) {
            return dG.newRequest();
        }
        return null;
    }

    public static void release() {
        if (qC != null) {
            qC.release();
            qC = null;
        }
    }
}
