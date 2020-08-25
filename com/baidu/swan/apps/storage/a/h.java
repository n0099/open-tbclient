package com.baidu.swan.apps.storage.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class h extends aa {
    public h(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/file/removeSavedFile");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (context == null || callbackHandler == null || eVar == null || eVar.azT() == null) {
            com.baidu.swan.apps.console.c.e("removeSavedFile", "execute fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("removeSavedFile", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String cn2 = com.baidu.swan.apps.storage.b.cn(optParamsAsJo.optString("filePath"), com.baidu.swan.apps.runtime.e.azK());
        if (DEBUG) {
            Log.d("SaveFileAction", "——> handle: fileUrl " + optParamsAsJo.optString("filePath"));
            Log.d("SaveFileAction", "——> handle: filePath " + cn2);
        }
        if (DEBUG) {
            Log.d("RemoveSavedFileAction", "——> handle: filePath " + cn2);
        }
        if (TextUtils.isEmpty(cn2)) {
            com.baidu.swan.apps.console.c.e("removeSavedFile", "file path is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        int rL = eVar.azT().rL(cn2);
        if (DEBUG) {
            Log.d("RemoveSavedFileAction", "——> handle: statusCode " + rL);
        }
        if (rL > 2000) {
            com.baidu.swan.apps.console.c.e("removeSavedFile", "file path status code : " + rL);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(rL, com.baidu.swan.apps.scheme.f.getErrMessage(rL)));
            return false;
        } else if (com.baidu.swan.c.d.deleteFile(cn2)) {
            com.baidu.swan.apps.console.c.i("removeSavedFile", "file delete success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            if (DEBUG) {
                Log.d("RemoveSavedFileAction", "——> handle:  delete OK ");
            }
            return true;
        } else {
            com.baidu.swan.apps.console.c.e("removeSavedFile", "file delete fail");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2004, com.baidu.swan.apps.scheme.f.getErrMessage(2004)));
            if (DEBUG) {
                Log.d("RemoveSavedFileAction", "——> handle:  delete fail ");
                return false;
            }
            return false;
        }
    }
}
