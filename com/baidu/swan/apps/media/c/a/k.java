package com.baidu.swan.apps.media.c.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes11.dex */
public class k extends g {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public k(String str) {
        super(str);
    }

    @Override // com.baidu.swan.apps.media.c.a.g
    public boolean a(com.baidu.swan.apps.media.c.a aVar, com.baidu.swan.apps.media.c.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("video", "update, video id:" + cVar.bYS + " slave id: " + cVar.bGJ);
        c(aVar, cVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    private void c(com.baidu.swan.apps.media.c.a aVar, com.baidu.swan.apps.media.c.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.c(cVar);
        aVar.b(cVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
