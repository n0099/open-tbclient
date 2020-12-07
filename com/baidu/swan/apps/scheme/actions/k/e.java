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
/* loaded from: classes25.dex */
public class e extends aa {
    private static final int cFd = com.baidu.swan.apps.t.a.azd().aiO();
    private Context mContext;

    static {
        if (DEBUG) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + cFd);
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
        com.baidu.swan.apps.performance.j.ry(uuid);
        String a2 = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        final com.baidu.swan.apps.v.f aCp = com.baidu.swan.apps.v.f.aCp();
        final com.baidu.swan.apps.core.d.f aim = aCp.aim();
        if (aim == null) {
            com.baidu.swan.apps.console.c.e("navigateTo", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b ch = com.baidu.swan.apps.model.b.ch(a2, aCp.aBW());
        if (!ak.a(aCp.aBU(), ch, false)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "page params error : path=" + ch.mPage + " ; routePath=" + ch.dlu);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String a3 = a.a(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(a3) && ch != null && !TextUtils.isEmpty(ch.dlu) && com.baidu.swan.apps.runtime.e.aJU() != null) {
            com.baidu.swan.apps.runtime.e.aJU().cw(a3, ch.dlu);
        }
        String a4 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a4)) {
            com.baidu.swan.apps.performance.i.cl("route", uuid).f(new UbcFlowEvent("fe_route_start").cx(Long.valueOf(a4).longValue()));
        }
        if (DEBUG) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        final b.a G = com.baidu.swan.apps.core.slave.b.G(aCp.aBZ());
        final String alj = G.cUE.alj();
        if (DEBUG) {
            Log.d("NavigateToAction", "slave webView id: " + alj);
        }
        final String optString = v.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (com.baidu.swan.apps.scheme.actions.forbidden.a.aLe().f(ch)) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.aLe().c("navigateTo", ch);
            com.baidu.swan.apps.console.c.e("NavigateToAction", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            aCp.showLoadingView();
            g.a(eVar, ch, alj, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.e.1
                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void li(String str) {
                    com.baidu.swan.apps.performance.j.rx(uuid);
                    com.baidu.swan.apps.console.c.i("navigateTo", "check pages success");
                    com.baidu.swan.apps.statistic.h.l(true, eVar.aio().aBe());
                    aCp.aip();
                    a.a(unitedSchemeEntity, callbackHandler, eVar, alj, ch.mPage, a.e(aim), optString);
                    e.this.a(G, ch, aim, uuid);
                }

                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void hQ(int i) {
                    com.baidu.swan.apps.console.c.e("navigateTo", "check pages failed");
                    com.baidu.swan.apps.statistic.h.l(false, eVar.aio().aBe());
                    aCp.aip();
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
        com.baidu.swan.apps.performance.i.cl("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).co("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0443b() { // from class: com.baidu.swan.apps.scheme.actions.k.e.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0443b
            public void onReady() {
                if (e.DEBUG) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                com.baidu.swan.apps.performance.j.a(aVar, str);
                e.this.a(aVar.cUE, bVar, fVar, str);
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
        SwanAppActivity aBZ = com.baidu.swan.apps.v.f.aCp().aBZ();
        if (aBZ != null && !aBZ.isFinishing()) {
            a.a(cVar, bVar, str);
            if (fVar.arE() < cFd) {
                fVar.nC("navigateTo").an(com.baidu.swan.apps.core.d.f.cQb, com.baidu.swan.apps.core.d.f.cQd).a("normal", bVar).arM();
                com.baidu.swan.apps.ap.f.a(fVar, this.mContext);
                com.baidu.swan.apps.performance.i.cl("route", str).f(new UbcFlowEvent("na_push_page_end"));
                com.baidu.swan.apps.performance.j.al(0, str);
                com.baidu.swan.apps.performance.j.rz(str);
                return;
            }
            com.baidu.swan.apps.api.module.g.c.a(fVar, bVar, str, true);
        }
    }
}
