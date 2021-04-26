package com.baidu.down.utils;

import android.content.Context;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
/* loaded from: classes2.dex */
public class CryptUtil {
    static {
        System.loadLibrary("AsyncSdk_v1");
    }

    public static native byte[] decrypt(Context context, byte[] bArr);

    public static String decryptCdnData(Context context, String str) {
        try {
            return new String(decryptData(context, Base64.decode(str.getBytes("UTF-8"), 0)));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] decryptData(Context context, byte[] bArr) {
        return decrypt(context, bArr);
    }

    public static native byte[] encrypt(Context context, byte[] bArr);
}
