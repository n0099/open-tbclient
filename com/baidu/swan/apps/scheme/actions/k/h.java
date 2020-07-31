package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.v;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.actions.k.g;
import java.util.UUID;
@Deprecated
/* loaded from: classes7.dex */
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
        com.baidu.swan.apps.performance.j.nm(uuid);
        String a = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.e("relaunch", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final com.baidu.swan.apps.v.f akr = com.baidu.swan.apps.v.f.akr();
        final com.baidu.swan.apps.core.d.f Sc = akr.Sc();
        if (Sc == null) {
            com.baidu.swan.apps.console.c.e("relaunch", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b bB = com.baidu.swan.apps.model.b.bB(a, akr.ajY());
        if (!al.a(akr.ajW(), bB, true)) {
            com.baidu.swan.apps.console.c.e("relaunch", "page params error : path=" + bB.mPage + " ; routePath=" + bB.cvJ);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a2 = a.a(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(a2) && bB != null && !TextUtils.isEmpty(bB.cvJ) && com.baidu.swan.apps.runtime.e.arv() != null) {
            com.baidu.swan.apps.runtime.e.arv().bO(a2, bB.cvJ);
        }
        String a3 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a3)) {
            com.baidu.swan.apps.performance.i.bE("route", uuid).f(new UbcFlowEvent("fe_route_start").bm(Long.valueOf(a3).longValue()));
        }
        final b.a E = com.baidu.swan.apps.core.slave.b.E(akr.akb());
        final String UR = E.cgw.UR();
        if (DEBUG) {
            Log.d("ReLaunchAction", "webview idx: " + UR);
        }
        final String optString = v.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("relaunch", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (com.baidu.swan.apps.scheme.actions.forbidden.a.asG().f(bB)) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.asG().c("reLaunch", bB);
            com.baidu.swan.apps.console.c.e("ReLaunchAction", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            akr.showLoadingView();
            g.a(eVar, bB, UR, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.h.1
                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void hw(String str) {
                    com.baidu.swan.apps.performance.j.nl(uuid);
                    com.baidu.swan.apps.console.c.i("relaunch", "check pages success");
                    akr.Sf();
                    a.a(unitedSchemeEntity, callbackHandler, eVar, UR, bB.mPage, null, optString);
                    h.this.b(E, bB, Sc, uuid);
                }

                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void ex(int i) {
                    com.baidu.swan.apps.console.c.e("relaunch", "check pages failed");
                    akr.Sf();
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
        com.baidu.swan.apps.performance.i.bE("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).bH("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0353b() { // from class: com.baidu.swan.apps.scheme.actions.k.h.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0353b
            public void onReady() {
                if (h.DEBUG) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
                }
                com.baidu.swan.apps.performance.j.a(aVar, str);
                a.a(aVar.cgw, bVar, str);
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
        if (bVar != null) {
            com.baidu.swan.apps.console.c.i("ReLaunchAction", "doReLaunch page=" + bVar.mPage + " routePage=" + bVar.cvJ);
        }
        fVar.jO("reLaunch").ag(0, 0).abj().a("normal", bVar).abl();
        com.baidu.swan.apps.performance.i.bE("route", str).f(new UbcFlowEvent("na_push_page_end"));
        com.baidu.swan.apps.performance.j.U(3, str);
        com.baidu.swan.apps.performance.j.nn(str);
    }
}
