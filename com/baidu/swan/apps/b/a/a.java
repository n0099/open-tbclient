package com.baidu.swan.apps.b.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends aa {
    private String mCallback;

    public a(j jVar) {
        super(jVar, "/swanAPI/chooseAddress");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar) {
        if (eVar == null) {
            c.i("ChooseAddress", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        } else if (eVar.TU()) {
            if (DEBUG) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject parseString = parseString(unitedSchemeEntity.getParam("params"));
            this.mCallback = parseString.optString("cb");
            if (TextUtils.isEmpty(this.mCallback)) {
                c.i("ChooseAddress", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            eVar.aoR().a(context, "mapp_choose_address", com.baidu.swan.apps.setting.oauth.c.bi(parseString), new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.b.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, a.this.mCallback);
                    } else {
                        a.this.b(context, unitedSchemeEntity, callbackHandler, eVar);
                    }
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    private JSONObject parseString(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.w("SwanAppAction", "JSONObject parsed error!!", e);
            }
            return new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, e eVar) {
        com.baidu.swan.apps.u.a.aeX().a(context, eVar.id, eVar.getAppKey(), new b() { // from class: com.baidu.swan.apps.b.a.a.2
            @Override // com.baidu.swan.apps.b.a.b
            public void ab(JSONObject jSONObject) {
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), a.this.mCallback);
            }

            @Override // com.baidu.swan.apps.b.a.b
            public void ei(int i) {
                if (i == 1) {
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1002, "user cancel this operation").toString(), a.this.mCallback);
                } else {
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "close failed").toString(), a.this.mCallback);
                }
            }
        });
    }
}
