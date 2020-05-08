package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.s;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.actions.k.g;
import java.util.UUID;
/* loaded from: classes11.dex */
public class j extends ab {
    public j(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/switchTab");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("SwitchTabAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        final String uuid = UUID.randomUUID().toString();
        com.baidu.swan.apps.performance.g.ln(uuid);
        String a = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.e("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final String optString = s.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        final com.baidu.swan.apps.y.f aeJ = com.baidu.swan.apps.y.f.aeJ();
        final com.baidu.swan.apps.core.d.e Ot = aeJ.Ot();
        if (Ot == null) {
            com.baidu.swan.apps.console.c.e("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b bg = com.baidu.swan.apps.model.b.bg(a, aeJ.aer());
        if (!ai.a(aeJ.aep(), bg)) {
            com.baidu.swan.apps.console.c.e("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a2 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.performance.f.bh("route", uuid).f(new UbcFlowEvent("fe_route_start").aZ(Long.valueOf(a2).longValue()));
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        aeJ.showLoadingView();
        g.a(eVar, bg.mPage, "", new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.j.1
            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void gt(String str) {
                com.baidu.swan.apps.performance.g.lm(uuid);
                aeJ.Ow();
                com.baidu.swan.apps.core.d.d Wf = Ot.Wf();
                if (Wf == null || TextUtils.isEmpty(Wf.ik(bg.mPage))) {
                    final b.a G = com.baidu.swan.apps.core.slave.b.G(aeJ.aeu());
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.mF(G.bQj.QF()), 0));
                    com.baidu.swan.apps.performance.f.bh("route", uuid).f(new UbcFlowEvent("na_pre_load_slave_check")).bk("preload", G.isReady ? "1" : "0");
                    com.baidu.swan.apps.core.slave.b.a(G, new b.InterfaceC0306b() { // from class: com.baidu.swan.apps.scheme.actions.k.j.1.1
                        @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0306b
                        public void onReady() {
                            com.baidu.swan.apps.performance.g.a(G, uuid);
                            a.a(G.bQj, bg, uuid);
                            com.baidu.swan.apps.performance.g.R(5, uuid);
                            j.this.d(Ot, bg, uuid);
                        }
                    });
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.mF(Wf.ik(bg.mPage)), 0));
                com.baidu.swan.apps.performance.g.R(4, uuid);
                j.this.d(Ot, bg, uuid);
            }

            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void ed(int i) {
                aeJ.Ow();
                if (j.DEBUG) {
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
        eVar.io("switchTab").ab(0, 0).Wm().b(bVar).Wp();
        com.baidu.swan.apps.performance.f.bh("route", str).f(new UbcFlowEvent("na_push_page_end"));
        com.baidu.swan.apps.performance.g.lo(str);
    }
}
