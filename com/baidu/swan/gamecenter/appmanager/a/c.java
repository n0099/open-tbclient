package com.baidu.swan.gamecenter.appmanager.a;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class c extends com.baidu.swan.gamecenter.c.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public c() {
        super("checkAppInstalled");
    }

    @Override // com.baidu.swan.gamecenter.c.a
    public com.baidu.swan.apps.api.c.b b(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (DEBUG) {
            Log.d("checkAppInstalled", "handle: " + jSONObject);
        }
        String optString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(optString)) {
            bVar.onFail(31010, "package name is empty");
        } else {
            try {
                PackageInfo packageInfo = AppRuntime.getAppContext().getPackageManager().getPackageInfo(optString, 0);
                if (DEBUG) {
                    Log.d("checkAppInstalled", "packageInfo: " + packageInfo);
                }
                if (packageInfo != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("versionName", packageInfo.versionName);
                    jSONObject3.put("versionCode", packageInfo.versionCode);
                    jSONObject2.put("data", jSONObject3);
                    bVar.aH(jSONObject2);
                } else {
                    bVar.onFail(31016, "no package info");
                }
            } catch (Exception e) {
                bVar.onFail(31011, "app is not installed");
            }
        }
        return null;
    }
}
