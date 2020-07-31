package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i {
    private final String bRZ;
    private final String bSl;
    private final boolean bSm;

    public i(@NonNull String str, @NonNull JSONObject jSONObject, String str2) {
        this.bSl = str;
        this.bRZ = str2;
        this.bSm = jSONObject.optBoolean("useEvent");
    }

    public void a(com.baidu.swan.apps.api.a.d dVar) {
        if (this.bSm) {
            dVar.a(this.bRZ, new com.baidu.swan.apps.api.c.b(0));
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (this.bSm) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.bRZ);
        }
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, JSONObject jSONObject) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(0, jSONObject);
        if (this.bSm) {
            com.baidu.swan.apps.v.f.akr().a(new com.baidu.swan.apps.event.a.f(this.bSl, bVar));
        } else {
            dVar.a(this.bRZ, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (this.bSm) {
            com.baidu.swan.apps.v.f.akr().a(new com.baidu.swan.apps.event.a.f(this.bSl, new com.baidu.swan.apps.api.c.b(0, jSONObject)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.bRZ);
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, String str) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(1001, str);
        if (this.bSm) {
            com.baidu.swan.apps.v.f.akr().a(new com.baidu.swan.apps.event.a.f(this.bSl, bVar));
        } else {
            dVar.a(this.bRZ, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        if (this.bSm) {
            com.baidu.swan.apps.v.f.akr().a(new com.baidu.swan.apps.event.a.f(this.bSl, new com.baidu.swan.apps.api.c.b(1001, str)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.bRZ);
    }
}
