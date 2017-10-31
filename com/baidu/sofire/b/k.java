package com.baidu.sofire.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.ac.U;
import com.baidu.tbadk.TbConfig;
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
        String str;
        String str2;
        PublicKey publicKey;
        try {
            String str3 = d.a() + "plugin/v1/product";
            String[] e = d.e(context);
            if (e != null && e.length == 2 && !TextUtils.isEmpty(e[0]) && !TextUtils.isEmpty(e[1])) {
                str = e[0];
                str2 = e[1];
            } else {
                str = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
                str2 = "925fc15df8a49bed0b3eca8d2b44cb7b";
            }
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            jSONObject.put("pk", packageName);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 64);
            if (packageInfo != null) {
                PublicKey bV = c.bV(packageInfo.applicationInfo.sourceDir);
                if (bV != null || packageInfo.signatures == null || packageInfo.signatures.length <= 0 || packageInfo.signatures[0] == null) {
                    publicKey = bV;
                } else {
                    publicKey = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray())).getPublicKey();
                }
                if (publicKey != null) {
                    byte[] encoded = publicKey.getEncoded();
                    if (encoded != null) {
                        jSONObject.put("sm", j.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", "")));
                    }
                } else {
                    jSONObject.put("sm", "");
                }
            } else {
                jSONObject.put("sm", "");
            }
            String jSONObject2 = jSONObject.toString();
            com.baidu.sofire.b.a();
            String a2 = f.a(context, str3, jSONObject2, str, str2, false);
            String str4 = a2;
            com.baidu.sofire.b.a();
            JSONObject jSONObject3 = new JSONObject(a2);
            JSONArray optJSONArray = jSONObject3.optJSONArray("product");
            long optLong = jSONObject3.optLong("pt");
            if (optJSONArray != null && optLong > 0) {
                new com.baidu.sofire.e(context).a(optJSONArray.toString(), optLong);
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
            String a2 = new com.baidu.sofire.e(context).a();
            String str = "157:" + a2;
            com.baidu.sofire.b.a();
            if (!TextUtils.isEmpty(a2)) {
                JSONArray jSONArray = new JSONArray(a2);
                HashMap hashMap = new HashMap();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("p");
                    String optString2 = optJSONObject.optString("s");
                    String str2 = "167:" + optString + "_" + optString2;
                    com.baidu.sofire.b.a();
                    hashMap.put(optString, optString2);
                }
                for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(64)) {
                    String str3 = packageInfo.packageName;
                    String str4 = "174:" + str3;
                    com.baidu.sofire.b.a();
                    if (hashMap.keySet().contains(str3) && !str3.equals(context.getPackageName())) {
                        String str5 = (String) hashMap.get(str3);
                        String str6 = "179:" + str5;
                        com.baidu.sofire.b.a();
                        String str7 = packageInfo.applicationInfo.sourceDir;
                        String str8 = "181:" + str7;
                        com.baidu.sofire.b.a();
                        PublicKey bV = c.bV(str7);
                        String str9 = "183:" + (bV == null);
                        com.baidu.sofire.b.a();
                        if (bV == null && packageInfo.signatures != null && packageInfo.signatures.length > 0 && packageInfo.signatures[0] != null) {
                            bV = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray())).getPublicKey();
                        }
                        String str10 = "194:" + (bV == null);
                        com.baidu.sofire.b.a();
                        if (bV != null) {
                            byte[] encoded = bV.getEncoded();
                            String str11 = "197:" + (encoded == null);
                            com.baidu.sofire.b.a();
                            if (encoded != null) {
                                String a3 = j.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                                String str12 = "201:" + a3;
                                com.baidu.sofire.b.a();
                                if (!TextUtils.isEmpty(a3) && a3.equals(str5)) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("pk", str3);
                                    jSONObject.put("av", packageInfo.versionName);
                                    jSONObject.put("sm", a3);
                                    jSONObject.put("dm", Build.MODEL);
                                    jSONObject.put("al", String.valueOf(Build.VERSION.SDK_INT));
                                    a.put(str3, jSONObject.toString());
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
