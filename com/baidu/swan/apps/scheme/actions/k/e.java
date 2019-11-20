package com.baidu.swan.apps.scheme.actions.k;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.b.c.f;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends z {
    private f aLk;

    public e(j jVar) {
        super(jVar, "/swan/webviewPostMessage");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            Log.d("WebViewPostMsgAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        com.baidu.swan.apps.console.c.i("webviewPostMsg", "start post webview msg");
        if (this.aLk == null) {
            com.baidu.swan.apps.console.c.e("webviewPostMsg", "none webview widget");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none webview widget");
            return false;
        }
        d Cv = this.aLk.Cv();
        if (Cv == null) {
            com.baidu.swan.apps.console.c.e("webviewPostMsg", "none WWWParams");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none WWWParams");
            return false;
        }
        JSONObject c = c(unitedSchemeEntity, "params");
        if (c == null) {
            com.baidu.swan.apps.console.c.e("webviewPostMsg", "none params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
            return false;
        } else if (!c.has("data")) {
            com.baidu.swan.apps.console.c.e("webviewPostMsg", "none param data");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none param data");
            return false;
        } else {
            String optString = c.optString("data");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", optString);
                jSONObject.put("eventType", "message");
                jSONObject.put("wvID", Cv.aXp);
                jSONObject.put("webviewId", Cv.id);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.apps.console.c.e("webviewPostMsg", "meet json exception");
            }
            com.baidu.swan.apps.view.container.c.d.b(Cv.aXp, Cv.id, "webview", "message", jSONObject);
            com.baidu.swan.apps.console.c.i("webviewPostMsg", "post webview msg success");
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public void c(f fVar) {
        this.aLk = fVar;
    }
}
