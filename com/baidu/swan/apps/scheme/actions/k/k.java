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
/* loaded from: classes10.dex */
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
        com.baidu.swan.apps.performance.j.qJ(uuid);
        String a2 = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.console.c.e("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final String optString = v.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        final com.baidu.swan.apps.v.f axo = com.baidu.swan.apps.v.f.axo();
        final com.baidu.swan.apps.core.d.f adm = axo.adm();
        if (adm == null) {
            com.baidu.swan.apps.console.c.e("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b cb = com.baidu.swan.apps.model.b.cb(a2, axo.awV());
        if (!ak.a(axo.awT(), cb)) {
            com.baidu.swan.apps.console.c.e("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a3 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a3)) {
            com.baidu.swan.apps.performance.i.cf("route", uuid).f(new UbcFlowEvent("fe_route_start").bC(Long.valueOf(a3).longValue()));
        }
        axo.showLoadingView();
        g.a(eVar, cb, "", new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.k.1
            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void ks(String str) {
                com.baidu.swan.apps.performance.j.qI(uuid);
                axo.adp();
                com.baidu.swan.apps.core.d.e amD = adm.amD();
                if (amD == null || TextUtils.isEmpty(amD.mI(cb.dag))) {
                    final b.a H = com.baidu.swan.apps.core.slave.b.H(axo.awY());
                    final JSONObject ss = a.ss(H.cJC.agj());
                    com.baidu.swan.apps.performance.i.cf("route", uuid).f(new UbcFlowEvent("na_pre_load_slave_check")).ci("preload", H.isReady ? "1" : "0");
                    com.baidu.swan.apps.core.slave.b.a(H, new b.InterfaceC0421b() { // from class: com.baidu.swan.apps.scheme.actions.k.k.1.1
                        @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0421b
                        public void onReady() {
                            com.baidu.swan.apps.performance.j.a(H, uuid);
                            a.a(H.cJC, cb, uuid);
                            com.baidu.swan.apps.performance.j.ah(5, uuid);
                            k.this.c(adm, cb, uuid);
                            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(ss, 0));
                        }
                    });
                    return;
                }
                JSONObject ss2 = a.ss(amD.mI(cb.dag));
                com.baidu.swan.apps.performance.j.ah(4, uuid);
                k.this.c(adm, cb, uuid);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(ss2, 0));
            }

            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void hm(int i) {
                axo.adp();
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
        fVar.mM("switchTab").al(0, 0).amJ().b(bVar).amM();
        com.baidu.swan.apps.performance.i.cf("route", str).f(new UbcFlowEvent("na_push_page_end"));
        com.baidu.swan.apps.performance.j.qK(str);
    }
}
