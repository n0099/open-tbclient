package com.baidu.swan.apps.n;

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
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends z {
    private String aQL;

    public a(j jVar) {
        super(jVar, "/swan/getFormId");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            if (DEBUG) {
                Log.e("GetFormIdAction", "swanApp is null");
            }
            c.e("GetFormIdAction", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject c = c(unitedSchemeEntity, "params");
        if (c == null) {
            if (DEBUG) {
                Log.e("GetFormIdAction", "joParams is null");
            }
            c.e("GetFormIdAction", "joParams is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        }
        this.aQL = c.optString("cb");
        if (TextUtils.isEmpty(this.aQL)) {
            if (DEBUG) {
                Log.e("GetFormIdAction", "mCallBack is null");
            }
            c.e("GetFormIdAction", "mCallBack is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty callback");
            return false;
        }
        String appKey = bVar.getAppKey();
        if (TextUtils.isEmpty(appKey)) {
            if (DEBUG) {
                Log.e("GetFormIdAction", "appKey is null");
            }
            c.e("GetFormIdAction", "appKey is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty appkey");
            return false;
        } else if (!(context instanceof Activity)) {
            if (DEBUG) {
                Log.e("GetFormIdAction", "context is not instanceof Activity");
            }
            c.e("GetFormIdAction", "context is not instanceof Activity");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            return false;
        } else {
            com.baidu.swan.apps.u.a.JL().a(appKey, new b() { // from class: com.baidu.swan.apps.n.a.1
                @Override // com.baidu.swan.apps.ad.a
                public void onFail(String str) {
                    callbackHandler.handleSchemeDispatchCallback(a.this.aQL, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString());
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
