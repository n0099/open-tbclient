package com.baidu.swan.apps.scheme.actions.m;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes8.dex */
public class b extends e {
    public b(j jVar) {
        super(jVar, "/swanAPI/removeWebView");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("RemoveWebViewAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        d o = d.o(unitedSchemeEntity);
        if (!o.isValid()) {
            com.baidu.swan.apps.console.c.e("removeWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
        } else {
            com.baidu.swan.apps.adaptation.b.c cVar = (com.baidu.swan.apps.adaptation.b.c) com.baidu.swan.apps.v.f.azN().mQ(o.cJd);
            if (cVar == null) {
                com.baidu.swan.apps.console.c.e("removeWebView", "viewManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            } else if (!cVar.c(o)) {
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
