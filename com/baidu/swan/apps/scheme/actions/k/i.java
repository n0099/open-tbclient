package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.s;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.actions.k.g;
import java.util.UUID;
@Deprecated
/* loaded from: classes9.dex */
public class i extends ab {
    public i(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/redirectTo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
        }
        final String uuid = UUID.randomUUID().toString();
        com.baidu.swan.apps.performance.g.jJ(uuid);
        String a = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.e("redirect", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final com.baidu.swan.apps.y.f Uf = com.baidu.swan.apps.y.f.Uf();
        final com.baidu.swan.apps.core.d.e DP = Uf.DP();
        if (DP == null) {
            com.baidu.swan.apps.console.c.e("redirect", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b aN = com.baidu.swan.apps.model.b.aN(a, Uf.TN());
        if (!ai.a(Uf.TL(), aN, false)) {
            com.baidu.swan.apps.console.c.e("redirect", "page params error : pageParam=" + aN.mPage);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String str = unitedSchemeEntity.getParams().get("initData");
        if (!TextUtils.isEmpty(str) && aN != null && !TextUtils.isEmpty(aN.mPage) && com.baidu.swan.apps.runtime.e.ZS() != null) {
            com.baidu.swan.apps.runtime.e.ZS().aW(str, aN.mPage);
        }
        String a2 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.performance.f.aO("route", uuid).f(new UbcFlowEvent("fe_route_start").an(Long.valueOf(a2).longValue()));
        }
        if (DEBUG) {
            Log.d("redirectTo", "PreloadSlaveManager start.");
        }
        final b.a I = com.baidu.swan.apps.core.slave.b.I(Uf.TQ());
        final String Ge = I.bmM.Ge();
        if (DEBUG) {
            Log.d("redirectTo", "webview id: " + Ge);
        }
        final String optString = s.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("redirect", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        Uf.showLoadingView();
        g.a(eVar, aN.mPage, Ge, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.i.1
            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void success(String str2) {
                com.baidu.swan.apps.performance.g.jI(uuid);
                com.baidu.swan.apps.console.c.i("redirect", "check pages success");
                Uf.DS();
                a.a(unitedSchemeEntity, callbackHandler, eVar, Ge, aN.mPage, optString);
                i.this.b(I, aN, DP, uuid);
            }

            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void dH(int i) {
                com.baidu.swan.apps.console.c.e("redirect", "check pages failed");
                Uf.DS();
                if (i.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).showToast();
                }
                a.c(unitedSchemeEntity, callbackHandler, optString);
            }
        }, uuid);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final com.baidu.swan.apps.core.d.e eVar, final String str) {
        boolean z = aVar != null && aVar.bmN;
        com.baidu.swan.apps.performance.f.aO("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).aR("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0243b() { // from class: com.baidu.swan.apps.scheme.actions.k.i.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0243b
            public void onReady() {
                if (i.DEBUG) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                com.baidu.swan.apps.performance.g.a(aVar, str);
                a.a(aVar.bmM, bVar, str);
                i.a(eVar, bVar, str, false);
                if (i.DEBUG) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        });
        if (DEBUG) {
            Log.d("redirectTo", "tryToExecutePageRoute end.");
        }
    }

    public static void a(com.baidu.swan.apps.core.d.e eVar, com.baidu.swan.apps.model.b bVar, String str, boolean z) {
        eVar.gJ("redirectTo").U(0, 0).a("normal", bVar).eg(eVar.LE() - 2).LN();
        int i = 2;
        if (z) {
            i = 8;
        }
        com.baidu.swan.apps.performance.f.aO("route", str).f(new UbcFlowEvent("na_push_page_end"));
        com.baidu.swan.apps.performance.g.v(i, str);
        com.baidu.swan.apps.performance.g.jK(str);
    }
}
