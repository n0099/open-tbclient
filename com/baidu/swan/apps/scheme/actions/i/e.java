package com.baidu.swan.apps.scheme.actions.i;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.o;
import com.baidu.swan.apps.core.i.b;
import com.baidu.swan.apps.scheme.actions.i.g;
import com.baidu.swan.apps.scheme.actions.z;
/* loaded from: classes2.dex */
public class e extends z {
    private static final int aSP = com.baidu.swan.apps.u.a.DE().vD();

    static {
        if (DEBUG) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + aSP);
        }
    }

    public e(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/navigateTo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String b = a.b(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(b)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        final com.baidu.swan.apps.w.e FV = com.baidu.swan.apps.w.e.FV();
        final com.baidu.swan.apps.core.d.e vi = FV.vi();
        if (vi == null) {
            com.baidu.swan.apps.console.c.e("navigateTo", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b aq = com.baidu.swan.apps.model.b.aq(b, FV.FE());
        if (!ac.a(FV.FD(), aq, false)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "page params error : pageParam=" + aq.ayL);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String a = a.a(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(a) && aq != null && !TextUtils.isEmpty(aq.ayL) && com.baidu.swan.apps.ae.b.Lq() != null) {
            com.baidu.swan.apps.ae.b.Lq().au(a, aq.ayL);
        }
        if (DEBUG) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        final b.a x = com.baidu.swan.apps.core.i.b.x(FV.FH());
        final String wU = x.asY.wU();
        if (DEBUG) {
            Log.d("NavigateToAction", "slave webView id: " + wU);
        }
        final String optString = o.cY(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        FV.showLoadingView();
        g.Mj().a(bVar, aq.ayL, wU, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.i.e.1
            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
            public void fa(String str) {
                com.baidu.swan.apps.console.c.i("navigateTo", "check pages success");
                com.baidu.swan.apps.statistic.e.f(true, bVar.vk().EW());
                FV.vl();
                a.a(unitedSchemeEntity, callbackHandler, bVar, wU, aq.ayL, optString);
                e.this.a(x, aq, vi);
            }

            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
            public void cI(int i) {
                com.baidu.swan.apps.console.c.e("navigateTo", "check pages failed");
                com.baidu.swan.apps.statistic.e.f(false, bVar.vk().EW());
                FV.vl();
                if (e.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).Ld();
                }
                a.c(unitedSchemeEntity, callbackHandler, optString);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final com.baidu.swan.apps.core.d.e eVar) {
        if (DEBUG) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + aVar.asZ);
        }
        com.baidu.swan.apps.core.i.b.a(aVar, new b.InterfaceC0137b() { // from class: com.baidu.swan.apps.scheme.actions.i.e.2
            @Override // com.baidu.swan.apps.core.i.b.InterfaceC0137b
            public void onReady() {
                if (e.DEBUG) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                e.this.a(aVar.asY, bVar, eVar);
                if (e.DEBUG) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        });
        if (DEBUG) {
            Log.d("NavigateToAction", "tryToExecutePageRoute end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.b.c.c cVar, com.baidu.swan.apps.model.b bVar, com.baidu.swan.apps.core.d.e eVar) {
        a.a(cVar, bVar);
        if (eVar.zN() < aSP) {
            eVar.dN("navigateTo").y(com.baidu.swan.apps.core.d.e.aqT, com.baidu.swan.apps.core.d.e.aqV).a("normal", bVar).zW();
        } else {
            i.c(eVar, bVar);
        }
    }
}
