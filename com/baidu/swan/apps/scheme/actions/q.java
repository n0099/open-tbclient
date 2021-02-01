package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
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
            optParamsAsJo.putOpt("propagation", com.baidu.swan.apps.ao.v.b(optParamsAsJo.optJSONObject("propagation"), "source", com.baidu.swan.apps.runtime.d.aIG().aIC().aIO().aza()));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        JSONObject optJSONObject = optParamsAsJo.optJSONObject("content");
        if (optJSONObject != null) {
            bR(optJSONObject.optJSONObject("ext"));
        }
        com.baidu.swan.apps.console.c.i("OpenStatisticEvent", "OpenStat : " + optParamsAsJo);
        com.baidu.swan.apps.ao.p.a(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.q.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.ubc.e.onEvent(optString, optParamsAsJo);
            }
        }, "OpenStatisticEvent");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public static void bR(JSONObject jSONObject) {
        if (jSONObject != null) {
            b.a aIO = com.baidu.swan.apps.runtime.d.aIG().aIC().aIO();
            com.baidu.swan.apps.ao.v.b(jSONObject, "launchId", aIO.azt());
            com.baidu.swan.apps.ao.v.b(jSONObject, "scheme", aIO.azc());
            com.baidu.swan.apps.ao.v.b(jSONObject, "appid", aIO.getAppId());
            com.baidu.swan.apps.ao.v.b(jSONObject, GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME, com.baidu.swan.apps.swancore.b.a(aIO.asA(), aIO.getAppFrameType()));
            com.baidu.swan.apps.ao.v.b(jSONObject, "packageVersion", aIO.getVersion());
        }
    }
}
