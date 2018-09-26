package cn.jiguang.service;
/* loaded from: classes3.dex */
public class Protocol {
    static {
        try {
            System.loadLibrary("jcore125");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static native int GetSdkVersion();

    public static native String getCerTificate();
}
