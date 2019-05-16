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
public class h extends z {
    public h(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/getAppInfoSync");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("GetAppInfoSyncAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (bVar == null) {
            com.baidu.swan.apps.console.c.e("appInfo", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.v.b.b vk = bVar.vk();
        if (vk == null || !vk.isValid()) {
            com.baidu.swan.apps.console.c.e("appInfo", "launch info is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", vk.getAppId());
            jSONObject.put("appname", vk.BM());
            if (!TextUtils.isEmpty(vk.getIconUrl())) {
                jSONObject.put("iconUrl", vk.getIconUrl());
            }
            if (!TextUtils.isEmpty(vk.EX())) {
                jSONObject.put("appLaunchScheme", vk.EX());
            }
            if (vk.Fm() != null) {
                String str = vk.Fm().description;
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("appDesc", str);
                }
            }
            String bd = com.baidu.swan.apps.u.a.DG().bd(context);
            jSONObject.put("cuid", bd);
            jSONObject.put("mtjCuid", bd);
            jSONObject.put("clkid", vk.Fb());
            jSONObject.put(FaceBaseDTO.KEY_BUSINESS_SCENE, vk.EW());
            jSONObject.put("appId", vk.getAppId());
            Bundle Fa = vk.Fa();
            if (Fa != null) {
                String string = Fa.getString("extraData");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("extraData", new JSONObject(string));
                }
                if (!TextUtils.isEmpty(Fa.getString("srcAppId"))) {
                    jSONObject.put("srcAppId", Fa.getString("srcAppId"));
                }
                if (!TextUtils.isEmpty(Fa.getString("srcAppPage"))) {
                    jSONObject.put("srcAppPage", Fa.getString("srcAppPage"));
                }
                String str2 = NotificationCompat.CATEGORY_SYSTEM;
                SwanAppActivity FH = com.baidu.swan.apps.w.e.FV().FH();
                if (FH != null) {
                    str2 = FH.vh();
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = NotificationCompat.CATEGORY_SYSTEM;
                }
                if (DEBUG) {
                    Log.d("GetAppInfoSyncAction", "showBy: " + str2);
                }
                jSONObject.put("showBy", str2);
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
