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
/* loaded from: classes10.dex */
public class e extends aa {
    private static final int cua = com.baidu.swan.apps.t.a.aud().adO();
    private Context mContext;

    static {
        if (DEBUG) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + cua);
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
        com.baidu.swan.apps.performance.j.qJ(uuid);
        String a2 = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        final com.baidu.swan.apps.v.f axo = com.baidu.swan.apps.v.f.axo();
        final com.baidu.swan.apps.core.d.f adm = axo.adm();
        if (adm == null) {
            com.baidu.swan.apps.console.c.e("navigateTo", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b cb = com.baidu.swan.apps.model.b.cb(a2, axo.awV());
        if (!ak.a(axo.awT(), cb, false)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "page params error : path=" + cb.mPage + " ; routePath=" + cb.dag);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String a3 = a.a(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(a3) && cb != null && !TextUtils.isEmpty(cb.dag) && com.baidu.swan.apps.runtime.e.aEU() != null) {
            com.baidu.swan.apps.runtime.e.aEU().cq(a3, cb.dag);
        }
        String a4 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a4)) {
            com.baidu.swan.apps.performance.i.cf("route", uuid).f(new UbcFlowEvent("fe_route_start").bC(Long.valueOf(a4).longValue()));
        }
        if (DEBUG) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        final b.a H = com.baidu.swan.apps.core.slave.b.H(axo.awY());
        final String agj = H.cJC.agj();
        if (DEBUG) {
            Log.d("NavigateToAction", "slave webView id: " + agj);
        }
        final String optString = v.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (com.baidu.swan.apps.scheme.actions.forbidden.a.aGe().f(cb)) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.aGe().c("navigateTo", cb);
            com.baidu.swan.apps.console.c.e("NavigateToAction", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            axo.showLoadingView();
            g.a(eVar, cb, agj, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.e.1
                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void ks(String str) {
                    com.baidu.swan.apps.performance.j.qI(uuid);
                    com.baidu.swan.apps.console.c.i("navigateTo", "check pages success");
                    com.baidu.swan.apps.statistic.h.l(true, eVar.ado().awd());
                    axo.adp();
                    a.a(unitedSchemeEntity, callbackHandler, eVar, agj, cb.mPage, a.e(adm), optString);
                    e.this.a(H, cb, adm, uuid);
                }

                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void hm(int i) {
                    com.baidu.swan.apps.console.c.e("navigateTo", "check pages failed");
                    com.baidu.swan.apps.statistic.h.l(false, eVar.ado().awd());
                    axo.adp();
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
        com.baidu.swan.apps.performance.i.cf("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).ci("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0421b() { // from class: com.baidu.swan.apps.scheme.actions.k.e.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0421b
            public void onReady() {
                if (e.DEBUG) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                com.baidu.swan.apps.performance.j.a(aVar, str);
                e.this.a(aVar.cJC, bVar, fVar, str);
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
        SwanAppActivity awY = com.baidu.swan.apps.v.f.axo().awY();
        if (awY != null && !awY.isFinishing()) {
            a.a(cVar, bVar, str);
            if (fVar.amE() < cua) {
                fVar.mM("navigateTo").al(com.baidu.swan.apps.core.d.f.cEZ, com.baidu.swan.apps.core.d.f.cFb).a("normal", bVar).amM();
                com.baidu.swan.apps.ap.f.a(fVar, this.mContext);
                com.baidu.swan.apps.performance.i.cf("route", str).f(new UbcFlowEvent("na_push_page_end"));
                com.baidu.swan.apps.performance.j.ah(0, str);
                com.baidu.swan.apps.performance.j.qK(str);
                return;
            }
            com.baidu.swan.apps.api.module.g.c.a(fVar, bVar, str, true);
        }
    }
}
