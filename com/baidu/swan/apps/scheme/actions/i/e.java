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
    private static final int aTX = com.baidu.swan.apps.u.a.Er().wi();

    static {
        if (DEBUG) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + aTX);
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
        final com.baidu.swan.apps.w.e GJ = com.baidu.swan.apps.w.e.GJ();
        final com.baidu.swan.apps.core.d.e vN = GJ.vN();
        if (vN == null) {
            com.baidu.swan.apps.console.c.e("navigateTo", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b aq = com.baidu.swan.apps.model.b.aq(b, GJ.Gs());
        if (!ac.a(GJ.Gr(), aq, false)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "page params error : pageParam=" + aq.azQ);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String a = a.a(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(a) && aq != null && !TextUtils.isEmpty(aq.azQ) && com.baidu.swan.apps.ae.b.Mh() != null) {
            com.baidu.swan.apps.ae.b.Mh().au(a, aq.azQ);
        }
        if (DEBUG) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        final b.a A = com.baidu.swan.apps.core.i.b.A(GJ.Gv());
        final String xz = A.atZ.xz();
        if (DEBUG) {
            Log.d("NavigateToAction", "slave webView id: " + xz);
        }
        final String optString = o.df(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        GJ.showLoadingView();
        g.Nb().a(bVar, aq.azQ, xz, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.i.e.1
            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
            public void fh(String str) {
                com.baidu.swan.apps.console.c.i("navigateTo", "check pages success");
                com.baidu.swan.apps.statistic.e.f(true, bVar.vP().FK());
                GJ.vQ();
                a.a(unitedSchemeEntity, callbackHandler, bVar, xz, aq.azQ, optString);
                e.this.a(A, aq, vN);
            }

            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
            public void cK(int i) {
                com.baidu.swan.apps.console.c.e("navigateTo", "check pages failed");
                com.baidu.swan.apps.statistic.e.f(false, bVar.vP().FK());
                GJ.vQ();
                if (e.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).LU();
                }
                a.c(unitedSchemeEntity, callbackHandler, optString);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final com.baidu.swan.apps.core.d.e eVar) {
        if (DEBUG) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + aVar.aua);
        }
        com.baidu.swan.apps.core.i.b.a(aVar, new b.InterfaceC0148b() { // from class: com.baidu.swan.apps.scheme.actions.i.e.2
            @Override // com.baidu.swan.apps.core.i.b.InterfaceC0148b
            public void onReady() {
                if (e.DEBUG) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                e.this.a(aVar.atZ, bVar, eVar);
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
        if (eVar.Ay() < aTX) {
            eVar.dU("navigateTo").B(com.baidu.swan.apps.core.d.e.arU, com.baidu.swan.apps.core.d.e.arW).a("normal", bVar).AH();
        } else {
            i.c(eVar, bVar);
        }
    }
}
