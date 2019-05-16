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
public class i extends z {
    public i(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/redirectTo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
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
        final com.baidu.swan.apps.w.e FV = com.baidu.swan.apps.w.e.FV();
        final com.baidu.swan.apps.core.d.e vi = FV.vi();
        if (vi == null) {
            com.baidu.swan.apps.console.c.e("redirect", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b aq = com.baidu.swan.apps.model.b.aq(b, FV.FE());
        if (!ac.a(FV.FD(), aq, false)) {
            com.baidu.swan.apps.console.c.e("redirect", "page params error : pageParam=" + aq.ayL);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String str = unitedSchemeEntity.getParams().get("initData");
        if (!TextUtils.isEmpty(str) && aq != null && !TextUtils.isEmpty(aq.ayL) && com.baidu.swan.apps.ae.b.Lq() != null) {
            com.baidu.swan.apps.ae.b.Lq().au(str, aq.ayL);
        }
        if (DEBUG) {
            Log.d("redirectTo", "PreloadSlaveManager start.");
        }
        final b.a x = com.baidu.swan.apps.core.i.b.x(FV.FH());
        final String wU = x.asY.wU();
        if (DEBUG) {
            Log.d("redirectTo", "webview id: " + wU);
        }
        final String optString = o.cZ(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("redirect", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        FV.showLoadingView();
        g.Mj().a(bVar, aq.ayL, wU, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.i.i.1
            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
            public void fb(String str2) {
                com.baidu.swan.apps.console.c.i("redirect", "check pages success");
                FV.vl();
                a.a(unitedSchemeEntity, callbackHandler, bVar, wU, aq.ayL, optString);
                i.this.b(x, aq, vi);
            }

            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
            public void cI(int i) {
                com.baidu.swan.apps.console.c.e("redirect", "check pages failed");
                FV.vl();
                if (i.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).Ld();
                }
                a.c(unitedSchemeEntity, callbackHandler, optString);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final com.baidu.swan.apps.core.d.e eVar) {
        if (DEBUG) {
            Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + aVar.asZ);
        }
        com.baidu.swan.apps.core.i.b.a(aVar, new b.InterfaceC0137b() { // from class: com.baidu.swan.apps.scheme.actions.i.i.2
            @Override // com.baidu.swan.apps.core.i.b.InterfaceC0137b
            public void onReady() {
                if (i.DEBUG) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                a.a(aVar.asY, bVar);
                i.c(eVar, bVar);
                if (i.DEBUG) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        });
        if (DEBUG) {
            Log.d("redirectTo", "tryToExecutePageRoute end.");
        }
    }

    public static void c(com.baidu.swan.apps.core.d.e eVar, com.baidu.swan.apps.model.b bVar) {
        eVar.dO("redirectTo").y(0, 0).a("normal", bVar).cg(eVar.zN() - 2).zW();
    }
}
