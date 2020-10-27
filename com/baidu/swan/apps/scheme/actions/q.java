package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class q extends aa {
    public q(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/openStatisticEvent");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        final JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        final String optString = optParamsAsJo.optString("bizId", "-1");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty flowId");
            return false;
        }
        try {
            optParamsAsJo.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
            optParamsAsJo.putOpt("eventType", "0");
            optParamsAsJo.putOpt("propagation", com.baidu.swan.apps.ap.v.b(optParamsAsJo.optJSONObject("propagation"), "source", com.baidu.swan.apps.runtime.d.aEQ().aEM().aEY().awd()));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        JSONObject optJSONObject = optParamsAsJo.optJSONObject("content");
        if (optJSONObject != null) {
            bK(optJSONObject.optJSONObject("ext"));
        }
        com.baidu.swan.apps.console.c.i("OpenStatisticEvent", "OpenStat : " + optParamsAsJo);
        com.baidu.swan.apps.ap.p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.q.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.ubc.e.onEvent(optString, optParamsAsJo);
            }
        }, "OpenStatisticEvent");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public static void bK(JSONObject jSONObject) {
        if (jSONObject != null) {
            b.a aEY = com.baidu.swan.apps.runtime.d.aEQ().aEM().aEY();
            com.baidu.swan.apps.ap.v.b(jSONObject, "launchId", aEY.aww());
            com.baidu.swan.apps.ap.v.b(jSONObject, "scheme", aEY.awf());
            com.baidu.swan.apps.ap.v.b(jSONObject, "appid", aEY.getAppId());
            com.baidu.swan.apps.ap.v.b(jSONObject, "swan", com.baidu.swan.apps.swancore.b.a(aEY.apD(), aEY.getAppFrameType()));
            com.baidu.swan.apps.ap.v.b(jSONObject, "packageVersion", aEY.getVersion());
        }
    }
}
