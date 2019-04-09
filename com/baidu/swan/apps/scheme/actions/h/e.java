package com.baidu.swan.apps.scheme.actions.h;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.n;
import com.baidu.swan.apps.core.h.b;
import com.baidu.swan.apps.scheme.actions.h.f;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
/* loaded from: classes2.dex */
public class e extends y {
    private static final int aQg = com.baidu.swan.apps.u.a.Cz().vb();

    static {
        if (DEBUG) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + aQg);
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
        String b = a.b(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(b)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        final com.baidu.swan.apps.w.e Ea = com.baidu.swan.apps.w.e.Ea();
        final com.baidu.swan.apps.core.c.e uy = Ea.uy();
        if (uy == null) {
            com.baidu.swan.apps.console.c.e("navigateTo", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b ap = com.baidu.swan.apps.model.b.ap(b, Ea.DJ());
        if (!aa.a(Ea.DI(), ap, false)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "page params error : pageParam=" + ap.axM);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String a = a.a(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(a) && ap != null && !TextUtils.isEmpty(ap.axM) && com.baidu.swan.apps.ae.b.IV() != null) {
            com.baidu.swan.apps.ae.b.IV().au(a, ap.axM);
        }
        if (DEBUG) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        final b.a x = com.baidu.swan.apps.core.h.b.x(Ea.DM());
        final String wd = x.asK.wd();
        if (DEBUG) {
            Log.d("NavigateToAction", "slave webView id: " + wd);
        }
        final String optString = n.dm(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        Ea.showLoadingView();
        f.JJ().a(bVar, ap.axM, wd, new f.a() { // from class: com.baidu.swan.apps.scheme.actions.h.e.1
            @Override // com.baidu.swan.apps.scheme.actions.h.f.a
            public void eQ(String str) {
                com.baidu.swan.apps.console.c.i("navigateTo", "check pages success");
                com.baidu.swan.apps.statistic.c.g(true, bVar.uA().axK);
                Ea.uB();
                a.a(unitedSchemeEntity, callbackHandler, bVar, wd, ap.axM, optString);
                e.this.a(x, ap, uy);
            }

            @Override // com.baidu.swan.apps.scheme.actions.h.f.a
            public void cF(int i) {
                com.baidu.swan.apps.console.c.e("navigateTo", "check pages failed");
                com.baidu.swan.apps.statistic.c.g(false, bVar.uA().axK);
                Ea.uB();
                if (e.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).II();
                }
                a.c(unitedSchemeEntity, callbackHandler, optString);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final com.baidu.swan.apps.core.c.e eVar) {
        if (DEBUG) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + aVar.asL);
        }
        com.baidu.swan.apps.core.h.b.a(aVar, new b.InterfaceC0134b() { // from class: com.baidu.swan.apps.scheme.actions.h.e.2
            @Override // com.baidu.swan.apps.core.h.b.InterfaceC0134b
            public void onReady() {
                if (e.DEBUG) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                e.this.a(aVar.asK, bVar, eVar);
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
        if (eVar.yQ() < aQg) {
            eVar.ea("navigateTo").A(com.baidu.swan.apps.core.c.e.aqO, com.baidu.swan.apps.core.c.e.aqQ).a("normal", bVar).yZ();
        } else {
            h.c(eVar, bVar);
        }
    }
}
