package com.baidu.searchbox.bsdiff;
/* loaded from: classes3.dex */
public class BsPatchNative {
    public static native int patch(String str, String str2, String str3);

    static {
        System.loadLibrary("npspatch");
    }
}
