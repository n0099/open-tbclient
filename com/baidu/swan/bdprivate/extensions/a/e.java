package com.baidu.swan.bdprivate.extensions.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e extends aa {
    public e(j jVar) {
        super(jVar, "/swanAPI/getStoken");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        final String optString = optParamsAsJo.optString("tpl");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("GetStokenAction", "empty tpl");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty tpl");
            return false;
        }
        final String optString2 = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        } else if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            return false;
        } else {
            eVar.aIZ().b(context, "mapp_i_get_stoken", new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.bdprivate.extensions.a.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void N(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    e.this.a(hVar, context, callbackHandler, optString2, optString);
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.setting.oauth.h<b.d> hVar, Context context, final CallbackHandler callbackHandler, final String str, final String str2) {
        if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
            com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, str);
        } else if (TextUtils.isEmpty(com.baidu.swan.bdprivate.a.a.dU(context))) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "bduss is invalid").toString());
        } else {
            com.baidu.swan.bdprivate.a.a.a(context, new com.baidu.swan.apps.ao.e.b<Bundle>() { // from class: com.baidu.swan.bdprivate.extensions.a.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: B */
                public void N(Bundle bundle) {
                    JSONObject wrapCallbackParams;
                    if (bundle != null && !TextUtils.isEmpty(bundle.getString(str2))) {
                        String string = bundle.getString(str2);
                        com.baidu.swan.apps.console.c.i("GetStokenAction", "stoken=" + string);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("stoken", string);
                            wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                        } catch (JSONException e) {
                            if (e.DEBUG) {
                                Log.d("SwanAppAction", e.getMessage());
                            }
                            wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
                        }
                        callbackHandler.handleSchemeDispatchCallback(str, wrapCallbackParams.toString());
                        return;
                    }
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "stoken is invalid").toString());
                }
            }, str2);
        }
    }
}
