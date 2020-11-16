package com.baidu.down.utils;

import android.content.Context;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
/* loaded from: classes15.dex */
public class CryptUtil {
    private static native byte[] decrypt(Context context, byte[] bArr);

    private static native byte[] encrypt(Context context, byte[] bArr);

    static {
        System.loadLibrary("AsyncSdk_v1");
    }

    public static String decryptCdnData(Context context, String str) {
        try {
            return new String(decryptData(context, Base64.decode(str.getBytes("UTF-8"), 0)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] decryptData(Context context, byte[] bArr) {
        return decrypt(context, bArr);
    }
}
