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
/* loaded from: classes3.dex */
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
        com.baidu.swan.apps.performance.j.pE(uuid);
        String a = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.e("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final String optString = v.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        final com.baidu.swan.apps.v.f asJ = com.baidu.swan.apps.v.f.asJ();
        final com.baidu.swan.apps.core.d.f YG = asJ.YG();
        if (YG == null) {
            com.baidu.swan.apps.console.c.e("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b bP = com.baidu.swan.apps.model.b.bP(a, asJ.asq());
        if (!ak.a(asJ.aso(), bP)) {
            com.baidu.swan.apps.console.c.e("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a2 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.performance.i.bT("route", uuid).f(new UbcFlowEvent("fe_route_start").bs(Long.valueOf(a2).longValue()));
        }
        asJ.showLoadingView();
        g.a(eVar, bP, "", new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.k.1
            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void jn(String str) {
                com.baidu.swan.apps.performance.j.pD(uuid);
                asJ.YJ();
                com.baidu.swan.apps.core.d.e ahY = YG.ahY();
                if (ahY == null || TextUtils.isEmpty(ahY.lD(bP.cFG))) {
                    final b.a G = com.baidu.swan.apps.core.slave.b.G(asJ.ast());
                    final JSONObject rm = a.rm(G.coR.abD());
                    com.baidu.swan.apps.performance.i.bT("route", uuid).f(new UbcFlowEvent("na_pre_load_slave_check")).bW("preload", G.isReady ? "1" : "0");
                    com.baidu.swan.apps.core.slave.b.a(G, new b.InterfaceC0390b() { // from class: com.baidu.swan.apps.scheme.actions.k.k.1.1
                        @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0390b
                        public void onReady() {
                            com.baidu.swan.apps.performance.j.a(G, uuid);
                            a.a(G.coR, bP, uuid);
                            com.baidu.swan.apps.performance.j.U(5, uuid);
                            k.this.c(YG, bP, uuid);
                            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(rm, 0));
                        }
                    });
                    return;
                }
                JSONObject rm2 = a.rm(ahY.lD(bP.cFG));
                com.baidu.swan.apps.performance.j.U(4, uuid);
                k.this.c(YG, bP, uuid);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(rm2, 0));
            }

            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void gE(int i) {
                asJ.YJ();
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
        fVar.lH("switchTab").al(0, 0).aie().b(bVar).aih();
        com.baidu.swan.apps.performance.i.bT("route", str).f(new UbcFlowEvent("na_push_page_end"));
        com.baidu.swan.apps.performance.j.pF(str);
    }
}
