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
/* loaded from: classes11.dex */
public class e extends ab {
    private static final int beW = com.baidu.swan.apps.w.a.TZ().Hg();
    private Context mContext;

    static {
        if (DEBUG) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + beW);
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
        com.baidu.swan.apps.performance.g.kb(uuid);
        String a = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        final com.baidu.swan.apps.y.f WS = com.baidu.swan.apps.y.f.WS();
        final com.baidu.swan.apps.core.d.e GC = WS.GC();
        if (GC == null) {
            com.baidu.swan.apps.console.c.e("navigateTo", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b aX = com.baidu.swan.apps.model.b.aX(a, WS.WA());
        if (!ai.a(WS.Wy(), aX, false)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "page params error : pageParam=" + aX.mPage);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String a2 = a.a(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(a2) && aX != null && !TextUtils.isEmpty(aX.mPage) && com.baidu.swan.apps.runtime.e.acF() != null) {
            com.baidu.swan.apps.runtime.e.acF().bg(a2, aX.mPage);
        }
        String a3 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a3)) {
            com.baidu.swan.apps.performance.f.aY("route", uuid).f(new UbcFlowEvent("fe_route_start").au(Long.valueOf(a3).longValue()));
        }
        if (DEBUG) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        final b.a K = com.baidu.swan.apps.core.slave.b.K(WS.WD());
        final String IR = K.brK.IR();
        if (DEBUG) {
            Log.d("NavigateToAction", "slave webView id: " + IR);
        }
        final String optString = s.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        WS.showLoadingView();
        g.a(eVar, aX.mPage, IR, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.e.1
            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void success(String str) {
                com.baidu.swan.apps.performance.g.ka(uuid);
                com.baidu.swan.apps.console.c.i("navigateTo", "check pages success");
                com.baidu.swan.apps.statistic.f.h(true, eVar.GE().VJ());
                WS.GF();
                a.a(unitedSchemeEntity, callbackHandler, eVar, IR, aX.mPage, optString);
                e.this.a(K, aX, GC, uuid);
            }

            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void dY(int i) {
                com.baidu.swan.apps.console.c.e("navigateTo", "check pages failed");
                com.baidu.swan.apps.statistic.f.h(false, eVar.GE().VJ());
                WS.GF();
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
        boolean z = aVar != null && aVar.brL;
        com.baidu.swan.apps.performance.f.aY("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).bb("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0255b() { // from class: com.baidu.swan.apps.scheme.actions.k.e.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0255b
            public void onReady() {
                if (e.DEBUG) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                com.baidu.swan.apps.performance.g.a(aVar, str);
                e.this.a(aVar.brK, bVar, eVar, str);
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
        if (eVar.Oq() < beW) {
            eVar.hb("navigateTo").Y(com.baidu.swan.apps.core.d.e.bof, com.baidu.swan.apps.core.d.e.boh).a("normal", bVar).Oz();
            com.baidu.swan.apps.as.d.a(eVar, this.mContext);
            com.baidu.swan.apps.performance.f.aY("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.g.A(0, str);
            com.baidu.swan.apps.performance.g.kc(str);
            return;
        }
        i.a(eVar, bVar, str, true);
    }
}
