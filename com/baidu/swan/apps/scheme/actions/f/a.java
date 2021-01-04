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
/* loaded from: classes9.dex */
public final class a extends aa implements b.a {
    private CallbackHandler det;

    public a(j jVar) {
        super(jVar, "/swanAPI/getLocation");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar) {
        if (DEBUG) {
            Log.d("GetLocationAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        this.det = callbackHandler;
        if (eVar == null) {
            c.e("location", "swan app is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final a.C0393a lD = a.C0393a.lD(unitedSchemeEntity.getParam("params"));
        if (lD == null || !lD.isValid()) {
            c.e("location", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (TextUtils.isEmpty(lD.cJu)) {
            c.e("location", "empty cb");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        } else {
            eVar.aMw().b(context, "mapp_location", new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.scheme.actions.f.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void L(h<b.d> hVar) {
                    a.this.a(hVar, callbackHandler, lD, eVar.ank());
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h<b.d> hVar, CallbackHandler callbackHandler, a.C0393a c0393a, boolean z) {
        c.i("GetLocationAction", "authorized result is " + hVar);
        if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
            com.baidu.swan.apps.api.module.f.b.any().a(c0393a, this, z);
            return;
        }
        int errorCode = hVar.getErrorCode();
        callbackHandler.handleSchemeDispatchCallback(c0393a.cJu, UnitedSchemeUtility.wrapCallbackParams(errorCode, com.baidu.swan.apps.setting.oauth.c.hR(errorCode)).toString());
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(a.C0393a c0393a, b bVar) {
        if (DEBUG) {
            Log.d("GetLocationAction", "convert info : " + bVar.toJSON());
        }
        if (this.det != null) {
            this.det.handleSchemeDispatchCallback(c0393a.cJu, UnitedSchemeUtility.wrapCallbackParams(bVar.toJSON(), 0).toString());
        }
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(a.C0393a c0393a, int i) {
        if (this.det != null) {
            c.e("GetLocationAction", "request location error code : " + i);
            this.det.handleSchemeDispatchCallback(c0393a.cJu, UnitedSchemeUtility.wrapCallbackParams(i).toString());
        }
    }

    @Override // com.baidu.swan.apps.api.module.f.b.a
    public void a(a.C0393a c0393a, String str) {
        if (this.det != null) {
            this.det.handleSchemeDispatchCallback(c0393a.cJu, UnitedSchemeUtility.wrapCallbackParams(10005, "system deny").toString());
        }
    }
}
