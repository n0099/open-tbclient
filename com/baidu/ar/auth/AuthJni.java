package com.baidu.ar.auth;

import com.baidu.ar.h.r;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.ar.statistic.StatisticApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class AuthJni {
    public static volatile AuthJni jC;
    public final List<Runnable> jE = new ArrayList();
    public boolean jD = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void cy() {
        for (Runnable runnable : this.jE) {
            runnable.run();
        }
        this.jE.clear();
    }

    public static void d(String str, String str2) {
        String name = Thread.currentThread().getName();
        HashMap hashMap = new HashMap();
        hashMap.put("event_param", name + "_" + str + "_" + str2);
        hashMap.put("feature_code", str);
        StatisticApi.onEvent("event_authjni_error", hashMap);
    }

    public static void init() {
        jC = new AuthJni();
        com.baidu.ar.libloader.a.require("ardatabasic");
        com.baidu.ar.libloader.a.setLibReadyListener("ardatabasic", new ILibLoader.c() { // from class: com.baidu.ar.auth.AuthJni.1
            @Override // com.baidu.ar.libloader.ILibLoader.c
            public void onReady() {
                r.runOnUiThread(new Runnable() { // from class: com.baidu.ar.auth.AuthJni.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AuthJni.jC != null) {
                            try {
                                AuthJni.jC.nativeInit();
                                AuthJni.jC.jD = true;
                                AuthJni.jC.cy();
                            } catch (Throwable th) {
                                th.printStackTrace();
                                AuthJni.d(AuthJni.jC.getVersionStr(), th.getMessage());
                            }
                        }
                    }
                });
            }
        });
    }

    public static void release() {
        if (jC != null) {
            jC.jE.clear();
            r.runOnUiThread(new Runnable() { // from class: com.baidu.ar.auth.AuthJni.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AuthJni.jC.nativeDestroy();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    AuthJni unused = AuthJni.jC = null;
                }
            });
        }
    }

    public static void setGrantedFeatures(final int[] iArr) {
        if (jC == null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.baidu.ar.auth.AuthJni.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AuthJni.jC != null) {
                        AuthJni.jC.nativeSetGrantedFeatures(iArr);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    if (AuthJni.jC != null) {
                        AuthJni.jC.nativePutGrantedFeatures(iArr);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        };
        if (jC.jD) {
            r.runOnUiThread(runnable);
        } else {
            jC.jE.add(runnable);
        }
    }

    public String getVersionStr() {
        try {
            int nativeGetVersion = nativeGetVersion();
            return "ver-" + nativeGetVersion;
        } catch (Throwable th) {
            th.printStackTrace();
            return "EXCEPTION-UNKNOWN";
        }
    }

    public native void nativeDestroy();

    public native int nativeGetVersion();

    public native void nativeInit();

    public native void nativePutGrantedFeatures(int[] iArr);

    public native void nativeSetGrantedFeatures(int[] iArr);

    public void sendAuthFailMessageFromNative(int i) {
        ARAuth.receiveAuthFailMessage(i);
    }
}
