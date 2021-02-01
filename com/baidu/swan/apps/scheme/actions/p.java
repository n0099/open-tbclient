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
/* loaded from: classes9.dex */
public class p extends aa implements com.baidu.swan.apps.network.f {
    int RESULT_CODE_SUCCESS;
    int dGC;

    /* loaded from: classes9.dex */
    public interface a {
    }

    public p(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/file/openDocument");
        this.RESULT_CODE_SUCCESS = 1;
        this.dGC = 3;
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        } else if (eVar.ajP()) {
            if (DEBUG) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject b2 = b(unitedSchemeEntity, "params");
            if (b2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                return false;
            }
            String optString = b2.optString("filePath");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal filePath");
                return false;
            }
            String aIM = com.baidu.swan.apps.runtime.e.aIM();
            if (TextUtils.isEmpty(aIM)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
                return false;
            }
            String cx = com.baidu.swan.apps.storage.b.cx(optString, aIM);
            if (TextUtils.isEmpty(cx)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal realFilePath");
                return false;
            }
            String optString2 = b2.optString("fileType");
            String yP = com.baidu.swan.c.d.yP(cx);
            if (!TextUtils.isEmpty(yP)) {
                optString2 = yP;
            } else if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal file ext");
                return false;
            }
            String guessSupportMimeTypeFromExt = com.baidu.swan.apps.ao.m.guessSupportMimeTypeFromExt(optString2);
            if (TextUtils.isEmpty(guessSupportMimeTypeFromExt)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal file mimeType");
                return false;
            }
            Uri parse = Uri.parse(cx);
            if (parse == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal Uri path");
                return false;
            }
            if (parse.getScheme() == null) {
                parse = Uri.fromFile(new File(cx));
            }
            SwanAppActivity aIE = eVar.aIE();
            if (aIE == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal activity == null");
                return false;
            } else if (!com.baidu.swan.apps.ao.m.getSupportMimeType(guessSupportMimeTypeFromExt)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support this mimeType=" + guessSupportMimeTypeFromExt);
                return false;
            } else {
                String optString3 = b2.optString("cb");
                com.baidu.swan.apps.adaptation.a.u axn = com.baidu.swan.apps.t.a.axn();
                if (!axn.X(aIE, guessSupportMimeTypeFromExt)) {
                    if (TextUtils.isEmpty(optString3)) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not found plugin,mimeType=" + guessSupportMimeTypeFromExt);
                        return false;
                    }
                    a(aIE, guessSupportMimeTypeFromExt, parse, optString3, callbackHandler);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                axn.a(aIE, parse, guessSupportMimeTypeFromExt);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                callbackHandler.handleSchemeDispatchCallback(optString3, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                return true;
            }
        }
    }

    private void a(final Activity activity, final String str, final Uri uri, final String str2, final CallbackHandler callbackHandler) {
        com.baidu.swan.apps.t.a.axn().a(activity, str, new a() { // from class: com.baidu.swan.apps.scheme.actions.p.1
        });
    }
}
