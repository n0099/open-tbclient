package com.baidu.swan.apps.api.module.k;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.setting.oauth.a.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e extends com.baidu.swan.apps.api.a.d {
    public e(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lK(String str) {
        if (DEBUG) {
            Log.d("Api-DeviceInfo", "start get device info");
        }
        com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
        if (aHv == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "SwanApp is null");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bj = com.baidu.swan.apps.api.d.b.bj("Api-DeviceInfo", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bj.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-DeviceInfo", "parse fail");
                return bVar;
            }
            return bVar;
        }
        final String optString = ((JSONObject) bj.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new com.baidu.swan.apps.api.c.b(202, "cb is required");
        }
        final Context context = getContext();
        aHv.aHG().b(context, "scope_get_device_info", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.api.module.k.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    e.this.a(optString, new com.baidu.swan.apps.api.c.b(0, e.this.bC(context)));
                    return;
                }
                int errorCode = hVar.getErrorCode();
                String hD = com.baidu.swan.apps.setting.oauth.c.hD(errorCode);
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.e("Api-DeviceInfo", "getDeviceInfo auth fail(" + errorCode + ", " + hD + ")");
                }
                e.this.a(optString, new com.baidu.swan.apps.api.c.b(errorCode, com.baidu.swan.apps.setting.oauth.c.hD(errorCode)));
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bC(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oaid", com.baidu.swan.apps.t.a.axG().bt(context));
            jSONObject.put("androidId", com.baidu.swan.apps.t.a.axG().getAndroidId(context));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
