package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ab extends aa {
    public ab(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/checkAppInstalled");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        JSONObject b2 = b(unitedSchemeEntity, "params");
        if (b2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
            com.baidu.swan.apps.console.c.i("SwanCheckAppInstalledAction", "params parse error");
            return false;
        }
        String optString = b2.optString("name");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parameter error");
            com.baidu.swan.apps.console.c.i("SwanCheckAppInstalledAction", "packageName empty");
            return false;
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(optString, 0);
        } catch (PackageManager.NameNotFoundException e) {
            com.baidu.swan.apps.console.c.e("SwanCheckAppInstalledAction", e.getMessage(), e);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (packageInfo != null) {
                jSONObject.put("hasApp", true);
                jSONObject.put("versionName", packageInfo.versionName);
                jSONObject.put("versionCode", packageInfo.versionCode);
            } else {
                jSONObject.put("hasApp", false);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0, "success"));
        } catch (JSONException e2) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage());
            com.baidu.swan.apps.console.c.e("SwanCheckAppInstalledAction", e2.getMessage(), e2);
        }
        return true;
    }
}
