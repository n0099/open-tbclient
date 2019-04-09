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
public class h extends y {
    public h(j jVar) {
        super(jVar, "/swan/redirectTo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
        }
        String b = a.b(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(b)) {
            com.baidu.swan.apps.console.c.e("redirect", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final com.baidu.swan.apps.w.e Ea = com.baidu.swan.apps.w.e.Ea();
        final com.baidu.swan.apps.core.c.e uy = Ea.uy();
        if (uy == null) {
            com.baidu.swan.apps.console.c.e("redirect", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b ap = com.baidu.swan.apps.model.b.ap(b, Ea.DJ());
        if (!aa.a(Ea.DI(), ap, false)) {
            com.baidu.swan.apps.console.c.e("redirect", "page params error : pageParam=" + ap.axM);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String str = unitedSchemeEntity.getParams().get("initData");
        if (!TextUtils.isEmpty(str) && ap != null && !TextUtils.isEmpty(ap.axM) && com.baidu.swan.apps.ae.b.IV() != null) {
            com.baidu.swan.apps.ae.b.IV().au(str, ap.axM);
        }
        if (DEBUG) {
            Log.d("redirectTo", "PreloadSlaveManager start.");
        }
        final b.a x = com.baidu.swan.apps.core.h.b.x(Ea.DM());
        final String wd = x.asK.wd();
        if (DEBUG) {
            Log.d("redirectTo", "webview id: " + wd);
        }
        final String optString = n.dm(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("redirect", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        Ea.showLoadingView();
        f.JJ().a(bVar, ap.axM, wd, new f.a() { // from class: com.baidu.swan.apps.scheme.actions.h.h.1
            @Override // com.baidu.swan.apps.scheme.actions.h.f.a
            public void eQ(String str2) {
                com.baidu.swan.apps.console.c.i("redirect", "check pages success");
                Ea.uB();
                a.a(unitedSchemeEntity, callbackHandler, bVar, wd, ap.axM, optString);
                h.this.b(x, ap, uy);
            }

            @Override // com.baidu.swan.apps.scheme.actions.h.f.a
            public void cF(int i) {
                com.baidu.swan.apps.console.c.e("redirect", "check pages failed");
                Ea.uB();
                if (h.DEBUG) {
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
            Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + aVar.asL);
        }
        com.baidu.swan.apps.core.h.b.a(aVar, new b.InterfaceC0134b() { // from class: com.baidu.swan.apps.scheme.actions.h.h.2
            @Override // com.baidu.swan.apps.core.h.b.InterfaceC0134b
            public void onReady() {
                if (h.DEBUG) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                a.a(aVar.asK, bVar);
                h.c(eVar, bVar);
                if (h.DEBUG) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        });
        if (DEBUG) {
            Log.d("redirectTo", "tryToExecutePageRoute end.");
        }
    }

    public static void c(com.baidu.swan.apps.core.c.e eVar, com.baidu.swan.apps.model.b bVar) {
        eVar.ea("redirectTo").A(0, 0).a("normal", bVar).cg(eVar.yQ() - 2).yZ();
    }
}
