package com.baidu.swan.apps.api.module.k;

import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class k {
    private final String cFJ;
    private final String cFY;
    private final boolean cFZ;

    public k(@NonNull String str, @NonNull JSONObject jSONObject, String str2) {
        this.cFY = str;
        this.cFJ = str2;
        this.cFZ = jSONObject.optBoolean("useEvent");
    }

    public void a(com.baidu.swan.apps.api.a.d dVar) {
        if (this.cFZ) {
            dVar.a(this.cFJ, new com.baidu.swan.apps.api.c.b(0));
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (this.cFZ) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.cFJ);
        }
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, JSONObject jSONObject) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(0, jSONObject);
        if (this.cFZ) {
            com.baidu.swan.apps.v.f.azN().b(new com.baidu.swan.apps.event.a.f(this.cFY, bVar));
        } else {
            dVar.a(this.cFJ, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (this.cFZ) {
            com.baidu.swan.apps.v.f.azN().b(new com.baidu.swan.apps.event.a.f(this.cFY, new com.baidu.swan.apps.api.c.b(0, jSONObject)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.cFJ);
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, String str) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(1001, str);
        if (this.cFZ) {
            com.baidu.swan.apps.v.f.azN().b(new com.baidu.swan.apps.event.a.f(this.cFY, bVar));
        } else {
            dVar.a(this.cFJ, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        if (this.cFZ) {
            com.baidu.swan.apps.v.f.azN().b(new com.baidu.swan.apps.event.a.f(this.cFY, new com.baidu.swan.apps.api.c.b(1001, str)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.cFJ);
    }
}
