package com.baidu.swan.apps.scheme.actions.i;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.z;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends z {
    public d(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/navigateBack");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        int optInt;
        if (DEBUG) {
            Log.d("NavigateBackAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String str = unitedSchemeEntity.getParams().get("params");
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
        com.baidu.swan.apps.core.d.e vi = com.baidu.swan.apps.w.e.FV().vi();
        if (vi == null) {
            com.baidu.swan.apps.console.c.e("navigateBack", "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (DEBUG) {
            Log.d("NavigateBackAction", "back delta: " + optInt);
        }
        if (optInt >= vi.zN()) {
            optInt = vi.zN() - 1;
        }
        if (DEBUG) {
            Log.d("NavigateBackAction", "real back delta: " + optInt);
        }
        vi.dN("navigateBack").y(com.baidu.swan.apps.core.d.e.aqV, com.baidu.swan.apps.core.d.e.aqU).ch(optInt).commit();
        if (!(vi.zK() instanceof com.baidu.swan.apps.core.d.d)) {
            com.baidu.swan.apps.console.c.e("navigateBack", "top fragment error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) vi.zK();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.ha(dVar != null ? dVar.zv() : ""), 0));
        return true;
    }
}
