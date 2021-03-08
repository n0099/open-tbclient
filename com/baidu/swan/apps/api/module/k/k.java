package com.baidu.swan.apps.api.module.k;

import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class k {
    private final String cJE;
    private final String cJT;
    private final boolean cJU;

    public k(@NonNull String str, @NonNull JSONObject jSONObject, String str2) {
        this.cJT = str;
        this.cJE = str2;
        this.cJU = jSONObject.optBoolean("useEvent");
    }

    public void a(com.baidu.swan.apps.api.a.d dVar) {
        if (this.cJU) {
            dVar.a(this.cJE, new com.baidu.swan.apps.api.c.b(0));
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (this.cJU) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.cJE);
        }
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, JSONObject jSONObject) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(0, jSONObject);
        if (this.cJU) {
            com.baidu.swan.apps.v.f.aAo().b(new com.baidu.swan.apps.event.a.f(this.cJT, bVar));
        } else {
            dVar.a(this.cJE, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (this.cJU) {
            com.baidu.swan.apps.v.f.aAo().b(new com.baidu.swan.apps.event.a.f(this.cJT, new com.baidu.swan.apps.api.c.b(0, jSONObject)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.cJE);
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, String str) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(1001, str);
        if (this.cJU) {
            com.baidu.swan.apps.v.f.aAo().b(new com.baidu.swan.apps.event.a.f(this.cJT, bVar));
        } else {
            dVar.a(this.cJE, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        if (this.cJU) {
            com.baidu.swan.apps.v.f.aAo().b(new com.baidu.swan.apps.event.a.f(this.cJT, new com.baidu.swan.apps.api.c.b(1001, str)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.cJE);
    }
}
