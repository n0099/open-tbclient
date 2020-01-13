package com.baidu.swan.apps.scheme.actions.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.as.s;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
/* loaded from: classes10.dex */
public abstract class b extends ab {
    protected String bNq;
    protected String mCallback;

    protected abstract void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str);

    protected abstract boolean o(UnitedSchemeEntity unitedSchemeEntity);

    public b(j jVar, String str) {
        super(jVar, str);
        this.mCallback = null;
        this.bNq = null;
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public final boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("favorite", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (DEBUG) {
                Log.d("SwanAppAction", "getSwanHistory --- illegal swanApp");
                return false;
            }
            return false;
        }
        this.mCallback = s.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(this.mCallback)) {
            com.baidu.swan.apps.console.c.e("favorite", "none cb");
            if (DEBUG) {
                Log.d("SwanAppAction", "getSwanHistory --- cb is empty");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (!(context instanceof Activity)) {
            com.baidu.swan.apps.console.c.e("favorite", "error context");
            if (DEBUG) {
                Log.d("SwanAppAction", "getSwanHistory --- the context is not an activity");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "the context is not an activity");
            return false;
        } else if (!o(unitedSchemeEntity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params error");
            return false;
        } else {
            eVar.aaz().b(context, "mapp_favorite", new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.scheme.actions.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void B(h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, b.this.mCallback);
                    } else {
                        b.this.a(unitedSchemeEntity, callbackHandler, b.this.mCallback);
                    }
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
