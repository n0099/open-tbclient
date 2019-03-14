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
/* loaded from: classes2.dex */
public class j extends y {
    public j(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/getLocalImgData");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (!com.baidu.swan.apps.u.a.CB().vb()) {
            com.baidu.swan.apps.console.c.e("GetLocalImgDataAction", "GetLocalImgData is refused");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(null, UIMsg.m_AppUI.MSG_APP_VERSION_NAV_MODULE, com.baidu.swan.apps.scheme.f.getErrMessage(UIMsg.m_AppUI.MSG_APP_VERSION_NAV_MODULE));
            return false;
        } else if (bVar == null) {
            com.baidu.swan.apps.console.c.e("GetLocalImgDataAction", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        } else {
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
            } else if (com.baidu.swan.apps.storage.b.gY(optString) != PathType.BD_FILE) {
                com.baidu.swan.apps.console.c.e("GetLocalImgDataAction", "invalid path : " + optString);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(null, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND, com.baidu.swan.apps.scheme.f.getErrMessage(UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND));
                return false;
            } else {
                String aC = com.baidu.swan.apps.storage.b.aC(optString, bVar.id);
                if (TextUtils.isEmpty(aC)) {
                    com.baidu.swan.apps.console.c.e("GetLocalImgDataAction", "GetLocalImgDataAction realPath null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("filePath", aC);
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
}
