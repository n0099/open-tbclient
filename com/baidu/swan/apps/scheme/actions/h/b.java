package com.baidu.swan.apps.scheme.actions.h;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes2.dex */
public class b extends z {
    public b(j jVar) {
        super(jVar, "/swan/stopPullDownRefresh");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        e AI = com.baidu.swan.apps.w.e.LE().AI();
        if (AI == null) {
            c.e("stopPullDownRefresh", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!(AI.Fr() instanceof d)) {
            c.e("stopPullDownRefresh", "top fragment error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            d dVar = (d) AI.Fr();
            if (dVar.Cm() == null) {
                c.e("stopPullDownRefresh", "view is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            dVar.Cm().ce(false);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            c.i("stopPullDownRefresh", "refresh complete");
            return true;
        }
    }
}
