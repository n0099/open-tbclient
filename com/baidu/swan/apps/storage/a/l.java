package com.baidu.swan.apps.storage.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.y;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l extends y {
    public l(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/setStorage");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
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
        com.baidu.swan.apps.storage.c Ja = bVar.Ja();
        if (!Ja.KE() && Ja.KF().getString(optString, "").length() < optString2.length()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not available");
            return false;
        }
        Ja.KF().putString(optString, optString2);
        com.baidu.swan.apps.ak.e.aVP.update();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
