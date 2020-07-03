package com.baidu.swan.apps.scheme.actions.m;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.w.f;
/* loaded from: classes11.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/insertWebView");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.core.d.d ZW;
        if (DEBUG) {
            Log.d("InsertWebViewAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        d p = d.p(unitedSchemeEntity);
        if (!p.isValid()) {
            com.baidu.swan.apps.console.c.e("insertWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
        } else {
            com.baidu.swan.apps.adaptation.b.c cVar = (com.baidu.swan.apps.adaptation.b.c) f.ajb().jW(p.bUu);
            if (cVar == null) {
                com.baidu.swan.apps.console.c.e("insertWebView", "viewManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            } else if (!cVar.a(p)) {
                com.baidu.swan.apps.console.c.e("insertWebView", "insert webview widget fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            } else {
                com.baidu.swan.apps.core.d.e RN = f.ajb().RN();
                if (RN != null && (ZW = RN.ZW()) != null) {
                    com.baidu.swan.apps.console.c.i("insertWebView", "disable navigationStyle custom");
                    ZW.ZT();
                }
                com.baidu.swan.apps.console.c.i("insertWebView", "insert webview widget success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            }
        }
        return true;
    }
}
