package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.v;
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
        com.baidu.swan.apps.performance.j.qg(uuid);
        String a2 = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.console.c.e("relaunch", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final com.baidu.swan.apps.v.f azN = com.baidu.swan.apps.v.f.azN();
        final com.baidu.swan.apps.core.d.f afz = azN.afz();
        if (afz == null) {
            com.baidu.swan.apps.console.c.e("relaunch", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b cf = com.baidu.swan.apps.model.b.cf(a2, azN.azu());
        if (!ak.a(azN.azs(), cf, true)) {
            com.baidu.swan.apps.console.c.e("relaunch", "page params error : path=" + cf.mPage + " ; routePath=" + cf.dlD);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a3 = a.a(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(a3) && cf != null && !TextUtils.isEmpty(cf.dlD) && com.baidu.swan.apps.runtime.e.aIr() != null) {
            com.baidu.swan.apps.runtime.e.aIr().cu(a3, cf.dlD);
        }
        String a4 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a4)) {
            com.baidu.swan.apps.performance.i.cj("route", uuid).f(new UbcFlowEvent("fe_route_start").cy(Long.valueOf(a4).longValue()));
        }
        final b.a f = com.baidu.swan.apps.core.slave.b.f(azN.azx(), a.C0417a.arm());
        final String aiA = f.cUO.aiA();
        if (DEBUG) {
            Log.d("ReLaunchAction", "webview idx: " + aiA);
        }
        final String optString = v.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("relaunch", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (com.baidu.swan.apps.scheme.actions.forbidden.a.aJB().f(cf)) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.aJB().c("reLaunch", cf);
            com.baidu.swan.apps.console.c.e("ReLaunchAction", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            azN.showLoadingView();
            g.a(eVar, cf, aiA, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.h.1
                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void jQ(String str) {
                    com.baidu.swan.apps.performance.j.qf(uuid);
                    com.baidu.swan.apps.console.c.i("relaunch", "check pages success");
                    azN.afC();
                    a.a(unitedSchemeEntity, callbackHandler, eVar, aiA, cf.mPage, null, optString);
                    h.this.b(f, cf, afz, uuid);
                }

                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void gd(int i) {
                    com.baidu.swan.apps.console.c.e("relaunch", "check pages failed");
                    azN.afC();
                    if (h.DEBUG) {
                        com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).aHZ();
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
        com.baidu.swan.apps.performance.i.cj("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).cm("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0418b() { // from class: com.baidu.swan.apps.scheme.actions.k.h.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0418b
            public void onReady() {
                if (h.DEBUG) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
                }
                com.baidu.swan.apps.performance.j.a(aVar, str);
                a.a(aVar.cUO, bVar, str);
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
