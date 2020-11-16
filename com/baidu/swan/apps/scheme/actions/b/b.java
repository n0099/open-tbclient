package com.baidu.swan.apps.scheme.actions.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ap.v;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class b extends aa {
    protected String dtX;
    protected boolean dtY;

    protected abstract void b(com.baidu.swan.apps.runtime.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str);

    protected abstract boolean b(com.baidu.swan.apps.runtime.e eVar, UnitedSchemeEntity unitedSchemeEntity);

    public b(j jVar, String str) {
        super(jVar, str);
        this.dtX = null;
        this.dtY = false;
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
        JSONObject parseString = v.parseString(unitedSchemeEntity.getParam("params"));
        final String optString = parseString.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("favorite", "none cb");
            if (DEBUG) {
                Log.d("SwanAppAction", "getSwanHistory --- cb is empty");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        this.dtY = parseString.optBoolean("isFavorButton", false);
        if (!b(eVar, unitedSchemeEntity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params error");
            return false;
        }
        String optString2 = parseString.optString("slaveId");
        String azl = com.baidu.swan.apps.v.f.azg().azl();
        if (TextUtils.equals(optString2, com.baidu.swan.apps.v.f.azg().aod()) && (TextUtils.equals(azl, "pages/swan-news-showcase/index") || TextUtils.equals(azl, "pages/swan-operate-news/index"))) {
            b(eVar, unitedSchemeEntity, callbackHandler, optString);
        } else {
            eVar.aGY().b(context, this.dtY ? "scope_favorite_button" : "mapp_favorite", new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.scheme.actions.b.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, optString);
                    } else {
                        b.this.b(eVar, unitedSchemeEntity, callbackHandler, optString);
                    }
                }
            });
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
