package com.baidu.searchbox.http;
/* loaded from: classes5.dex */
public class NetCheckLogic {
    public static native void reset();

    public static native String updateShortLinkInfo(int i, boolean z, int i2, long j, boolean z2, String str);

    static {
        try {
            System.loadLibrary("Sdt");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }
}
