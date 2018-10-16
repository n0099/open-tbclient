package com.baidu.aip.auth;

import android.content.Context;
import android.util.Base64;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.searchbox.ng.ai.apps.util.AiAppEncryptUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class Auth {
    private static Throwable Sk;
    private String Sm;
    private String Sn;
    private long mExpiresTime;
    private int Sl = 1;
    private String mToken = null;

    static {
        try {
            System.loadLibrary("aip-native-auth");
            Sk = null;
        } catch (Throwable th) {
            Sk = new AuthException(283506, AuthException.a);
        }
    }

    private static String C(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    private static String aU(Context context) {
        return Base64.encodeToString(initWithBin(context), 2);
    }

    private static String g(Context context, String str, String str2) {
        return str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + md5(str2) + Base64.encodeToString(init(context), 2);
    }

    private static native byte[] init(Context context);

    private static native byte[] initWithBin(Context context);

    private static String md5(String str) {
        try {
            return C(MessageDigest.getInstance(AiAppEncryptUtils.ENCRYPT_MD5).digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private boolean pF() {
        return System.currentTimeMillis() > this.mExpiresTime;
    }

    private void parseJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.isNull("status")) {
                throw new AuthException(283505, AuthException.c);
            }
            int optInt = jSONObject.optInt("status");
            if (optInt != 0) {
                String optString = jSONObject.optString("message");
                throw new AuthException(optInt, optString + " logId: " + Long.valueOf(jSONObject.optLong("log_id")));
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.mToken = optJSONObject.getString("access_token");
                this.mExpiresTime = (optJSONObject.optLong("expires_in") * 1000) + System.currentTimeMillis();
            }
        } catch (JSONException e) {
            throw new AuthException(283505, AuthException.c);
        }
    }

    public String getToken(Context context) {
        String str;
        String str2 = null;
        if (pF() || this.mToken == null) {
            if (this.Sl == 0) {
                str2 = "https://verify.baidubce.com/verify/1.0/token/sk?channel=ar";
                str = g(context, this.Sm, this.Sn);
            } else {
                str = null;
            }
            if (this.Sl == 1) {
                str2 = "https://verify.baidubce.com/verify/1.0/token/bin?channel=ar";
                str = aU(context);
            }
            parseJson(a.a(str2, str));
            return this.mToken;
        }
        return this.mToken;
    }
}
