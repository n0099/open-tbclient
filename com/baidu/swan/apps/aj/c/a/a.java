package com.baidu.swan.apps.aj.c.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends y {
    public a(j jVar) {
        super(jVar, "/swan/brightness");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b bVar) {
        if (DEBUG) {
            Log.d("Brightness", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, b bVar) {
        Activity activity;
        JSONObject jSONObject;
        boolean z;
        float f = -1.0f;
        if (DEBUG) {
            Log.d("Brightness", "handleSubAction: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (DEBUG) {
            Log.i("Brightness", "handleSubAction params: " + unitedSchemeEntity.getParam(LegoListActivityConfig.PARAMS));
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
            case -1130635193:
                if (str.equals("/swan/brightness/get")) {
                    c = 1;
                    break;
                }
                break;
            case -1130623661:
                if (str.equals("/swan/brightness/set")) {
                    c = 0;
                    break;
                }
                break;
            case -589707201:
                if (str.equals("/swan/brightness/keepScreenOn")) {
                    c = 2;
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
                String optString = optParamsAsJo.optString(UBC.CONTENT_KEY_VALUE);
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
                    com.baidu.swan.apps.aj.c.b.a.Lj().a(activity, f);
                    jSONObject = null;
                    z = true;
                    break;
                }
                break;
            case 1:
                jSONObject = new JSONObject();
                try {
                    jSONObject.put(UBC.CONTENT_KEY_VALUE, String.valueOf(com.baidu.swan.apps.aj.c.b.a.Lj().J(activity)));
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
                    com.baidu.swan.apps.aj.c.b.a.Lj().e(activity, optParamsAsJo.getBoolean("keepScreenOn"));
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
