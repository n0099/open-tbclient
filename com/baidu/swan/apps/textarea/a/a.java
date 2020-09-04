package com.baidu.swan.apps.textarea.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/closeTextarea");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        com.baidu.swan.apps.console.c.i("CloseTextAreaAction", "closeTextAreaAction paramsJson: " + optParamsAsJo);
        com.baidu.swan.apps.component.components.textarea.b bVar = new com.baidu.swan.apps.component.components.textarea.b();
        try {
            bVar.parseFromJson(optParamsAsJo);
        } catch (JSONException e) {
            e.printStackTrace();
            com.baidu.swan.apps.console.c.e("CloseTextAreaAction", "model parse exception:", e);
        }
        com.baidu.swan.apps.component.components.textarea.a aVar = (com.baidu.swan.apps.component.components.textarea.a) com.baidu.swan.apps.component.container.a.d(bVar);
        if (aVar == null) {
            String str = "can't find textarea component:#" + bVar.caX;
            com.baidu.swan.apps.console.c.e("CloseTextAreaAction", str);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str);
            return false;
        }
        com.baidu.swan.apps.component.b.c adb = aVar.adb();
        if (!adb.isSuccess()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, adb.msg);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
