package com.baidu.swan.apps.textarea.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.component.components.textarea.a;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.w.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends aa {
    public b(j jVar) {
        super(jVar, "/swanAPI/openTextarea");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            Log.d("OpenTextAreaAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.swan.apps.console.c.d("OpenTextAreaAction", "OpenTextAreaAction paramsJson: " + optParamsAsJo);
        com.baidu.swan.apps.component.components.textarea.b bVar = new com.baidu.swan.apps.component.components.textarea.b();
        try {
            bVar.parseFromJson(optParamsAsJo);
        } catch (JSONException e) {
            e.printStackTrace();
            com.baidu.swan.apps.console.c.e("OpenTextAreaAction", "model parse exception:", e);
        }
        SwanAppActivity aiL = f.ajb().aiL();
        if (aiL == null) {
            com.baidu.swan.apps.console.c.e("OpenTextAreaAction", "activity is null when add textarea");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "activity is null when add textarea");
            return false;
        }
        com.baidu.swan.apps.core.d.e RN = f.ajb().RN();
        if (RN == null) {
            com.baidu.swan.apps.console.c.e("OpenTextAreaAction", "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragmentManager is null");
            return false;
        }
        d ZW = RN.ZW();
        if (ZW == null) {
            com.baidu.swan.apps.console.c.e("OpenTextAreaAction", "fragment is null when add input");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment is null when add input");
            return false;
        }
        com.baidu.swan.apps.component.b.c Wm = new com.baidu.swan.apps.component.components.textarea.a(context, bVar, aiL, ZW, new a.InterfaceC0327a() { // from class: com.baidu.swan.apps.textarea.a.b.1
            @Override // com.baidu.swan.apps.component.components.textarea.a.InterfaceC0327a
            public void a(String str, String str2, JSONObject jSONObject) {
                b.this.a(str, str2, callbackHandler, 0, jSONObject);
            }
        }).Wm();
        if (!Wm.isSuccess()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, Wm.msg);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, CallbackHandler callbackHandler, int i, JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("OpenTextAreaAction", "sendAsyncCallback, arg0: " + i + ", arg1: " + jSONObject);
        }
        com.baidu.swan.apps.console.c.d("OpenTextAreaAction", "sendAsyncCallback, arg0: " + i + ", arg1: " + jSONObject);
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.aU("OpenTextAreaAction", "sendAsyncCallback with a empty callback");
        } else {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }
}
