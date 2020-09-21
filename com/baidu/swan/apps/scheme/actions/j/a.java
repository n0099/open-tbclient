package com.baidu.swan.apps.scheme.actions.j;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes3.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/startPullDownRefresh");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar != null && eVar.acu()) {
            if (DEBUG) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        }
        f YG = com.baidu.swan.apps.v.f.asJ().YG();
        if (YG == null) {
            c.e("startPullDownRefresh", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!(YG.ahW() instanceof com.baidu.swan.apps.core.d.e)) {
            c.e("startPullDownRefresh", "top fragment error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            com.baidu.swan.apps.core.d.e eVar2 = (com.baidu.swan.apps.core.d.e) YG.ahW();
            if (eVar2.abt() == null) {
                c.e("startPullDownRefresh", "view is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            c.i("startPullDownRefresh", "start pull refresh");
            eVar2.abt().doPullRefreshing(true, 100L);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
