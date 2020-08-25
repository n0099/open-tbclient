package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.v;
import com.baidu.swan.apps.core.slave.a;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.actions.k.g;
import java.util.UUID;
@Deprecated
/* loaded from: classes8.dex */
public class h extends aa {
    public h(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/reLaunch");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("ReLaunchAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        final String uuid = UUID.randomUUID().toString();
        com.baidu.swan.apps.performance.j.pk(uuid);
        String a = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.e("relaunch", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final com.baidu.swan.apps.v.f arY = com.baidu.swan.apps.v.f.arY();
        final com.baidu.swan.apps.core.d.f XX = arY.XX();
        if (XX == null) {
            com.baidu.swan.apps.console.c.e("relaunch", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b bP = com.baidu.swan.apps.model.b.bP(a, arY.arF());
        if (!ak.a(arY.arD(), bP, true)) {
            com.baidu.swan.apps.console.c.e("relaunch", "page params error : path=" + bP.mPage + " ; routePath=" + bP.cDC);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a2 = a.a(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(a2) && bP != null && !TextUtils.isEmpty(bP.cDC) && com.baidu.swan.apps.runtime.e.azI() != null) {
            com.baidu.swan.apps.runtime.e.azI().ce(a2, bP.cDC);
        }
        String a3 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a3)) {
            com.baidu.swan.apps.performance.i.bT("route", uuid).f(new UbcFlowEvent("fe_route_start").br(Long.valueOf(a3).longValue()));
        }
        final b.a f = com.baidu.swan.apps.core.slave.b.f(arY.arI(), a.C0394a.ajz());
        final String aaU = f.cmK.aaU();
        if (DEBUG) {
            Log.d("ReLaunchAction", "webview idx: " + aaU);
        }
        final String optString = v.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("relaunch", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (com.baidu.swan.apps.scheme.actions.forbidden.a.aAS().f(bP)) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.aAS().c("reLaunch", bP);
            com.baidu.swan.apps.console.c.e("ReLaunchAction", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            arY.showLoadingView();
            g.a(eVar, bP, aaU, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.h.1
                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void iT(String str) {
                    com.baidu.swan.apps.performance.j.pj(uuid);
                    com.baidu.swan.apps.console.c.i("relaunch", "check pages success");
                    arY.Ya();
                    a.a(unitedSchemeEntity, callbackHandler, eVar, aaU, bP.mPage, null, optString);
                    h.this.b(f, bP, XX, uuid);
                }

                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void gv(int i) {
                    com.baidu.swan.apps.console.c.e("relaunch", "check pages failed");
                    arY.Ya();
                    if (h.DEBUG) {
                        com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).showToast();
                    }
                    a.c(unitedSchemeEntity, callbackHandler, optString);
                }
            }, uuid);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final com.baidu.swan.apps.core.d.f fVar, final String str) {
        boolean z = aVar != null && aVar.isReady;
        com.baidu.swan.apps.performance.i.bT("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).bW("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0395b() { // from class: com.baidu.swan.apps.scheme.actions.k.h.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0395b
            public void onReady() {
                if (h.DEBUG) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
                }
                com.baidu.swan.apps.performance.j.a(aVar, str);
                a.a(aVar.cmK, bVar, str);
                h.a(fVar, bVar, str);
                if (h.DEBUG) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady end.");
                }
            }
        });
        if (DEBUG) {
            Log.d("ReLaunchAction", "tryToExecutePageRoute end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.baidu.swan.apps.core.d.f fVar, com.baidu.swan.apps.model.b bVar, String str) {
        com.baidu.swan.apps.api.module.g.d.a(fVar, bVar, str);
    }
}
