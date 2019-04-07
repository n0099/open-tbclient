package com.baidu.swan.apps.scheme.actions;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class o extends y implements com.baidu.swan.apps.network.f {
    public o(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/file/openDocument");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject c = c(unitedSchemeEntity, "params");
        if (c == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        }
        String optString = c.optString("filePath");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal filePath");
            return false;
        }
        String Jg = com.baidu.swan.apps.ae.b.Jg();
        if (TextUtils.isEmpty(Jg)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        String aC = com.baidu.swan.apps.storage.b.aC(optString, Jg);
        if (TextUtils.isEmpty(aC)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal realFilePath");
            return false;
        }
        String optString2 = c.optString("fileType");
        String ka = com.baidu.swan.c.b.ka(aC);
        if (!TextUtils.isEmpty(ka)) {
            optString2 = ka;
        } else if (TextUtils.isEmpty(optString2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal file ext");
            return false;
        }
        String hA = com.baidu.swan.apps.an.h.hA(optString2);
        if (TextUtils.isEmpty(hA)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal file mimeType");
            return false;
        }
        Uri parse = Uri.parse(aC);
        if (parse == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal Uri path");
            return false;
        }
        if (parse.getScheme() == null) {
            parse = Uri.fromFile(new File(aC));
        }
        Activity activity = bVar.getActivity();
        if (activity == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal activity == null");
            return false;
        } else if (!com.baidu.swan.apps.an.h.hz(hA)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support this mimeType=" + hA);
            return false;
        } else if (!com.baidu.swan.apps.u.a.CO().a(activity, parse, hA)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not found plugin,mimeType=" + hA);
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
