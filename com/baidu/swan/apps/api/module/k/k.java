package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class k {
    private final String cFF;
    private final String cFU;
    private final boolean cFV;

    public k(@NonNull String str, @NonNull JSONObject jSONObject, String str2) {
        this.cFU = str;
        this.cFF = str2;
        this.cFV = jSONObject.optBoolean("useEvent");
    }

    public void a(com.baidu.swan.apps.api.a.d dVar) {
        if (this.cFV) {
            dVar.a(this.cFF, new com.baidu.swan.apps.api.c.b(0));
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (this.cFV) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.cFF);
        }
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, JSONObject jSONObject) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(0, jSONObject);
        if (this.cFV) {
            com.baidu.swan.apps.v.f.aCp().b(new com.baidu.swan.apps.event.a.f(this.cFU, bVar));
        } else {
            dVar.a(this.cFF, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (this.cFV) {
            com.baidu.swan.apps.v.f.aCp().b(new com.baidu.swan.apps.event.a.f(this.cFU, new com.baidu.swan.apps.api.c.b(0, jSONObject)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.cFF);
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, String str) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(1001, str);
        if (this.cFV) {
            com.baidu.swan.apps.v.f.aCp().b(new com.baidu.swan.apps.event.a.f(this.cFU, bVar));
        } else {
            dVar.a(this.cFF, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        if (this.cFV) {
            com.baidu.swan.apps.v.f.aCp().b(new com.baidu.swan.apps.event.a.f(this.cFU, new com.baidu.swan.apps.api.c.b(1001, str)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.cFF);
    }
}
