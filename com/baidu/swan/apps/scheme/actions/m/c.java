package com.baidu.swan.apps.scheme.actions.m;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.y.f;
/* loaded from: classes11.dex */
public class c extends ab {
    public c(j jVar) {
        super(jVar, "/swanAPI/updateWebView");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("InsertWebViewAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        d q = d.q(unitedSchemeEntity);
        if (!q.isValid()) {
            com.baidu.swan.apps.console.c.e("updateWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
        } else {
            com.baidu.swan.apps.adaptation.b.c cVar = (com.baidu.swan.apps.adaptation.b.c) f.WQ().hv(q.bil);
            if (cVar == null) {
                com.baidu.swan.apps.console.c.e("updateWebView", "viewManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            } else if (!cVar.b(q)) {
                com.baidu.swan.apps.console.c.e("updateWebView", "update webview widget fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            }
        }
        return true;
    }
}
