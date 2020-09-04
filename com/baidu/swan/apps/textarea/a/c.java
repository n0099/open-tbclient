package com.baidu.swan.apps.textarea.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends aa {
    public c(j jVar) {
        super(jVar, "/swanAPI/updateTextarea");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("UpdateTextAreaAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.console.c.i("UpdateTextAreaAction", "UpdateTextAreaAction updateParams: " + optParamsAsJo);
        String optString = optParamsAsJo.optString("slaveId");
        String optString2 = optParamsAsJo.optString("inputId");
        com.baidu.swan.apps.component.components.textarea.a aVar = (com.baidu.swan.apps.component.components.textarea.a) com.baidu.swan.apps.component.container.a.aZ(optString, optString2);
        if (aVar == null) {
            String str = "can't find textarea component:#" + optString2;
            com.baidu.swan.apps.console.c.e("UpdateTextAreaAction", str);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str);
            return false;
        }
        com.baidu.swan.apps.component.components.textarea.b bVar = (com.baidu.swan.apps.component.components.textarea.b) aVar.add();
        bVar.aH(optParamsAsJo);
        com.baidu.swan.apps.component.b.c a = aVar.a((com.baidu.swan.apps.component.components.textarea.a) bVar);
        if (!a.isSuccess()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, a.msg);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        aVar.kz(optString2);
        return true;
    }
}
