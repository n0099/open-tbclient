package com.baidu.swan.apps.q;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e extends aa {
    public e(j jVar) {
        super(jVar, "/swanAPI/updateInput");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("updateInput", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("updateInput", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.component.components.f.b bVar = new com.baidu.swan.apps.component.components.f.b();
        try {
            bVar.parseFromJson(optParamsAsJo);
        } catch (JSONException e) {
            e.printStackTrace();
            com.baidu.swan.apps.console.c.e("SwanAppAction", "model parse exception:", e);
        }
        com.baidu.swan.apps.component.components.f.a aVar = (com.baidu.swan.apps.component.components.f.a) com.baidu.swan.apps.component.container.a.d(bVar);
        if (aVar == null) {
            com.baidu.swan.apps.console.c.e("updateInput", "input组件不存在");
            com.baidu.swan.apps.console.c.e("SwanAppAction", "can't find input component:#" + bVar.caT);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "input组件不存在");
            return false;
        }
        boolean isSuccess = aVar.a((com.baidu.swan.apps.component.components.f.a) bVar).isSuccess();
        if (isSuccess) {
            com.baidu.swan.apps.console.c.i("updateInput", "update success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return isSuccess;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 1001);
        return isSuccess;
    }
}
