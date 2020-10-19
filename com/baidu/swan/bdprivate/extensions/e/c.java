package com.baidu.swan.bdprivate.extensions.e;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.bdprivate.extensions.e.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends aa {
    public c(j jVar) {
        super(jVar, "/swanAPI/guidePushSetting");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("GuidePushSettingAction", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("GuidePushSettingAction", "illegal params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (TextUtils.isEmpty(optParamsAsJo.optString("source"))) {
            com.baidu.swan.apps.console.c.e("GuidePushSettingAction", "openPushGuide source empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (!(context instanceof Activity)) {
            com.baidu.swan.apps.console.c.e("GuidePushSettingAction", "illegal context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal context");
            return false;
        } else {
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            boolean cR = b.cR(context);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("authorized", cR);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (cR) {
                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            } else {
                b.a(context, a(context, jSONObject, optString, callbackHandler));
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("authorized", cR);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0));
                return true;
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
    }

    private b.a a(final Context context, final JSONObject jSONObject, final String str, final CallbackHandler callbackHandler) {
        return new b.a() { // from class: com.baidu.swan.bdprivate.extensions.e.c.1
            @Override // com.baidu.swan.bdprivate.extensions.e.b.a
            public void onResult(boolean z) {
                if (z) {
                    b.dp(context);
                }
                try {
                    jSONObject.put("canceled", z);
                } catch (JSONException e) {
                    if (c.DEBUG) {
                        e.printStackTrace();
                    }
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            }
        };
    }
}
