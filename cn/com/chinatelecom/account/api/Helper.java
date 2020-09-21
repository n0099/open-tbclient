package cn.com.chinatelecom.account.api;

import android.content.Context;
/* loaded from: classes14.dex */
public final class Helper {
    static {
        System.loadLibrary("CtaApiLib");
    }

    public static native String cemnetwul();

    public static native String cemppmul();

    public static native String cepahsul();

    public static native String cinetw(Context context, String str, String str2, String str3, String str4, long j, String str5);

    public static native byte[] dnenwret(byte[] bArr, String str);

    public static native String dnepah(Context context, String str, String str2, String str3, long j, String str4);

    public static native String dnepmo(Context context, String str, String str2, String str3, long j, String str4);

    public static native byte[] dnepmret(byte[] bArr, String str);

    public static native String testEncrypt(String str, String str2);
}
