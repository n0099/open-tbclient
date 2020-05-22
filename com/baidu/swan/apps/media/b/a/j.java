package com.baidu.swan.apps.media.b.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes11.dex */
public class j extends g {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public j(String str) {
        super(str);
    }

    @Override // com.baidu.swan.apps.media.b.a.g
    public boolean a(com.baidu.swan.apps.media.b.a aVar, com.baidu.swan.apps.media.b.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.console.c.i("video", "sendDanmu, video id:" + cVar.cjA + " slave id: " + cVar.bPG);
        a(aVar, cVar.cnO, unitedSchemeEntity, callbackHandler);
        return true;
    }

    private void a(com.baidu.swan.apps.media.b.a aVar, String str, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.kG(str);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
