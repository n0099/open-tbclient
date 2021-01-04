package com.baidu.fsg.base.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.fsg.base.armor.RimArmor;
import java.io.UnsupportedEncodingException;
/* loaded from: classes6.dex */
public final class SafeUtils {
    public static final String TAG = "SafeUtils";

    public static String encrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return RimArmor.getInstance().encryptProxy(str2);
        }
        return "";
    }

    public static byte[] xor(byte[] bArr, byte[] bArr2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (bArr == null || bArr2 == null) {
            return null;
        }
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i % bArr2.length]);
        }
        Log.i(TAG, "xor cost time " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        return bArr;
    }

    public static String xor(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return new String(xor(str.getBytes("UTF-8"), str2.getBytes("UTF-8")), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
