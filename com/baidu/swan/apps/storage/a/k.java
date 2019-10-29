package com.baidu.swan.apps.storage.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.z;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k extends z {
    public k(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/file/save");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (context == null || callbackHandler == null || bVar == null || bVar.Rc() == null) {
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
        String aL = com.baidu.swan.apps.storage.b.aL(optParamsAsJo.optString("tempFilePath"), com.baidu.swan.apps.ae.b.Rk());
        if (DEBUG) {
            Log.d("SaveFileAction", "——> handle: tempFileUrl " + optParamsAsJo.optString("tempFilePath"));
            Log.d("SaveFileAction", "——> handle: tempFilePath " + aL);
        }
        if (TextUtils.isEmpty(aL)) {
            com.baidu.swan.apps.console.c.e("saveFile", "temp file path is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        int io = bVar.Rc().io(aL);
        if (DEBUG) {
            Log.d("SaveFileAction", "——> handle: statusCode " + io);
        }
        if (io > 2000) {
            com.baidu.swan.apps.console.c.e("saveFile", "file path status code : " + io);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(io, com.baidu.swan.apps.scheme.f.getErrMessage(io)));
            return false;
        }
        String ip = bVar.Rc().ip(aL);
        if (TextUtils.isEmpty(ip)) {
            com.baidu.swan.apps.console.c.e("saveFile", "save file path is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, com.baidu.swan.apps.scheme.f.getErrMessage(2003)));
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("savedFilePath", com.baidu.swan.apps.storage.b.aN(ip, com.baidu.swan.apps.ae.b.Rk()));
            if (DEBUG) {
                Log.d("SaveFileAction", "——> handle: saveFilePath saveFilePath " + ip + " update saveFilePath " + jSONObject.get("savedFilePath"));
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
