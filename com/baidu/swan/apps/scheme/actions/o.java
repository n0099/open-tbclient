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
        String Mo = com.baidu.swan.apps.ae.b.Mo();
        if (TextUtils.isEmpty(Mo)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        String aE = com.baidu.swan.apps.storage.b.aE(optString, Mo);
        if (TextUtils.isEmpty(aE)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal realFilePath");
            return false;
        }
        String optString2 = c.optString("fileType");
        String lh = com.baidu.swan.c.a.lh(aE);
        if (!TextUtils.isEmpty(lh)) {
            optString2 = lh;
        } else if (TextUtils.isEmpty(optString2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal file ext");
            return false;
        }
        String ij = com.baidu.swan.apps.an.h.ij(optString2);
        if (TextUtils.isEmpty(ij)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal file mimeType");
            return false;
        }
        Uri parse = Uri.parse(aE);
        if (parse == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal Uri path");
            return false;
        }
        if (parse.getScheme() == null) {
            parse = Uri.fromFile(new File(aE));
        }
        Activity activity = bVar.getActivity();
        if (activity == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal activity == null");
            return false;
        } else if (!com.baidu.swan.apps.an.h.ii(ij)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support this mimeType=" + ij);
            return false;
        } else if (!com.baidu.swan.apps.u.a.EC().a(activity, parse, ij)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not found plugin,mimeType=" + ij);
            return false;
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
