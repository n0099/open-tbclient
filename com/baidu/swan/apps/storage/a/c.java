package com.baidu.swan.apps.storage.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends y {
    public c(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/file/getInfo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (context == null || callbackHandler == null || bVar == null || bVar.IY() == null) {
            com.baidu.swan.apps.console.c.e("fileInfo", "execute fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("fileInfo", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = optParamsAsJo.optString("filePath");
        String str = "";
        if (com.baidu.swan.apps.storage.b.gZ(optString) == PathType.BD_FILE) {
            str = com.baidu.swan.apps.storage.b.aC(optString, com.baidu.swan.apps.ae.b.Jg());
        } else if (com.baidu.swan.apps.storage.b.gZ(optString) == PathType.RELATIVE) {
            str = com.baidu.swan.apps.storage.b.a(optString, bVar, bVar.getVersion());
        }
        if (DEBUG) {
            Log.d("GetFileInfoAction", "——> handle: fileUrl " + optString);
            Log.d("GetFileInfoAction", "——> handle: filePath " + str);
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.console.c.e("fileInfo", "absolute filePath is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        File file = new File(str);
        String a = com.baidu.swan.apps.an.i.a(TextUtils.equals(optParamsAsJo.optString("digestAlgorithm", "md5"), "md5") ? "MD5" : "SHA-1", file, false);
        if (TextUtils.isEmpty(a)) {
            com.baidu.swan.apps.console.c.e("fileInfo", "hash is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2001, com.baidu.swan.apps.scheme.f.getErrMessage(2001)));
            if (DEBUG) {
                Log.d("GetFileInfoAction", "——> handle: file not exist");
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("digest", a);
            jSONObject.put("size", file.length());
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, com.baidu.swan.apps.scheme.f.getErrMessage(2003)));
            if (DEBUG) {
                Log.d("GetFileInfoAction", "——> handle: jsonException ");
            }
            return false;
        }
    }
}
