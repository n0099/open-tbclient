package com.baidu.pass.biometrics.base.utils;

import android.annotation.TargetApi;
import android.util.Base64;
@TargetApi(8)
/* loaded from: classes5.dex */
public class Base64Utils {
    public static byte[] encode(byte[] bArr) {
        return Base64.encode(bArr, 2);
    }

    public static String encodeToString(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }
}
