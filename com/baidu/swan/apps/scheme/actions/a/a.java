package com.baidu.swan.apps.scheme.actions.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends z {
    public a(j jVar) {
        super(jVar, "/swan/setBackgroundColor");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            c.e("backgroundColor", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        if (DEBUG) {
            Log.d("backgroundColor", optParamsAsJo.toString());
        }
        e AH = com.baidu.swan.apps.w.e.LD().AH();
        if (AH == null) {
            c.e("backgroundColor", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString = optParamsAsJo.optString("backgroundColor");
        d Fr = AH.Fr();
        if (!Fr.a(Fr.EY(), com.baidu.swan.apps.ae.a.c.bR(optString))) {
            c.e("backgroundColor", "set window background fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
