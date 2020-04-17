package com.baidu.ar.auth;

import com.baidu.ar.f.p;
/* loaded from: classes3.dex */
public class AuthJni {
    public static void setGrantedFeatures(final int[] iArr) {
        p.runOnUiThread(new Runnable() { // from class: com.baidu.ar.auth.AuthJni.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    new AuthJni().nativeSetGrantedFeatures(iArr);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    native void nativeSetGrantedFeatures(int[] iArr);

    public void sendAuthFailMessageFromNative(int i) {
        a.receiveAuthFailMessage(i);
    }
}
