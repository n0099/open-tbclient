package com.baidu.swan.apps.scheme.actions.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends z {
    public b(j jVar) {
        super(jVar, "/swan/setBackgroundTextStyle");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            c.e("setBackgroundTextStyle", "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        if (DEBUG) {
            Log.d("setBackgroundTextStyle", optParamsAsJo.toString());
        }
        e AH = com.baidu.swan.apps.w.e.LD().AH();
        if (AH == null) {
            c.e("setBackgroundTextStyle", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString = optParamsAsJo.optString("textStyle");
        if (TextUtils.isEmpty(optString)) {
            c.e("setBackgroundTextStyle", "text style is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (!AH.Fr().Fg().cK(com.baidu.swan.apps.ae.a.c.bR(optString))) {
            c.e("setBackgroundTextStyle", "set window background fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
