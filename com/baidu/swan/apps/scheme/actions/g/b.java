package com.baidu.swan.apps.scheme.actions.g;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends z {
    public b(j jVar) {
        super(jVar, "/swan/setNavigationBarColor");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("BarColorAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        e AH = com.baidu.swan.apps.w.e.LD().AH();
        if (AH == null) {
            com.baidu.swan.apps.console.c.e("navigationColor", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("navigationColor", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            String optString = optParamsAsJo.optString("frontColor");
            String optString2 = optParamsAsJo.optString("backgroundColor");
            JSONObject optJSONObject = optParamsAsJo.optJSONObject("animation");
            com.baidu.swan.apps.core.d.b Fq = AH.Fq();
            if (!Fq.ev(optString)) {
                com.baidu.swan.apps.console.c.e("navigationColor", "set title color fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!Fq.cY(com.baidu.swan.apps.ae.a.c.bR(optString2))) {
                com.baidu.swan.apps.console.c.e("navigationColor", "set title background fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                if (optJSONObject != null) {
                    Fq.p(optJSONObject.optInt("duration"), optJSONObject.optString("timingFunc"));
                    com.baidu.swan.apps.console.c.i("navigationColor", "set action bar animator");
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
    }
}
