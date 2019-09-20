package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
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
        com.baidu.swan.apps.v.b.b vP = bVar.vP();
        if (vP == null || !vP.isValid()) {
            com.baidu.swan.apps.console.c.e("appInfo", "launch info is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", vP.getAppId());
            jSONObject.put("appname", vP.Cz());
            if (!TextUtils.isEmpty(vP.getIconUrl())) {
                jSONObject.put("iconUrl", vP.getIconUrl());
            }
            if (!TextUtils.isEmpty(vP.FL())) {
                jSONObject.put("appLaunchScheme", vP.FL());
            }
            if (vP.Ga() != null) {
                String str = vP.Ga().description;
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("appDesc", str);
                }
            }
            String bd = com.baidu.swan.apps.u.a.Et().bd(context);
            jSONObject.put(DpStatConstants.KEY_CUID, bd);
            jSONObject.put("mtjCuid", bd);
            jSONObject.put("clkid", vP.FP());
            jSONObject.put(FaceBaseDTO.KEY_BUSINESS_SCENE, vP.FK());
            jSONObject.put("appId", vP.getAppId());
            Bundle FO = vP.FO();
            if (FO != null) {
                String string = FO.getString("extraData");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("extraData", new JSONObject(string));
                }
                if (!TextUtils.isEmpty(FO.getString("srcAppId"))) {
                    jSONObject.put("srcAppId", FO.getString("srcAppId"));
                }
                if (!TextUtils.isEmpty(FO.getString("srcAppPage"))) {
                    jSONObject.put("srcAppPage", FO.getString("srcAppPage"));
                }
                String str2 = "sys";
                SwanAppActivity Gv = com.baidu.swan.apps.w.e.GJ().Gv();
                if (Gv != null) {
                    str2 = Gv.vM();
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "sys";
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
