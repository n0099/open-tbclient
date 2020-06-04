package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.t;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.actions.k.g;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes11.dex */
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
        com.baidu.swan.apps.performance.h.mC(uuid);
        String a = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.e("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final String optString = t.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        final com.baidu.swan.apps.w.f ahV = com.baidu.swan.apps.w.f.ahV();
        final com.baidu.swan.apps.core.d.e QH = ahV.QH();
        if (QH == null) {
            com.baidu.swan.apps.console.c.e("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b bx = com.baidu.swan.apps.model.b.bx(a, ahV.ahC());
        if (!aj.a(ahV.ahA(), bx)) {
            com.baidu.swan.apps.console.c.e("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a2 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.performance.g.bA("route", uuid).f(new UbcFlowEvent("fe_route_start").bg(Long.valueOf(a2).longValue()));
        }
        ahV.showLoadingView();
        g.a(eVar, bx, "", new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.k.1
            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void hg(String str) {
                com.baidu.swan.apps.performance.h.mB(uuid);
                ahV.QK();
                com.baidu.swan.apps.core.d.d YR = QH.YR();
                if (YR == null || TextUtils.isEmpty(YR.jl(bx.coT))) {
                    final b.a F = com.baidu.swan.apps.core.slave.b.F(ahV.ahF());
                    final JSONObject oc = a.oc(F.bZV.Tj());
                    com.baidu.swan.apps.performance.g.bA("route", uuid).f(new UbcFlowEvent("na_pre_load_slave_check")).bD("preload", F.isReady ? "1" : "0");
                    com.baidu.swan.apps.core.slave.b.a(F, new b.InterfaceC0346b() { // from class: com.baidu.swan.apps.scheme.actions.k.k.1.1
                        @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0346b
                        public void onReady() {
                            com.baidu.swan.apps.performance.h.a(F, uuid);
                            a.a(F.bZV, bx, uuid);
                            com.baidu.swan.apps.performance.h.S(5, uuid);
                            k.this.d(QH, bx, uuid);
                            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(oc, 0));
                        }
                    });
                    return;
                }
                JSONObject oc2 = a.oc(YR.jl(bx.coT));
                com.baidu.swan.apps.performance.h.S(4, uuid);
                k.this.d(QH, bx, uuid);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(oc2, 0));
            }

            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void el(int i) {
                ahV.QK();
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
    public void d(com.baidu.swan.apps.core.d.e eVar, com.baidu.swan.apps.model.b bVar, String str) {
        eVar.jp("switchTab").ae(0, 0).YY().b(bVar).Zb();
        com.baidu.swan.apps.performance.g.bA("route", str).f(new UbcFlowEvent("na_push_page_end"));
        com.baidu.swan.apps.performance.h.mD(str);
    }
}
