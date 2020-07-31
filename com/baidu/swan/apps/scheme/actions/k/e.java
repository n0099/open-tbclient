package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
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
public class e extends aa {
    private static final int bRB = com.baidu.swan.apps.t.a.ahm().SF();
    private Context mContext;

    static {
        if (DEBUG) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + bRB);
        }
    }

    public e(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/navigateTo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        this.mContext = context;
        final String uuid = UUID.randomUUID().toString();
        com.baidu.swan.apps.performance.j.nm(uuid);
        String a = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        final com.baidu.swan.apps.v.f akr = com.baidu.swan.apps.v.f.akr();
        final com.baidu.swan.apps.core.d.f Sc = akr.Sc();
        if (Sc == null) {
            com.baidu.swan.apps.console.c.e("navigateTo", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b bB = com.baidu.swan.apps.model.b.bB(a, akr.ajY());
        if (!al.a(akr.ajW(), bB, false)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "page params error : path=" + bB.mPage + " ; routePath=" + bB.cvJ);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
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
        if (DEBUG) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        final b.a E = com.baidu.swan.apps.core.slave.b.E(akr.akb());
        final String UR = E.cgw.UR();
        if (DEBUG) {
            Log.d("NavigateToAction", "slave webView id: " + UR);
        }
        final String optString = v.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (com.baidu.swan.apps.scheme.actions.forbidden.a.asG().f(bB)) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.asG().c("navigateTo", bB);
            com.baidu.swan.apps.console.c.e("NavigateToAction", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            akr.showLoadingView();
            g.a(eVar, bB, UR, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.e.1
                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void hw(String str) {
                    com.baidu.swan.apps.performance.j.nl(uuid);
                    com.baidu.swan.apps.console.c.i("navigateTo", "check pages success");
                    com.baidu.swan.apps.statistic.h.j(true, eVar.Se().ajg());
                    akr.Sf();
                    a.a(unitedSchemeEntity, callbackHandler, eVar, UR, bB.mPage, a.e(Sc), optString);
                    e.this.a(E, bB, Sc, uuid);
                }

                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void ex(int i) {
                    com.baidu.swan.apps.console.c.e("navigateTo", "check pages failed");
                    com.baidu.swan.apps.statistic.h.j(false, eVar.Se().ajg());
                    akr.Sf();
                    if (e.DEBUG) {
                        com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).showToast();
                    }
                    a.c(unitedSchemeEntity, callbackHandler, optString);
                }
            }, uuid);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final com.baidu.swan.apps.core.d.f fVar, final String str) {
        boolean z = aVar != null && aVar.isReady;
        com.baidu.swan.apps.performance.i.bE("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).bH("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0353b() { // from class: com.baidu.swan.apps.scheme.actions.k.e.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0353b
            public void onReady() {
                if (e.DEBUG) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                com.baidu.swan.apps.performance.j.a(aVar, str);
                e.this.a(aVar.cgw, bVar, fVar, str);
                if (e.DEBUG) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        });
        if (DEBUG) {
            Log.d("NavigateToAction", "tryToExecutePageRoute end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.model.b bVar, com.baidu.swan.apps.core.d.f fVar, String str) {
        SwanAppActivity akb = com.baidu.swan.apps.v.f.akr().akb();
        if (akb != null && !akb.isFinishing()) {
            a.a(cVar, bVar, str);
            if (fVar.abc() < bRB) {
                fVar.jO("navigateTo").ag(com.baidu.swan.apps.core.d.f.cci, com.baidu.swan.apps.core.d.f.cck).a("normal", bVar).abl();
                com.baidu.swan.apps.aq.f.a(fVar, this.mContext);
                com.baidu.swan.apps.performance.i.bE("route", str).f(new UbcFlowEvent("na_push_page_end"));
                com.baidu.swan.apps.performance.j.U(0, str);
                com.baidu.swan.apps.performance.j.nn(str);
                return;
            }
            com.baidu.swan.apps.api.module.g.c.a(fVar, bVar, str, true);
        }
    }
}
