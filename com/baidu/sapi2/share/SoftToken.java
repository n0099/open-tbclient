package com.baidu.sapi2.share;

import com.baidu.sapi2.utils.L;
/* loaded from: classes.dex */
public class SoftToken {
    private static final String a = "sapi_web_connector_v1";

    public static native String getToken(String str, int i);

    static {
        try {
            System.loadLibrary(a);
        } catch (Throwable th) {
            L.e(th);
        }
    }
}
