package com.baidu.swan.apps.scheme.actions.d.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes8.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/hideOpenAppGuide");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.i("HideFloatButtonGuide", unitedSchemeEntity.toString());
        }
        com.baidu.swan.apps.scheme.actions.d.a aJG = com.baidu.swan.apps.scheme.actions.d.a.aJG();
        FloatButton aJI = aJG.aJI();
        if (aJI == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
        } else {
            aJI.setVisibility(8);
            aJG.a(null);
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        }
        return true;
    }
}
