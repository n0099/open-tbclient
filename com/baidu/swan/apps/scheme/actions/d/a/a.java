package com.baidu.swan.apps.scheme.actions.d.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes11.dex */
public class a extends ab {
    public a(j jVar) {
        super(jVar, "/swanAPI/hideOpenAppGuide");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.i("HideFloatButtonGuide", unitedSchemeEntity.toString());
        }
        com.baidu.swan.apps.scheme.actions.d.a adQ = com.baidu.swan.apps.scheme.actions.d.a.adQ();
        FloatButton adS = adQ.adS();
        if (adS == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
        } else {
            adS.setVisibility(8);
            adQ.a(null);
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        }
        return true;
    }
}
