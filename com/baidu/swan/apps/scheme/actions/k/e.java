package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.v;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.actions.k.g;
import java.util.UUID;
@Deprecated
/* loaded from: classes3.dex */
public class e extends aa {
    private static final int bZi = com.baidu.swan.apps.t.a.apx().Zi();
    private Context mContext;

    static {
        if (DEBUG) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + bZi);
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
        com.baidu.swan.apps.performance.j.pE(uuid);
        String a = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        final com.baidu.swan.apps.v.f asJ = com.baidu.swan.apps.v.f.asJ();
        final com.baidu.swan.apps.core.d.f YG = asJ.YG();
        if (YG == null) {
            com.baidu.swan.apps.console.c.e("navigateTo", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b bP = com.baidu.swan.apps.model.b.bP(a, asJ.asq());
        if (!ak.a(asJ.aso(), bP, false)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "page params error : path=" + bP.mPage + " ; routePath=" + bP.cFG);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String a2 = a.a(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(a2) && bP != null && !TextUtils.isEmpty(bP.cFG) && com.baidu.swan.apps.runtime.e.aAr() != null) {
            com.baidu.swan.apps.runtime.e.aAr().ce(a2, bP.cFG);
        }
        String a3 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a3)) {
            com.baidu.swan.apps.performance.i.bT("route", uuid).f(new UbcFlowEvent("fe_route_start").bs(Long.valueOf(a3).longValue()));
        }
        if (DEBUG) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        final b.a G = com.baidu.swan.apps.core.slave.b.G(asJ.ast());
        final String abD = G.coR.abD();
        if (DEBUG) {
            Log.d("NavigateToAction", "slave webView id: " + abD);
        }
        final String optString = v.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (com.baidu.swan.apps.scheme.actions.forbidden.a.aBB().f(bP)) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.aBB().c("navigateTo", bP);
            com.baidu.swan.apps.console.c.e("NavigateToAction", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            asJ.showLoadingView();
            g.a(eVar, bP, abD, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.e.1
                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void jn(String str) {
                    com.baidu.swan.apps.performance.j.pD(uuid);
                    com.baidu.swan.apps.console.c.i("navigateTo", "check pages success");
                    com.baidu.swan.apps.statistic.h.j(true, eVar.YI().arx());
                    asJ.YJ();
                    a.a(unitedSchemeEntity, callbackHandler, eVar, abD, bP.mPage, a.e(YG), optString);
                    e.this.a(G, bP, YG, uuid);
                }

                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void gE(int i) {
                    com.baidu.swan.apps.console.c.e("navigateTo", "check pages failed");
                    com.baidu.swan.apps.statistic.h.j(false, eVar.YI().arx());
                    asJ.YJ();
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
        com.baidu.swan.apps.performance.i.bT("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).bW("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0390b() { // from class: com.baidu.swan.apps.scheme.actions.k.e.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0390b
            public void onReady() {
                if (e.DEBUG) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                com.baidu.swan.apps.performance.j.a(aVar, str);
                e.this.a(aVar.coR, bVar, fVar, str);
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
        SwanAppActivity ast = com.baidu.swan.apps.v.f.asJ().ast();
        if (ast != null && !ast.isFinishing()) {
            a.a(cVar, bVar, str);
            if (fVar.ahZ() < bZi) {
                fVar.lH("navigateTo").al(com.baidu.swan.apps.core.d.f.ckl, com.baidu.swan.apps.core.d.f.ckn).a("normal", bVar).aih();
                com.baidu.swan.apps.ap.f.a(fVar, this.mContext);
                com.baidu.swan.apps.performance.i.bT("route", str).f(new UbcFlowEvent("na_push_page_end"));
                com.baidu.swan.apps.performance.j.U(0, str);
                com.baidu.swan.apps.performance.j.pF(str);
                return;
            }
            com.baidu.swan.apps.api.module.g.c.a(fVar, bVar, str, true);
        }
    }
}
