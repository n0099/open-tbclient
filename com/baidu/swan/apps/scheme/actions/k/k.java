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
/* loaded from: classes8.dex */
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
        com.baidu.swan.apps.performance.j.pk(uuid);
        String a = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.e("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final String optString = v.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        final com.baidu.swan.apps.v.f arY = com.baidu.swan.apps.v.f.arY();
        final com.baidu.swan.apps.core.d.f XX = arY.XX();
        if (XX == null) {
            com.baidu.swan.apps.console.c.e("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b bP = com.baidu.swan.apps.model.b.bP(a, arY.arF());
        if (!ak.a(arY.arD(), bP)) {
            com.baidu.swan.apps.console.c.e("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a2 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.performance.i.bT("route", uuid).f(new UbcFlowEvent("fe_route_start").br(Long.valueOf(a2).longValue()));
        }
        arY.showLoadingView();
        g.a(eVar, bP, "", new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.k.1
            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void iT(String str) {
                com.baidu.swan.apps.performance.j.pj(uuid);
                arY.Ya();
                com.baidu.swan.apps.core.d.e aho = XX.aho();
                if (aho == null || TextUtils.isEmpty(aho.lj(bP.cDC))) {
                    final b.a F = com.baidu.swan.apps.core.slave.b.F(arY.arI());
                    final JSONObject qS = a.qS(F.cmK.aaU());
                    com.baidu.swan.apps.performance.i.bT("route", uuid).f(new UbcFlowEvent("na_pre_load_slave_check")).bW("preload", F.isReady ? "1" : "0");
                    com.baidu.swan.apps.core.slave.b.a(F, new b.InterfaceC0395b() { // from class: com.baidu.swan.apps.scheme.actions.k.k.1.1
                        @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0395b
                        public void onReady() {
                            com.baidu.swan.apps.performance.j.a(F, uuid);
                            a.a(F.cmK, bP, uuid);
                            com.baidu.swan.apps.performance.j.T(5, uuid);
                            k.this.c(XX, bP, uuid);
                            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(qS, 0));
                        }
                    });
                    return;
                }
                JSONObject qS2 = a.qS(aho.lj(bP.cDC));
                com.baidu.swan.apps.performance.j.T(4, uuid);
                k.this.c(XX, bP, uuid);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(qS2, 0));
            }

            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void gv(int i) {
                arY.Ya();
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
        fVar.ln("switchTab").al(0, 0).ahu().b(bVar).ahx();
        com.baidu.swan.apps.performance.i.bT("route", str).f(new UbcFlowEvent("na_push_page_end"));
        com.baidu.swan.apps.performance.j.pl(str);
    }
}
