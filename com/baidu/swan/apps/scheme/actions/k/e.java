package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.s;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.actions.k.g;
import java.util.UUID;
@Deprecated
/* loaded from: classes10.dex */
public class e extends ab {
    private static final int baJ = com.baidu.swan.apps.w.a.RJ().EP();
    private Context mContext;

    static {
        if (DEBUG) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + baJ);
        }
    }

    public e(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/navigateTo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        this.mContext = context;
        final String uuid = UUID.randomUUID().toString();
        com.baidu.swan.apps.performance.g.jM(uuid);
        String a = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        final com.baidu.swan.apps.y.f UC = com.baidu.swan.apps.y.f.UC();
        final com.baidu.swan.apps.core.d.e El = UC.El();
        if (El == null) {
            com.baidu.swan.apps.console.c.e("navigateTo", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b aO = com.baidu.swan.apps.model.b.aO(a, UC.Uk());
        if (!ai.a(UC.Ui(), aO, false)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "page params error : pageParam=" + aO.mPage);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String a2 = a.a(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(a2) && aO != null && !TextUtils.isEmpty(aO.mPage) && com.baidu.swan.apps.runtime.e.aap() != null) {
            com.baidu.swan.apps.runtime.e.aap().aX(a2, aO.mPage);
        }
        String a3 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a3)) {
            com.baidu.swan.apps.performance.f.aP("route", uuid).f(new UbcFlowEvent("fe_route_start").aq(Long.valueOf(a3).longValue()));
        }
        if (DEBUG) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        final b.a J = com.baidu.swan.apps.core.slave.b.J(UC.Un());
        final String GA = J.bnA.GA();
        if (DEBUG) {
            Log.d("NavigateToAction", "slave webView id: " + GA);
        }
        final String optString = s.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        UC.showLoadingView();
        g.a(eVar, aO.mPage, GA, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.e.1
            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void success(String str) {
                com.baidu.swan.apps.performance.g.jL(uuid);
                com.baidu.swan.apps.console.c.i("navigateTo", "check pages success");
                com.baidu.swan.apps.statistic.f.g(true, eVar.En().Tt());
                UC.Eo();
                a.a(unitedSchemeEntity, callbackHandler, eVar, GA, aO.mPage, optString);
                e.this.a(J, aO, El, uuid);
            }

            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void dI(int i) {
                com.baidu.swan.apps.console.c.e("navigateTo", "check pages failed");
                com.baidu.swan.apps.statistic.f.g(false, eVar.En().Tt());
                UC.Eo();
                if (e.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).showToast();
                }
                a.c(unitedSchemeEntity, callbackHandler, optString);
            }
        }, uuid);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final com.baidu.swan.apps.core.d.e eVar, final String str) {
        boolean z = aVar != null && aVar.bnB;
        com.baidu.swan.apps.performance.f.aP("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).aS("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0245b() { // from class: com.baidu.swan.apps.scheme.actions.k.e.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0245b
            public void onReady() {
                if (e.DEBUG) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                com.baidu.swan.apps.performance.g.a(aVar, str);
                e.this.a(aVar.bnA, bVar, eVar, str);
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
    public void a(com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.model.b bVar, com.baidu.swan.apps.core.d.e eVar, String str) {
        a.a(cVar, bVar, str);
        if (eVar.Ma() < baJ) {
            eVar.gM("navigateTo").Y(com.baidu.swan.apps.core.d.e.bjU, com.baidu.swan.apps.core.d.e.bjW).a("normal", bVar).Mj();
            com.baidu.swan.apps.as.d.a(eVar, this.mContext);
            com.baidu.swan.apps.performance.f.aP("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.g.y(0, str);
            com.baidu.swan.apps.performance.g.jN(str);
            return;
        }
        i.a(eVar, bVar, str, true);
    }
}
