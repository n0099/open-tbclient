package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class k {
    private final String bXJ;
    private final String bXY;
    private final boolean bXZ;

    public k(@NonNull String str, @NonNull JSONObject jSONObject, String str2) {
        this.bXY = str;
        this.bXJ = str2;
        this.bXZ = jSONObject.optBoolean("useEvent");
    }

    public void a(com.baidu.swan.apps.api.a.d dVar) {
        if (this.bXZ) {
            dVar.a(this.bXJ, new com.baidu.swan.apps.api.c.b(0));
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (this.bXZ) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.bXJ);
        }
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, JSONObject jSONObject) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(0, jSONObject);
        if (this.bXZ) {
            com.baidu.swan.apps.v.f.arY().b(new com.baidu.swan.apps.event.a.f(this.bXY, bVar));
        } else {
            dVar.a(this.bXJ, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (this.bXZ) {
            com.baidu.swan.apps.v.f.arY().b(new com.baidu.swan.apps.event.a.f(this.bXY, new com.baidu.swan.apps.api.c.b(0, jSONObject)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.bXJ);
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, String str) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(1001, str);
        if (this.bXZ) {
            com.baidu.swan.apps.v.f.arY().b(new com.baidu.swan.apps.event.a.f(this.bXY, bVar));
        } else {
            dVar.a(this.bXJ, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        if (this.bXZ) {
            com.baidu.swan.apps.v.f.arY().b(new com.baidu.swan.apps.event.a.f(this.bXY, new com.baidu.swan.apps.api.c.b(1001, str)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.bXJ);
    }
}
