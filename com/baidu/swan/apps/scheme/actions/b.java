package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class b extends aa {
    public abstract boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.runtime.e eVar);

    public abstract boolean b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.runtime.e eVar);

    public abstract boolean c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.runtime.e eVar);

    @NonNull
    public abstract String getModuleName();

    public b(com.baidu.swan.apps.scheme.j jVar, String str) {
        super(jVar, str);
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.runtime.e eVar) {
        boolean e;
        String qL = qL("insert");
        String qL2 = qL(IMTrack.DbBuilder.ACTION_UPDATE);
        String qL3 = qL("remove");
        if (TextUtils.equals(qL, str)) {
            e = a(context, unitedSchemeEntity, callbackHandler, str, eVar);
        } else if (TextUtils.equals(qL2, str)) {
            e = b(context, unitedSchemeEntity, callbackHandler, str, eVar);
        } else if (TextUtils.equals(qL3, str)) {
            e = c(context, unitedSchemeEntity, callbackHandler, str, eVar);
        } else {
            e = e(context, unitedSchemeEntity, callbackHandler, str, eVar);
        }
        com.baidu.swan.apps.console.c.d("AbsSwanAppWidget", "subAction = " + str + " ; handle result = " + e);
        return e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject n(UnitedSchemeEntity unitedSchemeEntity) {
        JSONObject jSONObject;
        if (unitedSchemeEntity == null) {
            com.baidu.swan.apps.console.c.e("AbsSwanAppWidget", "getParamsJSONObject entity is null");
            return null;
        }
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            com.baidu.swan.apps.console.c.e("AbsSwanAppWidget", "getParamsJSONObject paramsJson is empty");
            return null;
        }
        try {
            jSONObject = new JSONObject(param);
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("AbsSwanAppWidget", "getParamsJSONObject exception = " + e.getMessage());
            if (DEBUG) {
                e.printStackTrace();
            }
            jSONObject = null;
        }
        return jSONObject;
    }

    private String qL(String str) {
        return getModuleName() + "/" + str;
    }

    public boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.runtime.e eVar) {
        return super.d(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }
}
