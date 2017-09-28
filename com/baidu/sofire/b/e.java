package com.baidu.sofire.b;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
/* loaded from: classes.dex */
public final class e {
    public static String a(Context context) {
        com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
        String string = eVar.a.getString("xyus", "");
        if (TextUtils.isEmpty(string)) {
            String b = b(context);
            String c = c(context);
            if (TextUtils.isEmpty(c)) {
                c = "0";
            }
            String str = b + "|" + new StringBuffer(c).reverse().toString();
            eVar.Qe.putString("xyus", str);
            eVar.Qe.commit();
            return str;
        }
        return string;
    }

    private static String b(Context context) {
        String str;
        String str2;
        String str3 = "";
        try {
            str3 = c(context);
            str2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            str = str3;
        } catch (Throwable th) {
            d.a(th);
            str = str3;
            str2 = "";
        }
        return a((str + str2 + UUID.randomUUID().toString()).getBytes());
    }

    private static String c(Context context) {
        TelephonyManager telephonyManager;
        if ((context.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) != -1) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            String deviceId = telephonyManager.getDeviceId();
            if (TextUtils.isEmpty(deviceId)) {
                return "";
            }
            return deviceId;
        }
        return "";
    }

    private static String a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String upperCase = Integer.toHexString(b & 255).toUpperCase();
                if (upperCase.length() == 1) {
                    sb.append("0");
                }
                sb.append(upperCase).append("");
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            d.a(e);
            return null;
        }
    }
}
