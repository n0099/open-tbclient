package com.baidu.swan.apps.storage.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.ab;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes11.dex */
public class m extends ab {
    public m(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/setStorageSync");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("key");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty key");
            return false;
        }
        String optString2 = optParamsAsJo.optString("data");
        com.baidu.swan.apps.storage.c acN = eVar.acN();
        if (!acN.available() && acN.afi().getString(optString, "").length() < optString2.length()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not available");
            return false;
        }
        acN.afi().putString(optString, optString2);
        com.baidu.swan.apps.ap.e.bXQ.update();
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
        return true;
    }
}
