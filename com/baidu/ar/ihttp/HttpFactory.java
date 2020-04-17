package com.baidu.ar.ihttp;

import com.baidu.ar.f.l;
/* loaded from: classes3.dex */
public final class HttpFactory {
    private static volatile b qd;
    private static volatile int qe = 0;
    private static Object sLock = new Object();

    private static b dq() {
        if (qd != null) {
            return qd;
        }
        if (isAvailable()) {
            synchronized (sLock) {
                if (qd == null) {
                    qd = (b) l.aN("com.baidu.ar.http.HttpRequestFactory");
                }
            }
        }
        return qd;
    }

    public static boolean isAvailable() {
        boolean z = false;
        if (qe == 1) {
            return true;
        }
        if (qe != -1) {
            try {
                Class.forName("com.baidu.ar.http.HttpRequestFactory");
                z = true;
            } catch (ClassNotFoundException e) {
            }
            synchronized (sLock) {
                qe = z ? 1 : -1;
            }
            return z;
        }
        return false;
    }

    public static IHttpRequest newRequest() {
        b dq = dq();
        if (dq != null) {
            return dq.newRequest();
        }
        return null;
    }

    public static void release() {
        if (qd != null) {
            qd.release();
            qd = null;
        }
    }
}
