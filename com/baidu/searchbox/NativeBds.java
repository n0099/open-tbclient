package com.baidu.searchbox;

import com.baidu.android.util.soloader.SoLoader;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public final class NativeBds implements NoProGuard {
    static {
        SoLoader.load(AppRuntime.getAppContext(), "libAesArithmetic_V1_1.so");
    }

    public static byte[] ae(String str, String str2) {
        return ae0(str, str2);
    }

    public static native byte[] ae0(String str, String str2);

    public static native byte[] ae1(String str, byte[] bArr);

    public static byte[] dae(String str, byte[] bArr) {
        return dae1(str, bArr);
    }

    public static native byte[] dae1(String str, byte[] bArr);

    public static byte[] ae(String str, byte[] bArr) {
        return ae1(str, bArr);
    }
}
