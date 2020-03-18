package com.baidu.swan.apps.storage.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.ab;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends ab {
    public d(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/file/getSavedFileInfo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (context == null || callbackHandler == null || eVar == null || eVar.acQ() == null) {
            com.baidu.swan.apps.console.c.e("getSavedFile", "execute fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("getSavedFile", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String bo = com.baidu.swan.apps.storage.b.bo(optParamsAsJo.optString("filePath"), com.baidu.swan.apps.runtime.e.acK());
        if (DEBUG) {
            Log.d("GetSavedFileInfoAction", "——> handle: fileUrl " + optParamsAsJo.optString("filePath"));
            Log.d("GetSavedFileInfoAction", "——> handle: filePath " + bo);
        }
        if (TextUtils.isEmpty(bo)) {
            com.baidu.swan.apps.console.c.e("getSavedFile", "file path is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        com.baidu.swan.apps.storage.a md = eVar.acQ().md(bo);
        if (md == null) {
            com.baidu.swan.apps.console.c.e("getSavedFile", "file info is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2001, com.baidu.swan.apps.scheme.f.getErrMessage(2001)));
            if (DEBUG) {
                Log.d("GetSavedFileInfoAction", "——> handle: file not exist");
                return false;
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("createTime", Math.round((float) (md.afi() / 1000)));
            jSONObject.put(TiebaInitialize.LogFields.SIZE, md.getSize());
            if (DEBUG) {
                Log.d("GetSavedFileInfoAction", "——> handle: fileInfo (" + jSONObject.get("createTime") + " , " + jSONObject.get(TiebaInitialize.LogFields.SIZE) + ")");
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.w("getSavedFile", "file info to json fail");
            e.printStackTrace();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, com.baidu.swan.apps.scheme.f.getErrMessage(2003)));
            if (DEBUG) {
                Log.d("GetSavedFileInfoAction", "——> handle: jsonException ");
                return false;
            }
            return false;
        }
    }
}
