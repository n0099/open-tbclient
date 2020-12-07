package com.baidu.swan.apps.scheme.actions.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.module.f.a;
import com.baidu.swan.apps.api.module.f.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
/* loaded from: classes25.dex */
public final class a extends aa implements b.a {
    private CallbackHandler cZx;

    public a(j jVar) {
        super(jVar, "/swanAPI/getLocation");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar) {
        if (DEBUG) {
            Log.d("GetLocationAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        this.cZx = callbackHandler;
        if (eVar == null) {
            c.e("location", "swan app is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final a.C0401a lK = a.C0401a.lK(unitedSchemeEntity.getParam("params"));
        if (lK == null || !lK.isValid()) {
            c.e("location", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (TextUtils.isEmpty(lK.cEE)) {
            c.e("location", "empty cb");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        } else {
            eVar.aKg().b(context, "mapp_location", new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.scheme.actions.f.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(h<b.d> hVar) {
                    a.this.a(hVar, callbackHandler, lK, eVar.ama());
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h<b.d> hVar, CallbackHandler callbackHandler, a.C0401a c0401a, boolean z) {
        c.i("GetLocationAction", "authorized result is " + hVar);
        if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
            com.baidu.swan.apps.api.module.f.b.amo().a(c0401a, this, z);
            return;
        }
        int errorCode = hVar.getErrorCode();
        callbackHandler.handleSchemeDispatchCallback(c0401a.cEE, UnitedSchemeUtility.wrapCallbackParams(errorCode, com.baidu.swan.apps.setting.oauth.c.hX(errorCode)).toString());
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(a.C0401a c0401a, b bVar) {
        if (DEBUG) {
            Log.d("GetLocationAction", "convert info : " + bVar.toJSON());
        }
        if (this.cZx != null) {
            this.cZx.handleSchemeDispatchCallback(c0401a.cEE, UnitedSchemeUtility.wrapCallbackParams(bVar.toJSON(), 0).toString());
        }
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(a.C0401a c0401a, int i) {
        if (this.cZx != null) {
            c.e("GetLocationAction", "request location error code : " + i);
            this.cZx.handleSchemeDispatchCallback(c0401a.cEE, UnitedSchemeUtility.wrapCallbackParams(i).toString());
        }
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(a.C0401a c0401a, String str) {
        if (this.cZx != null) {
            this.cZx.handleSchemeDispatchCallback(c0401a.cEE, UnitedSchemeUtility.wrapCallbackParams(10005, "system deny").toString());
        }
    }
}
