package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.v;
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
        com.baidu.swan.apps.performance.j.nm(uuid);
        String a = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.e("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final String optString = v.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        final com.baidu.swan.apps.v.f akr = com.baidu.swan.apps.v.f.akr();
        final com.baidu.swan.apps.core.d.f Sc = akr.Sc();
        if (Sc == null) {
            com.baidu.swan.apps.console.c.e("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b bB = com.baidu.swan.apps.model.b.bB(a, akr.ajY());
        if (!al.a(akr.ajW(), bB)) {
            com.baidu.swan.apps.console.c.e("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a2 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.performance.i.bE("route", uuid).f(new UbcFlowEvent("fe_route_start").bm(Long.valueOf(a2).longValue()));
        }
        akr.showLoadingView();
        g.a(eVar, bB, "", new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.k.1
            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void hw(String str) {
                com.baidu.swan.apps.performance.j.nl(uuid);
                akr.Sf();
                com.baidu.swan.apps.core.d.e abb = Sc.abb();
                if (abb == null || TextUtils.isEmpty(abb.jK(bB.cvJ))) {
                    final b.a E = com.baidu.swan.apps.core.slave.b.E(akr.akb());
                    final JSONObject oV = a.oV(E.cgw.UR());
                    com.baidu.swan.apps.performance.i.bE("route", uuid).f(new UbcFlowEvent("na_pre_load_slave_check")).bH("preload", E.isReady ? "1" : "0");
                    com.baidu.swan.apps.core.slave.b.a(E, new b.InterfaceC0353b() { // from class: com.baidu.swan.apps.scheme.actions.k.k.1.1
                        @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0353b
                        public void onReady() {
                            com.baidu.swan.apps.performance.j.a(E, uuid);
                            a.a(E.cgw, bB, uuid);
                            com.baidu.swan.apps.performance.j.U(5, uuid);
                            k.this.d(Sc, bB, uuid);
                            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(oV, 0));
                        }
                    });
                    return;
                }
                JSONObject oV2 = a.oV(abb.jK(bB.cvJ));
                com.baidu.swan.apps.performance.j.U(4, uuid);
                k.this.d(Sc, bB, uuid);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(oV2, 0));
            }

            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void ex(int i) {
                akr.Sf();
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
    public void d(com.baidu.swan.apps.core.d.f fVar, com.baidu.swan.apps.model.b bVar, String str) {
        fVar.jO("switchTab").ag(0, 0).abi().b(bVar).abl();
        com.baidu.swan.apps.performance.i.bE("route", str).f(new UbcFlowEvent("na_push_page_end"));
        com.baidu.swan.apps.performance.j.nn(str);
    }
}
