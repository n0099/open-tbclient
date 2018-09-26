package com.baidu.sofire.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobstat.Config;
import com.baidu.sofire.ac.U;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class o {
    public static Map<String, String> a = new HashMap();

    public static void a(Context context) {
        try {
            String str = e.a() + "p/1/prt";
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            jSONObject.put(PushConstants.URI_PACKAGE_NAME, packageName);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 64);
            if (packageInfo != null) {
                PublicKey a2 = e.a(packageInfo, packageInfo.applicationInfo.sourceDir);
                if (a2 != null) {
                    byte[] encoded = a2.getEncoded();
                    if (encoded != null) {
                        e.a(context, encoded);
                        jSONObject.put("sm", n.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", "")));
                    }
                } else {
                    jSONObject.put("sm", "");
                }
            } else {
                jSONObject.put("sm", "");
            }
            String a3 = h.a(context, str, jSONObject.toString(), false, false);
            new StringBuilder().append(a3);
            JSONObject jSONObject2 = new JSONObject(a3);
            JSONArray optJSONArray = jSONObject2.optJSONArray("product");
            long optLong = jSONObject2.optLong(Config.PLATFORM_TYPE);
            if (optJSONArray != null && optLong > 0) {
                new com.baidu.sofire.e(context).a(optJSONArray.toString(), optLong);
            }
            if (optLong > 0) {
                e.h(context);
            }
        } catch (Throwable th) {
            e.a(th);
        }
    }

    public static void b(Context context) {
        try {
            a.clear();
            String a2 = new com.baidu.sofire.e(context).a();
            if (!TextUtils.isEmpty(a2)) {
                JSONArray jSONArray = new JSONArray(a2);
                HashMap hashMap = new HashMap();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("p");
                    String optString2 = optJSONObject.optString("s");
                    new StringBuilder("167:").append(optString).append("_").append(optString2);
                    hashMap.put(optString, optString2);
                }
                for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(64)) {
                    String str = packageInfo.packageName;
                    if (hashMap.keySet().contains(str) && !str.equals(context.getPackageName())) {
                        String str2 = (String) hashMap.get(str);
                        PublicKey a3 = e.a(packageInfo, packageInfo.applicationInfo.sourceDir);
                        new StringBuilder("194:").append(a3 == null);
                        if (a3 != null) {
                            byte[] encoded = a3.getEncoded();
                            new StringBuilder("197:").append(encoded == null);
                            if (encoded != null) {
                                e.a(context, encoded);
                                String a4 = n.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                                if (!TextUtils.isEmpty(a4) && a4.equals(str2)) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put(PushConstants.URI_PACKAGE_NAME, str);
                                    jSONObject.put("av", packageInfo.versionName);
                                    jSONObject.put("sm", a4);
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
            e.a(th);
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
            e.a(th);
        }
    }
}
