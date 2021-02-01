package com.baidu.swan.apps.api.module.k;

import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class k {
    private final String cIe;
    private final String cIt;
    private final boolean cIu;

    public k(@NonNull String str, @NonNull JSONObject jSONObject, String str2) {
        this.cIt = str;
        this.cIe = str2;
        this.cIu = jSONObject.optBoolean("useEvent");
    }

    public void a(com.baidu.swan.apps.api.a.d dVar) {
        if (this.cIu) {
            dVar.a(this.cIe, new com.baidu.swan.apps.api.c.b(0));
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (this.cIu) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.cIe);
        }
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, JSONObject jSONObject) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(0, jSONObject);
        if (this.cIu) {
            com.baidu.swan.apps.v.f.aAl().b(new com.baidu.swan.apps.event.a.f(this.cIt, bVar));
        } else {
            dVar.a(this.cIe, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (this.cIu) {
            com.baidu.swan.apps.v.f.aAl().b(new com.baidu.swan.apps.event.a.f(this.cIt, new com.baidu.swan.apps.api.c.b(0, jSONObject)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.cIe);
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, String str) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(1001, str);
        if (this.cIu) {
            com.baidu.swan.apps.v.f.aAl().b(new com.baidu.swan.apps.event.a.f(this.cIt, bVar));
        } else {
            dVar.a(this.cIe, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        if (this.cIu) {
            com.baidu.swan.apps.v.f.aAl().b(new com.baidu.swan.apps.event.a.f(this.cIt, new com.baidu.swan.apps.api.c.b(1001, str)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.cIe);
    }
}
