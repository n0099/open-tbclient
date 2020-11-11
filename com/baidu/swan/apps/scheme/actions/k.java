package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.storage.PathType;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class k extends aa {
    public k(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/getLocalImgData");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("GetLocalImgDataAction", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("SwanAppAction", "illegal params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = optParamsAsJo.optString("filePath");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("GetLocalImgDataAction", "GetLocalImgDataAction bdfile path null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (com.baidu.swan.apps.storage.b.tx(optString) != PathType.BD_FILE) {
            com.baidu.swan.apps.console.c.e("GetLocalImgDataAction", "invalid path : " + optString);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(null, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND, com.baidu.swan.apps.scheme.f.getErrMessage(UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND));
            return false;
        } else {
            String cz = com.baidu.swan.apps.storage.b.cz(optString, eVar.id);
            if (TextUtils.isEmpty(cz)) {
                com.baidu.swan.apps.console.c.e("GetLocalImgDataAction", "GetLocalImgDataAction realPath null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("filePath", cz);
                com.baidu.swan.apps.console.c.i("GetLocalImgDataAction", "getLocalImgData success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            } catch (JSONException e) {
                com.baidu.swan.apps.console.c.e("GetLocalImgDataAction", "getLocalImgData failed");
                if (DEBUG) {
                    e.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
    }
}
