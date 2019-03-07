package com.baidu.swan.apps.scheme.actions.h;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends y {
    public d(j jVar) {
        super(jVar, "/swan/navigateBack");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        int optInt;
        if (DEBUG) {
            Log.d("NavigateBackAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String str = unitedSchemeEntity.getParams().get(LegoListActivityConfig.PARAMS);
        if (TextUtils.isEmpty(str)) {
            optInt = 1;
        } else {
            try {
                optInt = new JSONObject(str).optInt("delta", 1);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.apps.console.c.e("navigateBack", "params parse fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
        }
        com.baidu.swan.apps.core.c.e uz = com.baidu.swan.apps.w.e.Ec().uz();
        if (uz == null) {
            com.baidu.swan.apps.console.c.e("navigateBack", "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (DEBUG) {
            Log.d("NavigateBackAction", "back delta: " + optInt);
        }
        if (optInt >= uz.yR()) {
            optInt = uz.yR() - 1;
        }
        if (DEBUG) {
            Log.d("NavigateBackAction", "real back delta: " + optInt);
        }
        uz.dY("navigateBack").A(com.baidu.swan.apps.core.c.e.aqK, com.baidu.swan.apps.core.c.e.aqJ).ci(optInt).commit();
        if (!(uz.yO() instanceof com.baidu.swan.apps.core.c.d)) {
            com.baidu.swan.apps.console.c.e("navigateBack", "top fragment error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        com.baidu.swan.apps.core.c.d dVar = (com.baidu.swan.apps.core.c.d) uz.yO();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.gG(dVar != null ? dVar.yB() : ""), 0));
        return true;
    }
}
