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
        com.baidu.swan.apps.performance.j.qF(uuid);
        String a2 = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.console.c.e("relaunch", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final com.baidu.swan.apps.v.f aAo = com.baidu.swan.apps.v.f.aAo();
        final com.baidu.swan.apps.core.d.f aga = aAo.aga();
        if (aga == null) {
            com.baidu.swan.apps.console.c.e("relaunch", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b bZ = com.baidu.swan.apps.model.b.bZ(a2, aAo.azV());
        if (!ak.a(aAo.azT(), bZ, true)) {
            com.baidu.swan.apps.console.c.e("relaunch", "page params error : path=" + bZ.mPage + " ; routePath=" + bZ.dps);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a3 = a.a(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(a3) && bZ != null && !TextUtils.isEmpty(bZ.dps) && com.baidu.swan.apps.runtime.e.aIN() != null) {
            com.baidu.swan.apps.runtime.e.aIN().co(a3, bZ.dps);
        }
        String a4 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a4)) {
            com.baidu.swan.apps.performance.i.cd("route", uuid).f(new UbcFlowEvent("fe_route_start").cE(Long.valueOf(a4).longValue()));
        }
        final b.a f = com.baidu.swan.apps.core.slave.b.f(aAo.azY(), a.C0420a.arN());
        final String ajb = f.cYB.ajb();
        if (DEBUG) {
            Log.d("ReLaunchAction", "webview idx: " + ajb);
        }
        final String optString = v.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("relaunch", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (com.baidu.swan.apps.scheme.actions.forbidden.a.aJX().f(bZ)) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.aJX().c("reLaunch", bZ);
            com.baidu.swan.apps.console.c.e("ReLaunchAction", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            aAo.showLoadingView();
            g.a(eVar, bZ, ajb, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.h.1
                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void kp(String str) {
                    com.baidu.swan.apps.performance.j.qE(uuid);
                    com.baidu.swan.apps.console.c.i("relaunch", "check pages success");
                    aAo.agd();
                    a.a(unitedSchemeEntity, callbackHandler, eVar, ajb, bZ.mPage, null, optString);
                    h.this.b(f, bZ, aga, uuid);
                }

                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void gh(int i) {
                    com.baidu.swan.apps.console.c.e("relaunch", "check pages failed");
                    aAo.agd();
                    if (h.DEBUG) {
                        com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).aIv();
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
        com.baidu.swan.apps.performance.i.cd("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).cg("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0421b() { // from class: com.baidu.swan.apps.scheme.actions.k.h.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0421b
            public void onReady() {
                if (h.DEBUG) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
                }
                com.baidu.swan.apps.performance.j.a(aVar, str);
                a.a(aVar.cYB, bVar, str);
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
