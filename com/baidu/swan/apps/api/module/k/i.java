package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class i {
    private final String bMG;
    private final boolean bMH;
    private final String bMu;

    public i(@NonNull String str, @NonNull JSONObject jSONObject, String str2) {
        this.bMG = str;
        this.bMu = str2;
        this.bMH = jSONObject.optBoolean("useEvent");
    }

    public void a(com.baidu.swan.apps.api.a.d dVar) {
        if (this.bMH) {
            dVar.a(this.bMu, new com.baidu.swan.apps.api.c.b(0));
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (this.bMH) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.bMu);
        }
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, JSONObject jSONObject) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(0, jSONObject);
        if (this.bMH) {
            com.baidu.swan.apps.w.f.ahV().a(new com.baidu.swan.apps.event.a.f(this.bMG, bVar));
        } else {
            dVar.a(this.bMu, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (this.bMH) {
            com.baidu.swan.apps.w.f.ahV().a(new com.baidu.swan.apps.event.a.f(this.bMG, new com.baidu.swan.apps.api.c.b(0, jSONObject)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.bMu);
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, String str) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(1001, str);
        if (this.bMH) {
            com.baidu.swan.apps.w.f.ahV().a(new com.baidu.swan.apps.event.a.f(this.bMG, bVar));
        } else {
            dVar.a(this.bMu, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        if (this.bMH) {
            com.baidu.swan.apps.w.f.ahV().a(new com.baidu.swan.apps.event.a.f(this.bMG, new com.baidu.swan.apps.api.c.b(1001, str)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.bMu);
    }
}
