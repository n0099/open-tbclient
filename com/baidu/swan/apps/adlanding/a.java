package com.baidu.swan.apps.adlanding;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.d.h;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes10.dex */
public class a extends ab {
    public a(j jVar) {
        super(jVar, "/swanAPI/openAdWebPage");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("AdLandingAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String a = com.baidu.swan.apps.scheme.actions.k.a.a(unitedSchemeEntity, "params");
        String a2 = com.baidu.swan.apps.scheme.actions.k.a.a(unitedSchemeEntity, "params", "extraData");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.i("AdLanding", "adLanding: url is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        com.baidu.swan.apps.model.b aO = com.baidu.swan.apps.model.b.aO(a, a);
        aO.mParams = a2;
        if (!h.b("adLanding", aO)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.console.c.i("AdLanding", "open adLanding page finish");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
