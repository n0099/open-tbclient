package com.baidu.crabsdk.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.sapi2.base.network.Apn;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class h {
    private static String ZF = null;

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return Apn.APN_UNKNOWN;
        }
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes(HTTP.UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (messageDigest != null) {
            try {
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
            } catch (Exception e4) {
                return str;
            }
        }
        return str;
    }

    public static String g(Context context) {
        if (com.baidu.crabsdk.a.K) {
            if (ZF != null) {
                return ZF;
            }
            try {
                ZF = a(((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getDeviceId() + ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress() + Settings.Secure.getString(context.getContentResolver(), "android_id"));
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.v("getCUID fail," + e);
                ZF = Apn.APN_UNKNOWN;
            }
            return ZF;
        }
        return Apn.APN_UNKNOWN;
    }
}
