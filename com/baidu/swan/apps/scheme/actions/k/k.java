package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.v;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.actions.k.g;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class k extends aa {
    public k(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/switchTab");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("SwitchTabAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        final String uuid = UUID.randomUUID().toString();
        com.baidu.swan.apps.performance.j.ry(uuid);
        String a2 = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.console.c.e("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final String optString = v.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        final com.baidu.swan.apps.v.f aCp = com.baidu.swan.apps.v.f.aCp();
        final com.baidu.swan.apps.core.d.f aim = aCp.aim();
        if (aim == null) {
            com.baidu.swan.apps.console.c.e("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b ch = com.baidu.swan.apps.model.b.ch(a2, aCp.aBW());
        if (!ak.a(aCp.aBU(), ch)) {
            com.baidu.swan.apps.console.c.e("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a3 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a3)) {
            com.baidu.swan.apps.performance.i.cl("route", uuid).f(new UbcFlowEvent("fe_route_start").cx(Long.valueOf(a3).longValue()));
        }
        aCp.showLoadingView();
        g.a(eVar, ch, "", new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.k.1
            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void li(String str) {
                com.baidu.swan.apps.performance.j.rx(uuid);
                aCp.aip();
                com.baidu.swan.apps.core.d.e arD = aim.arD();
                if (arD == null || TextUtils.isEmpty(arD.ny(ch.dlu))) {
                    final b.a G = com.baidu.swan.apps.core.slave.b.G(aCp.aBZ());
                    final JSONObject ti = a.ti(G.cUE.alj());
                    com.baidu.swan.apps.performance.i.cl("route", uuid).f(new UbcFlowEvent("na_pre_load_slave_check")).co("preload", G.isReady ? "1" : "0");
                    com.baidu.swan.apps.core.slave.b.a(G, new b.InterfaceC0443b() { // from class: com.baidu.swan.apps.scheme.actions.k.k.1.1
                        @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0443b
                        public void onReady() {
                            com.baidu.swan.apps.performance.j.a(G, uuid);
                            a.a(G.cUE, ch, uuid);
                            com.baidu.swan.apps.performance.j.al(5, uuid);
                            k.this.c(aim, ch, uuid);
                            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(ti, 0));
                        }
                    });
                    return;
                }
                JSONObject ti2 = a.ti(arD.ny(ch.dlu));
                com.baidu.swan.apps.performance.j.al(4, uuid);
                k.this.c(aim, ch, uuid);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(ti2, 0));
            }

            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void hQ(int i) {
                aCp.aip();
                if (k.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).showToast();
                }
                if (!TextUtils.isEmpty(optString)) {
                    a.c(unitedSchemeEntity, callbackHandler, optString);
                }
            }
        }, uuid);
        com.baidu.swan.apps.console.c.i("switchTab", "create and load page");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.core.d.f fVar, com.baidu.swan.apps.model.b bVar, String str) {
        fVar.nC("switchTab").an(0, 0).arJ().b(bVar).arM();
        com.baidu.swan.apps.performance.i.cl("route", str).f(new UbcFlowEvent("na_push_page_end"));
        com.baidu.swan.apps.performance.j.rz(str);
    }
}
