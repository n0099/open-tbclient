package com.baidu.swan.apps.storage.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes8.dex */
public class m extends aa {
    public m(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/setStorageSync");
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
        } else if (com.baidu.swan.apps.storage.c.rP(aA)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "exceed storage key max length");
            return false;
        } else {
            String az = com.baidu.swan.apps.api.module.i.a.az(optParamsAsJo);
            if (az == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (com.baidu.swan.apps.storage.c.rQ(az)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "exceed storage item max length");
                return false;
            } else {
                com.baidu.swan.apps.storage.c azT = eVar.azT();
                if (azT.cs(aA, az)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1003, "exceed storage max length");
                    return false;
                }
                azT.aCP().putString(aA, az);
                com.baidu.swan.apps.am.e.dai.update();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                return true;
            }
        }
    }
}
