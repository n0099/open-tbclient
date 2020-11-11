package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class k {
    private final String cAM;
    private final boolean cAN;
    private final String cAx;

    public k(@NonNull String str, @NonNull JSONObject jSONObject, String str2) {
        this.cAM = str;
        this.cAx = str2;
        this.cAN = jSONObject.optBoolean("useEvent");
    }

    public void a(com.baidu.swan.apps.api.a.d dVar) {
        if (this.cAN) {
            dVar.a(this.cAx, new com.baidu.swan.apps.api.c.b(0));
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (this.cAN) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.cAx);
        }
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, JSONObject jSONObject) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(0, jSONObject);
        if (this.cAN) {
            com.baidu.swan.apps.v.f.azO().b(new com.baidu.swan.apps.event.a.f(this.cAM, bVar));
        } else {
            dVar.a(this.cAx, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (this.cAN) {
            com.baidu.swan.apps.v.f.azO().b(new com.baidu.swan.apps.event.a.f(this.cAM, new com.baidu.swan.apps.api.c.b(0, jSONObject)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.cAx);
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, String str) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(1001, str);
        if (this.cAN) {
            com.baidu.swan.apps.v.f.azO().b(new com.baidu.swan.apps.event.a.f(this.cAM, bVar));
        } else {
            dVar.a(this.cAx, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        if (this.cAN) {
            com.baidu.swan.apps.v.f.azO().b(new com.baidu.swan.apps.event.a.f(this.cAM, new com.baidu.swan.apps.api.c.b(1001, str)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.cAx);
    }
}
