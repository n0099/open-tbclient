package com.baidu.swan.apps.scheme.actions.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.as.s;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends ab {
    public static final String bRL = SchemeConfig.getSchemeHead() + "://v19/swan/launch?params={\"appid\":\"";
    public static final String bRM = SchemeConfig.getSchemeHead() + "://swangame/%s";

    /* renamed from: com.baidu.swan.apps.scheme.actions.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0286a {
        void aK(JSONObject jSONObject);
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/getHistory");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            c.e("history", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (DEBUG) {
                Log.d("SwanAppAction", "getSwanHistory --- illegal swanApp");
                return false;
            }
            return false;
        }
        final String optString = s.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            c.e("history", "none cb");
            if (DEBUG) {
                Log.d("SwanAppAction", "getSwanHistory --- cb is empty");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (!(context instanceof Activity)) {
            c.e("history", "error context");
            if (DEBUG) {
                Log.d("SwanAppAction", "getSwanHistory --- the context is not an activity");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "the context is not an activity");
            return false;
        } else {
            eVar.acS().b(context, "mapp_i_get_history", new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.scheme.actions.c.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void D(h<b.d> hVar) {
                    if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        a.this.b(unitedSchemeEntity, callbackHandler, optString);
                    } else {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, optString);
                    }
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str) {
        c.i("history", "start get history");
        com.baidu.swan.apps.database.a.b.a(new InterfaceC0286a() { // from class: com.baidu.swan.apps.scheme.actions.c.a.2
            @Override // com.baidu.swan.apps.scheme.actions.c.a.InterfaceC0286a
            public void aK(JSONObject jSONObject) {
                if (jSONObject == null || jSONObject.length() == 0) {
                    c.i("history", "none history");
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParamsWithEncode(null, 0).toString(), str);
                    return;
                }
                c.i("history", "get history :" + jSONObject.toString());
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), str);
            }
        });
    }
}
