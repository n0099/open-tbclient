package com.baidu.swan.apps.scheme.actions;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.setting.oauth.a.b;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e extends aa {
    public e(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/confirmSwanClose");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("SwanConfirmClose", "framework runtime exception");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "framework runtime exception");
            return false;
        } else if (!(context instanceof Activity)) {
            com.baidu.swan.apps.console.c.e("SwanConfirmClose", "handle action, but context is not Activity");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                com.baidu.swan.apps.console.c.e("SwanConfirmClose", "empty params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
                return false;
            }
            final String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                com.baidu.swan.apps.console.c.e("SwanConfirmClose", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            final String optString2 = optParamsAsJo.optString("content");
            eVar.aID().b(context, "mapp_confirm_close", new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.scheme.actions.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void L(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, optString);
                        return;
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    com.baidu.swan.apps.p.a.avj().nF(optString2);
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
