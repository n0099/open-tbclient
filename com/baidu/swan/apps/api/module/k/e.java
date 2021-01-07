package com.baidu.swan.apps.api.module.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.setting.oauth.a.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e extends com.baidu.swan.apps.api.a.d {
    public e(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b me(String str) {
        if (DEBUG) {
            Log.d("Api-DeviceInfo", "start get device info");
        }
        com.baidu.swan.apps.runtime.e aMm = com.baidu.swan.apps.runtime.e.aMm();
        if (aMm == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "SwanApp is null");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bo = com.baidu.swan.apps.api.d.b.bo("Api-DeviceInfo", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bo.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-DeviceInfo", "parse fail");
                return bVar;
            }
            return bVar;
        }
        final String optString = ((JSONObject) bo.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new com.baidu.swan.apps.api.c.b(202, "cb is required");
        }
        final Context context = getContext();
        aMm.aMx().b(context, "scope_get_device_info", new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.api.module.k.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    e.this.a(optString, new com.baidu.swan.apps.api.c.b(0, e.this.cp(context)));
                    return;
                }
                int errorCode = hVar.getErrorCode();
                String hR = com.baidu.swan.apps.setting.oauth.c.hR(errorCode);
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.e("Api-DeviceInfo", "getDeviceInfo auth fail(" + errorCode + ", " + hR + ")");
                }
                e.this.a(optString, new com.baidu.swan.apps.api.c.b(errorCode, com.baidu.swan.apps.setting.oauth.c.hR(errorCode)));
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject cp(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oaid", com.baidu.swan.apps.t.a.aBy().cg(context));
            jSONObject.put("androidId", com.baidu.swan.apps.t.a.aBy().getAndroidId(context));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
