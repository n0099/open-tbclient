package com.baidu.crabsdk.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes2.dex */
public final class h {
    private static String Vr = null;

    public static String b(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            System.out.println("NoSuchAlgorithmException caught!");
        }
        byte[] digest = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            if (Integer.toHexString(digest[i] & 255).length() == 1) {
                stringBuffer.append("0").append(Integer.toHexString(digest[i] & 255));
            } else {
                stringBuffer.append(Integer.toHexString(digest[i] & 255));
            }
        }
        return stringBuffer.toString();
    }

    public static String g(Context context) {
        if (com.baidu.crabsdk.a.K) {
            if (Vr != null) {
                return Vr;
            }
            try {
                Vr = b(((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getDeviceId() + ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress() + Settings.Secure.getString(context.getContentResolver(), "android_id"));
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.cx("getCUID fail," + e);
                Vr = "N/A";
            }
            return Vr;
        }
        return "N/A";
    }
}
