package com.baidu.swan.apps.scheme.actions.h;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.n;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.h.b;
import com.baidu.swan.apps.scheme.actions.h.f;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
/* loaded from: classes2.dex */
public class e extends y {
    private static final int aQb = com.baidu.swan.apps.u.a.CB().vc();

    static {
        if (DEBUG) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + aQb);
        }
    }

    public e(j jVar) {
        super(jVar, "/swan/navigateTo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String b = a.b(unitedSchemeEntity, LegoListActivityConfig.PARAMS);
        if (TextUtils.isEmpty(b)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        final com.baidu.swan.apps.w.e Ec = com.baidu.swan.apps.w.e.Ec();
        final com.baidu.swan.apps.core.c.e uz = Ec.uz();
        if (uz == null) {
            com.baidu.swan.apps.console.c.e("navigateTo", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b ap = com.baidu.swan.apps.model.b.ap(b, Ec.DL());
        if (!aa.a(Ec.DK(), ap, false)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "page params error : pageParam=" + ap.axH);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String a = a.a(unitedSchemeEntity, LegoListActivityConfig.PARAMS, "initData");
        if (!TextUtils.isEmpty(a) && ap != null && !TextUtils.isEmpty(ap.axH) && com.baidu.swan.apps.ae.b.IX() != null) {
            com.baidu.swan.apps.ae.b.IX().au(a, ap.axH);
        }
        if (DEBUG) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        final b.a x = com.baidu.swan.apps.core.h.b.x(Ec.DO());
        final String we = x.asE.we();
        if (DEBUG) {
            Log.d("NavigateToAction", "slave webView id: " + we);
        }
        final String optString = n.dk(unitedSchemeEntity.getParam(LegoListActivityConfig.PARAMS)).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        Ec.showLoadingView();
        f.JL().a(bVar, ap.axH, we, new f.a() { // from class: com.baidu.swan.apps.scheme.actions.h.e.1
            @Override // com.baidu.swan.apps.scheme.actions.h.f.a
            public void eP(String str) {
                com.baidu.swan.apps.console.c.i("navigateTo", "check pages success");
                com.baidu.swan.apps.statistic.c.g(true, bVar.uB().axF);
                Ec.uC();
                a.a(unitedSchemeEntity, callbackHandler, bVar, we, ap.axH, optString);
                e.this.a(x, ap, uz);
            }

            @Override // com.baidu.swan.apps.scheme.actions.h.f.a
            public void cG(int i) {
                com.baidu.swan.apps.console.c.e("navigateTo", "check pages failed");
                com.baidu.swan.apps.statistic.c.g(false, bVar.uB().axF);
                Ec.uC();
                if (e.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(b.h.aiapps_open_pages_failed) + i).IK();
                }
                a.c(unitedSchemeEntity, callbackHandler, optString);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final com.baidu.swan.apps.core.c.e eVar) {
        if (DEBUG) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + aVar.asF);
        }
        com.baidu.swan.apps.core.h.b.a(aVar, new b.InterfaceC0105b() { // from class: com.baidu.swan.apps.scheme.actions.h.e.2
            @Override // com.baidu.swan.apps.core.h.b.InterfaceC0105b
            public void onReady() {
                if (e.DEBUG) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                e.this.a(aVar.asE, bVar, eVar);
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
    public void a(com.baidu.swan.apps.b.c.c cVar, com.baidu.swan.apps.model.b bVar, com.baidu.swan.apps.core.c.e eVar) {
        a.a(cVar, bVar);
        if (eVar.yR() < aQb) {
            eVar.dY("navigateTo").A(com.baidu.swan.apps.core.c.e.aqI, com.baidu.swan.apps.core.c.e.aqK).a("normal", bVar).za();
        } else {
            h.c(eVar, bVar);
        }
    }
}
