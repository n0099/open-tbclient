package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes11.dex */
public class ad extends ab {
    public ad(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/ubcFlowJar");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("SwanAppAction", "start ubc flor jar");
        }
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("flowId");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty flowId");
            return false;
        }
        char c = 65535;
        switch (optString.hashCode()) {
            case 53647:
                if (optString.equals("670")) {
                    c = 0;
                    break;
                }
                break;
            case 53648:
                if (optString.equals("671")) {
                    c = 3;
                    break;
                }
                break;
            case 54610:
                if (optString.equals("772")) {
                    c = 1;
                    break;
                }
                break;
            case 55357:
                if (optString.equals("805")) {
                    c = 2;
                    break;
                }
                break;
            case 56506:
                if (optString.equals("967")) {
                    c = 4;
                    break;
                }
                break;
            case 1508542:
                if (optString.equals("1153")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                com.baidu.swan.apps.api.module.l.e.a(optParamsAsJo, eVar);
                break;
            case 1:
                com.baidu.swan.apps.api.module.l.e.s(optParamsAsJo.optJSONArray("data"));
                break;
            case 2:
                com.baidu.swan.apps.api.module.l.e.t(optParamsAsJo.optJSONArray("data"));
                break;
            case 3:
                com.baidu.swan.apps.api.module.l.e.u(optParamsAsJo.optJSONArray("data"));
                break;
            case 4:
                com.baidu.swan.apps.api.module.l.e.ah(optParamsAsJo);
                break;
            case 5:
                com.baidu.swan.apps.console.debugger.a.d.w(optParamsAsJo.optJSONArray("data"));
                break;
            default:
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "unknown flowId");
                return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
