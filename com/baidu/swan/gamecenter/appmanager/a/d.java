package com.baidu.swan.gamecenter.appmanager.a;

import android.content.pm.PackageInfo;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends com.baidu.swan.gamecenter.c.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public d() {
        super("getAppList");
    }

    @Override // com.baidu.swan.gamecenter.c.a
    public com.baidu.swan.apps.api.c.b b(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", aRW());
            if (DEBUG) {
                Log.i("GetAppListAction", jSONObject2.toString());
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        bVar.aE(jSONObject2);
        return null;
    }

    private JSONArray aRW() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (PackageInfo packageInfo : AppRuntime.getAppContext().getPackageManager().getInstalledPackages(1)) {
            jSONArray.put(c(packageInfo));
        }
        return jSONArray;
    }

    private JSONObject c(PackageInfo packageInfo) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appName", packageInfo.applicationInfo.name);
        jSONObject.put("appPackageName", packageInfo.packageName);
        jSONObject.put("appVersion", packageInfo.versionName);
        jSONObject.put("appIsSystemApp", (packageInfo.applicationInfo.flags & 1) != 0);
        return jSONObject;
    }
}
