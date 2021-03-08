package com.baidu.ar.ihttp;

import com.baidu.ar.h.n;
/* loaded from: classes3.dex */
public final class HttpFactory {
    private static volatile b ry;
    private static volatile int rz = 0;
    private static Object sLock = new Object();

    private static b eP() {
        if (ry != null) {
            return ry;
        }
        if (isAvailable()) {
            synchronized (sLock) {
                if (ry == null) {
                    ry = (b) n.aV("com.baidu.ar.http.HttpRequestFactory");
                }
            }
        }
        return ry;
    }

    public static boolean isAvailable() {
        boolean z = false;
        if (rz == 1) {
            return true;
        }
        if (rz != -1) {
            try {
                Class.forName("com.baidu.ar.http.HttpRequestFactory");
                z = true;
            } catch (ClassNotFoundException e) {
            }
            synchronized (sLock) {
                rz = z ? 1 : -1;
            }
            return z;
        }
        return false;
    }

    public static IHttpRequest newRequest() {
        b eP = eP();
        if (eP != null) {
            return eP.newRequest();
        }
        return null;
    }

    public static void release() {
        if (ry != null) {
            ry.release();
            ry = null;
        }
    }
}
