package com.baidu.sofire.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.mipush.sdk.Constants;
import java.security.PublicKey;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class s {
    public static boolean a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            jSONObject.put("pkg", packageName);
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 64);
            if (packageInfo != null) {
                PublicKey a = e.a(packageInfo, packageInfo.applicationInfo.sourceDir);
                if (a != null) {
                    byte[] encoded = a.getEncoded();
                    if (encoded != null) {
                        e.a(context, encoded);
                        jSONObject.put("sign", n.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", "")));
                    }
                } else {
                    jSONObject.put("sign", "");
                }
                jSONObject.put("app", e.c(packageInfo.applicationInfo.loadLabel(packageManager).toString()));
            } else {
                jSONObject.put("sign", "");
                jSONObject.put("app", "");
            }
            String a2 = h.a(context, e.a() + "p/1/auh", jSONObject.toString(), false, false);
            new StringBuilder().append(a2);
            JSONObject jSONObject2 = new JSONObject(a2);
            if (jSONObject2.length() <= 0 || jSONObject2.optInt("code") != 200) {
                return false;
            }
            String optString = jSONObject2.optString("ak");
            String optString2 = jSONObject2.optString("sk");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return false;
            }
            com.baidu.sofire.core.c a3 = com.baidu.sofire.core.c.a(context);
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && (!"3".equals(optString) || !"925fc15df8a49bed0b3eca8d2b44cb7b".equals(optString2))) {
                e.a(optString, optString2);
                com.baidu.sofire.e eVar = a3.a;
                eVar.c.putString("svi_n", optString + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString2);
                eVar.c.commit();
            }
            return true;
        } catch (Throwable th) {
            new StringBuilder(" exception ").append(th.toString());
            e.a(th);
            return false;
        }
    }
}
