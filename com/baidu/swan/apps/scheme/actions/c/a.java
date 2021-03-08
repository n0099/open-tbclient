package com.baidu.swan.apps.scheme.actions.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ao.v;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends aa {
    public static final String dIy = SchemeConfig.getSchemeHead() + "://v19/swan/launch?params={\"appid\":\"";
    public static final String dIz = SchemeConfig.getSchemeHead() + "://swangame/%s";

    /* renamed from: com.baidu.swan.apps.scheme.actions.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0462a {
        void bU(JSONObject jSONObject);
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/getHistory");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
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
        final String optString = v.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            c.e("history", "none cb");
            if (DEBUG) {
                Log.d("SwanAppAction", "getSwanHistory --- cb is empty");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        eVar.aIZ().b(context, "mapp_i_get_history", new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.scheme.actions.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void N(h<b.d> hVar) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str) {
        c.i("history", "start get history");
        com.baidu.swan.apps.database.a.b.a(new InterfaceC0462a() { // from class: com.baidu.swan.apps.scheme.actions.c.a.2
            @Override // com.baidu.swan.apps.scheme.actions.c.a.InterfaceC0462a
            public void bU(JSONObject jSONObject) {
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
