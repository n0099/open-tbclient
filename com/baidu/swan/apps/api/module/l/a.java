package com.baidu.swan.apps.api.module.l;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends com.baidu.swan.apps.api.a.d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b ke(String str) {
        if (DEBUG) {
            Log.d("Api-CheckAppInstall", "start check app install");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aX = com.baidu.swan.apps.api.d.b.aX("Api-CheckAppInstall", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aX.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-CheckAppInstall", "parse fail");
                return bVar;
            }
            return bVar;
        }
        String optString = ((JSONObject) aX.second).optString("name");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.i("Api-CheckAppInstall", "packageName empty");
            return new com.baidu.swan.apps.api.c.b(201, "parameter error");
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = getContext().getPackageManager().getPackageInfo(optString, 0);
        } catch (PackageManager.NameNotFoundException e) {
            com.baidu.swan.apps.console.c.e("Api-CheckAppInstall", e.getMessage(), e);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (packageInfo != null) {
                jSONObject.put("hasApp", true);
                jSONObject.put("versionName", packageInfo.versionName);
                jSONObject.put("versionCode", packageInfo.versionCode);
            } else {
                jSONObject.put("hasApp", false);
            }
            return new com.baidu.swan.apps.api.c.b(0, "success", jSONObject);
        } catch (JSONException e2) {
            com.baidu.swan.apps.console.c.e("Api-CheckAppInstall", e2.getMessage(), e2);
            return new com.baidu.swan.apps.api.c.b(1001, e2.getMessage());
        }
    }
}
