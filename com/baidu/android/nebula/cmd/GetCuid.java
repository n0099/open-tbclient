package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.moplus.util.NoProGuard;
import com.baidu.tbadk.TbConfig;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetCuid implements NoProGuard, d {
    private static final String ALGORITHM_RSA = "RSA";
    private static final boolean DEBUG = false;
    public static final int ERROR_FAIL = 1;
    public static final String RSA_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDVQ9YJNnxYatFmbzWnd0BN0GBI\rwScGcyK++zPwb27HD7NbgCfVRySUMYKdxnzZa1xuzah9+c8M8asFaVEZr90d1+Ed\rDQqw6f96lBKwwtxYiD9o0XgqFraUiOHySnMUw/SNWfAWGKlvNsYueAaJ2zzGl639\rNjekdHqpoQk7VAiQdwIDAQAB";
    private static final String TAG = "GetCuid";
    private int mErrcode = -1;
    Context mContext = null;

    public GetCuid() {
        a.a();
        a.a(TAG);
    }

    public static byte[] decryptByPrivateKey(byte[] bArr, String str) {
        PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(com.baidu.android.nebula.a.k.a(str.getBytes())));
        Cipher cipher = Cipher.getInstance(com.baidu.sapi2.shell.b.a);
        cipher.init(2, generatePrivate);
        return cipher.doFinal(bArr);
    }

    public static byte[] decryptByPublicKey(byte[] bArr, String str) {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(com.baidu.android.nebula.a.k.a(str.getBytes(), 0)));
        Cipher cipher = Cipher.getInstance(com.baidu.sapi2.shell.b.a);
        cipher.init(2, generatePublic);
        return cipher.doFinal(bArr);
    }

    public static byte[] encryptByPrivateKey(byte[] bArr, String str) {
        PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(com.baidu.android.nebula.a.k.a(str.getBytes(), 0)));
        Cipher cipher = Cipher.getInstance(com.baidu.sapi2.shell.b.a);
        cipher.init(1, generatePrivate);
        return cipher.doFinal(bArr);
    }

    public byte[] encryptByPublicKey(byte[] bArr, String str) {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(com.baidu.android.nebula.a.k.a(str.getBytes())));
        Cipher cipher = Cipher.getInstance(com.baidu.sapi2.shell.b.a);
        cipher.init(1, generatePublic);
        return cipher.doFinal(bArr);
    }

    @Override // com.baidu.android.nebula.cmd.d
    public com.baidu.android.nebula.b.c execute(com.baidu.android.nebula.b.k kVar, Map map, Map map2, Map map3) {
        String str;
        String str2;
        a.a(System.currentTimeMillis());
        if (map2 == null || map2.size() < 1) {
            a.a(-1);
            return null;
        }
        String str3 = (String) map2.get("callback");
        a.d((String) map2.get("mcmdf"));
        if (str3 == null) {
            a.a(-1);
            return null;
        }
        String str4 = (String) map2.get("secret");
        this.mContext = com.baidu.android.nebula.d.b.a().c();
        if (this.mContext == null) {
            a.a(-1);
            return null;
        }
        a.b(this.mContext.getPackageName());
        if (!com.baidu.android.nebula.d.a.a(this.mContext).a((String) map.get("referer"))) {
            this.mErrcode = 4;
        }
        if (this.mErrcode != 4) {
            this.mErrcode = 1;
            String a = com.baidu.android.nebula.a.j.a(this.mContext);
            if (TextUtils.equals(str4, TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK)) {
                try {
                    str = str4;
                    str2 = new String(com.baidu.android.nebula.a.k.a(encryptByPublicKey(a.getBytes(), RSA_PUBLIC_KEY), "utf-8"));
                } catch (Exception e) {
                    System.out.println("加密失败：" + e.getMessage());
                    str = "0";
                    str2 = a;
                }
            } else {
                str = "0";
                str2 = a;
            }
        } else {
            str = str4;
            str2 = null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("secret", str);
                jSONObject.put("cuid", str2);
                this.mErrcode = 0;
            }
            jSONObject.put("error", this.mErrcode);
        } catch (JSONException e2) {
        }
        com.baidu.android.nebula.b.c cVar = new com.baidu.android.nebula.b.c(str3 + " && " + str3 + "(" + jSONObject.toString() + ");");
        a.a(this.mErrcode);
        return cVar;
    }

    @Override // com.baidu.android.nebula.cmd.d
    public void writeToStatic() {
        k.a().a(this.mContext, a.toString());
    }
}
