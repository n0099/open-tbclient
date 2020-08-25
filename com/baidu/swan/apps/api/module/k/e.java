package com.baidu.swan.apps.api.module.k;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.setting.oauth.a.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e extends com.baidu.swan.apps.api.a.d {
    public e(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b jW(String str) {
        if (DEBUG) {
            Log.d("Api-DeviceInfo", "start get device info");
        }
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        if (azJ == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "SwanApp is null");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aX = com.baidu.swan.apps.api.d.b.aX("Api-DeviceInfo", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aX.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-DeviceInfo", "parse fail");
                return bVar;
            }
            return bVar;
        }
        final String optString = ((JSONObject) aX.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new com.baidu.swan.apps.api.c.b(202, "cb is required");
        }
        final Context context = getContext();
        azJ.azU().b(context, "scope_get_device_info", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.api.module.k.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void I(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    e.this.a(optString, new com.baidu.swan.apps.api.c.b(0, e.this.bx(context)));
                    return;
                }
                int errorCode = hVar.getErrorCode();
                String gC = com.baidu.swan.apps.setting.oauth.c.gC(errorCode);
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.e("Api-DeviceInfo", "getDeviceInfo auth fail(" + errorCode + ", " + gC + ")");
                }
                e.this.a(optString, new com.baidu.swan.apps.api.c.b(errorCode, com.baidu.swan.apps.setting.oauth.c.gC(errorCode)));
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bx(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oaid", com.baidu.swan.apps.t.a.apQ().bo(context));
            jSONObject.put("androidId", com.baidu.swan.apps.t.a.apQ().getAndroidId(context));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
