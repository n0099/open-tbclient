package com.baidu.android.imrtc.utils;

import android.util.Base64;
/* loaded from: classes3.dex */
public class IMJni {
    private static String TAG = "IMJni";

    public static String transBDUID(String str) {
        try {
            byte[] encrypt = AESUtil.encrypt("2011121211143000", "AFD311832EDEEAEF", str.getBytes());
            if (encrypt != null) {
                return Base64.encodeToString(encrypt, 11);
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "AES java exception");
        }
        return "";
    }
}
