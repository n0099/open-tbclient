package com.baidu.swan.apps.scheme.actions.j;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.y.f;
/* loaded from: classes11.dex */
public class b extends ab {
    public b(j jVar) {
        super(jVar, "/swanAPI/stopPullDownRefresh");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        com.baidu.swan.apps.core.d.e Ot = f.aeJ().Ot();
        if (Ot == null) {
            c.e("stopPullDownRefresh", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!(Ot.Wd() instanceof d)) {
            c.e("stopPullDownRefresh", "top fragment error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            d dVar = (d) Ot.Wd();
            if (dVar.Qw() == null) {
                c.e("stopPullDownRefresh", "view is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            dVar.Qw().er(false);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            c.i("stopPullDownRefresh", "refresh complete");
            return true;
        }
    }
}
