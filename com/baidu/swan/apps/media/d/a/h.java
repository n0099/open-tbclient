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
        com.baidu.swan.apps.console.c.i("video", "remove, video id:" + cVar.aUO + " slave id: " + cVar.aXH);
        b(aVar, cVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    private void b(com.baidu.swan.apps.media.d.a aVar, com.baidu.swan.apps.media.d.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        com.baidu.swan.apps.view.container.a ji = com.baidu.swan.apps.view.container.c.c.ji(cVar.aXH);
        SwanAppNAViewContainer a = com.baidu.swan.apps.view.container.c.b.a(cVar, ji);
        if (ji != null && a != null) {
            com.baidu.swan.apps.view.container.c.c.b(a, ji);
            com.baidu.swan.apps.view.container.c.c.d(a, ji);
        }
        aVar.onDestroy();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
