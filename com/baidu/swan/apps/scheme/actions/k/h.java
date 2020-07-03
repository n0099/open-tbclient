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
        com.baidu.swan.apps.performance.h.mK(uuid);
        String a = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.e("relaunch", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final com.baidu.swan.apps.w.f ajb = com.baidu.swan.apps.w.f.ajb();
        final com.baidu.swan.apps.core.d.e RN = ajb.RN();
        if (RN == null) {
            com.baidu.swan.apps.console.c.e("relaunch", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b bz = com.baidu.swan.apps.model.b.bz(a, ajb.aiI());
        if (!aj.a(ajb.aiG(), bz, true)) {
            com.baidu.swan.apps.console.c.e("relaunch", "page params error : path=" + bz.mPage + " ; routePath=" + bz.ctH);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a2 = a.a(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(a2) && bz != null && !TextUtils.isEmpty(bz.ctH) && com.baidu.swan.apps.runtime.e.apM() != null) {
            com.baidu.swan.apps.runtime.e.apM().bM(a2, bz.ctH);
        }
        String a3 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a3)) {
            com.baidu.swan.apps.performance.g.bC("route", uuid).f(new UbcFlowEvent("fe_route_start").bg(Long.valueOf(a3).longValue()));
        }
        final b.a F = com.baidu.swan.apps.core.slave.b.F(ajb.aiL());
        final String Up = F.ceL.Up();
        if (DEBUG) {
            Log.d("ReLaunchAction", "webview idx: " + Up);
        }
        final String optString = t.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("relaunch", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        ajb.showLoadingView();
        g.a(eVar, bz, Up, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.h.1
            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void ho(String str) {
                com.baidu.swan.apps.performance.h.mJ(uuid);
                com.baidu.swan.apps.console.c.i("relaunch", "check pages success");
                ajb.RQ();
                a.a(unitedSchemeEntity, callbackHandler, eVar, Up, bz.mPage, null, optString);
                h.this.b(F, bz, RN, uuid);
            }

            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void ew(int i) {
                com.baidu.swan.apps.console.c.e("relaunch", "check pages failed");
                ajb.RQ();
                if (h.DEBUG) {
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
            Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0352b() { // from class: com.baidu.swan.apps.scheme.actions.k.h.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0352b
            public void onReady() {
                if (h.DEBUG) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
                }
                com.baidu.swan.apps.performance.h.a(aVar, str);
                a.a(aVar.ceL, bVar, str);
                h.a(eVar, bVar, str);
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
    public static void a(com.baidu.swan.apps.core.d.e eVar, com.baidu.swan.apps.model.b bVar, String str) {
        eVar.jx("reLaunch").ag(0, 0).aaf().a("normal", bVar).aah();
        com.baidu.swan.apps.performance.g.bC("route", str).f(new UbcFlowEvent("na_push_page_end"));
        com.baidu.swan.apps.performance.h.U(3, str);
        com.baidu.swan.apps.performance.h.mL(str);
    }
}
