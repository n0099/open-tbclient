package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.scheme.actions.aa;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes10.dex */
public class d extends aa {
    public d(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/navigateBack");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        int optInt;
        if (DEBUG) {
            Log.d("NavigateBackAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String uuid = UUID.randomUUID().toString();
        com.baidu.swan.apps.performance.j.qX(uuid);
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
        com.baidu.swan.apps.core.d.f afM = com.baidu.swan.apps.v.f.azO().afM();
        if (afM == null) {
            com.baidu.swan.apps.console.c.e("navigateBack", "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        int ape = afM.ape();
        if (DEBUG) {
            Log.d("NavigateBackAction", "back delta: " + optInt);
        }
        if (ape == 1) {
            com.baidu.swan.apps.console.c.e("NavigateBackAction", "navigateBack api can only work when slave's count greater than 1");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "navigateBack api can only work when slave's count greater than 1");
            return false;
        }
        if (optInt >= ape) {
            optInt = ape - 1;
        }
        if (DEBUG) {
            Log.d("NavigateBackAction", "real back delta: " + optInt);
        }
        com.baidu.swan.apps.ap.f.b(afM, context);
        afM.nb("navigateBack").al(com.baidu.swan.apps.core.d.f.cKU, com.baidu.swan.apps.core.d.f.cKT).ib(optInt).commit();
        com.baidu.swan.apps.performance.i.cf("route", uuid).f(new UbcFlowEvent("na_push_page_end"));
        com.baidu.swan.apps.performance.j.al(1, uuid);
        com.baidu.swan.apps.performance.j.qY(uuid);
        if (!(afM.apb() instanceof com.baidu.swan.apps.core.d.e)) {
            com.baidu.swan.apps.console.c.e("navigateBack", "top fragment error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        com.baidu.swan.apps.core.d.e eVar2 = (com.baidu.swan.apps.core.d.e) afM.apb();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.sG(eVar2 != null ? eVar2.aoL() : ""), 0));
        return true;
    }
}
