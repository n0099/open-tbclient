package com.baidu.swan.apps.setting.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends aa {
    public c(j jVar) {
        super(jVar, "/swanAPI/getPhoneNumber");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        final String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        }
        Activity aAl = context instanceof Activity ? (Activity) context : eVar.aAl();
        if (aAl == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            return false;
        }
        com.baidu.swan.apps.setting.b.a.a(aAl, "mobile", null, false, new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.apps.setting.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void J(com.baidu.swan.apps.setting.b.a aVar) {
                com.baidu.swan.apps.console.c.d("OpenData", "onOpenDataCallback:: ", aVar);
                if (!aVar.aCK()) {
                    com.baidu.swan.apps.setting.oauth.c.a(aVar, callbackHandler, optString);
                } else {
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(aVar.cXD, 0).toString());
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
