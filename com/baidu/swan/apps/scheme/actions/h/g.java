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
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
/* loaded from: classes2.dex */
public class g extends y {
    public g(j jVar) {
        super(jVar, "/swan/reLaunch");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("ReLaunchAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String b = a.b(unitedSchemeEntity, LegoListActivityConfig.PARAMS);
        if (TextUtils.isEmpty(b)) {
            com.baidu.swan.apps.console.c.e("relaunch", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final com.baidu.swan.apps.w.e Ec = com.baidu.swan.apps.w.e.Ec();
        final com.baidu.swan.apps.core.c.e uz = Ec.uz();
        if (uz == null) {
            com.baidu.swan.apps.console.c.e("relaunch", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b ap = com.baidu.swan.apps.model.b.ap(b, Ec.DL());
        if (!aa.a(Ec.DK(), ap, true)) {
            com.baidu.swan.apps.console.c.e("relaunch", "page params error : pageParam=" + ap.axI);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a = a.a(unitedSchemeEntity, LegoListActivityConfig.PARAMS, "initData");
        if (!TextUtils.isEmpty(a) && ap != null && !TextUtils.isEmpty(ap.axI) && com.baidu.swan.apps.ae.b.IX() != null) {
            com.baidu.swan.apps.ae.b.IX().au(a, ap.axI);
        }
        final b.a x = com.baidu.swan.apps.core.h.b.x(Ec.DO());
        final String we = x.asF.we();
        if (DEBUG) {
            Log.d("ReLaunchAction", "webview idx: " + we);
        }
        final String optString = n.dk(unitedSchemeEntity.getParam(LegoListActivityConfig.PARAMS)).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("relaunch", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        Ec.showLoadingView();
        f.JL().a(bVar, ap.axI, we, new f.a() { // from class: com.baidu.swan.apps.scheme.actions.h.g.1
            @Override // com.baidu.swan.apps.scheme.actions.h.f.a
            public void eP(String str) {
                com.baidu.swan.apps.console.c.i("relaunch", "check pages success");
                Ec.uC();
                a.a(unitedSchemeEntity, callbackHandler, bVar, we, ap.axI, optString);
                g.this.b(x, ap, uz);
            }

            @Override // com.baidu.swan.apps.scheme.actions.h.f.a
            public void cG(int i) {
                com.baidu.swan.apps.console.c.e("relaunch", "check pages failed");
                Ec.uC();
                if (g.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).IK();
                }
                a.c(unitedSchemeEntity, callbackHandler, optString);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final com.baidu.swan.apps.core.c.e eVar) {
        if (DEBUG) {
            Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + aVar.asG);
        }
        com.baidu.swan.apps.core.h.b.a(aVar, new b.InterfaceC0134b() { // from class: com.baidu.swan.apps.scheme.actions.h.g.2
            @Override // com.baidu.swan.apps.core.h.b.InterfaceC0134b
            public void onReady() {
                if (g.DEBUG) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
                }
                a.a(aVar.asF, bVar);
                g.a(eVar, bVar);
                if (g.DEBUG) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady end.");
                }
            }
        });
        if (DEBUG) {
            Log.d("ReLaunchAction", "tryToExecutePageRoute end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.baidu.swan.apps.core.c.e eVar, com.baidu.swan.apps.model.b bVar) {
        eVar.dY("reLaunch").A(0, 0).yY().a("normal", bVar).za();
    }
}
