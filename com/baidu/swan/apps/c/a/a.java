package com.baidu.swan.apps.c.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends z {
    private String mCallback;

    public a(j jVar) {
        super(jVar, "/swan/chooseAddress");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            c.i("ChooseAddress", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        this.mCallback = dd(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(this.mCallback)) {
            c.i("ChooseAddress", "cb is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        bVar.Mh().a((Activity) context, "mapp_choose_address", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.swan.apps.c.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: b */
            public void D(Boolean bool) {
                if (bool.booleanValue()) {
                    a.this.b(context, unitedSchemeEntity, callbackHandler, bVar);
                    return;
                }
                c.i("ChooseAddress", "Permission denied");
                callbackHandler.handleSchemeDispatchCallback(a.this.mCallback, UnitedSchemeUtility.wrapCallbackParams(1001, "Permission denied").toString());
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private JSONObject dd(String str) {
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
    public void b(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        com.baidu.swan.apps.u.a.Eq().a(context, bVar.id, bVar.getAppKey(), new b() { // from class: com.baidu.swan.apps.c.a.a.2
            @Override // com.baidu.swan.apps.c.a.b
            public void r(JSONObject jSONObject) {
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), a.this.mCallback);
            }

            @Override // com.baidu.swan.apps.c.a.b
            public void bO(int i) {
                if (i == 1) {
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1002, "用户取消操作").toString(), a.this.mCallback);
                } else {
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "choose failed").toString(), a.this.mCallback);
                }
            }
        });
    }
}
