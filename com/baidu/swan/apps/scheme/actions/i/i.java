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
        final com.baidu.swan.apps.w.e GF = com.baidu.swan.apps.w.e.GF();
        final com.baidu.swan.apps.core.d.e vJ = GF.vJ();
        if (vJ == null) {
            com.baidu.swan.apps.console.c.e("redirect", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b aq = com.baidu.swan.apps.model.b.aq(b, GF.Go());
        if (!ac.a(GF.Gn(), aq, false)) {
            com.baidu.swan.apps.console.c.e("redirect", "page params error : pageParam=" + aq.azs);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String str = unitedSchemeEntity.getParams().get("initData");
        if (!TextUtils.isEmpty(str) && aq != null && !TextUtils.isEmpty(aq.azs) && com.baidu.swan.apps.ae.b.Md() != null) {
            com.baidu.swan.apps.ae.b.Md().au(str, aq.azs);
        }
        if (DEBUG) {
            Log.d("redirectTo", "PreloadSlaveManager start.");
        }
        final b.a A = com.baidu.swan.apps.core.i.b.A(GF.Gr());
        final String xv = A.atB.xv();
        if (DEBUG) {
            Log.d("redirectTo", "webview id: " + xv);
        }
        final String optString = o.dd(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("redirect", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        GF.showLoadingView();
        g.MX().a(bVar, aq.azs, xv, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.i.i.1
            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
            public void ff(String str2) {
                com.baidu.swan.apps.console.c.i("redirect", "check pages success");
                GF.vM();
                a.a(unitedSchemeEntity, callbackHandler, bVar, xv, aq.azs, optString);
                i.this.b(A, aq, vJ);
            }

            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
            public void cJ(int i) {
                com.baidu.swan.apps.console.c.e("redirect", "check pages failed");
                GF.vM();
                if (i.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).LQ();
                }
                a.c(unitedSchemeEntity, callbackHandler, optString);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final com.baidu.swan.apps.core.d.e eVar) {
        if (DEBUG) {
            Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + aVar.atC);
        }
        com.baidu.swan.apps.core.i.b.a(aVar, new b.InterfaceC0134b() { // from class: com.baidu.swan.apps.scheme.actions.i.i.2
            @Override // com.baidu.swan.apps.core.i.b.InterfaceC0134b
            public void onReady() {
                if (i.DEBUG) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                a.a(aVar.atB, bVar);
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
        eVar.dS("redirectTo").B(0, 0).a("normal", bVar).cg(eVar.Au() - 2).AD();
    }
}
