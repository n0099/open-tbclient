package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.v;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.actions.k.g;
import java.util.UUID;
@Deprecated
/* loaded from: classes8.dex */
public class e extends aa {
    private static final int cFh = com.baidu.swan.apps.t.a.awB().agd();
    private Context mContext;

    static {
        if (DEBUG) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + cFh);
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
        com.baidu.swan.apps.performance.j.qg(uuid);
        String a2 = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        final com.baidu.swan.apps.v.f azN = com.baidu.swan.apps.v.f.azN();
        final com.baidu.swan.apps.core.d.f afz = azN.afz();
        if (afz == null) {
            com.baidu.swan.apps.console.c.e("navigateTo", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b cf = com.baidu.swan.apps.model.b.cf(a2, azN.azu());
        if (!ak.a(azN.azs(), cf, false)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "page params error : path=" + cf.mPage + " ; routePath=" + cf.dlD);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
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
        if (DEBUG) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        final b.a F = com.baidu.swan.apps.core.slave.b.F(azN.azx());
        final String aiA = F.cUO.aiA();
        if (DEBUG) {
            Log.d("NavigateToAction", "slave webView id: " + aiA);
        }
        final String optString = v.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (com.baidu.swan.apps.scheme.actions.forbidden.a.aJB().f(cf)) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.aJB().c("navigateTo", cf);
            com.baidu.swan.apps.console.c.e("NavigateToAction", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            azN.showLoadingView();
            g.a(eVar, cf, aiA, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.e.1
                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void jQ(String str) {
                    com.baidu.swan.apps.performance.j.qf(uuid);
                    com.baidu.swan.apps.console.c.i("navigateTo", "check pages success");
                    com.baidu.swan.apps.statistic.h.l(true, eVar.afB().ayC());
                    azN.afC();
                    a.a(unitedSchemeEntity, callbackHandler, eVar, aiA, cf.mPage, a.e(afz), optString);
                    e.this.a(F, cf, afz, uuid);
                }

                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void gd(int i) {
                    com.baidu.swan.apps.console.c.e("navigateTo", "check pages failed");
                    com.baidu.swan.apps.statistic.h.l(false, eVar.afB().ayC());
                    azN.afC();
                    if (e.DEBUG) {
                        com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).aHZ();
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
        com.baidu.swan.apps.performance.i.cj("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).cm("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0418b() { // from class: com.baidu.swan.apps.scheme.actions.k.e.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0418b
            public void onReady() {
                if (e.DEBUG) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                com.baidu.swan.apps.performance.j.a(aVar, str);
                e.this.a(aVar.cUO, bVar, fVar, str);
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
        SwanAppActivity azx = com.baidu.swan.apps.v.f.azN().azx();
        if (azx != null && !azx.isFinishing()) {
            a.a(cVar, bVar, str);
            if (fVar.apb() < cFh) {
                fVar.mk("navigateTo").ai(com.baidu.swan.apps.core.d.f.cQm, com.baidu.swan.apps.core.d.f.cQo).a("normal", bVar).apk();
                com.baidu.swan.apps.ao.f.a(fVar, this.mContext);
                com.baidu.swan.apps.performance.i.cj("route", str).f(new UbcFlowEvent("na_push_page_end"));
                com.baidu.swan.apps.performance.j.ao(0, str);
                com.baidu.swan.apps.performance.j.qh(str);
                return;
            }
            com.baidu.swan.apps.api.module.g.c.a(fVar, bVar, str, true);
        }
    }
}
