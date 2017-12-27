package com.baidu.sofire.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.ac.U;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.io.ByteArrayInputStream;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class k {
    public static Map<String, String> a = new HashMap();

    public static void a(Context context) {
        PublicKey publicKey;
        try {
            String str = d.a() + "plugin/v1/product";
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            jSONObject.put(PushConstants.URI_PACKAGE_NAME, packageName);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 64);
            if (packageInfo != null) {
                PublicKey cd = c.cd(packageInfo.applicationInfo.sourceDir);
                if (cd != null || packageInfo.signatures == null || packageInfo.signatures.length <= 0 || packageInfo.signatures[0] == null) {
                    publicKey = cd;
                } else {
                    publicKey = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray())).getPublicKey();
                }
                if (publicKey != null) {
                    byte[] encoded = publicKey.getEncoded();
                    if (encoded != null) {
                        d.a(context, encoded);
                        jSONObject.put("sm", j.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", "")));
                    }
                } else {
                    jSONObject.put("sm", "");
                }
            } else {
                jSONObject.put("sm", "");
            }
            String a2 = f.a(context, str, jSONObject.toString(), false, false, "");
            new StringBuilder().append(a2);
            JSONObject jSONObject2 = new JSONObject(a2);
            JSONArray optJSONArray = jSONObject2.optJSONArray("product");
            long optLong = jSONObject2.optLong("pt");
            if (optJSONArray != null && optLong > 0) {
                new com.baidu.sofire.d(context).a(optJSONArray.toString(), optLong);
            }
            if (optLong > 0) {
                d.f(context);
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static void b(Context context) {
        try {
            a.clear();
            String a2 = new com.baidu.sofire.d(context).a();
            if (!TextUtils.isEmpty(a2)) {
                JSONArray jSONArray = new JSONArray(a2);
                HashMap hashMap = new HashMap();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("p");
                    String optString2 = optJSONObject.optString(NotifyType.SOUND);
                    new StringBuilder("167:").append(optString).append("_").append(optString2);
                    hashMap.put(optString, optString2);
                }
                for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(64)) {
                    String str = packageInfo.packageName;
                    if (hashMap.keySet().contains(str) && !str.equals(context.getPackageName())) {
                        String str2 = (String) hashMap.get(str);
                        PublicKey cd = c.cd(packageInfo.applicationInfo.sourceDir);
                        new StringBuilder("183:").append(cd == null);
                        if (cd == null && packageInfo.signatures != null && packageInfo.signatures.length > 0 && packageInfo.signatures[0] != null) {
                            cd = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray())).getPublicKey();
                        }
                        new StringBuilder("194:").append(cd == null);
                        if (cd != null) {
                            byte[] encoded = cd.getEncoded();
                            new StringBuilder("197:").append(encoded == null);
                            if (encoded != null) {
                                d.a(context, encoded);
                                String a3 = j.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                                if (!TextUtils.isEmpty(a3) && a3.equals(str2)) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put(PushConstants.URI_PACKAGE_NAME, str);
                                    jSONObject.put("av", packageInfo.versionName);
                                    jSONObject.put("sm", a3);
                                    jSONObject.put("dm", Build.MODEL);
                                    jSONObject.put("al", String.valueOf(Build.VERSION.SDK_INT));
                                    a.put(str, jSONObject.toString());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static void a(Context context, Intent intent) {
        try {
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            if (!intent.getBooleanExtra("android.intent.extra.REPLACING", false) && a.containsKey(schemeSpecificPart)) {
                a.remove(schemeSpecificPart);
                new U(context, 4, false).start();
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
