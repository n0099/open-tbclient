package com.baidu.android.imrtc.utils;

import android.util.Base64;
/* loaded from: classes2.dex */
public class IMJni {
    public static String TAG = "IMJni";

    public static String transBDUID(String str) {
        try {
            byte[] encrypt = AESUtil.encrypt("2011121211143000", "AFD311832EDEEAEF", str.getBytes());
            return encrypt != null ? Base64.encodeToString(encrypt, 11) : "";
        } catch (Exception unused) {
            LogUtils.e(TAG, "AES java exception");
            return "";
        }
    }
}
