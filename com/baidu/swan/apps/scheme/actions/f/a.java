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
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
/* loaded from: classes11.dex */
public final class a extends ab implements b.a {
    private CallbackHandler bzI;

    public a(j jVar) {
        super(jVar, "/swanAPI/getLocation");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar) {
        if (DEBUG) {
            Log.d("GetLocationAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        this.bzI = callbackHandler;
        if (eVar == null) {
            c.e("location", "swan app is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final a.C0218a fC = a.C0218a.fC(unitedSchemeEntity.getParam("params"));
        if (fC == null || !fC.isValid()) {
            c.e("location", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (TextUtils.isEmpty(fC.bex)) {
            c.e("location", "empty cb");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        } else {
            eVar.acP().b(context, "mapp_location", new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.scheme.actions.f.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void D(h<b.d> hVar) {
                    a.this.a(hVar, callbackHandler, fC, eVar.JF());
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h<b.d> hVar, CallbackHandler callbackHandler, a.C0218a c0218a, boolean z) {
        c.i("GetLocationAction", "authorized result is " + hVar);
        if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
            com.baidu.swan.apps.api.module.f.b.JR().a(c0218a, this, z);
            return;
        }
        int errorCode = hVar.getErrorCode();
        callbackHandler.handleSchemeDispatchCallback(c0218a.bex, UnitedSchemeUtility.wrapCallbackParams(errorCode, com.baidu.swan.apps.setting.oauth.c.gn(errorCode)).toString());
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(a.C0218a c0218a, b bVar) {
        if (DEBUG) {
            Log.d("GetLocationAction", "convert info : " + bVar.toJSON());
        }
        if (this.bzI != null) {
            this.bzI.handleSchemeDispatchCallback(c0218a.bex, UnitedSchemeUtility.wrapCallbackParams(bVar.toJSON(), 0).toString());
        }
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(a.C0218a c0218a, int i) {
        if (this.bzI != null) {
            c.e("GetLocationAction", "request location error code : " + i);
            this.bzI.handleSchemeDispatchCallback(c0218a.bex, UnitedSchemeUtility.wrapCallbackParams(i).toString());
        }
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(a.C0218a c0218a, String str) {
        if (this.bzI != null) {
            this.bzI.handleSchemeDispatchCallback(c0218a.bex, UnitedSchemeUtility.wrapCallbackParams(10005, "system deny").toString());
        }
    }
}
