package com.baidu.swan.apps.api.module.k;

import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class k {
    private final String cKK;
    private final boolean cKL;
    private final String cKv;

    public k(@NonNull String str, @NonNull JSONObject jSONObject, String str2) {
        this.cKK = str;
        this.cKv = str2;
        this.cKL = jSONObject.optBoolean("useEvent");
    }

    public void a(com.baidu.swan.apps.api.a.d dVar) {
        if (this.cKL) {
            dVar.a(this.cKv, new com.baidu.swan.apps.api.c.b(0));
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (this.cKL) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.cKv);
        }
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, JSONObject jSONObject) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(0, jSONObject);
        if (this.cKL) {
            com.baidu.swan.apps.v.f.aDH().b(new com.baidu.swan.apps.event.a.f(this.cKK, bVar));
        } else {
            dVar.a(this.cKv, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (this.cKL) {
            com.baidu.swan.apps.v.f.aDH().b(new com.baidu.swan.apps.event.a.f(this.cKK, new com.baidu.swan.apps.api.c.b(0, jSONObject)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.cKv);
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, String str) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(1001, str);
        if (this.cKL) {
            com.baidu.swan.apps.v.f.aDH().b(new com.baidu.swan.apps.event.a.f(this.cKK, bVar));
        } else {
            dVar.a(this.cKv, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        if (this.cKL) {
            com.baidu.swan.apps.v.f.aDH().b(new com.baidu.swan.apps.event.a.f(this.cKK, new com.baidu.swan.apps.api.c.b(1001, str)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.cKv);
    }
}
