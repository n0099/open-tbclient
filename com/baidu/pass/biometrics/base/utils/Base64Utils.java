package com.baidu.pass.biometrics.base.utils;

import android.annotation.TargetApi;
import android.util.Base64;
@TargetApi(8)
/* loaded from: classes3.dex */
public class Base64Utils {
    public static final int NO_WRAP = 2;

    public static byte[] decode(String str) {
        return Base64.decode(str.getBytes(), 2);
    }

    public static byte[] encode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encode(bArr, 2);
    }

    public static String encodeToString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 2);
    }
}
