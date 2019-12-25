package com.baidu.swan.apps.ao.e.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends ab {
    public a(j jVar) {
        super(jVar, "/swanAPI/brightness");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("Brightness", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        Activity activity;
        JSONObject jSONObject;
        boolean z;
        float f = -1.0f;
        if (DEBUG) {
            Log.d("Brightness", "handleSubAction: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (DEBUG) {
            Log.i("Brightness", "handleSubAction params: " + unitedSchemeEntity.getParam("params"));
        }
        if (!(context instanceof Activity)) {
            activity = null;
        } else {
            activity = (Activity) context;
        }
        if (activity == null) {
            c.e("brightness", "activity is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        int i = 1001;
        char c = 65535;
        switch (str.hashCode()) {
            case -1634890823:
                if (str.equals("/swanAPI/brightness/keepScreenOn")) {
                    c = 2;
                    break;
                }
                break;
            case 1913219981:
                if (str.equals("/swanAPI/brightness/get")) {
                    c = 1;
                    break;
                }
                break;
            case 1913231513:
                if (str.equals("/swanAPI/brightness/set")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (optParamsAsJo == null) {
                    c.e("brightness", "paramsJson is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString = optParamsAsJo.optString("value");
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        f = Float.parseFloat(optString);
                    } catch (Exception e) {
                    }
                }
                if (f < 0.0f || f > 1.0f) {
                    i = 202;
                    jSONObject = null;
                    z = false;
                    break;
                } else {
                    com.baidu.swan.apps.ao.e.b.a.ade().b(activity, f);
                    jSONObject = null;
                    z = true;
                    break;
                }
                break;
            case 1:
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("value", com.baidu.swan.apps.ao.e.b.a.ade().Q(activity));
                    z = true;
                    break;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    z = true;
                    break;
                }
            case 2:
                if (optParamsAsJo == null) {
                    c.e("brightness", "paramsJson is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                try {
                    com.baidu.swan.apps.ao.e.b.a.ade().e(activity, optParamsAsJo.getBoolean("keepScreenOn"));
                    jSONObject = null;
                    z = true;
                    break;
                } catch (JSONException e3) {
                    i = 202;
                    jSONObject = null;
                    z = false;
                    break;
                }
            default:
                jSONObject = null;
                z = false;
                break;
        }
        if (z) {
            if (jSONObject != null) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            }
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(i);
        }
        return z;
    }
}
