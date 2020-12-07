package com.baidu.swan.apps.scheme.actions.m;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class f extends aa {
    private com.baidu.swan.apps.adaptation.b.f cQs;

    public f(j jVar) {
        super(jVar, "/swanAPI/webviewPostMessage");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("WebViewPostMsgAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        com.baidu.swan.apps.console.c.i("webviewPostMsg", "start post webview msg");
        if (this.cQs == null) {
            com.baidu.swan.apps.console.c.e("webviewPostMsg", "none webview widget");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none webview widget");
            return false;
        }
        d aln = this.cQs.aln();
        if (aln == null) {
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
                jSONObject.put("wvID", aln.cIW);
                jSONObject.put("webviewId", aln.cIV);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.apps.console.c.e("webviewPostMsg", "meet json exception");
            }
            com.baidu.swan.apps.view.b.b.a.d(aln.cIW, aln.cIV, "webview", "message", jSONObject);
            com.baidu.swan.apps.console.c.i("webviewPostMsg", "post webview msg success");
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public void c(com.baidu.swan.apps.adaptation.b.f fVar) {
        this.cQs = fVar;
    }
}
