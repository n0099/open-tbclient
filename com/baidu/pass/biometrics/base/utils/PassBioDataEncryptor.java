package com.baidu.pass.biometrics.base.utils;

import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.common.SecurityUtil;
import java.util.Random;
/* loaded from: classes6.dex */
public class PassBioDataEncryptor {
    private static final String TAG = "PassBioDataEncryptor";

    public static String decryptAccountInfo(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(SecurityUtil.base64Decode(new AES().decrypt(SecurityUtil.base64Decode(str.getBytes()), new StringBuffer(str2).reverse().toString(), str2)), "UTF-8").trim();
        } catch (Throwable th) {
            Log.e(TAG, TAG, th);
            return "";
        }
    }

    public static String encryptAccountInfo(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return SecurityUtil.base64Encode(new AES().encrypt(SecurityUtil.base64Encode(str.getBytes()), new StringBuffer(str2).reverse().toString(), str2));
        } catch (Throwable th) {
            Log.e(TAG, TAG, th);
            return "";
        }
    }

    public static String encryptParams(String str) {
        String str2;
        Exception e;
        String randomKey = getRandomKey(16);
        String str3 = "";
        try {
            str2 = SecurityUtil.base64Encode(new AES().encrypt(str, new StringBuffer(randomKey).reverse().toString(), randomKey));
        } catch (Exception e2) {
            str2 = "";
            e = e2;
        }
        try {
            str3 = SecurityUtil.base64Encode(RSA.encrypt(randomKey));
        } catch (Exception e3) {
            e = e3;
            Log.e(TAG, TAG, e);
            return TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{str3, str2});
        }
        return TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{str3, str2});
    }

    private static String getRandomKey(int i) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append("0123456789abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt("0123456789abcdefghijklmnopqrstuvwxyz".length())));
        }
        return stringBuffer.toString();
    }
}
