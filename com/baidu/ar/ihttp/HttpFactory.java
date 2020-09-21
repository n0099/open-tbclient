package com.baidu.ar.ihttp;

import com.baidu.ar.g.n;
/* loaded from: classes10.dex */
public final class HttpFactory {
    private static volatile b rh;
    private static volatile int ri = 0;
    private static Object sLock = new Object();

    private static b eQ() {
        if (rh != null) {
            return rh;
        }
        if (isAvailable()) {
            synchronized (sLock) {
                if (rh == null) {
                    rh = (b) n.aS("com.baidu.ar.http.HttpRequestFactory");
                }
            }
        }
        return rh;
    }

    public static boolean isAvailable() {
        boolean z = false;
        if (ri == 1) {
            return true;
        }
        if (ri != -1) {
            try {
                Class.forName("com.baidu.ar.http.HttpRequestFactory");
                z = true;
            } catch (ClassNotFoundException e) {
            }
            synchronized (sLock) {
                ri = z ? 1 : -1;
            }
            return z;
        }
        return false;
    }

    public static IHttpRequest newRequest() {
        b eQ = eQ();
        if (eQ != null) {
            return eQ.newRequest();
        }
        return null;
    }

    public static void release() {
        if (rh != null) {
            rh.release();
            rh = null;
        }
    }
}
