package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.security.Base64;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.moplus.util.NoProGuard;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
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
public class GetCuid implements NoProGuard, n {
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
        PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str.getBytes())));
        Cipher cipher = Cipher.getInstance(com.baidu.sapi2.shell.b.a);
        cipher.init(2, generatePrivate);
        return cipher.doFinal(bArr);
    }

    public static byte[] decryptByPublicKey(byte[] bArr, String str) {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes(), 0)));
        Cipher cipher = Cipher.getInstance(com.baidu.sapi2.shell.b.a);
        cipher.init(2, generatePublic);
        return cipher.doFinal(bArr);
    }

    public static byte[] encryptByPrivateKey(byte[] bArr, String str) {
        PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str.getBytes(), 0)));
        Cipher cipher = Cipher.getInstance(com.baidu.sapi2.shell.b.a);
        cipher.init(1, generatePrivate);
        return cipher.doFinal(bArr);
    }

    public byte[] encryptByPublicKey(byte[] bArr, String str) {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes())));
        Cipher cipher = Cipher.getInstance(com.baidu.sapi2.shell.b.a);
        cipher.init(1, generatePublic);
        return cipher.doFinal(bArr);
    }

    @Override // com.baidu.android.nebula.cmd.n
    public void execute(com.baidu.android.nebula.a.d dVar, com.baidu.android.nebula.a.a aVar) {
        String str;
        String str2;
        a.a(System.currentTimeMillis());
        Map a = dVar.a();
        if (a == null || a.size() < 1) {
            a.a(-1);
            return;
        }
        String str3 = (String) a.get("callback");
        a.d((String) a.get("mcmdf"));
        if (str3 == null) {
            a.a(-1);
            return;
        }
        String str4 = (String) a.get("secret");
        this.mContext = com.baidu.android.nebula.d.c.a().c();
        if (this.mContext == null) {
            a.a(-1);
            return;
        }
        a.b(this.mContext.getPackageName());
        if (!com.baidu.android.nebula.d.a.a(this.mContext).a(dVar.a("Referer"))) {
            this.mErrcode = 4;
        }
        if (this.mErrcode != 4) {
            this.mErrcode = 1;
            String cuid = CommonParam.getCUID(this.mContext);
            if (TextUtils.equals(str4, TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK)) {
                try {
                    str = str4;
                    str2 = new String(Base64.encode(encryptByPublicKey(cuid.getBytes(), RSA_PUBLIC_KEY), "utf-8"));
                } catch (Exception e) {
                    System.out.println("加密失败：" + e.getMessage());
                    str = "0";
                    str2 = cuid;
                }
            } else {
                str = "0";
                str2 = cuid;
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
        aVar.a("text/javascript");
        aVar.a().put("Cache-Control", "no-cache");
        aVar.b(str3 + " && " + str3 + "(" + jSONObject.toString() + ");");
        aVar.a(Constants.MEDIA_INFO);
        a.a(this.mErrcode);
    }

    @Override // com.baidu.android.nebula.cmd.n
    public void writeToStatic() {
        m.a().a(this.mContext, a.toString());
    }
}
