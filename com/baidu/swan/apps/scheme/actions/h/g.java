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
public class g extends y {
    public g(j jVar) {
        super(jVar, "/swan/reLaunch");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("ReLaunchAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        String b = a.b(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(b)) {
            com.baidu.swan.apps.console.c.e("relaunch", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final com.baidu.swan.apps.w.e Ea = com.baidu.swan.apps.w.e.Ea();
        final com.baidu.swan.apps.core.c.e uy = Ea.uy();
        if (uy == null) {
            com.baidu.swan.apps.console.c.e("relaunch", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b ap = com.baidu.swan.apps.model.b.ap(b, Ea.DJ());
        if (!aa.a(Ea.DI(), ap, true)) {
            com.baidu.swan.apps.console.c.e("relaunch", "page params error : pageParam=" + ap.axL);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a = a.a(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(a) && ap != null && !TextUtils.isEmpty(ap.axL) && com.baidu.swan.apps.ae.b.IV() != null) {
            com.baidu.swan.apps.ae.b.IV().au(a, ap.axL);
        }
        final b.a x = com.baidu.swan.apps.core.h.b.x(Ea.DM());
        final String wd = x.asJ.wd();
        if (DEBUG) {
            Log.d("ReLaunchAction", "webview idx: " + wd);
        }
        final String optString = n.dm(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("relaunch", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        Ea.showLoadingView();
        f.JJ().a(bVar, ap.axL, wd, new f.a() { // from class: com.baidu.swan.apps.scheme.actions.h.g.1
            @Override // com.baidu.swan.apps.scheme.actions.h.f.a
            public void eQ(String str) {
                com.baidu.swan.apps.console.c.i("relaunch", "check pages success");
                Ea.uB();
                a.a(unitedSchemeEntity, callbackHandler, bVar, wd, ap.axL, optString);
                g.this.b(x, ap, uy);
            }

            @Override // com.baidu.swan.apps.scheme.actions.h.f.a
            public void cF(int i) {
                com.baidu.swan.apps.console.c.e("relaunch", "check pages failed");
                Ea.uB();
                if (g.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).II();
                }
                a.c(unitedSchemeEntity, callbackHandler, optString);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final com.baidu.swan.apps.core.c.e eVar) {
        if (DEBUG) {
            Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + aVar.asK);
        }
        com.baidu.swan.apps.core.h.b.a(aVar, new b.InterfaceC0134b() { // from class: com.baidu.swan.apps.scheme.actions.h.g.2
            @Override // com.baidu.swan.apps.core.h.b.InterfaceC0134b
            public void onReady() {
                if (g.DEBUG) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
                }
                a.a(aVar.asJ, bVar);
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
        eVar.ea("reLaunch").A(0, 0).yX().a("normal", bVar).yZ();
    }
}
