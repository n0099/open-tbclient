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
        com.baidu.swan.apps.v.b.b AK = bVar.AK();
        if (AK == null || !AK.isValid()) {
            com.baidu.swan.apps.console.c.e("appInfo", "launch info is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", AK.getAppId());
            jSONObject.put("appname", AK.Hu());
            if (!TextUtils.isEmpty(AK.getIconUrl())) {
                jSONObject.put("iconUrl", AK.getIconUrl());
            }
            if (!TextUtils.isEmpty(AK.KG())) {
                jSONObject.put("appLaunchScheme", AK.KG());
            }
            if (AK.KV() != null) {
                String str = AK.KV().description;
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("appDesc", str);
                }
            }
            String bf = com.baidu.swan.apps.u.a.Jo().bf(context);
            jSONObject.put("cuid", bf);
            jSONObject.put("mtjCuid", bf);
            jSONObject.put("clkid", AK.KK());
            jSONObject.put(FaceBaseDTO.KEY_BUSINESS_SCENE, AK.KF());
            jSONObject.put("appId", AK.getAppId());
            Bundle KJ = AK.KJ();
            if (KJ != null) {
                String string = KJ.getString("extraData");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("extraData", new JSONObject(string));
                }
                if (!TextUtils.isEmpty(KJ.getString("srcAppId"))) {
                    jSONObject.put("srcAppId", KJ.getString("srcAppId"));
                }
                if (!TextUtils.isEmpty(KJ.getString("srcAppPage"))) {
                    jSONObject.put("srcAppPage", KJ.getString("srcAppPage"));
                }
                String str2 = "sys";
                SwanAppActivity Lq = com.baidu.swan.apps.w.e.LE().Lq();
                if (Lq != null) {
                    str2 = Lq.AH();
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
