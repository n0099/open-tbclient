package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends y {
    public h(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/getAppInfoSync");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("GetAppInfoSyncAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (bVar == null) {
            com.baidu.swan.apps.console.c.e("appInfo", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.v.b.b uB = bVar.uB();
        if (uB == null || !uB.isValid()) {
            com.baidu.swan.apps.console.c.e("appInfo", "launch info is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", uB.mAppId);
            jSONObject.put("appname", uB.axD);
            if (!TextUtils.isEmpty(uB.axE)) {
                jSONObject.put("iconUrl", uB.axE);
            }
            if (!TextUtils.isEmpty(uB.axH)) {
                jSONObject.put("appLaunchScheme", uB.axH);
            }
            String bJ = com.baidu.swan.apps.u.a.CD().bJ(context);
            jSONObject.put("cuid", bJ);
            jSONObject.put("mtjCuid", bJ);
            jSONObject.put("clkid", uB.axR);
            jSONObject.put(FaceBaseDTO.KEY_BUSINESS_SCENE, uB.axG);
            jSONObject.put("appId", uB.mAppId);
            Bundle bundle = uB.axQ;
            if (bundle != null) {
                String string = bundle.getString("extraData");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("extraData", new JSONObject(string));
                }
                if (!TextUtils.isEmpty(bundle.getString("srcAppId"))) {
                    jSONObject.put("srcAppId", bundle.getString("srcAppId"));
                }
                if (!TextUtils.isEmpty(bundle.getString("srcAppPage"))) {
                    jSONObject.put("srcAppPage", bundle.getString("srcAppPage"));
                }
                String str = NotificationCompat.CATEGORY_SYSTEM;
                SwanAppActivity DO = com.baidu.swan.apps.w.e.Ec().DO();
                if (DO != null) {
                    str = DO.uy();
                }
                if (TextUtils.isEmpty(str)) {
                    str = NotificationCompat.CATEGORY_SYSTEM;
                }
                if (DEBUG) {
                    Log.d("GetAppInfoSyncAction", "showBy: " + str);
                }
                jSONObject.put("showBy", str);
            }
            if (DEBUG && jSONObject != null) {
                Log.d("GetAppInfoSyncAction", "data: " + jSONObject.toString());
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            return true;
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("GetAppInfoSyncAction", Log.getStackTraceString(e));
            }
            com.baidu.swan.apps.console.c.e("appInfo", Log.getStackTraceString(e));
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }
}
