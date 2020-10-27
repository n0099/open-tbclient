package com.baidu.swan.apps.scheme.actions.m;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
/* loaded from: classes10.dex */
public class a extends e {
    public a(j jVar) {
        super(jVar, "/swanAPI/insertWebView");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("InsertWebViewAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        final d p = d.p(unitedSchemeEntity);
        if (!p.isValid()) {
            com.baidu.swan.apps.console.c.e("insertWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (!TextUtils.isEmpty(p.mSrc) && d(p.mSrc, p.dqO)) {
            com.baidu.swan.apps.console.c.e("insertWebView", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else {
            final com.baidu.swan.apps.adaptation.b.c cVar = (com.baidu.swan.apps.adaptation.b.c) com.baidu.swan.apps.v.f.axo().ns(p.cxS);
            if (cVar == null) {
                com.baidu.swan.apps.console.c.e("insertWebView", "viewManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            if (TextUtils.equals(p.mType, "quickPass")) {
                eVar.aFg().b(context, "scope_webview_extra_operation", new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.scheme.actions.m.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: a */
                    public void M(h<b.d> hVar) {
                        if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                            com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, p.callback);
                            p.anz = null;
                        } else {
                            p.dqN = false;
                            a.this.a(callbackHandler, (SwanAppSlaveManager) cVar, p);
                        }
                        if (cVar.a(p)) {
                            a.this.amx();
                            return;
                        }
                        com.baidu.swan.apps.console.c.e("insertWebView", "insert webview widget fail");
                        callbackHandler.handleSchemeDispatchCallback(p.callback, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    }
                });
            } else if (!cVar.a(p)) {
                com.baidu.swan.apps.console.c.e("insertWebView", "insert webview widget fail");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                amx();
            }
            com.baidu.swan.apps.console.c.i("insertWebView", "insert webview widget success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amx() {
        com.baidu.swan.apps.core.d.e amC;
        com.baidu.swan.apps.core.d.f adm = com.baidu.swan.apps.v.f.axo().adm();
        if (adm != null && (amC = adm.amC()) != null) {
            com.baidu.swan.apps.console.c.i("insertWebView", "disable navigationStyle custom");
            amC.amx();
        }
    }
}
