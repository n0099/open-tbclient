package com.baidu.swan.apps.setting.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends ab {
    public c(j jVar) {
        super(jVar, "/swanAPI/getPhoneNumber");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else if (TextUtils.isEmpty(eVar.getAppKey())) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            final String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            } else if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
                return false;
            } else {
                com.baidu.swan.apps.setting.b.a.a((Activity) context, "mobile", null, false, new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.apps.setting.a.c.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void B(com.baidu.swan.apps.setting.b.a aVar) {
                        com.baidu.swan.apps.console.c.i("OpenData", "onOpenDataCallback:: " + aVar.toString());
                        if (!aVar.aco()) {
                            com.baidu.swan.apps.setting.oauth.c.a(aVar, callbackHandler, optString);
                        } else {
                            callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(aVar.bPw, 0).toString());
                        }
                    }
                });
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
    }
}
