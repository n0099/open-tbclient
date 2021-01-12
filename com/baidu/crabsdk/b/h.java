package com.baidu.crabsdk.b;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes14.dex */
public final class h {
    public static String aph = null;
    private static Context mContext = null;

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "N/A";
        }
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
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

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
        }
    }

    public static String z() {
        if (aph != null) {
            return aph;
        }
        try {
            aph = a(Settings.Secure.getString(mContext.getContentResolver(), "android_id"));
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("getCUID failed!", e);
            aph = "N/A";
        }
        return aph;
    }
}
