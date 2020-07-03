package com.baidu.swan.apps.scheme.actions.m;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.adaptation.b.f;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e extends aa {
    private f caX;

    public e(j jVar) {
        super(jVar, "/swanAPI/webviewPostMessage");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("WebViewPostMsgAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        com.baidu.swan.apps.console.c.i("webviewPostMsg", "start post webview msg");
        if (this.caX == null) {
            com.baidu.swan.apps.console.c.e("webviewPostMsg", "none webview widget");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none webview widget");
            return false;
        }
        d Ur = this.caX.Ur();
        if (Ur == null) {
            com.baidu.swan.apps.console.c.e("webviewPostMsg", "none WWWParams");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none WWWParams");
            return false;
        }
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            com.baidu.swan.apps.console.c.e("webviewPostMsg", "none params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
            return false;
        } else if (!b.has("data")) {
            com.baidu.swan.apps.console.c.e("webviewPostMsg", "none param data");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none param data");
            return false;
        } else {
            String optString = b.optString("data");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", optString);
                jSONObject.put("eventType", "message");
                jSONObject.put("wvID", Ur.bUu);
                jSONObject.put("webviewId", Ur.bUt);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.apps.console.c.e("webviewPostMsg", "meet json exception");
            }
            com.baidu.swan.apps.view.b.b.a.b(Ur.bUu, Ur.bUt, "webview", "message", jSONObject);
            com.baidu.swan.apps.console.c.i("webviewPostMsg", "post webview msg success");
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public void c(f fVar) {
        this.caX = fVar;
    }
}
