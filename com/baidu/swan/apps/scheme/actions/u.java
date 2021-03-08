package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes8.dex */
public class u extends aa {
    public u(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/postMessage");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        com.baidu.swan.apps.performance.h.B("postMessage", "PostMsgAction handle");
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        com.baidu.swan.apps.event.a.d nS = com.baidu.swan.apps.event.a.d.nS(str);
        if (nS == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        com.baidu.swan.apps.performance.h.B("postMessage", "PostEvent start");
        com.baidu.swan.apps.v.f.aAo().a(nS, true);
        com.baidu.swan.apps.performance.h.B("postMessage", "PostEvent end.");
        return true;
    }
}
