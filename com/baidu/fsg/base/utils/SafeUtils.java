package com.baidu.fsg.base.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.fsg.base.armor.RimArmor;
import java.io.UnsupportedEncodingException;
/* loaded from: classes2.dex */
public final class SafeUtils {
    public static final String TAG = "SafeUtils";

    public static String encrypt(String str, String str2) {
        return !TextUtils.isEmpty(str2) ? RimArmor.getInstance().encryptProxy(str2) : "";
    }

    public static byte[] xor(byte[] bArr, byte[] bArr2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (bArr == null || bArr2 == null) {
            return null;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2 % bArr2.length]);
        }
        Log.i(TAG, "xor cost time " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        return bArr;
    }

    public static String xor(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return new String(xor(str.getBytes("UTF-8"), str2.getBytes("UTF-8")), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }
}
