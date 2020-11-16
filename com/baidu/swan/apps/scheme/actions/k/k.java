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
/* loaded from: classes7.dex */
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
        com.baidu.swan.apps.performance.j.qR(uuid);
        String a2 = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.console.c.e("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final String optString = v.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        final com.baidu.swan.apps.v.f azg = com.baidu.swan.apps.v.f.azg();
        final com.baidu.swan.apps.core.d.f afe = azg.afe();
        if (afe == null) {
            com.baidu.swan.apps.console.c.e("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b ca = com.baidu.swan.apps.model.b.ca(a2, azg.ayN());
        if (!ak.a(azg.ayL(), ca)) {
            com.baidu.swan.apps.console.c.e("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a3 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a3)) {
            com.baidu.swan.apps.performance.i.ce("route", uuid).f(new UbcFlowEvent("fe_route_start").bY(Long.valueOf(a3).longValue()));
        }
        azg.showLoadingView();
        g.a(eVar, ca, "", new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.k.1
            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void kB(String str) {
                com.baidu.swan.apps.performance.j.qQ(uuid);
                azg.afh();
                com.baidu.swan.apps.core.d.e aov = afe.aov();
                if (aov == null || TextUtils.isEmpty(aov.mR(ca.dew))) {
                    final b.a G = com.baidu.swan.apps.core.slave.b.G(azg.ayQ());
                    final JSONObject sB = a.sB(G.cNL.aib());
                    com.baidu.swan.apps.performance.i.ce("route", uuid).f(new UbcFlowEvent("na_pre_load_slave_check")).ch("preload", G.isReady ? "1" : "0");
                    com.baidu.swan.apps.core.slave.b.a(G, new b.InterfaceC0431b() { // from class: com.baidu.swan.apps.scheme.actions.k.k.1.1
                        @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0431b
                        public void onReady() {
                            com.baidu.swan.apps.performance.j.a(G, uuid);
                            a.a(G.cNL, ca, uuid);
                            com.baidu.swan.apps.performance.j.al(5, uuid);
                            k.this.c(afe, ca, uuid);
                            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(sB, 0));
                        }
                    });
                    return;
                }
                JSONObject sB2 = a.sB(aov.mR(ca.dew));
                com.baidu.swan.apps.performance.j.al(4, uuid);
                k.this.c(afe, ca, uuid);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(sB2, 0));
            }

            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void hs(int i) {
                azg.afh();
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
        fVar.mV("switchTab").al(0, 0).aoB().b(bVar).aoE();
        com.baidu.swan.apps.performance.i.ce("route", str).f(new UbcFlowEvent("na_push_page_end"));
        com.baidu.swan.apps.performance.j.qS(str);
    }
}
