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
        com.baidu.swan.apps.performance.j.qq(uuid);
        String a2 = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.console.c.e("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final String optString = v.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        final com.baidu.swan.apps.v.f avu = com.baidu.swan.apps.v.f.avu();
        final com.baidu.swan.apps.core.d.f abs = avu.abs();
        if (abs == null) {
            com.baidu.swan.apps.console.c.e("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b bU = com.baidu.swan.apps.model.b.bU(a2, avu.avb());
        if (!ak.a(avu.auZ(), bU)) {
            com.baidu.swan.apps.console.c.e("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a3 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a3)) {
            com.baidu.swan.apps.performance.i.bY("route", uuid).f(new UbcFlowEvent("fe_route_start").bA(Long.valueOf(a3).longValue()));
        }
        avu.showLoadingView();
        g.a(eVar, bU, "", new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.k.1
            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void jZ(String str) {
                com.baidu.swan.apps.performance.j.qp(uuid);
                avu.abv();
                com.baidu.swan.apps.core.d.e akJ = abs.akJ();
                if (akJ == null || TextUtils.isEmpty(akJ.mp(bU.cRK))) {
                    final b.a H = com.baidu.swan.apps.core.slave.b.H(avu.ave());
                    final JSONObject rY = a.rY(H.cBg.aep());
                    com.baidu.swan.apps.performance.i.bY("route", uuid).f(new UbcFlowEvent("na_pre_load_slave_check")).cb("preload", H.isReady ? "1" : "0");
                    com.baidu.swan.apps.core.slave.b.a(H, new b.InterfaceC0407b() { // from class: com.baidu.swan.apps.scheme.actions.k.k.1.1
                        @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0407b
                        public void onReady() {
                            com.baidu.swan.apps.performance.j.a(H, uuid);
                            a.a(H.cBg, bU, uuid);
                            com.baidu.swan.apps.performance.j.af(5, uuid);
                            k.this.c(abs, bU, uuid);
                            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(rY, 0));
                        }
                    });
                    return;
                }
                JSONObject rY2 = a.rY(akJ.mp(bU.cRK));
                com.baidu.swan.apps.performance.j.af(4, uuid);
                k.this.c(abs, bU, uuid);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(rY2, 0));
            }

            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void hb(int i) {
                avu.abv();
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
        fVar.mt("switchTab").ak(0, 0).akP().b(bVar).akS();
        com.baidu.swan.apps.performance.i.bY("route", str).f(new UbcFlowEvent("na_push_page_end"));
        com.baidu.swan.apps.performance.j.qr(str);
    }
}
