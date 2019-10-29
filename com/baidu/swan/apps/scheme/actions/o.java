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
public class o extends z implements com.baidu.swan.apps.network.f {
    public o(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/file/openDocument");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
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
        String Rk = com.baidu.swan.apps.ae.b.Rk();
        if (TextUtils.isEmpty(Rk)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        String aL = com.baidu.swan.apps.storage.b.aL(optString, Rk);
        if (TextUtils.isEmpty(aL)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal realFilePath");
            return false;
        }
        String optString2 = c.optString("fileType");
        String lM = com.baidu.swan.c.a.lM(aL);
        if (!TextUtils.isEmpty(lM)) {
            optString2 = lM;
        } else if (TextUtils.isEmpty(optString2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal file ext");
            return false;
        }
        String iO = com.baidu.swan.apps.an.h.iO(optString2);
        if (TextUtils.isEmpty(iO)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal file mimeType");
            return false;
        }
        Uri parse = Uri.parse(aL);
        if (parse == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal Uri path");
            return false;
        }
        if (parse.getScheme() == null) {
            parse = Uri.fromFile(new File(aL));
        }
        Activity activity = bVar.getActivity();
        if (activity == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal activity == null");
            return false;
        } else if (!com.baidu.swan.apps.an.h.iN(iO)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support this mimeType=" + iO);
            return false;
        } else if (!com.baidu.swan.apps.u.a.JA().a(activity, parse, iO)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not found plugin,mimeType=" + iO);
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
