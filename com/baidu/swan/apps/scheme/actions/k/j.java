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
        com.baidu.swan.apps.performance.g.kb(uuid);
        String a = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.e("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final String optString = s.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        final com.baidu.swan.apps.y.f WS = com.baidu.swan.apps.y.f.WS();
        final com.baidu.swan.apps.core.d.e GC = WS.GC();
        if (GC == null) {
            com.baidu.swan.apps.console.c.e("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b aX = com.baidu.swan.apps.model.b.aX(a, WS.WA());
        if (!ai.a(WS.Wy(), aX)) {
            com.baidu.swan.apps.console.c.e("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a2 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.performance.f.aY("route", uuid).f(new UbcFlowEvent("fe_route_start").au(Long.valueOf(a2).longValue()));
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        WS.showLoadingView();
        g.a(eVar, aX.mPage, "", new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.j.1
            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void success(String str) {
                com.baidu.swan.apps.performance.g.ka(uuid);
                WS.GF();
                com.baidu.swan.apps.core.d.d Op = GC.Op();
                if (Op == null || TextUtils.isEmpty(Op.gX(aX.mPage))) {
                    final b.a K = com.baidu.swan.apps.core.slave.b.K(WS.WD());
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.lt(K.brK.IR()), 0));
                    com.baidu.swan.apps.performance.f.aY("route", uuid).f(new UbcFlowEvent("na_pre_load_slave_check")).bb("preload", K.brL ? "1" : "0");
                    com.baidu.swan.apps.core.slave.b.a(K, new b.InterfaceC0255b() { // from class: com.baidu.swan.apps.scheme.actions.k.j.1.1
                        @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0255b
                        public void onReady() {
                            com.baidu.swan.apps.performance.g.a(K, uuid);
                            a.a(K.brK, aX, uuid);
                            com.baidu.swan.apps.performance.g.A(5, uuid);
                            j.this.d(GC, aX, uuid);
                        }
                    });
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.lt(Op.gX(aX.mPage)), 0));
                com.baidu.swan.apps.performance.g.A(4, uuid);
                j.this.d(GC, aX, uuid);
            }

            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void dY(int i) {
                WS.GF();
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
        eVar.hb("switchTab").Y(0, 0).Ow().b(bVar).Oz();
        com.baidu.swan.apps.performance.f.aY("route", str).f(new UbcFlowEvent("na_push_page_end"));
        com.baidu.swan.apps.performance.g.kc(str);
    }
}
