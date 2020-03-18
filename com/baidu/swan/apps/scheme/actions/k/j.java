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
        com.baidu.swan.apps.performance.g.ka(uuid);
        String a = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.e("switchTab", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final String optString = s.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        final com.baidu.swan.apps.y.f WV = com.baidu.swan.apps.y.f.WV();
        final com.baidu.swan.apps.core.d.e GH = WV.GH();
        if (GH == null) {
            com.baidu.swan.apps.console.c.e("switchTab", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b aW = com.baidu.swan.apps.model.b.aW(a, WV.WD());
        if (!ai.a(WV.WB(), aW)) {
            com.baidu.swan.apps.console.c.e("switchTab", "tab params error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a2 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.performance.f.aX("route", uuid).f(new UbcFlowEvent("fe_route_start").au(Long.valueOf(a2).longValue()));
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        WV.showLoadingView();
        g.a(eVar, aW.mPage, "", new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.j.1
            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void success(String str) {
                com.baidu.swan.apps.performance.g.jZ(uuid);
                WV.GK();
                com.baidu.swan.apps.core.d.d Os = GH.Os();
                if (Os == null || TextUtils.isEmpty(Os.gW(aW.mPage))) {
                    final b.a K = com.baidu.swan.apps.core.slave.b.K(WV.WG());
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.ls(K.brX.IU()), 0));
                    com.baidu.swan.apps.performance.f.aX("route", uuid).f(new UbcFlowEvent("na_pre_load_slave_check")).ba("preload", K.brY ? "1" : "0");
                    com.baidu.swan.apps.core.slave.b.a(K, new b.InterfaceC0255b() { // from class: com.baidu.swan.apps.scheme.actions.k.j.1.1
                        @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0255b
                        public void onReady() {
                            com.baidu.swan.apps.performance.g.a(K, uuid);
                            a.a(K.brX, aW, uuid);
                            com.baidu.swan.apps.performance.g.A(5, uuid);
                            j.this.d(GH, aW, uuid);
                        }
                    });
                    return;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a.ls(Os.gW(aW.mPage)), 0));
                com.baidu.swan.apps.performance.g.A(4, uuid);
                j.this.d(GH, aW, uuid);
            }

            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void dY(int i) {
                WV.GK();
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
        eVar.ha("switchTab").Y(0, 0).Oz().b(bVar).OC();
        com.baidu.swan.apps.performance.f.aX("route", str).f(new UbcFlowEvent("na_push_page_end"));
        com.baidu.swan.apps.performance.g.kb(str);
    }
}
