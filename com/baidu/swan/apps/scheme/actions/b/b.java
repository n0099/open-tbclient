package com.baidu.swan.apps.scheme.actions.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.aq.t;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class b extends aa {
    protected String cCs;
    protected boolean cCt;
    protected String mCallback;

    protected abstract void b(com.baidu.swan.apps.runtime.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str);

    protected abstract boolean b(com.baidu.swan.apps.runtime.e eVar, UnitedSchemeEntity unitedSchemeEntity);

    public b(j jVar, String str) {
        super(jVar, str);
        this.mCallback = null;
        this.cCs = null;
        this.cCt = false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public final boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("favorite", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (DEBUG) {
                Log.d("SwanAppAction", "getSwanHistory --- illegal swanApp");
            }
            return false;
        }
        JSONObject parseString = t.parseString(unitedSchemeEntity.getParam("params"));
        this.mCallback = parseString.optString("cb");
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
        } else {
            this.cCt = parseString.optBoolean("isFavorButton", false);
            if (!b(eVar, unitedSchemeEntity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params error");
                return false;
            }
            eVar.aoR().b(context, this.cCt ? "scope_favorite_button" : "mapp_favorite", new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.scheme.actions.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, b.this.mCallback);
                    } else {
                        b.this.b(eVar, unitedSchemeEntity, callbackHandler, b.this.mCallback);
                    }
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
