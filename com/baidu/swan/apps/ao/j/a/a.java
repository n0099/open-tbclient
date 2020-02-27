package com.baidu.swan.apps.ao.j.a;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes11.dex */
public class a extends ab {
    public a(j jVar) {
        super(jVar, "/swanAPI/vibrateLong");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("LongVibrateAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (eVar != null && eVar.JD()) {
            if (DEBUG) {
                Log.d("LongVibrateAction", "LongVibrateAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        }
        com.baidu.swan.apps.ao.j.b.a.afW().afY();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
