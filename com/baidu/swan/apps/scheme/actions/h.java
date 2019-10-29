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
        com.baidu.swan.apps.v.b.b AJ = bVar.AJ();
        if (AJ == null || !AJ.isValid()) {
            com.baidu.swan.apps.console.c.e("appInfo", "launch info is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", AJ.getAppId());
            jSONObject.put("appname", AJ.Ht());
            if (!TextUtils.isEmpty(AJ.getIconUrl())) {
                jSONObject.put("iconUrl", AJ.getIconUrl());
            }
            if (!TextUtils.isEmpty(AJ.KF())) {
                jSONObject.put("appLaunchScheme", AJ.KF());
            }
            if (AJ.KU() != null) {
                String str = AJ.KU().description;
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("appDesc", str);
                }
            }
            String bf = com.baidu.swan.apps.u.a.Jn().bf(context);
            jSONObject.put("cuid", bf);
            jSONObject.put("mtjCuid", bf);
            jSONObject.put("clkid", AJ.KJ());
            jSONObject.put(FaceBaseDTO.KEY_BUSINESS_SCENE, AJ.KE());
            jSONObject.put("appId", AJ.getAppId());
            Bundle KI = AJ.KI();
            if (KI != null) {
                String string = KI.getString("extraData");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("extraData", new JSONObject(string));
                }
                if (!TextUtils.isEmpty(KI.getString("srcAppId"))) {
                    jSONObject.put("srcAppId", KI.getString("srcAppId"));
                }
                if (!TextUtils.isEmpty(KI.getString("srcAppPage"))) {
                    jSONObject.put("srcAppPage", KI.getString("srcAppPage"));
                }
                String str2 = "sys";
                SwanAppActivity Lp = com.baidu.swan.apps.w.e.LD().Lp();
                if (Lp != null) {
                    str2 = Lp.AG();
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
