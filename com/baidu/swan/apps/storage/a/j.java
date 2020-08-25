package com.baidu.swan.apps.storage.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes8.dex */
public class j extends aa {
    public j(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/removeStorageSync");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
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
        String aA = com.baidu.swan.apps.api.module.i.a.aA(optParamsAsJo);
        if (aA == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        eVar.azT().aCP().remove(aA);
        com.baidu.swan.apps.am.e.dai.update();
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
        return true;
    }
}
