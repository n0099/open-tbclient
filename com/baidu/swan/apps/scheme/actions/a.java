package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a extends y {
    @NonNull
    public abstract String JG();

    public abstract boolean b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.ae.b bVar);

    public abstract boolean c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.ae.b bVar);

    public abstract boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.ae.b bVar);

    public abstract boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.ae.b bVar);

    public a(com.baidu.swan.apps.scheme.j jVar, String str) {
        super(jVar, str);
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return false;
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.ae.b bVar) {
        boolean e;
        String gC = gC("insert");
        String gC2 = gC("update");
        String gC3 = gC("remove");
        if (TextUtils.equals(gC, str)) {
            e = b(context, unitedSchemeEntity, callbackHandler, str, bVar);
        } else if (TextUtils.equals(gC2, str)) {
            e = c(context, unitedSchemeEntity, callbackHandler, str, bVar);
        } else if (TextUtils.equals(gC3, str)) {
            e = d(context, unitedSchemeEntity, callbackHandler, str, bVar);
        } else {
            e = e(context, unitedSchemeEntity, callbackHandler, str, bVar);
        }
        com.baidu.swan.apps.console.c.i("AbsSwanAppWidget", "subAction = " + str + " ; handle result = " + e);
        return e || super.a(context, unitedSchemeEntity, callbackHandler, str, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject j(UnitedSchemeEntity unitedSchemeEntity) {
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

    private String gC(String str) {
        return JG() + "/" + str;
    }
}
