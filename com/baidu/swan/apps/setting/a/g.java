package com.baidu.swan.apps.setting.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g extends aa {
    public g(j jVar) {
        super(jVar, "/swanAPI/login");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar != null && eVar.VF()) {
            if (DEBUG) {
                Log.d("LoginAction", "LoginAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        } else if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            com.baidu.swan.games.v.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception").toString());
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
                com.baidu.swan.games.v.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "params is null").toString());
                com.baidu.swan.apps.api.module.a.b.a(eVar, 1, 201, "params is null");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                com.baidu.swan.games.v.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                com.baidu.swan.apps.api.module.a.b.a(eVar, 1, 201, "empty cb");
                return false;
            } else if (!optParamsAsJo.optBoolean("force", true) && !eVar.arI().isLogin(context)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                com.baidu.swan.games.v.c.e(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                com.baidu.swan.apps.api.module.a.b.a(eVar, 43, 10004, "user not logged in");
                return true;
            } else {
                com.baidu.swan.apps.api.module.a.b.a(eVar, (Activity) context, optParamsAsJo, callbackHandler, optString);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
    }
}
