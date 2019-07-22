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
    private static final int aTz = com.baidu.swan.apps.u.a.En().we();

    static {
        if (DEBUG) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + aTz);
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
        final com.baidu.swan.apps.w.e GF = com.baidu.swan.apps.w.e.GF();
        final com.baidu.swan.apps.core.d.e vJ = GF.vJ();
        if (vJ == null) {
            com.baidu.swan.apps.console.c.e("navigateTo", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b aq = com.baidu.swan.apps.model.b.aq(b, GF.Go());
        if (!ac.a(GF.Gn(), aq, false)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "page params error : pageParam=" + aq.azs);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String a = a.a(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(a) && aq != null && !TextUtils.isEmpty(aq.azs) && com.baidu.swan.apps.ae.b.Md() != null) {
            com.baidu.swan.apps.ae.b.Md().au(a, aq.azs);
        }
        if (DEBUG) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        final b.a A = com.baidu.swan.apps.core.i.b.A(GF.Gr());
        final String xv = A.atB.xv();
        if (DEBUG) {
            Log.d("NavigateToAction", "slave webView id: " + xv);
        }
        final String optString = o.dd(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        GF.showLoadingView();
        g.MX().a(bVar, aq.azs, xv, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.i.e.1
            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
            public void ff(String str) {
                com.baidu.swan.apps.console.c.i("navigateTo", "check pages success");
                com.baidu.swan.apps.statistic.e.f(true, bVar.vL().FG());
                GF.vM();
                a.a(unitedSchemeEntity, callbackHandler, bVar, xv, aq.azs, optString);
                e.this.a(A, aq, vJ);
            }

            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
            public void cJ(int i) {
                com.baidu.swan.apps.console.c.e("navigateTo", "check pages failed");
                com.baidu.swan.apps.statistic.e.f(false, bVar.vL().FG());
                GF.vM();
                if (e.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).LQ();
                }
                a.c(unitedSchemeEntity, callbackHandler, optString);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final com.baidu.swan.apps.core.d.e eVar) {
        if (DEBUG) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + aVar.atC);
        }
        com.baidu.swan.apps.core.i.b.a(aVar, new b.InterfaceC0134b() { // from class: com.baidu.swan.apps.scheme.actions.i.e.2
            @Override // com.baidu.swan.apps.core.i.b.InterfaceC0134b
            public void onReady() {
                if (e.DEBUG) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                e.this.a(aVar.atB, bVar, eVar);
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
        if (eVar.Au() < aTz) {
            eVar.dS("navigateTo").B(com.baidu.swan.apps.core.d.e.arw, com.baidu.swan.apps.core.d.e.ary).a("normal", bVar).AD();
        } else {
            i.c(eVar, bVar);
        }
    }
}
