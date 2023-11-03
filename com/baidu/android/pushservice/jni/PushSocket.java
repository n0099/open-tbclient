package com.baidu.android.pushservice.jni;

import android.util.Log;
/* loaded from: classes.dex */
public class PushSocket {
    public static String a = "PushSocket";
    public static boolean b;

    /* loaded from: classes.dex */
    public interface OnCreateSocketListener {
        void onConnect(int i);
    }

    static {
        try {
            System.loadLibrary("bdpush_V3_6");
            b = true;
        } catch (Throwable unused) {
        }
    }

    public static boolean a() {
        if (!b) {
            try {
                System.loadLibrary("bdpush_V3_6");
                b = true;
            } catch (Throwable unused) {
                Log.e("BDPushSDK-" + a, "Native library not found! Please copy libbdpush_V3_6.so into your project!");
            }
        }
        return b;
    }

    public static native boolean isIPv4Reachable();
}
