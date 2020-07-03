package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.t;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.actions.k.g;
import java.util.UUID;
@Deprecated
/* loaded from: classes11.dex */
public class i extends aa {
    public i(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/redirectTo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
        }
        final String uuid = UUID.randomUUID().toString();
        com.baidu.swan.apps.performance.h.mK(uuid);
        String a = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.e("redirect", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final com.baidu.swan.apps.w.f ajb = com.baidu.swan.apps.w.f.ajb();
        final com.baidu.swan.apps.core.d.e RN = ajb.RN();
        if (RN == null) {
            com.baidu.swan.apps.console.c.e("redirect", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b bz = com.baidu.swan.apps.model.b.bz(a, ajb.aiI());
        if (!aj.a(ajb.aiG(), bz, false)) {
            com.baidu.swan.apps.console.c.e("redirect", "page params error : path=" + bz.mPage + " ; routePath=" + bz.ctH);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String str = unitedSchemeEntity.getParams().get("initData");
        if (!TextUtils.isEmpty(str) && bz != null && !TextUtils.isEmpty(bz.ctH) && com.baidu.swan.apps.runtime.e.apM() != null) {
            com.baidu.swan.apps.runtime.e.apM().bM(str, bz.ctH);
        }
        String a2 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.performance.g.bC("route", uuid).f(new UbcFlowEvent("fe_route_start").bg(Long.valueOf(a2).longValue()));
        }
        if (DEBUG) {
            Log.d("redirectTo", "PreloadSlaveManager start.");
        }
        final b.a F = com.baidu.swan.apps.core.slave.b.F(ajb.aiL());
        final String Up = F.ceL.Up();
        if (DEBUG) {
            Log.d("redirectTo", "webview id: " + Up);
        }
        final String optString = t.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("redirect", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        ajb.showLoadingView();
        g.a(eVar, bz, Up, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.i.1
            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void ho(String str2) {
                com.baidu.swan.apps.performance.h.mJ(uuid);
                com.baidu.swan.apps.console.c.i("redirect", "check pages success");
                ajb.RQ();
                a.a(unitedSchemeEntity, callbackHandler, eVar, Up, bz.mPage, null, optString);
                i.this.b(F, bz, RN, uuid);
            }

            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void ew(int i) {
                com.baidu.swan.apps.console.c.e("redirect", "check pages failed");
                ajb.RQ();
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
        boolean z = aVar != null && aVar.isReady;
        com.baidu.swan.apps.performance.g.bC("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).bF("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0352b() { // from class: com.baidu.swan.apps.scheme.actions.k.i.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0352b
            public void onReady() {
                if (i.DEBUG) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                com.baidu.swan.apps.performance.h.a(aVar, str);
                a.a(aVar.ceL, bVar, str);
                com.baidu.swan.apps.api.module.g.c.a(eVar, bVar, str, false);
                if (i.DEBUG) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        });
        if (DEBUG) {
            Log.d("redirectTo", "tryToExecutePageRoute end.");
        }
    }
}
