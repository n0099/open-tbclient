package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class i {
    private final String bRi;
    private final String bRu;
    private final boolean bRv;

    public i(@NonNull String str, @NonNull JSONObject jSONObject, String str2) {
        this.bRu = str;
        this.bRi = str2;
        this.bRv = jSONObject.optBoolean("useEvent");
    }

    public void a(com.baidu.swan.apps.api.a.d dVar) {
        if (this.bRv) {
            dVar.a(this.bRi, new com.baidu.swan.apps.api.c.b(0));
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (this.bRv) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.bRi);
        }
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, JSONObject jSONObject) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(0, jSONObject);
        if (this.bRv) {
            com.baidu.swan.apps.w.f.ajb().a(new com.baidu.swan.apps.event.a.f(this.bRu, bVar));
        } else {
            dVar.a(this.bRi, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (this.bRv) {
            com.baidu.swan.apps.w.f.ajb().a(new com.baidu.swan.apps.event.a.f(this.bRu, new com.baidu.swan.apps.api.c.b(0, jSONObject)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.bRi);
    }

    public void a(com.baidu.swan.apps.api.a.d dVar, String str) {
        com.baidu.swan.apps.api.c.b bVar = new com.baidu.swan.apps.api.c.b(1001, str);
        if (this.bRv) {
            com.baidu.swan.apps.w.f.ajb().a(new com.baidu.swan.apps.event.a.f(this.bRu, bVar));
        } else {
            dVar.a(this.bRi, bVar);
        }
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        if (this.bRv) {
            com.baidu.swan.apps.w.f.ajb().a(new com.baidu.swan.apps.event.a.f(this.bRu, new com.baidu.swan.apps.api.c.b(1001, str)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.bRi);
    }
}
