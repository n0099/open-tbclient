package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {
    private final String bZK;
    private final String bZZ;
    private final boolean caa;

    public k(@NonNull String str, @NonNull JSONObject jSONObject, String str2) {
        this.bZZ = str;
        this.bZK = str2;
        this.caa = jSONObject.optBoolean("useEvent");
    }

    public void a(com.baidu.swan.apps.api.a.d dVar) {
        if (this.caa) {
            dVar.a(this.bZK, new com.baidu.swan.apps.api.c.b(0));
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (this.caa) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.bZK);
        }
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, JSONObject jSONObject) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(0, jSONObject);
        if (this.caa) {
            com.baidu.swan.apps.v.f.asJ().b(new com.baidu.swan.apps.event.a.f(this.bZZ, bVar));
        } else {
            dVar.a(this.bZK, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (this.caa) {
            com.baidu.swan.apps.v.f.asJ().b(new com.baidu.swan.apps.event.a.f(this.bZZ, new com.baidu.swan.apps.api.c.b(0, jSONObject)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.bZK);
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, String str) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(1001, str);
        if (this.caa) {
            com.baidu.swan.apps.v.f.asJ().b(new com.baidu.swan.apps.event.a.f(this.bZZ, bVar));
        } else {
            dVar.a(this.bZK, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        if (this.caa) {
            com.baidu.swan.apps.v.f.asJ().b(new com.baidu.swan.apps.event.a.f(this.bZZ, new com.baidu.swan.apps.api.c.b(1001, str)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.bZK);
    }
}
