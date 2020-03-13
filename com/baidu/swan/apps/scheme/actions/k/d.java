package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.scheme.actions.ab;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes11.dex */
public class d extends ab {
    public d(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/navigateBack");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        int optInt;
        if (DEBUG) {
            Log.d("NavigateBackAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String uuid = UUID.randomUUID().toString();
        com.baidu.swan.apps.performance.g.kb(uuid);
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
        com.baidu.swan.apps.core.d.e GC = com.baidu.swan.apps.y.f.WS().GC();
        if (GC == null) {
            com.baidu.swan.apps.console.c.e("navigateBack", "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (DEBUG) {
            Log.d("NavigateBackAction", "back delta: " + optInt);
        }
        if (optInt >= GC.Oq()) {
            optInt = GC.Oq() - 1;
        }
        if (DEBUG) {
            Log.d("NavigateBackAction", "real back delta: " + optInt);
        }
        com.baidu.swan.apps.as.d.b(GC, context);
        GC.hb("navigateBack").Y(com.baidu.swan.apps.core.d.e.boi, com.baidu.swan.apps.core.d.e.boh).ey(optInt).commit();
        com.baidu.swan.apps.performance.f.aY("route", uuid).f(new UbcFlowEvent("na_push_page_end"));
        com.baidu.swan.apps.performance.g.A(1, uuid);
        com.baidu.swan.apps.performance.g.kc(uuid);
        if (!(GC.On() instanceof com.baidu.swan.apps.core.d.d)) {
            com.baidu.swan.apps.console.c.e("navigateBack", "top fragment error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) GC.On();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.lt(dVar != null ? dVar.NZ() : ""), 0));
        return true;
    }
}
