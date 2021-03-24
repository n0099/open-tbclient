package com.baidu.pass.biometrics.base.utils;

import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.common.SecurityUtil;
import java.util.Random;
/* loaded from: classes2.dex */
public class PassBioDataEncryptor {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9560a = "PassBioDataEncryptor";

    public static String a(int i) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append("0123456789abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(36)));
        }
        return stringBuffer.toString();
    }

    public static String decryptAccountInfo(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(SecurityUtil.base64Decode(new AES().decrypt(SecurityUtil.base64Decode(str.getBytes()), new StringBuffer(str2).reverse().toString(), str2)), "UTF-8").trim();
        } catch (Throwable th) {
            Log.e(f9560a, f9560a, th);
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
            Log.e(f9560a, f9560a, th);
            return "";
        }
    }

    public static String encryptParams(String str) {
        String str2;
        String str3 = "";
        String a2 = a(16);
        try {
            str2 = SecurityUtil.base64Encode(new AES().encrypt(str, new StringBuffer(a2).reverse().toString(), a2));
        } catch (Exception e2) {
            e = e2;
            str2 = "";
        }
        try {
            str3 = SecurityUtil.base64Encode(RSA.encrypt(a2));
        } catch (Exception e3) {
            e = e3;
            Log.e(f9560a, f9560a, e);
            return TextUtils.join("_", new String[]{str3, str2});
        }
        return TextUtils.join("_", new String[]{str3, str2});
    }
}
