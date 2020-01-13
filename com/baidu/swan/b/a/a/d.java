package com.baidu.swan.b.a.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends com.baidu.swan.b.d.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public d() {
        super("openApp");
    }

    @Override // com.baidu.swan.b.d.a
    public com.baidu.swan.apps.api.b.b b(@NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.p.b bVar) {
        if (DEBUG) {
            Log.d("GameCenterOpenAppAction", "handle: " + jSONObject);
        }
        String optString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(optString)) {
            bVar.onFail(31010, "package name is empty");
        } else {
            com.baidu.swan.b.a.f.c.a(optString, "openApp", null, null, null);
            if (!com.baidu.swan.b.a.c.a.at(AppRuntime.getAppContext(), optString)) {
                bVar.onFail(31011, "app is not installed");
                com.baidu.swan.b.a.f.c.a(optString, "openApp", LivenessStat.TYPE_FACE_MATCH_FAIL, String.valueOf(31011), null);
            } else if (com.baidu.swan.b.a.c.a.au(AppRuntime.getAppContext(), optString)) {
                bVar.K(null);
                com.baidu.swan.b.a.f.c.a(optString, "openApp", "success", null, null);
            } else {
                bVar.onFail(31019, "open app fail");
                com.baidu.swan.b.a.f.c.a(optString, "openApp", LivenessStat.TYPE_FACE_MATCH_FAIL, String.valueOf(31019), null);
            }
        }
        return null;
    }
}
