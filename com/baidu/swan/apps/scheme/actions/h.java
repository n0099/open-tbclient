package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.os.Bundle;
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
        com.baidu.swan.apps.v.b.b vL = bVar.vL();
        if (vL == null || !vL.isValid()) {
            com.baidu.swan.apps.console.c.e("appInfo", "launch info is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", vL.getAppId());
            jSONObject.put("appname", vL.Cv());
            if (!TextUtils.isEmpty(vL.getIconUrl())) {
                jSONObject.put("iconUrl", vL.getIconUrl());
            }
            if (!TextUtils.isEmpty(vL.FH())) {
                jSONObject.put("appLaunchScheme", vL.FH());
            }
            if (vL.FW() != null) {
                String str = vL.FW().description;
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("appDesc", str);
                }
            }
            String bd = com.baidu.swan.apps.u.a.Ep().bd(context);
            jSONObject.put("cuid", bd);
            jSONObject.put("mtjCuid", bd);
            jSONObject.put("clkid", vL.FL());
            jSONObject.put(FaceBaseDTO.KEY_BUSINESS_SCENE, vL.FG());
            jSONObject.put("appId", vL.getAppId());
            Bundle FK = vL.FK();
            if (FK != null) {
                String string = FK.getString("extraData");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("extraData", new JSONObject(string));
                }
                if (!TextUtils.isEmpty(FK.getString("srcAppId"))) {
                    jSONObject.put("srcAppId", FK.getString("srcAppId"));
                }
                if (!TextUtils.isEmpty(FK.getString("srcAppPage"))) {
                    jSONObject.put("srcAppPage", FK.getString("srcAppPage"));
                }
                String str2 = "sys";
                SwanAppActivity Gr = com.baidu.swan.apps.w.e.GF().Gr();
                if (Gr != null) {
                    str2 = Gr.vI();
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
