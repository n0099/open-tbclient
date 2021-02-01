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
        com.baidu.swan.apps.performance.j.qy(uuid);
        String a2 = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.console.c.e("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final String optString = v.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        final com.baidu.swan.apps.v.f aAl = com.baidu.swan.apps.v.f.aAl();
        final com.baidu.swan.apps.core.d.f afX = aAl.afX();
        if (afX == null) {
            com.baidu.swan.apps.console.c.e("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b bZ = com.baidu.swan.apps.model.b.bZ(a2, aAl.azS());
        if (!ak.a(aAl.azQ(), bZ)) {
            com.baidu.swan.apps.console.c.e("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a3 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a3)) {
            com.baidu.swan.apps.performance.i.cd("route", uuid).f(new UbcFlowEvent("fe_route_start").cE(Long.valueOf(a3).longValue()));
        }
        aAl.showLoadingView();
        g.a(eVar, bZ, "", new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.k.1
            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void ki(String str) {
                com.baidu.swan.apps.performance.j.qx(uuid);
                aAl.aga();
                com.baidu.swan.apps.core.d.e apz = afX.apz();
                if (apz == null || TextUtils.isEmpty(apz.my(bZ.dnO))) {
                    final b.a z = com.baidu.swan.apps.core.slave.b.z(aAl.azV());
                    final JSONObject sm = a.sm(z.cXb.aiY());
                    com.baidu.swan.apps.performance.i.cd("route", uuid).f(new UbcFlowEvent("na_pre_load_slave_check")).cg("preload", z.isReady ? "1" : "0");
                    com.baidu.swan.apps.core.slave.b.a(z, new b.InterfaceC0415b() { // from class: com.baidu.swan.apps.scheme.actions.k.k.1.1
                        @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0415b
                        public void onReady() {
                            com.baidu.swan.apps.performance.j.a(z, uuid);
                            a.a(z.cXb, bZ, uuid);
                            com.baidu.swan.apps.performance.j.as(5, uuid);
                            k.this.c(afX, bZ, uuid);
                            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(sm, 0));
                        }
                    });
                    return;
                }
                JSONObject sm2 = a.sm(apz.my(bZ.dnO));
                com.baidu.swan.apps.performance.j.as(4, uuid);
                k.this.c(afX, bZ, uuid);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(sm2, 0));
            }

            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void gg(int i) {
                aAl.aga();
                if (k.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).aIs();
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
        fVar.mC("switchTab").af(0, 0).apF().b(bVar).apI();
        com.baidu.swan.apps.performance.i.cd("route", str).f(new UbcFlowEvent("na_push_page_end"));
        com.baidu.swan.apps.performance.j.qz(str);
    }
}
