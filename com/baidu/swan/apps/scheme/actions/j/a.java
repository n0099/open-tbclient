package com.baidu.swan.apps.scheme.actions.j;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.y.f;
/* loaded from: classes10.dex */
public class a extends ab {
    public a(j jVar) {
        super(jVar, "/swanAPI/startPullDownRefresh");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar != null && eVar.Ho()) {
            if (DEBUG) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        }
        com.baidu.swan.apps.core.d.e El = f.UC().El();
        if (El == null) {
            c.e("startPullDownRefresh", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!(El.LX() instanceof d)) {
            c.e("startPullDownRefresh", "top fragment error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            d dVar = (d) El.LX();
            if (dVar.Gr() == null) {
                c.e("startPullDownRefresh", "view is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.i("startPullDownRefresh", "start pull refresh");
            dVar.Gr().doPullRefreshing(true, 100L);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
