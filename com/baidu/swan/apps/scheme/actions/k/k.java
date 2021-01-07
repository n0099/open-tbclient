package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.v;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.actions.k.g;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes9.dex */
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
        com.baidu.swan.apps.performance.j.rr(uuid);
        String a2 = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.console.c.e("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final String optString = v.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        final com.baidu.swan.apps.v.f aDH = com.baidu.swan.apps.v.f.aDH();
        final com.baidu.swan.apps.core.d.f ajt = aDH.ajt();
        if (ajt == null) {
            com.baidu.swan.apps.console.c.e("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b cg = com.baidu.swan.apps.model.b.cg(a2, aDH.aDo());
        if (!ak.a(aDH.aDm(), cg)) {
            com.baidu.swan.apps.console.c.e("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a3 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a3)) {
            com.baidu.swan.apps.performance.i.ck("route", uuid).f(new UbcFlowEvent("fe_route_start").cy(Long.valueOf(a3).longValue()));
        }
        aDH.showLoadingView();
        g.a(eVar, cg, "", new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.k.1
            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void lb(String str) {
                com.baidu.swan.apps.performance.j.rq(uuid);
                aDH.ajw();
                com.baidu.swan.apps.core.d.e asW = ajt.asW();
                if (asW == null || TextUtils.isEmpty(asW.nr(cg.dqt))) {
                    final b.a F = com.baidu.swan.apps.core.slave.b.F(aDH.aDr());
                    final JSONObject tf = a.tf(F.cZA.amu());
                    com.baidu.swan.apps.performance.i.ck("route", uuid).f(new UbcFlowEvent("na_pre_load_slave_check")).cn("preload", F.isReady ? "1" : "0");
                    com.baidu.swan.apps.core.slave.b.a(F, new b.InterfaceC0435b() { // from class: com.baidu.swan.apps.scheme.actions.k.k.1.1
                        @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0435b
                        public void onReady() {
                            com.baidu.swan.apps.performance.j.a(F, uuid);
                            a.a(F.cZA, cg, uuid);
                            com.baidu.swan.apps.performance.j.an(5, uuid);
                            k.this.c(ajt, cg, uuid);
                            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(tf, 0));
                        }
                    });
                    return;
                }
                JSONObject tf2 = a.tf(asW.nr(cg.dqt));
                com.baidu.swan.apps.performance.j.an(4, uuid);
                k.this.c(ajt, cg, uuid);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(tf2, 0));
            }

            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void hK(int i) {
                aDH.ajw();
                if (k.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).aLT();
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
        fVar.nv("switchTab").ai(0, 0).atc().b(bVar).atf();
        com.baidu.swan.apps.performance.i.ck("route", str).f(new UbcFlowEvent("na_push_page_end"));
        com.baidu.swan.apps.performance.j.rs(str);
    }
}
