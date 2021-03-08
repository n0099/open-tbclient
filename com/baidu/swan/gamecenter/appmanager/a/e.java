package com.baidu.swan.gamecenter.appmanager.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class e extends com.baidu.swan.gamecenter.c.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public e() {
        super("openApp");
    }

    @Override // com.baidu.swan.gamecenter.c.a
    public com.baidu.swan.apps.api.c.b b(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (DEBUG) {
            Log.d("GameCenterOpenAppAction", "handle: " + jSONObject);
        }
        String optString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(optString)) {
            bVar.onFail(31010, "package name is empty");
        } else {
            com.baidu.swan.gamecenter.appmanager.d.c.a(optString, "openApp", null, null, null);
            if (!com.baidu.swan.gamecenter.appmanager.install.a.as(AppRuntime.getAppContext(), optString)) {
                bVar.onFail(31011, "app is not installed");
                com.baidu.swan.gamecenter.appmanager.d.c.a(optString, "openApp", com.baidu.pass.biometrics.face.liveness.c.a.p, String.valueOf(31011), null);
            } else if (com.baidu.swan.gamecenter.appmanager.install.a.au(AppRuntime.getAppContext(), optString)) {
                bVar.aH(null);
                com.baidu.swan.gamecenter.appmanager.d.c.a(optString, "openApp", "success", null, null);
            } else {
                bVar.onFail(31019, "open app fail");
                com.baidu.swan.gamecenter.appmanager.d.c.a(optString, "openApp", com.baidu.pass.biometrics.face.liveness.c.a.p, String.valueOf(31019), null);
            }
        }
        return null;
    }
}
