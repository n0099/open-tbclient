package com.baidu.swan.apps.textarea.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.component.components.textarea.a;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.v.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
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
        com.baidu.swan.apps.console.c.i("OpenTextAreaAction", "OpenTextAreaAction paramsJson: " + optParamsAsJo);
        com.baidu.swan.apps.component.components.textarea.b bVar = new com.baidu.swan.apps.component.components.textarea.b();
        try {
            bVar.parseFromJson(optParamsAsJo);
        } catch (JSONException e) {
            e.printStackTrace();
            com.baidu.swan.apps.console.c.e("OpenTextAreaAction", "model parse exception:", e);
        }
        SwanAppActivity arI = f.arY().arI();
        if (arI == null) {
            com.baidu.swan.apps.console.c.e("OpenTextAreaAction", "activity is null when add textarea");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "activity is null when add textarea");
            return false;
        }
        com.baidu.swan.apps.core.d.f XX = f.arY().XX();
        if (XX == null) {
            com.baidu.swan.apps.console.c.e("OpenTextAreaAction", "fragmentManager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragmentManager is null");
            return false;
        }
        com.baidu.swan.apps.core.d.e ahn = XX.ahn();
        if (ahn == null) {
            com.baidu.swan.apps.console.c.e("OpenTextAreaAction", "fragment is null when add input");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment is null when add input");
            return false;
        }
        com.baidu.swan.apps.component.b.c acZ = new com.baidu.swan.apps.component.components.textarea.a(context, bVar, arI, ahn, new a.InterfaceC0371a() { // from class: com.baidu.swan.apps.textarea.a.b.1
            @Override // com.baidu.swan.apps.component.components.textarea.a.InterfaceC0371a
            public void a(String str, String str2, JSONObject jSONObject) {
                b.this.a(str, str2, callbackHandler, 0, jSONObject);
            }
        }).acZ();
        if (!acZ.isSuccess()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, acZ.msg);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, CallbackHandler callbackHandler, int i, JSONObject jSONObject) {
        com.baidu.swan.apps.console.c.i("OpenTextAreaAction", "sendAsyncCallback, arg0: " + i + ", arg1: " + jSONObject);
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.component.e.a.ba("OpenTextAreaAction", "sendAsyncCallback with a empty callback");
        } else {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }
}
