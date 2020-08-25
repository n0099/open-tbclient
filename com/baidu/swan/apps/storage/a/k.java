package com.baidu.swan.apps.storage.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class k extends aa {
    public k(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/file/save");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (context == null || callbackHandler == null || eVar == null || eVar.azT() == null) {
            com.baidu.swan.apps.console.c.e("saveFile", "execute fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("saveFile", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String cn2 = com.baidu.swan.apps.storage.b.cn(optParamsAsJo.optString("tempFilePath"), eVar.getAppId());
        if (DEBUG) {
            Log.d("SaveFileAction", "——> handle: tempFileUrl " + optParamsAsJo.optString("tempFilePath"));
            Log.d("SaveFileAction", "——> handle: tempFilePath " + cn2);
        }
        if (TextUtils.isEmpty(cn2)) {
            com.baidu.swan.apps.console.c.e("saveFile", "temp file path is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        int rL = eVar.azT().rL(cn2);
        if (DEBUG) {
            Log.d("SaveFileAction", "——> handle: statusCode " + rL);
        }
        if (rL > 2000) {
            com.baidu.swan.apps.console.c.e("saveFile", "file path status code : " + rL);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(rL, com.baidu.swan.apps.scheme.f.getErrMessage(rL)));
            return false;
        }
        String rM = eVar.azT().rM(cn2);
        if (TextUtils.isEmpty(rM)) {
            com.baidu.swan.apps.console.c.e("saveFile", "save file path is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, com.baidu.swan.apps.scheme.f.getErrMessage(2003)));
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("savedFilePath", com.baidu.swan.apps.storage.b.cq(rM, com.baidu.swan.apps.runtime.e.azK()));
            if (DEBUG) {
                Log.d("SaveFileAction", "——> handle: saveFilePath saveFilePath " + rM + " update saveFilePath " + jSONObject.get("savedFilePath"));
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.w("saveFile", "save file path to scheme fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }
}
