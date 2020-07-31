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
@Deprecated
/* loaded from: classes7.dex */
public class i extends aa {
    public i(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/redirectTo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
        }
        final String uuid = UUID.randomUUID().toString();
        com.baidu.swan.apps.performance.j.nm(uuid);
        String a = a.a(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.e("redirect", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final com.baidu.swan.apps.v.f akr = com.baidu.swan.apps.v.f.akr();
        final com.baidu.swan.apps.core.d.f Sc = akr.Sc();
        if (Sc == null) {
            com.baidu.swan.apps.console.c.e("redirect", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b bB = com.baidu.swan.apps.model.b.bB(a, akr.ajY());
        if (!al.a(akr.ajW(), bB, false)) {
            com.baidu.swan.apps.console.c.e("redirect", "page params error : path=" + bB.mPage + " ; routePath=" + bB.cvJ);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String str = unitedSchemeEntity.getParams().get("initData");
        if (!TextUtils.isEmpty(str) && bB != null && !TextUtils.isEmpty(bB.cvJ) && com.baidu.swan.apps.runtime.e.arv() != null) {
            com.baidu.swan.apps.runtime.e.arv().bO(str, bB.cvJ);
        }
        String a2 = a.a(unitedSchemeEntity, "params", "startTime");
        if (!TextUtils.isEmpty(a2)) {
            com.baidu.swan.apps.performance.i.bE("route", uuid).f(new UbcFlowEvent("fe_route_start").bm(Long.valueOf(a2).longValue()));
        }
        if (DEBUG) {
            Log.d("redirectTo", "PreloadSlaveManager start.");
        }
        final b.a E = com.baidu.swan.apps.core.slave.b.E(akr.akb());
        final String UR = E.cgw.UR();
        if (DEBUG) {
            Log.d("redirectTo", "webview id: " + UR);
        }
        final String optString = v.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("redirect", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (com.baidu.swan.apps.scheme.actions.forbidden.a.asG().f(bB)) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.asG().c("redirectTo", bB);
            com.baidu.swan.apps.console.c.e("redirectTo", "access to this page is prohibited");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            akr.showLoadingView();
            g.a(eVar, bB, UR, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.k.i.1
                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void hw(String str2) {
                    com.baidu.swan.apps.performance.j.nl(uuid);
                    com.baidu.swan.apps.console.c.i("redirect", "check pages success");
                    akr.Sf();
                    a.a(unitedSchemeEntity, callbackHandler, eVar, UR, bB.mPage, null, optString);
                    i.this.b(E, bB, Sc, uuid);
                }

                @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                public void ex(int i) {
                    com.baidu.swan.apps.console.c.e("redirect", "check pages failed");
                    akr.Sf();
                    if (i.DEBUG) {
                        com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).showToast();
                    }
                    a.c(unitedSchemeEntity, callbackHandler, optString);
                }
            }, uuid);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final com.baidu.swan.apps.core.d.f fVar, final String str) {
        boolean z = aVar != null && aVar.isReady;
        com.baidu.swan.apps.performance.i.bE("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).bH("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0353b() { // from class: com.baidu.swan.apps.scheme.actions.k.i.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0353b
            public void onReady() {
                if (i.DEBUG) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                com.baidu.swan.apps.performance.j.a(aVar, str);
                a.a(aVar.cgw, bVar, str);
                com.baidu.swan.apps.api.module.g.c.a(fVar, bVar, str, false);
                if (i.DEBUG) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        });
        if (DEBUG) {
            Log.d("redirectTo", "tryToExecutePageRoute end.");
        }
    }
}
