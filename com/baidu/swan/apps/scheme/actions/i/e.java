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
    private static final int bmK = com.baidu.swan.apps.u.a.Jm().Bd();

    static {
        if (DEBUG) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + bmK);
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
        final com.baidu.swan.apps.w.e LE = com.baidu.swan.apps.w.e.LE();
        final com.baidu.swan.apps.core.d.e AI = LE.AI();
        if (AI == null) {
            com.baidu.swan.apps.console.c.e("navigateTo", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b ay = com.baidu.swan.apps.model.b.ay(b, LE.Ln());
        if (!ac.a(LE.Lm(), ay, false)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "page params error : pageParam=" + ay.aSM);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String a = a.a(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(a) && ay != null && !TextUtils.isEmpty(ay.aSM) && com.baidu.swan.apps.ae.b.Ra() != null) {
            com.baidu.swan.apps.ae.b.Ra().aC(a, ay.aSM);
        }
        if (DEBUG) {
            Log.d("NavigateToAction", "PreloadSlaveManager start.");
        }
        final b.a z = com.baidu.swan.apps.core.i.b.z(LE.Lq());
        final String Cu = z.aMY.Cu();
        if (DEBUG) {
            Log.d("NavigateToAction", "slave webView id: " + Cu);
        }
        final String optString = o.dP(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("navigateTo", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        LE.showLoadingView();
        g.RT().a(bVar, ay.aSM, Cu, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.i.e.1
            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
            public void fO(String str) {
                com.baidu.swan.apps.console.c.i("navigateTo", "check pages success");
                com.baidu.swan.apps.statistic.e.g(true, bVar.AK().KF());
                LE.AL();
                a.a(unitedSchemeEntity, callbackHandler, bVar, Cu, ay.aSM, optString);
                e.this.a(z, ay, AI);
            }

            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
            public void dF(int i) {
                com.baidu.swan.apps.console.c.e("navigateTo", "check pages failed");
                com.baidu.swan.apps.statistic.e.g(false, bVar.AK().KF());
                LE.AL();
                if (e.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).QO();
                }
                a.c(unitedSchemeEntity, callbackHandler, optString);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final com.baidu.swan.apps.core.d.e eVar) {
        if (DEBUG) {
            Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + aVar.aMZ);
        }
        com.baidu.swan.apps.core.i.b.a(aVar, new b.InterfaceC0175b() { // from class: com.baidu.swan.apps.scheme.actions.i.e.2
            @Override // com.baidu.swan.apps.core.i.b.InterfaceC0175b
            public void onReady() {
                if (e.DEBUG) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                e.this.a(aVar.aMY, bVar, eVar);
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
        if (eVar.Fu() < bmK) {
            eVar.eC("navigateTo").F(com.baidu.swan.apps.core.d.e.aKT, com.baidu.swan.apps.core.d.e.aKV).a("normal", bVar).FD();
        } else {
            i.c(eVar, bVar);
        }
    }
}
