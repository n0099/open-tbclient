package com.baidu.platform.comapi.util;

import com.baidu.platform.comjni.JNIBaseApi;
/* loaded from: classes20.dex */
public final class URLEncodeUtils extends JNIBaseApi {
    public static String a(int i, String str) {
        return i == 1 ? nativeMD5Sign(str) : i == 2 ? nativeWebSign(str) : i == 3 ? nativeOperSign(str) : "";
    }

    private static native String nativeMD5Sign(String str);

    private static native String nativeOperSign(String str);

    private static native String nativeUrlEncode(String str);

    private static native String nativeWebSign(String str);
}
