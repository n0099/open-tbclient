package com.baidu.crabsdk.b;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static String f4684a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f4685b;

    public static String a(String str) {
        byte b2;
        if (TextUtils.isEmpty(str)) {
            return "N/A";
        }
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (messageDigest == null) {
            return str;
        }
        try {
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                if (Integer.toHexString(digest[i] & 255).length() == 1) {
                    stringBuffer.append("0");
                    b2 = digest[i];
                } else {
                    b2 = digest[i];
                }
                stringBuffer.append(Integer.toHexString(b2 & 255));
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static void b(Context context) {
        if (f4685b == null) {
            f4685b = context;
        }
    }

    public static String c() {
        String str = f4684a;
        if (str != null) {
            return str;
        }
        try {
            f4684a = a(Settings.Secure.getString(f4685b.getContentResolver(), "android_id"));
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.a("getCUID failed!", e2);
            f4684a = "N/A";
        }
        return f4684a;
    }
}
