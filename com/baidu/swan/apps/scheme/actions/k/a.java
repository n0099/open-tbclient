package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes2.dex */
public class a extends z {
    public a(j jVar) {
        super(jVar, "/swan/insertWebView");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        com.baidu.swan.apps.core.d.d As;
        if (DEBUG) {
            Log.d("InsertWebViewAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        d m = d.m(unitedSchemeEntity);
        if (!m.isValid()) {
            com.baidu.swan.apps.console.c.e("insertWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
        } else {
            com.baidu.swan.apps.b.c.c cVar = (com.baidu.swan.apps.b.c.c) com.baidu.swan.apps.w.e.GF().dY(m.aDU);
            if (cVar == null) {
                com.baidu.swan.apps.console.c.e("insertWebView", "viewManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            } else if (!cVar.a(m)) {
                com.baidu.swan.apps.console.c.e("insertWebView", "insert webview widget fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            } else {
                com.baidu.swan.apps.core.d.e vJ = com.baidu.swan.apps.w.e.GF().vJ();
                if (vJ != null && (As = vJ.As()) != null) {
                    com.baidu.swan.apps.console.c.i("insertWebView", "disable navigationStyle custom");
                    As.Ap();
                }
                com.baidu.swan.apps.console.c.i("insertWebView", "insert webview widget success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            }
        }
        return true;
    }
}
