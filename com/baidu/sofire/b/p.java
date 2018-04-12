package com.baidu.sofire.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class p {
    public static boolean a(Context context) {
        PublicKey publicKey;
        try {
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            jSONObject.put("pkg", packageName);
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 64);
            if (packageInfo != null) {
                PublicKey a = c.a(packageInfo.applicationInfo.sourceDir);
                if (a != null || packageInfo.signatures == null || packageInfo.signatures.length <= 0 || packageInfo.signatures[0] == null) {
                    publicKey = a;
                } else {
                    publicKey = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray())).getPublicKey();
                }
                if (publicKey != null) {
                    byte[] encoded = publicKey.getEncoded();
                    if (encoded != null) {
                        d.a(context, encoded);
                        jSONObject.put("sign", l.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", "")));
                    }
                } else {
                    jSONObject.put("sign", "");
                }
                jSONObject.put("app", d.c(packageInfo.applicationInfo.loadLabel(packageManager).toString()));
            } else {
                jSONObject.put("sign", "");
                jSONObject.put("app", "");
            }
            String a2 = g.a(context, d.a() + "plugin/v1/auth", jSONObject.toString(), false, false, "");
            new StringBuilder().append(a2);
            JSONObject jSONObject2 = new JSONObject(a2);
            if (jSONObject2.optInt("code") == 200) {
                String optString = jSONObject2.optString("ak");
                String optString2 = jSONObject2.optString("sk");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    com.baidu.sofire.core.c a3 = com.baidu.sofire.core.c.a(context);
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        d.a(optString, optString2);
                        com.baidu.sofire.e eVar = a3.a;
                        eVar.c.putString("svi_n", optString + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString2);
                        eVar.c.commit();
                    }
                    return true;
                }
            }
        } catch (Throwable th) {
            new StringBuilder(" exception ").append(th.toString());
            d.a(th);
        }
        return false;
    }
}
