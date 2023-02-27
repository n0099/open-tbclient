package com.baidu.ar.ihttp;

import com.baidu.ar.h.n;
/* loaded from: classes.dex */
public final class HttpFactory {
    public static volatile b ry;
    public static volatile int rz;
    public static Object sLock = new Object();

    public static b eP() {
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
        if (rz == 1) {
            return true;
        }
        boolean z = false;
        if (rz == -1) {
            return false;
        }
        try {
            Class.forName("com.baidu.ar.http.HttpRequestFactory");
            z = true;
        } catch (ClassNotFoundException unused) {
        }
        synchronized (sLock) {
            rz = z ? 1 : -1;
        }
        return z;
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
