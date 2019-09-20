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
public class h extends z {
    public h(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/reLaunch");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
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
        final com.baidu.swan.apps.w.e GJ = com.baidu.swan.apps.w.e.GJ();
        final com.baidu.swan.apps.core.d.e vN = GJ.vN();
        if (vN == null) {
            com.baidu.swan.apps.console.c.e("relaunch", "manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final com.baidu.swan.apps.model.b aq = com.baidu.swan.apps.model.b.aq(b, GJ.Gs());
        if (!ac.a(GJ.Gr(), aq, true)) {
            com.baidu.swan.apps.console.c.e("relaunch", "page params error : pageParam=" + aq.azQ);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String a = a.a(unitedSchemeEntity, "params", "initData");
        if (!TextUtils.isEmpty(a) && aq != null && !TextUtils.isEmpty(aq.azQ) && com.baidu.swan.apps.ae.b.Mh() != null) {
            com.baidu.swan.apps.ae.b.Mh().au(a, aq.azQ);
        }
        final b.a A = com.baidu.swan.apps.core.i.b.A(GJ.Gv());
        final String xz = A.atZ.xz();
        if (DEBUG) {
            Log.d("ReLaunchAction", "webview idx: " + xz);
        }
        final String optString = o.df(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("relaunch", "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        GJ.showLoadingView();
        g.Nb().a(bVar, aq.azQ, xz, new g.a() { // from class: com.baidu.swan.apps.scheme.actions.i.h.1
            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
            public void fh(String str) {
                com.baidu.swan.apps.console.c.i("relaunch", "check pages success");
                GJ.vQ();
                a.a(unitedSchemeEntity, callbackHandler, bVar, xz, aq.azQ, optString);
                h.this.b(A, aq, vN);
            }

            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
            public void cK(int i) {
                com.baidu.swan.apps.console.c.e("relaunch", "check pages failed");
                GJ.vQ();
                if (h.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).LU();
                }
                a.c(unitedSchemeEntity, callbackHandler, optString);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final com.baidu.swan.apps.core.d.e eVar) {
        if (DEBUG) {
            Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + aVar.aua);
        }
        com.baidu.swan.apps.core.i.b.a(aVar, new b.InterfaceC0148b() { // from class: com.baidu.swan.apps.scheme.actions.i.h.2
            @Override // com.baidu.swan.apps.core.i.b.InterfaceC0148b
            public void onReady() {
                if (h.DEBUG) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
                }
                a.a(aVar.atZ, bVar);
                h.a(eVar, bVar);
                if (h.DEBUG) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady end.");
                }
            }
        });
        if (DEBUG) {
            Log.d("ReLaunchAction", "tryToExecutePageRoute end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.baidu.swan.apps.core.d.e eVar, com.baidu.swan.apps.model.b bVar) {
        eVar.dU("reLaunch").B(0, 0).AF().a("normal", bVar).AH();
    }
}
