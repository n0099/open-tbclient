package com.baidu.swan.apps.storage.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.y;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends y {
    public h(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/file/removeSavedFile");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (context == null || callbackHandler == null || bVar == null || bVar.IY() == null) {
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
        String aC = com.baidu.swan.apps.storage.b.aC(optParamsAsJo.optString("filePath"), com.baidu.swan.apps.ae.b.Jg());
        if (DEBUG) {
            Log.d("SaveFileAction", "——> handle: fileUrl " + optParamsAsJo.optString("filePath"));
            Log.d("SaveFileAction", "——> handle: filePath " + aC);
        }
        if (DEBUG) {
            Log.d("RemoveSavedFileAction", "——> handle: filePath " + aC);
        }
        if (TextUtils.isEmpty(aC)) {
            com.baidu.swan.apps.console.c.e("removeSavedFile", "file path is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        int hb = bVar.IY().hb(aC);
        if (DEBUG) {
            Log.d("RemoveSavedFileAction", "——> handle: statusCode " + hb);
        }
        if (hb > 2000) {
            com.baidu.swan.apps.console.c.e("removeSavedFile", "file path status code : " + hb);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(hb, com.baidu.swan.apps.scheme.f.getErrMessage(hb)));
            return false;
        } else if (com.baidu.swan.c.b.deleteFile(aC)) {
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
