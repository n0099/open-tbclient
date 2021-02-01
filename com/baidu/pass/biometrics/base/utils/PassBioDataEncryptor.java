package com.baidu.pass.biometrics.base.utils;

import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.common.SecurityUtil;
import java.util.Random;
/* loaded from: classes6.dex */
public class PassBioDataEncryptor {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3978a = "PassBioDataEncryptor";

    private static String a(int i) {
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
            Log.e(f3978a, f3978a, th);
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
            Log.e(f3978a, f3978a, th);
            return "";
        }
    }

    public static String encryptParams(String str) {
        String str2;
        String a2 = a(16);
        String str3 = "";
        try {
            str3 = SecurityUtil.base64Encode(new AES().encrypt(str, new StringBuffer(a2).reverse().toString(), a2));
        } catch (Exception e) {
            e = e;
        }
        try {
            str2 = SecurityUtil.base64Encode(RSA.encrypt(a2));
        } catch (Exception e2) {
            e = e2;
            Log.e(f3978a, f3978a, e);
            str2 = "";
            return TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{str2, str3});
        }
        return TextUtils.join(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, new String[]{str2, str3});
    }
}
