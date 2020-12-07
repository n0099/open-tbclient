package com.baidu.swan.apps.scheme.actions;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class p extends aa implements com.baidu.swan.apps.network.f {
    int RESULT_CODE_SUCCESS;
    int dAF;

    /* loaded from: classes25.dex */
    public interface a {
    }

    public p(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/file/openDocument");
        this.RESULT_CODE_SUCCESS = 1;
        this.dAF = 3;
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        } else if (eVar.ama()) {
            if (DEBUG) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject b = b(unitedSchemeEntity, "params");
            if (b == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                return false;
            }
            String optString = b.optString("filePath");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal filePath");
                return false;
            }
            String aJW = com.baidu.swan.apps.runtime.e.aJW();
            if (TextUtils.isEmpty(aJW)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
                return false;
            }
            String cF = com.baidu.swan.apps.storage.b.cF(optString, aJW);
            if (TextUtils.isEmpty(cF)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal realFilePath");
                return false;
            }
            String optString2 = b.optString("fileType");
            String zJ = com.baidu.swan.c.d.zJ(cF);
            if (!TextUtils.isEmpty(zJ)) {
                optString2 = zJ;
            } else if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal file ext");
                return false;
            }
            String guessSupportMimeTypeFromExt = com.baidu.swan.apps.ap.m.guessSupportMimeTypeFromExt(optString2);
            if (TextUtils.isEmpty(guessSupportMimeTypeFromExt)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal file mimeType");
                return false;
            }
            Uri parse = Uri.parse(cF);
            if (parse == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal Uri path");
                return false;
            }
            if (parse.getScheme() == null) {
                parse = Uri.fromFile(new File(cF));
            }
            SwanAppActivity aJO = eVar.aJO();
            if (aJO == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal activity == null");
                return false;
            } else if (!com.baidu.swan.apps.ap.m.getSupportMimeType(guessSupportMimeTypeFromExt)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support this mimeType=" + guessSupportMimeTypeFromExt);
                return false;
            } else {
                String optString3 = b.optString("cb");
                com.baidu.swan.apps.adaptation.a.u azr = com.baidu.swan.apps.t.a.azr();
                if (!azr.T(aJO, guessSupportMimeTypeFromExt)) {
                    if (TextUtils.isEmpty(optString3)) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not found plugin,mimeType=" + guessSupportMimeTypeFromExt);
                        return false;
                    }
                    a(aJO, guessSupportMimeTypeFromExt, parse, optString3, callbackHandler);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                azr.a(aJO, parse, guessSupportMimeTypeFromExt);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                return true;
            }
        }
    }

    private void a(final Activity activity, final String str, final Uri uri, final String str2, final CallbackHandler callbackHandler) {
        com.baidu.swan.apps.t.a.azr().a(activity, str, new a() { // from class: com.baidu.swan.apps.scheme.actions.p.1
        });
    }
}
