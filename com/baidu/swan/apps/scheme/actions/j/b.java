package com.baidu.swan.apps.scheme.actions.j;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes2.dex */
public class b extends y {
    public b(j jVar) {
        super(jVar, "/swan/removeWebView");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("InsertWebViewAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        d m = d.m(unitedSchemeEntity);
        if (!m.isValid()) {
            com.baidu.swan.apps.console.c.e("removeWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
        } else {
            com.baidu.swan.apps.b.c.c cVar = (com.baidu.swan.apps.b.c.c) com.baidu.swan.apps.w.e.Ec().ee(m.aBD);
            if (cVar == null) {
                com.baidu.swan.apps.console.c.e("removeWebView", "viewManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            } else if (!cVar.c(m)) {
                com.baidu.swan.apps.console.c.e("removeWebView", "remove webview widget fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            } else {
                com.baidu.swan.apps.console.c.i("removeWebView", "remove webview widget success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            }
        }
        return true;
    }
}
