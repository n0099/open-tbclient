package com.baidu.swan.apps.media.d.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
/* loaded from: classes2.dex */
public class h extends g {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public h(String str) {
        super(str);
    }

    @Override // com.baidu.swan.apps.media.d.a.g
    public boolean a(com.baidu.swan.apps.media.d.a aVar, com.baidu.swan.apps.media.d.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        com.baidu.swan.apps.console.c.i("video", "remove, video id:" + cVar.aAu + " slave id: " + cVar.aDm);
        b(aVar, cVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    private void b(com.baidu.swan.apps.media.d.a aVar, com.baidu.swan.apps.media.d.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        com.baidu.swan.apps.view.container.a ix = com.baidu.swan.apps.view.container.c.c.ix(cVar.aDm);
        SwanAppNAViewContainer a = com.baidu.swan.apps.view.container.c.b.a(cVar, ix);
        if (ix != null && a != null) {
            com.baidu.swan.apps.view.container.c.c.b(a, ix);
            com.baidu.swan.apps.view.container.c.c.d(a, ix);
        }
        aVar.onDestroy();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
