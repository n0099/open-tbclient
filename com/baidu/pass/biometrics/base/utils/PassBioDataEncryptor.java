package com.baidu.pass.biometrics.base.utils;

import android.text.TextUtils;
import com.baidu.android.common.security.Base64;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.pass.biometrics.base.debug.Log;
import java.util.Random;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class PassBioDataEncryptor {
    private static final String TAG = "PassBioDataEncryptor";

    public static String decryptAccountInfo(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(Base64.decode(new AES().decrypt(Base64.decode(str.getBytes()), new StringBuffer(str2).reverse().toString(), str2)), HTTP.UTF_8).trim();
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
            return Base64.encode(new AES().encrypt(Base64.encode(str.getBytes(), HTTP.UTF_8), new StringBuffer(str2).reverse().toString(), str2), HTTP.UTF_8);
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
            str2 = Base64.encode(new AES().encrypt(str, new StringBuffer(randomKey).reverse().toString(), randomKey), HTTP.UTF_8);
            try {
                str3 = Base64.encode(RSA.encrypt(randomKey), HTTP.UTF_8);
            } catch (Exception e2) {
                e = e2;
                Log.e(TAG, TAG, e);
                return TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{str3, str2});
            }
        } catch (Exception e3) {
            str2 = "";
            e = e3;
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
