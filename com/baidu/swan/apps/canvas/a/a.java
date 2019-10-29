package com.baidu.swan.apps.canvas.a;

import android.widget.AbsoluteLayout;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
abstract class a extends z {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(j jVar, String str) {
        super(jVar, str);
    }

    public com.baidu.swan.apps.canvas.c.a c(UnitedSchemeEntity unitedSchemeEntity) {
        return new com.baidu.swan.apps.canvas.c.a(unitedSchemeEntity.getParams().get("params"));
    }

    public AbsoluteLayout a(UnitedSchemeEntity unitedSchemeEntity, String str) {
        com.baidu.swan.apps.b.c.e eH = com.baidu.swan.apps.w.e.LD().eH(str);
        if (eH == null) {
            unitedSchemeEntity.result = cM(1001);
            return null;
        }
        com.baidu.swan.apps.b.c.d Cr = eH.Cr();
        if (Cr == null) {
            unitedSchemeEntity.result = cM(1001);
            return null;
        }
        return Cr.getCurrentWebView();
    }

    public JSONObject cM(int i) {
        return UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, z ? 0 : 1001);
    }
}
