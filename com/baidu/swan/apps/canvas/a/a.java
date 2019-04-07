package com.baidu.swan.apps.canvas.a;

import android.widget.AbsoluteLayout;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
abstract class a extends y {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(j jVar, String str) {
        super(jVar, str);
    }

    public com.baidu.swan.apps.canvas.c.a c(UnitedSchemeEntity unitedSchemeEntity) {
        return new com.baidu.swan.apps.canvas.c.a(unitedSchemeEntity.getParams().get("params"));
    }

    public AbsoluteLayout a(UnitedSchemeEntity unitedSchemeEntity, String str) {
        com.baidu.swan.apps.b.c.e eg = com.baidu.swan.apps.w.e.Ea().eg(str);
        if (eg == null) {
            unitedSchemeEntity.result = bP(1001);
            return null;
        }
        com.baidu.swan.apps.b.c.d wb = eg.wb();
        if (wb == null) {
            unitedSchemeEntity.result = bP(1001);
            return null;
        }
        return wb.getCurrentWebView();
    }

    public JSONObject bP(int i) {
        return UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, z ? 0 : 1001);
    }
}
