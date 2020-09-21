package com.baidu.swan.apps.canvas.a;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes3.dex */
abstract class a extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(j jVar, String str) {
        super(jVar, str);
    }

    public com.baidu.swan.apps.canvas.b.a d(UnitedSchemeEntity unitedSchemeEntity) {
        return new com.baidu.swan.apps.canvas.b.a(unitedSchemeEntity.getParams().get("params"));
    }

    public JSONObject gK(int i) {
        return UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, z ? 0 : 1001);
    }
}
