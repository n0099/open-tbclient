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
public class h extends y {
    public h(j jVar) {
        super(jVar, "/swan/redirectTo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
        }
        String b = a.b(unitedSchemeEntity, LegoListActivityConfig.PARAMS);
        if (TextUtils.isEmpty(b)) {
            com.baidu.swan.apps.console.c.e("redirect", "url is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final com.baidu.swan.apps.w.e Ec = com.baidu.swan.apps.w.e.Ec();
        final com.baidu.swan.apps.core.c.e uz = Ec.uz();
        if (uz == null) {
            com.baidu.swan.apps.console.c.e("redirect", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b ap = com.baidu.swan.apps.model.b.ap(b, Ec.DL());
        if (!aa.a(Ec.DK(), ap, false)) {
            com.baidu.swan.apps.console.c.e("redirect", "page params error : pageParam=" + ap.axI);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String str = unitedSchemeEntity.getParams().get("initData");
        if (!TextUtils.isEmpty(str) && ap != null && !TextUtils.isEmpty(ap.axI) && com.baidu.swan.apps.ae.b.IX() != null) {
            com.baidu.swan.apps.ae.b.IX().au(str, ap.axI);
        }
        if (DEBUG) {
            Log.d("redirectTo", "PreloadSlaveManager start.");
        }
        final b.a x = com.baidu.swan.apps.core.h.b.x(Ec.DO());
        final String we = x.asF.we();
        if (DEBUG) {
            Log.d("redirectTo", "webview id: " + we);
        }
        final String optString = n.dk(unitedSchemeEntity.getParam(LegoListActivityConfig.PARAMS)).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("redirect", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        Ec.showLoadingView();
        f.JL().a(bVar, ap.axI, we, new f.a() { // from class: com.baidu.swan.apps.scheme.actions.h.h.1
            @Override // com.baidu.swan.apps.scheme.actions.h.f.a
            public void eP(String str2) {
                com.baidu.swan.apps.console.c.i("redirect", "check pages success");
                Ec.uC();
                a.a(unitedSchemeEntity, callbackHandler, bVar, we, ap.axI, optString);
                h.this.b(x, ap, uz);
            }

            @Override // com.baidu.swan.apps.scheme.actions.h.f.a
            public void cG(int i) {
                com.baidu.swan.apps.console.c.e("redirect", "check pages failed");
                Ec.uC();
                if (h.DEBUG) {
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
            Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + aVar.asG);
        }
        com.baidu.swan.apps.core.h.b.a(aVar, new b.InterfaceC0134b() { // from class: com.baidu.swan.apps.scheme.actions.h.h.2
            @Override // com.baidu.swan.apps.core.h.b.InterfaceC0134b
            public void onReady() {
                if (h.DEBUG) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                a.a(aVar.asF, bVar);
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
        eVar.dY("redirectTo").A(0, 0).a("normal", bVar).ch(eVar.yR() - 2).za();
    }
}
