package com.baidu.ar.auth;

import com.baidu.ar.g.r;
import com.baidu.ar.libloader.a;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes14.dex */
public class AuthJni {
    private static volatile AuthJni jn;
    private final List<Runnable> jp = new ArrayList();
    private boolean jo = false;

    private AuthJni() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz() {
        for (Runnable runnable : this.jp) {
            runnable.run();
        }
        this.jp.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, String str2) {
        String name = Thread.currentThread().getName();
        HashMap hashMap = new HashMap();
        hashMap.put("event_param", name + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2);
        hashMap.put("feature_code", str);
        StatisticApi.onEvent("event_authjni_error", hashMap);
    }

    public static void init() {
        jn = new AuthJni();
        com.baidu.ar.libloader.b.as("ardatabasic2");
        com.baidu.ar.libloader.b.a("ardatabasic2", new a.c() { // from class: com.baidu.ar.auth.AuthJni.1
            @Override // com.baidu.ar.libloader.a.c
            public void onReady() {
                r.runOnUiThread(new Runnable() { // from class: com.baidu.ar.auth.AuthJni.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AuthJni.jn != null) {
                            try {
                                AuthJni.jn.nativeInit();
                                AuthJni.jn.jo = true;
                                AuthJni.jn.cz();
                            } catch (Throwable th) {
                                th.printStackTrace();
                                AuthJni.d(AuthJni.jn.getVersionStr(), th.getMessage());
                            }
                        }
                    }
                });
            }
        });
    }

    public static void release() {
        if (jn != null) {
            jn.jp.clear();
            r.runOnUiThread(new Runnable() { // from class: com.baidu.ar.auth.AuthJni.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AuthJni.jn.nativeDestroy();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    AuthJni unused = AuthJni.jn = null;
                }
            });
        }
    }

    public static void setGrantedFeatures(final int[] iArr) {
        if (jn == null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.baidu.ar.auth.AuthJni.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AuthJni.jn != null) {
                        AuthJni.jn.nativeSetGrantedFeatures(iArr);
                        AuthJni.jn.nativePutGrantedFeatures(iArr);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        if (jn.jo) {
            r.runOnUiThread(runnable);
        } else {
            jn.jp.add(runnable);
        }
    }

    public String getVersionStr() {
        try {
            return "ver-" + nativeGetVersion();
        } catch (Throwable th) {
            th.printStackTrace();
            return "EXCEPTION-UNKNOWN";
        }
    }

    native void nativeDestroy();

    native int nativeGetVersion();

    native void nativeInit();

    native void nativePutGrantedFeatures(int[] iArr);

    native void nativeSetGrantedFeatures(int[] iArr);

    public void sendAuthFailMessageFromNative(int i) {
        a.receiveAuthFailMessage(i);
    }
}
